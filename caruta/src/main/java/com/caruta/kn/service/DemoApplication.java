package com.caruta.kn.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoApplication {
    @RequestMapping("/hello")
	public static void main(String[] args) {
		System.out.println("sss");
	}
}
