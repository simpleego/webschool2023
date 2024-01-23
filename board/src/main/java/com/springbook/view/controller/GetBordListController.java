package com.springbook.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBordListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
		// 2. DB 연동처리
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.jsp");
		
		return mav;
	}

}
