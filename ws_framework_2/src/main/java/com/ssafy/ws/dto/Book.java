package com.ssafy.ws.dto;

public class Book {
	private String booknumber;
	private String booktitle;
	private String author;
	private int price;
	private String description;
	
	public Book() {
	}
	
	public Book(String booknumber, String booktitle, String author, int price, String description) {
		super();
		this.booknumber = booknumber;
		this.booktitle = booktitle;
		this.author = author;
		this.price = price;
		this.description = description;
	}

	public String getBooknumber() {
		return booknumber;
	}

	public void setBooknumber(String booknumber) {
		this.booknumber = booknumber;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Book [booknumber=" + booknumber + ", booktitle=" + booktitle + ", author=" + author + ", price=" + price
				+ ", description=" + description + "]";
	}
	
}