/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example04;

/**
 *
 * @author user
 */

import java.util.Scanner;
public class Example04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        NumberTriangle numtriangle = new NumberTriangle();
        System.out.print("Enter the height: ");
        numtriangle.setHeight(in.nextInt());
        numtriangle.printTriangle1();
        System.out.println();
        numtriangle.printTriangle2();
        System.out.println();
        numtriangle.printTriangle2Rotate90();
        System.out.println();
        numtriangle.printTriangle2Rotate270();
    }
}

class NumberTriangle {
    private int height;  // number of lines in the triangle
    
    void setHeight(int h) {
        height = h;
    }
    
    void printTriangle1() {
        for(int i = 1; i <= height; i++) { //row loop
            int n = 1; //every line always starts with a one
            int j;
            
            for(j = 1; j <= height-i; j++) {
                System.out.printf("%-5s", ""); //%s = string, %-5s = 5 spaces
            }
            
            for(j = 1; j <= i; j++) { //constructs first half of the line
                System.out.printf("%-5d", n); //%d means integer value
                n*=2;
            }
            
            n /= 4;
            for(j = 1; j <= i-1; j++) { //2nd half of the line
                System.out.printf("%-5d", n);
                n /=2;
            }
            System.out.println();
        }
    }
    
    void printTriangle2() {
        int n = 1;
        for(int i = 1; i <= height; i++) {
            for(int j = 1; j <= i; j++)
                System.out.printf("%-5d", n++);
            System.out.println();
        }
    }
 
    void printTriangle2Rotate90() {
        int start = 0;      //to find out the first number of flipped triangle
        for(int i = 1; i <= height-1; i++)
            start += i;
        start += 1;
        
        for(int i = 1; i <= height; i++) {
            int n = start;
            int diff = height - i; //difference between adjacent columns
            for(int j = 1; j<= height-i +1; j++) {
                System.out.printf("%-5d", n);
                n -= diff;
                diff--;
            }
            System.out.println();
            start++;
        }
    }
    
    void printTriangle2Rotate270() {
        
        //determine the starting number
        int start = 0;
        for(int i = 1; i <= height; i++)
            start += i;
        //print out all lines in the triangle
        for(int i = 1; i <= height; i++) {
            //print out the blank spaces
            for(int space = 1; space <= height-i; space++)
                System.out.printf("%-5s", "");     
            int n = start;
            int diff = height-i+1; //difference between adjacent columns
            //print all numbers in a line
            for(int j = 1; j <= i; j++) {
                System.out.printf("%-5d", n);
                n += diff; //update n
                diff++;   //update diff
            }
            System.out.println();
            start -= height+1-i;   //update the starting number
        }
    }
}
