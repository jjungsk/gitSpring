package com.ssafy.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping("/hello")
	public String hello(Model model) {
		logger.info("hello() cal!!!!"); // controller 인식을 하지만..
		model.addAttribute("msg", "안녕하세요 스프링 부트입니다.");
		return "hello";
	}

}
