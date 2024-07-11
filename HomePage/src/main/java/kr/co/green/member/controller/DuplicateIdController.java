package kr.co.green.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/member/duplicateId.do")
public class DuplicateIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DuplicateIdController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("userId");
		MemberServiceImpl memberService = new MemberServiceImpl();
		int duplicateCheck = memberService.duplicateId(id);
		
		if(duplicateCheck == 1) { // 중복
			response.getWriter().write("unavailable");
		} else { // 사용 가능(중복되지 않음)
			response.getWriter().write("available");
		}
	}
}









