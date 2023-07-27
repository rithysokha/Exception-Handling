//group8
package Exercise1;
import java.util.Scanner;
public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Array of the names of the months.
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        // Array number of days in each month
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        System.out.print("Enter a month number (1-12): ");
        int monthNumber = scanner.nextInt();
        // Try to print the month and number of days.
        try {
            System.out.println("The month of " + months[monthNumber - 1] + " has " + dom[monthNumber - 1] + " days.");
        }
        // Catch the `ArrayIndexOutOfBoundsException` exception if the user enters a wrong number. 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong number.");
        }
        scanner.close();
    }
}