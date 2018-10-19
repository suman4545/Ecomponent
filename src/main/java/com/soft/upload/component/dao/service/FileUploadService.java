package com.soft.upload.component.dao.service;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
@NoRepositoryBean
public interface FileUploadService <T, ID extends Serializable> extends Repository<T, ID>{
	 <S extends T> S save(S entity); 
	// <S extends T> S read(S entity); 
	 
}
