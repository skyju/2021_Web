package ch06;

public class StudentMain {

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
