package com.ssm.crm.mapper;

import java.util.List;

import com.ssm.crm.domain.BaseDict;

public interface BaseDictMapper {

	List<BaseDict> getBaseDictListByCode(String code);
	
}
