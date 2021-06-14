package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.regex.Pattern;

public class SmartPhone implements Serializable{
	
	Scanner kb = new Scanner(System.in);
	
	ArrayList<Contact> contact;
	
	public SmartPhone() {
		contact = new ArrayList<Contact>();
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
		try {
			
			System.out.println("이름을 입력해주세요: ");
			String name = kb.nextLine();
			isEmpty(name);
			boolean regex1 = Pattern.matches("^[a-zA-Z가-힣]*$", name);
			if(!regex1) {
				throw new MyMadeException("이름은 영어, 한글로만 작성해주세요.");
			}
			
			System.out.println("전화번호를 다음의 형식에 따라 입력해주세요: ");
			System.out.println("[010-9999-9999]");
			System.out.println("주의! - 까지 입력해주세요");
			String phoneN = kb.nextLine();
			isEmpty(phoneN);
			boolean regex2 = Pattern.matches("^([0-9]{3})(\\-)([0-9]{3,4})(\\-)([0-9]{3,4})$", phoneN);
			if(!regex2) {
				throw new MyMadeException("전화번호 형식에 맞지 않는 입력입니다.");
			}
			boolean chk1 = true;
			if(contact.size() > 0) {
				for(int i = 0 ; i < contact.size() ; i++ ) {
					while(chk1) {
						if(contact.get(i) != null && phoneN.equals(contact.get(i).getPhoneNum())) {
							System.out.println("이미 저장되어 있는 번호입니다.");
							System.out.println("확인 후 다시 입력해주세요.");
							phoneN = kb.nextLine();
							isEmpty(phoneN);
							if(!phoneN.equals(contact.get(i).getPhoneNum())) {
								chk1 = false;
							}
						}
						break;
					}
				}
			}
			
			System.out.println("이메일을 입력해주세요: ");
			String email = kb.nextLine();
			isEmpty(email);
			
			boolean regex3 = Pattern.matches("^([a-zA-Z0-9\\_\\+\\.\\-]+)(\\@)([a-z]*)(\\.?)([a-z]*)(\\.?)([a-z]*)$", email);
			if(!regex3) {
				throw new MyMadeException("이메일 형식에 부합하지 않습니다.");
			}
			
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
					contact.add(new CompanyContact(
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
					contact.add(new CustomerContact(
							name, phoneN, email, address, birth, group2
							, custCompanyName, item, gobGrade2));
					System.out.println("저장 완료하였습니다.");
					chk = false;
					break;
				default: 
					System.out.println("잘못된 번호입니다.");
					System.out.println("다시 입력해주세요.\n");
					continue;
				} //switch문 끝
			}//while문 끝 
		} catch (MyMadeException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("숫자로 입력해주세요.\n");
			kb.nextLine();
		}
	}

	void findInfo() { //연락처 검색 => null pointer exception fixing 필요
					  // if조건에 != null 넣고 픽싱함
		if(contact.size() > 0) {
			System.out.println("검색하실 연락처의 이름을 입력해주세요.");
			String name = kb.nextLine();
			isEmpty(name);
			int isIt = 0;
			for(int i = 0 ; i < contact.size() ; i++ ) {
				if(contact.get(i) != null && name.equals(contact.get(i).getName())) {
					contact.get(i).showData();
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
	
	void updateInfo() { //연락처 수정
		if(contact.size() > 0) {
			System.out.println("수정하실 연락처의 이름을 입력해주세요.");
			int isIt = 0;
			String name = kb.nextLine();
			isEmpty(name);
			for(int i = 0 ; i< contact.size() ; i++ ) {
				if(contact.get(i) != null && name.equals(contact.get(i).getName())) {
					System.out.print("수정 전 데이터: ");
					contact.get(i).showData();
					System.out.println("수정하실 항목을 선택해주세요.");
					int num = kb.nextInt();
					switch (num) {
					case 1:
						kb.nextLine(); //nextInt 버퍼비움
						System.out.println("새로운 이름을 입력해주세요.");
						String newName = kb.nextLine();
						isEmpty(newName);
						contact.get(i).setName(newName);
						System.out.println("이름이 변경되었습니다.");
						break;
					case 2:
						kb.nextLine();
						System.out.println("새로운 전화번호를 입력해주세요.");
						String newPhoneNum = kb.nextLine();
						isEmpty(newPhoneNum);
						contact.get(i).setPhoneNum(newPhoneNum);
						System.out.println("전화번호가 변경되었습니다.");
						break;
					case 3:
						kb.nextLine();
						System.out.println("새로운 이메일을 입력해주세요.");
						String newEmail = kb.nextLine();
						isEmpty(newEmail);
						contact.get(i).setEmail(newEmail);
						System.out.println("이메일이 변경되었습니다.");
						break;
					case 4:
						kb.nextLine();
						System.out.println("새로운 주소를 입력해주세요.");
						String newAddress = kb.nextLine();
						isEmpty(newAddress);
						contact.get(i).setAddress(newAddress);
						System.out.println("주소가 변경되었습니다.");
						break;
					case 5:
						kb.nextLine();
						System.out.println("새로운 생일을 입력해주세요.");
						String newBirth = kb.nextLine();
						isEmpty(newBirth);
						contact.get(i).setBirth(newBirth);
						System.out.println("생일이 변경되었습니다.");
						break;
					case 6:
						kb.nextLine();
						System.out.println("새로운 그룹을 입력해주세요.");
						String newGroup = kb.nextLine();
						isEmpty(newGroup);
						contact.get(i).setGroup(newGroup);
						System.out.println("그룹이 변경되었습니다.");
						break;
					case 7:	
						if(contact.get(i) instanceof CompanyContact) {
							kb.nextLine();
							CompanyContact comc = (CompanyContact) contact.get(i);
							System.out.println("새로운 회사명을 입력해주세요.");
							String newCompany = kb.nextLine();
							isEmpty(newCompany);
							comc.setCompanyName(newCompany);
							System.out.println("소속회사가 변경되었습니다.");
							break;
						} else {
							kb.nextLine();
							CustomerContact cusc = (CustomerContact) contact.get(i);
							System.out.println("새로운 거래처명을 입력해주세요.");
							String newCompany = kb.nextLine();
							isEmpty(newCompany);
							cusc.setCustCompanyName(newCompany);
							System.out.println("거래처명이 변경되었습니다.");
							break;
						}
					case 8:
						if(contact.get(i) instanceof CompanyContact) {
							kb.nextLine();
							CompanyContact comc = (CompanyContact) contact.get(i);
							System.out.println("새로운 부서명을 입력해주세요.");
							String newDept = kb.nextLine();
							isEmpty(newDept);
							comc.setDeptName(newDept);
							System.out.println("부서명이 변경되었습니다.");
							break;
						} else {
							kb.nextLine();
							CustomerContact cusc = (CustomerContact) contact.get(i);
							System.out.println("새로운 거래 품목을 입력해주세요.");
							String newItem = kb.nextLine();
							isEmpty(newItem);
							cusc.setItem(newItem);
							System.out.println("거래 품목이 변경되었습니다.");
							break;
						}
					case 9:
						kb.nextLine();
						System.out.println("새로운 직급을 입력해주세요.");
						String newJobGrade = kb.nextLine();
						isEmpty(newJobGrade);
						contact.get(i).setJobGrade(newJobGrade);
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
		int isIt = 0;
		if(contact.size() > 0) {
			if(contact.size() == 1) {
				System.out.println("저장된 데이터가 하나 있습니다.");
				System.out.println("정말로 삭제하시겠습니까?");
		        System.out.println( "=================" );
				System.out.println("1. 예");
				System.out.println("2. 아니오");
		        System.out.println( "=================" );
		        String answer = kb.nextLine();
		        isEmpty(answer);
		        if(answer.equals(String.valueOf(1))) {
					contact.remove(0);
					System.out.println("연락처를 삭제했습니다.");
		        } else if (answer.equals(String.valueOf(2))) {
		        	System.out.println("연락처를 삭제하지 않습니다.");
		        } else {
		        	System.out.println("잘못된 입력입니다.");
		        }
		        ++isIt;
			} else {
				System.out.println("삭제하실 연락처의 이름을 입력해주세요.");
				String name = kb.nextLine();
				isEmpty(name);
				for(int i = 0 ; i< contact.size() ; i++ ) {
					if(contact.get(i) != null && name.equals(contact.get(i).getName())) {
						contact.remove(i);
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
	
	void removeAllList() { //수정중
		File file = new File("D:"+File.separator+"Contact"
				+File.separator+"contact.ser");
		if(contact.size() > 0 | file.exists()) {
			System.out.println("정말로 연락처를 전체 삭제하시겠습니까?");
			System.out.println( "=================" );
			System.out.println("1. 예");
			System.out.println("2. 아니오");
			System.out.println( "=================" );
			String answer = kb.nextLine();
			isEmpty(answer);
			if(answer.equals(String.valueOf(1))) {
				file.delete();
				System.out.println("연락처를 전부 삭제했습니다.");
			} else if (answer.equals(String.valueOf(2))) {
				System.out.println("연락처를 삭제하지 않습니다.");
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		} else {
			System.out.println("아직 저장된 연락처가 하나도 없습니다.");
		}
	}
	
	void showList() { //전체 리스트 보기
		if(contact.size() > 0) {
			System.out.println("전체 연락처 리스트를 출력합니다.");
			for(int i = 0 ; i < contact.size() ; i++) {
				if(contact.get(i) != null) {
					contact.get(i).showData();
				}
			}
		} else {
			System.out.println("아직 저장된 연락처가 하나도 없습니다.");
		}
	}
	
	void savingFile() {
		try {
			System.out.println("파일을 저장중입니다.");
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(
							"D:"+File.separator+"Contact"
									+File.separator+"contact.ser"));
			out.writeObject(contact);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("연락처 정보를 파일로 저장했습니다.");
	}
	
	void loadingFile() {
		try {
			File file = new File("D:"+File.separator+"Contact"
					+File.separator+"contact.ser");
			if(file.exists()) {
				System.out.println("이전에 저장한 정보가 있습니다.");
				ObjectInputStream in = new ObjectInputStream(
						new FileInputStream(
								"D:"+File.separator+"Contact"
										+File.separator+"contact.ser"));
				contact = (ArrayList<Contact>)in.readObject();
				in.close();
				System.out.println("파일을 로드했습니다.");
			} else {
				System.out.println("이전에 저장한 정보가 존재하지 않습니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}