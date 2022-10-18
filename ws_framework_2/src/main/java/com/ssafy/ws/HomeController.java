package com.ssafy.ws;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.ws.config.ApplicationConfig;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.BookServiceImpl;
import com.ssafy.ws.model.service.UserService;
import com.ssafy.ws.model.service.UserServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	@Autowired
//	private BookServiceImpl bookService;
//	
//	@Autowired
//	private UserServiceImpl userService;
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		UserService userService = context.getBean("uService", UserService.class);
		userService.select("ssafy");
		BookService bookService = context.getBean("bService", BookService.class);
//		bookService.insert("");
//		bookService.update("");
		bookService.delete("");
		bookService.select("");
		bookService.search();
	}
	
//	@Autowired
//	private BookServiceImpl bookService;
//	
//	@Autowired
//	private UserServiceImpl userService;
//	
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public ModelAndView test() {
//		ModelAndView mav = new ModelAndView();
//		String msg = "test";
//		
//		mav.addObject("msg", msg); // 이름, 값
//		mav.setViewName("test/result"); // 가야할 곳
//		
//		return mav;
//	}
	
//	// 자동 완성
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//	
//	/**
//	 * Simply selects the home view to render by returning its name.
//	 */
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
	
}
