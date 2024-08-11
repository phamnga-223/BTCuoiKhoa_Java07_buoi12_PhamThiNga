package bussiness;

import java.util.List;

import entity.Company;
import entity.Employee;

public interface EmployeeInterface {

	public int menu();

	public List<Employee> inputData();
	
	public void displayInfo(List<Employee> list);
	
	public int findEmployee(List<Employee> list, String id);
	
	public void deleteEmployee(List<Employee> list);
	
	public void maxStock(List<Employee> list);
	
	public void calculateSalary(List<Employee> list);
	
	public void maxSalary(List<Employee> list);
	
	public void hasMaxEmployee(List<Employee> list);
	
	public void directorIncome(Company company, List<Employee> list);
	
	public void sapXepTenNV(List<Employee> list);
	
	public void sapXepLuong(List<Employee> list);
}
