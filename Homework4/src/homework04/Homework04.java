package homework04;
import java.util.Scanner;

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
		// your code 
		A = new int [ms][ms];
		maxSize = ms;
		
		int c = 1;
		for(int i = 0; i < maxSize; i++){
			for(int j = 0; j < maxSize; j++){
				A[i][j] = c;
				c++;
			}
		}
	} 
 
  
	// print the content of the grid
	void print() {
		System.out.print("Grid:\n======");
		System.out.println();
		for(int i = 0; i < maxSize; i++){
			for(int j = 0; j < maxSize; j++)
				System.out.print(A[i][j]+" ");
			System.out.println();
		}
	}

	// zigzag scan the grid and do run-length coding 
	void runLengthCoding() {
		// your code 
	}

	// print the run-length coding result, i.e., content of rlc[][] 
	void printCodingResult() {
		// your code 
	}
}

public class Homework04 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter n (positive integer): ");
		Walk walk = new Walk(in.nextInt());
		
		walk.print();
	}
}
