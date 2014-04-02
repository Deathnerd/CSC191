/*
 * ------------------------------
 *	Course: CSC191
 *	Project: Lab 11
 *	Date: 4/2/13
 *	Author: George Gilleland
 *	..............................
 *	Purpose: This program will make use lf a generic class that will take in a one-dimensional
 * 	array of Comparable data types. The class will have a method to sort the array and print the array
 *	------------------------------
 */
package lab11;

class GenericClass<E extends Comparable<E>>{
		private E array[];
		GenericClass(E arr[]){
			array = arr;
		}

		public void print() {
			for(int i=0; i<array.length; i++)
				System.out.print(array[i]+" ");
			System.out.println();
		}

		public void sort(){ //bubble sort
			boolean sorted;
			do {
				sorted = true;
				for (int a = 0; a < array.length - 1; a++) {
					if (array[a].compareTo(array[a + 1]) > 0) {
						E tmp = array[a];
						array[a] = array[a + 1];
						array[a + 1] = tmp;
						sorted = false;
					}
				}
			} while (!sorted);
		}
}
public class Lab11 {

	public static void main(String[] args) {
		//construct array types
		Integer intArr[] = {4, 1, 8, 7, 9, 2, 3};
		Double doubArr[] = {2.5,3.65,89.65,11.4};
		String strArr[] = {"career", "computer", "networking", "database", "mobile"};
		Character charArray[] = {'c', 'A', 'f', 's', 'C', 'e'};
		//instantiate classes with different types
		GenericClass<Integer> integers = new GenericClass<Integer>(intArr);
		GenericClass<Double> doubles = new GenericClass<Double>(doubArr);
		GenericClass<String> strings = new GenericClass<String>(strArr);
		GenericClass<Character> characters = new GenericClass<Character>(charArray);
		//print unsorted lists
		System.out.println("\nPrinting unsorted lists...");
		integers.print();
		doubles.print();
		strings.print();
		characters.print();
		//sort lists
		integers.sort();
		doubles.sort();
		strings.sort();
		characters.sort();
		//print sorted lists
		System.out.println("\nPrinting sorted lists...");
		integers.print();
		doubles.print();
		strings.print();
		characters.print();
	}
}
