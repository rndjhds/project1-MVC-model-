package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardservice.BoardDetailAction;
import boardservice.BoardListAction;
import orderservice.BuyEnd;
import orderservice.Delivery;
import orderservice.OrderAction;
import orderservice.OrderCancel;
import orderservice.OrderConfirm;
import orderservice.OrderListAction;
import model.OrderDTO;
import service.Action;
import service.ActionForward;


@WebServlet("*.odo")
public class OrderController extends HttpServlet {
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
	
		
		if(command.equals("/OrderAction.odo")) {
			try {
				action = new OrderAction();
				forward =action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		
		} else if(command.equals("/OrderListAction.odo")) {
			try {
				action = new OrderListAction();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		// 주문취소
		}else if(command.equals("/OrderCancel.odo")) {
			try {
				action = new OrderCancel();
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 회원주문확인
		}else if(command.equals("/OrderConfirm.odo")) {
	         try {
	            action = new OrderConfirm();
	            forward = action.execute(request, response);
	         } catch(Exception e) {
	            e.printStackTrace();
	         }
	         
		// 구매 확정
	    }else if(command.equals("/BuyEnd.odo")) {
	       try {
	            action = new BuyEnd();
	            forward = action.execute(request, response);
	         } catch(Exception e) {
	            e.printStackTrace();
	         }
		
		// 배송처리
		}else if(command.equals("/Delivery.odo")) {
	       try {
	            action = new Delivery();
	            forward = action.execute(request, response);
	         } catch(Exception e) {
	            e.printStackTrace();
	         }
    }
			
		
				
		
		if (forward != null) {
			if (forward.isRedirect()) { // redirect 방식으로 포워딩
				response.sendRedirect(forward.getPath());
			} else { // dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	
		} //doProcess end
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
		doProcess(request, response);
	}

}
