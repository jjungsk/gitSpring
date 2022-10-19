package com.ssafy.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

//Exception 이 발생할때만 처리 하는 controller
//@ControllerAdvice
public class ExceptionControllerAdvice {
	
	private Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);
	
	// 500 에러
	@ExceptionHandler(Exception.class)
	public String handleException(Exception exception, Model model) {
		logger.error("Exception 발생 : {}", exception.getMessage());
		model.addAttribute("msg", "처리 중 에러 발생");
		return "error/error";
	}
	
	// 404 에러
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException exception, Model model) {
		logger.error("404 발생 : {}", "404 page not found");
		model.addAttribute("msg", "해당 페이지를 찾을 수 없습니다");
		return "error/error";
	}

}
