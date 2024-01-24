package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController{
	
	
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
		 
		UserVO user = userDAO.getUser(vo);
		
		// 3. 화면 네비게이션  
		if(user != null){
			// 로그인 성공
			return "getBoardList.do";
		} else {
			// 로그인 실패
			return "login.jsp";
		}
		
	}

}
