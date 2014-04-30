package example22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Project: Example22
 * Package: example22
 * Class:
 * Created by George Gilleland at 10:09 AM on 4/29/14.
 */

class ReadTextFile{
	Scanner inputFile;

	void openFile(String inputFileName){
		try{
			inputFile = new Scanner(new File(inputFileName));
		} catch (FileNotFoundException e){
			System.out.println("Failed to open file");
			System.exit(1);
		} catch (SecurityException e){
			System.out.println("Filesystem access error");
			System.exit(1);
		}
	}

	void readFile(){
		try{
			System.out.printf("%-10s%-10s%-10s\n", "Course", "Hours", "Grade");
			while(inputFile.hasNext()){
				String course = inputFile.next();
				int hours = inputFile.nextInt();
				double grade = inputFile.nextDouble();

				System.out.printf("%-10s%-10d%-10.1f\n", course, hours, grade);
			}
		} catch (NoSuchElementException e){
			System.out.println("File improperly formatted");
			inputFile.close();
			System.exit(1);
		} catch (IllegalStateException e){
			System.out.println("Reading from this file failed");
			System.exit(1);
		}
	}

	void closeFile(){
		if(inputFile != null)
			inputFile.close();
	}
}
public class example22 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the file name: ");

		ReadTextFile rtf = new ReadTextFile();
		rtf.openFile(input.next());
		rtf.readFile();
		rtf.closeFile();
	}
}
