package com.myhome.admin.chart;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.myhome.DBUtil;

/***
 * 가격변화차트 DAO입니다.
 * @author MY
 *
 */
public class ChartDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;

	
	public ChartDAO() {
		
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

	//원룸 매매차트
	public ArrayList<Chart1DTO> get1() {
		
		try {
			
			String sql = "select contractdate, roomtype, avg from vwAvg1";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<Chart1DTO> list1 = new ArrayList<Chart1DTO>();
			
			while (rs.next()) {
				
				Chart1DTO dto = new Chart1DTO();
				dto.setContractdate(rs.getString("contractdate"));
				dto.setRoomtype(rs.getString("roomtype"));
				dto.setAvg(rs.getString("avg"));
				
				list1.add(dto);

			}
			
			return list1;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	//원룸 전세차트 
	public ArrayList<Chart2DTO> get2() {
		try {
			
			String sql = "select contractdate, roomtype, avg from vwAvg2";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<Chart2DTO> list2 = new ArrayList<Chart2DTO>();
			
			while (rs.next()) {
				
				Chart2DTO dto = new Chart2DTO();
				dto.setContractdate(rs.getString("contractdate"));
				dto.setRoomtype(rs.getString("roomtype"));
				dto.setAvg(rs.getString("avg"));
				
				list2.add(dto);

			}
			
			return list2;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	//원룸 매매차트 
	public ArrayList<Chart3DTO> get3() {
		try {
			
			String sql = "select contractdate, roomtype, avg from vwAvg3";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<Chart3DTO> list3 = new ArrayList<Chart3DTO>();
			
			while (rs.next()) {
				
				Chart3DTO dto = new Chart3DTO();
				dto.setContractdate(rs.getString("contractdate"));
				dto.setRoomtype(rs.getString("roomtype"));
				dto.setAvg(rs.getString("avg"));
				
				list3.add(dto);

			}
			
			return list3;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	

}
