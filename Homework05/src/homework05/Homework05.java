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
	static int PrintNumbers(int n){
		System.out.println(n);
		if(n == 0){ //base case
			return 1;
		}
		return n*PrintNumbers(n-1);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a positive integer n where 0>n>10: ");
		PrintNumbers(in.nextInt());
	}
	
}
