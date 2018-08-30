package reading_with_exceptions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class Reading_With_Exceptions {
	void process (String inputFileName) {
		Scanner scan = null;
		PrintStream printStream = null;
		
		try {
			FileInputStream fi = new FileInputStream(inputFileName);
			scan = new Scanner(fi);
		} catch(FileNotFoundException e) {
			System.out.println("error: " +e);
		} finally {
			if (scan != null) {
				scan.close();
			} 
			if (printStream != null) {
				printStream.close();
			}
		}

//2) Read the first String from the file and use it to create a PrintStream
//3) Using hasNextInt and nextInt, carefully read the count integer
//4) use copyNumbers method to complete the job
//5) close the Scanner and PrintStream objects
//6) call printToScreen to copy the output file to the screen
	}
	
	void copyNumbers (Scanner scan, PrintStream ps, int numIntsToRead) {
		//hasNext() can be used to see if the scan object still has data
		//Note that hasNextInt() can be used to see if an integer is present
		//nextInt() will read an integer
		//next() can be used to skip over bad integers
	}
	
	public static void main (String[] args) {
		Reading_With_Exceptions rwe = new Reading_With_Exceptions();
		for (int i = 0; i < args.length; i++) {
			System.out.println("\n\n============ Processing " + args[i] + " =================\n");
			rwe.process(args[i]);
		}
	}
	
	private void printToScreen (String filename) {
		Scanner scan = null;
		try {
			FileInputStream fis = new FileInputStream(filename);
			scan = new Scanner (fis);
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("printToScreen: can't open: " + filename);
		} finally {
			if (scan != null) {
				scan.close();
			}
		}
	}
}
