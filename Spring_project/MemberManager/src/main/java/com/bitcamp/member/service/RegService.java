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
		
		//자동주입안되는중
		System.out.println(report);
		
		try {
			conn = ConnectionProvider.getConnection();
			Member member = new Member(); // domain도 repository처리하는지 나중에 질문
			
			member.setId(report.getId());
			member.setPw(report.getPw());
			member.setName(report.getName());
			
			if(report.getPhoto() != null) {
				member.setPhoto(report.getPhoto().getOriginalFilename());
				newFile = saveFile(request, report.getPhoto());
			} else {
				member.setPhoto("photo");
			}
			resultCnt = dao.insertMember(conn, member);

			
		} catch (SQLException | IllegalStateException | IOException e) {
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
	
	// 사용자 업로드한 파일을 저장하는 메소드
	private File saveFile(
			HttpServletRequest request, 
			MultipartFile file
			) throws IllegalStateException, IOException {
		// 저장 경로 : 시스템 경로
		String saveDir = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
		// 새롭게 저장할 파일
		File newFile = new File(saveDir, file.getOriginalFilename());
		// 파일 저장
		file.transferTo(newFile);
		
		return newFile;
	}

}
