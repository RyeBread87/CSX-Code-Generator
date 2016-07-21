import java.io.*;
/*
 *  This Visitor class generates JVM assembler code (using Jasmin's format)
 *  for CSX lite in the Printstream afile. You'll need to extend it to
 *  handle all of CSX. Note that for some AST nodes (like asgNode) code generation
 *  for CSX is more complex than that needed for CSX lite.
 *  All methods marked TODO will have to be completed by you (for full CSX)
 */

public class CodeGenerating extends Visitor {
	
	PrintStream afile;	// File to generate JVM code into 

	int cgErrors =  0;       // Total number of code generation errors 

	int numberOfLocals =  0; // Total number of local CSX-lite vars

	int labelCnt = 0;	// counter used to generate unique labels
	
	CodeGenerating(PrintStream f){
		afile=f;
	}

	static void assertCondition(boolean assertion){
		if (! assertion)
			 throw new RuntimeException();
	}

	String error(ASTNode n) {
		return "Error (line " + n.linenum + "): ";
        }

	// generate a comment
	 void  genComment(String text){
       	gen("; "+text);
	}

	// generate an instruction w/ 0 operands
	 void  gen(String opcode){
        	afile.println("\t"+opcode);
	}

        // generate an instruction w/ 1 operand
	void  gen(String opcode, String operand){
        	afile.println("\t"+opcode+"\t"+operand);
	}

        // generate an instruction w/ 1 integer operand
	void  gen(String opcode, int operand){
        	afile.println("\t"+opcode+"\t"+operand);
	}


	//  generate an instruction w/ 2 operands
	void  gen(String opcode, String operand1, String operand2){
        	afile.println("\t"+opcode+"\t"+ operand1+"  "+ operand2);
	}

	//  generate an instruction w/ 2 operands (String and int)
	void  gen(String opcode, String operand1, int operand2){
        	afile.println("\t"+opcode+"\t"+ operand1+"  "+operand2);
	}

	//      Generate a new label of form labeln (e.g., label7 or label123)
	String   genLab(){
                return "label"+labelCnt++;
	}

	//      Place a label in generated code
	void    defineLab(String label){
        	afile.println(label+":");
	}
	
	void branch(String label){
		gen("goto",label);
	}
	
	void loadI(int val){
		gen("ldc",val);
	}

	static Boolean isRelationalOp(int op) {
		switch (op) {
			case sym.EQ:
			case sym.NOTEQ:
	//		case sym.LT:
	//		case sym.LEQ:	
	//		case sym.GT:
	//		case sym.GEQ:
				return true;
			default:
				return false;
		}
	}
	static String relationCode(int op) {
		switch (op) {
			case sym.EQ:
				return "eq";
			case sym.NOTEQ:
				return "ne";
	//		case sym.LT:
	//		case sym.LEQ:	
	//		case sym.GT:
	//		case sym.GEQ:
			default:
				return "";
		}
	}
	static String selectOpCode(int op) {
		switch (op) {
			case sym.PLUS:
				return("iadd");
			case sym.MINUS:
				return("isub");
			//case sym.TIMES:
			//	return("imul");
			//case sym.SLASH:
			//	return("idiv");
			//case sym.CAND:
			//	return("iand");
			//case sym.COR:
			//	return("ior");
			default:
				assertCondition(false);
				return "";
		}
	}
	
	
	//   startCodeGen translates the AST rooted by node n
  	//      into JVM code which is written in afile.
	//   If no errors occur during code generation,
	//    TRUE is returned, and afile should contain a
    //    complete and correct JVM program. 
	//   Otherwise, FALSE is returned and afile need not
	//    contain a valid program.
	
	boolean startCodeGen(csxLiteNode n) {// For CSX Lite
	    this.visit(n);
	    return (cgErrors == 0);
	}
	
	boolean startCodeGen(classNode n) {// For CSX
	    this.visit(n);
	    return (cgErrors == 0);
		}
	
 	void visit(csxLiteNode n) {
 		genComment("CSX Lite program translated into Java bytecodes (Jasmin format)");
		gen(".class","public","test");
    	gen(".super","java/lang/Object");
    	gen(".method"," public static","main([Ljava/lang/String;)V");
		this.visit(n.progDecls);
		if (numberOfLocals >0)
    		gen(".limit","locals",numberOfLocals);
		this.visit(n.progStmts);
    	gen("return");
    	gen(".limit","stack",10);
    	gen(".end","method");
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

	void visit(varDeclNode n){
			//   Give this variable an index equal to numberOfLocals (initially 0)
			//     and remember index in symbol table entry

	        n.varName.idinfo.varIndex = numberOfLocals;
	        
	        //   Increment numberOfLocals used in this prog
	        
	        numberOfLocals++;
	}
	
	void visit(nullTypeNode n) {}

	void visit(intTypeNode n) {
		// No code generation needed
	}

	void visit(boolTypeNode n) {
		// No code generation needed
	}

	void visit(charTypeNode n) {
		// No code generation needed
	}

	void visit(voidTypeNode n) {
		// No code generation needed
	}
	
	void visit(asgNode n) {
	 // Translate RHS (an expression)
    	this.visit(n.source);

    // Value to be stored is now on the stack
    // Save it into target variable, using the variable's index
    	gen("istore", n.target.varName.idinfo.varIndex);
	}
	
	void visit(ifThenNode n) { //No else statement in CSX lite
	 	String    out;  // label that will mark end of if stmt

        // translate boolean condition, pushing it onto the stack
        	this.visit(n.condition);

        	out = genLab();

        // generate conditional branch around then stmt
        	gen("ifeq",out);

        // translate then part
        	this.visit(n.thenPart);

        // generate label marking end of if stmt
        	defineLab(out);
	}

	void visit(printNode n) {
		// compute value to be printed onto the stack
    	this.visit(n.outputValue);
    
    // Call CSX library routine "printInt(int i)"
    	gen("invokestatic"," CSXLib/printInt(I)V");
	}

	void visit(nullPrintNode n) {}
		
	void visit(blockNode n) {
		this.visit(n.decls);
		this.visit(n.stmts);
	}
	
	void visit(binaryOpNode n) {
		 // First translate the left and right operands
    	this.visit(n.leftOperand);
    	this.visit(n.rightOperand);
    // Now the values of the operands are on the stack
    // Is this a relational operator?
    	if (isRelationalOp(n.operatorCode)){
    		String trueLab = genLab();
    		String skip = genLab();
    		gen("if_icmp" + relationCode(n.operatorCode), trueLab);
    		loadI(0);
    		branch(skip);
			defineLab(trueLab);
			loadI(1);
			defineLab(skip);
    	}else{
    		gen(selectOpCode(n.operatorCode));
    	}
	}
	
	
	void visit(identNode n) {
	// In CSX-lite, we don't code generate identNode directly.
       //  Instead, we do translation in parent nodes where the
       //   context of identNode is known
       // Hence no code generation actions are defined here 
	   // (though you may want/need to define some in full CSX)

	}
	
	void visit(intLitNode n) {
		loadI(n.intval);
	}
	
	void visit(nameNode n) {
		 // In CSX lite no arrays exist and all variable names are local variables
		
		 // Load value of this variable onto stack using its index
   		gen("iload",n.varName.idinfo.varIndex);
	}

	
	void visit(classNode n) {
		// TODO Auto-generated method stub

	}

	void visit(memberDeclsNode n) {
		// TODO Auto-generated method stub

	}

	
	void visit(valArgDeclNode n) {
		// TODO Auto-generated method stub

	}

	void visit(arrayArgDeclNode n) {
		// TODO Auto-generated method stub

	}

	void visit(argDeclsNode n) {
		// TODO Auto-generated method stub

	}


	void visit(nullArgDeclsNode n) {}


	void visit(methodDeclsNode n) {
		// TODO Auto-generated method stub

	}

	void visit(nullMethodDeclsNode n) {}

	void visit(methodDeclNode n) {
		// TODO Auto-generated method stub

	}

	void visit(trueNode n) {
		// TODO Auto-generated method stub

	}

	void visit(falseNode n) {
		// TODO Auto-generated method stub

	}

	void visit(constDeclNode n) {
		// TODO Auto-generated method stub

	}

	void visit(arrayDeclNode n) {
		// TODO Auto-generated method stub

	}


	void visit(readNode n) {
		// TODO Auto-generated method stub

	}


	void visit(nullReadNode n) {}


	void visit(charLitNode n) {
		// TODO Auto-generated method stub

	}

	void visit(strLitNode n) {
		// TODO Auto-generated method stub

	}

	void visit(argsNode n) {
		// TODO Auto-generated method stub

	}


	void visit(nullArgsNode n) {}

	
	void visit(unaryOpNode n) {
		// TODO Auto-generated method stub

	}


	void visit(nullStmtNode n) {}


	void visit(nullExprNode n) {}

	
	void visit(whileNode n) {
		// TODO Auto-generated method stub

	}

	void visit(callNode n) {
		// TODO Auto-generated method stub

	}


	void visit(fctCallNode n) {
		// TODO Auto-generated method stub

	}


	void visit(returnNode n) {
		// TODO Auto-generated method stub

	}

	void visit(breakNode n) {
		// TODO Auto-generated method stub

	}

	void visit(continueNode n) {
		// TODO Auto-generated method stub

	}


	void visit(castNode n) {
		// TODO Auto-generated method stub

	}
	
	 void visit(incrementNode n){
		// TODO Auto-generated method stub
		 }
	 void visit(decrementNode n){
		// TODO Auto-generated method stub
		 }

}
