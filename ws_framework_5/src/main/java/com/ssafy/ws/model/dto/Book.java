package com.ssafy.ws.model.dto;

import java.util.List;

public class Book {
	private String isbn;
	private String author;
	private String title;
	private int price;
	private String content;
	private String img;
	private String orgImg;
	private List<FileInfoDto> fileInfos;

	public Book() {
	}

	public Book(String isbn, String author, String title, int price, String content, String img) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.price = price;
		this.content = content;
		this.img = img;
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
	
	public String getOrgImg() {
		return orgImg;
	}


	public void setOrgImg(String orgImg) {
		this.orgImg = orgImg;
	}
	
	public List<FileInfoDto> getFileInfos() {
		return fileInfos;
	}

	public void setFileInfos(List<FileInfoDto> fileInfos) {
		this.fileInfos = fileInfos;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", author=" + author + ", title=" + title + ", price=" + price + ", content=" + content + ", img=" + img + "]";
	}

}
