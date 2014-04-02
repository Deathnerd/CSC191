/*
 * ------------------------------
 *	Course: CSC191
 *	Project: Homework 08
 *	Date: 4/11/13
 *	Author: George Gilleland
 *	..............................
 *	Purpose: This program will generate an n*n matrix with randomly generated integer elements with
 *	values of 0-49 inside a class called MyMatrix. The class will contain functions to perform printing,
 *	binary searching, sequential searching, insertion sort, selection sort, bubble sort, and check if
 * 	the array is sorted in non-descending sequential order.	It will also implement a user-friendly command-line
 * 	menu with which to interact with the program.
 *	------------------------------
 */
package homework08;

import java.util.Random;
import java.util.Scanner;

class MyMatrix {

	private int A[][];
	int size;

	MyMatrix() {
		A = new int[1][1];
		size = A.length;
	}

	MyMatrix(int s) {
		size = s;
		A = new int[size][size];
	}

	// Randomly generate a matrix in which every element is  // an integer between 0 and 49
	void randGenerate() {
		Random rand = new Random();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				A[i][j] = rand.nextInt(50);
			}
		}
	}

	// Display the matrix 
	public void print() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				System.out.printf("%2d ", A[i][j]);
			System.out.println();
		}
	}

	// Recursively sort the matrix
	// using the bubble sort algorithm 
	public void bubbleSort() {
		bubbleSort(size - 1, size - 1);
	}

	//done
	private void bubbleSort(int x, int y) {
		//x is column
		//y is row
		if (x == 0 && y == 0) return;

		for (int i = 0; i <= size - 1; i++) { //loop through the rows
			for (int j = 0; j <= size - 1; j++) { //loop through the columns
				if (i == y && j == x) { //if reached the end point of this run
					if (x == 0) { //reached the beginning of the row
						bubbleSort(size - 1, y - 1); //go to next row, last column
						return;
					} else {
						bubbleSort(x - 1, y);
						return;
					}
				}
				//Actual sorting
				if (j == size - 1) { //if reached the end of the row
					if (i == size - 1)
						break;
					if (A[i][j] > A[i + 1][0]) { //check on next row, first column
						int t = A[i][j];
						A[i][j] = A[i + 1][0];
						A[i + 1][0] = t;
					}
				} else {
					if (A[i][j] > A[i][j + 1]) {
						int t = A[i][j];
						A[i][j] = A[i][j + 1];
						A[i][j + 1] = t;
					}
				}
			}
		}
		bubbleSort(x - 1, y);
	}

	public int maxSub(int m) {
		int x = A[0][0];
		int index = 0;
		for (int i = 1; i < m; i++) {
			if (A[i / A.length][i % A.length] > x) {
				x = A[i / A.length][i % A.length];
				index = i;
			}
		}
		return index;
	}

	// Recursively sort the matrix 
	// using the selection sort algorithm 
	public void selectionSort() {
		selectionSort(size * size);
	}

	private void selectionSort(int len) {
		if (len == 1)
			return;

		int idx = maxSub(len);
		int t = A[idx / A.length][idx % A.length];
		A[idx / A.length][idx % A.length] = A[(len - 1) / A.length][(len - 1) % A.length];
		A[(len - 1) / A.length][(len - 1) % A.length] = t;

		selectionSort(len - 1);
	}

	// Recursively sort the matrix 
	// using the insertion sort algorithm 
	public void insertionSort() {
		insertionSort(size * size);
	}

	private void insertionSort(int len) {
		if (len == 1)
			return;

		insertionSort(len - 1);       //sort sublist A[0] - A[len-1]

		//insert A[len-1] into sorted list A[0] - A[len-2]
		int t = A[(len - 1) / A.length][(len - 1) % A.length];
		int i;
		for (i = len - 2; i >= 0; i--) {
			if (A[i / A.length][i % A.length] <= t)
				break;
			else
				A[(i + 1) / A.length][(i + 1) % A.length] = A[i / A.length][i % A.length];
		}

		A[(i + 1) / A.length][(i + 1) % A.length] = t;
	}

	// Recursively check whether the matrix 
	// has been sorted into non-decreasing order 
	public boolean isSortedNonDecreasing() {
		return isSortedNonDecreasing(0, 0);
	}

	//done
	private boolean isSortedNonDecreasing(int x, int y) {
		if (x == size - 1 && y == size - 1)
			return true;
		if (x == size - 1) { //if at the end of a row, check the next row's first element
			if (A[y][x] <= A[y + 1][0])
				return isSortedNonDecreasing(0, ++y);
		} else {
			if (A[y][x] <= A[y][x + 1])
				return isSortedNonDecreasing(++x, y);
		}
		return false;
	}

	// Recursively search for a key in the matrix 
	// using the sequential search algorithm 
	public int sequentialSearch(int key) {
		return sequentialSearch(key, 0, 0, 1);
	}

	//done
	private int sequentialSearch(int key, int x, int y, int count) {
		if (key == A[y][x]) return count;//if key is found
		if (x == size - 1 && y == size - 1 && key != A[y][x])
			return -1;//if at the end of the array and key is not found
		else {
			if (x == size - 1) return sequentialSearch(key, 0, ++y, ++count);//if at the end of the row
			else return sequentialSearch(key, ++x, y, ++count);
		}
	}

	// Recursively search for a key in the matrix
	// using the binary search algorithm
	public int binarySearch(int key) {
		if (!isSortedNonDecreasing()) {
			System.out.println("Matrix needs to be sorted first");
			return -1;
		}
		return binarySearch(key, 1, size * size);
	}

	private int binarySearch(int key, int start, int end) {
		//base case
		if (start > end)
			return -1;

		//general case
		int mid = (start + end) / 2;

		if (A[mid / A.length][mid % A.length] == key)
			return mid + 1;
		else if (A[mid / A.length][mid % A.length] > key)
			return binarySearch(key, start, mid - 1);
		else
			return binarySearch(key, mid + 1, end);
	}
}

public class Homework08 {

	public static void run() {
		Scanner in = new Scanner(System.in);
		MyMatrix matrix = new MyMatrix();
		while (true) {
			System.out.println("1. Generate matrix");
			System.out.println("2. Print matrix");
			System.out.println("3. Sort");
			System.out.println("4. Search");
			System.out.println("0. Quit");

			switch (in.nextInt()) {
				case 1:
					System.out.print("Enter the size of the array: ");
					matrix = new MyMatrix(in.nextInt());
					matrix.randGenerate();
					break;
				case 2:
					System.out.println("Printing current matrix:");
					System.out.println("========================");
					matrix.print();
					break;
				case 3:
					System.out.println("1. Bubble sort");
					System.out.println("2. Selection sort");
					System.out.println("3. Insertion sort");
					System.out.println("0. Back to main menu");

					switch (in.nextInt()) {
						case 1:
							System.out.println("Sorting matrix with bubble sort");
							matrix.bubbleSort();
							break;
						case 2:
							System.out.println("Sorting matrix with selection sort");
							matrix.selectionSort();
							break;
						case 3:
							System.out.println("Sorting matrix with insertion sort");
							matrix.insertionSort();
							break;
						case 0:
							System.out.println("Returning to main menu \n");
							break;
					}
					break;
				case 4:
					int pos;
					System.out.println("1. Sequential saerch");
					System.out.println("2. Binary Search");
					System.out.println("0. Back to main menu");

					switch (in.nextInt()) {
						case 1:
							System.out.print("Enter key to search for: ");
							pos = matrix.sequentialSearch(in.nextInt());
							System.out.println("Searching matrix with sequential search");
							if (pos == -1) {
								System.out.println("Key not found!");
							} else {
								System.out.println("Key found at (" + ((pos / matrix.size) + 1) + "," + ((pos % matrix.size)) + ")");
							}
							break;
						case 2:
							System.out.print("Enter a key to search for: ");
							pos = matrix.binarySearch(in.nextInt());
							System.out.println("Searching matrix with binary search");
							if (pos == -1) {
								System.out.println("Key not found!");
							} else {
								System.out.println("Key found at (" + ((pos / matrix.size) + 1) + "," + ((pos % matrix.size)) + ")");
							}
							break;
						case 0:
							System.out.println("Returning to main menu \n");
							break;
					}
					break;
				case 0:
					System.out.println("Exiting program");
					return;
				default:
					System.out.println("Invalid selection\n");
					break;
			}
		}
	}

	public static void main(String[] args) {
		run();
	}
}