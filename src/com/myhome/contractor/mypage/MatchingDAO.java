package com.myhome.contractor.mypage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.myhome.DBUtil;

/**
 * 
 * @author 박지현
 * 임대인의 매물을 중개인과 매칭하는 DAO
 *
 */
public class MatchingDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;
	
	  
/*
 * @author 박지현
 * 생성자
 *
 */	 
	
	public MatchingDAO() {
		
		try {

			this.conn = DBUtil.open();
			this.stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println("ContractorDAO()");
			e.printStackTrace();
		}
		
	}
	
	
/*
 * @author 박지현
 * 중개인이 받은 매칭리스트
 *
 */
	public ArrayList<MatchingDTO> listContractor(String seq) {
		
		try {
			
			//중개인에게 들어온 매칭리스트 쿼리
			String sql = "select * from vmatchingTocontractor where seqContractor = ?";
			
			//중개인번호 넘겨주기
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			//ResultSet -> ArrayList<DTO>
			ArrayList<MatchingDTO> list = new ArrayList<MatchingDTO>();

			while (rs.next()) {
				
				MatchingDTO dto = new MatchingDTO();
				
				//모든 매물번호
				dto.setSeqProperty(rs.getInt("seqProperty_lp"));
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqContractor(rs.getInt("seqContractor"));
				dto.setSeqLessorProperty(rs.getInt("seqLessorProperty"));
				dto.setTitle(rs.getString("title"));
				dto.setNickname(rs.getString("nickname"));
				dto.setMatching(rs.getInt("matching"));
				
				
			
				list.add(dto);				
			}

			return list; 
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	

		}
		
	
	

/*
 * @author 박지현
 * 중개인이 보낸 매칭리스트
 * 
 */
	public ArrayList<MatchingDTO> listLessor(String seq) {
		
		try {
			
			//중개인이 보낸 매칭리스트 쿼리
			String sql = "select * from  vmatchingToLessor where seqContractor = ?";
			
			//중개인번호 넘겨주기
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			//ResultSet -> ArrayList<DTO>
			ArrayList<MatchingDTO> list = new ArrayList<MatchingDTO>();
	
			while (rs.next()) {
				
				MatchingDTO dto = new MatchingDTO();
				
				//모든 매물번호
				dto.setSeqProperty(rs.getInt("seqProperty"));
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqContractor(rs.getInt("seqContractor"));
				dto.setSeqLessorProperty(rs.getInt("seqLessorProperty"));
				dto.setTitle(rs.getString("title"));
				dto.setNickname(rs.getString("nickname"));
				dto.setMatching(rs.getInt("matching"));
				
				
			
				list.add(dto);				
			}
	
			return list; 
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	
	
	}
	
	
/*
 * @author 박지현
 * 임대인과 매칭된 모든 매물리스트
 * @param 검색어, 중개인 seq
 * 
*/
	public ArrayList<PropertyDTO> matchingDone(HashMap<String, String> map, int seq) {
			
		try {

			String where = "";
				
			if (map.get("search") != null) {
					
				where = String.format("nickname like '%%%s%%' or seqLessorProperty like '%%%s%%'", map.get("search"), map.get("search"));
			}
				
			String sql = String.format("select * from vMatchingDone where nickname is not null and seqContractor = ?");
				
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seq);
			
			rs = pstat.executeQuery();

			// ResultSet -> ArrayList<DTO>
			ArrayList<PropertyDTO> list = new ArrayList<PropertyDTO>();
				
			while (rs.next()) {
				// 레코드 1줄 -> DTO 1개
				PropertyDTO dto = new PropertyDTO();

				// 매물 seq
				dto.setSeqLessorProperty(rs.getInt("seqLessorProperty"));
				System.out.println(dto.getSeqLessorProperty());	
					
				// 1. 방옵션
				dto.setRoomType(rs.getString("roomType"));
				dto.setSpacing(rs.getString("spacing"));

				System.out.println(dto.getRoomType());
				System.out.println(dto.getSpacing());

				// 2. 계약형태
				dto.setContractTypeDetail(rs.getString("contractType"));
				System.out.println(dto.getContractTypeDetail());

				////////////////////////////////
				// 보증금
				String deposit = String.format("%,d" + "원", rs.getInt("deposit"));
				dto.setDeposit(deposit);
				//System.out.println(dto.getDeposit());

				// 월세
				String monthlyRent = String.format("%,d" + "원", rs.getInt("monthlyPay"));
				dto.setMonthlyRent(monthlyRent);

				// 매매

				String temp;
				String dealing = "";

				temp = rs.getString("dealing");

				
				if (temp == null) {
					dealing = "";
					dto.setDealing(dealing);
					System.out.println("DELING" + dto.getDealing());
				}

				else {
					dealing = String.format("%,d" + "원", Integer.parseInt(temp));
					dto.setDealing(dealing);
					System.out.println("DELING" +  dto.getDealing());
				}

				// 기간
				dto.setContractPeriod(rs.getString("contractPeriod") + "개월");

				System.out.println(dto.getContractPeriod());

				// 3. 관리비
				dto.setInternet(rs.getInt("internet"));
				dto.setCable(rs.getInt("cabletv"));

				dto.setCleaning(rs.getInt("cleaning"));
				dto.setWater(rs.getInt("water"));
				dto.setGas(rs.getInt("gas"));
				dto.setElectric(rs.getInt("electric"));

				String serviceCharge = String.format("%,d" + "원", (rs.getInt("serviceCharge")));
				dto.setServiceCharge(serviceCharge);

				System.out.println(dto.getInternet());

				// 4. 건물옵션
				dto.setParking(rs.getInt("parking"));
				dto.setElevator(rs.getInt("elevator"));
				dto.setPet(rs.getInt("pet"));
				dto.setWindow(rs.getInt("window"));
				dto.setFloor(rs.getString("floor"));
		
				// 5. 방옵션 12개
				dto.setAirconditional(rs.getInt("airconditional"));
				dto.setWasher(rs.getInt("washer"));
				dto.setBed(rs.getInt("bed"));
				dto.setDesk(rs.getInt("desk"));
				dto.setCloset(rs.getInt("closet"));
				dto.setTv(rs.getInt("tv"));
				dto.setShoebox(rs.getInt("shoebox"));
				dto.setRefrigerator(rs.getInt("refrigerator"));
				dto.setStove(rs.getInt("stove"));
				dto.setInduction(rs.getInt("induction"));
				dto.setMicrowave(rs.getInt("microwave"));
				dto.setBidet(rs.getInt("bidet"));

				// 6. 지역
				dto.setLocation(rs.getString("location"));
				
				System.out.println(dto.getLocation());

				// 7. 이미지
				dto.setPath(rs.getString("imagePath"));
				
				dto.setOccupancyDate(rs.getString("occupancyDate"));
				
				System.out.println(dto.getOccupancyDate());
				
				dto.setTitle(rs.getString("title"));
				System.out.println(dto.getTitle());

				dto.setContent(rs.getString("content"));
				System.out.println(dto.getContent());
					
				// 9. 중개인 정보
				dto.setCompanyName(rs.getString("companyName"));
				dto.setTel(rs.getString("telc"));
				dto.setName(rs.getString("nameC"));
				
				System.out.println(dto.getCompanyName());
				System.out.println(dto.getTel());
				System.out.println(dto.getName());
				
				//임대인 정보
				dto.setNickname(rs.getString("nickname"));
				System.out.println(dto.getNickname());
				
				list.add(dto);
			}

				return list;

			} catch (Exception e) {
				System.out.println("list: " + e);
			}

			return null;
		}


	//임대인과 매칭된 매물 총 카운트
	public int getTotalCountMatching(HashMap<String, String> map, int seq) {
		
		try {
			
			String where = "";
			
			
			 if (map.get("search") != null) { 
				 
				 where = String.format("where nickname is not null and seqContractor = %d and nickname like '%%%s%%' or seqLessorProperty  like '%%%s%%'", seq, map.get("search"), map.get("search")); 
			
			 } else { 
				
				 where = String.format("where nickname is not null and seqContractor = %d", seq); 
			 }
			 
			
			String sql = String.format("select count(*) as cnt from vMatchingDone %s", where);
			
			System.out.println(sql);
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				return rs.getInt("cnt");
				
			}
			
		} catch (Exception e) {
			System.out.println("MatchingDAO.getTotalCountMatching()");
			e.printStackTrace();
		}
		
		return 0;
	}




}	
	
	
	
	

	

