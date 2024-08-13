package entity;

import java.util.List;
import java.util.Scanner;

public class Employee {
	
	private Scanner scanner;
	
	private String id;
	private String name;
	private String phone;
	private double workDay;
	private long salaryPerDay;
	private String department;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getSalaryPerDay() {
		return salaryPerDay;
	}

	public void setSalaryPerDay(long salaryPerDay) {
		this.salaryPerDay = salaryPerDay;
	}

	public double getWorkDay() {
		return workDay;
	}

	public void setWorkDay(double workDay) {
		this.workDay = workDay;
	}
	
	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public long calculateSalary() {
		return (long) (this.salaryPerDay * workDay);
	}
	
	public void inputData() {
		try {
			this.scanner = new Scanner(System.in);
			System.out.println("Please enter some information about employee : ");
			
			do {
				System.out.print("id: ");
				this.id = this.scanner.nextLine();
			} while (this.id.strip().equals(""));

			do {
				System.out.print("Name: ");
				this.name = this.scanner.nextLine();
			} while (this.name.strip().equals(""));
			
			do {
				System.out.print("Phone: ");
				this.phone = this.scanner.nextLine();
			} while (this.phone.strip().equals(""));
			
			do {
				System.out.println("Department: ");
				this.department = this.scanner.nextLine();
			} while (this.department.strip().equals(""));
			
			do {
				System.out.print("Salary per month: ");
				this.salaryPerDay = this.scanner.nextLong();
			} while (this.salaryPerDay < 0);			

			do {
				System.out.print("Work day: ");
				this.workDay = this.scanner.nextDouble();
			} while (this.workDay < 0);
		} catch (Exception ex) {
			System.out.println("Error!");
			ex.printStackTrace();
		}
	}
	
	public int findEmployeeById(List<Employee> list, String id) {
		if (list == null || list.size() == 0) {
			System.out.println("List employee is empty!");
			return -1;
		}
	
		for (int i = 0; i < list.size(); i++) {
			Employee e = list.get(i);
			if (e.id.equals(id)) {
				return i;
			}
		}
		
		return -1;
	}

	public void displayInfo() {
		System.out.println("Employee Id=" + id + ", name=" + name + ", phone=" + phone
				+ ", department= " + this.department + ", salaryPerDay=" + salaryPerDay	+ ", workDay=" + workDay);
	}
}
