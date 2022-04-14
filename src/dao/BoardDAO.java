package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.BoardDTO;

public class BoardDAO {
	
		// 싱글톤 : 객체 생성을 한번만 수행하는 것.
		private static BoardDAO instance = new BoardDAO();
		
		public static BoardDAO getInstance() {		// 정적 메소드
			return instance;
		}
		
		// 컨넥션풀에서 컨넥션을 구해오는 메소드
		private Connection getConnection() throws Exception{
			Context init = new InitialContext();
	  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
	  		return ds.getConnection();
		}
		
		// 총 (검색) 데이터 갯수
		public int getCount(String sel, String find) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				if(find == null) {
					String sql = "select count(*) from board";
					
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
				} else {
					String sql = "select count(*) from board where "+sel+" like '%"+find+"%'";
					
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
				}
				
				if(rs.next()) {
					result = rs.getInt("count(*)");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null)
					try {rs.close();} catch(Exception e) {}
				if(pstmt != null)
					try {pstmt.close();} catch(Exception e) {}
				if(con != null)
					try {con.close();} catch(Exception e) {}
			}
			return result;
		}
		
		// 게시판 (검색) 글 목록
		public List<BoardDTO> getList(int start, int end, String sel, String find) {
			List<BoardDTO> list = new ArrayList<BoardDTO>();
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println(sel);
			System.out.println(find);
			
			try {
				con = getConnection();
				
				if(find == null) {
					String sql = "select * from (select rownum rnum, board.* from (select * from board order by board_ref desc, board_seq asc) ";
					sql += "board) where rnum >= ? and rnum <= ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, start);
					pstmt.setInt(2, end);
					rs = pstmt.executeQuery();
					
				} else {
					String sql = "select * from (select rownum rnum, board.* from (select * from board where board_ref in";
							sql += " (select board_ref from board where "+sel+" like '%"+find+"%' and board_lev=0)";
							sql += " order by board_ref desc, board_seq asc) board) where rnum >= ? and rnum <= ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, start);
					pstmt.setInt(2, end);
					rs = pstmt.executeQuery();
				}
				
				while(rs.next()) {
					BoardDTO board = new BoardDTO();
					board.setBoard_num(rs.getInt("board_num"));
					board.setBoard_writer(rs.getString("board_writer"));
					board.setBoard_subject(rs.getString("board_subject"));
					board.setBoard_date(rs.getTimestamp("board_date"));
					board.setBoard_rc(rs.getInt("board_rc"));
					board.setBoard_content(rs.getString("board_content"));
					board.setBoard_check(rs.getInt("board_check"));
					board.setBoard_ref(rs.getInt("board_ref"));
					board.setBoard_lev(rs.getInt("board_lev"));
					board.setBoard_seq(rs.getInt("board_seq"));
					board.setBoard_pw(rs.getInt("board_pw"));
					
					list.add(board);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null)
					try {rs.close();} catch(Exception e) {}
				if(pstmt != null)
					try {pstmt.close();} catch(Exception e) {}
				if(con != null)
					try {con.close();} catch(Exception e) {}
			}
			return list;
		}
		
		// 게시판 조회수
		public void rcUpdate(int board_num) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "update board set board_rc=board_rc+1 where board_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_num);
				pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null)
					try {pstmt.close();} catch(Exception e) {}
				if(con != null)
					try {con.close();} catch(Exception e) {}
			}
		}
		
		// 게시판 상세정보
		public BoardDTO getDetail(int board_num) {
			BoardDTO board = new BoardDTO();
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql = "select * from board where board_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_num);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					board.setBoard_num(rs.getInt("board_num"));
					board.setBoard_writer(rs.getString("board_writer"));
					board.setBoard_subject(rs.getString("board_subject"));
					board.setBoard_date(rs.getTimestamp("board_date"));
					board.setBoard_rc(rs.getInt("board_rc"));
					board.setBoard_content(rs.getString("board_content"));
					board.setBoard_check(rs.getInt("board_check"));
					board.setBoard_ref(rs.getInt("board_ref"));
					board.setBoard_lev(rs.getInt("board_lev"));
					board.setBoard_seq(rs.getInt("board_seq"));
					board.setBoard_pw(rs.getInt("board_pw"));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null)
					try {rs.close();} catch(Exception e) {}
				if(pstmt != null)
					try {pstmt.close();} catch(Exception e) {}
				if(con != null)
					try {con.close();} catch(Exception e) {}
			}
			return board;
		}
		
		// 게시판 글 작성
		public int insert(BoardDTO board) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "insert into board values(board_seq.nextval, ?, ?, sysdate, 0, ?, 0, board_seq.nextval, 0, 0, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, board.getBoard_writer());
				pstmt.setString(2, board.getBoard_subject());
				pstmt.setString(3, board.getBoard_content());
				pstmt.setInt(4, board.getBoard_pw());
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null)
					try {pstmt.close();} catch(Exception e) {}
				if(con != null)
					try {con.close();} catch(Exception e) {}
			}
			return result;
		}
		
		// 게시판 댓글 작성
		public int reply(BoardDTO board) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			int board_ref = board.getBoard_ref();
			int board_lev = board.getBoard_lev();
			int board_seq = board.getBoard_seq();
			
			try {
				con = getConnection();
				
				String sql = "update board set board_seq=board_seq+1 where board_ref=? and board_seq>?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_ref);
				pstmt.setInt(2, board_seq);
				pstmt.executeUpdate();
				
				sql = "insert into board values(board_seq.nextval, ?, ?, sysdate, 0, ?, 0, ?, ?, ?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, board.getBoard_writer());
				pstmt.setString(2, board.getBoard_subject());
				pstmt.setString(3, board.getBoard_content());
				pstmt.setInt(4, board_ref);
				pstmt.setInt(5, board_lev+1);
				pstmt.setInt(6, board_seq+1);
				pstmt.setInt(7, board.getBoard_pw());
				result = pstmt.executeUpdate();
				
				sql = "update board set board_check=1 where board_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_ref);
				pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null)
					try {pstmt.close();} catch(Exception e) {}
				if(con != null)
					try {con.close();} catch(Exception e) {}
			}
			return result;
		}
		
		// 게시판 글 수정
		public int update(BoardDTO board) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "update board set board_writer=?, board_subject=?, board_content=? where board_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, board.getBoard_writer());
				pstmt.setString(2, board.getBoard_subject());
				pstmt.setString(3, board.getBoard_content());
				pstmt.setInt(4, board.getBoard_num());
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null)
					try {pstmt.close();} catch(Exception e) {}
				if(con != null)
					try {con.close();} catch(Exception e) {}
			}
			return result;
		}
		
		// 게시판 글 삭제
		public int delete(int board_num) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "delete from board where board_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_num);
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null)
					try {pstmt.close();} catch(Exception e) {}
				if(con != null)
					try {con.close();} catch(Exception e) {}
			}
			return result;
		}
}
