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
		if(denominator > numerator)
			return 0;
		else if((numerator - denominator) < denominator)
			return 1;
		else
			numerator -= denominator;
		
		return 1+divide(numerator, denominator);
	}
	
	static int mod(int numerator, int denominator){
		if(numerator < denominator)
			return numerator;
		else
			numerator -= denominator;
		
		return mod(numerator, denominator);
	}
}
public class Lab05 {
	public static void main(String[] args) {
		System.out.println(6/7);
		System.out.println(DM.divide(5,1));
		System.out.println(DM.mod(5, 2));
	}
}
