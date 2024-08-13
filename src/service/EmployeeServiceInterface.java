package service;

import java.util.List;

import entity.Company;
import entity.Employee;

public interface EmployeeServiceInterface {

	public int menu();
	
	public double subMenu();

	public Employee inputData();

	public List<Employee> inputBatchData();
	
	public void displayInfo(List<Employee> list);
	
	public int findEmployee(List<Employee> list, String id);
	
	public int findEmployeeByDepartment(List<Employee> list, String department);
	
	public void deleteEmployee(List<Employee> list);
	
	public void maxStock(List<Employee> list);
	
	public void calculateSalary(List<Employee> list);
	
	public void maxSalary(List<Employee> list);
	
	public void hasMaxEmployee(List<Employee> list);
	
	public void directorIncome(Company company, List<Employee> list);
	
	public void arrangeByName(List<Employee> list);
	
	public void arrangeBySalary(List<Employee> list);
}
