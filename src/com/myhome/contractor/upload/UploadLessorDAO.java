package com.myhome.contractor.upload;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.myhome.DBUtil;

/**
 * @author 박지현
 *중개인과 매칭된 임대인의 매물 올리기
 */
public class UploadLessorDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;


	public UploadLessorDAO() {

		try {

			this.conn = DBUtil.open();
			this.stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println("MainDAO()");
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @author 박지현
	 *중개인 매물 테이블에 임대인 매물 넣는 메서드
	 *
	 */
	public int uploadLessor(int seqLessorProperty, int seqContractor) {
		
		try {
			
			String sql = "insert into tblContractorProperty values (seqContractorProperty.nextVal, ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqContractor);
			pstat.setInt(2, seqLessorProperty);
			pstat.setInt(3, 0);
			
			return pstat.executeUpdate(); //1 or 0
			
		} catch (Exception e) {
			
			System.out.println(e + "uploadLessor()");
			return 0;
		}
	}
	
	

}
