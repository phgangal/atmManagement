package main.java.com.atm;

import java.awt.List;
import java.text.NumberFormat; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner; 

public class ATM {
	

	public static void main(String[] args) {
	
		Account custChkAccount = new Account();
		custChkAccount.setType("Checking");
		custChkAccount.setBalance(0.00);
		
		Account custSavAccount = new Account();
		custSavAccount.setType("Savings");
		custSavAccount.setBalance(0.00);
		

		NumberFormat formatter = NumberFormat.getCurrencyInstance(); 
		Scanner sc = new Scanner(System.in); 

		boolean session = true; 
		boolean transactionValidity = false;
		HashMap billsDenominations = new Bills().getBillMap(); 

		while (session) {

			System.out.print("\nATM Menu: \n \n"
							 + "1. Deposit Money \n"
							 + "2. Withdraw Money"
							 );

			int selection = sc.nextInt(); 

			switch (selection) {

				// case 1 depositing of money

				case 1:
					System.out.print("Enter (1) for Savings or (2) for Checking: ");
					int depAccount = sc.nextInt(); 
					ArrayList<String> denominationList = new ArrayList<String>();

					if (depAccount == 1) {

						System.out.println("\nYour current Savings balance is: " + formatter.format(custSavAccount.getBalance()) + "\n");

						System.out.println("How much money would you like to deposit?");
						double deposit = sc.nextDouble();
						transactionValidity =validateFundTransaction(custSavAccount, TransationType.DEPOSIT, deposit); 
						if(transactionValidity) {
						custSavAccount.deposit(deposit);
						printDenomination(denominationList, billsDenominations, TransationType.DEPOSIT);
						}
						System.out.println("\nYour Savings balance is now: " + formatter.format(custSavAccount.getBalance()) + "\n");
						

					}

					else if (depAccount == 2) {
						
						System.out.println("\nYour current Checking balance is: " + formatter.format(custChkAccount.getBalance()) + "\n");

						System.out.println("How much money would you like to deposit?");
						double deposit = sc.nextDouble();
						transactionValidity =validateFundTransaction(custSavAccount, TransationType.DEPOSIT, deposit); 
						if(transactionValidity) {
						custChkAccount.deposit(deposit);
						printDenomination(denominationList, billsDenominations, TransationType.DEPOSIT);
						}
						System.out.println("\nChecking balance is now: " + formatter.format(custChkAccount.getBalance()) + "\n");

					}

					break;

				

				// case 2 withdrawal of money	

				case 2:
					System.out.print("\nEnter (1) for Savings or (2) for Checking: ");
					int witAccount = sc.nextInt(); 
					ArrayList<String> denominationListWithdraw = new ArrayList<String>();
					if (witAccount == 1) {

						System.out.println("\nYour current Savings balance is: " + formatter.format(custSavAccount.getBalance()) + "\n");

						System.out.println("How much money would you like to withdraw?");
						double withdraw = sc.nextDouble();
						transactionValidity =validateFundTransaction(custSavAccount, TransationType.WITHDRAWAL, withdraw); 
						if(transactionValidity) {
						custSavAccount.withdraw(withdraw);
						printDenomination(denominationListWithdraw, billsDenominations, TransationType.WITHDRAWAL);
						}
						System.out.println("\nYour Savings balance is now: " + formatter.format(custSavAccount.getBalance()) + "\n");
						

					}

					else if (witAccount == 2) {
						
						System.out.println("\nYour current Checking balance is: " + formatter.format(custChkAccount.getBalance()) + "\n");

						System.out.println("How much money would you like to withdraw?");
						double withdraw = sc.nextDouble();
						transactionValidity =validateFundTransaction(custSavAccount, TransationType.WITHDRAWAL, withdraw); 
						if(transactionValidity) {
						custChkAccount.withdraw(withdraw);
						printDenomination(denominationListWithdraw, billsDenominations, TransationType.WITHDRAWAL);
						}

						System.out.println("\nYour Checking balance is now: " + formatter.format(custChkAccount.getBalance()) + "\n");

					}

					break;

			}				 	
			

		}

		System.out.println("\nThank you for banking with us!\n");

	}
	
	
	public static boolean validateFundTransaction(Account accountIn, TransationType tranType, double transactionValue) {
		boolean isTranValid = false;
		if(transactionValue == 0 || transactionValue < 0) {
			return isTranValid;
		}
		if(tranType == TransationType.WITHDRAWAL && transactionValue > accountIn.getBalance()) {
			return isTranValid;
		}
		return isTranValid = true;
	}
	
	
	public static void printDenomination(ArrayList<String> denomination, HashMap billsDenominations, TransationType transactionType) {
		for(int i=0; i<denomination.size(); i++) {
			String deno = denomination.get(i);
			if(transactionType == TransationType.DEPOSIT) {
				int valAdd = ((int) billsDenominations.get(deno)) + 1;
				billsDenominations.put(deno, valAdd);
			}
			if(transactionType == TransationType.WITHDRAWAL) {
				int valRemove = ((int) billsDenominations.get(deno)) - 1;
				billsDenominations.put(deno, valRemove);
			}
			
		}
		
		System.out.println("the bill demoninations are: " + billsDenominations.toString());
	}
	
	

}
