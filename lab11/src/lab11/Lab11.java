/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
		Character charArray[] = {"c", "A", "f", "s", "C", "e"};
		//instantiate classes with different types
		GenericClass<Integer> integers = new GenericClass<Integer>(intArr);
		GenericClass<Double> doubles = new GenericClass<Double>(doubArr);
		GenericClass<String> strings = new GenericClass<String>(strArr);
		GenericClass<Character> characters = new GenericClass<Character>(charArray);
		//print unsorted lists
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
		integers.print();
		doubles.print();
		strings.print();
		characters.print();
	}
}
