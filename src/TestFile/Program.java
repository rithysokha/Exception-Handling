package TestFile;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Program {
    public static void main(String[] args) {
        File file = new File("myFile.txt");
try {
            // try to create a file
            boolean isFileCreated = file.createNewFile();
            if (isFileCreated){
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("hello bart\n");
                fileWriter.close();
            }
            else {
            
            }
            }
            catch(Exception e) {
            System.out.println(e);
            }
        }
    }

