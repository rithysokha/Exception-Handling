//group8
package Exercise4;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Program {
    public static void main(String[] args) {
        String line;
        int lines = 0;
        int Characters = 0;
        int words = 0;

        try {
            //create file
            File filename = new File("src\\Exercise4\\homework4.txt");
            filename.createNewFile();
            //method read file
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            //loop  to read and count
            while ((line = reader.readLine()) != null){
                System.out.println(line);
                lines++;

                Characters += line.length();
                //count with space
                words += line.split(" ").length;
            }
            reader.close();
        }

        catch (Exception e){
            System.out.println("file can not found");
            System.exit(1);
        }
        //display word characters
        System.out.println(" Number of Characters : " + Characters);
        System.out.println(" Number of Word  : " + words);
        System.out.println(" Number of Lines : " + lines);
    }
}
