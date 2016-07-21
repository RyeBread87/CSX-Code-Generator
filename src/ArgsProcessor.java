//import java.awt.Image;
import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * The purpose of this class is to obtain a  string representing a file name.  
 *  The method getArg first checks the command line. If the args array is non-empty, args[0] is returned.
 *  Otherwise, a GUI will prompt the user to interactively enter a file name.
 *  If the constant SIMPLE_GUI is true, a simple dialog box is created, requesting the name of a file.
 *  If the constant SIMPLE_GUI is false, a file chooser box is created. This box shows available
 *  files and allows navigation within the file system.
 *  
 *  Adapted by Charles Fischer from a class written by Ron Cytron.
 *  
 * @author roncytron
 *
 */
public class ArgsProcessor {
        
    /* If no file name appears on the command line, should a simple gui (that prompts for file name) be used
       or should a more complex gui that show possible file selections be activated?
    */
	final static boolean SIMPLE_GUI = false;
	public static File openedFile; // Save file opened by file chooser GUI 
	
	public static String getArg(String[] args){
		if (args.length >=1) {
			openedFile = null; // caller will open file using name provided on command line
			return(args[0]);
		} else if (SIMPLE_GUI) {
               String ans;
               openedFile = null; // caller will open file using name provided by input dialog
		       Object result = null;
               String prompt = "Enter file name";
		       int curArg = 0;
		       while (result == null) {
		          result = JOptionPane.showInputDialog(
					null,
					prompt,
					"Parameter " + (curArg),
					JOptionPane.QUESTION_MESSAGE,
					null,
					null,
					null
					); 
			   }
		       return(result.toString());
        }  else { // Initiate file chooser GUI dialog
			String directory = ".";
			JFileChooser fc = new JFileChooser();
			File selectedFile = null;
			while (selectedFile == null){
				fc.setCurrentDirectory(new File(directory));
				fc.showOpenDialog(null);
		        	selectedFile = fc.getSelectedFile();
			}
			openedFile = selectedFile; // Remember file opened by file chooser GUI
		    return(selectedFile.getName());
        }
	}

	public static void main(String[] args){
		System.out.println(getArg(args));
	}
	
}
