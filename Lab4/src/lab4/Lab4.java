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
import java.util.Scanner;
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
		System.out.println();
	}

	// place queens on the chessboard by marking cells with ‘Q’ 
	// such that no two queens are on the same row or same column 
	void placeQueens() {
		// your code
		boolean placed = false;
		Random rand = new Random();
			//place the queens. Only places one queen per row
			for(int i = 0; i < size; i++){ //rows
				placed = false;
//				for(int j = 0; j < size; j++){ //columns
				while(!placed){
					int j = rand.nextInt(size);
					placed = false;
					if(!columnsPlaced[j]){ //if there's not a queen in the column
						boolean place = rand.nextBoolean();
						if(place){
							A[i][j] = 'Q';
							columnsPlaced[j] = true;
							placed = true;
							break;
						}
					}
				}
			}
	}

	// scan the chessboard by making counter clockwise circles, 
	// starting from the bottom-right corner 
	void circleScan() {
		// your code 
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
