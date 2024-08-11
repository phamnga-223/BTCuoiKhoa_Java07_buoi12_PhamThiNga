package bussiness;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Company;
import entity.DepartmentManager;
import entity.Director;
import entity.Employee;
import entity.Staff;

public class EmployeeDAO implements EmployeeInterface {

	static final int STAFF_TYPE = 0;
	static final int DEPARTMENT_MANAGER_TYPE = 1;
	static final int DIRECTOR_TYPE = 2;
	
	private Scanner scanner;
	
	public EmployeeDAO() {
		this.scanner = new Scanner(System.in);
	}

	@Override
	public int findEmployee(List<Employee> list, String id) {
		if (list == null || list.size() == 0) {
			return -1;
		}
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				return i;
			}
		}
		
		return -1;
	}

	@Override
	public void deleteEmployee(List<Employee> list) {
		try {
			String id;
			do {
				System.out.println("Xin vui lòng nhập Id nhân viên muốn xóa");
				id = this.scanner.nextLine().strip();
			} while (id.strip().equals(""));
			
			if (list == null || list.size() == 0) {
				System.out.println("List employee is empty!");
				return;
			}
			
			EmployeeDAO employeeDao = new EmployeeDAO();		
			int index = employeeDao.findEmployee(list, id);
			if (index < 0) {
				System.out.println("Employee not found. Delete Finish!");
			} else {
				if (list.get(index) instanceof Staff) {			
				//B1: Update số nhân viên dưới quyền của trưởng phòng liên quan
					String department = ((Staff) list.get(index)).getDepartment();
					index = employeeDao.findEmployee(list, department);
					if (index < 0) {
						System.out.println("Not found Department!");
						return;
					}
					
					DepartmentManager departmentManager = (DepartmentManager) list.get(index);
//					departmentManager.update();
				}
				
				//B2: Xóa thông tin ở list
				list.remove(index);
				
				System.out.println("Delete Finish!");
			}
		} catch (Exception ex) {
			System.out.println("Error!");
			ex.printStackTrace();
		}
	}

	@Override
	public void displayInfo(List<Employee> list) {
		if (list == null || list.size() == 0) {
			System.out.println("Empty list!");
			return;
		}
		
		for (Employee e : list) {
			e.displayInfo();
		}
	}
	
	public void maxStock(List<Employee> list) {
		if (list == null || list.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
		
		double max = 0;
		for (Employee e : list) {
			if (e instanceof Director) {
				double stock = ((Director)e).getStock();
				if (max < stock) {
					max = stock;
				}
			}
		}
		
		System.out.println("Giám đốc có số cổ phần nhiều nhất là: ");
		for (Employee e : list) {
			if (e instanceof Director) {
				double stock = ((Director)e).getStock();
				if (max == stock) {
					e.displayInfo();;
				}
			}
		}
	}

	/**
	 * Thu nhập giám đốc = Lương tháng + Số cổ phần * Lợi nhuận công ty
	 * Lợi nhuận công ty = Doanh thu tháng của công ty - Tổng lương toàn công ty trong tháng.
	 */
	@Override
	public void directorIncome(Company company, List<Employee> list) {
		//B1: Tính lương toàn công ty
		long summarySalary = 0;
		for (Employee e : list) {
			summarySalary += e.calculateSalary();
		}
		
		//B2: Lợi nhuận công ty
		long loiNhuan = company.getRevenue() - summarySalary;
		
		//B2: Tính thu nhập từng giám đốc, In ra kết quả
		for (Employee e : list) {
			if (e instanceof Director) {
				long income = (long) (e.calculateSalary() + (((Director) e).getStock() / 100) * loiNhuan);
				e.displayInfo();
				System.out.println("Tổng thu nhập: " + income);
			}
		}
	}

	@Override
	public void sapXepLuong(List<Employee> list) {
		List<Long> listSalary = new ArrayList<Long>();
		for (Employee e : list) {
			listSalary.add(e.calculateSalary());
		}
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (listSalary.get(i) < listSalary.get(j)) {
					swap(list, i, j);
				}
			}
		}
		
		//In kết quả ra màn hình
		System.out.println("Sắp xếp theo thứ tự lương giảm dần: ");
		for (Employee e : list) {
			e.displayInfo();
		}		
	}
	
	@Override
	public void sapXepTenNV(List<Employee> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = list.size() - 1; j > i; j--) {
				int compare = list.get(i).getName().compareTo(list.get(j).getName());
				if (compare > 0) {
					swap(list, i, j);
				}
			}
		}		
	}
	
	public static void swap (List<Employee> list, int i, int j) {
		Employee e = list.get(i);
		list.set(i, list.get(j));
		list.set(j, e);
	}

	@Override
	public void hasMaxEmployee(List<Employee> list) {
		int max = 0;
		for (Employee e : list) {
			if (e instanceof DepartmentManager) {
				int number = ((DepartmentManager) e).getEmployeeNumber();
				if (max < number) {
					max = number;
				}
			}
		}
		
		for (Employee e : list) {
			if (e instanceof DepartmentManager) {
				int number = ((DepartmentManager) e).getEmployeeNumber();
				if (max == number) {
					e.displayInfo();
				}
			}
		}
	}

	@Override
	public void maxSalary(List<Employee> list) {
		long max = 0;
		for (Employee e : list) {
			if (e instanceof Employee) {
				long salary = e.calculateSalary();
				if (max < salary) {
					max = salary;
				}
			}
		}
		
		for (Employee e : list) {
			if (e instanceof Employee) {
				long salary = e.calculateSalary();
				if (max == salary) {
					e.displayInfo();
				}
			}
		}		
	}

	@Override
	public void calculateSalary(List<Employee> list) {
		for (Employee e : list) {
			System.out.println("Calculate salary: " + e.calculateSalary());
		}
	}

	@Override
	public int menu() {
		int menu = -1;
			
		try {
			System.out.println("Menu: \n"
					+ "1. Input company's information \n"
					+ "2. Add new Deparment Manager \n"
					+ "3. Add/Delete 1 Employee \n"
					+ "4. Print all employees \n"
					+ "5. Calculate + Print salary for all employees \n"
					+ "6. Find Employee has max salary \n"
					+ "7. Find Department Manager has max number of employees \n"
					+ "8. Sx employees by abc \n"
					+ "9. Sx employees by salary desc \n"
					+ "10. Find Director has max stocks \n"
					+ "11. Calculate + Print Director's summary income");
			menu = this.scanner.nextInt();
		} catch (Exception ex) {
			System.out.println("Error!");
			ex.printStackTrace();
		}
			
		return menu;
	}

	@Override
	public List<Employee> inputData() {
		List<Employee> list = new ArrayList<Employee>();
		
		try {
			//B1: Nhập số nhân viên
			int n = 0;
			do {
				System.out.print("Please enter number of employees: ");
				n = this.scanner.nextInt();
			} while (n <= 0);
			
			//B2: Nhập danh sách nhân viên
			for (int i = 0; i < n; i++) {
				System.out.println("Enter employee " + i);
				
				//Kiểu nhân viên
				int employeeType;
				do {
					System.out.println("Please choose employee's type: \n"
							+ " 0: Staff \n"
							+ " 1: Department Manager \n"
							+ " 2: Director");
					employeeType = this.scanner.nextInt();
				} while (employeeType != STAFF_TYPE && employeeType != DEPARTMENT_MANAGER_TYPE && employeeType != DIRECTOR_TYPE);
				
				switch (employeeType) {
					case STAFF_TYPE:
						Employee e = new Staff();
						e.inputData();
						list.add(e);

						break;
						
					case DEPARTMENT_MANAGER_TYPE:
						e = new DepartmentManager();
						e.inputData();
						list.add(e);
						
						break;
						
					case DIRECTOR_TYPE:
						e = new Director();
						e.inputData();
						list.add(e);
						
						break;
					default:
						System.out.println("Employee's type is invalid!");
						break;
				}
			}
		} catch (Exception ex) {
			System.out.println("Error!");
			ex.printStackTrace();
		}
		
		return list;
	}
}
