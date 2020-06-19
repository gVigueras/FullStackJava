package cl.test;

import cl.bank.BankAccount;

public class BankTest {

	public static void main(String[] args) {
		BankAccount ba = new BankAccount(100, 200);
		BankAccount bb = new BankAccount(200, 400);
		BankAccount bc = new BankAccount(300, 600);
		
		ba.deposit(1, 200);
		ba.draw(2, 200);
		
		bb.draw(2, 400);
		bb.deposit(1, 400);
		
		bc.deposit(1, 700);
		bc.deposit(2, 600);
		
		ba.showDetails();
		bb.showDetails();
		bc.showDetails();
		
		BankAccount.getMoney();
	}

}
