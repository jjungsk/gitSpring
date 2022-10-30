package com.ssafy.ws.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.model.service.BookService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/bookapi")
@CrossOrigin("*")
public class BookRestController {

	private static final Logger logger = LoggerFactory.getLogger(BookRestController.class);

	@Autowired
	BookService bs;
	
	// resource 경로를 가져오기 위해
	@Autowired
	ResourceLoader resLoader;
	
	// File
	@Autowired
	private ServletContext servletContext;

	@GetMapping("/book/{isbn}")
	@ApiOperation(value = "{isbn}에 해당하는 도서 정보를 반환한다.", response = Book.class)
	public ResponseEntity<?> select(@PathVariable String isbn) {
		Book book = new Book();
		
		book = bs.select(isbn);
		
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@GetMapping("/book")
	@ApiOperation(value = "query string에 해당하는 검색 조건에 해당하는 도서 목록을 반환한다.", response = Book.class)
	public ResponseEntity<?> search(@ModelAttribute SearchCondition condition) {
		List<Book> books = new ArrayList<>();
		
		books = bs.search(condition);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@PostMapping("/book")
	@ApiOperation(value = "Book 객체를 저장한다.", response = Integer.class)
	public ResponseEntity<?> insert(Book book, @RequestPart(required = false) MultipartFile file) throws IllegalStateException, IOException {

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
		
		bs.insert(book, file);
		
		return null;
	}

	@PutMapping("/book")
	@ApiOperation(value = "Book 객체를 수정한다.", response = Integer.class)
	public ResponseEntity<?> update(Book book, @RequestPart(required = false) MultipartFile file) {
		try {
			bs.update(book, file);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@DeleteMapping("/book/{isbn}")
	@ApiOperation(value = "Book 객체를 삭제한다.", response = Integer.class)
	public ResponseEntity<?> delete(@PathVariable String isbn) {
		bs.delete(isbn);
		
		return null;
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		return null;
	}
}
