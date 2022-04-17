package model;

import java.sql.Timestamp;

public class BoardDTO {
	private int board_num;
	private String board_writer;
	private String board_subject;
	private Timestamp board_date;
	private int board_rc;
	private String board_content;
	private int board_check;
	private int board_ref;
	private int board_lev;
	private int board_seq;
	private int board_pw;
	
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public Timestamp getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Timestamp board_date) {
		this.board_date = board_date;
	}
	public int getBoard_rc() {
		return board_rc;
	}
	public void setBoard_rc(int board_rc) {
		this.board_rc = board_rc;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public int getBoard_check() {
		return board_check;
	}
	public void setBoard_check(int board_check) {
		this.board_check = board_check;
	}
	public int getBoard_ref() {
		return board_ref;
	}
	public void setBoard_ref(int board_ref) {
		this.board_ref = board_ref;
	}
	public int getBoard_lev() {
		return board_lev;
	}
	public void setBoard_lev(int board_lev) {
		this.board_lev = board_lev;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public int getBoard_pw() {
		return board_pw;
	}
	public void setBoard_pw(int board_pw) {
		this.board_pw = board_pw;
	}
	
}
