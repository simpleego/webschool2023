package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.jdbc.core.JdbcTemplate;

public class BoardDAOSpring  {
	
	private JdbcTemplate jdbcTemplate;
	
	// JDBC 멤버 선언
		private Connection conn = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;

		// SQL 명령어 준비
		private final String BOARD_INSERT = "INSERT INTO board(seq, title, writer, content) "
				+ "VALUES ( (SELECT nvl(max(seq),0)+1 FROM board), ?,?,?);";
		private final String BOARD_LIST = "SELECT * FROM board ORDER BY seq DESC;";
		private final String BOARD_GET = "SELECT * FROM board WHERE seq=?;";

		private final String BOARD_UPDATE = "UPDATE BOARD set title=?, content=? WHERE seq=?;";
		private final String BOARD_DELETE = "DELETE FROM BOARD WHERE seq=?;";

		

}
