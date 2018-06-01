package com.evilbas.dyndbdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evilbas.dyndbdemo.dao.TestDao;

@Service
public class DemoService {

	@Autowired
	private TestDao testDao;

	public String testData() {
		return testDao.getTestString();
	}
}
