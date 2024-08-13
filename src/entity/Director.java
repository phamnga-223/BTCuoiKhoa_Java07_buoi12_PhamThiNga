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
	
	@Override
	public void inputData() {
		super.inputData();
		
		try {
			do {
				System.out.print("Stock: ");
				this.stock = this.getScanner().nextDouble();
			} while (this.stock < 0);
		} catch (Exception ex) {
			System.out.println("Error!");
			ex.printStackTrace();
		}
	}
}
