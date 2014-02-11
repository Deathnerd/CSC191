package homework3;

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
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				System.out.printf("%c ",S[i][j]);
	}

	// your code comes here to implement other necessary methods 
	void placeToken(int x, int y) {
		
		if(checkWin()){
			System.out.printf("Winner is %c", winner);
			return;
		}
	}

	boolean checkWin() {
		return false;
	}

}

public class Homework3 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
	}

}
