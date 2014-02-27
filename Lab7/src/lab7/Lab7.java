// ------------------------------
// Course: CSC191
// Project: Lab 7
// Date: 2/25/13
// Author: George Gilleland
// ..............................
// Purpose: This program will use two recursive functions to
//			find the number of occurances of a character in a 
//			given string and also find if a given substring is
//			in a given string
// ------------------------------
package lab7;
import java.util.Scanner;

class MyString {
	 // recursive method that count the number of occurrences of
	// a given character ch in string str
	static int countChar(String str, char ch) {
		
		//check the first character if there is one
		if(str.length() > 0 && str.charAt(0) == ch){
			
			String t = ""; //new trunctuated string
			for(int i = 1; i<=str.length()-1; i++){
				t += str.charAt(i);
			}
			return 1+countChar(t, ch); //character found
		}
		
		String t = ""; //new trunctuated string
		for(int i = 1; i<=str.length()-1; i++){ //trunctuate string
			t += str.charAt(i);
		}
		
		if(t.length() == 0) //there are no more characters
			return 0;
		
		return 0+countChar(t ,ch); //character not found
	}

	// recursive method
	// if the string sub occurs as a substring within
	// the given string str, then the index of the first
	// character of the first such substring is returned;
	// if it does not occur as a substring, -1 is returned.
	static int idxOfSubstring(String str, String sub){
		return idxOfSubstring(str, sub, 0);
	}
	
	static int idxOfSubstring(String str, String sub, int index) {
		boolean found = false; //assume we haven't found anything
		
		if(index < str.length() && sub.length() <= str.length()){ //
			
			for(int j=0; j<sub.length(); j++){ //check the whole substring
				
				if(sub.charAt(j) == str.charAt(index+j)){ //if current char is equal to index + j in str
					found = true; //so far so good
					continue; //check the next character
				}	
				found = false; //substring is not equal to current substring of str
				break;
			}
			
			if(found) //if the substring has been found
				return index; //return the index
			else //string not found, but there is more to scan
				return idxOfSubstring(str, sub, index+1); //check the next string
		}
		
		return -1; //substring not found
	}
}

public class Lab7 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = "";
		char ch;
		String sub = "";
		while(true){
			System.out.print("Select from:\n"
					+		 "1. Count a specified character \n"
					+		 "2. Index of a substring \n"
					+		 "0. Quit");
			int i = in.nextInt();
			switch(i){
				case 1:
					System.out.print("Enter a string: ");
					str = in.next();
					System.out.print("Enter a character:");
					ch = in.next().charAt(0);
					System.out.printf("Number of %c in %s: %d", ch, str, MyString.countChar(str, ch));
					break;
				case 2:
					System.out.print("Enter a string: ");
					str = in.next();
					System.out.print("Enter a substrin: ");
					sub = in.next();
					System.out.printf("Substring %s is located at %d in string %s ", sub, MyString.idxOfSubstring(str, sub), str);
					break;
				case 0:
					return;
				default:
					System.out.println("Invalid input!");
			}
		}
	}
}
