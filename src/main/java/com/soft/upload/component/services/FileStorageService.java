package com.soft.upload.component.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.soft.upload.component.dao.service.FileuploadServiceImpl;
import com.soft.upload.component.models.PartFileBean;
import com.soft.upload.component.models.UploadFileResponse;

@Service
public class FileStorageService {

	 private final Path fileStorageLocation;
	// @Value("${textmsg}")
	// @Value("${uploaddir}")
	 private String filepath="./uploads";

	
	 

		@Autowired
		CreateUploadResponse UPLOADservice_obj;	
		@Autowired
		FTPFileuploadService FTPService_OBJ;
		@Autowired
		FileuploadServiceImpl fileDaoService;
		
		
		
	    public FileStorageService() {
	        this.fileStorageLocation = Paths.get(filepath)
	                .toAbsolutePath().normalize();

	        try {
	            Files.createDirectories(this.fileStorageLocation);
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	           // throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
	        }
	    }

	    public UploadFileResponse storeFile(PartFileBean reqMapBody) {
	    	UploadFileResponse uploadres=null;
	        // Normalize file name
	        String fileName = StringUtils.cleanPath(reqMapBody.getFile().getOriginalFilename());
	        MultipartFile file=null;

	        try {
	            // Check if the file's name contains invalid characters
	            if(fileName.contains("..")) {
	            	System.out.println("errror");
	            	file=reqMapBody.getFile();
	               // throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
	            }

	            // Copy file to the target location (Replacing existing file with the same name)
	           // Path targetLocation = this.fileStorageLocation.resolve(fileName);	            
	            //Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
	            FTPService_OBJ.ftpUpload(reqMapBody.getFile());
	            
	            
	            uploadres=UPLOADservice_obj.uploadfileResponse(reqMapBody.getFile());
	            reqMapBody.setUploadFile(uploadres);
				
				if(uploadres.getFileDownloadUri()!=null) {
					fileDaoService.save(reqMapBody);
				}
	           
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	           // throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
	        }
	        return uploadres;
	    }
	    
	    public String getFilepath() {
			return filepath;
		}

		public void setFilepath(String filepath) {
			this.filepath = filepath;
		}

	
	
	
}
