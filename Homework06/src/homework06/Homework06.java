// ------------------------------
// Course: CSC191
// Project: Homework 6
// Date: 3/4/13
// Author: George Gilleland
// ..............................
// Purpose: This program will find the number of possible paths given an m*n grid
//			and print out the direction of the paths
// ------------------------------
package homework06;
import java.util.Scanner;

class GridPath {
 // Prints the total number of all possible paths and 
	// the steps in each path, using a recursive algorithm. 
	// Parameter “row” specifies the number of rows in 
	// the grid, and “col” specifies the number of columns 
	static int routes(int row, int col) {
		return routes(row, col, 1,1, "", ' ');
	}
	
	static int routes(int x, int y, int i, int j, String str, char dir){
		int count = 0; //initialize count variable to count the number of paths
		if(dir != ' '){ //if the direction isn't U or R
			str += dir; //append the direction to the string
		}
		if(i==x && j==y){ //if at the end of the path
			System.out.println(str); //print the path
			count++; //increment the count number
		} else if (i > x || j > y){
			return count; //return the count number
		} else{
			count += routes(x,y, i+1, j, str, 'U'); //next up iteration and increment the count
			count += routes(x,y, i, j+1, str, 'R'); //next right iteration and increment the count
		}
		return count; //return count... just to keep Java happy
	}
}

public class Homework06 {
	//run function
	static void run(){
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("Select from:");
			System.out.println("C or c: Find routes in a grid");
			System.out.println("Q or q: Quit");
			char choice = in.next().charAt(0);
			switch (choice){
				case 'C':
					System.out.print("Enter number of rows and columns: ");
					System.out.printf("\n There are %d paths in the grid",GridPath.routes(in.nextInt(), in.nextInt()));
					break;
				case 'c':
					System.out.print("Enter number of rows and columns: ");
					System.out.printf("\n There are %d paths in the grid",GridPath.routes(in.nextInt(), in.nextInt()));
					break;
				case 'Q':
					return;
				case 'q':
					return;
				default:
					System.out.println("Improper selection; try again!");
					break;
			}
		}
	}
	public static void main(String[] args) {
		run();
	}

}
