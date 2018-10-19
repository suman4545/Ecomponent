package com.soft.upload.component.dao.service;

import com.soft.upload.component.models.PartFileBean;

public interface FileuploadServiceImpl extends FileUploadService<PartFileBean, Long>{

	public PartFileBean save(PartFileBean entity); 
	//public PartFileBean read(PartFileBean entity); 
	
	PartFileBean findBypartno(String partno);
	
	

}
