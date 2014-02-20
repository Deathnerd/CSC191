// ------------------------------
// Course: CSC191
// Project: lab 6
// Date: 2/19/13
// Author: George Gilleland
// ..............................
// Purpose: This program will take a binary number and convert it to a 
// decimal as well as a decimal and convert it to a binary nubmer
// ------------------------------
package lab6;

class NumConversion {
	// recursive method that converts a decimal integer to binary 
	static String decimal2binary(int d) {
		//base case
		if(d == 0)
			return "";
		return decimal2binary(d/2)+d%2+"";
	}

	// recursive method that converts a binary number to decimal 
	static int binary2decimal(String b) {
		if(b.length() == 0)
			return 0;
		String t = b.substring(1,b.length());
		if(b.charAt(0) == '1')
			return (int)Math.pow(2, t.length())+binary2decimal(t);
		return binary2decimal(t);
	}
}

public class Lab6 {

	public static void main(String[] args) {
		System.out.print(NumConversion.decimal2binary(25698735));
		System.out.println();
		System.out.print(NumConversion.binary2decimal("10101"));
		System.out.println();
	}

}
