package com.yy.service.impl;

import java.util.List;

import com.yy.dao.LanguageDao;
import com.yy.dao.impl.LanguageDaoImpl;
import com.yy.service.LanguageService;

public class LanguageServiceImpl implements LanguageService {

	LanguageDao dao =new LanguageDaoImpl();
	public List<String> findLanguageName() {
		
		return dao.findLanguageName();
	}
	public int findLanguageId(String name) {
		
		return dao.findLanguageId(name);
	}

}
