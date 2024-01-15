package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("bdDAO")
public class BoardDAO {

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

	// 게시판 글 생성(추가)
	public void insertBoard(BoardVO vo) {
		System.out.println("==> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

	// 게시판 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("==> JDBC로 updatetBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

	// 게시판 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("==> JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

	// 게시판 글 조회, 상세조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("==> JDBC로 getBoardList() 기능 처리");
		List<BoardVO> boardList = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));

				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}

		return boardList;
	}

	// 게시판 상세 보기
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("==> JDBC로 getBoard() 기능 처리");
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}

		return board;
	}

}
