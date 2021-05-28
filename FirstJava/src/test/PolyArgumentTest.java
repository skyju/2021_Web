package test;

class PolyArgumentTest {
	public static void main(String args[]) {
		Buyer buyer = new Buyer();
		Tv tv = new Tv(100);
		Computer com = new Computer(200);
		buyer.buy(tv);
		buyer.buy(com);
		buyer.buy(tv);
		buyer.buy(com);
//		System.out.println("현재 남은 돈은 " + buyer.money + "만원입니다.");
		buyer.summary();
	}
}