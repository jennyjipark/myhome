package com.myhome.contractor.upload;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.myhome.DBUtil;

/**
 * @author 박지현
 * 중개인 본인 매물 올리기
 */
public class UploadContractorDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;

	
	/**
	 * @author 박지현
	 * 생성자
	 */
	public UploadContractorDAO() {

		try {

			this.conn = DBUtil.open();
			this.stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println("UploadConractorDAO()");
			e.printStackTrace();
		}

	}
	
	
	
	/**
	 * 방 형태 넣기
	 * @param roomType
	 * @param spacing
	 * @return 결과값
	 */
	public int insertRoom(String roomType, String spacing) {
		
		try {
			
			String sql = "insert into tblPropertyRoomType(seqPropertyRoomType, seqPropertyRoomTypeDetail, spacing)"
					+ " values(seqPropertyRoomType.nextVal, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, roomType);
			pstat.setString(2, spacing);
			
			return pstat.executeUpdate(); //1 or 0
			
		} catch (Exception e) {
			
		}
		
		return 0;
	
		
	}

	/**
	 * 계약 형태 넣기
	 * @param contractType
	 * @param deposit
	 * @param monthlyRent
	 * @param dealing
	 * @param contractPeriod
	 * @return 결과값
	 *
	 */
	public int insertContractType(String contractType, String deposit, String monthlyRent, String dealing, String contractPeriod) {
		
		try {
			
			String sql = "insert into tblPropertyContractType(seqPropertyContractType, "
					+ "        seqPropertyContractTypeDetail, "
					+ "        deposit, monthlyRent, dealing, "
					+ "        contractPeriod) values (seqPropertyContractType.nextVal, ?, ?, ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, contractType);
			pstat.setString(2, deposit);
			pstat.setString(3, monthlyRent);
			pstat.setString(4, dealing);
			pstat.setString(5, contractPeriod);
			
			return pstat.executeUpdate(); //1 or 0
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		return 0;
		
	}
	
	
	/**
	 * 관리비 배열 넣기
	 * @param 관리비 옵션 배열
	 * @return 결과값
	 */
	public int insertServiceCharge(String[] op) {
		
		try {
			
			String sql = "insert into tblMaintenanceOption values (seqMaintenanceOption.nextVal, ?, ?, ?, ?, ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, op[0]);
			pstat.setString(2, op[1]);
			pstat.setString(3, op[2]);
			pstat.setString(4, op[3]);
			pstat.setString(5, op[4]);
			pstat.setString(6, op[5]);
			pstat.setString(7, op[6]);
			
			return pstat.executeUpdate(); //1 or 0
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		return 0;
		
	}
	
	
	/**
	 * 건물옵션 넣기
	 * @param 건물옵션 배열
	 * @return 결과값
	 */
	
	public int buildingOption(String[] op) {
		
		try {
			
			String sql = "insert into tblPropertyBuildingOption values (seqPropertyBuildingOption.nextVal, ?, ?, ?, ?)";					
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, op[0]);
			pstat.setString(2, op[1]);
			pstat.setString(3, op[2]);
			pstat.setString(4, op[3]);
			
			return pstat.executeUpdate(); //1 or 0
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		return 0;
		
	}
	
	/**
	 * 방 옵션 넣기
	 * @param 방옵션 배열
	 * @return 결과값
	 */
	
	public int roomOption(String[] op) {
		
		try {
			
			String sql = "insert into tblPropertyRoomOption values (seqPropertyRoomOption.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";				
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, op[0]);
			pstat.setString(2, op[1]);
			pstat.setString(3, op[2]);
			pstat.setString(4, op[3]);
			pstat.setString(5, op[4]);
			pstat.setString(6, op[5]);
			pstat.setString(7, op[6]);
			pstat.setString(8, op[7]);
			pstat.setString(9, op[8]);
			pstat.setString(10, op[9]);
			pstat.setString(11, op[10]);
			pstat.setString(11, op[11]);
			
			return pstat.executeUpdate(); //1 or 0
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		return 0;
		
	}
	
	
	/**
	 * 
	 * @param 기본주소 + 상세주소
	 * @return 결과값
	 */
	public int location(String[] location) {
		
		try {
			
			String sql = "insert into tblLocation values(seqLocation.nextVal, '?')";			
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, location[0] + " " + location[1]);
			
			return pstat.executeUpdate(); //1 or 0
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		return 0;
		
	}
	

/**
 * 
 * @param img
 * @return 결과값
 */
	public int image(String img) {
		
		try {
			
			String sql = "insert into tblImage values(seqImage.nextVal, 'path')";	
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, img);
			
			return pstat.executeUpdate(); //1 or 0
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		return 0;
		
	}
	
	
	/**
	 * 
	 * @param seq 중개인 seq
	 * @param occupancyDate 입주가능일
	 * @param floor 층
	 * @param title 제목
	 * @param content 내용
	 * @return 결과값
	 */
	public int write(int seq, String occupancyDate, String[] floor, String title, String content) {
		
		try {
			
			//최종 넣기 프로시저
			String sql = "{ call procUploadProperty(?, ?, ?, ?, ?)";
			
			cstat = conn.prepareCall(sql);

			//중개인번호, 입주가능일, 층, 제목, 상세내용
			cstat.setInt(1, seq);
			cstat.setString(2, occupancyDate);
			cstat.setString(3, floor[0] + "/" + floor[1] + "층");
			cstat.setString(4, title);
			cstat.setString(5, content);
			
			cstat.executeUpdate();
			
			//out 결과값
			int result = cstat.getInt(3);
			
			return result;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
		
	}

}
