package employee2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import employee2.employee;
// phương thức quản lý nhân viên 
public class utilEmployee {
	private Scanner scanner = new Scanner(System.in); //đọc dữ liệu từ đầu vào tiêu chuẩn của hệ thống

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
	
	public void addList(int numberEmployee) {
	    System.out.println("-----------PARTTIME STAFF--------");
	    int nextId = listEmployee.size() + predefinedEmployees.size();
	    for (int i = 0; i < numberEmployee; i++) {
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
		if (e.getName().isEmpty()) {
			System.out.println("** Invalid name !");
			return true;
		}else if(e.getAge() >= 60 || e.getAge() <= 20) {
			System.out.println("** Invalid age !");
			return true;
		}else if (e.getDepartment().isEmpty()) {
			System.out.println("** Invalid department !");
			return true;
		}else if (e.getCode().isEmpty()) {
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
//	    	predefinedEmployees là một danh sách các nhân viên được xác định trước.
//	    	employee emp định nghĩa một biến emp kiểu employee, trong đó employee là tên của lớp hoặc kiểu dữ liệu đối tượng nhân viên.
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

	
	public void removeEmployee(int id) {
	    Iterator<employee> iterator = listEmployee.iterator(); // lặp qua các phẩn tử trong ds
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
//	Iterator là một giao diện (interface) thuộc gói java.util. Nó được sử dụng để lặp qua các phần tử của một tập hợp (collection), và cung cấp các phương thức để truy cập và xóa các phần tử trong tập hợp đó
}
