package com.ssafy.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.hello.service.HelloService;

@Controller
public class HelloController {
	
	@Autowired
	private HelloService helloService;

//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
//	@GetMapping("/hsm")
//	public ModelAndView hello() {
//		ModelAndView mav = new ModelAndView();
//		String msg = helloService.hello();
//		
//		mav.addObject("msg", msg); // 이름, 값
//		mav.setViewName("hello/result"); // 가야할 곳
//		
//		return mav;
//	}
	
	// model에 담아서 forwarding
	@GetMapping("/hsm")
	public String hello(Model model) {
		String msg = helloService.hello();
		
		model.addAttribute("msg", "메세지 :::::: " + msg);
		
		return "hello/result";
	}

}
