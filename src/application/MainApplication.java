package application;

import java.util.ArrayList;
import java.util.List;

import bussiness.EmployeeDAO;
import entity.Company;
import entity.Employee;

public class MainApplication {

	public static void main(String[] args) {
		EmployeeDAO employeeDAO = new EmployeeDAO();

		//B1: Đưa ra menu
		int menu = employeeDAO.menu();
		
		//B2: Xử lý theo yêu cầu menu
		Company company = new Company();
		List<Employee> list = new ArrayList<Employee>();
		switch (menu) {
		case 1:
			company.inputData();
			company.displayInfo();
			
			break;
		case 2:
			list = employeeDAO.inputData();
			employeeDAO.displayInfo(list);
			
			break;
		case 3:			
			employeeDAO.deleteEmployee(list);
			
			break;
		case 4:
			employeeDAO.displayInfo(list);
			
			break;
		case 5:
			employeeDAO.calculateSalary(list);
			
			break;
		case 6:
			employeeDAO.maxSalary(list);
			
			break;
		case 7:
			employeeDAO.hasMaxEmployee(list);
			
			break;
		case 8:
			employeeDAO.sapXepTenNV(list);
			
			break;
		case 9:
			employeeDAO.sapXepLuong(list);
			
			break;
		case 10:
			employeeDAO.maxStock(list);
			
			break;
		case 11:
			employeeDAO.directorIncome(company, list);
			
			break;
		default:
			System.out.println("Menu is invalid!");
			break;
		}
	}

}
