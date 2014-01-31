package Example07;
// ------------------------------
// Course: CSC191
// Project: Example 07 - 2d Grid Array
// Date: 1/30/13
// Author: George Gilleland
// ..............................
// Purpose: This is a template of all your future programs
// ------------------------------

import java.util.Scanner;
import java.util.Random;

class PointList {
	double points[][];

	PointList(int len){
		points = new double[len][2];
		
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < len; i++){
			System.out.print("Enter x and y coordinates of a poitn: ");
			points[i][0] = input.nextDouble(); //x
			points[i][0] = input.nextDouble(); //y
		}
	}

	double distance(double x1, double y1, double x2, double y2){
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	void findClosestPair(){
	}
}

class Grid{

	private int maxSize = 4;
	private int A[][] = new int[maxSize][maxSize];

	// randomly set every element with 0 or 1
	public void rand_set(){
		Random rand = new Random();
	}

	public void print(){
	}

	public void check(){
	}
}

public class Example07{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
	}
}