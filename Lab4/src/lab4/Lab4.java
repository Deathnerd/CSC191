// ------------------------------
// Course: CSC191
// Project: Lab 4 - The N Queens Problem
// Date: 2/5/13
// Author: George Gilleland
// ..............................
// Purpose: This will generate an NxN chessboard and randomly place N queens
// with no row or column containing more than one queen
// ------------------------------
package lab4;
import java.util.Random;
import java.util.Scanner;
class ChessBoard {

	private int size;
	private char A[][];
	private boolean columnsPlaced[];

	// construct a size by size chessboard and initialize 
	// all elements with character â€˜Xâ€™ 
	ChessBoard(int s) {
		// your code 
		size = s;
		A = new char [size][size];
		//fill the board with the character 'X'
		for(int i = 0; i < size; i++) //rows
			for(int j = 0; j < size; j++) //columns
				A[i][j] = 'X';
		columnsPlaced = new boolean [size];
	}

	// print the content of the chessboard 
	void print() {
		// your code 
		for(int i = 0; i < size; i++){ //rows
			for(int j = 0; j < size; j++) //columns
				System.out.print(" "+A[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}

	// place queens on the chessboard by marking cells with â€˜Qâ€™ 
	// such that no two queens are on the same row or same column 
	void placeQueens() {
		// your code
		boolean placed = false;
		Random rand = new Random();
			//place the queens. Only places one queen per row
			for(int i = 0; i < size; i++){ //rows
				placed = false; //has a queen been placed?
				while(!placed){ //keep trying till a queen is placed in the row
					int j = rand.nextInt(size); //pick a random spot on the row
					if(!columnsPlaced[j]){ //if there's not a queen in the column
						boolean place = rand.nextBoolean(); //flip a coin, basically
						if(place){ //should we place a queen?
							A[i][j] = 'Q';
							columnsPlaced[j] = true; //mark this column as occupied
							placed = true; //a queen has been placed
						}
					}
				}
			}
	}

	// scan the chessboard by making counter clockwise circles, 
	// starting from the bottom-right corner 
	void circleScan() {
		int numRows = size, numCols = size;
		int r = size-1, c = size-1; //start from the bottom right corner
		int flag = 0; //0:up, 1:left, 2:down, 3:right
		
		while(numRows >=0 || numCols >=0){
			if(flag == 0){ //walking up
				for(int i=1; i <= numRows; i++){
					System.out.printf(" %c", A[r][c]);
					r--;
				}
				r++;
				c--;
				numCols--;
			}
			else if(flag == 1){ //walking left
				for(int i=1; i <= numCols; i++){
					System.out.printf(" %c", A[r][c]);
					c--;
				}
				r++;
				c++;
				numRows--;
			}
			else if(flag == 2){ //walking down
				for(int i=1; i <= numRows; i++){
					System.out.printf(" %c", A[r][c]);
					r++;
				}
				r--;
				c++;
				numCols--;
			}
			else{ //walking right
				for(int i=1; i <= numCols; i++){
					System.out.printf(" %c", A[r][c]);
					c++;
				}
				r--;
				c--;
				numRows--;
			}
			flag = (flag+1)%4;
			System.out.println();
		}
	}
}

public class Lab4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a positive integer: ");
		ChessBoard board = new ChessBoard(in.nextInt());
		board.print();
		board.placeQueens();
		board.print();
		board.circleScan();
	}
}
