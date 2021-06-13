package ex.arrayInheritance;

public class Buyer {

	int money = 1000;
	int bonusPoint = 0;
	Product[] item;
	int cnt; // 구매한 제품의 개수 > 배열의 입력 index값
	
	
	public Buyer() {
		this.money = 1000;
		this.bonusPoint = 0;
		this.item = new Product[10];
		this.cnt = 0;
	}
	
	void buy(Product p) {
		if(this.money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살수 없습니다.");
			return; //void인데 return 왜함? -> 메서드의 종료
			// return 의 2가지 기능 1) 메서드의 종료 2) 값의 반환
		}
		this.money -= p.price;
		this.bonusPoint += p.bonusPoint;
		item[cnt++] = p;
		//cnt++; 이거 한줄 줄이기위해 위에 대괄호안에 후위증가 넣은 거
		
		System.out.println(p + "구매 완료했습니다.");
	}
	
	void summary() {
		//구매 상품 리스트, 구매 금액의 총합 출력
		int sum = 0;
		int bonusPoint = 0;
		String itemList = "";
		
		for(int i = 0 ; i < cnt ; i ++) {
			if(item[i] == null) {
				break;
			}
			sum += item[i].price;
			bonusPoint += item[i].bonusPoint;
			//itemList += item[i] + ",";
			itemList += (i==0) ? ""+item[i] : ", "+item[i];
		}
		System.out.println("구입하신 물품의 총금액 : "+sum+"만원");
		System.out.println("구입하신 물품의 총목록 : "+itemList);
		System.out.println("현재 누적 적립 포인트 : "+bonusPoint+"점");
	}
	
}
