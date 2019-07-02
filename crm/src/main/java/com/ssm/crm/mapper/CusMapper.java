package com.ssm.crm.mapper;

import java.util.List;

import com.ssm.crm.domain.Customer;
import com.ssm.crm.domain.QueryVo;

public interface CusMapper {

	//查询所有
	List<Customer> getCustomerList(); 
	
	List<Customer> cusListPage(QueryVo vo);
	
	//根据Id查询
	Customer queryCustomerById(Integer cust_id);
	
	//查询数量
	Integer getCount(QueryVo vo);
	
	//删除客户
	void deleteCoustomer(Integer cust_id);
	
	//新增客户
	void addCustomer(Customer customer);
	
	void updateCustomer(Customer customer);
	
}
