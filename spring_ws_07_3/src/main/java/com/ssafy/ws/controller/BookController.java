package com.ssafy.ws.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.UserService;

@Controller
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	/**
	 * BookService를 주입받는다.
	 */
	@Autowired
	BookService bService;
	/**
	 * UserService를 주입받는다.
	 */
	@Autowired
	UserService uService;
	
	// resource 경로를 가져오기 위해 ResourceLoader를 주입 받는다..?
	@Autowired
	ResourceLoader resLoader;
	
	// File
	@Autowired
	private ServletContext servletContext;

	/**
	 * <pre>
	 *  / 또는 /index 요청이 get 방식으로 들어왔을 때 index 로 연결한다.
	 * </pre>
	 * 
	 * @return
	 */
	@GetMapping({ "/", "/index" })
	public String showRoot() {
		return "index";
	}

	/**
	 * <pre>
	 * /login 요청이 post 방식으로 왔을 때 login 처리한다.
	 * </pre>
	 * 
	 * 사용자의 요청에서 계정 정보를 추출해 로그인 처리한다. 로그인 성공 시 session에 정보를 담고 redirect로 index로
	 * 이동한다. 그렇지 않을 경우는 로그인 실패 메시지를 model에 담고 forward로 index로 이동한다.
	 * 
	 * @param user    전달된 파라미터는 ModelAttribute를 통해서 객체로 받을 수 있다.
	 * @param session 사용자 정보를 세션에 저장하기 위해 사용한다.
	 * @param model   Request scope에 정보를 저장하기 위해서 사용된다.
	 * @return
	 * @throws Exception 
	 */
	 @PostMapping("/login")
	 public String doLogin(@ModelAttribute User user, HttpSession session, Model model) throws Exception {
		 logger.debug("idCheck : {}", user);
		 
		 User userInfo = uService.login(user);
		 if (userInfo!=null) {
			 model.addAttribute("name", userInfo.getName());
			 model.addAttribute("id", userInfo.getId());
			 logger.debug("loginSuccess : {}", model);
					 
			 session.setAttribute("loginUser", model);
		 }
		 return "index";
	 }

	/**
	 * <pre>
	 * /logout을 get 방식으로 요청했을 때 session을 만료 시키고 로그아웃 처리한다.
	 * </pre>
	 * 
	 * 다음 경로는 redirect 형태로 /index로 이동한다.
	 * 
	 * @param session
	 * @return
	 */

	@GetMapping("/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}

	/**
	 * <pre>
	 * /list를 get 방식으로 요청할 때 도서 정보를 보여준다.
	 * </pre>
	 * 
	 * Paging을 이용하는 pagingSearch를 이용하도록 변경한다.
	 * 
	 * @return
	 * @throws Exception 
	 */
	 @GetMapping("/list")
	 public String showList(Model model, @ModelAttribute SearchCondition condition) throws Exception {
		List<Book> books = new ArrayList<>();
		logger.debug("search condition : {}", condition);
		
		books = bService.search(condition);
		logger.debug("book list : {}", books);
		
		model.addAttribute("books", books);
		
		return "list";
	 }

	@GetMapping("/regist")
	public String showRegistForm() {
		return "regist";
	}

	/**
	 * 도서 정보를 저장한다.
	 * 
	 * @param book
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@PostMapping("/regist")
	 public String doRegist(@ModelAttribute Book book, @RequestParam(required=false) MultipartFile file) throws IllegalStateException, IOException {
		logger.debug("regist book info(before) : {}", book);
		
		if (file!=null && !file.isEmpty()) {
			// 파일을 저장 할 폴더 지정
			Resource res = resLoader.getResource("resources/upload");
			
			// 파일이 피어있다면 처리할 필요가 없다.
			// prefix를 포함한 전체 이름
			book.setImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
			book.setOrgImg(file.getOriginalFilename());
			
			file.transferTo(new File(res.getFile().getCanonicalPath()+"/"+book.getImg()));
		}
		logger.debug("regist book info(after) : {}", book);
		
		bService.insert(book);
		
		return "regist_result";
	 }

	/**
	 * <pre>
	 * /error/404 요청이 get 방식으로 들어왔을 때 error/404로 연결한다.
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/error/404")
	public String showError404() {
		return "error/404";
	}

	/**
	 * <pre>
	 * /error/400 요청이 get 방식으로 들어왔을 때 error/400로 연결한다.
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/error/400")
	public String showError400() {
		return "error/400";
	}

	/**
	 * <pre>
	 * /error/500 요청이 get 방식으로 들어왔을 때 error/500로 연결한다.
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/error/500")
	public String showError500() {
		return "error/500";
	}
}
