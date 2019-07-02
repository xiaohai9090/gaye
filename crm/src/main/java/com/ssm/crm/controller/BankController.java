package com.ssm.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssm.crm.service.BankService;

@RestController
@RequestMapping("bank")
public class BankController {

	@Autowired
	private BankService bankService;
	
	@RequestMapping(value="payMoney")
	public String moveMoney(Double money,String card_id1,String card_id2) {
		try {
			bankService.moveMoney(money, card_id1, card_id2);
			return "转账成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "转账失败";
		}
	}
	
}
