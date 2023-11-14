package com.caruta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.caruta.kn.model.DemoRequest;
import com.caruta.kn.service.DemoApplicationService;

@RestController
@RequestMapping("/caruta")
@CrossOrigin(origins = "http://localhost:3000")
public class DemoApplicationController {

	@Autowired
	DemoApplicationService service;

	/**
	 * @param arg 引数
	 */
	@PostMapping(value = "/demo", consumes = "application/json")
	@ResponseBody
	public String demo(@RequestBody DemoRequest request) {
		service.demo(request.getArg());

		return "成功！！ リクエスト：" +  request.getArg();
	}
}
