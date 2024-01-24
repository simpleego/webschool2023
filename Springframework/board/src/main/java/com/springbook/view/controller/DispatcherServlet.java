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
	
	/*
	 * private HandlerMapping handlerMapping; private ViewResolver viewResolver;
	 * 
	 * @Override public void init() throws ServletException { handlerMapping = new
	 * HandlerMapping(); viewResolver = new ViewResolver();
	 * 
	 * viewResolver.setSuffix(".jsp"); viewResolver.setPrefix("/"); }
	 * 
	 * 
	 * @Override protected void doGet(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * System.out.println("get 요청이 들어왔다."); process(req, resp); }
	 * 
	 * @Override protected void doPost(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * System.out.println("post 요청이 들어왔다."); process(req, resp); }
	 * 
	 * private void process(HttpServletRequest req, HttpServletResponse resp) throws
	 * IOException { // TODO Auto-generated method stub
	 * 
	 * // 1. 요청을 알아낸다. // URL 분석 String uri = req.getRequestURI();
	 * System.out.println("uri:"+uri); String path =
	 * uri.substring(uri.lastIndexOf("/")); System.out.println("path:"+path);
	 * 
	 * // 2. 요청에 따른(path) 서비스 클래스 객체 호출 Controller ctrl =
	 * handlerMapping.getController(path);
	 * 
	 * // 3. 검색결과 얻은 컨트롤러 수행 String viewName = ctrl.handleRequest(req, resp);
	 * 
	 * // 4. 화면(View)처리를 위한 제어구조 String view = null; if(!viewName.contains(".do")) {
	 * view = viewResolver.getView(viewName); } else { view = viewName; }
	 * 
	 * // 5. view 호출 resp.sendRedirect(view); }
	 */
}
