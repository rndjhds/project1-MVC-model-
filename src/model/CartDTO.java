package model;

public class CartDTO {
	private int cart_no;
	private String member_id;
	private int cbook_num;
	private String cbook_name;
	private int cbook_price;
	
	public int getCart_no() {
		return cart_no;
	}
	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getCbook_num() {
		return cbook_num;
	}
	public void setCbook_num(int cbook_num) {
		this.cbook_num = cbook_num;
	}
	public String getCbook_name() {
		return cbook_name;
	}
	public void setCbook_name(String cbook_name) {
		this.cbook_name = cbook_name;
	}
	public int getCbook_price() {
		return cbook_price;
	}
	public void setCbook_price(int cbook_price) {
		this.cbook_price = cbook_price;
	}
	
}
