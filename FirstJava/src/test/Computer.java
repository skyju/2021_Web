package test;

public class Computer extends Product {

	public Computer(int price) {
		super(price);
	}
	
	public String toString() {
		//return "제품: Compute [price="+price+", bounusPoint="+bonusPoint+"]";
		return "Computer";
	}
}
