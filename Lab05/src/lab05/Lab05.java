/**
 * Course: CSC191, Spring 2014 
 * Project: Homework3 
 * Date: 2/12/2014 
 * Author: Wes Gilleland 
 * Purpose: A recursive implementation of mod and divide
 */
package lab05;
import java.util.Scanner;

class DM{
	static int divide(int numerator, int denominator){
		if(denominator > numerator) //if we have a decimal fraction
			return 0;
		else if((numerator - denominator) < denominator) //base case
			return 1;
		else //keep going
			numerator -= denominator;
		
		return 1+divide(numerator, denominator);
	}
	
	static int mod(int numerator, int denominator){
		if(numerator < denominator) //base case
			return numerator;
		else	//keep going
			numerator -= denominator;
		
		return mod(numerator, denominator);
	}
}
public class Lab05 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter two positive integers: ");
		int numerator = in.nextInt();
		int denominator = in.nextInt();
		System.out.println(numerator+" / "+denominator+" = "+DM.divide(numerator, denominator));
		System.out.println(numerator+" % "+denominator+" = "+DM.mod(numerator, denominator));
	}
}
