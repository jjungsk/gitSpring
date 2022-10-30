package com.ssafy.ws.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/book/{isbn}")
	@ApiOperation(value = "{isbn}에 해당하는 도서 정보를 반환한다.", response = Book.class)
	public ResponseEntity<?> select(@PathVariable String isbn) {
		return null;
	}

	// @ModelAttribute SearchCondition condition
	@GetMapping("/book")
	@ApiOperation(value = "query string에 해당하는 검색 조건에 해당하는 도서 목록을 반환한다.", response = Book.class)
	public ResponseEntity<?> search(@ModelAttribute SearchCondition condition) {
		logger.debug("book list searchCond info: {}", condition);
		
		return null;
	}

	@PostMapping("/book")
	@ApiOperation(value = "Book 객체를 저장한다.", response = Integer.class)
	public ResponseEntity<?> insert(Book book, @RequestPart(required = false) MultipartFile file) {
		return null;
	}

	@PutMapping("/book")
	@ApiOperation(value = "Book 객체를 수정한다.", response = Integer.class)
	public ResponseEntity<?> update(Book book, @RequestPart(required = false) MultipartFile file) {
		return null;
	}

	@DeleteMapping("/book/{isbn}")
	@ApiOperation(value = "Book 객체를 삭제한다.", response = Integer.class)
	public ResponseEntity<?> delete(@PathVariable String isbn) {
		return null;
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		return null;
	}
}
