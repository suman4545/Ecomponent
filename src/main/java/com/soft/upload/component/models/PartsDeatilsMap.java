package com.soft.upload.component.models;

import org.springframework.web.multipart.MultipartFile;

public class PartsDeatilsMap {
	private String partMap;
	private MultipartFile file;
	
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getPartMap() {
		return partMap;
	}
	public void setPartMap(String partMap) {
		this.partMap = partMap;
	}

}
