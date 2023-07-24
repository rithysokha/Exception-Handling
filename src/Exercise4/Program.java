//group 8
package Exercise4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Account accountObj = new Account("", 0, 0) {
        };

        File file = new File("src\\Exercise4\\account.txt");
        try {
            // Creates a reader that is linked with the myFile.txt
            FileReader reader = new FileReader("src\\Exercise4\\account.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValuePair = line.split(", ");
                String accNum = keyValuePair[0];
                String name = keyValuePair[1];
                String balance = keyValuePair[2];
                String password = keyValuePair[3];
                Integer accInteger = Integer.parseInt(accNum);
                double balanDouble = Double.parseDouble(balance);
                int passwordInt = Integer.parseInt(password);

                // Add the key-value pair to the HashMap.
                accountObj.accountList.put(accInteger, new Account(name, balanDouble, passwordInt));
            }

            // Close the file.
            bufferedReader.close();

            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        Scanner input = new Scanner(System.in);
        int accountNumber = 0;
        int accountNumberTransfer = 0;
        int password = 0;
        char choice;
        boolean isLogin = false;
        boolean isExit = false;

        do {
            try {
                System.out.println("Enter your account number: ");
                accountNumber = input.nextInt();
                System.out.println("Enter your password: ");
                password = input.nextInt();
            } catch (Exception e) {
                System.out.println("Only number allowed");
                input.nextLine();
                continue;
            }
            isLogin = accountObj.logIn(accountNumber, password);

        } while (!isLogin);
        while (!isExit) {
            try {
                accountObj.displayMenu();
                choice = input.next().charAt(0);
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Only character allowed");
                input.nextLine();
                continue;
            }
            switch (choice) {
                case 'a', 'A':
                    accountObj.displayBalance(accountNumber);
                    break;
                case 'b', 'B':
                    System.out.println("Enter amount to deposit: ");
                    double depositAmount = input.nextDouble();
                    accountObj.deposit(accountNumber, depositAmount);
                    break;
                case 'c', 'C':
                    System.out.println("Enter amount to withdraw: ");
                    double withdrawAmount = input.nextDouble();
                    accountObj.withdraw(accountNumber, withdrawAmount);
                    break;
                case 'd', 'D':
                    System.out.println("Enter account number to transfer: ");
                    accountNumberTransfer = input.nextInt();
                    System.out.println("Enter amount to transfer: ");
                    double transferAmount = input.nextDouble();
                    accountObj.transfer(accountNumber, accountNumberTransfer, transferAmount);
                    break;
                case 'e', 'E':
                    System.out.println("Thank you for using our service");
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        try {
            // try to create a file
            FileWriter writer = new FileWriter(file);
            for (int key : accountObj.accountList.keySet()) {
                writer.write(key + ", " + accountObj.accountList.get(key).getName() + ", " +
                        accountObj.accountList.get(key).getBalance() + ", " +
                        accountObj.accountList.get(key).getPassword() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        input.close();
    }
}
