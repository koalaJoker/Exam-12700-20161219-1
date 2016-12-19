package com.yy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yy.dao.CustomerDao;
import com.yy.entity.Customer;
import com.yy.utils.JdbcTest;

public class CustomerDaoImpl implements CustomerDao{

	//通过用户名找到一条记录
public  boolean findCustomerByName(String lastname){
	Connection  conn=JdbcTest.getConnection();
	ResultSet resultSet=null;
	PreparedStatement ps=null;
	try {
	String sql="select * from customer where last_name=?";
	    ps= conn.prepareStatement(sql);
	    ps.setString(1,lastname);
		//向数据库发出sql执行查询，查询出结果集
	    resultSet =  ps.executeQuery();
	    if(resultSet.next()){
	    	return true;
	    	}
	    }
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JdbcTest.close(ps, conn, resultSet);
	}
  return false;
}
}
