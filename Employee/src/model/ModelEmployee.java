package model;

public class ModelEmployee {
	private String ID;
	private String Name;
	private int Age;
	private String Department;
	private String Code;
	private int SalaryRate;
	
	public ModelEmployee() {
    }
	
	public ModelEmployee(String ID, String Name, int Age, String Department, String Code, int SalaryRate) {
		this.ID = ID;
		this.Name = Name;
		this.Age = Age;
		this.Department = Department;
		this.Code = Code;
		this.SalaryRate = SalaryRate;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public void setAge(int Age) {
		this.Age = Age;
	}
	
	public void setCode(String Code) {
		this.Code = Code;
	} 
	
	public void setDepartment(String Department) {
		this.Department = Department;
	}
	
	public void setSalaryRate(int SalaryRate) {
		this.SalaryRate = SalaryRate;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getName() {
		return Name;
	}
	
	public int getAge() {
		return Age;
	}
	
	public String getDepartment() {
		return Department;
	}
	
	public String getCode() {
		return Code;
	}
	
	public int getSalaryRate() {
		return SalaryRate;
	}
}
