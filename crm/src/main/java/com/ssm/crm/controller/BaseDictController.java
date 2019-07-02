package com.ssm.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssm.crm.domain.BaseDict;
import com.ssm.crm.service.BaseDictService;

@RestController
@RequestMapping("baseDict")
public class BaseDictController {

	@Autowired
	private BaseDictService baseDictService;
	
	@RequestMapping("getById")
	public List<BaseDict> getBaseDictListByCode(String code) {
		List<BaseDict> baseDictList = baseDictService.getBaseDictListByCode(code);
		return baseDictList;
	}
}
