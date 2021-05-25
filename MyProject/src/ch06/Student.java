package ch06;

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
	public int getEngScor() {
		return engScore;
	}
	public void setEngScor(int engScore) {
		this.engScore = engScore;
	}
	public int getMathScor() {
		return mathScore;
	}
	public void setMathScor(int mathScore) {
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
	
	public int avgScore() {
		return (korScore+engScore+mathScore)/3;
	}
	
	public void printInfo() {
		System.out.println(" 이름     : "+getName());
		System.out.println("국어 점수: "+getKorScore());
		System.out.println("영어 점수: "+getEngScor());
		System.out.println("수학 점수: "+getMathScor());
		System.out.println(" 총점     : "+totalScore());
		System.out.println(" 평균     : "+avgScore());
		System.out.println();
	}
	
	public static void main(String[] args) {
		Student[] stu = new Student[10];
		stu[0] = new Student("홍길동",45,88,74);
		stu[1] = new Student("홍길은",71,84,98);
		stu[2] = new Student("홍길금",97,58,66);
		stu[3] = new Student("아무개",98,96,92);

		stu[0].printInfo();
		stu[1].printInfo();
		stu[2].printInfo();
		stu[3].printInfo();
		
		
	}

}
