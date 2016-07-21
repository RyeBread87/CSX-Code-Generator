// The following methods type check   AST nodes used in CSX Lite
//  You will need to complete the methods after line 242 to type check the
//   rest of CSX
//  Note that the type checking done for CSX lite may need to be extended to
//   handle full CSX (for example binaryOpNode).

public class TypeChecking extends Visitor { 

//	static int typeErrors =  0;     // Total number of type errors found 
//  	public static SymbolTable st = new SymbolTable(); 	
	int typeErrors;     // Total number of type errors found 
	SymbolTable st;	
	
	TypeChecking(){
		typeErrors = 0;
		st = new SymbolTable(); 
	}
	
	boolean isTypeCorrect(csxLiteNode n) {
        	this.visit(n);
        	return (typeErrors == 0);
	}
	
	boolean isTypeCorrect(classNode n) {
    	this.visit(n);
    	return (typeErrors == 0);
}
	
	static void assertCondition(boolean assertion){  
		if (! assertion)
			 throw new RuntimeException();
	}
	 void typeMustBe(ASTNode.Types testType,ASTNode.Types requiredType,String errorMsg) {
		 if ((testType != ASTNode.Types.Error) && (testType != requiredType)) {
                        System.out.println(errorMsg);
                        typeErrors++;
                }
        }
	 void typesMustBeEqual(ASTNode.Types type1,ASTNode.Types type2,String errorMsg) {
		 if ((type1 != ASTNode.Types.Error) && (type2 != ASTNode.Types.Error) &&
                     (type1 != type2)) {
                        System.out.println(errorMsg);
                        typeErrors++;
                }
        }
	String error(ASTNode n) {
		return "Error (line " + n.linenum + "): ";
        }

	static String opToString(int op) {
		switch (op) {
			case sym.PLUS:
				return(" + ");
			case sym.MINUS:
				return(" - ");
			case sym.EQ:
				return(" == ");
			case sym.NOTEQ:
				return(" != ");
			default:
				assertCondition(false);
				return "";
		}
	}


// Extend this to handle all CSX binary operators
	static void printOp(int op) {
		switch (op) {
			case sym.PLUS:
				System.out.print(" + ");
				break;
			case sym.MINUS:
				System.out.print(" - ");
				break;
			case sym.EQ:
				System.out.print(" == ");
				break;
			case sym.NOTEQ:
				System.out.print(" != ");
				break;
			default:
				throw new Error();
		}
	}

	
	 void visit(csxLiteNode n){
		this.visit(n.progDecls);
		this.visit(n.progStmts);
	}
	
	void visit(fieldDeclsNode n){
			this.visit(n.thisField);
			this.visit(n.moreFields);
	}
	void visit(nullFieldDeclsNode n){}

	void visit(stmtsNode n){
		  //System.out.println ("In stmtsNode\n");
		  this.visit(n.thisStmt);
		  this.visit(n.moreStmts);

	}
	void visit(nullStmtsNode n){}

// Extend varDeclNode's method to handle initialization
	void visit(varDeclNode n){

		SymbolInfo     id;
 //       	id = (SymbolInfo) st.localLookup(n.varName.idname);
        	id = (SymbolInfo) st.localLookup(n.varName.idname);
        	if (id != null) {
               		 System.out.println(error(n) + id.name()+
                                     " is already declared.");
                	typeErrors++;
                	n.varName.type = ASTNode.Types.Error;

        	} else {
                	id = new SymbolInfo(n.varName.idname,
                                         ASTNode.Kinds.Var, n.varType.type);
                	n.varName.type = n.varType.type;
			try {
                		st.insert(id);
			} catch (DuplicateException d) 
                              { /* can't happen */ }
			  catch (EmptySTException e) 
                              { /* can't happen */ }
                	n.varName.idinfo=id;
        	}

	};
	
	void visit(nullTypeNode n){}
	
	void visit(intTypeNode n){
		//no type checking needed}
	}
	void visit(boolTypeNode n){
		//no type checking needed}
	}
	void visit(identNode n){
		SymbolInfo    id;
        	assertCondition(n.kind == ASTNode.Kinds.Var); //In CSX-lite all IDs should be vars! 
//        	id = (SymbolInfo) st.globalLookup(idname);
        	id =  (SymbolInfo) st.globalLookup(n.idname);
        	if (id == null) {
               	 	System.out.println(error(n) +  n.idname +
                             " is not declared.");
                typeErrors++;
                n.type = ASTNode.Types.Error;
        } else {
                n.type = id.type; 
                n.idinfo = id; // Save ptr to correct symbol table entry
        	}
	}

// Extend nameNode's method to handle subscripts
	void visit(nameNode n){
		this.visit(n.varName); // Subscripts not allowed in CSX Lite
        	n.type=n.varName.type;

	}

	void visit(asgNode n){
	;
		this.visit(n.target);
		this.visit(n.source);
        	assertCondition(n.target.kind == ASTNode.Kinds.Var); //In CSX-lite all IDs should be vars! 

		typesMustBeEqual(n.source.type, n.target.type,
                        error(n) + "Both the left and right"
                          	+ " hand sides of an assignment must "
                            	+ "have the same type.");
	}

// Extend ifThenNode's method to handle else parts
	void visit(ifThenNode n){
		  this.visit(n.condition);
        	  typeMustBe(n.condition.type, ASTNode.Types.Boolean,
                	error(n) + "The control expression of an" +
                          	" if must be a bool.");

		  this.visit(n.thenPart);
		  // No else parts in CSXlite
	}
	  
	 void visit(printNode n){
		this.visit(n.outputValue);
        	typeMustBe(n.outputValue.type, ASTNode.Types.Integer,
                	error(n) + "Only int values may be printed in CSX-lite.");
	  }
	  
	  void visit(blockNode n){
		// open a new local scope for the block body
			st.openScope();
			this.visit(n.decls);
			this.visit(n.stmts);
			// close this block's local scope
			try { st.closeScope();
			}  catch (EmptySTException e) 
	                      { /* can't happen */ }
	  }

	
	  void visit(binaryOpNode n){
		  
		//Only four bin ops in CSX-lite
		assertCondition(n.operatorCode== sym.PLUS||n.operatorCode==sym.MINUS 
        			|| n.operatorCode== sym.EQ||n.operatorCode==sym.NOTEQ);
		this.visit(n.leftOperand);
		this.visit(n.rightOperand);
        	if (n.operatorCode== sym.PLUS||n.operatorCode==sym.MINUS){
        		n.type = ASTNode.Types.Integer;
        		typeMustBe(n.leftOperand.type, ASTNode.Types.Integer,
                	error(n) + "Left operand of" + opToString(n.operatorCode) 
                         	+  "must be an int.");
        		typeMustBe(n.rightOperand.type, ASTNode.Types.Integer,
                	error(n) + "Right operand of" + opToString(n.operatorCode) 
                         	+  "must be an int.");
        	} else { // Must be a comparison operator
        		n.type = ASTNode.Types.Boolean;
        		String errorMsg = error(n)+"Both operands of"+
                           opToString(n.operatorCode)+"must have the same type.";
        		typesMustBeEqual(n.leftOperand.type,n.rightOperand.type,errorMsg);
        		
        	}
	  }

	
	
	void visit(intLitNode n){
	//      All intLits are automatically type-correct
	}


 
// Extend these unparsing methods to correctly unparse CSX AST nodes
	 
	 void visit(classNode n){
		System.out.println("Type checking for classNode not yet implemented");
		}

	 void  visit(memberDeclsNode n){
		System.out.println("Type checking for memberDeclsNode not yet implemented");
	 }
	 
	 void  visit(methodDeclsNode n){
		System.out.println("Type checking for methodDeclsNode not yet implemented");
		 }
	 
	 void visit(nullStmtNode n){}
	 
	 void visit(nullReadNode n){}

	 void visit(nullPrintNode n){}

	 void visit(nullExprNode n){}

	 void visit(nullMethodDeclsNode n){}

	 void visit(methodDeclNode n){
		System.out.println("Type checking for methodDeclNode not yet implemented");
	 }
	 
	 void visit(incrementNode n){
			System.out.println("Type checking for incrementNode not yet implemented");
		 }
	 void visit(decrementNode n){
			System.out.println("Type checking for decrementNode not yet implemented");
		 }
	 
	void visit(argDeclsNode n){
		System.out.println("Type checking for argDeclsNode not yet implemented");
	}

	void visit(nullArgDeclsNode n){}

	
	void visit(valArgDeclNode n){
		System.out.println("Type checking for valArgDeclNode not yet implemented");
	}
	
	void visit(arrayArgDeclNode n){
		System.out.println("Type checking for arrayArgDeclNode not yet implemented");
	}
	
	void visit(constDeclNode n){
		System.out.println("Type checking for constDeclNode not yet implemented");
	 }
	 
	 void visit(arrayDeclNode n){
		System.out.println("Type checking for arrayDeclNode not yet implemented");
	 }
	
	void visit(charTypeNode n){
		System.out.println("Type checking for charTypeNode not yet implemented");
	}
	void visit(voidTypeNode n){
		System.out.println("Type checking for voidTypeNode not yet implemented");
	}

	void visit(whileNode n){
		System.out.println("Type checking for whileNode not yet implemented");
	  }

	void visit(breakNode n){
		System.out.println("Type checking for breakNode not yet implemented");
	}
	void visit(continueNode n){
		System.out.println("Type checking for continueNode not yet implemented");
	}
	  
	void visit(callNode n){
		System.out.println("Type checking for callNode not yet implemented");
	}

	  
	  void visit(readNode n){
		System.out.println("Type checking for readNode not yet implemented");
	  }
	  

	  void visit(returnNode n){
		System.out.println("Type checking for returnNode not yet implemented");
	  }

	  
	  void visit(argsNode n){
		System.out.println("Type checking for argsNode not yet implemented");
	  }
	  	
	  void visit(nullArgsNode n){}
		
	  void visit(castNode n){
		System.out.println("Type checking for castNode not yet implemented");
	  }

	  void visit(fctCallNode n){
		System.out.println("Type checking for fctCallNode not yet implemented");
	  }

	  void visit(unaryOpNode n){
		System.out.println("Type checking for unaryOpNode not yet implemented");
	  }

	
	void visit(charLitNode n){
		System.out.println("Type checking for charLitNode not yet implemented");
	}
	  
	void visit(strLitNode n){
		System.out.println("Type checking for strLitNode not yet implemented");
	}

	
	void visit(trueNode n){
		System.out.println("Type checking for trueNode not yet implemented");
	}

	void visit(falseNode n){
		System.out.println("Type checking for falseNode not yet implemented");
	}


}
