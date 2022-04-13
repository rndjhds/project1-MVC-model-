package model;

import java.sql.Timestamp;

public class SaleDTO {
	private int sale_num;
	private int sale_ordernum;
	private Timestamp sale_date;
	private int sale_qty;
	private int sale_total;
	private String member_id;
	private int book_num;
	private int book_price;
	
	public int getSale_num() {
		return sale_num;
	}
	public void setSale_num(int sale_num) {
		this.sale_num = sale_num;
	}
	public int getSale_ordernum() {
		return sale_ordernum;
	}
	public void setSale_ordernum(int sale_ordernum) {
		this.sale_ordernum = sale_ordernum;
	}
	public Timestamp getSale_date() {
		return sale_date;
	}
	public void setSale_date(Timestamp sale_date) {
		this.sale_date = sale_date;
	}
	public int getSale_qty() {
		return sale_qty;
	}
	public void setSale_qty(int sale_qty) {
		this.sale_qty = sale_qty;
	}
	public int getSale_total() {
		return sale_total;
	}
	public void setSale_total(int sale_total) {
		this.sale_total = sale_total;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
}
