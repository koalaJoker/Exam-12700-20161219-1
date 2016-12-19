package com.yy.service.impl;

import com.yy.dao.CustomerDao;
import com.yy.dao.impl.CustomerDaoImpl;
import com.yy.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao dao =new CustomerDaoImpl();
	
	public boolean findCustomerByName(String lastname) {
		
		return dao.findCustomerByName(lastname);
	}

}
