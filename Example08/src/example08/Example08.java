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
}

public class Example08 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int option;
		do {
			System.out.println("\nSelect from:");
			System.out.println("1. Power(x, n)");
			System.out.println("0. Quit");

			option = input.nextInt();
			switch (option) {
				case 0:
					break;
				case 1:
					System.out.println("2^7="+RecursiveMethods.pow2(2,7));
					break;
				default:
					System.out.println("Invalid option!  Try it again: ");
			}
		} while (option != 0);

		System.out.println("Thanks for using my program.");
	}

}
