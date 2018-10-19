package com.soft.upload.component.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name = "PartsMaster")

public class NewPartsDetails {
	
	public int getPartsid() {
		return partsid;
	}
	public void setPartsid(int partsid) {
		this.partsid = partsid;
	}
	public String getPartsNo() {
		return partsNo;
	}
	public void setPartsNo(String partsNo) {
		this.partsNo = partsNo;
	}
	public String getPartsName() {
		return partsName;
	}
	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}
	public String getPartsFamily() {
		return partsFamily;
	}
	public void setPartsFamily(String partsFamily) {
		this.partsFamily = partsFamily;
	}
	public String getPartsCode() {
		return partsCode;
	}
	public void setPartsCode(String partsCode) {
		this.partsCode = partsCode;
	}
	public UploadFileResponse getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(UploadFileResponse uploadFile) {
		this.uploadFile = uploadFile;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int partsid;//Assign Auto
	private String partsNo;//get the parts no from the user sent while sending the file
	private String partsName;//Enter By user
	private String partsFamily; // Slect from DB by user
	private String partsCode; //Assign By user.dropdown populate based on family
	private UploadFileResponse uploadFile; //upload resullt

}
