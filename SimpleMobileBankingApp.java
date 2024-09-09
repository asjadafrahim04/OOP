/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import java.util.Scanner;

public class SimpleMobileBankingApp {

    // Account class to manage balance
    public static class Account {
        private double balance;

        public Account(double initialBalance) {
            this.balance = initialBalance;
        }

        public void sendMoney(double amount) {
            if (balance >= amount && amount > 0) {
                balance -= amount;
                System.out.println("You sent $" + amount);
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        }

        public void cashOut(double amount) {
            if (balance >= amount && amount > 0) {
                balance -= amount;
                System.out.println("You cashed out $" + amount);
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        }

        public void displayBalance() {
            System.out.println("Balance: $" + balance);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account myAccount = new Account(1000); // Start with $500
        int choice;

        do {
            System.out.println("\n1. Send Money");
            System.out.println("2. Cash Out");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();

            if (choice == 1) {
                System.out.print("Enter amount to send: $");
                double amount = input.nextDouble();
                myAccount.sendMoney(amount);
            } else if (choice == 2) {
                System.out.print("Enter amount to cash out: $");
                double amount = input.nextDouble();
                myAccount.cashOut(amount);
            } else if (choice == 3) {
                myAccount.displayBalance();
            } else if (choice != 4) {
                System.out.println("Invalid choice, try again.");
            }
        } while (choice != 4);

        System.out.println("Thank you for using our service!");
        input.close();
    }
}
