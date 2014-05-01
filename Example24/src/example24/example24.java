package example24;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Project: Example24
 * Package: example24
 * Class:
 * Created by George Gilleland at 10:03 AM on 5/1/14.
 */

class Account {
	private int balance = 0;

	int getBalance(){
		return balance;
	}

	synchronized void deposit(int amount){
		int newBalance = balance + amount;

		//this delay is deliberately added to magnify the data corruption problem and make it easy to observe
		try{
			Thread.sleep(1);
		} catch(InterruptedException e){

		}

		balance = newBalance;
	}
}

class AddDollarTask implements Runnable{
	final Account sharedAccount;

	AddDollarTask(Account a){
		sharedAccount = a;
	}

	public void run(){
		sharedAccount.deposit(1);
	}
}
public class example24 {
	public static void main(String[] args){

		Account account = new Account();

		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		for(int i = 0; i < 100; i++){
			threadExecutor.execute(new AddDollarTask(account));
		}
		threadExecutor.shutdown();

		//wait until all tasks are done
		while(!threadExecutor.isTerminated()){
		}

		System.out.println("Final balance = " + account.getBalance());
	}
}
