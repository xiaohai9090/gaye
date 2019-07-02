package com.ssm.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.crm.mapper.BankMapper;
import com.ssm.crm.service.BankService;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankMapper bankMapper;
	
	@Override
	public void moveMoney(Double money, String card_id1, String card_id2) {
		bankMapper.addMoney(money, card_id2);
		
		int i = 23/0;
		
		bankMapper.payMoney(money, card_id1);

	}

}
