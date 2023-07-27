//group 8
package Exercise7;
import java.util.Scanner;
public class Program {

    public static void main(String[] args) {
        //create accountObj to call method from Account.java
        Account accountObj = new Account("", 0, 0) {
        };
        accountObj.readFile();
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
                //will show error if user input wrong type
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
        input.close();
    }
}