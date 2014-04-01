
package example13;

class BankAccount{
	private double balance;
	
	BankAccount(){
		balance = 0;
	}
	
	BankAccount(double initialBalance){
		balance = initialBalance;
	}
	
	double getBalance(){
		return balance;
	}
	
	/*
	 * @return boolean true if the withdraw operation can be done
	 */
	boolean withdraw(double amount){
		if(balance >= amount){
			balance -= amount;
			return true;
		}
		return false;
	}
	
	void deposit(double amount){
		balance += amount;
		return;
	}
	
	void transferTo(double amount, BankAccount another){
		if(withdraw(amount)){
			another.deposit(amount);
			return;
		}
		return;
	}
	
	void transferFrom(double amount, BankAccount another){
		if(another.withdraw(amount)){
			deposit(amount);
			return;
		}
		return;
	}
}

class SavingsAccount extends BankAccount {
	
	private double interestRate;
	SavingsAccount(double rate){
//		super();
		interestRate = rate;
	}
	
	void earnInterest(){
		double interest = getBalance() * interestRate/100;
		deposit(interest);
	}
	
	double getInterestRate(){
		return interestRate;
	}
}

class CheckingAccount extends BankAccount{
	
	private int withdrawCount;
	private static int FREE_WITHDRAW = 3;
	private static final double WITHDRAW_FEE = 2.0;
	
	CheckingAccount(double initialBalance){
		
		super(initialBalance);
		withdrawCount = 0;
	}
	
	boolean withdraw(double amount){
		
		double total = amount;
		if(withdrawCount >= FREE_WITHDRAW){
			total += WITHDRAW_FEE;
		}
		
		if(!super.withdraw(total)){
			return false;
		}
		
		
		withdrawCount += 1;
		return true;
	}
}
public class Example13 {

	public static void main(String[] args) {
		
	}
	
}
