/*
 * ------------------------------
 *	Course: CSC191
 *	Project: Lab 12
 *	Date: 4/09/13
 *	Author: George Gilleland
 *	..............................
 *	Purpose: This program will take in a string and check if it is valid for having matching brackets in the proper order
 *	------------------------------
 */
package lab12;

import java.util.Scanner;

class MyStack<E> {
	private int size; //maximum size of the stack
	public E elements[];
	int top; //index of the top element;

	MyStack(int s) {
		size = s;
		elements = (E[]) new Object[size];
		top = -1; //empty stack
	}

	MyStack() {
		this(20);
	}

	//Return true if the stack is full
	boolean isFull() {
		return top == elements.length - 1;
	}

	//return true if stack be empty
	boolean isEmpty() {
		return top == -1;
	}

	void push(E item) {
		if (isFull())
			throw new RuntimeException("Stack is full. MyStack.push() fails");      //push failed

		top += 1;
		elements[top] = item;
	}

	//pop out the item on the stack and return it
	E pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty. MyStack.pop() fails");     //pop failed
		}

		E item = elements[top];
		top -= 1;
		return item;
	}

	E stackTop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty. MyStack.stackTop() fails");     //pop failed
		}

		return elements[top];
	}
}

public class Lab12 {

	public static void run() {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter a string with or without brackets");
		String inputString = in.nextLine();

		//check if there are any brackets at all
		if (inputString.indexOf('{') == -1 && inputString.indexOf('}') == -1 && inputString.indexOf('[') == -1 && inputString.indexOf(']') == -1 && inputString.indexOf('(') == -1 && inputString.indexOf(')') == -1) {
			System.out.printf("%s is legal", inputString);
			return;
		}
		//make new stack
		int size = inputString.length();
		MyStack<Character> s = new MyStack<Character>(size);
		for (int i = 0; i < inputString.length(); i++) { //push string to stack, character by character
			//check for beginning brackets
			if (inputString.charAt(i) == '[' || inputString.charAt(i) == '(' || inputString.charAt(i) == '{')
				s.push(inputString.charAt(i));
			else {
				//check if beginning and ending
				if (inputString.charAt(i) == ']' && (s.isEmpty() || s.pop() != '[' )){
					System.out.printf("%s is not legal", inputString);
					return;
				}else if (inputString.charAt(i) == '}' && (s.isEmpty() || s.pop() != '{' )){
					System.out.printf("%s is not legal", inputString);
					return;
				}else if (inputString.charAt(i) == ')' && (s.isEmpty() || s.pop() != '(' )){
					System.out.printf("%s is not legal", inputString);
					return;
				}
			}
		}
		if (s.isEmpty()) { //if the stack is empty when done looping through the string
			System.out.printf("\n%s is legal", inputString);
			return;
		}
		System.out.printf("\n%s is not legal", inputString);
		return;
	}

	public static void main(String[] args) {
		run();
	}
}
