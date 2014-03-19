/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example11;

import java.util.Scanner;
import java.util.Random;

class Employee {

	private String firstName, lastName;
	private static int count = 0;		// static variable: number of instances

	Employee(String first, String last) {
		firstName = first;
		lastName = last;
		count += 1;
		
		System.out.println("Employee constructor: " + firstName + " " + lastName + " " + count);
	}

	// static method
	static int getCount() {
		return count;
	}
}

public class Example11 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Number of employees before instantiation: "+ Employee.getCount());
		
		Employee e1 = new Employee("A", "B");
		Employee e2 = new Employee("C", "D");
		
		System.out.println("Number of employees after instantiation: "+ Employee.getCount());
		System.out.println("Number of employees after instantiation: "+ e1.getCount());
		System.out.println("Number of employees after instantiation: "+ e2.getCount());
	}

}
