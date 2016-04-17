package com.briup.ch08.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		driver = "com.mysql.jdbc.Driver";
		//jdbc:mysql://ip:port/dbName
		url="jdbc:mysql://127.0.0.1:3307/liyoujing";
		user = "root";
		password = "730429";
		
	}
	/**
	 * 闈欐�佹柟娉�
	 * */
	public static Connection getConn() throws Exception{
		//鍔犺浇椹卞姩
		Class.forName(driver);
		//鑾峰彇杩炴帴
		return DriverManager.getConnection(url, user, password);
		
	}
	public static void close(ResultSet rs,PreparedStatement pstmt,Connection conn) throws SQLException{
		if(rs!=null){
			rs.close();
		}
		if(pstmt!=null){
			pstmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
