package com.soft.upload.component.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soft.upload.component.kafkaservices.KafkaSenderServiceimpl;
import com.soft.upload.component.models.PartsDeatilsMap;
import com.soft.upload.component.models.UploadFileResponse;
import com.soft.upload.component.services.FileStorageService;

@RestController
public class GenericUploadController {

	@Autowired
	FileStorageService FILE_SERVICE_OBJ;

	@Autowired
	KafkaSenderServiceimpl KAFKASERVER_OBJ;

	@PostMapping("/uploadFile")
	// @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)

	public ResponseEntity<UploadFileResponse> uploadFile(@ModelAttribute PartsDeatilsMap reqMapBody) {
		System.out.println(reqMapBody.getPartMap());
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> reqMAp = new HashMap<String, String>();
		// convert JSON string to Map
		UploadFileResponse res = null;
		try {
			reqMAp = mapper.readValue(reqMapBody.getPartMap(), new TypeReference<Map<String, String>>() {});
			KAFKASERVER_OBJ.sendkafkaMsg(reqMAp);
			res = FILE_SERVICE_OBJ.storeFile(reqMapBody.getFile());
			return new ResponseEntity<UploadFileResponse>(res, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<UploadFileResponse>(res, HttpStatus.OK);

		}

	}

}
