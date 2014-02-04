/**
 * Course: CSC191, Spring 2014
 * Projet: Lab 03
 * Date: 2/3/2014
 * Author: Wes Gilleland
 * Purpose: Reads two integers as strings and performs the times table algorithm
 * on them to return a string of the product
 */

package homework2;
import java.util.Scanner;
/**
 * Positive integers of arbitrary length
 */
class LargeInteger {

	public String num; // use a string to store the integer 
	public Long product;
	int multiplier = 1; //the multiplier for our intermediate calculations

	/**
	 * Constructor: initialize num with str E.g., str is "4927", then num is
	 * initialized to "4927"
	 */
	LargeInteger(String str) {
		num = str;
	}

	/**
	 * Calculate the sum of the current integer and another integer The result
	 * is returned through a string
	 */
	String add(LargeInteger another) {
		// your code comes here 
		return "";
	}

	/**
	 * Calculate the product of the current integer and another integer. The
	 * result is returned through a string
	 */
	String multiply(LargeInteger another) {
		// your code comes here 
		return "";
	}
}

public class Homework2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter two positive integers: ");
		LargeInteger int1 = new LargeInteger(in.nextLine());
		LargeInteger int2 = new LargeInteger(in.nextLine());
		
		
	}

}
