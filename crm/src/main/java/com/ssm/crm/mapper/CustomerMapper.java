package com.ssm.crm.mapper;

import java.util.List;

import com.ssm.crm.domain.Customer;
import com.ssm.crm.domain.QueryVo;

public interface CustomerMapper {

	List<Customer> getCustomerList(QueryVo qv);
	
	int getCountByQuery(QueryVo qv);
	
	Customer getCustomerById(Integer id);
	
	void updateCustomer(Customer customer);
	
}
