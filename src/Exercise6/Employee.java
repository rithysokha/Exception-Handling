//group8
package Exercise6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Employee {
    private int id;
    private String name;
    private String gender;
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(String name, String gender, double salary) {
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }

    public HashMap<Integer, Employee> employeeList = new HashMap<>();

    void readEmployee() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input your ID: ");
        id = input.nextInt();
        input.nextLine();
        System.out.println("Input your Name: ");
        name = input.nextLine();
        System.out.println("Input your gender: ");
        gender = input.nextLine();
        System.out.println("Input your salary: ");
        salary = input.nextDouble();
        input.close();
    }

    void addEmployee() {
        File file = new File("src\\Exercise6\\employee.txt");
        try {
            // Creates a reader that is linked with the myFile.txt
            FileReader reader = new FileReader("src\\Exercise6\\employee.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValuePair = line.split(", ");
                String employeeId = keyValuePair[0];
                String nameString = keyValuePair[1];
                String genderString = keyValuePair[2];
                String salaryString = keyValuePair[3];
                Integer employeeIDInteger = Integer.parseInt(employeeId);
                double salayDouble = Integer.parseInt(salaryString);
                // Add the key-value pair to the HashMap.
                employeeList.put(employeeIDInteger, new Employee(nameString, genderString, salayDouble));
            }
            employeeList.put(id, new Employee(name, gender, salary));
            // Close the file.
            bufferedReader.close();

            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            // try to create a file
            FileWriter writer = new FileWriter(file);
            for (int key : employeeList.keySet()) {
                writer.write(key + ", " + employeeList.get(key).getName() + ", " +
                        employeeList.get(key).getGender() + ", " +
                        employeeList.get(key).getSalary() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void deleteEmployee(int employeeID) {
        System.out.println();
    }
}
