package com.caruta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.caruta.kn.entity.TestTable;
import com.caruta.kn.model.Demo2Response;
import com.caruta.kn.model.Demo3Request;
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

	/**
	 * model使用
	 *
	 * @return Demo2Response
	 */
	@PostMapping(value = "/demo2", consumes = "application/json")
	@ResponseBody
	public Demo2Response[] demo2() {
		return service.demo2();
	}

	/**
	 * 登録
	 *
	 * @param request
	 */
	@PostMapping(value = "/demo3", consumes = "application/json")
	@ResponseBody
	public void demo3(@RequestBody Demo3Request request) {
		service.demo3(request);
	}

	/**
	 * entity使用
	 *
	 * @return TestTable
	 */
	@PostMapping(value = "/demo4", consumes = "application/json")
	@ResponseBody
	public TestTable[] demo4() {
		return service.demo4();
	}
}
