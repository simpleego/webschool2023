package com.simple.web;

import java.util.List;

import com.simple.web.impl.BoardDAO;

public class BoardClient {

	public static void main(String[] args) {

		BoardDAO boardDAO = new BoardDAO();

		BoardVO vo = new BoardVO();
		vo.setTitle("myBatis 제목");
		vo.setWriter("홍길동");
		vo.setContent("myBatis 내용입니다...");
		boardDAO.insertBoard(vo);

		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}

}
