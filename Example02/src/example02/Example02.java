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
public class Example02 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
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
		if(another.tr.y < bl.y || another.bl.y > tr.y ||
				another.tr.x < bl.x || another.bl.x > tr.x){ //rectangles are disjointed (not overlapping or contained)
			System.out.println("The rectangles are disjointed");
		}
	}
}