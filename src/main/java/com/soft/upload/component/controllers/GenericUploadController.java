package com.soft.upload.component.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.soft.upload.component.models.UploadFileResponse;
import com.soft.upload.component.services.FileStorageService;

@RestController
public class GenericUploadController {

	@Autowired
	FileStorageService FILE_SERVICE_OBJ;
	
	@PostMapping("/uploadFile")
    public ResponseEntity<UploadFileResponse>  uploadFile(@RequestParam("file") MultipartFile file) {
		UploadFileResponse res = FILE_SERVICE_OBJ.storeFile(file);
		
		return new ResponseEntity<UploadFileResponse>(res, HttpStatus.OK);
		
		

      
    }
	
}
