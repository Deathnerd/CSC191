/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example06;

/**
 *
 * @author yangm
 */
import java.util.Scanner;

public class Example06{

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args){
        // TODO code application logic here

		MySet ms1 = new MySet(50);
		ms1.read();
		ms1.print();

		MySet ms2 = new MySet(50);
		ms2.read();
		ms2.print();

		MySet is = ms1.intersection(ms2);
		is.print();

		MySet ds = ms1.difference(ms2);
		ds.print();

		MySet us = ms1.union(ms2);
		us.print();
	}
}

class MyListOperations{

	// bubble sort a list with size elements
	static void bubbleSort(int A[], int size){
		boolean swapped = false;

		for (int i = 1; i <= size - 1; i++) // at most (size-1) rounds
		{
			for (int j = 0; j <= size - i - 1; j++){
				if (A[j] > A[j + 1]){
					int t = A[j];
					A[j] = A[j + 1];
					A[j + 1] = t;
					swapped = true;
				}
			}

			if (!swapped) // already sorted
			{
				break;
			}

			swapped = false;    // get prepared for the next round
		}
	}

	// remove duplicated elements in a give list
	static int removeDuplicate(int A[], int size){
		bubbleSort(A, size);

        // Approach I: not very efficient because
		// it shift the list right every time a duplicate is found
        /*
		 int idx = 0;    // which element to check
		 while (idx < size - 1)
		{
		 if (A[idx] == A[idx+1])
		{
		 for (int i=idx; i<=size-2; i++)
		 A[i] = A[i+1];
		 size --;
		 }
		 else
		 idx ++;
		 }
		 */
		// Approach II: 
		int idx = 0;    // which element to check
		while (idx < size - 1){
			int i;
			for (i = idx + 1; i <= size - 1; i++){
				if (A[idx] != A[i]){
					break;
				}
			}

			// remove duplicated copies
			if (i != idx + 1) // duplicated copies exist
			{
				int numDuplicate = i - idx;

				// shift the array left
				int k = i;
				for (int j = idx + 1; j <= i - 1; j++){
					A[j] = A[k];
					k++;
					if (k == size){
						break;
					}
				}

				size = size - (numDuplicate - 1);
			}

			idx++;
		}
		return size;
	}

	static void print(int A[], int size){
		for (int i = 0; i < size; i++){
			System.out.printf("%d ", A[i]);
		}
		System.out.println();
	}
}

class MySet{

	int maxsize;        // allow at most maxsize elements in the set
	int S[];
	int size;           // current size of the set

	MySet(int m){
		maxsize = m;
		S = new int[maxsize];
	}

	void read(){
		System.out.print("Enter elements (-1 to end): ");
		Scanner input = new Scanner(System.in);
		int i;
		for (i = 0; i < maxsize; i++){
			int n = input.nextInt();
			if (n >= 0){
				S[i] = n;
			} else{
				break;
			}
		}
		size = i;

		size = MyListOperations.removeDuplicate(S, size);
	}

	void print(){
		MyListOperations.print(S, size);
	}

	// return the intersection set between the current set and set B
	MySet intersection(MySet B){
		MySet r = new MySet(Math.min(size, B.size));

		int idx = 0;
		for (int i = 0; i < size; i++) // traverse the current (1st) set
		{
			int j;
			for (j = 0; j < B.size; j++) // traverse the 2nd set
			{
				if (S[i] == B.S[j]){
					break;
				}
			}

			if (j < B.size){
				r.S[idx] = S[i];
				idx++;
			}
		}

		r.size = idx;
		System.out.println("r.size=" + r.size + "B.size=" + B.size);
		return r;
	}

	MySet difference(MySet B){
		MySet r = new MySet(size);

		int idx = 0;
		for (int i = 0; i < size; i++) // traverse the current (1st) set
		{
			int j;
			for (j = 0; j < B.size; j++) // traverse the 2nd set
			{
				if (S[i] == B.S[j]){
					break;
				}
			}

			if (j == B.size) // break statement is not executed
			{
				r.S[idx] = S[i];
				idx++;
			}
		}

		r.size = idx;
		return r;
	}

	MySet union(MySet B){
		MySet r = new MySet(size + B.size);

		for (int i = 0; i < size; i++){
			r.S[i] = S[i];
		}
		r.size = size;

		MySet d = B.difference(this);
		// d.print();
		for (int i = 0; i < d.size; i++){
			r.S[r.size] = d.S[i];
			r.size++;
		}

		return r;
	}

}
