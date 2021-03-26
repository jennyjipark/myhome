package com.myhome.admin2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.myhome.DBUtil;

/**
 * admin2 DAO 추상클래스 및 메소드 입니다. 
 * @author 이대홍
 */
public abstract class Admin2 {
	/**
	 *DB관련 처리 변수 
	 */
	public Connection conn;
	public Statement st;
	public PreparedStatement ps;
	public ResultSet rs;
	public CallableStatement ct;

	/**
	 * 목록을 불러 오는 역할을 수행합니다 
	 * @param HashMap 검색어 카테코리 등을 담고 있는변수 
	 * @return DTO 반환
	 */
	public abstract ArrayList list(HashMap<String,String> map);
	
	/**
	 * 페이징 시의 최대 페이수를 돌려주는 역할을 수해합니다. 
	 * @param HashMap 검색어 카테코리 등을 담고 있는변수 
	 * @return DTO 반환
	 */
	public abstract int totalCount(HashMap<String, String> map);
	
	
	/**
	 * DB 닫기 
	 */
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("close : " + e);
		}
	}
	/**
	 * DB 열기 
	 */
	public Admin2() {
		conn =DBUtil.open();
	}


}



