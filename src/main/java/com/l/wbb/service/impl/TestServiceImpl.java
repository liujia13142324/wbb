package com.l.wbb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.l.wbb.mapper.TestMapper;
import com.l.wbb.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Autowired
	private TestMapper testMapper;
	
	@Override
	public List<Map<String,String>> testSelect() {
		return testMapper.testSelect(1);
	}

}
