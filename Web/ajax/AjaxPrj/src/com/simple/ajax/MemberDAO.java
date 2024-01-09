package com.simple.ajax;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String USER_DUPLICATE = 
			"select decode(count(*),1,'true','false')" + 
            " as result from t_member" +
			" where id=?";
	
	public boolean overlapedID(String id) {
		boolean result = false;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_DUPLICATE);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result"));
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return result;
	}

}
