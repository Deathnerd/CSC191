/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example03;

/**
 *
 * @author user
 */

import java.util.Scanner;
public class Example03{
    public static void main(String[] args){
        int option;
        Scanner input = new Scanner(System.in);
        Circle c = new Circle();
        
        do{
            System.out.println("\nSelect from:");
            System.out.println("1. Enter circle:");
            System.out.println("2. Display circle info.:");
            System.out.println("3. Print area:");
            System.out.println("4. Print circumference:");
            System.out.println("5. Quit:");
            
            option = input.nextInt();

            switch (option){
                case 1:
                    /*  for public
                    System.out.print("Enter the center of a circle: ");
                    c.center.x(input.nextFloat());
                    c.center.y(input.nextFloat());
                    System.out.print("Enter the radius of the circle: ");
                    c.r = input.nextFloat();
                     */
                    System.out.print("Enter the center of a circle: ");
                    c.center.setX(input.nextFloat());
                    c.center.setY(input.nextFloat());
                    System.out.print("Enter the radius of the circle: ");
                    c.r = input.nextFloat();
                    break;
                case 2:
                    //System.out.printf("Center: (%f, %f) and radius: %f \n", c.center.x, c.center.y, c.r); for public access
                    System.out.printf("Center: (%f, %f) and radius: %f \n", c.center.getX(), c.center.getY(), c.r);
                    break;
                case 3:
                    System.out.printf("Area = %f \n", c.get_area());
                    break;
                case 4:
                    System.out.printf("Circumference = %f", c.get_circum());
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid option!  Try it again:");
            }
        } while (option != 5);
        
        System.out.println("Thanks for using my program.");
    } 
}

class Point{
	//public float x, y; for public only need the variables
        private float x, y;
        
        void setX(float Xcord){
            x = Xcord;
        }
        
        void setY(float Ycord){
            y = Ycord;
        }
        
        float getX(){
            return x;
        }
        float getY(){
            return y;
        }
}

class Circle{
	public final float PI = 3.14159f;
	public Point center;
	public float r;
        
        Circle(){
            center = new Point();
            r = 0;
        }
	float get_area(){
		return (PI * r * r);
	}
	float get_circum(){
		return (2.0f * PI * r);
	}
}