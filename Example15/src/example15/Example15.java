/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example15;

class Pair<F, S> {
	private F first;
	private S second;

	Pair(F f, S s){
		first = f;
		second = s;
	}

	F getFirst(){
		return first;
	}

	S getSecond(){
		return second;
	}

	String getString() {
		return "(" + first + ", " + second + ")";
	}
}

public class Example15 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Integer integerArray[] = {2, 4, 6, 8, 10};
		String stringArray[] = {"AB", "ABC", "BCF"};

		printArray(integerArray);
		printArray(stringArray);

		System.out.println("Last element in string array: " + getArrayLast(stringArray) + "\n");
		System.out.println("Last element in integer array: " + getArrayLast(integerArray) + "\n");

		System.out.println("Max(5,3) = " + getMax(5, 3));
		System.out.println("Max(\"abc\", \"fa\") = " + getMax("abc", "fa"));

		String stringArray1[] = {"AB", "ABC", "BC"};
		System.out.println(equals(stringArray, stringArray1));

		Pair<String, String> grade440 = new Pair<String, String>("Mike", "A");
		Pair<String, Integer> marks440 = new Pair<String, Integer>("Mike", 96);

		System.out.println("Grade: "+grade440.getString());
		System.out.println("Marks: "+marks440.getString());
	}

	static <E> void printArray(E arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	static <E> E getArrayLast(E arr[]) {
		E t = arr[arr.length - 1];
		return t;
	}

	static <E extends Number> double fraction(E num) {
		return num.doubleValue() - num.intValue();
	}

	static <E extends Comparable<E>> E getMax(E a, E b) {
		if (a.compareTo(b) >= 0)
			return a;
		return b;
	}

	//return true if two given arrays a[] and b[] have the same length and 
	//contains identical elements
	static <E extends Comparable<E>> boolean equals(E a[], E b[]) {
		if (a.length != b.length)
			return false;
		for (int i = 0; i < a.length; i++)
			if (a[i].compareTo(b[i]) != 0)
				return false;
		return true;
	}
}
