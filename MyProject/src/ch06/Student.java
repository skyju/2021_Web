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

}
