package manageservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ManageDAO;
import dao.SaleDAO;
import model.ManageDTO;
import model.MemberDTO;
import model.SaleDTO;
import service.Action;
import service.ActionForward;

public class ManageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("ManageAction");
		
		int page = 1;		// 현재 페이지 번호			기본변수1
		int limit = 10;		// 한 페이지에 출력할 데이터 갯수	기본변수2
		
		if(request.getParameter("page") != null) {  // 사용자가 선택한 페이지
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		// page = 1 : startRow = 1, endRow = 10    --맨 첫번째에서 열번째 까지 추출후 뽑아냄 큰수에서 작은수로 내림차순이기 때문에 가장큰수 10개 출력됨
		// page = 2 : startRow = 11, endRow = 20
		// page = 3 : startRow = 21, endRow = 30
		
		int startRow = (page - 1) * limit + 1;		// 추출하기 위한 시작 번호, 이 둘은 출력되는 목록의 갯수
		int endRow = page * limit;					// 끝나는 번호
		// 뽑아 오는 순서번호 -- 단 우리는  num--로 설정을 하였기 때문에 큰수부터 10개 뽑아오는 개념이다
		
		ManageDAO dao = ManageDAO.getInstance();
		int listcount = dao.getCount();		// 총 데이터 갯수		기본변수3
		System.out.println("listcount:" + listcount);
		
		List<MemberDTO> managelist = dao.getList(startRow, endRow); // 고객의 마일리지, 등급정보
		System.out.println("managelist:" + managelist);
		
		// 총 페이지
		int pageCount = listcount / limit + ((listcount%limit==0) ? 0:1);
		
		int startPage = ((page-1)/10) * limit + 1;	// 1, 11, 21...
		int endPage = startPage + 10 - 1;			// 10, 20, 30...
		
		if(endPage > pageCount) endPage = pageCount;
		
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("managelist", managelist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);        //dispatcher 방식으로 포워딩
		forward.setPath("./manage/ManageActionView.jsp");
		
		return forward;
		
		
	}

}
