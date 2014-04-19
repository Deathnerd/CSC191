package lab13;

/**
 * Created by Deathnerd on 4/17/2014.
 */

import java.util.Scanner;

class Node {
	private int key;
	private String data;
	private Node next;

	Node(int ky, String dt) // constructor
	{
		key = ky;
		data = dt;
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

class LinkedList {
	private Node head; // reference of the first node
	public int length = 0;

	LinkedList() // Constructor for creating an empty list
	{
		head = null;
	}

	boolean insertAt(int key, String data, int index) {
		if(index < 0 || index > length){
			return false;
		}
		Node newNode = new Node(key, data);
		//if the list is empty
		if (index == 0){
			newNode.setNext(head);
			head = newNode;
			length++;
			return true;
		}
		Helper help = new Helper(null, head);
		//move forward till index is reached
		for(int i = 0; i < index; i++) {
			help.moveNext();
		}

		if(help.current != null){
			newNode.setNext(help.current);
			help.previous.setNext(newNode);
		} else {
			help.previous.setNext(newNode);
		}
		length++;
		return true;
	}

	// traverse the list and display keys and data
	void traverse() {
		Helper hlp = new Helper(null, head);
		while (hlp.current != null) {
			System.out.print(hlp.current.getKey() + " ");

			hlp.moveNext();
		}
		System.out.println();
	}

	boolean deleteAt(int index) {
		if(index < 0 || index >= length)
			return false;
		if(index == 0){
			head = head.getNext();
			length--;
			return true;
		}
		Helper help = new Helper(null, head);
		//move till index is reached
		for(int i = 0; i < index; i++)
			help.moveNext();

		help.previous.setNext(help.current.getNext());
		length--;
		return true;
	}
}

class Helper {
	Node previous;      //reference to the predecessor
	Node current;      //reference to the current Nodes

	Helper() {
		this(null, null);
	}

	Helper(Node p, Node c) {
		previous = p;
		current = c;
	}

	void set(Node p, Node c) {
		previous = p;
		current = c;
	}

	void moveNext() {
		if (current != null) {
			previous = current;
			current = previous.getNext();              //current = current.getNext();
		}
	}
}

public class lab13 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		LinkedList list = new LinkedList();
		while (true) {
			// print a menu of options
			System.out.println();
			System.out.println("1: addAt");
			System.out.println("2: removeAt");
			System.out.println("others: exit");

			// read user’s choice
			int option = input.nextInt();
			if (option != 1 && option != 2) {
				System.out.println("Quit");
				break;
			}

			// act based on user’s choice
			int key, index;
			String data;
			switch (option) {
				case 1:
					System.out.println("Enter key, data and index: ");
					key = input.nextInt();
					data = input.next();
					index = input.nextInt();

					if (!list.insertAt(key, data, index))
						System.out.println("Insertion failed.");
					else
						list.traverse();
					break;
				case 2:
					System.out.println("Enter index: ");
					index = input.nextInt();

					if (!list.deleteAt(index))
						System.out.println("Deletion failed.");
					else
						list.traverse();
					break;
			}
		}
	}
}