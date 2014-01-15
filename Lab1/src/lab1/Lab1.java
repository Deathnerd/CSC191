/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab1;

import java.util.Scanner;
import java.util.Random;

/**
 * Course: CSC191, Spring 2014
 * Projet: Lab1
 * Date: 1/15/2014
 * Author: Wes Gilleland
 * Purpose: To practice using logical expressions and selection statements
 */
public class Lab1 {

	public static void main(String[] args) { 
 
		Scanner input = new Scanner(System.in); 
		Random rand = new Random(); 

		// randomly gererate a three-digit lottery number 
		// each digit is in the range between 0~9 
		int ld1 = rand.nextInt(10); 
		int ld2 = rand.nextInt(10); 
		int ld3 = rand.nextInt(10); 
		System.out.println("Three digits in the lottery number: " 
		+ ld1 + " " + ld2 + " " + ld3); 

		// prompt for user input 
		System.out.print("Enter three digits (0~9): "); 
		int ud1 = input.nextInt(); 
		int ud2 = input.nextInt(); 
		int ud3 = input.nextInt(); 
		
		System.out.println("Your input: "+ud1+" , "+ud2+" , "+ud3);
		
		//First prize: all 3 match in order
		if(ud1 == ld1 && ud2 == ld2 && ud3 == ld3){
			System.out.println("1st prize: three digits match in exact order");
			return;
		}
		//Third prize: 2 digits match in exact position
		else if((ud1 == ld1 && ud2 == ld2) || (ud2 == ld2 && ud3 == ld3) || (ud1 == ld1 && ud3 == ld3)){
			System.out.println("3rd prize: two digits match in exact order");
			return;
		}
		//Fifth prize: Only 1 digits match in exact position
		else if(ud1 == ld1 || ud2 == ld2 || ud3 == ld3){
			System.out.println("5th prize: one digit matches in exact position");
			return;
		}
		
		//bubble sort user input
		if (ud1 > ud2){
			int t = ud1;
			ud1 = ud2;
			ud2 = t;
		}
		if (ud2 > ud3){
			int t = ud2;
			ud2 = ud3;
			ud3 = t;
		}
		if(ud1 > ud2){
			int t = ud1;
			ud1 = ud2;
			ud2 = t;
		}
		
		//bubble sort lottery numbers
		if (ld1 > ld2){
			int t = ld1;
			ld1 = ld2;
			ld2 = t;
		}
		if (ld2 > ld3){
			int t = ld2;
			ld2 = ld3;
			ld3 = t;
		}
		if(ld1 > ld2){
			int t = ld1;
			ld1 = ld2;
			ld2 = t;
		}
		
		//Second prize: Match all 3 digits, but not in exact order
		if(ud1 == ld1 && ud2 == ld2 && ud3 == ld3){
			System.out.println("Second Prize: three digits match, but not in exact order");
		}
		//Fourth prize: Match two digits, but not in order
		else if((ud1 == ld1 && ud2 == ld2) || (ud2 == ld2 && ud3 == ld3) || (ud1 == ld1 && ud3 == ld3)){
			System.out.println("Third Prize: two digits match, but not in exact order");
		}
		//Sixth prize: Match one digit, but not in exact position
		else if(ud1 == ld1 || ud2 == ld1 || ud3 == ld1 || ud1 == ld2 || ud2 == ld2 || ud3 == ld2 || ud1 == ld3 || ud2 == ld3 || ud3 == ld3){
			System.out.println("Sixth Prize: one digit matches, but not in the exact position");
		}
		else{
			System.out.println("Sorry, you win nothing!");
		}
   }
}