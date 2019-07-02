package com.ssm.crm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.crm.domain.Customer;
import com.ssm.crm.domain.QueryVo;
import com.ssm.crm.mapper.CusMapper;
import com.ssm.crm.mapper.CustomerMapper;
import com.ssm.crm.service.CustomerService;
import com.ssm.crm.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private CusMapper cusMapper;
	
	@Override
	public Page<Customer> customerList(QueryVo vo) {
		//计算分页查询从哪条记录开始
		vo.setStart((vo.getPage() - 1) * vo.getRows());
		int total = customerMapper.getCountByQuery(vo);
		List<Customer> customerList = customerMapper.getCustomerList(vo);
		Page<Customer> page = new Page<Customer>(total, vo.getPage(), vo.getRows(), customerList);
		return page;
	}

	@Override
	public Customer getCustomerById(Integer id) {
		Customer customer = cusMapper.queryCustomerById(id);
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		cusMapper.updateCustomer(customer);
	}

	@Override
	public List<Customer> getCustomerList() {
		List<Customer> customerList = cusMapper.getCustomerList();
		return customerList;
	}

	@Override
	public List<Customer> cusListPage(QueryVo vo) {
		List<Customer> cusListPage = cusMapper.cusListPage(vo);
		return cusListPage;
	}

	@Override
	public Integer getCount(QueryVo vo) {
		
		return cusMapper.getCount(vo);
	}

	@Override
	public void deleteCustomer(Integer cust_id) {
		
		cusMapper.deleteCoustomer(cust_id);
	}

	@Override
	public void addCustomer(Customer customer) {
		customer.setCust_createtime(new Date());
		cusMapper.addCustomer(customer);
		
	}

	
}
