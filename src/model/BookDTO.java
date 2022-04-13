package model;

import java.sql.Timestamp;

public class BookDTO {

	private int book_num;
	private String book_author;
	private String book_name;
	private int book_price;
	private int book_stock;
	private int book_count;
	private String book_pb;
	private String book_category;
	private String book_content;
	private String book_img;
	private Timestamp book_reg;
	
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public int getBook_stock() {
		return book_stock;
	}
	public void setBook_stock(int book_stock) {
		this.book_stock = book_stock;
	}
	public int getBook_count() {
		return book_count;
	}
	public void setBook_count(int book_count) {
		this.book_count = book_count;
	}
	public String getBook_pb() {
		return book_pb;
	}
	public void setBook_pb(String book_pb) {
		this.book_pb = book_pb;
	}
	public String getBook_category() {
		return book_category;
	}
	public void setBook_category(String book_category) {
		this.book_category = book_category;
	}
	public String getBook_content() {
		return book_content;
	}
	public void setBook_content(String book_content) {
		this.book_content = book_content;
	}
	public String getBook_img() {
		return book_img;
	}
	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}
	public Timestamp getBook_reg() {
		return book_reg;
	}
	public void setBook_reg(Timestamp book_reg) {
		this.book_reg = book_reg;
	}

}
