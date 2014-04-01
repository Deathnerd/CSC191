/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example08;

import java.util.*;

class RecursiveMethods {

	static double pow1(double x, int n) {
		if (n == 0) {
			return 1;
		}
		return x * pow1(x, n - 1);
	}

	static double pow2(double x, int n) {
		if (n == 0) {
			return 1;
		}

		double t = pow2(x, n / 2);
		if (n % 2 == 1) {//n is odd
			return x * t * t;
		}
		return t * t;	//n is even
	}

	//n! = 1*2*3...*n
	static long factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	static int multiply(int a, int b) {
		if (b == 0) { //base case
			return 0;
		}
		return a + multiply(a, b - 1);	//general case
	}

	//Greatest Common Divisor using Euclid's Method
	static int gcdEuclid(int n1, int n2) {
		if (n2 == 0) {
			return n1;
		}
		return gcdEuclid(n2, n1 % n2);
	}
}

class NumberSeries {

	/*
	 *1/3 + 2/5 + 3/7 + ... + i/(2i+1)
	 */
	static float series1(int i) {
		if (i == 0) { //base case
			return 0;
		}
		return series1(i - 1) + (float) i / (float) (2 * i + 1);
	}

	/*
	 * 1 + 4 + 9 + 16 + ... + i^2
	 */
	static float series2(int i) {
		if (i == 0) {
			return 0;
		}
		return series2(i - 1) + i * i;
	}

	/*
	 * Generate the i-th number in the Fibonacci sequence
	 */
	static int fibonacci(int i) {
		if (i == 1 || i == 2) {
			return 1;
		}
		return fibonacci(i - 1) + fibonacci(i - 2);
	}
}

class MyPrint {

	static void printTriangle1(int n) {
		if (n > 0) { //base case
			//print the triangle with n-1 lines;
			printTriangle1(n - 1);
			//print the 1st row with n stars
			for (int i = 1; i <= n; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	/*
	 * *****
	 *  ****
	 *   ***
	 *    **
	 *     *
	 */
	static void printTriangle2(int n) {
		printTriangle2(n, 0);
	}

	/*
	 * n: number of lines in the triangle
	 * s: number of blank spaces at the beginning of the first line in a triangle
	 */
	static void printTriangle2(int n, int s) {
		if (n > 0) { //base condition
			//print s blank spaces
			for (int i = 1; i <= s; i++) {
				System.out.print(" ");
			}
			//print n stars and a line break
			for (int i = 1; i <= n; i++) {
				System.out.print("*");
			}
			System.out.println();
			//print the smaller triangle with (n-1) lines
			printTriangle2(n - 1, s + 1);
		}
	}

	static void printTriangle3(int n) {
		printTriangle3(n, 0);
	}

	static void printTriangle3(int n, int s) {
		if (n > 0) { //base condition
			//print the larger line of stars
			printTriangle3(n - 1, s + 1);
			//print s blank spaces
			for (int i = 1; i <= s; i++) {
				System.out.print(" ");
			}
			//print n stars and a line break
			for (int i = 1; i <= n; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	static void printNumber1(int n) {
		if (n > 0) {
			System.out.print(n % 10);
			printNumber1(n / 10);
		}
	}

	static void printNumber2(int n) {
		if (n >= 1) {
			System.out.print(n + " ");
			printNumber2(n - 1);
			System.out.print(n + " ");
		}
	}

	static void printChars1() {
		Scanner in = new Scanner(System.in);

		String next;
		System.out.print("Enter a character (* to stop)");
		next = in.next();

		if (next.charAt(0) != '*') {
			printChars1();
			System.out.print(next);
		}
	}
}

class MyString {

	boolean isPalindrome(String s) {
		return isPalindrome(s, 0, s.length() - 1);
	}

	boolean isPalindrome(String s, int low, int high) {
		//base case
		if (low >= high) //0 or 1 character in the string
		{
			return true;
		}
		//general case
		return s.charAt(low) == s.charAt(high) && isPalindrome(s, low + 1, high - 1);
	}

	String removeChar(String s, char c) {
		if (s.length() == 0) //if s.equals("")
		{
			return s; //return ""
		}		//general case
		if (s.charAt(0) != c) {
			return s.charAt(0) + removeChar(s.substring(1), c);
		} else {
			return removeChar(s.substring(1), c);
		}
	}

	class Expression {

		String e;           //expression that is to be evaluated

		Expression(String exp) {
			e = exp;
		}

		int evaluate() {
			return evaluate(e);
		}

		/*
		 * recursive method to evaluate an arithmetic expression
		 */
		int evaluate(String s) {
			//scan string from i to left
			int i;
			for (i = s.length() - 1; i >= 0; i--) {
				if (s.charAt(i) == '+' || s.charAt(i) == '-') {
					break;
				}
			}

			if (i < 0) {
				return Integer.parseInt(s);
			}

			//general case
			int result = evaluate(s.substring(0, i));

			switch (s.charAt(i)) {
				case '+':
					result += Integer.parseInt(s.substring(i + 1));
					break;
				case '-':
					result -= Integer.parseInt(s.substring(i + 1));
					break;
				case '*':
					result *= Integer.parseInt(s.substring(i + 1));
					break;
				case '/':
					result /= Integer.parseInt(s.substring(i + 1));
			}

			return result;
		}
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
			System.out.println("5. Number series(a)");
			System.out.println("6. Fibonacci(a)");
			System.out.println("7. PrintTriangle(a)");
			System.out.println("0. Quit");

			option = input.nextInt();
			switch (option) {
				case 0:
					break;
				case 1:
					System.out.println("2^6=" + RecursiveMethods.pow2(2, 6));
					break;
				case 2:
					System.out.println("5!=" + RecursiveMethods.factorial(5));
					break;
				case 3:
					System.out.println("5*4=" + RecursiveMethods.multiply(5, 4));
					break;
				case 4:
					System.out.println("GCD of 5 and 25 is " + RecursiveMethods.gcdEuclid(5, 25));
					break;
				case 5:
					System.out.println("series1(5) = " + NumberSeries.series1(5));
					System.out.println("series2(5) = " + NumberSeries.series2(5));
					break;
				case 6:
					System.out.println("Fibonacci(6) = " + NumberSeries.fibonacci(6));
					break;
				case 7:
					System.out.println("PrintTriangle1");
					MyPrint.printTriangle1(6);
					System.out.println();
					MyPrint.printTriangle2(6);
					System.out.println();
					MyPrint.printTriangle3(6);
					break;
				default:
					System.out.println("Invalid option!  Try it again: ");
					break;
			}
		} while (option != 0);

		System.out.println("Thanks for using my program.");
	}
}
