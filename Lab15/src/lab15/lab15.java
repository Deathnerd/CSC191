package lab15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Project: Lab15
 * Package: lab15
 * Class:
 * Created by George Gilleland at 9:19 AM on 4/30/14.
 */

//class that contains methods for encrypting and decrypting text
class Crypto {

	//returns an encrypted string
	public static String encrypt(String line) {
		String temp = "";

		for (int i = 0; i < line.length(); i++) {
			int s = line.charAt(i) + 10 % 128;
			temp += Character.toString((char) s);
		}

		return temp;
	}

	//returns a decrypted string
	public static String decrypt(String line) {
		String temp = "";

		for (int i = 0; i < line.length(); i++) {
			char character = line.charAt(i);
			if (character <= 9) { //for characters that are between 118 and 128 when decrypted
				int s = 128 - (10 - character);
				temp += Character.toString((char) s);
			} else { //all the others
				int s = character - 10;
				temp += Character.toString((char) s);
			}
		}

		return temp;
	}
}

class ReadTextFile {
	Scanner inputFile;
	List<String> lines = new ArrayList<String>(); //a dynamic list of strings to contain the lines of the file

	void openFile(String filename) {
		try {
			inputFile = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println("Failed to open file");
			System.exit(1);
		} catch (SecurityException e) {
			System.out.println("Filesystem access error");
			System.exit(1);
		}
	}

	void readFile() {
		try {
			while (inputFile.hasNext()) {
				lines.add(inputFile.nextLine());
			}
		} catch (Exception e) {
			System.out.println("Error reading file");
			System.exit(1);
		}
	}

	void closeFile() {
		if (inputFile != null)
			inputFile.close();
	}
}

class WriteToFile {
	Formatter outputFile;

	void openFile(String filename) {
		try {
			outputFile = new Formatter(filename);
		} catch (FileNotFoundException e) {
			System.out.println("Create file failed!");
			System.exit(1);
		} catch (SecurityException e) {
			System.out.println("Improper file access permissions. Are you using sudo?");
			System.exit(1);
		}
	}

	void writeToFile(String line) {
		try {
			outputFile.format(line + "\n");
		} catch (FormatterClosedException e) {
			System.out.println("Writing to file failed!");
			System.exit(1);
		}
	}

	void closeFile() {
		if (outputFile != null)
			outputFile.close();
	}
}

public class lab15 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a command: ");
		String command = in.next(); //grab the command
		String readFile = in.next(); //grab the full file name and path of the file to read
		String writeFile = in.next(); //grab the full file name and path of the file to write

		ReadTextFile read = new ReadTextFile();
		WriteToFile write = new WriteToFile();

		//open the files for operation
		read.openFile(readFile);
		write.openFile(writeFile);
		read.readFile();

		if (command.equals("-e")) {
			//encrypt
			for (int i = 0; i < read.lines.size(); i++) {
				write.writeToFile(Crypto.encrypt(read.lines.get(i))); //encrypt line by line and write
			}
			write.closeFile();
			read.closeFile();
		} else if (command.equals("-d")) {
			//decrypt
			for (int i = 0; i < read.lines.size(); i++) {
				write.writeToFile(Crypto.decrypt(read.lines.get(i))); //decrypt line by line and write
			}
			write.closeFile();
			read.closeFile();
		} else {
			System.out.println("Invalid input. Try again");
		}
	}
}
