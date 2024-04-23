package employee2;

import java.util.Scanner;

import employee2.utilEmployee;

public class main {
	private static utilEmployee EmployeeUtil;
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        EmployeeUtil = new utilEmployee();
        EmployeeUtil.addPredefinedEmployees();
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Display");
            System.out.println("2. New entry");
            System.out.println("3. Delete");
            System.out.println("0. Exit");
            System.out.println("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    EmployeeUtil.printListEmployee();
                    break;
                case 2:
                    System.out.println("Enter the number of employees to enter:");
                    int numberInput = scanner.nextInt();
                    scanner.nextLine(); 
                    EmployeeUtil.addList(numberInput);
                    break;
                case 3:
                    System.out.println("Enter the ID of the employee to be deleted:");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine(); 
                    EmployeeUtil.removeEmployee(idToDelete);
                    break;
                case 0:
                    System.out.println("Exit the program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid selection!");
            }
        }
    }
}
