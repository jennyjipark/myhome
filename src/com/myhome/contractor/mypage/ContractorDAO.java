package com.myhome.contractor.mypage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.myhome.DBUtil;

/**
 * @author 박지현
 * 중개인 회원정보 목록, 수정, 탈퇴 DAO
 */
public class ContractorDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;


	public ContractorDAO() {

		try {

			this.conn = DBUtil.open();
			this.stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println("ContractorDAO()");
			e.printStackTrace();
		}

	}

	//회원목록 달라고 위임
	public ArrayList<ContractorDTO> list(String seq) {

		try {

			String sql = "select * from vwContractor where seq = ?";

			//System.out.println(sql);

			//회원번호 넘겨주기
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);


			rs = pstat.executeQuery();

			//ResultSet -> ArrayList<DTO>
			ArrayList<ContractorDTO> list = new ArrayList<ContractorDTO>();

			while (rs.next()) {
				//레코드 1줄 -> DTO 1개
				ContractorDTO dto = new ContractorDTO();

				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setAddress(rs.getString("address"));
				
				//사업자번호
				System.out.println(rs.getString("companynumber"));
				String[] businessNum = rs.getString("companynumber").split("-");
				dto.setBusinessNum(businessNum[0] + "-" + businessNum[1] + "-" + businessNum[2]);
				
				
				//전화번호
				System.out.println(rs.getString("tel"));
				String[] tel = rs.getString("tel").split("-");
				dto.setTel1(tel[0]);
				dto.setTel2(tel[1]);
				dto.setTel3(tel[2]);
				
				dto.setEmail(rs.getString("email"));
				dto.setPassword(rs.getString("password"));
				dto.setCompanyName(rs.getString("companyName"));
				dto.setName(rs.getString("name"));
				
				

				list.add(dto);				
			}

			return list; 

		} catch (Exception e) {
			System.out.println("list: " + e);
		}

		return null;
	}

	
	//회원정보 수정
	public int edit(ContractorDTO dto) {

		try {

			String sql = "update tblAllUser set password = ?, email = ?, phoneNumber = ?, address = ? where seqAllUser = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getPassword());
			pstat.setString(2, dto.getEmail());
			pstat.setString(3, dto.getTel1() + "-" + dto.getTel2() + "-" + dto.getTel3());
			pstat.setString(4, dto.getAddress());
			pstat.setString(5, dto.getSeq()); //중개인 seq


			return pstat.executeUpdate();
			

		} catch (Exception e) {
			System.out.println("EditContractorOk.edit()" + e);
		}

		return 0;

	}

}
