package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {

		// 1. Spring 컨테이너 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. 컨테이너로부터 필요한 객체를 요청
		BoardService boardService = (BoardService) container.getBean("boardService");

		// 3. 글 등록 기능 테스트
		BoardVO vo = new BoardVO();
		vo.setWriter("우수민");
		vo.setTitle("임시 제목10");
		vo.setContent("내일은 휴가. .....");

		boardService.insertBoard(vo);

		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		for (BoardVO board : boardList) {
			System.out.println("-->" + board);
		}

		container.close();

	}

}
