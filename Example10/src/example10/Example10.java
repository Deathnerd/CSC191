/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example10;

import java.util.Scanner;

/**
 *
 * @author Deathnerd
 */
public class Example10 {

	/**
	 * @param args the command line arguments
	 */
	// reference to an object as the parameter
	public static void modifyArray(int B[]) {
		for (int i = 0; i < B.length; i++)
			B[i] *= 2;	// double every element
	}

	// primitive type as the parameter
	public static void modifyElement(int e) {
		System.out.print("modifyElement() changes " + e);	// original value
		e *= 2;
		System.out.println(" to " + e);						// new value
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int A[] = {1, 2, 3, 4, 5};

		System.out.print("Original array: ");
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
		System.out.println();

		modifyArray(A);

		System.out.print("Modified array: ");
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
		System.out.println('\n');

		for (int i = 0; i < A.length; i++)
			modifyElement(A[i]);

		System.out.print("Modified array by calling modifyElement(): ");
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println('\n');

		int x = 100;
		modifyElement(x);
		System.out.println("x=" + x);
	}

}
