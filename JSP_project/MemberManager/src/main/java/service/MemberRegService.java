package service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.MemberDao;
import domain.Member;
import util.ConnectionProvider;

public class MemberRegService {

	private MemberRegService() {}
	private static MemberRegService service = new MemberRegService();
	public static MemberRegService getInstance() {
		return service;
	}

	public int regMember(HttpServletRequest request) throws FileUploadException {
		
		int resultCnt = 0;
		Member member = new Member();
		
		Connection con = null;
		MemberDao dao = null;
		
		File newFile = null;
		
		try {
		// 1. multipart 여부 확인
		boolean isMultpart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultpart) {
			// 2. 파일을 저장할 factory 객체 생성
			DiskFileItemFactory factory = new DiskFileItemFactory();
		
			// 3. 요청 처리(form안에 있는 input들을 분리)를 위해서 ServletFileUpload 생성
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			// 4. 사용자 요청을 파싱(분리: 원하는 형태로 분리 input > FileItem)
			// FileItem > input 데이터를 저장하는 객체
			List<FileItem> items = upload.parseRequest(request);
			
			Iterator<FileItem> itr = items.iterator();
			
			while(itr.hasNext()) {
				FileItem item = itr.next(); // text, checkbox, hidden, password, file
				
				// file과 file 이외의 폼을 구분
				if(item.isFormField()) {
					String paramName = item.getFieldName();
					if(paramName.equals("id")) {
						member.setId(item.getString("utf-8"));
					} else if(paramName.equals("pw")) {
						member.setPw(item.getString("utf-8"));
					} else if(paramName.equals("name")) {
						member.setName(item.getString("utf-8"));
					}
				} else { //사진 데이터 처리
					String uploadUri = "upload";
					String dir = request.getSession().getServletContext().getRealPath(uploadUri);
					
					File saveDir = new File(dir);
					
					if(!saveDir.exists()) {
						saveDir.mkdir();
					}
					
					String paramName = item.getFieldName();
					if(paramName.equals("photo")) {
						//파일 이름, 사이즈
						if(item.getName() != null && item.getSize() > 0) {
							
							// 파일저장
							newFile = new File(saveDir, item.getName());
							
							item.write(new File(saveDir, item.getName()));
							member.setPhoto(item.getName());
							System.out.println("파일 저장");
						}
					}
				}
			}
		} else {
			throw new Exception("multipart가 아님");
		}
		
		con = ConnectionProvider.getConnection();
		dao = MemberDao.getInstance();
		
		resultCnt = dao.insertMember(con, member);
		
		} catch (SQLException e) {
			e.printStackTrace();
			//DB입력 오류라면 파일을 삭제해야 함
			if(newFile != null & newFile.exists()) {
				newFile.delete();
				System.out.println("파일 삭제");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultCnt;
	}

}
