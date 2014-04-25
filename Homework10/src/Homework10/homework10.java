package Homework10;

import java.util.Scanner;

/**
 * Created by Deathnerd on 4/20/2014.
 */

class Checks {
	public static boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}

	public static boolean isCaret(char c) {
		return c == '^';
	}

	public static boolean isOperator(char c) {
		return c == '-' || c == '+';
	}
}

class Term {
	private int key;    // key of the node. Key is the exponent
	private String data;    // data in the node. Data is the coefficient
	private Term next;    // reference to the successor

	Term(int k, String d) {
		key = k;
		data = d;
		next = null;
	}

	int getKey() {
		return key;
	}

	String getData() {
		return data;
	}

	Term getNext() {
		return next;
	}

	void setKey(int k) {
		key = k;
	}

	void setData(String d) {
		data = d;
	}

	void setNext(Term n) {
		next = n;
	}
}

// a linked list in which nodes are sorted in non-decreasing order of keys
class Polynomial {
	private Term head;
	public int length = 0;

	// Construct an empty linked list
	Polynomial() {
		head = null;
	}

	//print out the polynomial
	void print() {
		Helper helper = new Helper(null, head);
		Term current = helper.current;
		String polynomial = "";
		while (current != null) {
			polynomial += current.getData() + "x^" + current.getKey();
			helper.moveNext();
			current = helper.current;
		}
		System.out.print("The current polynomial is: " + polynomial);
		System.out.println();
	}

	// Search for the first node whose key is k
	// Return: references to the node and its predecessor, if k is found null if k is not found.
	Helper search(int k) {
		Helper hlp = new Helper(null, head);//search starts from  left to right

		Term curr = hlp.current;
		while (curr != null) {
			if (k == curr.getKey())
				return hlp;    //return the locations of the node and its predecessor

			hlp.moveNext();    //move to the next node in the list
		}
		return null;
	}

	// Insert a node (k, d) into the list
	void insert(int k, String d) {
		Helper helper = new Helper(null, head);

		while (helper.current != null) {
			if (k >= helper.current.getKey())
				break;

			helper.moveNext();
		}

		Term newTerm = new Term(k, d);
		if (helper.current != null && helper.current.getKey() == k) {
			helper.current.setKey(k);
			helper.current.setData(d);

		} else if (helper.previous == null) {       //new node should become the first in the list
			newTerm.setNext(head);
			head = newTerm;

		} else {
			helper.previous.setNext(newTerm);
			newTerm.setNext(helper.current);
		}
		length++;
	}

	//does polynomial addition
	boolean addition(int exponent, String coefficient) {
		Helper helper = new Helper(null, head);

		//move till we reach the place where the exponent should be
		while (helper.current != null) {
			if (exponent >= helper.current.getKey())
				break;

			helper.moveNext();
		}

		//do the operation on the corresponding exponent or insert
		if (helper.previous == null){
			head = new Term(exponent, coefficient);
			if(!Checks.isOperator(head.getData().charAt(0))){
				head.setData("+" + head.getData());
			}
			head.setNext(helper.current);
			return true;
		} else if (helper.current == null/* || helper.previous == null*/) {	//add to the end
			//if reached the end of the list, insert it
			insert(exponent, coefficient);
			return true;

		} else if (helper.current.getKey() == exponent) { //if exponents are equal
			int previousCoefficient = Integer.parseInt(helper.current.getData());
			int currentCoefficient = Integer.parseInt(coefficient);
			String newCoefficient = String.valueOf(previousCoefficient + currentCoefficient);

			//if the current coefficient is 0, remove it from the linked list
			if (Integer.parseInt(newCoefficient) == 0) {
				delete(helper.current.getKey());
				return true;
			}

			//check if positive. Need that sign
			if (!Checks.isOperator(newCoefficient.charAt(0))) {
				newCoefficient = "+" + newCoefficient;
			}
			//update the previous data
			helper.current.setData(newCoefficient);
			return true;

		} else { //insert between two terms
			insert(exponent, coefficient);
			return true;
		}
	}

	//does polynomial subtraction
	boolean subtraction(int exponent, String coefficient) {
		Helper helper = new Helper(null, head);

		//move till we reach the place where the exponent should be
		while (helper.current != null) {
			if (exponent >= helper.current.getKey())
				break;

			helper.moveNext();
		}

		//do the operation on the corresponding exponent or insert
		if (helper.previous == null){
			head = new Term(exponent, "" + Integer.parseInt(coefficient)*-1);
			if(!Checks.isOperator(head.getData().charAt(0))){
				head.setData("+" + head.getData());
			}
			head.setNext(helper.current);
			return true;
		} else if (helper.current == null/* || helper.previous == null*/) {	//add to the end
			//if reached the end of the list, insert it
			insert(exponent,"" + (Integer.parseInt(coefficient)*-1));
			return true;

		} else if (helper.current.getKey() == exponent) { //if exponents are equal
			int previousCoefficient = Integer.parseInt(helper.current.getData());
			int currentCoefficient = Integer.parseInt(coefficient);
			String newCoefficient = String.valueOf(previousCoefficient - currentCoefficient);

			//if the current coefficient is 0, remove it from the linked list
			if (Integer.parseInt(newCoefficient) == 0) {
				delete(helper.current.getKey());
				return true;
			}

			//check if positive. Need that sign
			if (!Checks.isOperator(newCoefficient.charAt(0))) {
				newCoefficient = "+" + newCoefficient;
			}
			//update the previous data
			helper.current.setData(newCoefficient);
			return true;

		} else { //insert between two terms
			coefficient = "" + (Integer.parseInt(coefficient) * -1);
			insert(exponent, coefficient);
			return true;
		}
		//return false;
	}

	// Delete the first node whose key is k from the list
	boolean delete(int k) {
		Helper hlp = search(k);

		if (hlp == null)
			return false;    //failed deletion

		final Term next = hlp.current.getNext();
		final Term prev = hlp.previous;

		if (prev != null)
			prev.setNext(next);

		else
			head = next;

		length--;
		return true;
	}
}

class Helper {
	Term previous;    //reference to the predecessor
	Term current;    //reference to the current Nodes

	Helper() {
		this(null, null);
	}

	Helper(Term p, Term c) {
		previous = p;
		current = c;
	}

	void set(Term p, Term c) {
		previous = p;
		current = c;
	}

	void moveNext() {
		if (current != null) {
			previous = current;
			current = current.getNext();
		}
	}
}


public class homework10 {
	public static void printMenu() {
		System.out.println("----------------");
		System.out.println("1: Read");
		System.out.println("2: Print");
		System.out.println("3: Add");
		System.out.println("4: Subtract");
		System.out.println("0: Exit");
		System.out.println("----------------");
		System.out.println();
	}

	public static void run() {
		Polynomial polynomial = new Polynomial();
		Scanner in = new Scanner(System.in);
		String coefficient = "";
		String s;
		boolean exponentExists = false;
		int exponent = 0;

		while (true) {
			printMenu();

			switch (in.nextInt()) {
				case 0:
					return;
				case 1:
					//build the new polynomial
					System.out.print("Enter a polynomial: (e.g., +4x^3+3x^2-5x^0): ");
					s = in.next();
					for (int i = 0; i < s.length(); i++) {
						if (Checks.isOperator(s.charAt(i))) {
							int j;
							String number = "" + s.charAt(i);
							for (j = i + 1; j < s.length() && Checks.isNumber(s.charAt(j)); j++) {
								number += "" + s.charAt(j);
							}
							coefficient = number;
							i = j - 1;
						}

						if (Checks.isCaret(s.charAt(i))) {
							int j = 0;
							String number = "";
							for (j = i + 1; j < s.length() && Checks.isNumber(s.charAt(j)); j++) {
								number += "" + s.charAt(j);
							}
							exponent = Integer.parseInt(number);
							i = j - 1;
							exponentExists = true;
						}
						//if there's an exponent and a coefficient that's non-zero, insert into the list at key = exponent
						if (exponentExists && Integer.parseInt(coefficient) != 0) {
							polynomial.insert(exponent, coefficient);
							exponentExists = false;
						}
					}
					break;
				case 2:
					//print the polynomial
					if (polynomial.length == 0) {
						System.out.println("No polynomial defined, please enter one\n");
						break;
					}
					polynomial.print();
					break;
				case 3:
					//addition
					System.out.print("Enter a polynomial: (e.g., +4x^3+3x^2-5x^0): ");
					s = in.next();
					for (int i = 0; i < s.length(); i++) {
						if (Checks.isOperator(s.charAt(i))) {
							int j;
							String number = "" + s.charAt(i);
							for (j = i + 1; j < s.length() && Checks.isNumber(s.charAt(j)); j++) {
								number += "" + s.charAt(j);
							}
							coefficient = number;
							i = j - 1;
						}

						if (Checks.isCaret(s.charAt(i))) {
							int j;
							String number = "";
							for (j = i + 1; j < s.length() && Checks.isNumber(s.charAt(j)); j++) {
								number += "" + s.charAt(j);
							}
							exponent = Integer.parseInt(number);
							i = j - 1;
							exponentExists = true;
						}
						//if there's an exponent and a coefficient that's non-zero, insert into the list at key = exponent
						if (exponentExists && Integer.parseInt(coefficient) != 0) {
							polynomial.addition(exponent, coefficient);
							exponentExists = false;
						}
					}
					break;
				case 4:
					System.out.print("Enter a polynomial: (e.g., +4x^3+3x^2-5x^0): ");
					s = in.next();
					for (int i = 0; i < s.length(); i++) {
						if (Checks.isOperator(s.charAt(i))) {
							int j;
							String number = "" + s.charAt(i);
							for (j = i + 1; j < s.length() && Checks.isNumber(s.charAt(j)); j++) {
								number += "" + s.charAt(j);
							}
							coefficient = number;
							i = j - 1;
						}

						if (Checks.isCaret(s.charAt(i))) {
							int j;
							String number = "";
							for (j = i + 1; j < s.length() && Checks.isNumber(s.charAt(j)); j++) {
								number += "" + s.charAt(j);
							}
							exponent = Integer.parseInt(number);
							i = j - 1;
							exponentExists = true;
						}
						//if there's an exponent and a coefficient that's non-zero, insert into the list at key = exponent
						if (exponentExists && Integer.parseInt(coefficient) != 0) {
							polynomial.subtraction(exponent, coefficient);
							exponentExists = false;
						}
					}
					break;
				default:
					System.out.println("Invalid input. Try again");
					break;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		run();
	}
}
