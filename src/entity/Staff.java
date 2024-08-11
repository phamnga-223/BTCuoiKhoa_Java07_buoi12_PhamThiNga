package entity;

import java.util.List;

public class Staff extends Employee {

	private String department;
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public void inputData() {
		super.inputData();
		
		try {
			do {
				System.out.println("Department: ");
				this.department = super.getScanner().nextLine();
			} while (this.department.strip().equals(""));
		} catch (Exception ex) {
			System.out.println("Error!");
			ex.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + "; Department: " + this.department;
	}
	
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Department: " + this.department);
	}
	
	public int findEmployeeByDepartment(List<Employee> list, String department) {
		if (list == null || list.size() == 0) {
			System.out.println("List employee is empty!");
			return -1;
		}
	
		for (int i = 0; i < list.size(); i++) {
			Employee e = list.get(i);
			if (e instanceof Staff && ((Staff) e).department.equals(department)) {
				return i;
			}
		}
		
		return -1;
	}
}
