package com.ssafy.enjoytrip.tourlist.model.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ssafy.enjoytrip.tourlist.model.TourListDto;
import com.ssafy.enjoytrip.util.DBUtil;

public class TourListDaoImpl implements TourListMapper {

	private static TourListMapper tourListDao = new TourListDaoImpl();
	private DBUtil dbUtil;
	
	private TourListDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static TourListMapper getTourListDao() {
		return tourListDao;
	}
	
	@Override
	public TourListDto recommend(int contentTypeId) throws SQLException {
		TourListDto tourListDto  = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select title, addr1, mapx, mapy, image, tel \n");
			sql.append("from tour_list \n");
			sql.append("where content_type_id = ? \n");
			sql.append("order by rand() \n");
			sql.append("limit 1 \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, contentTypeId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				tourListDto = new TourListDto();
				tourListDto.setTitle(rs.getString("title"));
				tourListDto.setAddr1(rs.getString("addr1"));
				tourListDto.setMapx(rs.getDouble("mapx"));
				tourListDto.setMapy(rs.getDouble("mapy"));
				tourListDto.setImage(rs.getString("image"));
				tourListDto.setTel(rs.getString("tel"));
			}
		} finally {
			dbUtil.close(conn, pstmt, rs);
		}
		
		return tourListDto;
	}

	@Override
	public List<TourListDto> getData(Map<String, Integer> map) throws SQLException {
		List<TourListDto> list  = new ArrayList<TourListDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select title, addr1, mapx, mapy, image, tel, zipcode \n");
			sql.append("from tour_list \n");
			sql.append("where area_code = ? and sigungu_code = ? \n");
			
			int areaCode = map.get("areaCode");
			int sigunguCode = map.get("sigunguCode");
			int contentTypeId = map.get("contentTypeId");
			if (contentTypeId != 0) {
				sql.append("and content_type_id = ?");
			}
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, areaCode);
			pstmt.setInt(2, sigunguCode);
			if (contentTypeId != 0) {
				pstmt.setInt(3, contentTypeId);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TourListDto tourListDto = new TourListDto();
				tourListDto.setTitle(rs.getString("title"));
				tourListDto.setAddr1(rs.getString("addr1"));
				tourListDto.setMapx(rs.getDouble("mapx"));
				tourListDto.setMapy(rs.getDouble("mapy"));
				tourListDto.setImage(rs.getString("image"));
				tourListDto.setTel(rs.getString("tel"));
				tourListDto.setZipcode(rs.getString("zipcode"));
				tourListDto.setAreaCode(areaCode);
				tourListDto.setSigunguCode(sigunguCode);
				tourListDto.setContentTypeId(contentTypeId);
				
				
				list.add(tourListDto);
			}
		} finally {
			dbUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}



}
