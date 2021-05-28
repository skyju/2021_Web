package test;

public class Buyer {

	int money = 1000;
	int bonusPoint = 0;
	
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살수 없습니다.");
			return;
		}
		money -= p.price; // 가진 돈에서 구입한 제품의 가격을 뺀다.
		bonusPoint += p.bonusPoint;// 제품의 보너스 점수를 추가한다.
		System.out.println(p + "을/를 구입하셨습니다.");
	}

}
