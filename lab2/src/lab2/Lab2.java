/**
 * Course: CSC191, Spring 2014
 * Projet: Lab1
 * Date: 1/22/2014
 * Author: Wes Gilleland
 * Purpose: This program reads the height of a triangle (less than 10), draws it,
 * and rotates it 90 degrees, 180 degrees, and 270 degrees clockwise
 */
package lab2;
import java.util.Scanner;

public class Lab2 {

	static class NumberTriangle{
		private int height; // height of the triangle (assume it’s always less than 14) 

		// Set the height with h  
		void setHeight(int h){
			height = h; 
		}

		// Draw the triangle 
		public void printTriangle(){
			if(height <= 0) //check for no height
				return;
			
			for(int i = 0; i < height; i++){
				for(int j = 0; j < height-i; j++){ //print spaces
					System.out.printf("%-2s","");
				}
				int t = (int)Math.pow(2,i);
				for(int j = 0; j <= i; j++){ //print first half of the triangle
					System.out.printf("%-2d", t);
					t /=2;
				}
				
				t=2;
				//print the second half
				for(int j = 1; j <= i; j++){
					System.out.printf("%-2d", t);
					t*=2;
				}
				
				System.out.println();
			}
		}

		// Rotate the triangle 90 degrees clockwise and draw it 
		public void rotateTriangle90(){
			if(height <= 0) //check for no height
				return;
			
			int num = (int) Math.pow(2, height-1);
			int row = 1;
			int temp = num;
			
			while(row <= height){ //print half rows up to the 1's row
				for(int i = 1; i <= row; i++)
					System.out.print(temp+" ");
				System.out.println();
				row++;
				temp /= 2;
			}
			
			temp = 1;
			while(row <= (height*2-1)) { //print the other half
				temp *= 2;
				for(int i = 1; i<= (height*2-row); i++)
					System.out.print(temp+ " ");
				row++;
				System.out.println();
			}
		}

		// Rotate the triangle 180 degrees clockwise and draw it 
		public void rotateTriangle180(){
			if(height <= 0) //check for no height
				return;

			for(int i = 0; i < height; i++){ //print the rows
				for(int j = 0; j < i; j++)//print the spaces
					System.out.printf("%-2s", "");
				
				int t = (int)Math.pow(2,height-i-1); //give us our initial number
				for (int j = height-i; j > 0; j--){ //print the first half
					System.out.printf("%-2d", t);
					t /= 2;
				}
				t=2;
				
				for(int j=0; j < height-i-1; j++){ //print the second half
					System.out.printf("%-2d", t);
					t*=2;
				}
				System.out.println();
			}
		}

		// Rotate the triangle 270 degrees clockwise and draw it 
		public void rotateTriangle270(){
			if(height <= 0) //check for no height
				return;
			
			int n = 1;
			int num = (int) Math.pow(2, height-1);
			
			while (n < height){ //print the first rows up to the 2's
				for(int i = 1; i <= height-n; i++) //print spaces
					System.out.printf("%-2s", "");
				for(int i = 1; i <= n; i++) //print numbers
					System.out.printf("%-2d", num);
				System.out.println();
				n++;
				num /= 2;
			}
			
			num = 1;
			for(int i = 1; i <= height; i++) //print the 1's 
				System.out.printf("%-2d", num);
			
			System.out.println();
			num *= 2;
			n = height-1;
			
			while (n > 0){ //print the rest
				for(int i = height; i > n; i--)
					System.out.printf("%-2s", "");
				for(int i = 0; i < n; i++)
					System.out.printf("%-2d", num);
				System.out.println();
				num *= 2;
				n--;
			}
		}
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		NumberTriangle triangle = new NumberTriangle();
		
		System.out.print("Enter a height: ");
		int height = in.nextInt();
		
		triangle.setHeight(height);
		triangle.printTriangle(); //done
		triangle.rotateTriangle90(); // done
		triangle.rotateTriangle180(); //done
		triangle.rotateTriangle270(); // done
	}
}
