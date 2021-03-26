package com.myhome.user;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.myhome.DBUtil;

/**
 * 방올리기의 DB작업을 담당하는 클래스입니다.
 * @author 이준오
 *
 */
public class UploadPropertyDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	private CallableStatement cstat;

	public UploadPropertyDAO() {
		// DB 연결
		conn = DBUtil.open();
	}

	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//방올리기 -> 주소 등록
	/**
	 * 주소를 등록합니다.
	 * @param address3 매물주소
	 * @return DB작업결과
	 */
	public int insertLocation(String address3) {
		int result = 0;
		
		try {
			
			String sql = "insert into tblLocation values(seqLocation.nextVal, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1,address3);
			
			result = pstat.executeUpdate();
			
			
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	//지역 seq 받아오기
	/**
	 * 회원이 방금 insert한 지역정보의 seq를 가져옵니다.
	 * @return 지역정보번호
	 */
	public int getSeqLocation() {
		int result = 0;
		
		try {
			String sql = "select seqLocation from (select a.*, rownum as rnum from tblLocation a order by seqLocation desc) where rnum = 1";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				result = rs.getInt("seqLocation");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	//월세 가격정보 등 등록
	/**
	 * 가격정보(월세)를 등록합니다.
	 * @param dto 가격정보 객체
	 * @return DB작업 처리결과
	 */
	public int insertMonthlyRentData(UploadPropertyDTO dto) {
		int result = 0;
		
		try {
			String sql = "insert into tblPropertyContractType values(seqPropertyContractType.nextVal, ?, ?, ?, 0, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, Integer.parseInt(dto.getTradetype()));
			pstat.setInt(2, Integer.parseInt(dto.getDeposit()));
			pstat.setInt(3, Integer.parseInt(dto.getMonthlyRent()));
			pstat.setInt(4, Integer.parseInt(dto.getContractPeriod()));
			
			
			result = pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	//전세 가격정보 등 등록
	/**
	 * 가격정보(전세)를 등록합니다.
	 * @param dto 가격정보 객체
	 * @return DB작업 처리결과
	 */
	public int insertYearlyRentData(UploadPropertyDTO dto) {
		int result = 0;
		
		try {
			String sql = "insert into tblPropertyContractType values(seqPropertyContractType.nextVal, ?, ?, 0, 0, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, Integer.parseInt(dto.getTradetype()));
			pstat.setInt(2, Integer.parseInt(dto.getDeposit()));
			pstat.setInt(3, Integer.parseInt(dto.getContractPeriod()));
			
			result = pstat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	//매매 관련 정보 등록
	/**
	 * 가격정보(매매)를 등록합니다.
	 * @param dto 가격정보 객체
	 * @return DB작업 처리결과
	 */
	public int insertDealingData(UploadPropertyDTO dto) {
		int result = 0;
		
		try {
			String sql = "insert into tblPropertyContractType values(seqPropertyContractType.nextVal, ?, 0, 0, ?, null)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, Integer.parseInt(dto.getTradetype()));
			pstat.setInt(2, Integer.parseInt(dto.getDealing()));
			
			result = pstat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	//마지막 seq를 받는다. 방금등록한것의 seq!
	/**
	 * 회원이 등록한 가격정보의 seq를 가져옵니다.
	 * @return 가격정보번호
	 */
	public int getSeqPropertyContractType() {
		int result = 0;
		
		try {
			
			String sql = "select seqPropertyContractType from (select a.*, rownum as rnum from (select * from tblPropertyContractType b order by seqPropertyContractType desc) a) where rnum = 1";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				result = rs.getInt("seqPropertyContractType");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	//관리비 항목에따른 추가
	/**
	 * 매물의 관리비 정보를 등록합니다. 
	 * @param dto 관리비정보 객체
	 * @return DB작업 처리결과
	 */
	public int insertMaintenance(UploadPropertyDTO dto) {
		
		int result = 0;
		
		try {
			String sql = "insert into tblMaintenanceOption values(seqMaintenanceOption.nextVal, ?,?,?,?,?,?,?)";
		
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, Integer.parseInt(dto.getInternet()));
			pstat.setInt(2, Integer.parseInt(dto.getTvfee()));
			pstat.setInt(3, Integer.parseInt(dto.getCleaning()));
			pstat.setInt(4, Integer.parseInt(dto.getWater()));
			pstat.setInt(5, Integer.parseInt(dto.getGas()));
			pstat.setInt(6, Integer.parseInt(dto.getElectric()));
			pstat.setInt(7, Integer.parseInt(dto.getServicecharge()));
			
			result = pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	
	}
	
	//관리비옵션 seq 요청
	/**
	 * 회원이 등록한 관리비정보의 seq를 가져옵니다.
	 * @return 관리비정보번호
	 */
	public int getSeqMaintenanceOption() {
		
		int result = 0;
		
		try {
			String sql = "select seqMaintenanceOption from (select a.*, rownum as rnum from (select * from tblMaintenanceOption order by seqMaintenanceOption desc) a) where rnum = 1";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				result = rs.getInt("seqMaintenanceOption");
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;		
		
	}

	//매물옵션(건물)에 따른 row 추가하기
	/**
	 * 회원이 선택한 건물옵션의 정보를 등록합니다.
	 * @param dto2 건물옵션 객체
	 * @return DB작업 처리결과
	 */
	public int insertBuildingOption(UploadPropertyDTO dto2) {
		
		int result = 0;
		
		try {
			
			String sql = "insert into tblPropertyBuildingOption values(seqPropertyBuildingOption.nextVal, ?, ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, Integer.parseInt(dto2.getParking()));
			pstat.setInt(2, Integer.parseInt(dto2.getElevator()));
			pstat.setInt(3, Integer.parseInt(dto2.getPet()));
			pstat.setInt(4, Integer.parseInt(dto2.getWindow()));
			
			result = pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	//마지막에 추가된 매물옵션 row의 seqPropertyBuildingOption 가져오기
	/**
	 * 회원이 등록한 건물옵션의 번호를 가져옵니다.
	 * @return 건물옵션 번호
	 */
	public int getSeqPropertyBuildingOption() {
		
		int result = 0;
		
		try {
			
			String sql = "select seqPropertyBuildingOption from (select a.*, rownum as rnum from (select * from tblPropertyBuildingOption order by seqPropertyBuildingOption desc) a) where rnum = 1";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				result = rs.getInt("seqPropertyBuildingOption");
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	//방의형태 tblPropertyRoomType에 row 추가!
	/**
	 * 회원이 선택한 방의형태의 정보를 등록합니다.
	 * @param dto3 방의형태 객체
	 * @return DB작업 처리결과
	 */
	public int insertPropertyRoomType(UploadPropertyDTO dto3) {
		int result=0;
		
		try {
			
			String sql = "insert into tblPropertyRoomType values(seqPropertyRoomType.nextVal, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, Integer.parseInt(dto3.getRoomtype()));
			pstat.setInt(2, Integer.parseInt(dto3.getSuparea()));
			
			result = pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//방금만든 방의형태 row중 seq 가져오기seqPropertyRoomType!
	/**
	 * 회원이 등록한 방의형태 번호를 가져옵니다.
	 * @return 방의형태 번호
	 */
	public int getSeqPropertyRoomType() {
		int result = 0;
		
		try {
			
			String sql = "select seqPropertyRoomType from (select a.*, rownum as rnum from(select * from tblPropertyRoomType order by seqPropertyRoomType desc) a) where rnum = 1";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				result = rs.getInt("seqPropertyRoomType");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	//매물옵션(방)에 row 추가하기!!
	/**
	 * 회원이 선택한 방옵션 정보를 등록합니다. 
	 * @param dto4 방옵션 객체
	 * @return DB작업 처리결과
	 */
	public int insertPropertyRoomOption(UploadPropertyDTO dto4) {
		int result = 0;
		
		try {
			
			String sql = "insert into tblPropertyRoomOption values(seqPropertyRoomOption.nextVal, ?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, Integer.parseInt(dto4.getAircon()));
			pstat.setInt(2, Integer.parseInt(dto4.getWasher()));
			pstat.setInt(3, Integer.parseInt(dto4.getBed()));
			pstat.setInt(4, Integer.parseInt(dto4.getDesk()));
			pstat.setInt(5, Integer.parseInt(dto4.getCloset()));
			pstat.setInt(6, Integer.parseInt(dto4.getTv()));
			pstat.setInt(7, Integer.parseInt(dto4.getShoebox()));
			pstat.setInt(8, Integer.parseInt(dto4.getRefrigerator()));
			pstat.setInt(9, Integer.parseInt(dto4.getStove()));
			pstat.setInt(10, Integer.parseInt(dto4.getInduction()));
			pstat.setInt(11, Integer.parseInt(dto4.getMicrowave()));
			pstat.setInt(12, Integer.parseInt(dto4.getBidet()));
			
			result = pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;

	}

	//방금 만든 매물옵션(방) row 의 seq 가져오기
	/**
	 * 회원이 등록한 방옵션의 seq를 가져옵니다.
	 * @return 방옵션 번호
	 */
	public int getSeqPropertyRoomOption() {
		int result = 0;
		
		try {
			
			String sql = "select seqPropertyRoomOption from ( select a.*, rownum as rnum from (select * from tblPropertyRoomOption order by seqPropertyRoomOption desc)a) where rnum = 1";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				result = rs.getInt("seqPropertyRoomOption");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	//드디어 매물 넣기..
	/**
	 * 회원의 매물을 등록합니다. 
	 * @param dto5 매물 객체
	 * @return DB작업 처리결과
	 */
	public int insertProperty(PropertyDTO dto5) {
		int result = 0;
		
		try {
			
			String sql ="insert into tblProperty values(seqProperty.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, dto5.getSeqPropertyContractType());
			pstat.setInt(2, dto5.getSeqPropertyRoomOption());
			pstat.setInt(3, dto5.getSeqPropertyBuildingOption());
			pstat.setInt(4, dto5.getSeqLocation());
			pstat.setInt(5, dto5.getSeqMaintenanceOption());
			pstat.setInt(6, dto5.getSeqPropertyRoomType());
			pstat.setInt(7, dto5.getSeqImage());
			pstat.setString(8, dto5.getOccupancyDate());
			pstat.setString(9, dto5.getFloor());
			pstat.setString(10, dto5.getTitle());
			pstat.setString(11, dto5.getContent());
			
			result = pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	//방금 넣은 매물 seq 가져오기
	/**
	 * 회원이 등록한 매물의 seq를 가져옵니다.
	 * @return 매물 번호
	 */
	public int getSeqProperty() {
		
		int result = 0;
		
		try {
			
			String sql = "select seqProperty from (select a.*, rownum as rnum from (select * from tblProperty order by seqProperty desc)a) where rnum = 1";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				result = rs.getInt("seqProperty");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	//임대인 매물에 row 넣기! tblLessorProperty
	/**
	 * 임대인 매물을 등록합니다.
	 * @param dto6 임대인매물 객체
	 * @return DB작업 처리결과
	 */
	public int insertLessorProperty(LessorPropertyDTO dto6) {
		
		int result = 0;
		
		try {
			
			String sql = "insert into tblLessorProperty values(seqLessorProperty.nextVal, ?, ?, 0)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, dto6.getSeqProperty());
			pstat.setInt(2, dto6.getSeqUser());
			
			
			result = pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;		
		
	}

	//방금 만든 tblLessorProperty의 마지막 row의 seq 가져오기
	/**
	 * 회원이 등록한 임대인매물의 seq를 가져옵니다.
	 * @return 임대인매물 번호
	 */
	public int getSeqLessorProperty() {

		int result = 0;
		
		try {
			
			String sql = "select seqLessorProperty from (select a.*, rownum as rnum from (select * from tblLessorProperty order by seqLessorProperty desc)a) where rnum = 1";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				result = rs.getInt("seqLessorProperty");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	//매칭요청 tblMatching 에 row 넣기.
	/**
	 * 회원이 선택한 중개사에게 매칭요청을 등록합니다.
	 * @param dto7 매칭 객체
	 * @return DB작업 처리결과
	 */
	public int insertMatching(MatchingDTO dto7) {
		int result = 0;
		
		try {
			
			String sql = "insert into tblMatching values(seqMatching.nextVal, ?, ?, '임대인', null)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, dto7.getSeqLessorProperty());
			pstat.setInt(2, dto7.getSeqContractor());
			
			result = pstat.executeUpdate();
			
			//stat = conn.createStatement();
			
			//result = stat.executeUpdate(sql);			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}


}
