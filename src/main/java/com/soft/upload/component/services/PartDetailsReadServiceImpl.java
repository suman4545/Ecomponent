package com.soft.upload.component.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.upload.component.dao.service.FileuploadServiceImpl;
import com.soft.upload.component.models.PartFileBean;
@Service
public class PartDetailsReadServiceImpl implements PartDetailsReadService {

	@Autowired
	FileuploadServiceImpl fileDaoService;
	@Override
	public PartFileBean getpart(String partno) {
		// TODO Auto-generated method stub
		PartFileBean part=fileDaoService.findBypartno(partno);
		return part;
	}

	

}
