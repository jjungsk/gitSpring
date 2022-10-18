package com.ssafy.ws.model.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.model.User;
import com.ssafy.ws.util.DBUtil;

@Repository
public class UserRepoImpl implements UserRepo {
	
	private DataSource dataSource;
	private DBUtil dbUtil;
	
	public UserRepoImpl(DataSource dataSource, DBUtil dbUtil) {
		this.dataSource = dataSource;
	}

	@Override
	public User select(String id) throws SQLException {
		
		User user = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, name, pass \n");
			sql.append("from user \n");
			sql.append("where id = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				
			} else {
				System.out.println("해당 유저가 없습니다.");
			}
			
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return user;
				
	}

}
