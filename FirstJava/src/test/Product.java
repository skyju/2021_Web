package test;

public class Product {
	final int price;
	int bonusPoint;
	
	public Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}
