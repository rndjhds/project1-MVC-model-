package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import model.BookDTO;
import model.MemberDTO;
import model.SaleDTO;

public class SaleDAO {
	
	// 싱글톤 : 객체 생성을 한번만 수행하는 것.
		private static SaleDAO instance = new SaleDAO();
		
		public static SaleDAO getInstance() {		// 정적 메소드
			return instance;
		}
		
		// 컨넥션풀에서 컨넥션을 구해오는 메소드
		private Connection getConnection() throws Exception{
			Context init = new InitialContext();
	  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
	  		return ds.getConnection();
		}
		
		//상세 정보 구하기
		public MemberDTO getMember(String member_id) {
			MemberDTO member = new MemberDTO();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql="select * from member where member_id=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member_id);
				rs = pstmt.executeQuery();		// SQL문 실행
				
				if(rs.next()) {
					
					member.setMember_id(rs.getString("member_id"));
					member.setMember_pw(rs.getString("member_pw"));
					member.setMember_name(rs.getString("member_name"));
					member.setMember_mailid(rs.getString("member_mailid"));
					member.setMember_domain(rs.getString("member_domain"));
					member.setMember_phone1(rs.getString("member_phone1"));
					member.setMember_phone2(rs.getString("member_phone2"));
					member.setMember_phone3(rs.getString("member_phone3"));
					member.setMember_post(rs.getString("member_post"));
					member.setMember_address(rs.getString("member_address"));
					member.setMember_grade(rs.getString("member_grade"));
					member.setMember_mile(rs.getInt("member_mile"));
															
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(rs != null) try { rs.close();}catch(Exception e) {}
				if(pstmt != null) try { pstmt.close();}catch(Exception e) {}
				if(con != null) try { con.close();}catch(Exception e) {}
			}						
			return member;
		}
		// 책정보 구해오기
		public BookDTO getBook(int book_num) {
			BookDTO book = new BookDTO();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql="select * from book where book_num=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, book_num);
				rs = pstmt.executeQuery();		// SQL문 실행
				
				if(rs.next()) {
					
					book.setBook_num(rs.getInt("book_num"));
					book.setBook_author(rs.getString("book_author"));
					book.setBook_name(rs.getString("book_name"));
					book.setBook_price(rs.getInt("book_price"));
					book.setBook_stock(rs.getInt("book_stock"));
					book.setBook_count(rs.getInt("book_count"));
					book.setBook_pb(rs.getString("book_pb"));
					book.setBook_category(rs.getString("category"));
					book.setBook_content(rs.getString("book_content"));
					book.setBook_img(rs.getString("book_image"));
					book.setBook_reg(rs.getTimestamp("book_reg"));
					
									
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(rs != null) try { rs.close();}catch(Exception e) {}
				if(pstmt != null) try { pstmt.close();}catch(Exception e) {}
				if(con != null) try { con.close();}catch(Exception e) {}
			}						
			return book;
		}
		
		// 구매: 원문작성
		public int insert(BookDTO book,MemberDTO member) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql="insert into sale values(sale_seq.nextval,sysdate,?,?,?,?,?)";
			
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, book.getBook_count());
				pstmt.setString(2, member.getMember_id());
				pstmt.setInt(3, book.getBook_num());
				pstmt.setInt(4, book.getBook_price());
				pstmt.setString(5, book.getBook_name());
				result = pstmt.executeUpdate();
					
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt != null) try {pstmt.close(); } catch(Exception e) {}
				if(con != null) try {con.close(); } catch(Exception e) {}
			}
			
			return result;
		}
		
		
		
		// 판매내역 데이터 갯수 구하기
		public int getCount() {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql ="select count(*) from sale";
				
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();		// SQL문 실행
				
				if(rs.next()) {
//					result = rs.getInt(1);
					result = rs.getInt("count(*)");
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(rs != null) try {rs.close(); } catch(Exception e) {}
				if(pstmt != null) try {pstmt.close(); } catch(Exception e) {}
				if(con != null) try {con.close(); } catch(Exception e) {}
			}
					
			return result;
		}
		
		
		public List<SaleDTO> getList(int start, int end){
			List<SaleDTO> list = new ArrayList<SaleDTO>();	// 왼쪽 부모 오른쪽 자식 업캐스팅
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
	String sql="select * from (select rownum rnum, board.* from ";
			sql+=" (select * from sale order by sale_num desc) board ) ";
			sql+=" where rnum >= ? and rnum <= ?";
			
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				rs = pstmt.executeQuery();		// SQL문 실행
				
				while(rs.next()) {		
					SaleDTO sale = new SaleDTO();
					sale.setSale_num(rs.getInt("sale_num"));
					sale.setSale_date(rs.getTimestamp("sale_date"));
					sale.setSale_qty(rs.getInt("sale_qty"));
					sale.setMember_id(rs.getString("member_id"));
					sale.setBook_num(rs.getInt("book_num"));
					sale.setBook_price(rs.getInt("book_price")); 
					sale.setBook_name(rs.getString("book_name"));
					
					list.add(sale);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(rs != null) try {rs.close(); } catch(Exception e) {}
				if(pstmt != null) try {pstmt.close(); } catch(Exception e) {}
				if(con != null) try {con.close(); } catch(Exception e) {}
			}
					
			return list;
		}
		
		
		
	// db관련 메소드 아래쪽에 추가	
		

}
