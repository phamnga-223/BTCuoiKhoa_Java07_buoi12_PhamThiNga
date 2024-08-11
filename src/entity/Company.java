package entity;

import java.util.Scanner;

public class Company {

	private Scanner scanner;

	private String name;
	private String id;
	private long revenue;

	public long getRevenue() {
		return revenue;
	}

	public void setRevenue(long revenue) {
		this.revenue = revenue;
	}

	public void displayInfo() {
		System.out.println("Company Name: " + this.name + "; Id: " + this.id
				+ "; Revenue: " + this.revenue);
	}
	
	public void inputData() {
		try {
			System.out.println("Input company's infomation: ");
			this.scanner = new Scanner(System.in);
			
			//Company name
			do {
				System.out.print("Company's name: ");
				this.name = this.scanner.nextLine();
			} while (this.name.strip().equals(""));
			
			//Id
			do {
				System.out.print("Company's id: ");
				this.id = this.scanner.nextLine();
			} while (this.id.strip().equals(""));
			
			//Revenue
			do {
				System.out.print("Company's revenue: ");
				this.revenue = this.scanner.nextLong();
			} while (this.revenue < 0);
		} catch (Exception ex) {
			System.out.println("Error!");
			ex.printStackTrace();
		}
	}
}
