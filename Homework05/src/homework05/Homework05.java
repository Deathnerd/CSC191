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
		
		//print first n+1 lines
		for(int i = 1; i<=s; i++)
			System.out.print("  ");
		System.out.println(n);
		
		//base condition
		if (n==0){
			//print first line of the second n+1 section and spaces
			for(int i = 1; i<=s; i++)
				System.out.print("  ");
			System.out.println(1);
			return 1; //base return
		}
		
		//factorial section 
		int t = PrintNumbers(n-1, s+1); //grab the last factorial
		for(int i = 1; i<=s; i++) //print the spaces
			System.out.print("  ");
		System.out.println(t*n); //print the current factorial
		
		return t*n; //return the current factorial up the chain
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a positive integer n where 0>=n>=10: ");
		PrintNumbers(in.nextInt());
	}
}
