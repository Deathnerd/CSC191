/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example5;

/**
 *
 * @author zach_robertson3
 */

import java.util.Scanner;
public class Example5{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter two integers: ");
        String n1 = input.next();
        String n2 = input.next();
        
        String result = addition(n1, n2);
        System.out.printf("%s + %s = %s\n", n1, n2, result);
    }
    
    
    static String addition(String n1, String n2)
   {
        final int base = 10;        // for decimal numbers
        String r = "";              // result
        int idx1 = n1.length() - 1;
        int idx2 = n2.length() - 1;
        int carry = 0;
        
        while((idx1 >= 0) && (idx2 >= 0))  //not reached the beginning of the either string
       {
            int sum = (n1.charAt(idx1) - '0') + (n2.charAt(idx2) - '0') + carry;
            r = sum % base + r;
            carry = sum /base;
            
            idx1 --;
            idx2 --;
            
            
        }
        
        while (idx1 >= 0)               //not reached the beginning of the 1st string
       {
            int sum = (n1.charAt(idx1) - '0') + carry;
            r = sum % base + r;
            carry = sum / base;
            
            idx1 --;
        }
        
        while (idx2 >= 0)               //not reached the beginning of the 2st string
       {
            int sum = (n2.charAt(idx2) - '0') + carry;
            r = sum % base + r;
            carry = sum / base;
            
            idx2 --;
        }
        
        if (carry == 1)
       {
            r = carry + r;
        }
        return r;
    }
}
