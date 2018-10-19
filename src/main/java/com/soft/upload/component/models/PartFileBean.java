package com.soft.upload.component.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PART_FILE_DETAILS")

public class PartFileBean {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "FILE_ID")
	private int fileId;
	
	public String getPartno() {
		return partno;
	}
	public void setPartno(String partno) {
		this.partno = partno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	//@NotEmpty
	//@Size(min = 2, max = 500)
	@Column(name = "PART_NO")
	private String partno;
	
	//@NotEmpty
	@Size(min = 1, max = 99)
	//@NotEmpty
	//@Pattern(regexp="^[a-zA-Z ]*$")
	@Column(name = "USER_ID")
	private String userid;
	
	//@NotEmpty
	@Transient
	private MultipartFile file;
	//@Valid
	@OneToOne(cascade = CascadeType.ALL)
	private UploadFileResponse uploadFile;
	
	
	
	
	
	
	
	
	public PartFileBean() {
		super();
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public UploadFileResponse getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(UploadFileResponse uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	
	
	
	
	
	
	
	
	

}
