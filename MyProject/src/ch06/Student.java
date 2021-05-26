package ch06;

// 배열 > 변수의 집합: 변수를 묶음으로 사용
// 	왜 사용? 사용해야하는 같은 타입, 같은 성격의 변수가 많을 때 사용
// 	class도 타입이다 > 참조형 타입
// 	참조형 타입의 배열 : 참조변수?인스턴스의 주조를 저장 > 객체 배열

// 배열 선언 방법 >
// 	1차원 배열: 타입[] 식별자(배열이름) = new 타입[size]
// 	ex) int[] score = new int[10];
// 	index > 주소가 순서대로 연결되어 있기 때문에 > for 사용
//	마찬가지로 Collection, List > for 사용

public class Student {
	private String name;
	private int korScore;
	private int engScore;
	private int mathScore;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name; 
	}
	public int getKorScore() {
		return korScore;
	}
	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}
	public int getEngScore() {
		return engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	Student(){}
	Student(String name, int korScore, int engScore, int mathScore){
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	
	public int totalScore() {
		return korScore+engScore+mathScore;
	}
	
	public double avgScore() {
		return (korScore+engScore+mathScore)/3;
	}
	
	public void printInfo() {
		System.out.println("  이름  : "+getName());
		System.out.println("국어 점수: "+getKorScore());
		System.out.println("영어 점수: "+getEngScore());
		System.out.println("수학 점수: "+getMathScore());
		System.out.println("  총점  : "+totalScore());
		System.out.println("  평균  : "+avgScore());
		System.out.println("=====================");
	}
	
	public static void main(String[] args) {
		Student[] stu = new Student[10];
		stu[0] = new Student("홍길동",45,88,74);
		stu[1] = new Student("홍길은",71,84,98);
		stu[2] = new Student("홍길금",97,58,66);
		stu[3] = new Student("아무개",78,96,92);
		stu[4] = new Student("김자바",73,92,87);
		stu[5] = new Student("이자바",92,53,67);
		stu[6] = new Student("박자바",61,22,54);
		stu[7] = new Student("최자바",73,73,64);
		stu[8] = new Student("홍자바",42,57,44);
		stu[9] = new Student("현자바",88,98,97);
		
		int korSum = 0;
		int engSum = 0;
		int mathSum = 0;
		for(int inx = 0 ; inx < stu.length ; inx ++) {
			stu[inx].printInfo();
			korSum += stu[inx].getKorScore();
			engSum += stu[inx].getEngScore();
			mathSum += stu[inx].getMathScore();
		}
		
		//++
		double korAverage = (double)korSum/stu.length;
		double engAverage = (double)engSum/stu.length;
		double mathAverage = (double)mathSum/stu.length;
		System.out.println("총 국어 점수 평균: "+korAverage);
		System.out.println("총 영어 점수 평균: "+engAverage);
		System.out.println("총 수학 점수 평균: "+mathAverage);
		
		
	}

}
