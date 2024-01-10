package com.simple.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.sun.prism.Texture.WrapMode;

/**
 * Servlet implementation class JsonServlet1
 */
@WebServlet("/json3")
public class JsonServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		
		JSONObject totalObject = new JSONObject();
		JSONArray membersArray = new JSONArray();
		JSONObject memberInfo = new JSONObject();
		
		memberInfo.put("name","박지성");
		memberInfo.put("age","32");
		memberInfo.put("gender","남자");
		memberInfo.put("nickname","날센돌이");
		
		membersArray.add(memberInfo);
		
		
		memberInfo = new JSONObject();
		memberInfo.put("name","김연아");
		memberInfo.put("age","31");
		memberInfo.put("gender","여자");
		memberInfo.put("nickname","칼치");
		
		membersArray.add(memberInfo);
		totalObject.put("members",membersArray);
		
		JSONArray bookArray = new JSONArray();
		JSONObject bookInfo = new JSONObject();
		
		bookInfo.put("title","초보자를 위한 자바 프로그래밍");
		bookInfo.put("writer","이병승");
		bookInfo.put("price","30000");
		bookInfo.put("genre","IT");
		bookInfo.put("image","http://localhost:8080/AjaxPrj/image/image1.jpg");
		bookArray.add(bookInfo);
		
		bookInfo = new JSONObject();
		bookInfo.put("title","모두의 파이선");
		bookInfo.put("writer","이승찬");
		bookInfo.put("price","12000");
		bookInfo.put("genre","IT");
		bookInfo.put("image","http://localhost:8080/AjaxPrj/image/image2.jpg");
		bookArray.add(bookInfo);
		
		totalObject.put("books",bookArray);
		
		String jsonInfo = totalObject.toJSONString();
		
		System.out.println("객체:"+jsonInfo);
		
		// 배열객체를 문자열로 변환하여 전송
		writer.print(jsonInfo);
	}

}
