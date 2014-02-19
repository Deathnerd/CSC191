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
	
	void zigzagWalk1() {
		int flag = 0; //0: up 	1: down
		for (int i = 1; i <= maxSize * 2 - 1; i++) { //maxSize*2-1 segments in total
			int r, c; //A[r][c] is the cell that is currently accessed

			//inititalize r and c for the starting point of a segment
			if (flag == 0) { //if we're moving up
				if (i < maxSize) {
					c = 0;
					r = i - 1;
				} else {
					r = maxSize - 1;
					c = i - maxSize;
				}
			} else { //if we're moving down
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

				if (flag == 0) { //move to the right one and up one
					r--; //move up
					c++; //move right
				} else { //move to the left one and down one
					r++; //move down
					c--; //move left
				}
			}
			System.out.println();
			flag = (flag + 1) % 2;
		}
	}
	
	//all examples for a 3x3 grid
	void zigzagWalk2(){
		int flag = 0; //0 is down, 1 is up
		
		for(int i = 1; i < maxSize*2-1; i++){ //2maxSize-1 segments
			int r, c; //start at the top right corner
			//if moving down and right
			if(flag == 0){
				if (i < maxSize) {

				} else {	

				}
			} else { //if moving up and left
				if (i <= maxSize) { //repeats twice
					
				} else {
					
				}
			}
			
			//traverse the segment
			//r >= 0 && c >= 0 keeps us above the lower bound of the array
			//r <= maxSize-1 && c <= maxSize-1 keeps us below the upper bound
			while(r >= 0 && c >=0 && r <= maxSize-1 && c <= maxSize-1){
				System.out.print(A[r][c]+ " ");
				if(flag == 0){ //moving down
					r++; //move to the right
					c++; //move down
				} else{ //moving up
					r--; //move left
					c--; //move up
				}
			}
			System.out.println();
			flag = (flag + 1) % 2;
		}
	}
	
	void zigzagWalk3(){
		int flag = 0; //0: left/up 1: down/down
        int cnt = 0; //cnt how many times a match is made
        int match = -1;
        for (int i = 1; i <= maxSize * 2 - 1; i++) {
            int r, c;
 
            if (flag == 0) {
                if (i < maxSize) {
                    c = maxSize - 1;
                    r = i - 1;
                    if (A[r][c] == match)
                        cnt++;
                    else {
//                       System.out.printf("(%2d, %2d)\n", match, cnt); 
                       match = A[r][c];
                       cnt = 1;
                    }
               } else {
                    c = 0;
                    r = i - maxSize;
                    if (A[r][c] == match)
                        cnt++;
                    else {
//                       System.out.printf("(%2d, %2d)\n", match, cnt); 
                       match = A[r][c];
                       cnt = 1;
                    }
                } 
                
            }
            else {
                if (i <= maxSize) {
                    r = i - 1;
                    c = maxSize-1;
                    if (A[r][c] == match)
                        cnt++;
                    else {
//                       System.out.printf("(%2d, %2d)\n", match, cnt); 
                       match = A[r][c];
                       cnt = 1;
                    }
                } else {
                    c = i - maxSize;
                    r = maxSize;
                    if (A[r][c] == match) 
                        cnt++;
                    else {
//                       System.out.printf("(%2d, %2d)\n", match, cnt);
                       match = A[r][c];
                       cnt = 1;
                    }
                }
            }
            while(r > 0 && c > 0 && r <= maxSize - 1 && c < maxSize - 1) {
				System.out.print(A[r][c]+" ");
                if (flag == 0) {
                    c--;
                    r--;
                    if (A[r][c] == match)
                        cnt++;
                    else {
//                       System.out.printf("(%2d, %2d)\n", match, cnt); 
                       match = A[r][c];
                       cnt = 1;
                    }
                } else {
                    c++;
                    r++;
                    if (A[r][c] == match)
                        cnt = 1;
                    else {
//                       System.out.printf("(%2d, %2d)\n", match, cnt); 
                       match = A[r][c];
                       cnt = 1;
                    }
                }
            }
            flag = (flag + 1) % 2;
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
//		walk.zigzagWalk1();
		System.out.println();
		walk.zigzagWalk2();
//		System.out.println();
//		walk.zigzagWalk3();
	}
}
