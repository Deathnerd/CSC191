/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example08;

import java.util.*;

class RecursiveMethods {

	static double pow1(double x, int n){
		if(n==0)
			return 1;
		else
			return x*pow1(x, n-1);
	}
	
	static double pow2(double x, int n){
		if(n==0)
			return 1;
		
		double t = pow2(x, n/2);
		if(n%2 == 1){ //n is odd
			return x*t*t;
		}
		else //n is even
			return t*t;
	}

	//n! = 1*2*3...*n
	static long factorial(int n){
		if(n==1)
			return 1;

		return n * factorial(n-1);
	}

	static int multiply(int a, int b){
		if(b==0)	//base case
			return 0;
		return a + multiply(a, b-1);	//general case
	}

	//Greatest Common Divisor using Euclid's Method
	static int gcdEuclid(int n1, int n2){
		if (n2 == 0)
			return n1;
		
		return gcdEuclid(n2, n1%n2);
	}
}

public class Example08 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int option;
		do {
			System.out.println("\nSelect from:");
			System.out.println("1. Power(x, n)");
			System.out.println("2. Factorial(n)");
			System.out.println("3. Multiply(a, b)");
			System.out.println("4. GCD(a, b)");
			System.out.println("0. Quit");

			option = input.nextInt();
			switch (option) {
				case 0:
					break;
				case 1:
					System.out.println("2^6="+RecursiveMethods.pow2(2,6));
					break;
				case 2:
					System.out.println("5!="+RecursiveMethods.factorial(5));
					break;
				case 3:
					System.out.println("5*4="+RecursiveMethods.multiply(5,4));
					break;
				case 4:
					System.out.println("GCD of 5 and 25 is "+RecursiveMethods.gcdEuclid(5, 25));
					break;
				default:
					System.out.println("Invalid option!  Try it again: ");
			}
		} while (option != 0);

		System.out.println("Thanks for using my program.");
	}
}
