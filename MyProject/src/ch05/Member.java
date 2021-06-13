package ch05;

//1. Member 클래스에는 아래 요구사항에 맞는 변수와 메소드를 정의하고, 
//main()메소드 에 해당 메소드를 호출해서 결과를 확인해보세요. 
//단 인스턴스의 생성은 생성자를 이용해서 초기화하는 코드를 작성해 봅시다. 
// 생성자 > 초기화 메소드, 인스턴스를 생성할 때 단 한 번, 인스턴스 변수를 초기화

//① 아래의 데이터를 저장 (이름, 전화번호, 전공, 학년, email, 생일, 주소)
// 데이터를 저장 > 변수를 이용하여 메모리에 저장

//② 위에서 정의한 정보를 출력하는 메소드 정의 (기능>메소드)

//③ 모든 정보를 저장하도록 하는 생성자와 생일과 주소는 저장하지 않을 수 있는 생성자 정의
// 생성자의 요구사항 > 생성자 오버로딩, 오버로딩 > 이름이 같은 메소드 정의
// 생성자의 이름 (매개변수) {초기화 코드}
// 생성자의 이름은, 클래스의 이름
// 생성자는 반드시 하나 이상 존재해야 함

//접근제어 지시자 private 을 쓰는 이유
//클래스 내부의 멤버들만 참조가 가능 : 정보 은닉, 변수의 데이터를 보호

//오버로딩의 조건 : 
// 1. 메소드의 이름은 같다
// 2. 매개변수의 개수가 틀리거나, 매개변수의 타입이 달라야 오버로딩이 성립

//④ main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력


// 직렬화
// 변수의 기능 1) Data 메모리 저장
//		    2) 주소 기능


public class Member {

	private String name; 
//클래스 영역에서 정의 > 
//인스턴스 변수, 인스턴스가 생성될 때 변수의 메모리 공간이 생성 된다.
	private String phonNum; //final로 넣어도 생성자의 초기화는 허용
	private String major;
	private int grade;
	private String email;
	private String birth;
	private String address;
	
	Member(String name, 
		   String phonNum, 
		   String major, 
		   int grade, 
		   String email) {
			
		this(name, phonNum, major, grade, email, null, null);
	}
	
	Member(String name, String phonNum, String major, int grade, String email, String birth, String address) {
		this.name = name;
		this.phonNum = phonNum;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.birth = birth;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonNum() {
		return phonNum;
	}

	public void setPhonNum(String phonNum) {
		this.phonNum = phonNum;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	void printInfo() {
		System.out.println("이름: "+name);
		System.out.println("전화번호: "+phonNum);
		System.out.println("전공: "+major+"학과");
		System.out.println("학년: "+grade+"학년");
		System.out.println("이메일: "+email);
		if(this.birth == null) {
			System.out.println("생일: ");
		} else {
			System.out.println("생일: " + birth);
		}
		
		if(this.address != null) {
			System.out.println("주소: " + address);
		} else {
			System.out.println("주소: ");
		}
	}

}
