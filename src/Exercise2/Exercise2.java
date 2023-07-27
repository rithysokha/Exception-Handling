//group8
package Exercise2;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Exercise2 {
    public static void main(String[] args) {
       
        // Array of the names of the months.
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        // Array number of days in each month
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        System.out.print("Enter a month number (1-12): ");
        
        
        while(true){
            // Try to print the month and number of days.
            try {
                Scanner scanner = new Scanner(System.in);
                int monthNumber = scanner.nextInt();
                    System.out.println("The month of " + months[monthNumber - 1] + " has " + dom[monthNumber - 1] + " days.");
                    scanner.close();
                break;
            }
            // Catch the `ArrayIndexOutOfBoundsException` exception if the user enters a wrong number.
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.print("Wrong Number. Enter an integer between 1 and 12: ");
                
            }
            // Catch the `InputMismatchException` exception if the user enters invalid number.
            catch (InputMismatchException e){
                System.out.print("Invalid input. Please enter an integer: ");
   
            }
        }
        
    }
}