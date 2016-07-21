// The following methods unparse  AST nodes used in CSX Lite
//  You will need to complete the methods after line 130 to unparse the
//   rest of CSX
//  Be sure to extend method printOp to handle all CSX operators

public class TypeChecking extends Visitor {
	
	static void genIndent(int indent){
		for (int i=1;i<=indent;i++)
//			System.out.print("\t");
		    System.out.print("   ");
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

	
	 void visit(csxLiteNode n,int indent){
		//System.out.println ("\n\nStart 2nd unparsing:\n"); 
		System.out.println(n.linenum + ":\t" + " {");
		this.visit(n.progDecls,1);
		this.visit(n.progStmts,1);
		System.out.println(n.linenum + ":\t" + " } EOF");
	}
	
	void visit(fieldDeclsNode n,int indent){
			this.visit(n.thisField,indent);
			this.visit(n.moreFields,indent);
	}
	void visit(nullFieldDeclsNode n,int indent){}

	void visit(stmtsNode n,int indent){
		  //System.out.println ("In stmtsNode\n");
		  this.visit(n.thisStmt,indent);
		  this.visit(n.moreStmts,indent);

	}
	void visit(nullStmtsNode n,int indent){}

// Extend varDeclNode's method to handle initialization
	void visit(varDeclNode n,int indent){
		System.out.print(n.linenum + ":\t");
		genIndent(indent);
	    	this.visit(n.varType,0);
		System.out.print(" ");
		this.visit(n.varName,0);
		System.out.println(";");
	};
	
	void visit(nullTypeNode n,int ident){}
	
	void visit(intTypeNode n,int ident){
		System.out.print("int");
	}
	void visit(boolTypeNode n,int ident){
		System.out.print("bool");
	}
	void visit(identNode n,int indent){
		System.out.print(n.idname);
	}
// Extend nameNode's method to handle subscripts
	void visit(nameNode n,int indent){
		System.out.print(n.varName.idname);
	}
	void visit(asgNode n,int indent){
		System.out.print(n.linenum + ":\t"); 
		genIndent(indent);
		this.visit(n.target,0);
		System.out.print(" = ");
		this.visit(n.source,0);
		System.out.println(";");
	} 
// Extend ifThenNode's method to handle else parts
	void visit(ifThenNode n,int indent){
		  System.out.print(n.linenum + ":\t");
		  genIndent(indent);
		  System.out.print("if (");
		  this.visit(n.condition,0);
		  System.out.println(")");
		  this.visit(n.thenPart,indent+1);
		  // No else parts in CSXlite
	}
	  
	  void visit(blockNode n,int indent){
		System.out.print(n.linenum + ":\t");
		genIndent(indent);
		System.out.println("{");
		this.visit(n.decls,indent+1);
		this.visit(n.stmts,indent+1);
		System.out.print(n.linenum + ":\t");
		genIndent(indent);
		System.out.println("}");
	  }

	
	  void visit(binaryOpNode n,int indent){
		  
		  System.out.print("(");
			this.visit(n.leftOperand,0);
			printOp(n.operatorCode);
			this.visit(n.rightOperand,0);
			System.out.print(")");
	  }

	
	
	void visit(intLitNode n,int indent){
		if (n.intval>=0)
			System.out.print(n.intval);
		else	System.out.print("~"+-n.intval);
	}


 
// Extend these unparsing methods to correctly unparse CSX AST nodes
	 
	 void visit(classNode n,int indent){
		System.out.println("Unparsing for classNode not yet implemented");
		}

	 void  visit(memberDeclsNode n,int indent){
		System.out.println("Unparsing for memberDeclsNode not yet implemented");
	 }
	 
	 void  visit(methodDeclsNode n,int indent){
		System.out.println("Unparsing for methodDeclsNode not yet implemented");
		 }
	 
	 void visit(nullStmtNode n,int indent){}
	 
	 void visit(nullReadNode n,int indent){}

	 void visit(nullPrintNode n,int indent){}

	 void visit(nullExprNode n,int indent){}

	 void visit(nullMethodDeclsNode n,int indent){}

	 void visit(methodDeclNode n,int indent){
		System.out.println("Unparsing for methodDeclNode not yet implemented");
	 }

	 
	void visit(argDeclsNode n,int indent){
		System.out.println("Unparsing for argDeclsNode not yet implemented");
	}

	void visit(nullArgDeclsNode n,int indent){}

	
	void visit(valArgDeclNode n,int indent){
		System.out.println("Unparsing for valArgDeclNode not yet implemented");
	}
	
	void visit(arrayArgDeclNode n,int indent){
		System.out.println("Unparsing for arrayArgDeclNode not yet implemented");
	}
	
	void visit(constDeclNode n,int indent){
		System.out.println("Unparsing for constDeclNode not yet implemented");
	 }
	 
	 void visit(arrayDeclNode n,int indent){
		System.out.println("Unparsing for arrayDeclNode not yet implemented");
	 }
	
	void visit(charTypeNode n,int ident){
		System.out.println("Unparsing for charTypeNode not yet implemented");
	}
	void visit(voidTypeNode n,int ident){
		System.out.println("Unparsing for voidTypeNode not yet implemented");
	}

	void visit(whileNode n,int indent){
		System.out.println("Unparsing for whileNode not yet implemented");
	  }

	void visit(breakNode n,int indent){
		System.out.println("Unparsing for breakNode not yet implemented");
	}
	void visit(continueNode n,int indent){
		System.out.println("Unparsing for continueNode not yet implemented");
	}
	  
	void visit(callNode n,int indent){
		System.out.println("Unparsing for callNode not yet implemented");
	}

	  
	 void visit(printNode n,int indent){
		System.out.println("Unparsing for printNode not yet implemented");
	  }
	  
	  void visit(readNode n,int indent){
		System.out.println("Unparsing for readNode not yet implemented");
	  }
	  

	  void visit(returnNode n,int indent){
		System.out.println("Unparsing for returnNode not yet implemented");
	  }

	  
	  void visit(argsNode n,int indent){
		System.out.println("Unparsing for argsNode not yet implemented");
	  }
	  	
	  void visit(nullArgsNode n,int indent){}
		
	  void visit(castNode n,int indent){
		System.out.println("Unparsing for castNode not yet implemented");
	  }

	  void visit(fctCallNode n,int indent){
		System.out.println("Unparsing for fctCallNode not yet implemented");
	  }

	  void visit(unaryOpNode n,int indent){
		System.out.println("Unparsing for unaryOpNode not yet implemented");
	  }

	
	void visit(charLitNode n,int indent){
		System.out.println("Unparsing for charLitNode not yet implemented");
	}
	  
	void visit(strLitNode n,int indent){
		System.out.println("Unparsing for strLitNode not yet implemented");
	}

	
	void visit(trueNode n,int indent){
		System.out.println("Unparsing for trueNode not yet implemented");
	}

	void visit(falseNode n,int indent){
		System.out.println("Unparsing for falseNode not yet implemented");
	}


}
