package com.ssafy.ws.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.FileInfoDto;
import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.UserService;

@Controller
public class BookController {

	private Logger logger = LoggerFactory.getLogger(BookController.class);
	
	// File
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	/**

	 * @return
	 */
	@GetMapping({"/", "/index" })
	public String showRoot() {
		return "index";
	}

	/**
	 * <pre>
	 * /login 요청이 post 방식으로 왔을 때 login 처리한다.
	 * </pre>
	 * 
	 * 사용자의 요청에서 계정 정보를 추출해 로그인 처리한다.
	 * 일단 사용자 id가 ssafy, 비밀번호가 1234면 로그인에 성공으로 간주한다.
	 * 로그인 성공 시 session에 정보를 담고 redirect로 index로 이동한다.
	 * 그렇지 않을 경우는 로그인 실패 메시지를 model에 담고 forward로 index로 이동한다.
	 * 
	 * @param user
	 *            전달된 파라미터는 ModelAttribute를 통해서 객체로 받을 수 있다.
	 * @param session
	 *            사용자 정보를 세션에 저장하기 위해 사용한다.
	 * @param model
	 *            Request scope에 정보를 저장하기 위해서 사용된다.
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("login user info : {}", map);
		
		try {
			User user = userService.login(map);
			if (user != null) {
				
                Cookie cookie = new Cookie("ssafy_id", map.get("userId"));
                cookie.setMaxAge(60*60*24*365*40);
                cookie.setPath(request.getContextPath());

                response.addCookie(cookie);
                
                session.setAttribute("userinfo", user);
                logger.debug("login user info : {}", user);
                
                return "redirect:/";
			} else { // 로그인 실패(id, pwd 불일치!!!!)
                model.addAttribute("msg", "로그인 실패");
                return "index";
            }
		} catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "로그인 처리중 에러 발생!!!");
            return "error/error";
		}
		
	}


	/**
	 * <pre>/logout을 get 방식으로 요청했을 때 session을 만료 시키고 로그아웃 처리한다.</pre>
	 * 다음 경로는 redirect 형태로 /index로 이동한다.
	 * @param session
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}


	/**
	 * <pre>/list를 get 방식으로 요청할 때 도서 정보를 보여준다.</pre>
	 * 아직 MVC의 model 영역을 완성하지 않았기 때문에 여러 개의 Book을 직접 생성해서 List 형태로 전달한다.
	 * 정보를 Model 객체에 저장 후 forward로 list를 호출한다.
	 * @return
	 */
	@GetMapping("/list")
	public String list(Model model, RedirectAttributes redirectAttributes) throws Exception {
		
		List<Book> books = new ArrayList<>();
		books.add(new Book("111-222-3333", "홍길동", "책제목 1", 10000, "좋은 책1", "abc1.png"));
		books.add(new Book("111-222-3334", "간다가", "책제목 2", 20000, "좋은 책2", "abc2.png"));
		books.add(new Book("111-222-3335", "옿롤로", "책제목 3", 30000, "좋은 책3", "abc3.png"));
		model.addAttribute("articles", books);
		
		return "list";
	}




	/**
	 * get 방식의 regist 요청이 오면 regist 페이지를 forward로 연결한다.
	 * @return
	 */
	@GetMapping("/regist")
	public String regist() {
		
		return "regist";
	}
	

	/**
	 * post 방식의 regist 요청이 오면 요청으로 전달된 book 객체를 그대로 regist_result에 연결한다.
	 * @param book
	 * @return
	 */
	@PostMapping("/regist")
	public String regist(Book book, Model model, @RequestParam("upfile") MultipartFile[] files, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("regist parameter Book : {}", book);
		model.addAttribute("bookinfo", book);
		
		// FileUpload
		logger.debug("MultipartFile.isEmpty : {}", files[0].isEmpty());
		if (!files[0].isEmpty()) {
			String realPath = servletContext.getRealPath("/upload");
//			String realPath = servletContext.getRealPath("/resources/img");
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			String saveFolder = realPath + File.separator + today;
			logger.debug("저장 폴더 : {}", saveFolder);
			File folder = new File(saveFolder);
			if (!folder.exists())
				folder.mkdirs();
			List<FileInfoDto> fileInfos = new ArrayList<FileInfoDto>();
			for (MultipartFile mfile : files) {
				FileInfoDto fileInfoDto = new FileInfoDto();
				String originalFileName = mfile.getOriginalFilename();
				if (!originalFileName.isEmpty()) {
					String saveFileName = UUID.randomUUID().toString()
							+ originalFileName.substring(originalFileName.lastIndexOf('.'));
					fileInfoDto.setSaveFolder(today);
					fileInfoDto.setOriginalFile(originalFileName);
					fileInfoDto.setSaveFile(saveFileName);
					logger.debug("원본 파일 이름 : {}, 실제 저장 파일 이름 : {}", mfile.getOriginalFilename(), saveFileName);
					mfile.transferTo(new File(folder, saveFileName));
				}
				fileInfos.add(fileInfoDto);
			}
			book.setFileInfos(fileInfos);
		}
		
		
		return "regist_result"; // 정보를 다시 받아와야 하므로 redirect
	}
	


	/**
	 * <pre>
	 * /error/commonerr 요청이 get 방식으로 들어왔을 때 error/commonerr로 연결한다.
	 * </pre>
	 * 
	 * @return
	 */
//	@GetMapping("/error/commonerr")
//	public String errorCommonerr() {
//		
//		return "error/commonerr";
//	}
	

	/**
	 * <pre>
	 * /error/404 요청이 get 방식으로 들어왔을 때 error/404로 연결한다.
	 * </pre>
	 * 
	 * @return
	 */
//	@GetMapping("/error/404")
//	public String error404() {
//		
//		return "error/404";
//	}

}
