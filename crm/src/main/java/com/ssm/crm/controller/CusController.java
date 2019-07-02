package com.ssm.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssm.crm.domain.BaseDict;
import com.ssm.crm.domain.Customer;
import com.ssm.crm.domain.QueryVo;
import com.ssm.crm.service.BaseDictService;
import com.ssm.crm.service.CustomerService;
import com.ssm.crm.utils.Page;

@RestController
@RequestMapping("cus")
public class CusController {

	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping("list")
	public Map<String, Object> cusListPage(QueryVo vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer total = customerService.getCount(vo);
		int start = (vo.getPage() -1)*vo.getRows();
		vo.setStart(start);
		List<Customer> list = customerService.cusListPage(vo);
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping(value="delete" ,produces="text/html;charset=UTF-8")
	public String deleteCustomer(Integer cust_id) {
		try {
			customerService.deleteCustomer(cust_id);
			return "删除成功";
		} catch (Exception e) {
			
			e.printStackTrace();
			return "删除失败";
		}
	}
	
	@GetMapping("edit")
	public Customer eitd(Integer cust_id) {
		Customer customer = customerService.getCustomerById(cust_id);
		return customer;
	}
	
	@GetMapping(value="update",produces="text/html;charset=UTF-8")
	public String updateCustomer(Customer customer) {
		try {
			customerService.updateCustomer(customer);
			return "更新成功";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "更新失败";
		}
	}
	
	@GetMapping(value="add",produces="text/html;charset=UTF-8")
	public String addCustomer(Customer customer) {
		try {
			customerService.addCustomer(customer);
			return "新增成功";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "新增失败";
		}
	}
}
