package com.yy.service;

import java.util.List;

public interface LanguageService {

	
	//获取所有name
		public List<String> findLanguageName();
		
		//获取language ID
		public int findLanguageId(String name);
}
