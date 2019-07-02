package com.ssm.crm.service;

import java.util.List;

import com.ssm.crm.domain.Customer;
import com.ssm.crm.domain.QueryVo;
import com.ssm.crm.utils.Page;

public interface CustomerService {

	Page<Customer> customerList(QueryVo vo);
	
	Customer getCustomerById(Integer id);
	
	void updateCustomer(Customer customer);
	
	List<Customer> getCustomerList();
	
	List<Customer> cusListPage(QueryVo vo);
	
	Integer getCount(QueryVo vo);
	
	void deleteCustomer(Integer cust_id);
	
	void addCustomer(Customer customer);
}
