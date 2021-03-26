package com.myhome.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.myhome.DBUtil;

public class AdminDAO {

	private Connection conn;
	private PreparedStatement pstat;
	private ResultSet rs;

	public AdminDAO() {
		conn =DBUtil.open();
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public String login(String id,String password) {
		// TODO Auto-generated method stub
		
		try {
			String sql = "select seqadmin from tbladmin where id = ? "
					+ "and password = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			pstat.setString(2, password);
			
			rs = pstat.executeQuery();
			
			if( rs.next() ) {
			
				 return rs.getString("seqadmin");	
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		
			System.out.println("admin login : "+e);
		}
		
		return null;
	}
	
	
	
	
}
