package com.ssafy.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/") // "/"로 들어오면 index로 가라
	public String index() {
		return "index";
	}
	
	

}
