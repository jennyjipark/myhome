package com.myhome.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import com.myhome.DBUtil;

public class MemberDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public MemberDAO() {
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

	/**
	 * tblAllUser select
	 * @param dto
	 * @return 결과유무
	 */
	public int login(MemberDTO dto) {

		try {

			//쿼리
			String sql = "select * from tblAllUser where id = ? and password = ?";

			//준비
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPassword());

			//실행
			rs = pstat.executeQuery();
			
			MemberDTO mdto = new MemberDTO();
			
			int seqAllUser = 0;

			//리턴
			if (rs.next()) {
				seqAllUser = (rs.getInt("seqAllUser"));
				
				return seqAllUser; // 0 이거나  또는 0 이상
			}

		} catch (Exception e) {
			System.out.println("MemberDAO.login()");
		}

		return 0;
	}

	/**
	 * tblAllUser insert
	 * @param dto
	 * @return 결과유무
	 */
	public int add(MemberDTO dto) {

		try {
			String sql = "insert into tblAllUser(seqAllUser, id, name, password, email, nickname, state, phonenumber, address) values " +
					"(seqAllUser.nextVal, ?, ?, ?, ?, ?, 0, ?, ?)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getName());
			pstat.setString(3, dto.getPassword());
			pstat.setString(4, dto.getEmail());
			pstat.setString(5, dto.getNickname());
			pstat.setString(6, dto.getPhonenumber());
			pstat.setString(7, dto.getAddress());


			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("MemberDAO.add()"+e);
		}
		return 0;
	}

	/**
	 * tblLocation select
	 * @return 지역 리스트
	 */
	public HashMap<Integer, String> getLocation() {

		HashMap<Integer, String> location = new HashMap<Integer, String>();

		try {

			String sql = "select * from tblLocation";

			stat = conn.createStatement();

			rs = stat.executeQuery(sql);

			while(rs.next()) {
				location.put(rs.getInt("seqLocation"), rs.getString("location"));
			}
			
			return location;


		} catch (Exception e) {
			System.out.println("MemberDAO.getLocation()"+e);
		}

		return null;
	}

	/**
	 * tblUser insert
	 * @param dto
	 * @param roomtype
	 * @param alarm
	 * @param location 
	 * @param seqAllUser 
	 * @return
	 */
	public int addUser(MemberDTO dto, String roomtype, String alarm, int seqUser, int seqLocation) {
		
		try {
			//쿼리작성
			String sql = "insert into tblUser (seqUser, seqLocation, seqPropertyRoomTypeDetail, idNumber, Alarm, ReportCount)"
						+ "values (?, ?, ?, ?, ?, 0)";
			
			//준비
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			pstat.setInt(2, seqLocation);
			pstat.setInt(3, Integer.parseInt(roomtype));
			pstat.setString(4, dto.getIdNumber());
			pstat.setInt(5, Integer.parseInt(alarm));
			
			//실행 + 결과
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("MemberDAO.addUser()"+e);
		}
		return 0;
	}

	/**
	 * tblAllUser select
	 * @param dto
	 * @return 시퀀스
	 */
	public int getSeq(MemberDTO dto) {
		
		try {
			//쿼리작성 -> seq만뽑아오는 쿼리
			String sql = "select seqAllUser from tblAllUser where id=? and password=?";
			
			//준비
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPassword());
			
			//실행
			rs = pstat.executeQuery();
			
			int seqAllUSer = 0;
			//결과
			while(rs.next()) {
				seqAllUSer = rs.getInt("seqAllUser");
			}
			
			return seqAllUSer;
			
		} catch (Exception e) {
			System.out.println("MemberDAO.getSeq()"+e);
		}
		return 0;
	}

	/**
	 * tblContractor insert
	 * @param seqContractor
	 * @param companynumber
	 * @param companyname
	 * @return
	 */
	public int addContractor(int seqContractor, String companynumber, String companyname) {
		
		try {
			String sql = "insert into tblContractor (seqContractor, companynumber, contractorname, reportcount) " +
						"values (?, ?, ?, 0)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqContractor);
			pstat.setString(2, companynumber);
			pstat.setString(3, companyname);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("MemberDAO.addContractor"+e);
		}
		return 0;
	}

	
	/**
	 * tblAllUser select 
	 * @param seqAllUser
	 * @return
	 */
	public MemberDTO getMember(int seqAllUser) {
		
		try {
			
			String sql = "select * from tblAllUser where seqAllUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqAllUser);
			
			rs = pstat.executeQuery();
			
			MemberDTO dto = new MemberDTO();
			
			while(rs.next()) {
				dto.setSeqAllUser(rs.getInt("seqAllUser"));
				dto.setName(rs.getString("name"));
				dto.setNickname(rs.getString("nickname"));
				dto.setPhonenumber(rs.getString("phonenumber"));
				dto.setAddress(rs.getString("address"));
			}
			
			return dto;
			
			
		} catch (Exception e) {
			System.out.println("MemberDAO.login()");
		}
		
		return null;
	}

	public String searchID(String type, MemberDTO dto) {
		
		try {
			String sql = "";
			
			if(type.equals("email")) {
				sql = "select id from tblAllUser where name = ? and email = ?";
				
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, dto.getName());
				pstat.setString(2, dto.getEmail());
				rs = pstat.executeQuery();
				
				while(rs.next())
					return rs.getString("id");
				
			}
			else if(type.equals("phone")) {
				sql = "select id from tblAllUser where name = ? and phonenumber = ?";
				
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, dto.getName());
				pstat.setString(2, dto.getPhonenumber());
				rs = pstat.executeQuery();
				
				while(rs.next())
					return rs.getString("id");
				
			}
			
			
		} catch (Exception e) {
			System.out.println("MemberDAO.searchID()" + e);
		}
		return null;
	}

	public String searchPW(String type, MemberDTO dto) {
		
		try {
			String sql = "";
			
			if(type.equals("email")) {
				sql = "select password from tblAllUser where id = ? and email = ?";
				
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, dto.getId());
				pstat.setString(2, dto.getEmail());
				rs = pstat.executeQuery();
				
				while(rs.next())
					return rs.getString("password");
				
			}
			else if(type.equals("phone")) {
				sql = "select password from tblAllUser where id = ? and phonenumber = ?";
				
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, dto.getId());
				pstat.setString(2, dto.getPhonenumber());
				rs = pstat.executeQuery();
				
				while(rs.next())
					return rs.getString("password");
				
			}
			
			
		} catch (Exception e) {
			System.out.println("MemberDAO.searchID()" + e);
		}
		return null;
	}


}
