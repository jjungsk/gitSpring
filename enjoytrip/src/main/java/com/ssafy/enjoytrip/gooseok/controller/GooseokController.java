package com.ssafy.enjoytrip.gooseok.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gooseok")
public class GooseokController extends HttpServlet {
	private final Logger logger = LoggerFactory.getLogger(GooseokController.class);
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		if("sooncheon".equals(act)) {
			request.setAttribute("search", "순천시 맛집");
			forward(request, response, "gooseokgooseok/gooseok.jsp");
		}else if("seogwipo".equals(act)) {
			request.setAttribute("search", "서귀포시 맛집");
			forward(request, response, "gooseokgooseok/gooseok.jsp");
		}else if("gangreung".equals(act)) {
			request.setAttribute("search", "강릉시 맛집");
			forward(request, response, "gooseokgooseok/gooseok.jsp");
		}else if("haewoondae".equals(act)) {
			request.setAttribute("search", "해운대구 맛집");
			forward(request, response, "gooseokgooseok/gooseok.jsp");
		}else if("ganghwa".equals(act)) {
			request.setAttribute("search", "강화군 맛집");
			forward(request, response, "gooseokgooseok/gooseok.jsp");
		} else {
			request.setAttribute("msg", "잘못된 클릭입니다.");
			forward(request, response, "/index.jsp");
		}
		
	}


	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
