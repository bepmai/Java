package employee2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import employee2.employee;

public class utilEmployee {
	private Scanner scanner = new Scanner(System.in);

	private List<employee> listEmployee = new ArrayList<>();;
	private List<employee> predefinedEmployees = new ArrayList<>();

	public utilEmployee() {
	}
	
	public void addPredefinedEmployees() {
	    predefinedEmployees.add(new employee(1, "John", 25, "Department A", "001ee", 2000));
	    predefinedEmployees.add(new employee(2, "Alice", 30, "Department B", "002ee", 2500));
	    predefinedEmployees.add(new employee(3, "Jymy", 30, "Department C", "003ee", 2500));
	    predefinedEmployees.add(new employee(4, "Lili", 30, "Department D", "004ee", 2500));
	    predefinedEmployees.add(new employee(5, "Sam", 30, "Department E", "005ee", 2500));
	    predefinedEmployees.add(new employee(6, "Jaky", 30, "Department F", "006ee", 2500));
	    predefinedEmployees.add(new employee(7, "Tom", 30, "Department G", "007ee", 2500));
	    predefinedEmployees.add(new employee(8, "Heny", 30, "Department H", "008ee", 2500));
	    predefinedEmployees.add(new employee(9, "Kiny", 30, "Department I", "009ee", 2500));
	    predefinedEmployees.add(new employee(10, "Lyi", 30, "Department J", "0010ee", 2500));
	    
	    listEmployee.addAll(predefinedEmployees);
	}


	private void addEmploy(employee e) {
		listEmployee.add(e);
	}
	
	public void addList(int numberStaff) {
	    System.out.println("-----------PARTTIME STAFF--------");
	    int nextId = listEmployee.size() + predefinedEmployees.size();
	    for (int i = 0; i < numberStaff; i++) {
	        nextId += 1;
	        employee e = new employee();
	        e.setID(nextId);
	        boolean isValidate = true; 
	        
	        while (isValidate) {
	            System.out.println("--Staff " + nextId);
	            System.out.println("Enter name           :");
	            e.setName(scanner.nextLine());
	            System.out.println("Enter age :");
	            e.setAge(Integer.parseInt(scanner.nextLine()));
	            System.out.println("Enter department      :");
	            e.setDepartment(scanner.nextLine());
	            System.out.println("Enter code   :");
	            e.setCode(scanner.nextLine());
	            System.out.println("Enter salary rate   :");
	            e.setSalaryRate(Integer.parseInt(scanner.nextLine()));

	            isValidate = checkValidate(e);
	        }
	        addEmploy(e);
	    }
	}

	
	private boolean checkValidate(employee e) {
		if (e.getName().isEmpty() || e.getName().isBlank()) {
			System.out.println("** Invalid name !");
			return true;
		}else if(e.getAge() >= 60 || e.getAge() <= 20) {
			System.out.println("** Invalid age !");
			return true;
		}else if (e.getDepartment().isEmpty() || e.getDepartment().isBlank()) {
			System.out.println("** Invalid department !");
			return true;
		}else if (e.getCode().isEmpty() || e.getCode().isBlank()) {
			System.out.println("** Invalid code !");
			return true;
		}else {
			System.out.println("** Success **");
			return false;
		}
	}
	
	public void printListEmployee() {
	    System.out.println("-----------LIST OF EMPLOYEE--------");
	    
	    System.out.println("Available:");
	    for (employee emp : predefinedEmployees) {
	        printEmploy(emp);
	    }
	    
	    System.out.println("Added:");
	    for (employee emp : listEmployee) {
	        printEmploy(emp);
	    }
	}

	private void printEmploy(employee emp) {
	    System.out.println("----ID : " + emp.getID() + " ---");
	    System.out.println(" Name: " + emp.getName());
	    System.out.println(" Age: " + emp.getAge());
	    System.out.println(" Department: " + emp.getDepartment());
	    System.out.println(" Code: " + emp.getCode());
	    System.out.println(" Salary rate: " + emp.getSalaryRate());
	}


	private void printEmploy(int i) {
		System.out.println("----ID : "+listEmployee.get(i).getID() +" ---");
		System.out.println(" Name: "+ listEmployee.get(i).getName());
		System.out.println(" Age: "+ listEmployee.get(i).getAge());
		System.out.println(" Department: "+ listEmployee.get(i).getDepartment());
		System.out.println(" Code: "+ listEmployee.get(i).getCode());
		System.out.println(" Salary rate: "+ listEmployee.get(i).getSalaryRate());
	}
	
	public List<employee> getListParttime(){
		return listEmployee;
	}
	
	public void removeEmployee(int id) {
	    Iterator<employee> iterator = listEmployee.iterator();
	    while (iterator.hasNext()) {
	        employee emp = iterator.next();
	        if (emp.getID() == id) {
	            iterator.remove();
	            System.out.println("The employee with ID " + id + " has been deleted.");
	            return;
	        }
	    }
	    System.out.println("No employee ID found " + id + ".");
	}
}
