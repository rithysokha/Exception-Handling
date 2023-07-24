package Exercise6;

import java.util.HashMap;
public class Employee {
    private int id;
    private String name;
    private String gender;
    private int salary;

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
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public Employee( String name, String gender, int salary){
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }
    public HashMap<Integer, Employee> employeeList = new HashMap<>();

    void readEmployee(int employeeID){
        System.out.println();
    }
    void addEmployee(int employeeID){
        System.out.println();
    }
    void deleteEmployee(int employeeID){
        System.out.println();
    }
}
