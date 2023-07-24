package Exercise4;
import java.util.HashMap;

public class Account {
    private String name;
    private double balance;
    private int accountNumber;
    private int password;
    
    

    // setter getter for accesing private variable
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

    // constructor
    public Account(String name, double balance, int password) {
        this.name = name;
        this.balance = balance;
        this.password = password;
    }

    public HashMap<Integer, Account> accountList = new HashMap<>();
   
    void displayLine() {
        System.out.println("============================================");
    }
    boolean logIn(int accountNumber, int password) {
        if (accountList.containsKey(accountNumber) && accountList.get(accountNumber).getPassword() == password) {
            System.out.println("Login successful");
            System.out.println("Welcome " + accountList.get(accountNumber).getName());
            return true;
        } else {
            System.out.println("Login failed");
            return false;

        }
    }
    void displayBalance(int accountNumber){
        System.out.println("Your balance is: " + accountList.get(accountNumber).getBalance());
    }
    void deposit (int accountNumer, double ammount){
        accountList.get(accountNumer).setBalance(accountList.get(accountNumer).getBalance() + ammount);
        System.out.println("Deposit successful");
    }
    void withdraw(int accountNumber, double ammount){
        if(accountList.get(accountNumber).getBalance() < ammount){
            System.out.println("Insufficient balance");
        }else{
            accountList.get(accountNumber).setBalance(accountList.get(accountNumber).getBalance() - ammount);
            System.out.println("Withdraw successful");
        }
    }
    void transfer(int accountNumer, int accountNumberTransfer, double ammount){
        if(!accountList.containsKey(accountNumberTransfer)){
            System.out.println("Account number not found");
            return;
        }
        if(accountList.get(accountNumer).getBalance() < ammount){
            System.out.println("Insufficient balance");
        }else{
            accountList.get(accountNumer).setBalance(accountList.get(accountNumer).getBalance() - ammount);
            accountList.get(accountNumberTransfer).setBalance(accountList.get(accountNumberTransfer).getBalance() + ammount);
            System.out.println("Transfer successful");
        }
    }
    void displayMenu() {
        displayLine();
        System.out.println("Please select an option: ");
        System.out.println("A. Display balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Transfer");
        System.out.println("E. Exit");
    }
    
}