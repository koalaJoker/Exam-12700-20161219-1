package com.yy.test;


import org.junit.Test;

import com.yy.dao.CustomerDao;
import com.yy.dao.impl.CustomerDaoImpl;

public class JdbcTest {

	@Test
	public void test01(){
		CustomerDao dao =new CustomerDaoImpl();
		Boolean a=dao.findCustomerByName("SMIT");
		System.out.println(a);
	}
}
