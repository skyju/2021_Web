package com.bitcamp.firstSpring.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileUploadService {
	
	@Autowired
	Dao dao;
	
	public void fileUpload() {
		dao.insert();
	}

}
