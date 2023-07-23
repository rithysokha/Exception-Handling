package Exercise4;

import java.util.HashMap;

public class Account {
    private String name;
    private double balance;
    private int accountNumber;
    private int password;

    

    //setter getter for accesing private variable
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return this.balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public int getAccountNumber() {
        return this.accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public int getPassword() {
        return this.password;
    }
    public void setPassword(int password) {
        this.password = password;
    }
 //constructor
    public Account(String name, double balance, int accountNumber, int password) {
        this.name = name;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.password = password;
    }
    public HashMap <Integer, Account> accountList = new HashMap<Integer, Account>();
    void displayLine(){
        System.out.println("==================================");
    }
    
    boolean login(int accountNumber, int password) {
        if (this.accountNumber == accountNumber && this.password == password) {
            return true;
        } else {
            System.out.println("Wrong account number or password");
            return false;
        }
    }
    void displayBalance() {
        System.out.println("Your balance is: " + this.balance);
    }
    void deposit(double amount) {
        this.balance += amount;
        System.out.println("Your balance is: " + this.balance);
    }
    void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            displayBalance();
        } else {
            System.out.println("Your balance is not enough");
        }
    }
    void transfer(Account account, double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            account.balance += amount;
            displayBalance();
        } else {
            System.out.println("Your balance is not enough");
        }
    }

}