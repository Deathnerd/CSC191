package example21;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Scanner;

/**
 * Project: Example21
 * Package: example21
 * Class:
 * Created by George Gilleland at 9:48 AM on 4/29/14.
 */

class WriteTextFile{
	Formatter outputFile;

	void openFile(String outputFileName){
		try{
			outputFile = new Formatter(outputFileName);
		} catch(FileNotFoundException e){
			System.out.println("Create file failed!");
			System.exit(1);
		} catch(SecurityException e){
			System.out.println("Improper file access permissions. Are you using sudo?");
			System.exit(1);
		}
	}

	void writeToFile(){
		try{
			outputFile.format("%-10s%-5d%-5.1f\n", "CSC545", 3, 82.25);
			outputFile.format("%-10s%-5d%-5.1f\n", "CSC191", 3, 81.0);
			outputFile.format("%-10s%-5d%-5.1f\n", "MAT107", 5, 87.5);
		} catch(FormatterClosedException e){
			System.out.println("Writing to file failed!");
			System.exit(1);
		}
	}

	void closeFile(){
		if(outputFile != null){
			outputFile.close();
		}
	}
}
public class example21 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the file name: ");
		String outputFileName = input.next();

		WriteTextFile wtf = new WriteTextFile();
		wtf.openFile(outputFileName);
		wtf.writeToFile();
		wtf.closeFile();
	}
}
