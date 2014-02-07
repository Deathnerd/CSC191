/**
 * Course: CSC191, Spring 2014 Projet: Homework1 Date: 1/23/2014 Author: Wes
 * Gilleland Purpose: To find the intersections of a vertical line segment and a
 * circle
 */
package homework1;

import java.util.Scanner;

public class Homework1{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		while (true){
			System.out.println("Enter the points of a vertical line");
			Point point1 = new Point(in.nextFloat(), in.nextFloat()); //Will ask for x value then y value
			Point point2 = new Point(in.nextFloat(), in.nextFloat()); //Will ask for x value then y value
			VerticalLineSegment vLine = new VerticalLineSegment(point1, point2);

			System.out.println("Enter the coordinate of a circle");
			Point circCenter = new Point(in.nextFloat(), in.nextFloat()); //asks for x value then y value
			System.out.println("Enter the radius");
			Circle circle = new Circle(circCenter, in.nextFloat()); //inserts the point object and asks for radius

			circle.intersect(vLine);

			System.out.println("Enter 1 to exit");
			if (in.nextInt() == 1){
				return;
			}
		}
	}
}

class Point{

	public float x, y;

	Point(float px, float py){
		x = px;
		y = py;
	}

	Point(Point P){
		x = P.x;
		y = P.y;
	}
}

class VerticalLineSegment{

	Point p1, p2; //two end points, where p1 is above p2

	VerticalLineSegment(Point point1, Point point2){
		if (point2.x != point1.x){
			System.out.println("Not a vertical line! Run again!");
			System.exit(0); //quits the application. Not the most graceful solution, but it works
		}
		p1 = point1;
		p2 = point2;
		normalize();
	}

	void normalize(){ //run a check to see if point 1 is above point 2
		float pnt1x = p1.x, pnt1y = p1.y, pnt2x = p2.x, pnt2y = p2.y;

		if (pnt2x >= pnt1x){
			pnt1x = p2.x;
			pnt2x = p1.x;
		}
		if (pnt2y >= pnt1y){
			pnt1y = p2.y;
			pnt2y = p1.y;
		}

		p1.x = pnt1x;
		p1.y = pnt1y;
		p2.x = pnt2x;
		p2.y = pnt2y;
	}
}

class Circle{

	private static final float PI = 3.14159f;
	private final Point center;
	private final float radius;

	Circle(Point c, float r){
		center = c;
		radius = r;
	}

	// Necessary methods are defined here.
	// One of the methods is declared as follows.
	// It determines whether the circle intersects
	// a give vertical line segment and prints the x-y
	// coordinates of all points of intersection if exist.
	void intersect(VerticalLineSegment line){
		double dist = Math.abs(radius - line.p1.x);
		
		if (dist >= radius || (line.p1.y < center.y-radius) || (line.p2.y > center.y+radius)){ //check for outlying lines
			System.out.println("No intersections");
			return;
		}
		
		//check for tangents and center intersections
		if((dist == radius || dist == 0) && (line.p1.y >= center.y && line.p2.y <= center.y)){
			if(line.p1.x < center.x)
				System.out.println("One intersection: "+(center.x-radius));
			if(line.p1.x > center.x)
				System.out.println("One intersection: ("+(center.x+radius)+" , "+center.y+")");
			else
				System.out.println("Two intersections: ("+(center.x)+" , "+(center.y+radius)+"),("+(center.x)+" , "+(center.y-radius)+")");
			return;
		}
		
		//only one case left: one intersection
		double base = dist;
		double hyp = radius;
		double b = Math.sqrt((base*base)-(hyp*hyp));
		
		if(line.p1.x < center.x){
			if(line.p2.y <= center.y - radius){
				System.out.println("Two intersections: ("+(center.x+base)+","+(center.y+b)+")("+(center.x+base)+","+(center.y-b)+")");
				return;
			}
			System.out.println("One intersection: ("+(center.x-base)+","+(center.y+b)+")");
			return;
		}
	}
}
