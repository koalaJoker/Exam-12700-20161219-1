package com.yy.dao;

import java.util.List;

public interface LanguageDao {
//获取所有name

	public List<String> findLanguageName();
	
	//获取language ID
	public int findLanguageId(String name);
}
