package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.board.model.BoardDto;
import com.ssafy.util.SqlMapConfig;

@Repository
public class BoardDaoImpl implements BoardDao {

	private final String NAMESPACE = "com.ssafy.board.model.dao.BoardDao.";
	
	@Override
	public int writeArticle(BoardDto boardDto) throws SQLException {
		int articleNo = 0;
		
		return articleNo;
	}

	@Override
	public List<BoardDto> listArticle(Map<String, Object> map) throws SQLException {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectList(NAMESPACE + "listArticle", map); // return type에 따라 sqlSession.selelct method가 달라진다
		}
	}

	@Override
	public int getTotalArticleCount(Map<String, Object> map) throws SQLException {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectOne(NAMESPACE + "getTotalArticleCount", map); // return type에 따라 sqlSession.selelct method가 달라진다
		}
	}

	@Override
	public BoardDto getArticle(int articleNo) throws SQLException {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectOne(NAMESPACE + "getArticle", articleNo); // return type에 따라 sqlSession.selelct method가 달라진다
		}
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
