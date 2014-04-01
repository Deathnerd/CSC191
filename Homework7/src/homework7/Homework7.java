// ------------------------------
// Course: CSC191
// Project: Homework 7
// Date: 3/20/14
// Author: George Gilleland
// ..............................
// Purpose: This program will take an arthmetic expression string and parse it
// ------------------------------
package homework7;
import java.util.Scanner;

class Expression {

	String e; // the expression, e.g., “20-4*5/2+99” 

	// set the expression with a given string exp 
	public void set(String exp) {
		e = exp;
	}

	// display the expression 
	public void print() {
		System.out.println(e);
	}

	//helper method
	public String add(String s) {
		String[] parts = s.split("\\+", 2);
		int right = 0;
		do {
			right++;
		} while (right < parts[1].length() && parts[1].charAt(right) >= '0');
		int val = Integer.parseInt(parts[0]) + Integer.parseInt(parts[1].substring(0, right));
		return val + parts[1].substring(right);
	}

	//helper method
	public String subtract(String s) {
		String[] parts = s.split("\\-", 2);
		int right = 0;
		do {
			right++;
		} while (right < parts[1].length() && parts[1].charAt(right) >= '0');
		int val = Integer.parseInt(parts[0]) - Integer.parseInt(parts[1].substring(0, right));
		return val + parts[1].substring(right);
	}

	//helper method
	public String multiply(String s) {
		String[] parts = s.split("\\*", 2);
		int right = 0;
		int left = parts[0].length();
		do {
			left--;
		} while (left != 0 && parts[0].charAt(left) >= '0');
		if (left != 0)
			left++;
		do {
			right++;
		} while (right < parts[1].length() && parts[1].charAt(right) >= '0');
		int val = Integer.parseInt(parts[0].substring(left)) * Integer.parseInt(parts[1].substring(0, right));
		return parts[0].substring(0, left) + val + parts[1].substring(right);
	}

	//helper method
	public String divide(String s) {
		String[] parts = s.split("\\/", 2);
		int right = 0;
		int left = parts[0].length();
		do {
			left--;
		} while (left != 0 && parts[0].charAt(left) >= '0');
		if(left != 0)
			left++;
		do {
			right++;
		} while (right < parts[1].length() && parts[1].charAt(right) >= '0');
		int val = Integer.parseInt(parts[0].substring(left)) / Integer.parseInt(parts[1].substring(0, right));
		return parts[0].substring(0, left) + val + parts[1].substring(right);
	}

	// evaluate the expression and return the result 
	public int evaluate() {
		return evaluateE(e);
	}

	// recursive method to evaluate an expression given by string s 
	public int evaluateE(String s) {
		//base case. If there are no operators
		if ((s.indexOf('*') == -1
				&& s.indexOf('/') == -1
				&& s.substring(1).indexOf('+') == -1
				&& s.substring(1).indexOf('-') == -1)) {
			return Integer.parseInt(s);
		} 

		int div = s.indexOf('/'), mult = s.indexOf('*');
		if (div != -1 || mult != -1) { //if there is division or multiplication
			if (div != -1 && (mult == -1 || mult > div)) {
				return evaluateE(divide(s));
			}
			if (mult != -1 && (div == -1 || div > mult)) {
				return evaluateE(multiply(s));
			}
		}
		int add = s.indexOf('+'), sub = s.indexOf('-');
		if (add != -1 || sub != -1) { //if there is addition or subtraction
			if (add != -1 && (sub == -1 || sub > add)) {
				return evaluateE(add(s));
			}
			if (sub != -1 && (add == -1 || add > sub)) {
				return evaluateE(subtract(s));
			}
		}
		return Integer.parseInt(s);
	}
}

public class Homework7 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Expression expr = new Expression();
		while(true){
			System.out.println("1. Read Expression (with operators + - * / only)");
			System.out.println("2. Print expression");
			System.out.println("3. Evaluate expression");
			System.out.println("4. Quit");
			
			int choice = in.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter expression: ");
					expr.set(in.next());
					break;
				case 2:
					expr.print();
					break;
				case 3:
					System.out.println(expr.evaluate());
					break;
				case 4:
					return;
				default:
					break;
			}
		}
	}

}
