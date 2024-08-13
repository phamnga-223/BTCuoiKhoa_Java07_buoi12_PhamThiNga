package entity;

public class DepartmentManager extends Employee {

	private int employeeNumber;
	
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@Override
	public long calculateSalary() {
		return super.calculateSalary() + 100 * employeeNumber;
	}
	
	@Override
	public void inputData() {
		super.inputData();
		
		try {
			do {
				System.out.println("Number of employees");
				this.employeeNumber = getScanner().nextInt();
			} while (this.employeeNumber < 0);
		} catch (Exception ex) {
			System.out.println("Error!");
			ex.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return super.toString() + "DepartmentManager [employeeNumber=" + employeeNumber + "]";
	}
	
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Employee Number: " + this.employeeNumber);
	}
}
