package com.caruta.kn.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caruta.kn.entity.TestTable;
import com.caruta.kn.model.Demo2Response;
import com.caruta.kn.model.Demo3Request;
import com.caruta.kn.repository.DemoRepository;

@Service
public class DemoApplicationService {

	@Autowired
	private DemoRepository demoRepository;

	public void demo(String arg) {
		System.out.println(arg);
		demoRepository.demo(arg);
	}

	public Demo2Response[] demo2() {
		return demoRepository.demo2();
	}

	public void demo3(Demo3Request request) {
		// 0:男 1:女
		String gender = "0";
		// 小数第3位を四捨五入
		BigDecimal height = new BigDecimal(request.getHeight()).setScale(2, RoundingMode.HALF_UP);

		if (request.getGender() == "女") {
			gender = "1";
		}

		demoRepository.demo3(request.getName(), request.getAddress(), gender, height);
	}

	public TestTable[] demo4() {
		return demoRepository.demo4();
	}
}
