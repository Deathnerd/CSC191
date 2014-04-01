// ------------------------------
// Course: CSC191
// Project: Lab 8
// Date: 3/5/13
// Author: George Gilleland
// ..............................
// Purpose: This program will take a postfix notation equation and evaluate it
//			with a recursive function
// ------------------------------
package lab8;
import java.util.Scanner;

class PostFix{
	private String expr[];
	private int size;
	
	PostFix(String expression){
		if(expression.length() < 3){ //enforce a minimum size
			System.out.println("The expression is not of sufficient length. Exiting program");
			System.exit(1); //exit the program
		}
		expr = new String[expression.length()];
		
		//construct expression the array
		for(int i = 0; i < expression.length(); i++){
			expr[i] = Character.toString(expression.charAt(i));
		}
		size = expr.length;
	}
	String evaluate(){
		return evaluate(expr, size);
	}
	
	String evaluate(String expression[], int s){
		if(s < 2) //base case
			return "";
		int position; //current position in the overall equation
		
		//get the divisor
		for(position = 0; position < expression.length; position++){
			char c; //character we're gonna compare
			
			//this block takes care of negative numbers
			if(expression[position].length() == 1)
				c = expression[position].charAt(0); 
			else
				c = expression[position].charAt(1);
			
			if(c == '-' || c == '*' || c == '+' || c == '/') //if it's a divisor
				break; //got the position of the divisor
		}
		
		int x = 0; //holds operation result
		String s1; //holds the first value to operate on
		String s2; //holds the second value to operate on
		
		//check if it's an operator
		switch(expression[position].substring(0,1)){
			case "+":
				s1 = expression[position - 2];
				s2 = expression[position - 1];
				x = (Integer.parseInt(s1)+Integer.parseInt(s2));
				expression[position - 2] = Integer.toString(x); //store the result in the first element
				break;
			case "-": //subtracting
				s1 = expression[position - 2];
				s2 = expression[position - 1];
				x = (Integer.parseInt(s1)-Integer.parseInt(s2));
				expression[position - 2] = Integer.toString(x); //store the result in the first element
				break;
			case "*": //multiplying
				s1 = expression[position - 2];
				s2 = expression[position - 1];
				x = (Integer.parseInt(s1)*Integer.parseInt(s2));
				expression[position - 2] = Integer.toString(x); //store the result in the first element
				break;
			case "/": //dividing
				s1 = expression[position - 2];
				s2 = expression[position - 1];
				if(s1.charAt(0) == '0' || s2.charAt(0) == '0'){ //division by zero check
					System.out.println("Cannot divide by zero. Exiting program");
					System.exit(1); //quit the program
				}
				x = (Integer.parseInt(s1)/Integer.parseInt(s2));
				expression[position - 2] = Integer.toString(x); //store the result in the first element
				break;
		}
		//shift the values
		for(int i = position; i < s-1; i++)
			expression[i-1] = expression[i+1];
		
		evaluate(expression, s-2); //recursion! Let's do the time warp again!
		return expression[0]; //return the result
	}
}

public class Lab8 {	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a postfix equation: ");
		PostFix pf = new PostFix(in.next());
		System.out.printf("The result is: %s \n", pf.evaluate());
	}
	
}
