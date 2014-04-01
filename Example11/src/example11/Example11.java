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
	
	void empInfo(){
		System.out.println("Employee ...");
		System.out.println("First name: "+ firstName);
		System.out.println("Last name: "+ lastName);
		//print something else
	}

	// static method
	static int getCount() {
		return count;
	}
}

class SEmp extends Employee {
	double salary;
	
	SEmp(String sn, String nam, double sal){
		super(sn, nam);
		salary = sal;
	}
	
	void empInfo(){
		//print stuff
		System.out.println("SEmp...");
		super.empInfo();
		System.out.println("Salary = "+salary);
	}
}

class HEmp extends Employee{
	
	double hours;
	double rate;
	
	HEmp(String sn, String nam, double h, double r){
		super(sn, nam);
		hours = h;
		rate = r;
	}
	
	void empInfo(){
		System.out.println("HEmp...");
		super.empInfo();
		System.out.println("Hours = "+hours+"  Rate = "+rate);
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
		
		Employee E = new Employee("1111", "Judy");
		SEmp SE = new SEmp("2222", "Tom", 50000);
		HEmp HE = new HEmp("3333", "Mary", 45, 20.5);
		
		E.empInfo();
		System.out.println();
		SE.empInfo();
		System.out.println();
		HE.empInfo();
		System.out.println();
		
//		E = SE; //valid. Vice versa invalid
//		E.empInfo();
	}

}
