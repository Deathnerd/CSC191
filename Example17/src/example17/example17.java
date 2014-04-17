package example17;

/**
 * Created by Deathnerd on 4/10/2014.
 */

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
	private Node head; //reference to first node

	// Construct an empty linked list
	LinkedList() {
		head = null;  //construct an empty linked list
	}

	// Construct a list and copy the content of nodes from another list src
	LinkedList(LinkedList src) {
		head = null;

		Helper helpSrc = new Helper(null, src.head);
		Helper help = new Helper();

		while(helpSrc.curr != null) {
			Node newNode = new Node(helpSrc.curr.getKey(), helpSrc.curr.getData());

			if (head == null) {
				help.set(null, newNode);
				head = newNode;
			} else {
				help.curr.setNext(newNode);
				help.moveNext();
			}
		}
	}

	// Traverse list displaying keys and data
	void traverse() {
		Helper help = new Helper(null, head);

		while(help.curr != null){
			System.out.println(help.curr.getKey());
			System.out.println(help.curr.getData());
			help.moveNext();
		}
		System.out.println();
	}

	// Search for the first node whose key is k
	// Return: references to the node and its predecessor, if k is found
	//         null if k is not found.
	Helper search(int k) {
		Helper help = new Helper(null, head);

		while(help.curr != null){
			if(k == help.curr.getKey()) return help; //return the location of the node and its predecessors

			help.moveNext(); //move to the next node in the list
		}
		return null;
	}

	// Insert a node (k, d) into the list
	void insert(int k, String d) {

	}

	// Read keys and data from user and build a linked list
	void build() {

	}

	// Delete the first node whose key is k from the list
	boolean delete(int k) {
		return false;
	}
}

class Helper {
	Node prev; //reference to the predecessor
	Node curr; //reference to the crrent node

	Helper(){
		this(null, null);
	}

	Helper(Node p, Node c){
		prev = p;
		curr = c;
	}

	void set(Node p, Node c){
		prev = p;
		curr = c;
	}

	void moveNext(){
		if(curr != null) {
			prev = curr;
			curr = prev.getNext(); //curr = curr.getNext()
		}
	}
}

public class example17 {

	public static void main(String[] args) {

	}
}
