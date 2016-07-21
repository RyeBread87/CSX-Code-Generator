/*  This is the driver of the compilation process.
 *  The CSX Lite program is scanned and parsed, and an AST is built.
 *  The AST is then type checked and code is generated.
 *   You'll need to update this to handle ASTs rooted by classNodes
 * 
 */

import java.io.*;

import java_cup.runtime.*;

public class CSX {

  public static void
  main(String args[]) throws java.io.IOException,  Exception {

	 String fileName;
		fileName = ArgsProcessor.getArg(args);
		
	    java.io.FileInputStream yyin = null;
	    if (ArgsProcessor.openedFile != null) {
	    	// file chooser GUI already opened a file; create a 
	    	//  FileInputStream from it
	    	yyin = new FileInputStream(ArgsProcessor.openedFile);
	    } else { // open file using name provided
	    	try {
	    		yyin = new FileInputStream(fileName);  
	    	} catch (FileNotFoundException notFound){
	    		System.out.println ("Error: unable to open file: "+fileName);
	    		System.exit(-1);
	    	}
	    }

    Scanner.init(yyin); // Initialize Scanner class for parser

    parser csxParser = new parser(); 

    System.out.println ("\n\n" + "Begin CSX compilation of " +
			fileName + ".\n");
    Symbol root=null;
    try {
        root = csxParser.parse(); // do the parse
        System.out.println ("CSX program parsed correctly.");
	
    } catch (SyntaxErrorException e){  
        System.out.println ("Compilation terminated due to syntax errors.");
        System.exit(0);
    }

    boolean    ok;
    TypeChecking typeCheck = new TypeChecking();
    
 // Update to handle ASTs rooted by classNodes
    ok = typeCheck.isTypeCorrect((csxLiteNode) root.value);
    
    if (ok) {
    	// In CSX lite there is no user defined class name so we simply use "test"
    	// In full CSX you can get the actual class name via:
    	//   ((classNode) root.value).className.idname
        String className = "test"  ; 
    	String asmName = className+".j"; // name of asmFile

        
        // We'll place the name of the class we are generating in a file "build.properties"
        // This file can be accessed by build.xml to get the class name we're translating
        PrintStream	propertiesFile; // File to which build propertiese will be generated
        propertiesFile = new PrintStream(new FileOutputStream("build.properties"));
        propertiesFile.println("className="+className);
        propertiesFile.close();
        
        PrintStream	asmFile; // File to which asm code will be generated
    	asmFile = new PrintStream(new FileOutputStream(asmName));
    	CodeGenerating codeGen =new CodeGenerating(asmFile);
    	
        ok = codeGen.startCodeGen((csxLiteNode) root.value);

    	if (ok) {
    		asmFile.close();
            System.out.println("CSX compilation successfully completed.");
            System.out.println("Translated program is in "+asmName+".");
    	} else {
           System.out.println( "CSX compilation halted due to code generation errors.");
        }

    } else   System.out.println("\nCSX compilation halted due to type errors.");
	

    return;
    }
}
	
