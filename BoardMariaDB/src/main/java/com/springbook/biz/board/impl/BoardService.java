package com.springbook.biz.board.impl;

import java.util.List;

import com.springbook.biz.board.BoardVO;

public interface BoardService {
	// Board CRUD
	// 글 등록
	void insertBoard(BoardVO vo);
	
	// 글 수정
	void updateBoard(BoardVO vo);
	
	// 글 삭제
	void deleteBoard(BoardVO vo);
	
	// 글 목록 조회
	List<BoardVO> getBoardList(BoardVO vo); 
	
	// 글 상제 조회
	BoardVO getBoard(BoardVO vo); 	
}
