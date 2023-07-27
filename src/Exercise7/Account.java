//group8
package Exercise7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

    HashMap<Integer, Account> accountList = new HashMap<>();

    void displayLine() {
        System.out.println("============================================");
    }
    void readFile(){
        
        try {
            // Creates a reader that is linked with the myFile.txt
            FileReader reader = new FileReader("src\\Exercise7\\account.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String accNum = keyValue[0];
                String nameStr = keyValue[1];
                String balanceStr = keyValue[2];
                String passwordStr = keyValue[3];
            //convert string to integer and double 
                Integer accInteger = Integer.parseInt(accNum);
                double balanDouble = Double.parseDouble(balanceStr);
                int passwordInt = Integer.parseInt(passwordStr);

                // Add the key-value pair to the HashMap.
                accountList.put(accInteger, new Account(nameStr, balanDouble, passwordInt));
            }

            // Close the file.
            bufferedReader.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //write data back into txt file
    void writeFile(){
        File file = new File("src\\Exercise7\\account.txt");
        try {
            // write file back into account.txt
            FileWriter writer = new FileWriter(file);
            for (int key : accountList.keySet()) {
                writer.write(key + ", " + accountList.get(key).getName() + ", " +
                        accountList.get(key).getBalance() + ", " +
                        accountList.get(key).getPassword() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // login method will return true if the password and account number is correct
    boolean logIn(int accountNumber, int password) {
        displayLine();
        if (accountList.containsKey(accountNumber) && accountList.get(accountNumber).getPassword() == password) {
            System.out.println("Login successful");
            System.out.println("Welcome " + accountList.get(accountNumber).getName());
            return true;
        } else {
            System.out.println("Login failed.");
            return false;

        }
    }

    // display balance of user
    void displayBalance(int accountNumber) {
        displayLine();
        System.out.println("Your balance is: " + accountList.get(accountNumber).getBalance() + " $");
    }

    // deposit balace for user
    void deposit(int accountNumer, double ammount) {
        displayLine();
        accountList.get(accountNumer).setBalance(accountList.get(accountNumer).getBalance() + ammount);
        System.out.println("Deposit successful!");
        writeFile();
    }

    // withdraw method will check banlance before withdraq
    void withdraw(int accountNumber, double ammount) {
        displayLine();
        if (accountList.get(accountNumber).getBalance() < ammount) {
            System.out.println("Insufficient balance.");
        } else {
            accountList.get(accountNumber).setBalance(accountList.get(accountNumber).getBalance() - ammount);
            System.out.println("Withdraw successful.");
        }
        writeFile();
    }

    // transfer method will check balance and account validility before work
    void transfer(int accountNumber, int accountNumberTransfer, double ammount) {
        displayLine();
        if (accountNumber != accountNumberTransfer) {

            if (!accountList.containsKey(accountNumberTransfer)) {
                System.out.println("Account number not found.");
                return;
            }
            if (accountList.get(accountNumber).getBalance() < ammount) {
                System.out.println("Insufficient balance.");
            } else {
                accountList.get(accountNumber).setBalance(accountList.get(accountNumber).getBalance() - ammount);
                accountList.get(accountNumberTransfer)
                        .setBalance(accountList.get(accountNumberTransfer).getBalance() + ammount);
                System.out.println("Transfer successful.");
                writeFile();
            }
        } else {
            System.out.println("You can't transfer to your own account.");
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