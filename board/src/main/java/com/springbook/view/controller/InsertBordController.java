package com.springbook.view.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;


@Controller
public class InsertBordController {

	public void insertBoard(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);

		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.do");

		// 3. 화면 네비게이션
		return mav;
	}

}
