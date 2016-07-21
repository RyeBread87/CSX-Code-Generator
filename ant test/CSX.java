import java.io.*;

public class CSX {

  public static void
  main(String args[]) throws java.io.IOException,  Exception {

        System.out.println("Begin generation of properties file.");
    	String	asmName = "build.properties"; // name of asmFile
        PrintStream	asmFile; // File to which asm code will be generated
        
    	asmFile = new PrintStream(new FileOutputStream(asmName));
	asmFile.println("jasminFile=myProg2.j");
	asmFile.println("className=test2");
    	asmFile.close();
        System.out.println("End generation of properties file.");
	

    return;
    }
}
	
