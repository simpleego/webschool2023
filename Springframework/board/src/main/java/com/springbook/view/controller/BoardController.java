package com.springbook.view.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리==>");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		
		System.out.println("글 수정 처리");
		
		boardDAO.updateBoard(vo);
		
		// 3. 화면 네비게이션
		return "redirect:getBoardList.do";		
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		
		System.out.println("글 삭제 처리");
		
		boardDAO.deleteBoard(vo);		
		// 3. 화면 네비게이션
		return "getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo,
			BoardDAO boardDAO, ModelAndView mav
			) {
		
		System.out.println("글 상세 조회 처리");
		
		BoardVO board = boardDAO.getBoard(vo);
		
		// 3. 응답 화면 구성
		mav.addObject("board", board);
		mav.setViewName("getBoard.jsp");
		
		return mav;		
	}
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, 
						BoardDAO boardDAO,
						ModelAndView mav) {		
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList.jsp");
		
		return mav;
	}

}
