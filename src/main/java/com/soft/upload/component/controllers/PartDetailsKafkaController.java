package com.soft.upload.component.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soft.upload.component.models.PartFileBean;
import com.soft.upload.component.models.UploadFileResponse;
import com.soft.upload.component.services.PartDetailsReadServiceImpl;

@RestController
public class PartDetailsKafkaController {
	
	@Autowired
	PartDetailsReadServiceImpl partdetailDAO;
	
	@GetMapping("/sendpartstokafka/{partno}")
	public ResponseEntity<PartFileBean> uploadFile(@PathVariable String partno) {
		
		System.out.println("PART NO =========="+partno );
		
		
		PartFileBean part=partdetailDAO.getpart(partno);
		/*System.out.println("PART NO =========="+reqMapBody.getPartno() );
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Object> reqMAp = new HashMap<String, Object>();
		UploadFileResponse uploadres = null;
		try {
			uploadres = FILE_SERVICE_OBJ.storeFile(reqMapBody);
					
			//reqMAp = mapper.readValue(reqMapBody.getPartMap(), new TypeReference<Map<String, Object>>() {});
			//KAFKASERVER_OBJ.sendkafkaMsg(reqMAp);
			//;
			
			return new ResponseEntity<UploadFileResponse>(uploadres, HttpStatus.OK);

		} catch (Exception e) {
			reqMapBody.setUploadFile(uploadres);

			return new ResponseEntity<UploadFileResponse>(uploadres, HttpStatus.OK);*/

		
		return new ResponseEntity<PartFileBean>(part, HttpStatus.OK);
		
		}

	

	
	 

}
