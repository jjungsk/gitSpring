package com.ssafy.enjoytrip.do17.model.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.enjoytrip.do17.model.DoDto;
import com.ssafy.enjoytrip.util.DBUtil;

public class DoDaoImpl implements DoMapper {

	private static DoMapper doDao = new DoDaoImpl();
	private DBUtil dbUtil;
	
	private DoDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static DoMapper getDoDao() {
		return doDao;
	}
	
	@Override
	public List<DoDto> list() throws SQLException {
		List<DoDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select area_code, name \n");
			sql.append("from do \n");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DoDto doDto = new DoDto();
				doDto.setAreaCode(rs.getInt("area_code"));
				doDto.setName(rs.getString("name"));
				
				list.add(doDto);
			}
		}finally {
			dbUtil.close(pstmt, conn);
		}
		return list;
	}

}
