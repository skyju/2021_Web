package member.main;

import java.util.Scanner;

import member.dao.MemberDao;
import member.domain.RegRequest;
import member.service.ChangePasswordService;
import member.service.MemberRegService;

public class MainForMemberManager {
	
	//static MemberDao dao = new MemberDao();
	
	static Assembler assembler = new Assembler();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			printMenu();
			
			String command = sc.nextLine();
			// ���α׷��� ���� �б�
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("���α׷� ����");
				return;
			}
			
			if(command.startsWith("new")) {
				String[] values = command.split(" ");
				//  values[0] - > king@gmail.com
				processNewMember(values);	
				continue;
			}
			
			if(command.startsWith("change")) {
				String[] values = command.split(" ");
				processChangePw(values);
			}
		}
	}
	
	private static void processChangePw(String[] values) {
		
		//ChangePasswordService service = new ChangePasswordService(dao);
		ChangePasswordService service = assembler.getPasswordService();
		
		try {
			service.changePassword(values[1], values[2], values[3]);
			
			System.out.println("��й�ȣ�� �����߽��ϴ�.!!");
			
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}

	private static void processNewMember(String[] values) {
		// MemberRegService �̿��ؼ� ���� ����
		
		//MemberRegService service = new MemberRegService(dao);
		MemberRegService service = assembler.getRegService();
		RegRequest request = new RegRequest();
		request.setEmail(values[1]);
		request.setName(values[2]);
		request.setPassword(values[3]);
		request.setConfirmPassword(values[4]);
		
		if(!request.isPasswordEqualToConfirmPassword()) {
			System.out.println("��й�ȣ�� ��й�ȣ Ȯ���� ��ġ���� �ʽ��ϴ�.");
			return;
		}
		
		try {
			service.regMember(request);
			
			System.out.println("��ϵǾ����ϴ�!!");
			
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	static void printMenu() {
		System.out.println();
		System.out.println("��ɾ� ����");
		System.out.println("-------------------------------");
		System.out.println("new �̸��� �̸� ��й�ȣ ��й�ȣȮ��");
		System.out.println("new king@gmail.com KING 123 123");
		System.out.println("ȸ�� ���� ----------------------");
		System.out.println("change �̸��� ������ ���ο���");
		System.out.println("change king@gmail.com 123 0000");
		System.out.println("-------------------------------");
	}

}