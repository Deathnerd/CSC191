
package homework09;

import java.util.Random;
import java.util.Scanner;

abstract class Chart {
	public int numbers[] = new int[20];

	Chart(){
		Random rand = new Random();
		for(int i = 0; i < numbers.length; i++)
			numbers[i] = rand.nextInt(10)+1; //generate random numbers from 1 to 10
	}

	abstract void plot();

	public int max(int[] A){
		int max = 0;
		for(int i  = 0; i < A.length; i++){
			if(A[i] > max)
				max = A[i];
		}
		return max;
	}
}

class LineChart extends Chart {

	LineChart(){
		super(); //run parent constructor method and generate numbers to plot
	}
	void plot(){
		int max = max(numbers); //find max value
		int width = numbers.length;
		//put numbers into a 2d array
		//max is the height of the chart
		//the width of the chart should be the length of the numbers array
		char A[][] = new char[max][width];
		for(int i = 0; i < max; i ++){
			for(int j = 0; j < width; j++){
				if(numbers[j] == max-i) {
					A[i][j] = '-';
					continue;
				}
				A[i][j] = ' ';
			}
		}
		//print the array
		for(int i = 0; i < max; i ++){
			for(int j = 0; j < width; j++){
				System.out.printf("%2c", A[i][j]);
			}
			System.out.print("\n");
		}
		System.out.println(" = = = = = = = = = = = = = = = = = = = = >x");
	}
}

class BarChart extends Chart {

	BarChart(){
		super(); //run parent constructor method and generate numbers to plot
	}
	void plot(){
		int max = max(numbers); //find max value
		int width = numbers.length;

		//put numbers into a 2d array
		//max is the height of the chart
		//the width of the chart should be the length of the numbers array
		char A[][] = new char[max][width];
		for(int i = 0; i < max; i ++){
			for(int j = 0; j < width; j++){
				if(numbers[j] >= max-i) {
					A[i][j] = '*';
					continue;
				}
				A[i][j] = ' ';
			}
		}
		//print the array
		for(int i = 0; i < max; i ++){
			for(int j = 0; j < width; j++){
				System.out.printf("%2c", A[i][j]);
			}
			System.out.print("\n");
		}
		System.out.println(" = = = = = = = = = = = = = = = = = = = = >x");
	}
}
public class Homework09 {
	//main function to run program. Made for ease of maintenance
	public static void run() {
		Scanner in = new Scanner(System.in);
		int numCharts = 0;
		char chartType = ' ';
		Chart charts[] = new Chart[numCharts];
		while (true) {
			System.out.println("\nChoose from the following options:");
			System.out.println("1. Create charts: ");
			System.out.println("2. Generate and print data: ");
			System.out.println("3. Plot data: ");
			System.out.println("0. Quit");

			switch (in.nextInt()) {
				case 1:
					System.out.println("Enter the number of charts to be created: ");
					numCharts = in.nextInt();
					 charts = new Chart[numCharts];
					System.out.println("Enter the type of charts to be created(b-barchart l-linechart");
					chartType = in.next().charAt(0);
					break;
				case 2:
					//create charts
					if(chartType == 'b') {
						for(int i = 0; i < numCharts; i++)
							charts[i] = new BarChart();
					} else if (chartType == 'l'){
						for(int i = 0; i < numCharts; i++)
							charts[i] = new LineChart();
					} else{
						System.out.println("Chart type not set or invalid!");
						break;
					}
					//print values
					for(int i = 0; i < charts.length; i++){
						System.out.println("Numbers for chart "+(i+1)+" are: ");
						for(int j = 0; j < charts[i].numbers.length; j++)
							System.out.printf(" %2d", charts[i].numbers[j]);
						System.out.print("\n");
					}
					break;
				case 3:
					//plot the charts
					for(int i = 0; i < charts.length; i++){
						System.out.print("Chart for "+(i+1)+" :\n");
						charts[i].plot();
						System.out.print("\n");
					}
					break;
				case 0:
					System.out.println("Exiting program");
					return;
				default:
					System.out.println("Invalid selection\n");
					break;
			}
		}
	}
	public static void main(String[] args) {
		run();
	}
}
