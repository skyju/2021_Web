package com.bitcamp.firstSpring.upload;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitcamp.firstSpring.domain.Report;

@Controller
public class FileUploadController {
	
	@Autowired
	private FileUploadService uploadService;

	final String UPLOAD_URI = "/uploadfile";

	@RequestMapping("/upload/uploadForm")
	public String getUploadForm() {
		return "upload/uploadForm";
	}

	///////////////////////////////////////////////////////
	
	//@RequestParam 이용
	@RequestMapping(value = "/upload/upload1")
	public String upload1(
			@RequestParam("sno") String sno, 
			@RequestParam("sname") String sname,
			@RequestParam("report") MultipartFile report, 
			Model model, 
			HttpServletRequest request
	) throws IllegalStateException, IOException {

		model.addAttribute("sno", sno);
		model.addAttribute("sname", sname);
		model.addAttribute("reportfile", report.getOriginalFilename());
		
		saveFile(request, report);
		
		uploadService.fileUpload();

		return "upload/upload";
	}
	
	///////////////////////////////////////////////////////
	
	//MultipartHttpServletRequest 이용
	@RequestMapping("/upload/upload2")
	public String upload2(
			MultipartHttpServletRequest request,
			Model model
			) throws IllegalStateException, IOException {
		
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		MultipartFile report = request.getFile("report");
		
		model.addAttribute("sno", sno);
		model.addAttribute("sname", sname);
		model.addAttribute("reportfile", report.getOriginalFilename());
		
		saveFile(request, report);
		
		return "upload/upload";
	}
	
	///////////////////////////////////////////////////////
	
	//커맨드 객체 이용
	@RequestMapping("/upload/upload3")
	public String upload3(
			Report report,
			Model model,
			HttpServletRequest request
			) throws IllegalStateException, IOException {
		
		System.out.println(report);
		
		
		model.addAttribute("sno", report.getSno());
		model.addAttribute("sname", report.getSname());
		model.addAttribute("reportfile", report.getReport().getOriginalFilename());
		
		saveFile(request, report.getReport());
		
		return "upload/upload";
	}
	
	
	///////////////////////////////////////////////////////
	
	// 사용자 업로드한 파일을 저장하는 메소드
	private void saveFile(
			HttpServletRequest request, 
			MultipartFile file) 
			throws IllegalStateException, IOException {
		// 저장 경로 : 시스템 경로
		String saveDir = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
		// 새롭게 저장할 파일
		File newFile = new File(saveDir, file.getOriginalFilename());
		// 파일 저장
		file.transferTo(newFile);
	}

}