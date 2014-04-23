package Homework10;

/**
 * Created by Deathnerd on 4/20/2014.
 */
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

	// Construct a list and copy the content of nodes from another list src
	Polynomial(Polynomial src) {
		head = null;    //start with an empty list

		Helper hlpSrc = new Helper(null, src.head);
		Helper hlp = new Helper();

		while (hlpSrc.current != null) {
			Term newTerm = new Term(hlpSrc.current.getKey(), hlp.current.getData());
			hlpSrc.moveNext();

			//if the new node will become the first node
			if (head == null) {
				hlp.set(null, newTerm);
				head = newTerm;
			} else {
				hlp.current.setNext(newTerm);
				hlp.moveNext();
			}
		}
	}

	// Traverse list displaying keys and data
	void traverse() {
		Helper helper = new Helper(null, head);
		Term current = helper.current;
		while (current != null) {
			System.out.print(current.getKey() + " ");
			helper.moveNext();
			current = helper.current;
		}
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

//	// Insert a node (k, d) into the list at position k
//	boolean insertAt(int key, String data, int index) {
//		if(index < 0){
//			return false;
//		}
//		Term newTerm = new Term(key, data);
//		//if the list is empty
//		if (index == 0){
//			newTerm.setNext(head);
//			head = newTerm;
//			length++;
//			return true;
//		}
//		Helper help = new Helper(null, head);
//		//move forward till index is reached
//		for(int i = 0; i < index; i++) {
//			help.moveNext();
//		}
//
//		if(help.current != null){
//			newTerm.setNext(help.current);
//			help.previous.setNext(newTerm);
//		} else if(help.previous != null){
//			help.previous.setNext(newTerm);
//		} else {}
//		length++;
//		return true;
//	}

	// Insert a node (k, d) into the list
	void insert(int k, String d) {
		Helper hlp = new Helper(null, head);

		while (hlp.current != null) {
			if (k >= hlp.current.getKey())
				break;
			hlp.moveNext();
		}

		Term newTerm = new Term(k, d);
		if (hlp.previous == null) {       //new node should become the first in the list
			newTerm.setNext(head);
			head = newTerm;
		} else {
			hlp.previous.setNext(newTerm);
			newTerm.setNext(hlp.current);
		}
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
			current = current.getNext();    //current = current.getNext();
		}
	}
}


public class homework10 {
	public static boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}

	public static boolean isCaret(char c) {
		return c == '^';
	}

	public static boolean isOperator(char c) {
		return c == '-' || c == '+';
	}

	public static void main(String[] args) throws java.lang.Exception {
		Polynomial polynomial = new Polynomial();
		String s = "-33x^3+243x^41+3x^789";
//		String s = "-33x^3";
		System.out.println(s.length());
		System.out.println(s.charAt(0));
		int sum = 0;
		String coefficient = "";
		boolean exponentExists = false;
		int exponent = 0;
		for (int i = 0; i < s.length(); i++) {
			if (isOperator(s.charAt(i))) {
				int j = 0;
				String number = "" + s.charAt(i);
				for (j = i + 1; isNumber(s.charAt(j)) && j < s.length(); j++) {
					number += "" + s.charAt(j);
				}
				System.out.println("Coefficient = " + number);
				coefficient = number;
				i = j - 1;
			}
			if (isCaret(s.charAt(i))) {
				int j = 0;
				String number = "";
				for (j = i + 1; j < s.length() && isNumber(s.charAt(j)); j++) {
					number += "" + s.charAt(j);
				}
				System.out.println("Exponent =  " + number);
				exponent = Integer.parseInt(number);
				i = j - 1;
				exponentExists = true;
			}
			//if there's an exponent and a coefficient that's non-zero, insert into the list at key = exponent
			if (exponentExists && Integer.parseInt(coefficient) != 0) {
//				if(!polynomial.insert(exponent, coefficient)) {
//					System.out.println("Insertion failed");
//				}
				polynomial.insert(exponent, coefficient);
				exponentExists = false;
			}
		}
		polynomial.traverse();
	}
}
