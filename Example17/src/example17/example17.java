/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example17;

import java.util.Scanner;

public class example17 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int key;

		LinkedList L = new LinkedList();
		L.build();
		L.traverse();

		while (true) {
			System.out.println("Enter a key (-1 to stop) to be searched for: ");
			key = input.nextInt();
			if (key < 0) break;

			Helper hlp = L.search(key);

			if (hlp != null) {
				System.out.println("found data: " + hlp.curr.getKey() + " | " +
						hlp.curr.getData());

				System.out.println("Delete it (Y/y for yes): ");
				String option = input.next();
				if (option.equals("Y") || option.equals("y")) {
					L.delete(key);
					System.out.println("Node for key " + key + " has been deleted.");
				}
				L.traverse();
			} else
				System.out.println("Key is not found!");
		}

		LinkedList L2 = new LinkedList(L);
		L2.traverse();
	}
}

class Node {
	private int key;            // key of the node
	private String data;        // data in the node
	private Node next;          // reference to the successor

	Node(int k, String d) {
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

	Node getNext() {
		return next;
	}

	void setKey(int k) {
		key = k;
	}

	void setData(String d) {
		data = d;
	}

	void setNext(Node n) {
		next = n;
	}
}

// a linked list in which nodes are sorted in non-decreasing order of keys
class LinkedList {
	private Node head;

	// Construct an empty linked list
	LinkedList() {
		head = null;
	}

	// Construct a list and copy the content of nodes from another list src
	LinkedList(LinkedList src) {
		head = null;        //start with an empty list

		Helper hlpSrc = new Helper(null, src.head);
		Helper hlp = new Helper();

		while (hlpSrc.curr != null) {
			Node newNode = new Node(hlpSrc.curr.getKey(), hlp.curr.getData());
			hlpSrc.moveNext();

			//if the new node will become the first node
			if (head == null) {
				hlp.set(null, newNode);
				head = newNode;
			} else {
				hlp.curr.setNext(newNode);
				hlp.moveNext();
			}
		}
	}

	// Traverse list displaying keys and data
	void traverse() {
		Helper hlp = new Helper(null, head);
		while (hlp.curr != null) {
			System.out.print(hlp.curr.getKey() + " ");

			hlp.moveNext();
		}
		System.out.println();
	}

	// Search for the first node whose key is k
	// Return: references to the node and its predecessor, if k is found
	//         null if k is not found.
	Helper search(int k) {
		Helper hlp = new Helper(null, head);            //search starts from  left to right

		while (hlp.curr != null) {
			if (k == hlp.curr.getKey())
				return hlp;         //return the locations of the node and its predecessor

			hlp.moveNext();     //move to the next node in the list
		}
		return null;
	}

	// Insert a node (k, d) into the list
	void insert(int k, String d) {
		Helper hlp = new Helper(null, head);

		while (hlp.curr != null) {
			if (k <= hlp.curr.getKey())
				break;
			hlp.moveNext();
		}

		Node newNode = new Node(k, d);
		if (hlp.prev == null) {       //new node should become the first in the list
			newNode.setNext(head);
			head = newNode;
		} else {
			hlp.prev.setNext(newNode);
			newNode.setNext(hlp.curr);
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
			return false;           //failed deletion

		if (hlp.prev != null)
			hlp.prev.setNext(hlp.curr.getNext());
		else
			head = hlp.curr.getNext();

		return true;
	}
}

class Helper {
	Node prev;      //reference to the predecessor
	Node curr;      //reference to the current Nodes

	Helper() {
		this(null, null);
	}

	Helper(Node p, Node c) {
		prev = p;
		curr = c;
	}

	void set(Node p, Node c) {
		prev = p;
		curr = c;
	}

	void moveNext() {
		if (curr != null) {
			prev = curr;
			curr = curr.getNext();              //curr = curr.getNext();
		}
	}
}