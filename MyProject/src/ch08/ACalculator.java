package ch08;

public abstract class ACalculator implements ICalculator {
	public abstract long add(long n1, long n2); 
	public abstract long substract(long n1, long n2 ); 
	public abstract long multiply(long n1, long n2 ); 
	public abstract double divide(double n1, double n2 );
	public abstract void showResult();
}
