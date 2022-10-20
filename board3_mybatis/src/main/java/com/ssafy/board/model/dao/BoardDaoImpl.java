package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ssafy.board.model.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Override
	public int writeArticle(BoardDto boardDto) throws SQLException {
		int articleNo = 0;
		
		return articleNo;
	}

	@Override
	public List<BoardDto> listArticle(Map<String, Object> map) throws SQLException {
		return null;
	}

	@Override
	public int getTotalArticleCount(Map<String, String> map) throws SQLException {
		return 0;
	}

	@Override
	public BoardDto getArticle(int articleNo) throws SQLException {
		return null;
	}

	@Override
	public void updateHit(int articleNo) throws SQLException {
		
	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws SQLException {
		
	}

	@Override
	public void deleteArticle(int articleNo) throws SQLException {
		
	}

}
