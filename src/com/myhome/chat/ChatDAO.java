package com.myhome.chat;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.myhome.DBUtil;

public class ChatDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;

	public ChatDAO() {
		//DB 연결
		conn = DBUtil.open();
	}

	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}


	public String getChatUserList(String seqUser) {
		
		try {
			//누구누구랑 대화를 나눴는지
			String sql = "select distinct seqTheOther, au.name as name "
						+ "from tblUserChat uc "
						+ "inner join tblAllUser au "
						+ "on uc.seqTheOther = au.seqAllUser "
						+ "where uc.seqHost = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seqUser);
			
			rs = pstat.executeQuery();
			String result = "";
			
			while(rs.next()) {
				result += rs.getString("seqTheOther") + ",";	//번호 + 이름
				result += rs.getString("name") + ","; //,는 split을 위한 구분자
			}
			
			return result;
			
		} catch (Exception e) {
			System.out.println("ChatDAO.getChatUserList()" + e);
		}
		return null;
	}

	public String getChat(String seqUser, String seqTheOther) {
		
		try {
			String sql = "select * from tblUserChat where seqHost = ? and seqTheOther = ? "
						+ "union "
						+ "select * from tblUserChat where seqHost = ? and seqTheOther = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seqUser);
			pstat.setString(2, seqTheOther);
			pstat.setString(3, seqTheOther);
			pstat.setString(4, seqUser);
			
			rs = pstat.executeQuery();
			
			String line = "";
			
			while(rs.next()) {
				line += rs.getString("content") + ",";
			}
			
			return line;
		} catch (Exception e) {
			System.out.println("ChatDAO.getChat()" + e);
		}
		return null;
	}
}
