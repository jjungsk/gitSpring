package com.ssafy.ws.model.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.util.DBUtil;

@Repository
public class BookRepoImpl implements BookRepo {
	@Autowired
	private DataSource dataSource;
	
//	@Autowired
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	
//	private DataSource dataSource;
//	private DBUtil dbUtil;
//	
//	@Autowired
//	public BookRepoImpl(DataSource dataSource, DBUtil dbUtil) {
//		this.dataSource = dataSource;
//		this.dbUtil = dbUtil;
//	}
			

	@Override
	public int insert(Book book) throws SQLException  {
		
		System.out.println("insert");
		
		return 0;
		
//		int cnt = 0;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			conn = dataSource.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("insert into book(isbn, title, author, price, `desc`) \n");
//			sql.append("values(?, ?, ?, ?, ?) ");
//			
//			pstmt = conn.prepareStatement(sql.toString());
//			int idx = 0;
//			pstmt.setString(++idx, book.getBooknumber());
//			pstmt.setString(++idx, book.getBooktitle());
//			pstmt.setString(++idx, book.getAuthor());
//			pstmt.setInt(++idx, book.getPrice());
//			pstmt.setString(++idx, book.getDescription());
//			
//			cnt = pstmt.executeUpdate();
//			
//		} finally {
//			dbUtil.close(pstmt, conn);
//		}
//		
//		return cnt;
	}

	@Override
	public int update(Book book) throws SQLException  {
		
		System.out.println("update");
		
		return 0;
	}

	@Override
	public int delete(String booknumber) throws SQLException  {
		
		System.out.println("delete");
		
		return 0;
	}

	@Override
	public Book select(String booknumber) throws SQLException  {
		System.out.println("select");
		return null;
	}

	@Override
	public List<Book> search() throws SQLException {
		
		System.out.println("search");
		return null;
//		List<Book> list = new ArrayList<>();
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = dataSource.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("select isbn, title, author, price, 'desc' \n");
//			sql.append("from book ");
//			
//			pstmt = conn.prepareStatement(sql.toString());
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				Book book = new Book();
//				book.setBooknumber(rs.getString("isbn"));
//				book.setBooktitle(rs.getString("title"));
//				book.setAuthor(rs.getString("author"));
//				book.setPrice(rs.getInt("price"));
//				book.setDescription(rs.getString("desc"));
//				
//				list.add(book);
//			}
//			
//		} finally {
//			dbUtil.close(rs, pstmt, conn);
//		}
//		
//		return list;
	}

}
