import java.util.*;
import java.io.*;
class SymbolTable {
   class Scope {
      Hashtable currentScope;
      Scope next;
      Scope() {
         currentScope = new Hashtable();
         next = null;
      }
      Scope(Scope scopes) {
         currentScope = new Hashtable();
         next = scopes;
      }
   }

   private Scope top;

   SymbolTable() {top = new Scope();}

   public void openScope() {
      top = new Scope(top); }

   public void closeScope() throws EmptySTException {
      if (top == null)
         throw new EmptySTException();
      else top = top.next;
   }

   public void insert(Symb s)
         throws DuplicateException, EmptySTException {
      String key = (s.name().toLowerCase());
      if (top == null)
         throw new EmptySTException();
      if (localLookup(key) != null)
         throw new DuplicateException();
      else top.currentScope.put(key,s);
   }

   public Symb localLookup(String s) {
      String key = s.toLowerCase();
      if (top == null)
         return null;
      Symb ans = (Symb) top.currentScope.get(key);
      return ans;
   }

   public Symb globalLookup(String s) {
      String key = s.toLowerCase();
      Scope top = this.top;
      while (top != null) {
         Symb ans = (Symb) top.currentScope.get(key);
         if (ans != null)
            return ans;
         else top = top.next;
      }
      return null;
   }

   public String toString() {
      String ans = "";
      Scope top = this.top;
      while (top != null) {
         ans = ans +  top.currentScope.toString()+"\n";
         top = top.next;
      }
      return ans;
   }

   void dump(PrintStream ps) {
     ps.print(toString());
   }
}
