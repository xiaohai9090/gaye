package com.ssm.crm.service;

import java.util.List;

import com.ssm.crm.domain.BaseDict;

public interface BaseDictService {

	List<BaseDict> getBaseDictListByCode(String code);
	
}
