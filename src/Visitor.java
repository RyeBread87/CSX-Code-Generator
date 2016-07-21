// No need to change anything in this class!
// Generic visit
abstract class Visitor { 
	public void visit(ASTNode n){ 
		//System.out.println ("In  ASTNode visit\t"+n);

		n.accept(this);
	}
	
	abstract  void visit(csxLiteNode n);
	abstract  void visit(classNode n);
	abstract  void visit(memberDeclsNode n);
	abstract  void visit(fieldDeclsNode n);
	abstract  void visit(valArgDeclNode n);
	abstract  void visit(arrayArgDeclNode n);
	abstract  void visit(argDeclsNode n);
	abstract  void visit(nullArgDeclsNode n);
	abstract  void visit(methodDeclsNode n);
	abstract  void visit(nullMethodDeclsNode n);
	abstract  void visit(methodDeclNode n);
	abstract  void visit(trueNode n);
	abstract  void visit(falseNode n);
	abstract  void visit(nullFieldDeclsNode n);
	abstract  void visit(stmtsNode n);
	abstract  void visit(varDeclNode n);
	abstract  void visit(constDeclNode n);
	abstract  void visit(arrayDeclNode n);
	abstract  void visit(nullTypeNode n);
	abstract  void visit(intTypeNode n);
	abstract  void visit(boolTypeNode n);
	abstract  void visit(charTypeNode n);
	abstract  void visit(voidTypeNode n);
	abstract  void visit(identNode n);
	abstract  void visit(nameNode n);
	abstract  void visit(asgNode n);
	abstract  void visit(incrementNode n);
	abstract  void visit(decrementNode n);
	abstract  void visit(printNode n);
	abstract  void visit(nullPrintNode n);
	abstract  void visit(readNode n);
	abstract  void visit(nullReadNode n);
	abstract  void visit(intLitNode n);
	abstract  void visit(charLitNode n);
	abstract  void visit(strLitNode n);
	abstract  void visit(argsNode n);
	abstract  void visit(nullArgsNode n);
	abstract  void visit(binaryOpNode n);
	abstract  void visit(unaryOpNode n);
	abstract  void visit(nullStmtsNode n);
	abstract  void visit(nullStmtNode n);
	abstract  void visit(nullExprNode n);
	abstract  void visit(ifThenNode n);
	abstract  void visit(whileNode n);
	abstract  void visit(blockNode n);
	abstract  void visit(callNode n);
	abstract  void visit(fctCallNode n);
	abstract  void visit(returnNode n);
	abstract  void visit(breakNode n);
	abstract  void visit(continueNode n);
	abstract  void visit(castNode n);


}  
