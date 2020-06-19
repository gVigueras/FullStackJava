package cl.bank;

public class BankAccount {

	private String accountNumber;
	private double checkingBalance;
	private double savingBalance;

	private static int totalAccounts = 0;
	private static int totalMoney = 0;

	public BankAccount(double checkingBalance, double savingBalance) {
		this.setAccountNumber(this.randomAccount());
		this.checkingBalance = checkingBalance;
		this.savingBalance = savingBalance;
		totalMoney+=(checkingBalance+savingBalance);
		totalAccounts++;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	private String randomAccount() {
		String accountNumber = "";
		for (int i = 0; i < 10; i++) { 
			accountNumber+= String.valueOf((int)(Math.random() * 10));
		}
		return accountNumber;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}

	public void deposit(int account, int amount) {
		switch (account) {
		//Checking account
		case 1:
			this.checkingBalance += amount;
			totalMoney+=amount;
			break;
		//Saving account
		case 2:
			this.savingBalance += amount;
			totalMoney+=amount;
			break;
		default:
			System.out.println("¡No existe esa cuenta!");
			break;
		}
	}

	public void draw(int account, int amount) {
		switch (account) {
		//Checking account
		case 1:
			if(this.checkingBalance >= amount) {
				this.checkingBalance -= amount;
				totalMoney-=amount;
			}else {
				System.out.println("No hay dinero suficiente!");
			}
			break;
		//Saving account
		case 2:
			if(this.savingBalance >= amount) {
				this.savingBalance -= amount;
				totalMoney-=amount;
			}else {
				System.out.println("No hay dinero suficiente!");
			}
			break;
		default:
			System.out.println("¡No existe esa cuenta!");
			break;
		}
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void showDetails() {
		System.out.println("El número de esta cuenta es: "+this.getAccountNumber());
		System.out.println("El saldo de la cuenta corriente es: "+this.getCheckingBalance());
		System.out.println("El saldo en la cuenta de ahorro es: "+this.getSavingBalance());
		System.out.println();
	}

	public static void getMoney() {
		System.out.println("El dinero total existente es: "+totalMoney);
		System.out.println("Distribuído en "+totalAccounts+" cuentas.");
		System.out.println();
	}



}
