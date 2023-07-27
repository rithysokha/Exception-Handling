package Exercise6;

import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Employee {

    private int id;
    private String name;
    private String gender;
    private String salary;

    public Employee() {
    }
    public Employee(int id, String name, String gender, String salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', gender='" + gender + "', salary='" + salary + "'}";
    }

//    Ask user to input new employee
    public void readEmployee(){
        System.out.println("Add a new employee: ");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter id: ");
        id = input.nextInt();
        System.out.print("Enter name: ");
        name = input.next();
        System.out.print("Enter gender: ");
        gender = input.next();
        System.out.print("Enter salary: ");
        salary = input.next();
    }

//    Save employee data into txt file
    public void addEmployee() {
        Map<Integer, Employee> employee = new HashMap<>();
        if(!displayEmployee().isEmpty()){
            employee.putAll(displayEmployee());
        }
        Employee em = new Employee(id, name, gender, salary);
        employee.put(id, em);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\Exercise6\\employee.txt"))){
            // Write each employee in the HashMap to the file
            for (Map.Entry<Integer, Employee> entry : employee.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue().toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    Display employees from txt file
    public Map<Integer, Employee> displayEmployee() {
        Map<Integer, Employee> hashMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\Exercise6\\employee.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    int id = Integer.parseInt(parts[0]);
                    String employeeData = parts[1].trim();
                    Employee employee = createEmployeeFromString(employeeData);
                    hashMap.put(id, employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

//    Update data employees after remove id
    public void updateEmployee(Map<Integer, Employee> employee) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\Exercise6\\employee.txt"))){
            // Write each employee in the HashMap to the file
            for (Map.Entry<Integer, Employee> entry : employee.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue().toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    Remove employee data by id
    public void deleteEmployee(int employeeId) {
        Map<Integer, Employee> hashMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src\\Exercise6\\employee.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    int id = Integer.parseInt(parts[0]);
                    String employeeData = parts[1].trim();
                    Employee employee = createEmployeeFromString(employeeData);
                        hashMap.put(id, employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        hashMap.remove(employeeId);

        updateEmployee(hashMap);

    }

    // Extract the data from txt file and return Employee object
    private static Employee createEmployeeFromString(String employeeData) {
        String[] dataParts = employeeData.split(", ");
        if (dataParts.length == 4) {
            int id = Integer.parseInt(dataParts[0].substring(12));
            String name = dataParts[1].substring(6);
            name = name.replace("'", "");
            String gender = dataParts[2].replace("gender='", "");
            gender = gender.replace("'", "");
            String salary = dataParts[3].replace("salary='", "");
            salary = salary.replace("'}", "");
            return new Employee(id, name, gender, salary);
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getSalary() {
        return salary;
    }

    public void displayLine(){
        System.out.println("----------------------------------------------------");
    }
    public static void main(String[] args) {
        Employee employee = new Employee();

        boolean exit = false;
        while (!exit){
            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println(" -> Welcome to Employee Management <-");
            System.out.println("  a. Add a new employee");
            System.out.println("  b. Delete employee by id");
            System.out.println("  c. Search employee by id");
            System.out.println("  d. Display all employees");
            System.out.println("  e. Exit the program");
            System.out.print("    make a Choice : ");
            String choice = input.nextLine();
            System.out.println();

            switch (choice) {
                case "a" -> {
                    employee.displayLine();
                    employee.readEmployee();
                    employee.displayLine();
                    employee.addEmployee();
                }
                case "b" -> {
                    Scanner sc = new Scanner(System.in);
                    employee.displayLine();
                    try{
                        System.out.print("Enter ID to remove employee: ");
                         int id = sc.nextInt();
                        Map<Integer, Employee> removeEmployee = employee.displayEmployee();
                        if (removeEmployee.containsKey(id)) {
                            employee.deleteEmployee(id);
                            System.out.println("Id removed successfully!");
                        } else {
                            System.out.println("Id not found...");
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Please Enter a number...");
                    }
                    employee.displayLine();
                }
                case "c" -> {
                    Scanner scanner = new Scanner(System.in);
                    employee.displayLine();
                    try {
                        System.out.print("Enter ID to search employee: ");
                        int searchId = scanner.nextInt();
                        Map<Integer, Employee> searchEmployee = employee.displayEmployee();
                        if (searchEmployee.containsKey(searchId)) {
                            Employee em = searchEmployee.get(searchId);
                            System.out.printf("| %-10s | %-10s | %-10s | %-10s|\n", "ID", "Name", "Gender", "Salary");
                            System.out.printf("| %-10d | %-10s | %-10s | %-10s|%n", em.getId(), em.getName(), em.getGender(), em.getSalary());
                        } else {
                            System.out.println("ID not found...!");
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Please Enter a number...");
                    }
                    employee.displayLine();
                }
                case "d" -> {
                    employee.displayLine();
                    Map<Integer, Employee> getEmployee = employee.displayEmployee();
                    System.out.println("Display all employees information: \n");
                    System.out.printf("| %-10s | %-10s | %-10s | %-10s|\n", "ID", "Name", "Gender", "Salary");
                    for (Map.Entry<Integer, Employee> em : getEmployee.entrySet()) {
                        Employee employee1 = getEmployee.get(em.getKey());
                        System.out.printf("| %-10d | %-10s | %-10s | %-10s|%n", employee1.getId(), employee1.getName(), employee1.getGender(), employee1.getSalary());
                    }
                    employee.displayLine();
                }
                case "e" -> {
                    employee.displayLine();
                    System.out.println("Exiting the program...");
                    exit = true;
                    employee.displayLine();
                }
                default -> {
                    employee.displayLine();
                    System.out.println("Invalid Input ...");
                    employee.displayLine();
                }
            }

        }
    }
}

