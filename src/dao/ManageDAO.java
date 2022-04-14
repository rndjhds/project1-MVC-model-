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
import model.ManageDTO;
import model.MemberDTO;
import model.SaleDTO;

public class ManageDAO {
	
	// 싱글톤 : 객체 생성을 한번만 수행하는 것.
		private static ManageDAO instance = new ManageDAO();
		
		public static ManageDAO getInstance() {		// 정적 메소드
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
				
				
				
				
						
				
				public int insert(MemberDTO member) {
					int result = 0;
					Connection con = null;
					PreparedStatement pstmt = null;
					
					try {
						con = getConnection();
						
						String sql="insert into manage values(manage_seq.nextval,?,?,?)";
					
						pstmt = con.prepareStatement(sql);
						
						
						
						pstmt.setString(1, member.getMember_id());
						pstmt.setString(2, member.getMember_grade());
						pstmt.setInt(3, member.getMember_mile());
						
											
						result = pstmt.executeUpdate();
							
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						if(pstmt != null) try {pstmt.close(); } catch(Exception e) {}
						if(con != null) try {con.close(); } catch(Exception e) {}
					}
					
					return result;
				}
//	
				
				
				// 판매내역 데이터 갯수 구하기
				public int getCount() {
					int result = 0;
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					try {
						con = getConnection();
						
						String sql ="select count(*) from manage";
						
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery();		// SQL문 실행
						
						if(rs.next()) {
//							result = rs.getInt(1);
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
				
				
				public List<MemberDTO> getList(int start, int end){
					List<MemberDTO> list = new ArrayList<MemberDTO>();	// 왼쪽 부모 오른쪽 자식 업캐스팅
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					try {
						con = getConnection();
						
			String sql="select * from (select rownum rnum, board.* from ";
//					sql+=" (select * from manage order by manage_num desc) board ) ";
					sql+=" (select * from member order by member_id asc) board ) ";
					sql+=" where rnum >= ? and rnum <= ?";
					
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, start);
						pstmt.setInt(2, end);
						rs = pstmt.executeQuery();		// SQL문 실행
						
						while(rs.next()) {		
//							ManageDTO manage = new ManageDTO();
//							
//							manage.setManage_num(rs.getInt("manage_num"));
//							manage.setMember_id(rs.getString("member_id"));
//							manage.setMember_grade(rs.getString("member_grade"));
//							manage.setMember_mile(rs.getInt("member_mile"));
							
							MemberDTO member = new MemberDTO();
							member.setMember_id(rs.getString("member_id"));
							member.setMember_grade(rs.getString("member_grade"));
							member.setMember_mile(rs.getInt("member_mile"));							
														
							list.add(member);
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
				
				public ManageDTO get(int manage_num) {
					ManageDTO manage = new ManageDTO();
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					try {
						con = getConnection();
						
						String sql="select * from manage where manage_num=?";
						
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, manage_num);
						rs = pstmt.executeQuery();		// SQL문 실행
						
						if(rs.next()) {
							
							manage.setManage_num(rs.getInt("manage_num"));
							manage.setMember_id(rs.getString("member_id"));
							manage.setMember_grade(rs.getString("member_grade"));
							manage.setMember_mile(rs.getInt("member_mile"));
																									
						}
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						if(rs != null) try { rs.close();}catch(Exception e) {}
						if(pstmt != null) try { pstmt.close();}catch(Exception e) {}
						if(con != null) try { con.close();}catch(Exception e) {}
					}						
					return manage;
				}
				
				public int mileCharge(ManageDTO manage) {
					int result = 0;
					Connection con = null;
					PreparedStatement pstmt = null;
					
					try {
						con = getConnection();
						
						String sql="update member set member_mile=?, member_grade=? where member_id=?";
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, manage.getMember_mile());						
						pstmt.setString(2, manage.getMember_grade());
						pstmt.setString(3, manage.getMember_id());
							   
						result = pstmt.executeUpdate();
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
						if(con != null) try {con.close();} catch(Exception e) {}
					}
					return result;
				}
				
		

}