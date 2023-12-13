package com.simple.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.xml.ws.WebFault;

import com.sun.net.httpserver.Filter.Chain;

@WebFilter("/*")
public class CharacterIncodingFilter implements Filter  {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 필터 설정
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		
	}

}
