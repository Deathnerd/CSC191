/**
 * Course: CSC191, Spring 2014 
 * Project: Homework3 
 * Date: 2/11/2014 
 * Author: Wes Gilleland 
 * Purpose: A simple Tic-Tac-Toe game
 */
package homework3;

import java.util.Scanner;
import java.util.Random;

class TicTacToe {

	private final int size; // should be 3 
	private char S[][]; // a size*size array to represent the grid 
	private char winner;
	private int count = 1; //turn count

	// constructor 
	TicTacToe() {
		// your come comes here
		size = 3;
		S = new char[size][size];
		for (int i = 0; i < 3; i++) { //rows
			for (int j = 0; j < 3; j++) { //columns
				S[i][j] = '?';
			}
		}
	}

	// print the current content of the grid 
	void print() {
		System.out.println("\nGame board \n==========");
		for (int i = 0; i < 3; i++) { //rows
			for (int j = 0; j < 3; j++) { //columns
				System.out.printf("%c ", S[i][j]);
			}
			System.out.println();
		}
	}

	// your code comes here to implement other necessary methods 
	void placeToken(int x, int y) {
		//computer turn
		if (x == 4) {
			Random rand = new Random();
			boolean done = false;
			while (!done) {
				//generate the move
				x = rand.nextInt(3);
				y = rand.nextInt(3);
				if (S[x][y] == '?') { //if it is a blank space
					S[x][y] = 'C';
					done = true;
					count++;
					return;
				}
			}
		}
		//user turn
		if (S[x][y] != '?') { //if it's not a free space, have them try again
			System.out.println("Not a free space. Try again");
			Scanner in = new Scanner(System.in);
			String s = in.next();
			x = s.charAt(0) - '0';
			y = s.charAt(2) - '0';
			placeToken(x, y); //user turn
		}
		S[x][y] = 'U';
		count++;
	}

	boolean checkWin() {
		//rows and columns check
		for (int i = 0; i < 3; i++) {
			//rows
			if (S[i][0] != '?' && S[i][0] == S[i][1] && S[i][1] == S[i][2]) {
				winner = S[i][0];
				return true;
			}
			//columns
			if (S[0][i] != '?' && S[0][i] == S[1][i] && S[1][i] == S[2][i]) {
				winner = S[0][i];
				return true;
			}
		}
		//diagonals check
		//Top-left to Bottom-right check
		if (S[0][0] != '?' && S[0][0] == S[1][1] && S[1][1] == S[2][2]) {
			winner = S[0][0];
			return true;
		}

		//Bottom-left to Top-right check
		if (S[2][0] != '?' && S[2][0] == S[1][1] && S[1][1] == S[0][2]) {
			winner = S[1][1];
			return true;
		}
		return false;
	}

	//main function
	void play() {
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("Input coordinates (x,y) or q to exit");
			String s = in.next();
			if (s.charAt(0) == 'q' || s.charAt(0) == 'Q') { //check for exit condition
				System.out.println("\nThanks for playing!");
				return;
			}
			if (s.length() != 3 || s.charAt(0)-'0' > 2 || s.charAt(2)-'0' > 2) { //check for invalid input
				System.out.println("Invalid input. Input integer values of 0-2, in format x,y");
				continue;
			}
			int x = s.charAt(0) - '0';
			int y = s.charAt(2) - '0';
			placeToken(x, y); //user turn
			if (checkWin()) { //if the user won
				print();
				System.out.println(winner + " wins!");
				return;
			}
			if(count == 9){ //nobody won
				System.out.println("Nobody wins!");
				return;
			}
			placeToken(4, 4); //computer turn
			if (checkWin()) {
				print();
				System.out.println(winner + " wins!");
				return;
			}
			print();
		} while (true && count <= 9);
	}
}

public class Homework3 {

	public static void main(String[] args) {
		TicTacToe tic = new TicTacToe();
		tic.play();
	}

}