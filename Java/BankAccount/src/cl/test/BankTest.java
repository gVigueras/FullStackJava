package cl.test;

import cl.bank.BankAccount;

public class BankTest {

	public static void main(String[] args) {
		BankAccount ba = new BankAccount(500, 700);
		BankAccount bb = new BankAccount(560, 2000);
		ba.deposit(1, 500);
		ba.draw(1, 1000);
		
		BankAccount.getMoney();
	}

}
