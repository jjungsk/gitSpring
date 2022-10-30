package com.ssafy.ws.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.ws.model.UserDto;
import com.ssafy.ws.model.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, HttpSession session) throws Exception {
		logger.debug("login info : {}", map);
		UserDto userDto = userService.login(map);
		if (userDto != null) {
			session.setAttribute("loginUser", userDto);
		}
		logger.debug("DB login info : {}", userDto);

		return "redirect:/";
	}

}
