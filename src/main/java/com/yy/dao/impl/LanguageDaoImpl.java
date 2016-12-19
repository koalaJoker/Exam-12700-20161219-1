package com.yy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yy.dao.LanguageDao;
import com.yy.utils.JdbcTest;

public class LanguageDaoImpl implements LanguageDao {

	public List<String> findLanguageName() {
		Connection  conn=JdbcTest.getConnection();
		ResultSet resultSet=null;
		PreparedStatement ps=null;
		List<String> list=new ArrayList<String>();
	
		try {
		String sql="select name from language";
		    ps= conn.prepareStatement(sql);
			//向数据库发出sql执行查询，查询出结果集
		    resultSet =  ps.executeQuery();
		    while(resultSet.next()){
		    	String name=resultSet.getString("name");
		    	list.add(name);
		    	}
		    }
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTest.close(ps, conn, resultSet);
		}

		return list;
	}

	public int findLanguageId(String name) {
		Connection  conn=JdbcTest.getConnection();
		ResultSet resultSet=null;
		PreparedStatement ps=null;
		int id=0;
		try {
		String sql="select language_id from language where name=?";
		    ps= conn.prepareStatement(sql);
			//向数据库发出sql执行查询，查询出结果集
		    ps.setString(1,name);
		    resultSet =  ps.executeQuery();
		    while(resultSet.next()){
		    	id=resultSet.getInt("language_id");
		    	}
		    }
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTest.close(ps, conn, resultSet);
		}

		return id;
	}

}
