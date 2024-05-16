package be.pxl.ja.oefening3;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

public class Run {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", 1000, new BufferedWriter(new OutputStreamWriter(System.out)));
        account.deposit(100, "Peter");
        account.withdraw(50, "Peter");
        account.deposit(50, "Peter");
        account.withdraw(100, "Peter");
        account.deposit(100, "Peter");
        account.withdraw(50, "Peter");
        account.deposit(50, "Peter");
        account.withdraw(100, "Peter");

        System.out.println("Account number: " + account.getAccountNumber());
        System.out.println("Account balance: " + account.getBalance());
        /* 1000 + 100 - 50 + 50 - 100 + 100 - 50 + 50 - 100 = 1000 */
        System.out.println("Expected balance: 1000");
    }
}