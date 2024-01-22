package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.h2.engine.Session;
import org.omg.CORBA.Request;
import org.springframework.web.servlet.theme.SessionThemeResolver;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class DispatcherServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get 요청이 들어왔다.");
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post 요청이 들어왔다.");
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		
		// 1. 요청을 알아낸다.
		// URL 분석
		String uri = req.getRequestURI();
		System.out.println("uri:"+uri);
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("path:"+path);
		
		// 2. 요청에 따른(path) 서비스 클래스 객체 호출 
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
			//1. 사용자 입력 정보 추출
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			
			// 2. DB 연동 처리
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			// 3. 화면 네비게이션  
			if(user != null){
				// 로그인 성공
				resp.sendRedirect("getBoardList.do");
			} else {
				// 로그인 실패
				resp.sendRedirect("login.jsp");
			}
					
		}else if(path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			
			// 1. 브라우저와 연결된 세션(번호표) 객체를 강제로 종료한다.
			HttpSession session = req.getSession();
			session.invalidate();

			// 2. 세션 종료 후 처리
			resp.sendRedirect("login.jsp");
			
		}else if(path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
			// 1. 사용자 입력 정보 추출 	
			req.setCharacterEncoding("UTF-8");

			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			// 3. 화면 네비게이션			
			resp.sendRedirect("getBoardList.do");	
			
		}else if(path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");	
			
			// 1. 사용자 입력 정보 추출 
			
			req.setCharacterEncoding("UTF-8");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String seq = req.getParameter("seq");			
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			// 3. 화면 네비게이션
			resp.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");	
			
			// 1. 사용자 입력 정보 추출 	
			req.setCharacterEncoding("UTF-8");
			String seq = req.getParameter("seq");			
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			
			// 3. 화면 네비게이션
			resp.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/getBoard.do")) {
			System.out.println("글 상세보기 처리");	
			
			// 1. 검색할 게시글 번호 추출
			String seq = req.getParameter("seq");

			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			
			HttpSession session = req.getSession();
			session.setAttribute("board", board);
			resp.sendRedirect("getBoard.jsp");	
			
		}else if(path.equals("/getBoardList.do")) {
			System.out.println("글 목록보기 처리");	
			// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
			// 2. DB 연동처리
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			HttpSession session = req.getSession();
			session.setAttribute("boardList", boardList);
			resp.sendRedirect("getBoardList.jsp");	
		}
	}

}
