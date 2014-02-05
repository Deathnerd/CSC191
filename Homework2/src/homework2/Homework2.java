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
 * Positive integers of arbitrary length!
 */
class LargeInteger {

	public String num; // use a string to store the integer

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
		final int base = 10;        // for decimal numbers
		String r = "";              // result
		int idx1 = num.length() - 1;
		int idx2 = another.num.length() - 1;
		int carry = 0;

		while((idx1 >= 0) && (idx2 >= 0)){ //not reached the beginning of the either string
			int sum = (num.charAt(idx1) - '0') + (another.num.charAt(idx2) - '0') + carry; //add the two numbers
			r = sum % base + r; //tack on the 1's place to the result
			carry = sum / base; //if sum < 9, we have a carry

			idx1--;
			idx2--;
		}

		while(idx1 >= 0){ //not reached the beginning of the 1st string
			int sum = (num.charAt(idx1) - '0') + carry;
			r = sum % base + r;
			carry = sum / base;

			idx1--;
		}

		while(idx2 >= 0){ //not reached the beginning of the 2st string
			int sum = (another.num.charAt(idx2) - '0') + carry;
			r = sum % base + r;
			carry = sum / base;

			idx2--;
		}

		if(carry == 1){ //final carry
			r = carry + r;
		}
		return r;
	}

	/**
	 * Calculate the product of the current integer and another integer. The
	 * result is returned through a string
	 */
	String multiply(LargeInteger another) {
		// your code comes here
		String result = "";
		
		LargeInteger res1 = new LargeInteger("16526");
		LargeInteger res2 = new LargeInteger("2871");
		
		res1.add(res2);
		return result;
	}
}

public class Homework2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter two positive integers: ");
		LargeInteger int1 = new LargeInteger(in.nextLine());
		LargeInteger int2 = new LargeInteger(in.nextLine());
//		System.out.println(int1.num+" * "+int2.num+" = "+int1.multiply(int2));
		System.out.println(int1.add(int2));


	}

}
