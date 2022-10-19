package com.ssafy.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;
import com.ssafy.member.model.MemberDto;
import com.ssafy.util.ParameterCheck;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService;

	public void init() {
		boardService = BoardServiceImpl.getBoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");

		int pgNo = ParameterCheck.notNumberToOne(request.getParameter("pgno"));
		String key = ParameterCheck.nullToBlank(request.getParameter("key"));
		String word = ParameterCheck.nullToBlank(request.getParameter("word"));
		String queryString = "pgno=" + pgNo + "&key=" + key + "&word=" + ParameterCheck.urlEncoding(word);
		System.out.println(queryString);
//		%ED%85%8C%EC%8A%A4%ED%8A%B8
//		%ED%85%8C%EC%8A%A4%ED%8A%B8

		if ("list".equals(act)) {
			list(request, response, queryString);
		} else if ("mvwrite".equals(act)) {
			redirect(request, response, "/board/write.jsp");
		} else if ("write".equals(act)) {
			write(request, response, queryString);
		} else if ("view".equals(act)) {
			view(request, response, queryString);
		} else if ("mvmodify".equals(act)) {
			mvModify(request, response, queryString);
		} else if ("modify".equals(act)) {
			modify(request, response, queryString);
		} else if ("delete".equals(act)) {
			delete(request, response, queryString);
		} else {
			redirect(request, response, "/index.jsp");
		}
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response, String queryString)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if (memberDto != null) {
			try {
				int pgNo = ParameterCheck.notNumberToOne(request.getParameter("pgno"));
				String key = ParameterCheck.nullToBlank(request.getParameter("key"));
				String word = ParameterCheck.nullToBlank(request.getParameter("word"));
				Map<String, String> map = new HashMap<>();
				map.put("pgno", pgNo + "");
				map.put("key", key);
				map.put("word", word);
				List<BoardDto> list = boardService.listArticle(map);
				request.setAttribute("articles", list);
				forward(request, response, "/board/list.jsp?" + queryString);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글목록 얻기 중 에러발생!!!");
				forward(request, response, "/error/error.jsp");
			}
		} else {
			redirect(request, response, "/user?act=mvlogin");
		}
	}

	private void write(HttpServletRequest request, HttpServletResponse response, String queryString)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if (memberDto != null) {

			BoardDto boardDto = new BoardDto();
			boardDto.setUserId(memberDto.getUserId());
			boardDto.setSubject(request.getParameter("subject"));
			boardDto.setContent(request.getParameter("content"));
			try {
				boardService.writeArticle(boardDto);
				redirect(request, response, "/board?act=list&" + queryString);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글작성 중 에러발생!!!");
				forward(request, response, "/error/error.jsp");
			}
		} else {
			redirect(request, response, "/user?act=mvlogin");
		}
	}

	private void view(HttpServletRequest request, HttpServletResponse response, String queryString)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if (memberDto != null) {
			try {
				int articleNo = Integer.parseInt(request.getParameter("articleno"));
				BoardDto boardDto = boardService.getArticle(articleNo);
				boardService.updateHit(articleNo);
				request.setAttribute("article", boardDto);
				forward(request, response, "/board/view.jsp?" + queryString);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글 얻기 중 에러발생!!!");
				forward(request, response, "/error/error.jsp");
			}
		} else {
			redirect(request, response, "/user?act=mvlogin");
		}
	}

	private void mvModify(HttpServletRequest request, HttpServletResponse response, String queryString) {

	}

	private void modify(HttpServletRequest request, HttpServletResponse response, String queryString) {

	}

	private void delete(HttpServletRequest request, HttpServletResponse response, String queryString)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if (memberDto != null) {
			try {
				int articleNo = Integer.parseInt(request.getParameter("articleno"));
				boardService.deleteArticle(articleNo);
				redirect(request, response, "/board?act=list&" + queryString);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글 삭제 중 에러발생!!!");
				forward(request, response, "/error/error.jsp");
			}
		} else {
			redirect(request, response, "/user?act=mvlogin");
		}
	}

}
