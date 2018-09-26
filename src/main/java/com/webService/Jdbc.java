package com.webService;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Jdbc {
	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/loginuser";
	static String username = "root";
	static String password = "123456";
	static Connection initConn = null;

	static {
		try {
			Class.forName(driver);
			initConn = (Connection) DriverManager.getConnection(url, username,
					password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // classLoader,加载对应驱动
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void query() {
		Connection conn = initConn;
		ResultSet set ;
		String sql = "select * from user";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			set = pstmt.executeQuery();
			int col = set.getMetaData().getColumnCount();
			  while (set.next()) {
		            for (int i = 1; i <= col; i++) {
		                System.out.print(set.getString(i) + "\t");
		                if ((i == 2) && (set.getString(i).length() < 8)) {
		                    System.out.print("\t");
		                }
		             }
		            System.out.println("");
		        }
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
