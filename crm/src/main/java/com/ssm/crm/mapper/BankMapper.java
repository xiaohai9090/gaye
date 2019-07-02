package com.ssm.crm.mapper;

import org.apache.ibatis.annotations.Update;

public interface BankMapper {
	
	@Update("update bank set money = money + #{0} where card_id = #{1}")
	void addMoney(Double money,String card_id);
	
	@Update("update bank set money = money - #{0} where card_id = #{1}")
	void payMoney(Double money,String card_id);
	
}
