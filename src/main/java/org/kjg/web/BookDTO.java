package org.kjg.web;

public class BookDTO {
	private long number;
	private String imgName;
	private long isbn;
	private String title;
	private String person;
	private String publisher;
	private long price;
	private String search;
	private String cont;
	
	public BookDTO() {}
	
	public BookDTO( String imgName, long isbn, String title, String person, String publisher, long price, String cont) {
		this.imgName = imgName;
		this.isbn = isbn;
		this.title = title;
		this.person = person;
		this.publisher = publisher;
		this.price = price;
		this.cont = cont;
	}

	
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	
}
