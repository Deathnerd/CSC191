/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework08;

import java.util.Random;

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

	// Recursiely sort the matrix 
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
			if (A[i/A.length][i%A.length] > x) {
				x = A[i/A.length][i%A.length];
				index = i;
			}
		}
		return index;
	}

	// Recursively sort the matrix 
	// using the selection sort algorithm 
	public void selectionSort() {
		selectionSort(size*size);
	}

	private void selectionSort(int len) {
		if(len==1)
			return;

		int idx=maxSub(len);
		int t = A[idx/A.length][idx%A.length];
		A[idx/A.length][idx%A.length] = A[(len-1)/A.length][(len-1)%A.length];
		A[(len-1)/A.length][(len-1)%A.length] = t;

		selectionSort(len-1);
	}

	// Recursively sort the matrix 
	// using the insertion sort algorithm 
	public void insertionSort() {
		insertionSort(size*size);
	}

	private void insertionSort(int len){
		if (len == 1)
			return;

		insertionSort(len - 1);       //sort sublist A[0] - A[len-1]

		//insert A[len-1] into sorted list A[0] - A[len-2]
		int t = A[(len-1)/A.length][(len-1)%A.length];
		int i;
		for (i = len - 2; i >= 0; i--) {
			if (A[i/A.length][i%A.length] <= t)
				break;
			else
				A[(i+1)/A.length][(i+1)%A.length] = A[i/A.length][i%A.length];
		}

		A[(i+1)/A.length][(i+1)%A.length] = t;
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

	//helper method to make main function cleaner
	public int[] returnCoordinates(int x) {
		int B[] = new int[2];
		int row = (x / size) + 1;
		int column = x % size;
		if (column == 0) {
			column = size;
			row--;
			B[0] = column;
			B[1] = row;
			return B;
		}
		B[0] = column++;
		B[1] = row++;
		return B;
	}
}

// Recursively search for a key in the matrix
// using the binary search algorithm
//	public int binarySearch(int key) {
//	}


public class Homework08 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here

		MyMatrix matrix = new MyMatrix(3);
//		int x = 1;
//		while (x <= 10000) {
//			matrix.randGenerate();
//			matrix.bubbleSort();
//			if (!matrix.isSortedNonDecreasing()) {
//				System.out.println("FAILURE!");
//				return;
//			}
//			x++;
//		}
		matrix.randGenerate();
		int val = matrix.maxSub(9);
		matrix.print();
		System.out.println(val);
		matrix.insertionSort();
		matrix.print();
	}
}