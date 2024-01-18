<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 브라우저와 연결된 세션(번호표) 객체를 강제로 종료한다.
	session.invalidate();

	// 2. 세션 종료 후 처리
	response.sendRedirect("login.jsp");
%>