package com.soft.upload.component.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FTPFileuploadService {
	
	@Value("${app.ftp.server}")
	private String server;
	@Value("${app.ftp.port}")
	private int port;
	@Value("${app.ftp.username}")
	private String user;
	@Value("${app.ftp.password}")
	private String pass;
	
	
	public boolean ftpUpload(MultipartFile file){
	boolean returnRES=false;
	 
     
     FTPClient ftpClient = new FTPClient();
     try {

         ftpClient.connect(server, port);
         ftpClient.login(user, pass);
         ftpClient.enterLocalPassiveMode();
         System.out.println("connectrex");
         
         
         ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
         
         // APPROACH #1: uploads first file using an InputStream
      //   File firstLocalFile = new File(" ftpClient.setFileType(FTP.BINARY_FILE_TYPE");

     // APPROACH #1: uploads first file using an InputStream
    // MultipartFile firstLocalFile = new Mu(file);

   //  String firstRemoteFile = "Projects.zip";
         
         /*File createFile=new File(file.getOriginalFilename());
         createFile.createNewFile();
         FileOutputStream fos = new FileOutputStream(createFile);
         fos.write(file.getBytes());
         fos.close();
         
         
     InputStream inputStream = new FileInputStream(createFile);*/

     System.out.println("Start uploading first file");
     boolean done = ftpClient.storeFile(file.getOriginalFilename(), file.getInputStream());
    // inputStream.close();
     if (done) {
    	 returnRES=true;
         System.out.println("The first file is uploaded successfully.");
     }//Projects.zip");

     
         
         
         
     }
     catch(Exception e){
     	e.printStackTrace();
     }
	return returnRES;
     
	}
	

}
