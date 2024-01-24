package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class LoginController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		
		//1. 사용자 입력 정보 추출
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		ModelAndView mav = new ModelAndView();
		
		// 3. 화면 네비게이션  
		if(user != null){
			// 로그인 성공
			mav.setViewName("getBoardList.do");
		} else {
			// 로그인 실패
			mav.setViewName("login.jsp");
		}
		
		return mav;		
	}

}
