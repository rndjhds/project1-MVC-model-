package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.BookDTO;
import model.MemberDTO;
import model.OrderDTO;

public class MemberDAO {
	
	// 싱글톤 : 객체 생성을 한번만 수행하는 것.
	private static MemberDAO instance = new MemberDAO();
		
	public static MemberDAO getInstance() {		// 정적 메소드
		return instance;
	}
		
	// 컨넥션풀에서 컨넥션을 구해오는 메소드
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
	  	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
	  	return ds.getConnection();
	}
		
	// 회원 가입
	public int insert(MemberDTO member) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql="insert into member ";
				   sql+=" values(?,?,?,?,?,?,?,?,?,?,'bronze','0')";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_pw());
			pstmt.setString(3, member.getMember_name());
			pstmt.setString(4, member.getMember_mailid());
			pstmt.setString(5, member.getMember_domain());
			pstmt.setString(6, member.getMember_phone1());
			pstmt.setString(7, member.getMember_phone2());
			pstmt.setString(8, member.getMember_phone3());
			pstmt.setString(9, member.getMember_post());
			pstmt.setString(10, member.getMember_address());
				   
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		return result;
	}
	
	// ID 중복 검사(ajax)
	public int idcheck(String member_id) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql="select * from member where member_id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();
		
			if(rs.next()) {		// 중복 ID
				result = 1;
			}else {				// 사용 가능한 ID
				result = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		return result;
	}
	
	// 로그인(회원 인증)
	public int memberAuth(String member_id, String member_pw) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql="select * from member where member_id=? and member_pw=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_id);
			pstmt.setString(2, member_pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {		// 회원 인증 성공
				result = 1;
			}else {				// 회원 인증 실패
				result = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		return result;
	}
	
	// 회원 1명의 상세 정보 구하기 : 수정 폼, 수정, 삭제
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
			rs = pstmt.executeQuery();
			
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
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		return member;
	}
	
	// 회원 정보 수정
	public int update(MemberDTO member) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
String sql="update member set member_name=?,member_mailid=?,member_domain=?, ";
	   sql+=" member_phone1=?,member_phone2=?,member_phone3=?,member_post=?, ";
	   sql+=" member_address=? where member_id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMember_name());
			pstmt.setString(2, member.getMember_mailid());
			pstmt.setString(3, member.getMember_domain());
			pstmt.setString(4, member.getMember_phone1());
			pstmt.setString(5, member.getMember_phone2());
			pstmt.setString(6, member.getMember_phone3());
			pstmt.setString(7, member.getMember_post());
			pstmt.setString(8, member.getMember_address());
			pstmt.setString(9, member.getMember_id());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		return result;
	}
	
	// 회원 탈퇴
	public int delete(String member_id) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql="delete from member where member_id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_id);
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		return result;
	}
	
	// 마일리지 증가
		public int mileAdd(String id, int mile) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql="update member set member_mile=? where member_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, mile);
				pstmt.setString(2, id);
					   
				result = pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
				if(con != null) try {con.close();} catch(Exception e) {}
			}
			return result;
		}
	
	// BuyInsert 실행
//		public int buyInsert(OrderDTO order) {
//			int result = 0;
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			
//			try {
//				con = getConnection();
//				
//				String sql="insert into order_check ";
//					   sql+=" values(order_check_seq.nextval,?,?,?,?,1,?,'배송대기',sysdate)";
//				
//				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, order.getMember_id());
//				pstmt.setString(2, order.getMember_name());
//				pstmt.setInt(3, order.getBook_num());
//				pstmt.setString(4, order.getBook_name());
//				pstmt.setInt(5, order.getBook_price());
//				
//				result=pstmt.executeUpdate();
//				
//			}catch(Exception e) {
//				e.printStackTrace();
//			}finally {
//				if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
//				if(con != null) try {con.close();} catch(Exception e) {}
//			}
//			
//			return result;
//		}
		
		
		
		
}
