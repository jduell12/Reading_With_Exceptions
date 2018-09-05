package reading_with_exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class Reading_With_Exceptions {
	void process(String inputFileName) {
		Scanner scan = null;
		PrintStream ps = null;

		try {
			FileInputStream fi = new FileInputStream(inputFileName);
			scan = new Scanner(fi);

			
				String name = scan.next();
				ps = new PrintStream(name);
				int count = -1;
				if (scan.hasNextInt()) {
					count = scan.nextInt();
				} else {
					System.out.println("The next input is not an integer.");
					scan.next();
					count = scan.nextInt();
				}
				ps.println(name + " created with the following " + count + " output: ");
				copyNumbers(scan, ps, count);
				printToScreen(name);
			
		} catch (FileNotFoundException e) {
			System.out.println("error: " + e);
		} finally {
			if (scan != null) {
				scan.close();
			}
			if (ps != null) {
				ps.close();
			}
		}

	}

	void copyNumbers(Scanner scan, PrintStream ps, int numIntsToRead) {
		int sum = 0;
		int x = -1;
		int value = 0;
		int i = 0;
		
		try {
		while (i <= numIntsToRead + 1) {
			 if (sum == 10) {
				ps.println();
				sum = 0;
			} else if (scan.hasNextInt()) {
				if (value == (numIntsToRead + 1)) {
					if(scan.hasNext()) {
						scan.next();
					}
				} else {
					x = scan.nextInt();
					ps.print(x + " ");
					sum++;
					value++;
				} 
			}  else {
				System.out.println("Bad integer: " + scan.next());
			}
			 i++;
			} 
		} catch (NoSuchElementException e){
			System.out.println("Error: " + e);
		}
	}

	public static void main(String[] args) {
		Reading_With_Exceptions rwe = new Reading_With_Exceptions();
		for (int i = 0; i < args.length; i++) {
			System.out.println("\n\n============ Processing " + args[i] + " =================\n");
			rwe.process(args[i]);
		}
	}

	private void printToScreen(String filename) {
		Scanner scan = null;
		try {
			FileInputStream fis = new FileInputStream(filename);
			scan = new Scanner(fis);
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
