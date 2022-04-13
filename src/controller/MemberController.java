package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberservice.Delete;
import memberservice.Idcheck;
import memberservice.Login;
import memberservice.MemberInsert;
import memberservice.MileAddAction;
import memberservice.Update;
import memberservice.UpdateMember;
import service.Action;
import service.ActionForward;

@WebServlet("*.mdo")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		System.out.println("requestURI:" + requestURI);
		System.out.println("contextPath:" + contextPath);
		System.out.println("command:" + command);

		Action action = null;
		ActionForward forward = null;

		// 회원 가입
		if (command.equals("/MemberInsert.mdo")) {
			try {
				action = new MemberInsert();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		// ID 중복 검사(ajax)
		} else if (command.equals("/Idcheck.mdo")) {
			try {
				action = new Idcheck();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		// 회원 가입 폼
		}else if(command.equals("/MemberForm.mdo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/memberInsert.jsp");
		
		// 로그인(회원인증)
		}else if(command.equals("/Login.mdo")) {
			try {
				action = new Login();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 로그인 폼
		}else if(command.equals("/LoginForm.mdo")) {
			try {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("./member/memberLogin.jsp");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 로그아웃
		}else if(command.equals("/Logout.mdo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/memberLogout.jsp");
			
		// 회원 정보 수정 폼	
		}else if(command.equals("/UpdateMember.mdo")) {
			try {
				action = new UpdateMember();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 회원 정보 수정
		}else if(command.equals("/Update.mdo")) {
			try{
				action = new Update();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 회원 탈퇴 폼
		}else if(command.equals("/DeleteMember.mdo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/memberDelete.jsp");
			
		// 회원 탈퇴	
		}else if(command.equals("/Delete.mdo")) {
			try {
				action = new Delete();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		//마일리지 충전뷰 이동
		}else if(command.equals("/MileAdd.mdo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/MileAdd.jsp");
			
		//마일리지 충전해주기
		}else if(command.equals("/MileAddAction.mdo")) {
			try {
				action = new MileAddAction();
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 포워딩 처리
		if (forward != null) {
			if (forward.isRedirect()) { // Redirect 방식으로 포워딩
				response.sendRedirect(forward.getPath());
			} else { 					// Dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	} // doProcess() end

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get");

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post");

		doProcess(request, response);
	}
}
