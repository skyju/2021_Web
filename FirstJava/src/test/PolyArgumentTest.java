package test;

class PolyArgumentTest {
	public static void main(String args[]) {
		Buyer b = new Buyer();
		Tv tv = new Tv(100);
		Computer com = new Computer(200);
		b.buy(tv);
		b.buy(com);
		System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
		System.out.println("현재 보너스점수는 " + b.bonusPoint + "점입니다.");
	}
}