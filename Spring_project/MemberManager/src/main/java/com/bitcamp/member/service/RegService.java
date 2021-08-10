package com.bitcamp.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitcamp.member.dao.MemberDao;
import com.bitcamp.member.domain.Member;
import com.bitcamp.member.domain.Report;
import com.bitcamp.member.util.ConnectionProvider;

@Service
public class RegService {
	
	final String UPLOAD_URI = "/uploadfile";
	
	@Autowired
	MemberDao dao;

	public int reg(
			Report report,
			HttpServletRequest request
			) {

		int resultCnt = 0;
		Connection conn = null;
		File newFile = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			Member member = new Member();
			//new 안할 수 있나 고민해보기
			
			member.setId(report.getId());
			member.setPw(report.getPw());
			member.setName(report.getName());
			
			if(report.getPhoto() != null && !report.getPhoto().isEmpty()) {
				newFile = saveFile(request, report.getPhoto());
				member.setPhoto(newFile.getName());
			} else {
				member.setPhoto("");
			}
			
			resultCnt = dao.insertMember(conn, member);
			
		} catch (SQLException | IllegalStateException e) {
			e.printStackTrace();
			if(newFile != null & newFile.exists()) {
				newFile.delete();
				System.out.println("파일 삭제");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultCnt;
	}
	
	private File saveFile(
			HttpServletRequest request, 
			MultipartFile file
			) {
		
		String path = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
		
		File newDir = new File(path);
		if(!newDir.exists()) {
			newDir.mkdir();
			System.out.println("저장 폴더를 생성했습니다.");
		}
		// 파일 저장 시에 파일 이름이 같으면 덮어쓴다 -> 회원 별 고유한 파일 이름을 만들자!
		String newFileName = System.currentTimeMillis()+file.getOriginalFilename();
		File newFile = new File(newDir, newFileName);
		
		try {
			file.transferTo(newFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return newFile;
	}

}
