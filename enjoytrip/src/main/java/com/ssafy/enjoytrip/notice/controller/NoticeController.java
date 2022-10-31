package com.ssafy.enjoytrip.notice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
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

import com.ssafy.enjoytrip.notice.model.NoticeDto;
import com.ssafy.enjoytrip.notice.model.service.NoticeService;
import com.ssafy.enjoytrip.user.model.UserDto;
import com.ssafy.enjoytrip.util.ParameterCheck;
import com.ssafy.enjoytrip.util.SizeConstant;

@Controller
@RequestMapping("/notice")
public class NoticeController extends HttpServlet {
	private final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	private static final long serialVersionUID = 1L;

	private final NoticeService noticeService;

	@Autowired
	public NoticeController(NoticeService noticeService) {
		this.noticeService = noticeService;
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
			redirect(request, response, "/notice/write.jsp" + queryString);
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

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			List<NoticeDto> list = noticeService.listArticle(map);
			request.setAttribute("notices", list);

			int totalArticle = noticeService.countArticle();
			request.setAttribute("totalData", totalArticle);
			request.setAttribute("dataPerPage", SizeConstant.SIZE_PER_LIST);
			request.setAttribute("pageCount", SizeConstant.LIST_PER_PAGE);

			forward(request, response, "/notice/list.jsp?" + queryString);
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
			List<NoticeDto> list = noticeService.listArticle(map);
			request.setAttribute("list", list);
			forward(request, response, "/notice/listcontent.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void preview(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<NoticeDto> list = noticeService.preview(3);
			request.setAttribute("list", list);
			forward(request, response, "/notice/preview.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void write(HttpServletRequest request, HttpServletResponse response, String queryString)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		if (userDto != null && userDto.getIsManager() != 0) {
			NoticeDto noticeDto = new NoticeDto();
			noticeDto.setUserId(userDto.getId());
			noticeDto.setSubject(request.getParameter("subject"));
			noticeDto.setContent(request.getParameter("content"));
			try {
				noticeService.writeArticle(noticeDto);
				redirect(request, response, "/notice?act=list&" + queryString);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글작성 중 에러발생!!!");
				forward(request, response, "/index.jsp");
			}
		} else {
			request.setAttribute("msg", "관리자만 이용 가능합니다.");
			forward(request, response, "/notice?act=list&" + queryString);
		}

	}

	private void view(HttpServletRequest request, HttpServletResponse response, String queryString)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		if (userDto != null) {
			try {
				int articleNo = Integer.parseInt(request.getParameter("articleno"));
				NoticeDto noticeDto = noticeService.getArticle(articleNo);
				noticeService.updateHit(articleNo);
				request.setAttribute("notice", noticeDto);
				forward(request, response, "/notice/view.jsp?" + queryString);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글 얻기 중 에러발생!!!");
				forward(request, response, "/index.jsp");
			}
		} else {
			request.setAttribute("msg", "로그인 이후 이용 가능합니다.");
			forward(request, response, "/notice?act=list&" + queryString);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response, String queryString)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		if (userDto != null && userDto.getIsManager() != 0) {
			try {
				int articleNo = Integer.parseInt(request.getParameter("articleno"));
				noticeService.deleteArticle(articleNo);
				redirect(request, response, "/notice?act=list");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글 삭제 중 에러발생!!!");
				forward(request, response, "/index.jsp");
			}
		} else {
			request.setAttribute("msg", "관리자만 이용 가능합니다.");
			forward(request, response, "/notice?act=list&" + queryString);
		}
	}

	private void mvModify(HttpServletRequest request, HttpServletResponse response, String queryString)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		if (userDto != null && userDto.getIsManager() != 0) {
			int articleNo = Integer.parseInt(request.getParameter("articleno"));
			NoticeDto noticeDto;
			try {
				noticeDto = noticeService.getArticle(articleNo);
				request.setAttribute("notice", noticeDto);
				forward(request, response, "/notice/modify.jsp?" + queryString);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "목록 처리 중 에러 발생!!!");
				forward(request, response, "/index.jsp");

			}
		} else {
			request.setAttribute("msg", "관리자만 이용 가능합니다.");
			forward(request, response, "/notice?act=list&" + queryString);
		}
	}

	private void modify(HttpServletRequest request, HttpServletResponse response, String queryString)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		if (userDto != null && userDto.getIsManager() != 0) {
			NoticeDto noticeDto = new NoticeDto();
			noticeDto.setArticleNo(Integer.parseInt(request.getParameter("articleno")));
			noticeDto.setSubject(request.getParameter("subject"));
			noticeDto.setContent(request.getParameter("content"));
			try {
				noticeService.modifyArticle(noticeDto);
				redirect(request, response, "/notice?act=list&" + queryString);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "수정 중 에러 발생!!!");
				forward(request, response, "/index.jsp");
			}
		} else {
			request.setAttribute("msg", "관리자만 이용 가능합니다.");
			forward(request, response, "/notice?act=list&" + queryString);
		}
	}

}
