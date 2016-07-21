
//----------------------------------------------------
// The following code was generated by CUP v0.10f
// Thu Nov 21 14:16:00 CST 2013
//----------------------------------------------------

import java_cup.runtime.*;

public class parser extends java_cup.runtime.lr_parser {

  /** constructor */
  public parser() {super();}

  /** production table */
  protected static final short _production_table[][] = {
        {0, 2},     {1, 4},     {7, 4},     {7, 4},     {7, 0}, 
        {2, 2},     {2, 0},     {3, 4},     {3, 5},     {3, 5}, 
        {3, 5},     {3, 4},     {4, 3},     {4, 3},     {4, 3}, 
        {4, 3},     {4, 1},     {5, 1},     {5, 3},     {5, 1}, 
        {6, 1},     {8, 1}  };

  /** access to production table */
  public short[][] production_table() {return _production_table;}

  /** parse action table */
  protected static final short[][] _action_table = {
    /*0*/{8,2,-1,0},
    /*1*/{2,-5,8,-5,9,-5,14,-5,15,5,16,-5,17,7,-1,0},
    /*2*/{0,4,-1,0},
    /*3*/{0,-1,-1,0},
    /*4*/{2,8,-1,0},
    /*5*/{2,17,8,14,9,-7,14,13,16,15,-1,0},
    /*6*/{2,8,-1,0},
    /*7*/{4,-22,-1,0},
    /*8*/{4,10,-1,0},
    /*9*/{2,-5,8,-5,9,-5,14,-5,15,5,16,-5,17,7,-1,0},
    /*10*/{2,-3,8,-3,9,-3,14,-3,16,-3,-1,0},
    /*11*/{9,49,-1,0},
    /*12*/{5,45,-1,0},
    /*13*/{2,-5,8,-5,9,-5,14,-5,15,5,16,-5,17,7,-1,0},
    /*14*/{5,37,-1,0},
    /*15*/{7,20,-1,0},
    /*16*/{4,-21,6,-21,7,-21,10,-21,11,-21,12,-21,13,-21,-1,0},
    /*17*/{2,17,8,14,9,-7,14,13,16,15,-1,0},
    /*18*/{9,-6,-1,0},
    /*19*/{2,17,3,21,5,24,-1,0},
    /*20*/{4,-20,6,-20,10,-20,11,-20,12,-20,13,-20,-1,0},
    /*21*/{4,-18,6,-18,10,-18,11,-18,12,-18,13,-18,-1,0},
    /*22*/{4,-17,6,-17,10,-17,11,-17,12,-17,13,-17,-1,0},
    /*23*/{2,17,3,21,5,24,-1,0},
    /*24*/{4,29,10,27,11,30,12,26,13,28,-1,0},
    /*25*/{2,17,3,21,5,24,-1,0},
    /*26*/{2,17,3,21,5,24,-1,0},
    /*27*/{2,17,3,21,5,24,-1,0},
    /*28*/{2,-8,8,-8,9,-8,14,-8,16,-8,-1,0},
    /*29*/{2,17,3,21,5,24,-1,0},
    /*30*/{4,-14,6,-14,10,-14,11,-14,12,-14,13,-14,-1,0},
    /*31*/{4,-16,6,-16,10,-16,11,-16,12,-16,13,-16,-1,0},
    /*32*/{4,-13,6,-13,10,-13,11,-13,12,-13,13,-13,-1,0},
    /*33*/{4,-15,6,-15,10,-15,11,-15,12,-15,13,-15,-1,0},
    /*34*/{6,36,10,27,11,30,12,26,13,28,-1,0},
    /*35*/{4,-19,6,-19,10,-19,11,-19,12,-19,13,-19,-1,0},
    /*36*/{2,17,3,21,5,24,-1,0},
    /*37*/{6,39,10,27,11,30,12,26,13,28,-1,0},
    /*38*/{4,40,-1,0},
    /*39*/{2,-10,8,-10,9,-10,14,-10,16,-10,-1,0},
    /*40*/{2,17,8,14,9,-7,14,13,16,15,-1,0},
    /*41*/{9,43,-1,0},
    /*42*/{2,-12,4,44,8,-12,9,-12,14,-12,16,-12,-1,0},
    /*43*/{2,-11,8,-11,9,-11,14,-11,16,-11,-1,0},
    /*44*/{2,17,3,21,5,24,-1,0},
    /*45*/{6,47,10,27,11,30,12,26,13,28,-1,0},
    /*46*/{2,17,8,14,14,13,16,15,-1,0},
    /*47*/{2,-9,8,-9,9,-9,14,-9,16,-9,-1,0},
    /*48*/{0,-2,-1,0},
    /*49*/{4,51,-1,0},
    /*50*/{2,-5,8,-5,9,-5,14,-5,15,5,16,-5,17,7,-1,0},
    /*51*/{2,-4,8,-4,9,-4,14,-4,16,-4,-1,0},
  };

  /** access to parse action table */
  public short[][] action_table() {return _action_table;}

  /** reduce_goto table */
  protected static final short[][] _reduce_table = {
    /*0*/{1,2,-1,-1},
    /*1*/{7,5,-1,-1},
    /*2*/{-1,-1},
    /*3*/{-1,-1},
    /*4*/{8,49,-1,-1},
    /*5*/{2,11,3,17,6,15,-1,-1},
    /*6*/{8,8,-1,-1},
    /*7*/{-1,-1},
    /*8*/{-1,-1},
    /*9*/{7,10,-1,-1},
    /*10*/{-1,-1},
    /*11*/{-1,-1},
    /*12*/{-1,-1},
    /*13*/{7,40,-1,-1},
    /*14*/{-1,-1},
    /*15*/{-1,-1},
    /*16*/{-1,-1},
    /*17*/{2,18,3,17,6,15,-1,-1},
    /*18*/{-1,-1},
    /*19*/{4,24,5,22,6,21,-1,-1},
    /*20*/{-1,-1},
    /*21*/{-1,-1},
    /*22*/{-1,-1},
    /*23*/{4,34,5,22,6,21,-1,-1},
    /*24*/{-1,-1},
    /*25*/{5,33,6,21,-1,-1},
    /*26*/{5,32,6,21,-1,-1},
    /*27*/{5,31,6,21,-1,-1},
    /*28*/{-1,-1},
    /*29*/{5,30,6,21,-1,-1},
    /*30*/{-1,-1},
    /*31*/{-1,-1},
    /*32*/{-1,-1},
    /*33*/{-1,-1},
    /*34*/{-1,-1},
    /*35*/{-1,-1},
    /*36*/{4,37,5,22,6,21,-1,-1},
    /*37*/{-1,-1},
    /*38*/{-1,-1},
    /*39*/{-1,-1},
    /*40*/{2,41,3,17,6,15,-1,-1},
    /*41*/{-1,-1},
    /*42*/{-1,-1},
    /*43*/{-1,-1},
    /*44*/{4,45,5,22,6,21,-1,-1},
    /*45*/{-1,-1},
    /*46*/{3,47,6,15,-1,-1},
    /*47*/{-1,-1},
    /*48*/{-1,-1},
    /*49*/{-1,-1},
    /*50*/{7,51,-1,-1},
    /*51*/{-1,-1},
  };

  /** access to reduce_goto table */
  public short[][] reduce_table() {return _reduce_table;}

  /** instance of action encapsulation class */
  protected CUP$actions action_obj;

  /** action encapsulation object initializer */
  protected void init_actions()
    {
      action_obj = new CUP$actions();
    }

  /** invoke a user supplied parse action */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$do_action(act_num, parser, stack, top);
  }

  /** start state */
  public int start_state() {return 0;}
  /** start production */
  public int start_production() {return 0;}

  /** EOF Symbol index */
  public int EOF_sym() {return 0;}

  /** error Symbol index */
  public int error_sym() {return 1;}


  /** user initialization */
  public void user_init() throws java.lang.Exception
    {
              
    }

  /** scan to get the next Symbol */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {
 return Scanner.next_token(); 
    }


 public void syntax_error(Symbol cur_token)
     {
 	  report_error("CSX syntax error at line "+
			String.valueOf(((CSXToken)cur_token.value).linenum),
			null);
     }
     public void report_fatal_error( String   message, Object   info)
	 throws java.lang.Exception
     {
	   done_parsing();
 	   report_error(message, info);
	   throw new SyntaxErrorException();
     }


}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$actions {


  // only need to create one of these ever
  static public  intTypeNode	INTNode = new intTypeNode(0,0);
  // only need to create one of these ever
  static public  boolTypeNode	BOOLNode = new boolTypeNode(0,0);


  /** Constructor */
  CUP$actions() { }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$do_action(
    int                        CUP$act_num,
    java_cup.runtime.lr_parser CUP$parser,
    java.util.Stack            CUP$stack,
    int                        CUP$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$result;

      /* select the action based on the action number */
      switch (CUP$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // ident ::= IDENTIFIER 
            {
              identNode RESULT = null;
		int ileft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right;
		CSXIdentifierToken i = (CSXIdentifierToken)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-0)).value;
		 RESULT = new identNode(i.identifierText,
					  i.linenum,i.colnum); 
              CUP$result = new java_cup.runtime.Symbol(8/*ident*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // var ::= IDENTIFIER 
            {
              nameNode RESULT = null;
		int ileft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right;
		CSXIdentifierToken i = (CSXIdentifierToken)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-0)).value;
		 RESULT = new nameNode(
					 	   new identNode(i.identifierText,
							 i.linenum,i.colnum),
					  i.linenum,i.colnum); 
              CUP$result = new java_cup.runtime.Symbol(6/*var*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // term ::= INTLIT 
            {
              exprNode RESULT = null;
		int ileft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right;
		CSXIntLitToken i = (CSXIntLitToken)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-0)).value;
		 RESULT = new intLitNode(i.intValue,i.linenum,
						i.colnum);
              CUP$result = new java_cup.runtime.Symbol(5/*term*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // term ::= LPAREN exp RPAREN 
            {
              exprNode RESULT = null;
		int eleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).right;
		exprNode e = (exprNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-1)).value;
		 RESULT = e;  
              CUP$result = new java_cup.runtime.Symbol(5/*term*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // term ::= var 
            {
              exprNode RESULT = null;
		int ileft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right;
		nameNode i = (nameNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-0)).value;
		 RESULT = i; 
              CUP$result = new java_cup.runtime.Symbol(5/*term*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // exp ::= term 
            {
              exprNode RESULT = null;
		int tleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right;
		exprNode t = (exprNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-0)).value;
		 RESULT = t; 
              CUP$result = new java_cup.runtime.Symbol(4/*exp*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // exp ::= exp NOTEQ term 
            {
              exprNode RESULT = null;
		int lleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).right;
		exprNode l = (exprNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-2)).value;
		int opleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).right;
		CSXToken op = (CSXToken)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-1)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left;
		int rright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right;
		exprNode r = (exprNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-0)).value;
		 RESULT=new binaryOpNode(l,sym.NOTEQ,
				r,op.linenum,op.colnum,
				ASTNode.Types.Boolean); 
              CUP$result = new java_cup.runtime.Symbol(4/*exp*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // exp ::= exp EQ term 
            {
              exprNode RESULT = null;
		int lleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).right;
		exprNode l = (exprNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-2)).value;
		int opleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).right;
		CSXToken op = (CSXToken)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-1)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left;
		int rright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right;
		exprNode r = (exprNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-0)).value;
		 RESULT=new binaryOpNode(l,sym.EQ,
				r,op.linenum,op.colnum,
				ASTNode.Types.Boolean); 
              CUP$result = new java_cup.runtime.Symbol(4/*exp*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // exp ::= exp MINUS term 
            {
              exprNode RESULT = null;
		int lleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).right;
		exprNode l = (exprNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-2)).value;
		int opleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).right;
		CSXToken op = (CSXToken)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-1)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left;
		int rright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right;
		exprNode r = (exprNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-0)).value;
		 RESULT=new binaryOpNode(l,sym.MINUS,
				r,op.linenum,op.colnum,
				ASTNode.Types.Integer); 
              CUP$result = new java_cup.runtime.Symbol(4/*exp*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // exp ::= exp PLUS term 
            {
              exprNode RESULT = null;
		int lleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).right;
		exprNode l = (exprNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-2)).value;
		int opleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).right;
		CSXToken op = (CSXToken)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-1)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left;
		int rright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right;
		exprNode r = (exprNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-0)).value;
		 RESULT=new binaryOpNode(l,sym.PLUS,
				r,op.linenum,op.colnum,
				ASTNode.Types.Integer); 
              CUP$result = new java_cup.runtime.Symbol(4/*exp*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // stmt ::= LBRACE decls stmts RBRACE 
            {
              stmtNode RESULT = null;
		int lleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-3)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-3)).right;
		CSXToken l = (CSXToken)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-3)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).right;
		fieldDeclsOption d = (fieldDeclsOption)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-2)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).right;
		stmtsOption s = (stmtsOption)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-1)).value;
		 RESULT =
					new blockNode(d, s, l.linenum,l.colnum); 
              CUP$result = new java_cup.runtime.Symbol(3/*stmt*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-3)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // stmt ::= LBRACE decls stmts RBRACE SEMI 
            {
              stmtNode RESULT = null;
		int lleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-4)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-4)).right;
		CSXToken l = (CSXToken)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-4)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-3)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-3)).right;
		fieldDeclsOption d = (fieldDeclsOption)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-3)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).right;
		stmtsOption s = (stmtsOption)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-2)).value;
		 RESULT =
					new blockNode(d, s, l.linenum,l.colnum); 
              CUP$result = new java_cup.runtime.Symbol(3/*stmt*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-4)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // stmt ::= rw_PRINT LPAREN exp RPAREN SEMI 
            {
              stmtNode RESULT = null;
		int prleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-4)).left;
		int prright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-4)).right;
		CSXToken pr = (CSXToken)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-4)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).right;
		exprNode e = (exprNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-2)).value;
		 RESULT = new printNode(e, printNode.NULL,
					pr.linenum,pr.colnum);
              CUP$result = new java_cup.runtime.Symbol(3/*stmt*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-4)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // stmt ::= rw_IF LPAREN exp RPAREN stmt 
            {
              stmtNode RESULT = null;
		int ileft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-4)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-4)).right;
		CSXToken i = (CSXToken)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-4)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).right;
		exprNode e = (exprNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-2)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right;
		stmtNode s = (stmtNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-0)).value;
		
			 RESULT =new ifThenNode(e, s, stmtNode.NULL,
						i.linenum,i.colnum); 
              CUP$result = new java_cup.runtime.Symbol(3/*stmt*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-4)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // stmt ::= var ASG exp SEMI 
            {
              stmtNode RESULT = null;
		int idleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-3)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-3)).right;
		nameNode id = (nameNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-3)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).right;
		exprNode e = (exprNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-1)).value;
		 RESULT =
			new asgNode(id, e, id.linenum, id.colnum);
			 
              CUP$result = new java_cup.runtime.Symbol(3/*stmt*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-3)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // stmts ::= 
            {
              stmtsOption RESULT = null;
		 RESULT = stmtsNode.NULL; 
              CUP$result = new java_cup.runtime.Symbol(2/*stmts*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // stmts ::= stmt stmts 
            {
              stmtsOption RESULT = null;
		int s1left = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).left;
		int s1right = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).right;
		stmtNode s1 = (stmtNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-1)).value;
		int s2left = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left;
		int s2right = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right;
		stmtsOption s2 = (stmtsOption)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-0)).value;
		 RESULT =
			new stmtsNode(s1,s2,s1.linenum,s1.colnum);
			 
              CUP$result = new java_cup.runtime.Symbol(2/*stmts*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // decls ::= 
            {
              fieldDeclsOption RESULT = null;
		 RESULT = fieldDeclsNode.NULL;
              CUP$result = new java_cup.runtime.Symbol(7/*decls*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // decls ::= rw_BOOL ident SEMI decls 
            {
              fieldDeclsOption RESULT = null;
		int ileft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-3)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-3)).right;
		CSXToken i = (CSXToken)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-3)).value;
		int idleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).right;
		identNode id = (identNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right;
		fieldDeclsOption d = (fieldDeclsOption)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-0)).value;
		 RESULT =new fieldDeclsNode(
			        new varDeclNode(id,BOOLNode,exprNode.NULL,
						i.linenum,i.colnum),	
				d, i.linenum,i.colnum);
              CUP$result = new java_cup.runtime.Symbol(7/*decls*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-3)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // decls ::= rw_INT ident SEMI decls 
            {
              fieldDeclsOption RESULT = null;
		int ileft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-3)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-3)).right;
		CSXToken i = (CSXToken)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-3)).value;
		int idleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).right;
		identNode id = (identNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right;
		fieldDeclsOption d = (fieldDeclsOption)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-0)).value;
		 RESULT =new fieldDeclsNode(
			        new varDeclNode(id, INTNode,exprNode.NULL,
						i.linenum,i.colnum),	
				d, i.linenum,i.colnum);
              CUP$result = new java_cup.runtime.Symbol(7/*decls*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-3)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // prog ::= LBRACE decls stmts RBRACE 
            {
              csxLiteNode RESULT = null;
		int lleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-3)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-3)).right;
		CSXToken l = (CSXToken)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-3)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-2)).right;
		fieldDeclsOption d = (fieldDeclsOption)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-2)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).right;
		stmtsOption s = (stmtsOption)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-1)).value;
		 RESULT =
				new csxLiteNode(d, s, l.linenum,l.colnum); 
              CUP$result = new java_cup.runtime.Symbol(1/*prog*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-3)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          return CUP$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= prog EOF 
            {
              Object RESULT = null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).right;
		csxLiteNode start_val = (csxLiteNode)((java_cup.runtime.Symbol) CUP$stack.elementAt(CUP$top-1)).value;
		RESULT = start_val;
              CUP$result = new java_cup.runtime.Symbol(0/*$START*/, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-1)).left, ((java_cup.runtime.Symbol)CUP$stack.elementAt(CUP$top-0)).right, RESULT);
            }
          /* ACCEPT */
          CUP$parser.done_parsing();
          return CUP$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

