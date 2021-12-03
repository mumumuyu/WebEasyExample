package com.lgd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import com.lgd.pojo.Book;

public class BookDao {
	private Connection conn = null;
	public HashMap getAllBook() throws Exception{		
		HashMap hm = new HashMap();
		this.initConnection();
		Statement stat = conn.createStatement();
		String sql = "SELECT * FROM book";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			Book book = new Book();
			book = new Book();
			book.setId(rs.getString("id"));
			book.setName(rs.getString("name"));
			book.setPrice(rs.getFloat("price"));
			hm.put(book.getId(),book);
		}
		this.closeConnection();
		return hm;		
	}	
	public void initConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/javaweb-test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT",
						"root", "1328910");
	}
	public void closeConnection() throws Exception{
		conn.close();
	}
	
}
