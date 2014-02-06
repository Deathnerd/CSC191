// ------------------------------
// Course: CSC191
// Project: Example 07 - 2d Grid Array
// Date: 2/5/13
// Author: George Gilleland
// ..............................
// Purpose: This is a template of all your future programs
// ------------------------------
package lab4;
import java.util.Random;
class ChessBoard {

	private int size;
	private char A[][];
	private boolean columnsPlaced[];

	// construct a size by size chessboard and initialize 
	// all elements with character ‘X’ 
	ChessBoard(int s) {
		// your code 
		size = s;
		A = new char [size][size];
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				A[i][j] = 'X';
		columnsPlaced = new boolean [size];
	}

	// print the content of the chessboard 
	void print() {
		// your code 
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++)
				System.out.print(" "+A[i][j]+" ");
			System.out.println();
		}
	}

	// place queens on the chessboard by marking cells with ‘Q’ 
	// such that no two queens are on the same row or same column 
	void placeQueens() {
		// your code
		boolean placed = false;
		Random rand = new Random();
			//place the queens. Only places one queen per row
			for(int i = 0; i < size; i++) //rows
				for(int j = 0; j < size; j++){ //columns
					placed = false;
					if(!columnsPlaced[j]){ //if there's not a queen in the column
						boolean place = rand.nextBoolean();
						if(place){
							A[i][j] = 'Q';
							columnsPlaced[j] = true;
							break;
						}
					}
					if(j == size-1) //if end of row, return to beginning
						j = 0;
				}
	}

	// scan the chessboard by making counter clockwise circles, 
	// starting from the bottom-right corner 
	void circleScan() {
		// your code 
	}
}

public class Lab4 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		ChessBoard board = new ChessBoard(5);
		board.print();
		board.placeQueens();
		System.out.println();
		board.print();
	}

}
