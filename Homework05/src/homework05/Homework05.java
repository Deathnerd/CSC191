// ------------------------------
// Course: CSC191
// Project: Homework 5
// Date: 2/24/13
// Author: George Gilleland
// ..............................
// Purpose: This program will take an integer n and do the following operations
//			in one method PrintNumbers(int n):
//			
//			- Print (n+1)*2 lines, each of which includes a number
//
//			- Print numbers from n down to 0 in the first n+1 lines, with each line
//			  indented two more spaces than the line above
//
//			- Print numbers from 0! up to n! in the last n+1 lines, with each line
//			  indented two fewer spaces than the one above it except for the first line
// ------------------------------
package homework05;
import java.util.Scanner;

public class Homework05 {
	static void PrintNumbers(int n){
		PrintNumbers(n, 0);
	}
	
	static int PrintNumbers(int n, int s){
		
		//this block does the first block of n+1 numbers
		if (n >= 0){
			for(int i = 1; i<=s; i++){ //print spaces, 0, 1, 2, 3, ...
				System.out.print("  "); 
			}
			System.out.print(n+"\n");
			PrintNumbers(n-1, s+1);
		}
		//factorial
		if(n < 0){
			n = 0;
		}
		if(s >= 0){
			System.out.print(n*PrintNumbers(s-1, n+1));
		}
		return n;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a positive integer n where 0>n>10: ");
		PrintNumbers(in.nextInt());
	}
	
}
