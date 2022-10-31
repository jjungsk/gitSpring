package com.ssafy.enjoytrip.tourlist.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.enjoytrip.tourlist.model.TourListDto;
import com.ssafy.enjoytrip.tourlist.model.service.TourListService;
import com.ssafy.enjoytrip.util.ParameterCheck;

@Controller
@RequestMapping("/tourList")
public class TourListController extends HttpServlet {
	private Logger logger = LoggerFactory.getLogger(TourListController.class);
	
	private static final long serialVersionUID = 1L;

	private final TourListService tourListService;

	public TourListController(TourListService tourListService) {
		this.tourListService = tourListService;
	}
	
	@GetMapping("/todaysTour")
	public String todaysTour(Model model) {
		model.addAttribute("keywordRecommend", "오늘의 관광지");
		return "recommend/recommend";
	}
	
	
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");

		if ("mvTodaysTour".equals(act)) {
			firstRecommend(request, response, "오늘의 관광지");
		} else if ("todaysTour".equals(act)) {
			recommend(request, response, 12);
		} else if ("mvTodaysFestival".equals(act)) {
			firstRecommend(request, response, "오늘의 행사/공연/축제");
		} else if ("todaysFestival".equals(act)) {
			recommend(request, response, 15);
		} else if ("mvTodaysRestaurant".equals(act)) {
			firstRecommend(request, response, "오늘의 맛집");
		} else if ("todaysRestaurant".equals(act)) {
			recommend(request, response, 39);
		} else if ("mvSun".equals(act)) {
			sun(request, response, "/sun/sun.jsp");
		} else if ("map".equals(act)) {
			getData(request, response);
		} else if ("mvWeather".equals(act)) {
			weather(request, response, "/weather/weather.jsp");
		} else {
			redirect(request, response, "/index.jsp");
		}
	}


	private void weather(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		redirect(request, response, path);
		
	}

	private void getData(HttpServletRequest request, HttpServletResponse response) {
		int areaCode = Integer.parseInt(request.getParameter("areaCode"));
		int sigunguCode = Integer.parseInt(request.getParameter("sigunguCode"));
		int contentTypeId = ParameterCheck.notNumberToZero(request.getParameter("contentTypeId"));
		
		Map<String, Integer> map = new HashMap<>();
		map.put("areaCode", areaCode);
		map.put("sigunguCode", sigunguCode);
		map.put("contentTypeId", contentTypeId);
		
		try {
			List<TourListDto> list = tourListService.getData(map);
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(list);
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(jsonInString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void sun(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		redirect(request, response, path);
		
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);

	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	private void firstRecommend(HttpServletRequest request, HttpServletResponse response, String key) throws IOException {
		try {
			request.setAttribute("keywordRecommend", key);
			forward(request, response, "/recommend/recommend.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			redirect(request, response, "/index.jsp");
		}

	}

	private void recommend(HttpServletRequest request, HttpServletResponse response, int contentTypeId) {
		TourListDto tourListDto;
		try {
			tourListDto = tourListService.recommend(contentTypeId);
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(tourListDto);
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(jsonInString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	*/
}
