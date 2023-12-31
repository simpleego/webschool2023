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
@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet2() {
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
		
		String jsonInfo = totalObject.toJSONString();
		System.out.println("members:"+jsonInfo);
		
		// 배열객체를 문자열로 변환하여 전송
		writer.print(jsonInfo);
	}

}
