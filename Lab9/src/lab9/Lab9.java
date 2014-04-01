// ------------------------------
// Course: CSC191
// Project: Lab 9
// Date: 3/19/13
// Author: George Gilleland
// ..............................
// Purpose: This will implement a recursive method to generate a random set of numbers
// in array A[] with a max size of 20. This method will then cycle through A and push
// the values of A in a non-decreasing sequence, starting at the first element in A. 
// an array sizeB[] will contain the size of B[]
// ------------------------------
package lab9;

import java.util.Random;

class Recursive {

	int classB[];
	static int sizeB[] = new int[1];
	int positionA = 0;
	int positionB = 0;

	//helper method to make a resizedArray
	private int[] increaseSize(int B[]) {
		int C[] = new int[B.length + 1];
		for (int i = 0; i < B.length; i++) {
			C[i] = B[i];
		}
		B = C;
		return B;
	}

	void sequence(int A[], int sizeA, int B[], int sizeB[]) {
		//base case
		if(positionA == sizeA - 1) {
			return;
		}
		//general case
		if (B[B.length-1] <= A[positionA+1]){
			//increment counters
			positionA++;
			positionB++;
			//update the local variable
			B = increaseSize(B);
			B[positionB] = A[positionA];
			//update the accessor
			classB = increaseSize(classB);
			classB = B;
			sequence(A, sizeA, B, sizeB); //let's do the time warp again!
		} else {
			positionA++; //increment counter
			sequence(A, sizeA, B, sizeB); //it's just a jump to the left.... and then a step to the right!
		}
		sizeB[0] = classB.length; //update sizeB
		return; //exit
	}
}

public class Lab9 {

	public static void main(String[] args) {
		Recursive rec = new Recursive();
		Random rand = new Random();
		//construct arrays. A will have a length from 1-20
		int A[] = new int[rand.nextInt(20) + 1];
		int B[] = new int[1];

		for (int i = 0; i < A.length; i++) {
			A[i] = rand.nextInt(201);
		}
		B[0] = A[0];
		//print A[]
		System.out.print("A: ");
		for (int i = 0; i < A.length; i++) {
			System.out.printf("%d ", A[i]);
		}
		
		rec.classB = B; //update the class variable
		rec.sequence(A, A.length, B, rec.sizeB); //call the function
		B = rec.classB; //retrieve the array
		int sizeB = rec.sizeB[0]; //the size of B
		
		//print B[]
		System.out.print("\nB: ");
		for (int i = 0; i < B.length; i++) {
			System.out.printf("%d ", B[i]);
		}
		System.out.println("\nsizeB: "+sizeB);
	}
}
