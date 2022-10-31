package com.ssafy.enjoytrip.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.enjoytrip.board.model.BoardDto;
import com.ssafy.enjoytrip.board.model.service.BoardService;
import com.ssafy.enjoytrip.user.model.UserDto;
import com.ssafy.enjoytrip.util.ParameterCheck;
import com.ssafy.enjoytrip.util.SizeConstant;

@Controller
@RequestMapping("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private ServletContext servletContext;

	private BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) {
		logger.info("boardController 생성자 호출");
		this.boardService = boardService;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");

		int pgNo = ParameterCheck.notNumberToOne(request.getParameter("pgno"));
		String key = ParameterCheck.nullToBlank(request.getParameter("key"));
		String word = ParameterCheck.nullToBlank(request.getParameter("word"));
		String queryString = "pgno=" + pgNo + "&key=" + key + "&word=" + ParameterCheck.urlEncoding(word);

		if ("list".equals(act)) {
			list(request, response, queryString);
		} else if ("listcontent".equals(act)) {
			listcontent(request, response);
		} else if ("preview".equals(act)) {
			preview(request, response);
		} else if ("mvwrite".equals(act)) {
			redirect(request, response, "/board/write.jsp?"+queryString);
		} else if ("write".equals(act)) {
			write(request, response, queryString);
		} else if ("view".equals(act)) {
			view(request, response, queryString);
		} else if ("mvmodify".equals(act)) {
			mvModify(request, response, queryString);
		} else if ("delete".equals(act)) {
			delete(request, response, queryString);
		} else if ("modify".equals(act)) {
			modify(request, response, queryString);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response, String queryString)
			throws ServletException, IOException {
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
			
			int totalArticle = boardService.countArticle();
			request.setAttribute("totalData", totalArticle);
			request.setAttribute("dataPerPage", SizeConstant.SIZE_PER_LIST);
			request.setAttribute("pageCount", SizeConstant.LIST_PER_PAGE);
			
			forward(request, response, "/board/list.jsp?" + queryString);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글목록 얻기 중 에러발생!!!");
			forward(request, response, "/index.jsp");
		}
	}
	

	private void listcontent(HttpServletRequest request, HttpServletResponse response) {
		int pgNo = ParameterCheck.notNumberToOne(request.getParameter("pgno"));
		Map<String, String> map = new HashMap<>();
		map.put("pgno", pgNo + "");
		map.put("key", "");
		map.put("word", "");
		try {
			List<BoardDto> list = boardService.listArticle(map);
			request.setAttribute("list", list);
			forward(request, response, "/board/listcontent.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private void preview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<BoardDto> list = boardService.preview(3);
			request.setAttribute("list", list);
			forward(request, response, "/board/preview.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void write(HttpServletRequest request, HttpServletResponse response, String queryString)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		if (userDto != null) {
			BoardDto boardDto = new BoardDto();
			boardDto.setUserId(userDto.getId());
			boardDto.setSubject(request.getParameter("subject"));
			boardDto.setContent(request.getParameter("content"));
			try {
				boardService.writeArticle(boardDto);
				redirect(request, response, "/board?act=list&" + queryString);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글작성 중 에러발생!!!");
				forward(request, response, "/index.jsp");
			}
		} else {
			request.setAttribute("msg", "로그인 후 이용 가능합니다.");
			forward(request, response, "/board?act=list&" + queryString);
		}

	}

	private void view(HttpServletRequest request, HttpServletResponse response, String queryString)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		if(userDto != null) {
			try {
				int articleNo = Integer.parseInt(request.getParameter("articleno"));
				BoardDto boardDto = boardService.getArticle(articleNo);
				boardService.updateHit(articleNo);
				request.setAttribute("article", boardDto);
				forward(request, response, "/board/view.jsp?" + queryString);
				;
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글 얻기 중 에러발생!!!");
				forward(request, response, "/index.jsp");
			}
		} else {
			request.setAttribute("msg", "로그인 후 이용 가능합니다.");
			forward(request, response, "/board?act=list&" + queryString);
		}

	}

	private void delete(HttpServletRequest request, HttpServletResponse response, String queryString)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		if(userDto != null) {
			try {
				int articleNo = Integer.parseInt(request.getParameter("articleno"));
				boardService.deleteArticle(articleNo);
				redirect(request, response, "/board?act=list");
				;
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글 삭제 중 에러발생!!!");
				forward(request, response, "/index.jsp");
			}
		} else {
			request.setAttribute("msg", "로그인 후 이용 가능합니다.");
			forward(request, response, "/board?act=list&" + queryString);
		}	
	}

	private void mvModify(HttpServletRequest request, HttpServletResponse response, String queryString) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		if(userDto != null) {
			int articleNo = Integer.parseInt(request.getParameter("articleno"));
			BoardDto boardDto;
			try {
				boardDto = boardService.getArticle(articleNo);
				request.setAttribute("article", boardDto);
				forward(request, response, "/board/modify.jsp?" + queryString);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "목록 처리 중 에러 발생!!!");
				forward(request, response, "/index.jsp");
			}
		} else {
			request.setAttribute("msg", "로그인 후 이용 가능합니다.");
			forward(request, response, "/board?act=list&" + queryString);
		}	

	}
	
	private void modify(HttpServletRequest request, HttpServletResponse response, String queryString) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		if(userDto != null) {
			BoardDto boardDto = new BoardDto();
			boardDto.setArticleNo(Integer.parseInt(request.getParameter("articleno")));
			boardDto.setSubject(request.getParameter("subject"));
			boardDto.setContent(request.getParameter("content"));
			try {
				boardService.modifyArticle(boardDto);
				redirect(request, response, "/board?act=list&" + queryString);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "수정 중 에러 발생!!!");
				forward(request, response, "/index.jsp");
			}
		} else {
			request.setAttribute("msg", "로그인 후 이용 가능합니다.");
			forward(request, response, "/board?act=list&" + queryString);
		}	
	}

}
