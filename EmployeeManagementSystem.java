/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {

    
    public static class Employee {
        private String name;
        private int id;
        private String designation;
        private double salary;

        public Employee(String name, int id, String designation, double salary) {
            this.name = name;
            this.id = id;
            this.designation = designation;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: $" + salary;
        }
    }

   
    public static class EmployeeManager {
        private ArrayList<Employee> employees = new ArrayList<>();

        public void addEmployee(String name, int id, String designation, double salary) {
            employees.add(new Employee(name, id, designation, salary));
            System.out.println("Employee added.");
        }

        public void removeEmployee(int id) {
            boolean removed = false;
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getId() == id) {
                    employees.remove(i);
                    System.out.println("Employee with ID " + id + " removed.");
                    removed = true;
                    break;
                }
            }
            if (!removed) {
                System.out.println("Employee with ID " + id + " not found.");
            }
        }

        public void editEmployee(int id, String newDesignation, double newSalary) {
            boolean updated = false;
            for (Employee employee : employees) {
                if (employee.getId() == id) {
                    employee.setDesignation(newDesignation);
                    employee.setSalary(newSalary);
                    System.out.println("Employee with ID " + id + " updated.");
                    updated = true;
                    break;
                }
            }
            if (!updated) {
                System.out.println("Employee with ID " + id + " not found.");
            }
        }

        public void displayAllEmployees() {
            if (employees.isEmpty()) {
                System.out.println("No employees to display.");
            } else {
                System.out.println("Displaying all employees:");
                for (Employee employee : employees) {
                    System.out.println(employee);
                }
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        Scanner input = new Scanner(System.in);
        int choice = 0;

        
        employeeManager.addEmployee("Ali", 1, "Founder", 50000);
        employeeManager.addEmployee("Ahmed", 2, "CEO", 45000);
        employeeManager.addEmployee("Karim", 3, "Manager", 60000);

        
        while (choice != 5) {
            System.out.println("\nEmployee Management System:");
            System.out.println("1. Display all employees");
            System.out.println("2. Remove an employee");
            System.out.println("3. Edit employee details");
            System.out.println("4. Add a new employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    employeeManager.displayAllEmployees();
                    break;

                case 2:
                    System.out.print("Enter the ID of the employee to remove: ");
                    int removeId = input.nextInt();
                    employeeManager.removeEmployee(removeId);
                    employeeManager.displayAllEmployees();  // Display updated list
                    break;

                case 3:
                    System.out.print("Enter the ID of the employee to edit: ");
                    int editId = input.nextInt();
                    System.out.print("Enter new designation: ");
                    input.nextLine();  // Consume newline
                    String newDesignation = input.nextLine();
                    System.out.print("Enter new salary: ");
                    double newSalary = input.nextDouble();
                    employeeManager.editEmployee(editId, newDesignation, newSalary);
                    employeeManager.displayAllEmployees();  // Display updated list
                    break;

                case 4:
                    System.out.print("Enter employee name: ");
                    input.nextLine();  // Consume newline
                    String name = input.nextLine();
                    System.out.print("Enter employee ID: ");
                    int id = input.nextInt();
                    System.out.print("Enter employee designation: ");
                    input.nextLine();  // Consume newline
                    String designation = input.nextLine();
                    System.out.print("Enter employee salary: ");
                    double salary = input.nextDouble();
                    employeeManager.addEmployee(name, id, designation, salary);
                    employeeManager.displayAllEmployees();  // Display updated list
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        input.close();
    }
}
