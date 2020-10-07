package main.java.com.atm;

public class Account {
	
	
		String type;
		double balance;

	
		void setType(String accType) {
			
			type = accType;
		}

		void setBalance(double accBal) {
			
			balance = accBal;
		}


		void deposit(double dep) {
			
			balance += dep; 
		}

		void withdraw(double wit) {
			
			balance -= wit; 
		}


		String getType() {
			
			return type;
		}

		double getBalance() {
			
			return balance;
		}

}
