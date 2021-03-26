package com.myhome;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MainDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;


	public MainDAO() {

		try {

			this.conn = DBUtil.open();
			this.stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println("MainDAO()");
			e.printStackTrace();
		}

	}

	
	//공지사항
	public ArrayList<MainDTO> notice() {
		
		try {
			
			String sql = "select * from tblNotice";
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<MainDTO> list = new ArrayList<MainDTO>();
			
			while (rs.next()) {
				
				MainDTO dto = new MainDTO();
				
				String title = rs.getString("title");
				
				if(title.length() > 17) {
					
					dto.setNotice(rs.getString("title").substring(0, 17) + "..");
				
				} else {
					
					dto.setNotice(rs.getString("title"));
				}
				
				System.out.println(dto.getNotice());
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
		
			
		}
			return null;
	}

	
	//부동산 체크리스트
	public ArrayList<MainDTO> checkList() {
		
		try {
			
			String sql = "select * from tblcheckList";
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<MainDTO> list = new ArrayList<MainDTO>();
			
			while (rs.next()) {
				
				MainDTO dto = new MainDTO();
				
				String title = rs.getString("title");
				
				if(title.length() > 20) {
					
					dto.setCheck(rs.getString("title").substring(0, 20) + "..");
				
				} else {
					
					dto.setCheck(rs.getString("title"));
				}
				
				list.add(dto);
				System.out.println(dto.getCheck());
			}
			
			return list;
			
		} catch (Exception e) {
			
		}
			return null;
	}

	
	//청약게시판
	public ArrayList<MainDTO> application() {
		
		try {
			
			String sql = "select * from tblapplication";
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<MainDTO> list = new ArrayList<MainDTO>();
			
			while (rs.next()) {
				
				MainDTO dto = new MainDTO();
				
				String title = rs.getString("title");
				
				
				if(title.length() > 20) {
					
					dto.setApplication(rs.getString("title").substring(0, 20) + "..");
					
				} else {
					
					dto.setApplication(rs.getString("title"));
				}
				
				list.add(dto);
				System.out.println(dto.getApplication());
				
			}
			
			return list;
			
		} catch (Exception e) {
		
			
		}
			return null;
	}

	//전체매물
	public int count1() {
		
		try {
			
			String sql = "select count(*) as cnt from tblProperty";
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			while (rs.next()) {
				
				MainDTO dto = new MainDTO();
				
				dto.setTotalCount(rs.getInt("cnt"));
				
				int count = dto.getTotalCount();
				
				return count;
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
			return 0;
	}


	//계약완료 매물
	public int count2() {
		

		try {
			
			String sql = "select count(*) as cnt from tblContract where contractState = '완료'";
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			while (rs.next()) {
				
				MainDTO dto = new MainDTO();
				
				dto.setTotalCount(rs.getInt("cnt"));
				
				int count = dto.getTotalCount();
				
				return count;
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
			return 0;
	}
	
}	


