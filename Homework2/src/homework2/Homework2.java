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
	final int base = 10;        // for decimal numbers
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
		String multiplicand = num;
		String multiplier = another.num;
		String result = "";
		String r = "";
		LargeInteger r1 = new LargeInteger("0");
		int carry = 0;
		int m = 1; //the multiplier for our resultant numbers.... may not need it
		
		int multiplierIndex = another.num.length()-1;
		
		//for each number in the multiplier
		while(multiplierIndex >= 0){
			int multiplicandIndex = num.length()-1;
			while(multiplicandIndex >= 0){	//for each number in the multiplicand
				int product = (multiplier.charAt(multiplierIndex)-'0') * (multiplicand.charAt(multiplicandIndex)-'0');
				r = product % base + carry + r; //tack on the 1's and the leftover carry
				carry = product / base; //do we have a carry?
				multiplicandIndex--;
			}
			for(int i = 1; i < m; i++)
				r += "0";
			m++; //increase the multiplier
			
			if(carry != 0) //if there is a carry
				r = carry + r; //add the carry to the beginning of the string
			
			LargeInteger r2 = new LargeInteger(r);
			result = r1.add(r2);
			multiplierIndex--;
			r1.num = result;
			r = "";
		}
		
		return result;
	}
}

public class Homework2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter two positive integers: ");
		LargeInteger int1 = new LargeInteger(in.nextLine());
		LargeInteger int2 = new LargeInteger(in.nextLine());
		System.out.println(int1.num+" * "+int2.num+" = "+int1.multiply(int2));
		System.out.println(int1.add(int2));
	}
}