package com.simple.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=UTF-8");
		// Content 해석 방식을 알려줌

		PrintWriter out = resp.getWriter();

		String x_ = req.getParameter("x");
		String y_ = req.getParameter("y");
		String op = req.getParameter("operator");
		
		int x = 0;
		int y = 0;

		if (!x_.equals("")) {
			x = Integer.parseInt(x_);
		}
		if (!y_.equals("")) {
			y = Integer.parseInt(y_);
		}

		int result = 0;

		if (op.equals("+")) {
			result = x + y;
		} else if (op.equals("-")) {
			result = x - y;
		} else if (op.equals("x")) {
			result = x * y;
		} else {
			double result1 = 0.0;
			if (y > 0) {
				result1 = (double)x / y;
			}else {
				result1 = 0.0;
			}
			out.println("x " + op + "y " + "= " + result1);
			return;
		}

		out.println("x " + op + " y" + " = " + result);
	}

}
