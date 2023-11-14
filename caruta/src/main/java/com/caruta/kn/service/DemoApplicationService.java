package com.caruta.kn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caruta.kn.repository.DemoRepository;

@Service
public class DemoApplicationService {

	@Autowired
	private DemoRepository demoRepository;

	public void demo(String arg) {
		System.out.println(arg);
		demoRepository.demo(arg);
	}
}
