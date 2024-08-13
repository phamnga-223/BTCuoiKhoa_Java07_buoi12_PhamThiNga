package application;

import java.util.ArrayList;
import java.util.List;

import entity.Company;
import entity.Employee;
import service.EmployeeService;

public class MainApplication {

	public static void main(String[] args) {
		EmployeeService employeeDAO = new EmployeeService();
		
		Company company = new Company();
		List<Employee> list = new ArrayList<Employee>();
		int menu;
		
		do {
			//B1: Đưa ra menu
			menu = employeeDAO.menu();
			
			//B2: Xử lý theo yêu cầu menu		
			switch (menu) {
				case 1:
					company.inputData();
					company.displayInfo();
					list = new ArrayList<Employee>();
					
					break;
				case 2:
					list.addAll(employeeDAO.inputBatchData());
					employeeDAO.displayInfo(list);
					
					break;
				case 3:
					double subMenu = employeeDAO.subMenu();
					
					if (subMenu == 3.1) {
						Employee e = employeeDAO.inputData();
						list.add(e);
					} else if (subMenu == 3.2) {
						employeeDAO.deleteEmployee(list);
					} else {
						System.out.println("Submenu is invalid!");
					}			
					
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
					employeeDAO.arrangeByName(list);
					
					break;
				case 9:
					employeeDAO.arrangeBySalary(list);
					
					break;
				case 10:
					employeeDAO.maxStock(list);
					
					break;
				case 11:
					employeeDAO.directorIncome(company, list);
					
					break;
				default:
					System.out.println("Menu is invalid!");
					return;
				}
		} while (true);
	}

}
