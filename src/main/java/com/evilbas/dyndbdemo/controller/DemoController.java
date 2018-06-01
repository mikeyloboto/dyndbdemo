package com.evilbas.dyndbdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.evilbas.dyndbdemo.service.DemoService;

@RestController
@RequestMapping("/")
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	@RequestMapping(value="/demo", method = RequestMethod.GET)
	@ResponseBody
	private String testController() {
		return demoService.testData();
	}
}
