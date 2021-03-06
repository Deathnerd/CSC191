package example07;
// ------------------------------
// Course: CSC191
// Project: Example 07 - 2d Grid Array
// Date: 1/30/13
// Author: George Gilleland
// ..............................
// Purpose: This is a template of all your future programs
// ------------------------------

import java.util.Scanner;
import java.util.Random;

class PointList {

	double points[][];

	PointList(int len) {
		points = new double[len][2];

		Scanner input = new Scanner(System.in);
		for (int i = 0; i < len; i++) {
			System.out.print("Enter x and y coordinates of a poitn: ");
			points[i][0] = input.nextDouble(); //x
			points[i][0] = input.nextDouble(); //y
		}
	}

	double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	void findClosestPair() {
		int p1 = 0, p2 = 1; //assume that the closest pair are points p1 and p2
		double dist = distance(points[p1][0], points[p1][1], points[p2][0], points[p2][1]);

		for (int i = 0; i < points.length; i++) //traverse all possible points in the list
		{
			for (int j = i + 1; j < points.length; j++) { //traverse all points that have not been checked
				double d = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
				if (d < dist) { //if the current distance is smaller than our guess
					p1 = i;
					p2 = j;
					dist = d;
				}
			}
		}
		System.out.printf("The closest pair are (%.2f, $.2f) and (%.2f, %.2f)", points[p1][0], points[p1][1], points[p2][0], points[p2][1]);
	}
}

class Grid {

	private int maxSize = 4;
	private int A[][] = new int[maxSize][maxSize];

	// randomly set every element with 0 or 1
	public Grid(int size) {
		Random rand = new Random();

		maxSize = size;
		A = new int[maxSize][maxSize];
		for (int i = 0; i < A.length; i++) //rows
		{
			for (int j = 0; j < A[i].length; j++) { //elements in rows
				A[i][j] = rand.nextInt(10);
			}
		}
	}

	public void print() {
		for (int i = 0; i < A.length; i++) { //rows
			for (int j = 0; j < A[i].length; j++) { //elements in rows
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void check() { //check if a row has the same value throughout
		for (int i = 0; i < A.length; i++) { //rows
			int j;
			for (j = 0; j < A[i].length; j++) { //elements in rows
				if (A[i][0] != A[i][j]) //if row is not homogenus, then break
				{
					break;
				}
			}
			if (j == A[i].length) //if we successfully checked all rows, then all elements are homogenus
			{
				System.out.printf("All %d in row %d \n", A[i][0], i);
			}
		}
	}

	void circleWalk() {
		int numRows = maxSize, numCols = maxSize;
		int r = 0, c = 0; //start from the top left corner
		int flag = 0; //0:right 1:down 2:left 3:up

		while (numRows >= 0 || numCols >= 0) {
			if (flag == 0) { //walking to the right
				for (int i = 1; i <= numCols; i++) {
					System.out.printf("%d ", A[r][c]);
					c++;
				}
				r++;
				c--;
				numRows--;
			} else if (flag == 1) { //walking down
				for (int i = 1; i <= numRows; i++) {
					System.out.printf("%d ", A[r][c]);
					r++;
				}
				r--;
				c--;
				numCols--;
			} else if (flag == 2) { //walking left
				for (int i = 1; i <= numCols; i++) {
					System.out.printf("%d ", A[r][c]);
					c--;
				}
				r--;
				c++;
				numRows--;
			} else { //walking up
				for (int i = 1; i <= numRows; i++) {
					System.out.printf("%d ", A[r][c]);
					r--;
				}
				r++;
				c++;
				numCols--;
			}
			flag = (flag + 1) % 4;
			System.out.println();
		}
	}

	void zigzagWalk() {
		int flag = 0; //0: up 	1: down
		for (int i = 1; i <= maxSize * 2 - 1; i++) { //maxSize*2-1 segments in total
			int r, c; //A[r][c] is the cell that is currently accessed

			//inititalize r and c for the starting point of a segment
			if (flag == 0) {
				if (i < maxSize) {
					c = 0;
					r = i - 1;
				} else {
					r = maxSize - 1;
					c = i - maxSize;
				}
			} else {
				if (i <= maxSize) {
					r = 0;
					c = i - 1;
				} else {
					c = maxSize - 1;
					r = i - maxSize;
				}
			}
			//traverse every cell in a certain segment
			while (r >= 0 && c >= 0 && r <= maxSize - 1 && c <= maxSize - 1) {
				System.out.print(A[r][c] + " ");

				if (flag == 0) {
					r--;
					c++;
				} else {
					r++;
					c--;
				}
			}
			System.out.println();
			flag = (flag + 1) % 2;
		}
	}
}

public class Example07 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		Grid g1 = new Grid(input.nextInt());
		g1.print();
		System.out.println();
		g1.check();
		System.out.println();
		g1.circleWalk();
		g1.zigzagWalk();
	}
}
