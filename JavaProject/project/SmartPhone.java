package project;

import java.util.*;

public class SmartPhone {
	
	Scanner kb = new Scanner(System.in);
	
	private Contact[] contact;
	private int contactNum;
	
	public SmartPhone(int num) {
		contact = new Contact[num];
		contactNum = 0;
	}
	
	void addContactInfo(Contact c) { //연락처 저장
		contact[contactNum++] = c;
	}
	
	void isEmpty(String string) {
		while(true) {
			if(string.equals("")) {
				System.out.println("공란입니다. 다시 입력해주세요.");
				string = kb.nextLine();
				continue;
			} else {
				break;
			}
		}
	}
	
	void addInfo() {
		System.out.println("이름을 입력해주세요: ");
		String name = kb.nextLine();
		isEmpty(name);
		System.out.println("전화번호를 입력해주세요: ");
		String phoneN = kb.nextLine();
		isEmpty(phoneN);
		System.out.println("이메일을 입력해주세요: ");
		String email = kb.nextLine();
		isEmpty(email);
		System.out.println("주소를 입력해주세요: ");
		String address = kb.nextLine();
		isEmpty(address);
		System.out.println("생년월일을 입력해주세요: ");
		String birth = kb.nextLine();
		isEmpty(birth);
		boolean chk = true;
		while(chk) {
			System.out.println("그룹을 선택해주세요");
	        System.out.println( "=================" );
			System.out.println("1. 회사");
			System.out.println("2. 거래처");
	        System.out.println( "=================" );
			try {
				int menu = kb.nextInt();
				switch (menu) {
				case 1: 
					kb.nextLine();
					String group1 = "회사";
					System.out.println("회사명을 입력해주세요.");
					String companyName = kb.nextLine();
					isEmpty(companyName);
					System.out.println("부서명을 입력해주세요.");
					String deptName = kb.nextLine();
					isEmpty(deptName);
					System.out.println("직급을 입력해주세요.");
					String gobGrade1 = kb.nextLine();
					isEmpty(gobGrade1);
					addContactInfo(new CompanyContact(
							name, phoneN, email, address, birth, group1
							, companyName, deptName, gobGrade1));
					System.out.println("저장 완료하였습니다.");
					chk = false;
					break;
				case 2:
					kb.nextLine();
					String group2 = "거래처";
					System.out.println("거래처명을 입력해주세요.");
					String custCompanyName = kb.nextLine();
					isEmpty(custCompanyName);
					System.out.println("거래품목을 입력해주세요.");
					String item = kb.nextLine();
					isEmpty(item);
					System.out.println("직급을 입력해주세요.");
					String gobGrade2 = kb.nextLine();
					isEmpty(gobGrade2);
					addContactInfo(new CustomerContact(
							name, phoneN, email, address, birth, group2
							, custCompanyName, item, gobGrade2));
					System.out.println("저장 완료하였습니다.");
					chk = false;
					break;
				default: 
					System.out.println("잘못된 번호입니다.");
					System.out.println("다시 입력해주세요.\n");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("숫자로 입력해주세요.\n");
				kb.nextLine(); //버퍼 비우기
			}
		}//while문 끝 
	}
	
	void findInfo() { //연락처 검색 => null pointer exception fixing 필요
					  // if조건에 != null 넣고 픽싱함
		if(contactNum > 0) {
			System.out.println("검색하실 연락처의 이름을 입력해주세요.");
			String name = kb.nextLine();
			int isIt = 0;
			for(int i = 0 ; i < contact.length ; i++ ) {
				if(contact[i] != null && name.equals(contact[i].getName())) {
					contact[i].showData();
					++isIt;
				}
			}
			if(isIt == 0) {
				System.out.println("검색 결과와 일치하는 연락처가 없습니다.");
			}
		} else {
			System.out.println("아직 저장된 연락처가 하나도 없습니다.");
		}
	}
	
	void selectMenu() {
		System.out.println("무엇을 수정하시겠습니까?");
        System.out.println( "=================" );
		System.out.println("1. 이름: ");
		System.out.println("2. 전화번호");
		System.out.println("3. 이메일");
		System.out.println("4. 주소");
		System.out.println("5. 생일");
		System.out.println("6. 그룹");
	}
	
	void updateInfo() { //연락처 수정
		if(contactNum > 0) {
			System.out.println("수정하실 연락처의 이름을 입력해주세요.");
			int isIt = 0;
			String name = kb.nextLine();
			for(int i = 0 ; i< contact.length ; i++ ) {
				if(contact[i] != null && name.equals(contact[i].getName())) {
					System.out.print("현재 데이터: ");
					contact[i].showData();
					selectMenu();
					if(contact[i] instanceof CompanyContact) {
						System.out.println("7. 소속회사");
						System.out.println("8. 부서명");
						System.out.println("9. 직급");
					} else {
						System.out.println("7. 거래처명");
						System.out.println("8. 거래품목");
						System.out.println("9. 직급");
					}
			        System.out.println( "=================" );
					int num = kb.nextInt();
					switch (num) {
					case 1:
						kb.nextLine(); //nextInt 버퍼비움
						System.out.println("새로운 이름을 입력해주세요.");
						String newName = kb.nextLine();
						contact[i].setName(newName);
						System.out.println("이름이 변경되었습니다.");
						break;
					case 2:
						kb.nextLine();
						System.out.println("새로운 전화번호를 입력해주세요.");
						String newPhoneNum = kb.nextLine();
						contact[i].setPhoneNum(newPhoneNum);
						System.out.println("전화번호가 변경되었습니다.");
						break;
					case 3:
						kb.nextLine();
						System.out.println("새로운 이메일을 입력해주세요.");
						String newEmail = kb.nextLine();
						contact[i].setEmail(newEmail);
						System.out.println("이메일이 변경되었습니다.");
						break;
					case 4:
						kb.nextLine();
						System.out.println("새로운 주소를 입력해주세요.");
						String newAddress = kb.nextLine();
						contact[i].setAddress(newAddress);
						System.out.println("주소가 변경되었습니다.");
						break;
					case 5:
						kb.nextLine();
						System.out.println("새로운 생일을 입력해주세요.");
						String newBirth = kb.nextLine();
						contact[i].setBirth(newBirth);
						System.out.println("생일이 변경되었습니다.");
						break;
					case 6:
						kb.nextLine();
						System.out.println("새로운 그룹을 입력해주세요.");
						String newGroup = kb.nextLine();
						contact[i].setGroup(newGroup);
						System.out.println("그룹이 변경되었습니다.");
						break;
					case 7:	
						if(contact[i] instanceof CompanyContact) {
							kb.nextLine();
							CompanyContact comc = (CompanyContact) contact[i];
							System.out.println("새로운 회사명을 입력해주세요.");
							String newCompany = kb.nextLine();
							comc.setCompanyName(newCompany);
							System.out.println("소속회사가 변경되었습니다.");
							break;
						} else {
							kb.nextLine();
							CustomerContact cusc = (CustomerContact) contact[i];
							System.out.println("새로운 거래처명을 입력해주세요.");
							String newCompany = kb.nextLine();
							cusc.setCustCompanyName(newCompany);
							System.out.println("거래처명이 변경되었습니다.");
							break;
						}
					case 8:
						if(contact[i] instanceof CompanyContact) {
							kb.nextLine();
							CompanyContact comc = (CompanyContact) contact[i];
							System.out.println("새로운 부서명을 입력해주세요.");
							String newDept = kb.nextLine();
							comc.setDeptName(newDept);
							System.out.println("부서명이 변경되었습니다.");
							break;
						} else {
							kb.nextLine();
							CustomerContact cusc = (CustomerContact) contact[i];
							System.out.println("새로운 거래 품목을 입력해주세요.");
							String newItem = kb.nextLine();
							cusc.setItem(newItem);
							System.out.println("거래 품목이 변경되었습니다.");
							break;
						}
					case 9:
						kb.nextLine();
						System.out.println("새로운 직급을 입력해주세요.");
						String newJobGrade = kb.nextLine();
						contact[i].setJobGrade(newJobGrade);
						System.out.println("직급이 변경되었습니다.");
						break;
					default:
						break;
					}
					++isIt;
				}
			}
			if(isIt == 0) {
				System.out.println("검색 결과와 일치하는 연락처가 없습니다.");
			}
		} else {
			System.out.println("아직 저장된 연락처가 하나도 없습니다.");
		}
	}
	
	void removeInfo() { //연락처 삭제 
		// 삭제하고나서 새로 연락처 만들면 인덱스바운더리 예외 발생중
		int isIt = 0;
		if(contactNum > 0) {
			if(contactNum == 1) {
				System.out.println("저장된 데이터가 하나 있습니다.");
				contact[0] = null;
				contactNum--;
				System.out.println("연락처를 삭제했습니다.");
				++isIt;
			} else {
				System.out.println("삭제하실 연락처의 이름을 입력해주세요.");
				String name = kb.nextLine();
				for(int i = 0 ; i< contact.length ; i++ ) {
					if(contact[i] != null && name.equals(contact[i].getName())) {
						for(int j = i ; j < contact.length ; j++) {
							contact[j] = contact[j+1];
							contactNum--;
						}
						System.out.println("해당하는 연락처를 삭제했습니다.");
						++isIt;
					}
				} 
			}
			if(isIt == 0) {
				System.out.println("검색 결과와 일치하는 연락처가 없습니다.");
			}
		} else {
			System.out.println("아직 저장된 연락처가 하나도 없습니다.");
		}
	}
	
	void showList() { //전체 리스트 보기
		System.out.println("전체 연락처 리스트를 출력합니다.");
		for(int i = 0 ; i < contact.length ; i++) {
			if(contact[i] != null) {
				contact[i].showData();
			}
		}
	}
	
}
