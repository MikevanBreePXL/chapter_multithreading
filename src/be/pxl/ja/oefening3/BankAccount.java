package be.pxl.ja.oefening3;

import java.io.BufferedWriter;
import java.io.IOException;

public class BankAccount {
	private int balance;
	private String accountNumber;
	private BufferedWriter logger;
	
	public BankAccount(String accountNumber, int initialBalance, BufferedWriter logger) {
		this.accountNumber = accountNumber;
		this.balance = initialBalance;
		this.logger = logger;
	}
	
	public void deposit(int amount, String user) {
		Thread virtualThread = Thread.startVirtualThread(() -> {
			synchronized (this) {
				try {
					logger.write("User " + user + " deposited " + amount + " euros to account " + accountNumber + "\n");
					logger.flush();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}

				balance += amount;
			}
		});
	}

	public void withdraw(int amount, String user) {
		Thread virtualThread = Thread.startVirtualThread(() -> {
			try {
				logger.write("User " + user + " withdrew " + amount + " euros from account " + accountNumber + "\n");
				logger.flush();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

			balance -= amount;
		});
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
}
