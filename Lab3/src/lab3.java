/**
 * Course: CSC191, Spring 2014
 * Projet: Lab 03
 * Date: 1/29/2014
 * Author: Wes Gilleland
 * Purpose: Reads a positive integer and produces 10 random permutations
 * of numbers 1 to n
 */

import java.util.Scanner;
import java.util.Random;

class PermutationGenerator 
{
    int maxnum; // permutation is for numbers 1 ~ maxnum
    PermutationGenerator(int n){
        maxnum = n; 
    }
    // generate a random permutation of numbers 1 ~ maxnum
    // return a permutation array which stores a random permutation
    int[] generate(){
		Random rand = new Random();
        // array for a random permutation
        int permutation[] = new int[maxnum];
		int size = maxnum;
        
        // numbers not yet in a permutation
        int A[] = new int[maxnum];
		for(int i = 0; i < 10; i++){ //create the array we're gonna randomly pick from
			A[i] = i+1;
		}

        //make permutation array
		
		for(int i = 0; i <10; i++){
			int pos = rand.nextInt(size);
			System.out.println(pos);
			permutation[i] = A[pos];
			MyListOperations.removeListElement(A, size, pos);
			size--;
		}
        return permutation;
    }
    
    void run(){
        for (int i = 0; i < 10; i++){
            MyListOperations.printList(generate(), maxnum);
            System.out.println();
        }
    }
}
class MyListOperations{
    // remove A[pos] from A[0]~A[size-1]
    static void removeListElement(int A[], int size, int pos){
    // your code comes here
		pos = pos-1;
		System.out.println(pos);
		//shift the A[pos] to the right currentSize-1
		int temp = A[pos];
		//to the swapping!
		int i = pos;
		while(i < size){
			A[i]=A[i+1];
			i++;
		}
		A[size]=temp;
    }
    // print A[0]~A[n-1]
    static void printList(int A[], int size){
    // your code comes here
        for(int i = 0; i < size; i++){
           System.out.printf("%-2d", A[i]);
        }
    }
}
public class lab3{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PermutationGenerator pg = new PermutationGenerator(10);
		
		pg.run();
    }
}
