package member.main;

import javax.imageio.spi.RegisterableService;

import member.dao.GuestDao;
import member.dao.MemberDao;
import member.service.ChangePasswordService;
import member.service.MemberRegService;

public class Assembler {

	// �����̳� : �ν��Ͻ��� ���� -> ����, ����, ����, �ʿ��� ��ü�� ��ȯ, �Ҹ�
	// ������ Ŭ������ ����
	// ������ �ν��Ͻ��� ����
	// ���� ������ ���ش�.
	// �ʿ��� ��ü�� ��ȯ ���ִ� ���

	private MemberDao dao;
	private MemberRegService regService;
	private ChangePasswordService passwordService;
	
	private GuestDao gDao;

	public Assembler() {
		// �ν��Ͻ��� ���� -> ���� ����
		dao = new MemberDao();
		gDao = new GuestDao();
		
		regService = new MemberRegService(dao);
		passwordService = new ChangePasswordService(dao);
	}

	public MemberDao getDao() {
		return dao;
	}

	public MemberRegService getRegService() {
		return regService;
	}

	public ChangePasswordService getPasswordService() {
		return passwordService;
	}

}