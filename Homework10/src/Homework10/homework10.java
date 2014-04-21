package Homework10;

import java.util.Scanner;

/**
 * Created by Deathnerd on 4/20/2014.
 */
class Term {
	private int key;    // key of the node
	private String data;    // data in the node
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

	// Construct an empty linked list
	Polynomial() {
		head = null;
	}

	// Construct a list and copy the content of nodes from another list src
	Polynomial(Polynomial src) {
		head = null;    //start with an empty list

		Helper hlpSrc = new Helper(null, src.head);
		Helper hlp = new Helper();

		while (hlpSrc.curr != null) {
			Term newTerm = new Term(hlpSrc.curr.getKey(), hlp.curr.getData());
			hlpSrc.moveNext();

			//if the new node will become the first node
			if (head == null) {
				hlp.set(null, newTerm);
				head = newTerm;
			} else {
				hlp.curr.setNext(newTerm);
				hlp.moveNext();
			}
		}
	}

	// Traverse list displaying keys and data
	void traverse() {
		Helper hlp = new Helper(null, head);
		final Term curr = hlp.curr;
		while (curr != null) {
			System.out.print(curr.getKey() + " ");

			hlp.moveNext();
		}
		System.out.println();
	}

	// Search for the first node whose key is k
	// Return: references to the node and its predecessor, if k is found null if k is not found.
	Helper search(int k) {
		Helper hlp = new Helper(null, head);//search starts from  left to right

		final Term curr = hlp.curr;
		while (curr != null) {
			if (k == curr.getKey())
				return hlp;    //return the locations of the node and its predecessor

			hlp.moveNext();    //move to the next node in the list
		}
		return null;
	}

	// Insert a node (k, d) into the list
	void insert(int k, String d) {
		Helper hlp = new Helper(null, head);

		final Term curr = hlp.curr;
		while (curr != null) {
			if (k <= curr.getKey())
				break;
			hlp.moveNext();
		}

		Term newTerm = new Term(k, d);
		final Term prev = hlp.prev;
		if (prev == null) {    //new node should become the first in the list
			newTerm.setNext(head);
			head = newTerm;
		} else {
			prev.setNext(newTerm);
			newTerm.setNext(curr);
		}
	}

	// Read keys and data from user and build a linked list
	void build() {
		Scanner in = new Scanner(System.in);
		int k;
		String d;

		while (true) {
			System.out.print("Enter a key (negative to stop) and data: ");
			k = in.nextInt();
			if (k < 0)
				break;

			d = in.next();

			insert(k, d);
		}
	}

	// Delete the first node whose key is k from the list
	boolean delete(int k) {
		Helper hlp = search(k);

		if (hlp == null)
			return false;    //failed deletion

		final Term next = hlp.curr.getNext();
		final Term prev = hlp.prev;
		if (prev != null)
			prev.setNext(next);
		else
			head = next;

		return true;
	}
}

class Helper {
	Term prev;    //reference to the predecessor
	Term curr;    //reference to the current Nodes

	Helper() {
		this(null, null);
	}

	Helper(Term p, Term c) {
		prev = p;
		curr = c;
	}

	void set(Term p, Term c) {
		prev = p;
		curr = c;
	}

	void moveNext() {
		if (curr != null) {
			prev = curr;
			curr = curr.getNext();    //curr = curr.getNext();
		}
	}
}


public class homework10 {
	public static void main(String args[]) {

	}
}
