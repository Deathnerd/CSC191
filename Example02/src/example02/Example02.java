/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example02;

/**
 *
 * @author Deathnerd
 */

import java.util.Scanner;
public class Example02 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		double dblTotal = 2.6809;
		int intValue = 2;
		String stringVal = "Howdy";
		System.out.printf("Total is: $%,.2f%n", dblTotal);
		System.out.printf("Total: %-10.2f: ", dblTotal); 
		System.out.println();
		System.out.printf("% 4d", intValue); 
		System.out.println();
		System.out.printf("%20.10s\n", stringVal); 
		String s = "Hello World"; 
		System.out.printf("The String object %s is at hash code %h%n", s, s); 

		
//		Scanner input = new Scanner(System.in);
//		
//		System.out.print("Enter two end points of a diagonal in 1st rectangle: ");
//		float x1 = input.nextFloat();
//		float y1 = input.nextFloat();
//		float x2 = input.nextFloat();
//		float y2 = input.nextFloat();
//		
//		Point pt1 = new Point(x1, y1);
//		Point pt2 = new Point(x2, y2);
//		
//		Rectangle r1 = new Rectangle(pt1, pt2);
//		
//		System.out.print("Enter two end points of a diagonal in 1st rectangle: ");
//		x1 = input.nextFloat();
//		y1 = input.nextFloat();
//		x2 = input.nextFloat();
//		y2 = input.nextFloat();
//		
//		pt1 = new Point(x1, y1);
//		pt2 = new Point(x2, y2);
//		
//		Rectangle r2 = new Rectangle(pt1, pt2);
//		
//		r1.display();
//		r2.display();
//		
//		r1.overlap(r2); //check if r1 overlaps r2
//		
//		System.out.print("Enter the center of the circle: ");
//		
//		float cx = input.nextFloat();
//		float cy = input.nextFloat();
//		System.out.print("Enter the radius of the circle: ");
//		float r = input.nextFloat();
//		
//		float dist = (cy >= 0 ? cy : -cy); //shorthand if. Distance between center and x axis: abs
//		
//		if(dist > r){
//			System.out.println("No intersection");
//		}
//		else if(dist == r){
//			System.out.printf("One intersection (%f, $f)", cx, 0);
//		}
//		else{
//			float t = (float) Math.sqrt(r * r - dist * dist);
//			System.out.printf("Two intersections: ($f, 0) and ($f, 0)", cx-t, cx+t);
//		}
	}
}

class Point{
	
	public float x, y;
	
	Point(){
		x = 0;
		y = 0;
	}
	
	Point(float px, float py){
		x = px;
		y = py;
	}
	
	Point(Point p){
		x = p.x;
		y = p.y;
	}
}

class Rectangle{
	
	private Point bl, tr;
	
	Rectangle(Point pt1, Point pt2){	
		bl = pt1;
		tr = pt2;
		normalization();
	}
	
	void normalization(){
		float minX = bl.x, minY = bl.y, maxX = tr.x, maxY = tr.y;
		
		if (bl.x >= tr.x){
			minX = tr.x;
			maxX = bl.x;
		}
		if (bl.y >= tr.y){
			minY = tr.y;
			maxY = bl.y;
		}
		
		bl.x = minX;
		tr.x = maxX;
		bl.y = minY;
		tr.y = maxY;
	}
	
	void display(){
		System.out.printf("(%f, %f) , (%f, %f)", bl.x, bl.y, tr.x, tr.y);
	}
	
	void overlap(Rectangle another){
		if(another.tr.y < bl.y || another.bl.y > tr.y ||	//rectangles are disjointed (not overlapping or contained)
			another.tr.x < bl.x || another.bl.x > tr.x){
			System.out.println("The rectangles are disjointed");
		}
		else if(bl.x <= another.bl.x && tr.x >= another.tr.x &&	 //if one rectangle is contained within one another
				bl.y <= another.bl.y && tr.y >= another.tr.y &&
				another.bl.x <= bl.x && another.tr.x >= tr.x &&
				another.bl.y <= bl.y && another.tr.y >= tr.y){
			System.out.println("Rectangles are contained");
		}
		else{
			System.out.println("The rectangles overlap");
		}
	}
}