/**
 * Course: CSC191, Spring 2014 
 * Projet: Homework3 
 * Date: 2/11/2014 
 * Author: Wes Gilleland 
 * Purpose: A simple Tic-Tac-Toe game
 */
package homework3;

import java.util.Scanner;

class TicTacToe {

	private int size; // should be 3 
	private char S[][]; // a size*size array to represent the grid 
	private char winner;

	final static char user = 'U'; // used by user to mark a cell 
	final static char computer = 'C';//used by computer to mark a cell 

	// constructor 
	TicTacToe() {
		// your come comes here
		size = 3;
	}

	// print the current content of the grid 
	void print() {
		// your come comes here 
		for (int i = 0; i < 3; i++) { //rows
			for (int j = 0; j < 3; j++) { //columns
				System.out.printf("%c ", S[i][j]);
			}
		}
	}

	// your code comes here to implement other necessary methods 
	void placeToken(int x, int y) {

		if (checkWin()) {
			System.out.printf("Winner is %c", winner);
			return;
		}
	}

	boolean checkWin() {
		//rows check
		boolean win = false;
		for (int i = 0; i < 3; i++) { //rows
			for (int j = 0; j < 3; j++) { //columns
			}
		}
		return false;
	}

}

public class Homework3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	}

}
