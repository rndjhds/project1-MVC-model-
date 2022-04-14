package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.OrderDTO;
import model.SaleDTO;

public class OrderDAO {

	private static OrderDAO instance = new OrderDAO();
	
	public static OrderDAO getInstance() {		// 정적 메소드
		
		
		return instance;
	}
	
	// 컨넥션풀에서 컨넥션을 구해오는 메소드
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	// 구매버튼 클릭시에 실행
	public int buyInsert(OrderDTO order) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql="insert into order_check ";
				   sql+=" values(order_check_seq.nextval,?,?,?,?,1,?,'배송대기',sysdate)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, order.getMember_id());
			pstmt.setString(2, order.getMember_name());
			pstmt.setInt(3, order.getBook_num());
			pstmt.setString(4, order.getBook_name());
			pstmt.setInt(5, order.getBook_price());
			
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		return result;
	}
	
	public int getCount() {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql ="select count(*) from order_check";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();		// SQL문 실행
			
			if(rs.next()) {
//				result = rs.getInt(1);
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
	
	
	public List<OrderDTO> getList(int start, int end){
		List<OrderDTO> list = new ArrayList<OrderDTO>();	// 왼쪽 부모 오른쪽 자식 업캐스팅
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
String sql="select * from (select rownum rnum, board.* from ";
		sql+=" (select * from order_check order by order_num desc) board ) ";
		sql+=" where rnum >= ? and rnum <= ?";
		
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();		// SQL문 실행
			
			while(rs.next()) {		
				OrderDTO order = new OrderDTO();
				order.setOrder_num(rs.getInt("order_num"));
				order.setMember_id(rs.getString("member_id"));
				order.setMember_name(rs.getString("member_name"));
				order.setBook_num(rs.getInt("book_num"));
				order.setBook_name(rs.getString("book_name"));
				order.setOrder_qty(rs.getInt("order_qty"));
				order.setBook_price(rs.getInt("book_price"));
				order.setOrder_status(rs.getString("order_status"));
				order.setOrder_date(rs.getTimestamp("order_date"));
				
				
				
				list.add(order);
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
	
	// 로그인 한 아이디만 주문목록 출력
	   public List<OrderDTO> getList2(int start, int end, String member_id){
	      List<OrderDTO> list = new ArrayList<OrderDTO>();   // 왼쪽 부모 오른쪽 자식 업캐스팅
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      try {
	         con = getConnection();
	         
	String sql="select * from (select rownum rnum, board.* from ";
	      sql+=" (select * from order_check order by order_num desc) board ) ";
	      sql+=" where rnum >= ? and rnum <= ? and member_id= ?";
	      
	         pstmt = con.prepareStatement(sql);
	         pstmt.setInt(1, start);
	         pstmt.setInt(2, end);
	         pstmt.setString(3, member_id);
	         rs = pstmt.executeQuery();      // SQL문 실행
	         
	         while(rs.next()) {      
	            OrderDTO order = new OrderDTO();
	            order.setOrder_num(rs.getInt("order_num"));
	            order.setMember_id(rs.getString("member_id"));
	            order.setMember_name(rs.getString("member_name"));
	            order.setBook_num(rs.getInt("book_num"));
	            order.setBook_name(rs.getString("book_name"));
	            order.setOrder_qty(rs.getInt("order_qty"));
	            order.setBook_price(rs.getInt("book_price"));
	            order.setOrder_status(rs.getString("order_status"));
	            order.setOrder_date(rs.getTimestamp("order_date"));
	            
	                        
	            list.add(order);
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
	
	
	public int orderStatusChange(int order_num, String status) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "update order_check set order_status=? where order_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setInt(2, order_num);
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) try {pstmt.close(); } catch(Exception e) {}
			if(con != null) try {con.close(); } catch(Exception e) {}
		}
		
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
