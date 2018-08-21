package com.soft.upload.component.services;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.soft.upload.component.models.UploadFileResponse;

@Service
public class CreateUploadResponse {
	
	
	public UploadFileResponse uploadfileResponse(MultipartFile file) throws FileNotFoundException{
		 String fileName = StringUtils.cleanPath(file.getOriginalFilename());		
		 
			
			  String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
		                .path("/downloadFile/")
		                .path(fileName)
		                .toUriString();

		        return new UploadFileResponse(fileName, fileDownloadUri,
		                file.getContentType(), file.getSize());
			
		 
		 
	       
		
		
	}

}
