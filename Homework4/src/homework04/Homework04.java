// ------------------------------
// Course: CSC191
// Project: Homework 5
// Date: 2/18/13
// Author: George Gilleland
// ..............................
// Purpose: This program will create an N*N grid and walk it in a zig-zag
// pattern while compressing the sequence using Run Length Coding
// ------------------------------
package homework04;

import java.util.Scanner;
import java.util.Random;

class Walk {

	private int maxSize;
	private int A[][];

	private int rlc[][];
	private int idx = 0;

	/* For i>=1, rlc[i] includes a value (0 or 1) and 
	 * its number of consecutive occurrences in the zigzag path. 
	 * 
	 * For example, given a grid 
	 * 1 0 1 
	 * 1 0 1 
	 * 1 1 1 
	 * 
	 * After the run-length coding, rls[][] should become: 
	 * -1 0 
	 * 1 2 
	 * 0 1 
	 * 1 1 
	 * 0 1 
	 * 1 4 
	 * and idx should equal 5 
	 * 
	 * rlc[0][0] is always set to -1 
	 */
	// Construct a maxSize by maxSize two dimensional array A and 
	// randomly set elements with numbers 0 and 1 
	Walk(int ms) {
		System.out.println(ms*ms);
		rlc = new int[ms * ms][2];
		A = new int[ms][ms];
		maxSize = ms;
		Random rand = new Random();

		for (int i = 0; i < maxSize; i++)
			for (int j = 0; j < maxSize; j++)
				A[i][j] = rand.nextInt(2);
		
		//set rlc
		//set the first value of rlc
		for(int i = 0; i <= ms*ms-1; i++){
			rlc[i][0] = -1;
			rlc[i][1] = 0;
		}
	}

	// print the content of the grid
	void print() {
		System.out.print("Grid:\n======");
		System.out.println();
		for (int i = 0; i < maxSize; i++) {
			for (int j = 0; j < maxSize; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}

	// zigzag scan the grid and do run-length coding 
	void runLengthCoding() {
		
		int last = -1;
		int count = 0;
		
		int flag = 0; //0 is down, 1 is up
		int m = 0;
		for (int i = 1; i <= maxSize * 2 - 1; i++) { //2maxSize-1 segments
			int r, c; //start at the top right corner
			//if moving down and right
			if (flag == 0) {
				if (i < maxSize) {
					c = maxSize - i;
					r = 0;
				} else {
					c = 0;
					r = i - maxSize;
				}
			} else { //if moving up and left
				if (i <= maxSize) { //repeats twice
					c = maxSize - 1;
					r = i - 1;
				} else {
					r = maxSize - 1;
					m += 2;
					if (maxSize % 2 == 0) { //dirty hack, but it works
						c = maxSize - flag - m;
					} else {
						c = maxSize - m;
					}
				}
			}
			//traverse the segment
			//r >= 0 && c >= 0 keeps us above the lower bound of the array
			//r <= maxSize-1 && c <= maxSize-1 keeps us below the upper bound
			while (r >= 0 && c >= 0 && r <= maxSize - 1 && c <= maxSize - 1) {
				if(last == -1){ //if this is the first run
					count++; //count the first one
//					last = A[r][c];
				}
				else if (last == A[r][c]){ //if the last element matches the current one
					count++;
				} else { //the last element doesn't match the current one
					//record the number of repetitions
					rlc[idx][0] = last;
					rlc[idx][1] = count;
					count = 0; //reset the counter
					idx++; //increment the index
				}
				System.out.print(A[r][c] + " ");
				last = A[r][c];
				if (flag == 0) { //moving down
					r++; //move to the right
					c++; //move down
				} else { //moving up
					r--; //move left
					c--; //move up
				}
			}
			
			System.out.println();
			flag = (flag + 1) % 2;
		}
	}

	// print the run-length coding result, i.e., content of rlc[][] 
	void printCodingResult() {
		int i = 1;
		while(rlc[i][0] != -1){
			System.out.printf("(%d,%d)\n", rlc[i][0], rlc[i][1]);
			i++;
		}
	}
}

public class Homework04 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter n (positive integer): ");
		Walk walk = new Walk(in.nextInt());

		walk.print();
		System.out.println("\n");
		walk.runLengthCoding();
		walk.printCodingResult();
	}
}
