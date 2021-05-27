package homework2_inheritance;

class Car {
	int gasolineGauge;
	
	Car(int gasolineGauge) {
		this.gasolineGauge = gasolineGauge;
	}
	
	public void showCurrentGauge() {
		System.out.println("잔여 가솔린게에지 : " + gasolineGauge);
	}
}

class HybridCar extends Car {
	int electronicGauge;
	
	HybridCar(int gasolineGauge, int electronicGauge) {
		super(gasolineGauge);
		this.electronicGauge = electronicGauge;
	}
	
	public void showCurrentGauge() {
		super.showCurrentGauge();
		System.out.println("잔여 전기게이지    : " + electronicGauge);
	}

}

class HybridWaterCar extends HybridCar {
	int waterGauge;
	
	HybridWaterCar(int gasolineGauge, int electronicGauge, int waterGauge) {
		super(gasolineGauge, electronicGauge);
		this.waterGauge = waterGauge;
	}

	public void showCurrentGauge() {
		super.showCurrentGauge();
		System.out.println("잔여 워터게이지    : " + waterGauge);
	}
}

public class InheritanceQ1 {

	public static void main(String[] args) {
		HybridWaterCar hwc = new HybridWaterCar(4, 4, 4);
		hwc.showCurrentGauge();
	}

}
