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
		int p1 = 0, p2 = 1; //assume that the closest pair are points p1 and p2
		double dist = distance(points[p1][0], points[p1][1], points[p2][0], points[p2][1]);
		
		for(int i=0; i < points.length; i++) //traverse all possible points in the list
			for(int j=i+1; j < points.length; j++){ //traverse all points that have not been checked
				double d = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
				if (d < dist){ //if the current distance is smaller than our guess
					p1 = i; 
					p2 = j;
					dist = d;
				}
			}
		System.out.printf("The closest pair are (%.2f, $.2f) and (%.2f, %.2f)",points[p1][0], points[p1][1], points[p2][0], points[p2][1]);
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