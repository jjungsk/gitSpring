package com.ssafy.enjoytrip.sigungu.model.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.enjoytrip.sigungu.model.SigunguDto;
import com.ssafy.enjoytrip.util.DBUtil;

public class SigunguDaoImpl implements SigunguMapper {

	private static SigunguMapper sigunguDao = new SigunguDaoImpl();
	private DBUtil dbUtil;
	
	private SigunguDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static SigunguMapper getSigunguDao() {
		return sigunguDao;
	}
	
	@Override
	public List<SigunguDto> list(int areaCode) throws SQLException {
		List<SigunguDto> list = new ArrayList<SigunguDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select sigungu_code, name \n");
			sql.append("from sigungu \n");
			sql.append("where area_code = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, areaCode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SigunguDto sigunguDto = new SigunguDto();
				sigunguDto.setAreaCode(areaCode);
				sigunguDto.setSigunguCode(rs.getInt("sigungu_code"));
				sigunguDto.setName(rs.getString("name"));
				
				list.add(sigunguDto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

}
