/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package example16;

import java.util.Scanner;

public class Example16 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		MyStack<Integer> stack = new MyStack<Integer>();

		while (true) {
			System.out.println("Enter an integer (negative to exit)");
			int item = input.nextInt();
			if (item < 0)
				break;

			try {
				stack.push(item);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();

		MyStack<Integer> bitStack = new MyStack<Integer>();
		System.out.print("\nEnter a decimal: ");
		int d = input.nextInt();
		int dd = d;

		while (d != 0) {
			bitStack.push(d % 2);
			d /= 2;
		}

		String b = "";
		while (!bitStack.isEmpty()) {
			b = b + bitStack.pop();
		}
		System.out.printf("decimal %d = binary %s \n", dd, b);
		System.out.println("Thanks for using the fucking program ho");
	}
}

class MyStack<E> {
	private int size; //maximum size of the stack
	E elements[];
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
			throw new RuntimeException("Stack is full. Push() fails");      //push failed

		top += 1;
		elements[top] = item;
	}

	//pop out the item on the stack and return it
	E pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty. Pop() fails");     //pop failed
		}

		E item = elements[top];
		top -= 1;
		return item;
	}

	E stackTop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty. StackTop() fails");     //pop failed
		}

		return elements[top];
	}
}