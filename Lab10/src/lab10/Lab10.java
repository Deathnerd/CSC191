// ------------------------------
// Course: CSC191
// Project: Lab 10
// Date: 3/26/13
// Author: George Gilleland
// ..............................
// Purpose: This will implement a main Triangle class that will be extended by
// two classes: EulersTriangle and PascalsTriangle. These will respectively generate
// an Euler's Number Triangle and a Pascal's Number Triangle using user-defined height.
// The main method will contain a menu method that will handle user input and do 
// input quality checking to ensure proper operation of the program.
// ------------------------------
package lab10;

import java.util.Scanner;

class Triangle {

	private int width; // length of the base of a triangle 
	private int height; // height of a triangle 

	Triangle() {
		width = 0;
		height = 0;
	}

	Triangle(int h, int w) {
		width = w;
		height = h;
	}

	int getWidth() {
		return width;
	}

	int getHeight() {
		return height;
	}

	void print() {
		System.out.println("height=" + height + " width="+width);
	}
}
class PascalsTriangle extends Triangle{
	private int width;
	private int height;
	int T[][];
	
	PascalsTriangle(){
		width = super.getWidth();
		height = super.getHeight();
		T = new int[height][width];
	}
	PascalsTriangle(int h, int w){
		super(h, w);
		height = h;
		width = w;
		T = new int[height][width];
	}
	
	void generate(){
		int num = 0;
		for(int i = 0; i < T.length; i++){
			for(int j = 0; j <= i; j++){
				if(i==j || j==0){
					T[i][j]=1;
				} else {
					T[i][j]= T[i-1][j-1]+T[i-1][j];
				}
			}
		}
	}
	int getWidth(){
		return width;
	}
	
	int getHeight(){
		return height;
	}
	
	void print(){
		for(int i = 0; i < T.length; i++){
			for(int j=0; j<=i; j++){
				System.out.printf("%3d ", T[i][j]);
			}
			System.out.println();
		}
	}
}

class EulersTriangle extends Triangle{
	private int width;
	private int height;
	int T[][];
	
	EulersTriangle(){
		width = super.getWidth();
		height = super.getHeight();
		T = new int[height][width];
	}
	EulersTriangle(int h, int w){
		super(h, w);
		height = h;
		width = w;
		T = new int[height][width];
	}
	
	void generate(){
		int num = 0;
		for(int i = 0; i < T.length; i++){
			for(int j = 0; j <= i; j++){
				if(i==j || j==0){
					T[i][j]=1;
				} else {
					T[i][j]= (i-j+1)*(T[i-1][j-1])+((j+1)*T[i-1][j]);
				}
			}
		}
	}
	int getWidth(){
		return width;
	}
	
	int getHeight(){
		return height;
	}
	
	void print(){
		for(int i = 0; i < T.length; i++){
			for(int j=0; j<=i; j++){
				System.out.printf("%3d ", T[i][j]);
			}
			System.out.println();
		}
	}
}
public class Lab10 {

	/**
	 * @param args the command line arguments
	 */
	static void menu(){
		Scanner in = new Scanner(System.in);
		int height = 0;
		char c = ' '; //initialize a base case for selection. This will signify no valid triangle type selected
		//instantiate classes
		Triangle T = new Triangle();
		PascalsTriangle P = new PascalsTriangle();
		EulersTriangle E = new EulersTriangle();
		while(true){
			System.out.println();
			System.out.println("Choose from the following options:");
			System.out.println("1: Generate Triangle");
			System.out.println("2: Print Triangle");
			System.out.println("0: Exit");
			
			int n = in.nextInt();
			switch(n){
				case 0:
					return;
				case 1:
					System.out.println("Enter the height of the triangle: ");
					height = in.nextInt();
					if(height==0){
						System.out.println("Cannot have 0 height!");
						break;
					}
					System.out.println("Enter p for pascal's or e for Euler's: ");
					c = in.next().charAt(0);
					if(c == 'p'){
						System.out.println("Generating Pascal's Triangle");
						P = new PascalsTriangle(height, height);
						P.generate();
					} else if(c == 'e'){
						System.out.println("Generating Euler's Triangle");
						E = new EulersTriangle(height, height);
						E.generate();
					} else {
						System.out.println("Invalid selection");
						c = ' '; //reset the triangle selection
					}
					break;
				case 2:
					T = new Triangle(height, height);
					if(c == 'p' || c == 'e') { //not default case
						if(c == 'p'){
							System.out.println("Pascal's Triangle");
							T.print();
							P.print();
						} else if(c == 'e'){
							System.out.println("Euler's Triangle");
							T.print();
							E.print();
						}
					} else {
						System.out.println("No triangle type defined. Generate one first");
					}
					break;
				default:
					System.out.println("Invalid selection");
					break;
			}
		}
	}
	public static void main(String[] args) {
		// TODO code application logic here
		menu();
	}
}