package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAOJPA  boardDAO;
	
	public BoardServiceImpl() {
		//log = new LogAdvice();
		System.out.println("BoardServiceImp 생성자 호출됨");
	}
	
	@Override
	public void insertBoard(BoardVO vo) {	
		//log.printLog();
//		if(vo.getSeq() == 0) {
//			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
//		}
		
		System.out.println("글 등록 서비스");
		boardDAO.insertBoard(vo);		
	}

	@Override
	public void updateBoard(BoardVO vo) {
		//log.printLog();
		boardDAO.updateBoard(vo);		
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		//log.printLog();
		boardDAO.deleteBoard(vo);		
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {	
		//log.printLog();
		return boardDAO.getBoard(vo);
	}
	
	@Override 
	 public List<BoardVO> getBoardList(BoardVO vo) { 
		 //log.printLog();
		
		System.out.println("service");
		 return boardDAO.getBoardList(vo); 
	}
}
