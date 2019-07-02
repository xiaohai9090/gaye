package com.ssm.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.crm.domain.BaseDict;
import com.ssm.crm.domain.Customer;
import com.ssm.crm.domain.QueryVo;
import com.ssm.crm.service.BaseDictService;
import com.ssm.crm.service.CustomerService;
import com.ssm.crm.utils.Page;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	@Value("${customer_from_Type}")
	private String customer_from_Type;
	
	@Value("${customer_industry_Type}")
	private String customer_industry_Type;
	
	@Value("${customer_level_Type}")
	private String customer_level_Type;
	
	
	@RequestMapping("list")
	public String baseList(Model model,QueryVo vo) {
		//客户信息来源
		//List<BaseDict> fromType = baseDictService.getBaseDictByCode(customer_from_Type);
		
		//所属行业
		//List<BaseDict> industryType = baseDictService.getBaseDictByCode(customer_industry_Type);
		
		//客户级别
		//List<BaseDict> levelType = baseDictService.getBaseDictByCode(customer_level_Type);
		
		/*
		 * model.addAttribute("levelType", levelType); model.addAttribute("fromType",
		 * fromType); model.addAttribute("industryType", industryType);
		 */
		
		Page<Customer> page = customerService.customerList(vo);
		model.addAttribute("page", page);
		return "customer";
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public Customer edit(Integer id) {
		Customer customer = customerService.getCustomerById(id);
		
		return customer;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public String update(Customer customer) {
		String msg = "0";
		try {
			customerService.updateCustomer(customer);
			msg = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	
	@RequestMapping(value="mag" ,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String mag() {
		String msg = "这是字符串aaaa";
		return msg;
	}
}
