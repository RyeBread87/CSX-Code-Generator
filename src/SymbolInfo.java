/**************************************************
*  class used to hold information associated w/
*  Symbs (which are stored in SymbolTables)
*  Update to handle arrays and methods
*
****************************************************/

class SymbolInfo extends Symb {
 public ASTNode.Kinds kind; // Should always be Var in CSX-lite
 public ASTNode.Types type; // Should always be Integer or Boolean in CSX-lite
 public int  varIndex; // Index used to address a CSX-lite variable


 public SymbolInfo(String id, ASTNode.Kinds k, ASTNode.Types t){    
	super(id);
	kind = k; type = t;};
// public SymbolInfo(String id, int k, int t){
//	super(id);
//	kind = new Kinds(k); type = new Types(t);};
 public String toString(){
             return "("+name()+": kind=" + kind+ ", type="+  type+")";};
}

