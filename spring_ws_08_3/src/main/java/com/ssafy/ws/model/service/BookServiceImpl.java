package com.ssafy.ws.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dao.BookDao;
import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.util.PageNavigation;

/**
 * 빈으로 등록될 수 있도록 @Service를 선언한다.
 *
 */
@Service
public class BookServiceImpl implements BookService {

	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	/**
	 * has a 관계로 사용할 BookDao 타입의 dao를 선언한다.
	 */
<<<<<<< HEAD
	private BookDao bDao;
=======
	private BookDao dao;
>>>>>>> 8898bdd4d1b0d441d306d528d6831f01c6905c75
	/**
	 * 파일 업로드 경로를 설정하기 위해 ResourceLoader를 주입받는다.
	 */
	@Autowired
	ResourceLoader resLoader;

	/**
	 * setter를 통해 BookDao를 주입받는다.
	 * 
	 * @Autowired를 통해 BookDao 타입의 빈을 주입 받는다.
<<<<<<< HEAD
	 * @param bDao
	 */
	@Autowired
	public void setBookDao(BookDao bDao) {
		this.bDao = bDao;
	}

	public BookDao getBookDao() {
		return bDao;
=======
	 * @param dao
	 */
	@Autowired
	public void setBookRepo(BookDao dao) {
		this.dao = dao;
	}

	public BookDao getBookRepo() {
		return dao;
>>>>>>> 8898bdd4d1b0d441d306d528d6831f01c6905c75
	}

	@Override
	@Transactional
<<<<<<< HEAD
	public int insert(Book book) throws IllegalStateException, IOException {
		return bDao.insert(book);
	}


	@Override
	public Book select(String isbn) {
		return null;
	}

	@Override
	public List<Book> search(SearchCondition condition) throws Exception {
		
		return bDao.search(condition);
	}

	/**
	 * 리스트에 페이징을 적용하기 위한 메서드
	 * Map에 books를 키로 화면에 표시할 Book 목록을 저장하고
=======
	public int insert(Book book, MultipartFile file) throws IllegalStateException, IOException {
		fileHandling(book, file);
		return 0;
	}

	@Override
	@Transactional
	public int update(Book book, MultipartFile file) throws IllegalStateException, IOException {
		fileHandling(book, file);
		return dao.update(book);
	}

	private void fileHandling(Book book, MultipartFile file) throws IOException {
		// 파일을 저장할 폴더 지정
		Resource res = resLoader.getResource("resources/upload");
		logger.debug("res: {}", res.getFile().getCanonicalPath());
		if (file != null && file.getSize() > 0) {
			// prefix를 포함한 전체 이름
			book.setImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
			book.setOrgImg(file.getOriginalFilename());

			// 변경된 파일 이름이 적용된 Book을 BookService를 통해 DB에 저장한다.

			file.transferTo(new File(res.getFile().getCanonicalPath() + "/" + book.getImg()));
		}
	}

	@Override
	@Transactional
	public int delete(String isbn) {
		return dao.delete(isbn);
	}

	@Override
	public Book select(String isbn) {
		return dao.select(isbn);
	}

	@Override
	public List<Book> search(SearchCondition condition) {
		return dao.search(condition);
	}

	/**
	 * 리스트에 페이징을 적용하기 위한 메서드 Map에 books를 키로 화면에 표시할 Book 목록을 저장하고 navigation이라는 키로
	 * PageNavigation 객체를 저장해서 반환한다. PageNavigation을 만들기 위한 정보로 currentPage는
	 * SearchCondition에서 얻어오고 totalCount는 BookRepo에 새롭게 추가한 메서드를 사용한다.
>>>>>>> 8898bdd4d1b0d441d306d528d6831f01c6905c75
	 * 
	 * @param condition
	 * @return
	 */
	@Override
	public Map<String, Object> pagingSearch(SearchCondition condition) {
		return null;
	}

<<<<<<< HEAD

=======
>>>>>>> 8898bdd4d1b0d441d306d528d6831f01c6905c75
}
