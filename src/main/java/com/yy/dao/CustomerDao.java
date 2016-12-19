package com.yy.dao;

import com.yy.entity.Customer;

public interface CustomerDao  {
	
	//通过用户名找到一条记录
	public  boolean findCustomerByName(String lastname);
}
