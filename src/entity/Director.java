package entity;

public class Director extends Employee {
	
	private double stock;
	
	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}
	
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Stock: " + this.stock);
	}
}
