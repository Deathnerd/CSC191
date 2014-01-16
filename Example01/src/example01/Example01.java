/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example01;

/**
 * Course: CSC191, Spring 2014
 * Projet: Example01
 * Date: 1/14/2014
 * Author: Wes Gilleland
 * Purpose: Practice using selection structures
 */

import java.util.Scanner;
import java.util.Random;

public class Example01 {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		final int upperBound1 = 2, upperBound2 = 6, upperBound3 = 16;
		final double rate1 = 1.1, rate2 = 1.0, rate3 = 0.8, rate4 = 0.5;
		
		System.out.print("Enter the weight: ");
		double weight = Math.ceil(input.nextDouble()); //any part of a pound will be counted as a full pound
		
		double charge;
		if(weight <= upperBound1){
			charge = weight * rate1;
		}
		else if(weight <= upperBound2){
			charge = upperBound1 * rate1 + (weight - upperBound1) * rate2;
		}
		else if(weight <= upperBound3){
			charge = upperBound1 * rate1 + (upperBound2 - upperBound1) * rate2 + (weight - upperBound2) * rate3;
		}
		else{
			charge = upperBound1 * rate1 + (upperBound2 - upperBound1) * rate2 + (upperBound3 - upperBound2) * rate3 + (weight - upperBound3) * rate4;				
		}
		
		charge = (int)(charge*100);
		charge /= 100;
		
		System.out.printf("Charge = %.2f \n", charge);
		
//		if(a == b && b == c)
//			System.out.println("All of them are the same");
//		else if (a != b && b != c && a != c)
//			System.out.println("They are all unique (just like you!)");
//		else
//			System.out.println("Two are the same");
//		
		Random rand = new Random();
		int a = rand.nextInt(3)+1;
		int b = rand.nextInt(3)+1;
		int c = rand.nextInt(3)+1;
		
		System.out.println("A = "+a+", B = "+b+", C= "+c);
		
		//approach 1: based on unsorted list
		if(a == b && b == c)
			System.out.println("All are the same");
		else if(a == b || b == c || a == c)
			System.out.println("Only two are the same");
		else
			System.out.println("None are equal");
		
		//approach 2: based on sorted list
		//bubble sort
		if (a > b){
			int t = a;
			a = b;
			b = t;
		}
		if (b > c){
			int t = b;
			b = c;
			c = t;
		}
		if(a > b){
			int t = a;
			a = b;
			b = t;
		}
		
		if (a == c)
			System.out.println("All of them are the same");
		else if (a == b || b == c)
			System.out.println("Two of them are the same");
		else
			System.out.println("All are different");
	}
}
