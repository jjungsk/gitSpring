package com.ssafy.enjoytrip.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.user.model.UserDto;
import com.ssafy.enjoytrip.user.model.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends HttpServlet {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private static final long serialVersionUID = 1L;

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam Model model) {
		logger.debug("login info : {}", model);
		UserDto userDto = new UserDto();
		
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	
//	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id = request.getParameter("id");
//		String pass = request.getParameter("password");
//
//		try {
//			UserDto userDto = userService.loginUser(id);
//			if (userDto == null) { // 해당 아이디 없음
//				request.setAttribute("result", "id not exist");
//			} else if (!pass.equals(userDto.getPassword())) { // 비밀번호 틀림
//				request.setAttribute("result", "password wrong");
//			} else {
//				// cookie
//				int saveId = Integer.parseInt(request.getParameter("saveid"));
//				if (saveId == 1) { // 아이디 저장
//					Cookie cookie = new Cookie("enjoy_id", id);
//					cookie.setMaxAge(60 * 60 * 24 * 365);
//					cookie.setPath(request.getContextPath());
//					response.addCookie(cookie);
//				} else {
//					Cookie[] cookies = request.getCookies();
//					if (cookies != null) {
//						for (Cookie cookie : cookies) {
//							if (cookie.getName().equals("enjoy_id")) {
//								cookie.setMaxAge(0);
//								response.addCookie(cookie);
//								break;
//							}
//						}
//					}
//				}
//
//				// session
//				HttpSession session = request.getSession();
//				session.setAttribute("userinfo", userDto);
//
//				request.setAttribute("result", "success");
//				request.setAttribute("user", userDto);
//			}
//		} catch (Exception e) {
//			request.setAttribute("result", "error");
//			e.printStackTrace();
//		}
//		forward(request, response, "/user/info.jsp");
//	}
	
	/*
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");

		if ("join".equals(act)) {
			int joinSuccess = join(request, response);
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(joinSuccess);
		} else if ("idcheck".equals(act)) {
			int cnt = idCheck(request, response);
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(cnt);
		} else if ("findPass".equals(act)) {
			String pass = findPass(request, response);
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(pass);
		} else if ("login".equals(act)) {
			login(request, response);
		} else if ("logout".equals(act)) {
			logout(request, response);
		} else if ("modify".equals(act)) {
			modify(request, response);
		} else if ("getInfo".equals(act)) {
			getInfo(request, response);
		} else if ("delete".equals(act)) {
			String msg = delete(request, response);
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(msg);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}

	private int join(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		UserDto userDto = new UserDto();
		userDto.setId(request.getParameter("id"));
		userDto.setPassword(request.getParameter("password"));
		userDto.setName(request.getParameter("name"));
		userDto.setEmail(request.getParameter("email"));
		userDto.setTel(request.getParameter("tel"));
		userDto.setIsManager(Integer.parseInt(request.getParameter("manager")));

		try {
			cnt = userService.joinUser(userDto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnt;
	}

	private int idCheck(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userid");
		try {
			int count = userService.checkID(userId);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 500;
	}

	private String findPass(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userid");
		String userName = request.getParameter("username");
		try {
			String pass = userService.findPass(userId, userName);
			if (pass != null) return pass;
			else return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("password");

		try {
			UserDto userDto = userService.loginUser(id);
			if (userDto == null) { // 해당 아이디 없음
				request.setAttribute("result", "id not exist");
			} else if (!pass.equals(userDto.getPassword())) { // 비밀번호 틀림
				request.setAttribute("result", "password wrong");
			} else {
				// cookie
				int saveId = Integer.parseInt(request.getParameter("saveid"));
				if (saveId == 1) { // 아이디 저장
					Cookie cookie = new Cookie("enjoy_id", id);
					cookie.setMaxAge(60 * 60 * 24 * 365);
					cookie.setPath(request.getContextPath());
					response.addCookie(cookie);
				} else {
					Cookie[] cookies = request.getCookies();
					if (cookies != null) {
						for (Cookie cookie : cookies) {
							if (cookie.getName().equals("enjoy_id")) {
								cookie.setMaxAge(0);
								response.addCookie(cookie);
								break;
							}
						}
					}
				}

				// session
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", userDto);

				request.setAttribute("result", "success");
				request.setAttribute("user", userDto);
			}
		} catch (Exception e) {
			request.setAttribute("result", "error");
			e.printStackTrace();
		}
		forward(request, response, "/user/info.jsp");
	}

	private void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");

		UserDto userDto = new UserDto();
		userDto.setId(id);
		userDto.setPassword(password);
		userDto.setName(name);
		userDto.setEmail(email);
		userDto.setTel(tel);

		try {
			if (userService.modifyUser(userDto) == 1) { // 수정 성공
				// session
				HttpSession session = request.getSession();
				Object sessionUserInfo = session.getAttribute("userinfo");
				if (sessionUserInfo != null) {
					UserDto sessionUserDto = (UserDto) sessionUserInfo;
					sessionUserDto.setPassword(password);
					sessionUserDto.setName(name);
					sessionUserDto.setEmail(email);
					sessionUserDto.setTel(tel);
					session.setAttribute("userinfo", sessionUserDto);

					userDto.setIsManager(sessionUserDto.getIsManager());
				}

				request.setAttribute("modify", "success");
				request.setAttribute("user", userDto);

			} else {
				request.setAttribute("modify", "fail");
			}
		} catch (Exception e) {
			request.setAttribute("modify", "fail");
			e.printStackTrace();
		}

		forward(request, response, "/user/modify.jsp");
	}

	private void getInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object sessionUserInfo = session.getAttribute("userinfo");
		if (sessionUserInfo == null) {
			request.setAttribute("result", "please login");
		} else {
			UserDto sessionUserDto = (UserDto) sessionUserInfo;
			try {
				UserDto userDto = userService.loginUser(sessionUserDto.getId());
				if (userDto == null) { // 해당 아이디 없음
					request.setAttribute("result", "no userinfo");
				} else {
					request.setAttribute("result", "success");
					request.setAttribute("user", userDto);
				}
			} catch (Exception e) {
				request.setAttribute("result", "error");
				e.printStackTrace();
			}
		}

		forward(request, response, "/user/info.jsp");
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		String msg = "";
		HttpSession session = request.getSession();
		Object sessionUserInfo = session.getAttribute("userinfo");
		if (sessionUserInfo == null) {
			msg = "please login";
		} else {
			UserDto sessionUserDto = (UserDto) sessionUserInfo;
			try {
				if (userService.deleteUser(sessionUserDto.getId()) == 1) { // 삭제 성공
					msg = "success";
					logout(request, response);
				} else {
					msg = "fail";
				}
			} catch (Exception e) {
				msg = "error";
				e.printStackTrace();
			}
		}

		return msg;
	}
	
	*/
	
}
