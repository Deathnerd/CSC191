// ------------------------------
// Course: CSC191
// Project: Lab 7
// Date: 2/25/13
// Author: George Gilleland
// ..............................
// Purpose:
// ------------------------------
package lab7;

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
	static int idxOfSubstring(String str, String sub) {
		return -1;
	}
}

public class Lab7 {

	public static void main(String[] args) {
		System.out.print(MyString.countChar("abbbcdef", 'b'));
	}

}
