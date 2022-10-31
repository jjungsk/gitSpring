package com.ssafy.enjoytrip.do17.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.enjoytrip.do17.model.DoDto;
import com.ssafy.enjoytrip.do17.model.service.DoService;

@Controller
@RequestMapping("/do")
public class DoController extends HttpServlet {
	private final Logger logger = LoggerFactory.getLogger(DoController.class);
	
	private static final long serialVersionUID = 1L;

	private final DoService doService;
	
	public DoController(DoService doService) {
		logger.info("doController 생성자 호출");
		this.doService = doService;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		if ("list".equals(act)) {
			list(request, response);
		} else {
			redirect(request, response, "/index.jsp");
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
		List<DoDto> list = null;

		try {
			list = doService.list();
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(list);
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(jsonInString);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
