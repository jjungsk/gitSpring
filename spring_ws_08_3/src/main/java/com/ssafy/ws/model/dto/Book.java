package com.ssafy.ws.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class Book {
	private String isbn;
	private String author;
	private String title;
	private int price;
	private String content;
	// 중복 파일을 방지하기 위해 img에 prefix를 추가한 이름
	private String img;
	// 파일 업로드를 처리하기 위해 MultipartFile을 추가한다.
	private MultipartFile file;
	// 클라이언트가 최초 업로드한 파일 이름
	private String orgImg;

	public Book() {
	}

	public Book(String isbn, String author, String title, int price, String content, String img) {
		this(isbn, author, title, price, content, img, null);
	}

	public Book(String isbn, String author, String title, int price, String content, String img, MultipartFile file) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.price = price;
		this.content = content;
		this.img = img;
		this.file = file;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getOrgImg() {
		return orgImg;
	}

	public void setOrgImg(String orgImg) {
		this.orgImg = orgImg;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", author=" + author + ", title=" + title + ", price=" + price + ", content="
				+ content + ", img=" + img + ", file=" + file + "]";
	}

}
