//group 8
package Exercise5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();
        try {
            // Read the file
            String text = new String(Files.readAllBytes(Paths.get("src\\Exercise5\\" + fileName + ".txt")));
            HashMap<Character, Integer> occurrences = new HashMap<>();
            // Count the occurrences of each letter
            for (char c : text.toCharArray()) {
                // Only count letters if it is matched
                if (Character.isLetter(c)) {
                    occurrences.put(c, occurrences.getOrDefault(c, 0) + 1);
                }
            }
            System.out.println("Occurrences of each letter:");
            // Print the result in alphabetical order becasue it is already sort by key
            for (HashMap.Entry<Character, Integer> entry : occurrences.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        scanner.close();
    }
}
