package TestFile;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        HashMap<String,String> accountList = new HashMap<String, String>();

        File file = new File("myFile.txt");
        
        try {
            // Creates a reader that is linked with the myFile.txt
            FileReader reader = new FileReader("myFile.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String [] keyValuePair = line.split(",");
                String key = keyValuePair[0];
                String value = keyValuePair[1];
    
                // Add the key-value pair to the HashMap.
                accountList.put(key, value);
            }
    
            // Close the file.
            bufferedReader.close();
    
            // Print the HashMap.
            System.out.println(accountList);
            reader.close();
            }
            catch(Exception e) {
            System.out.println(e);
            }
        }
    }

