package example23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Project: Example23
 * Package: example23
 * Class:
 * Created by George Gilleland at 9:42 AM on 5/1/14.
 */

class PrintTask<E> implements Runnable{
	final String taskName;
	E value;
	int times;

	PrintTask(String name, E val, int t){
		taskName = name;
		value = val;
		times = t;
	}

	public void run(){
		for(int i = 0; i < times; i++){
			System.out.print(value);
		}
	}
}
public class example23 {
	public static void main(String[] args){

		/*//approach 1
		Thread t1 = new Thread(new PrintTask<Integer>("task1", 2, 100));
		Thread t2 = new Thread(new PrintTask<Character>("task2", 'c', 200));
		Thread t3 = new Thread(new PrintTask<String>("task3", "hi", 80));

		t1.start();
		t2.start();
		t3.start();*/

		//approach 2:
		PrintTask<Integer> t1 = new PrintTask<Integer>("task1", 2, 100);
		PrintTask<Character> t2 = new PrintTask<Character>("task2", 'c', 200);
		PrintTask<String> t3 = new PrintTask<String>("task3", "hi", 80);

		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		threadExecutor.execute(t1);
		threadExecutor.execute(t2);
		threadExecutor.execute(t3);
		threadExecutor.shutdown();

		System.out.println("\n Tasks started, main() ends");

	}
}
