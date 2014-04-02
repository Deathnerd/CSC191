/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example09;

import java.util.Scanner;
import java.util.Random;

class MyArray {

	private int A[];
	private int n;          // actual number of elements stored in the array

	MyArray(int ms) {
		A = new int[ms];
		n = 0;              // no values have been stored in the array yet
	}

	public void read() {
		Scanner input = new Scanner(System.in);
		int i = 0;
		int num;
		while (i < A.length) {
			System.out.print("Enter a positive integer(negative or 0 to stop): ");
			num = input.nextInt();
			if (num <= 0) {
				break;
			}

			A[i] = num;
			i++;
		}
		n = i;
	}

	void randGenerate() {
		Random rand = new Random();

		n = rand.nextInt(A.length + 1);        // [0, maxSize]
		for (int i = 0; i < n; i++) {
			A[i] = rand.nextInt(50);        // random integer in [0,9]
		}
	}

	public void print() {
		System.out.print("Elements are: ");
		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

	public int max() {
		return 1;
	}

	//find maximum from A[low} to A[n-1]
	int max(int low) {
		int maximum = max();

		if (low == n - 1) //base case
		{
			return A[low];
		}

		if (A[low] > maximum) //general case
		{
			return A[low];
		} else {
			return maximum;
		}
	}

	public void reverse() {
		reverse(0, n - 1);
	}

	public void reverse(int first, int last) {
		if (first >= last) {
			return;
		}

		int t = A[first];
		A[first] = A[last];
		A[last] = t;

		reverse(first + 1, last + 1);
	}

	public void sort() {
		Scanner input = new Scanner(System.in);
		int option;

		do {
			System.out.println("Select from:");
			System.out.println("1. bubble:");
			System.out.println("2. selection:");
			System.out.println("3. insertion:");
			System.out.println("4. back to main:");

			option = input.nextInt();

			switch (option) {
				case 1:
					bubbleSort();
					print();
					break;
				case 2:
					selectionSort();
					print();
					break;
				case 3:
					insertionSort();
					print();
					break;
				case 4:
					break;
				default:
					System.out.println("Invalid option!  Try it again: ");
			}
		} while (option != 4);
	}

	public void bubbleSort() {
		bubblesort(n);
	}

	public void bubblesort(int len) {
		if (len == 1) {
			return;
		}

		for (int i = 0; i < len - 1; i++) {
			if (A[i] > A[i + 1]) {
				int t = A[i];
				A[i] = A[i + 1];
				A[i + 1] = t;
			}
		}
		bubblesort(len - 1);
	}

	public int maxSub(int m) //find largest among A[0] - A[n] and return its index
	{
		int x = A[0];
		int index = 0;
		for (int i = 1; i <= m; i++) {
			if (A[i] > x) {
				x = A[i];
				index = i;
			}
		}

		return index;
	}

	public void selectionSort() {
		selectionSort(n);
	}

	public void selectionSort(int len) {
		if (len == 1)
			return;

		int idx = maxSub(len - 1);        //find highest number
		int t = A[idx];     //sorts list
		A[idx] = A[len - 1];
		A[len - 1] = t;

		selectionSort(len - 1);       //sort sublist
	}

	public void insertionSort() {
		insertionSort(n);
	}

	public void insertionSort(int len) {
		if (len == 1)
			return;

		insertionSort(len - 1);       //sort sublist A[0] - A[len-1]

		//insert A[len-1] into sorted list A[0] - A[len-2]
		int t = A[len - 1];
		int i;
		for (i = len - 2; i >= 0; i--) {
			if (A[i] <= t)
				break;
			else
				A[i + 1] = A[i];
		}

		A[i + 1] = t;
	}

	public boolean isSortedNonDecreasing() {
		return isSortedNonDecreasing(0);
	}

	public boolean isSortedNonDecreasing(int start) {
		//base case
		if (start == n - 1) {
			return true;
		}
		//general case
		return A[start] <= A[start + 1] && isSortedNonDecreasing(start + 1);
	}

	void search() {
		Scanner input = new Scanner(System.in);
		int option;
		int key, pos;

		do {
			System.out.println("Select from:");
			System.out.println("1. sequential:");
			System.out.println("2. binary:");
			System.out.println("3. back to main:");

			option = input.nextInt();

			switch (option) {
				case 1:
					System.out.println("Enter a key: ");
					key = input.nextInt();
					pos = sequentialSearch(key);
					if (pos == -1) {
						System.out.println("key not found");
					} else {
						System.out.println("Key found at " + pos);
					}
					break;
				case 2:
					if (!isSortedNonDecreasing()) {
						System.out.println("The array should be sorted first!");
					} else {
						System.out.println("Enter a key: ");
						key = input.nextInt();
						pos = binarySearch(key);
						if (pos == -1) {
							System.out.println("key not found");
						} else {
							System.out.println("Key found at " + pos);
						}
					}
					break;
				case 3:
					break;
				default:
					System.out.println("Invalid option!  Try it again: ");
			}

		} while (option != 3);
	}

	public int sequentialSearch(int key) {
		return sequentialSearch(key, 0);
	}

	/*
	 Search for the key among A[start] ~ A[n-1 and return the position of the key if it is found; otherwise return -1;
	 */
	public int sequentialSearch(int key, int start) {
		//general case
		if (A[start] == key) {
			return start;
		} else {
			return sequentialSearch(key, ++start);
		}
	}

	public int binarySearch(int key) {
		if (!isSortedNonDecreasing()) {
			System.out.println("Needs to be sorted");
			return -1;
		} else {
			return binarySearch(key, 0, n - 1);
		}
	}

	public int binarySearch(int key, int start, int end) {
		//base case
		if (start > end) {
			return -1;
		}

		//general case
		int mid = (start + end) / 2;

		if (A[mid] == key) {
			return mid;
		} else if (A[mid] > key) {
			return binarySearch(key, start, mid - 1);
		} else {
			return binarySearch(key, mid + 1, end);
		}
	}
}

public class Example09 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		Scanner input = new Scanner(System.in);

		int option;
		MyArray Ar = new MyArray(20);
		do {
			System.out.println("Select from:");

			System.out.println("1. Read Array:");
			System.out.println("2. Generate Array:");
			System.out.println("3. Print Array:");
			System.out.println("4. max:");
			System.out.println("5. reverse:");
			System.out.println("6. sort:");
			System.out.println("7. search:");
			System.out.println("0. Quit:");

			option = input.nextInt();

			switch (option) {
				case 1:
					Ar.read();
					break;
				case 2:
					Ar.randGenerate();
					break;
				case 3:
					Ar.print();
					break;
				case 4:
					Ar.max();
					break;
				case 5:
					break;
				case 6:
					Ar.sort();
					break;
				case 7:
					break;
				case 0:
					break;
				default:
					System.out.println("Invalid option!  Try it again: ");
			}

		} while (option != 0);

		System.out.println("Thanks for using my program.");
	}
}
