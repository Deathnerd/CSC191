/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab2;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Course: CSC191, Spring 2014
 * Projet: Lab1
 * Date: 1/22/2014
 * Author: Wes Gilleland
 * Purpose: This program reads the height of a triangle (less than 10), draws it,
 * and rotates it 90 degrees, 180 degrees, and 270 degrees clockwise
 */
public class Lab2 {

	static class NumberTriangle{
		private int height; // height of the triangle (assume it’s always less than 14) 
		private int number = 1; //the number we're manipulating
		int numbers[];

		// Set the height with h  
		void setHeight(int h){
			height = h; 
			setArray();
		}
		
		 void setArray(){
			numbers = new int[height];
			
			for(int i = 0; i < height; i++){
				numbers[i] = number;
				number *= 2;
			}
			
		}

		// Draw the triangle 
		public void printTriangle(){
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
			
			for(int i = 0; i <= height; i++){ //rows loop
				//loop through the array backwards, and then forwards to print out the first row
				//do the same except you begin at the 2nd to last spot, and stop at the beginning
				//continue until you're left with the beginning
				System.out.printf("%-2d", numbers[i]);
			}
		}

		// Rotate the triangle 270 degrees clockwise and draw it 
		public void rotateTriangle270(){
			if(height <= 0) //check for no height
				return;
		}
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		System.out.println(11/2);
		
		NumberTriangle triangle = new NumberTriangle();
		
		System.out.print("Enter a height: ");
		int height = in.nextInt();
		
		triangle.setHeight(height);
		triangle.rotateTriangle180();
//		triangle.rotateTriangle90();
//		triangle.printTriangle();
	}
}
