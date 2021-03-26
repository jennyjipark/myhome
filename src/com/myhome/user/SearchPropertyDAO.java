package com.myhome.user;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.myhome.DBUtil;



public class SearchPropertyDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;
	
	public SearchPropertyDAO() {
		
		try {
			
			this.conn = DBUtil.open();
			this.stat = conn.createStatement();
			
		} catch (Exception e) {
			System.out.println("SearchPropertyDAO.SearchPropertyDAO()");
			e.printStackTrace();
		}
	}
	
	
	public void close() {
		try {
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println("SearchPropertyDAO.close()");
			e.printStackTrace();
		}
	}
	
	
	
	// 2. 매물 상세보기
		public ArrayList<SearchPropertyDTO> propertyDetailUserVer(int seqContratorProperty) {

			try {

				String sql = "select * from vwSearchProperty where seqContractorProperty = ?";

				// 중개인매물 번호 넘겨주기
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, seqContratorProperty);

				rs = pstat.executeQuery();

				// ResultSet -> ArrayList<DTO>
				ArrayList<SearchPropertyDTO> list = new ArrayList<SearchPropertyDTO>();

				while (rs.next()) {
					// 레코드 1줄 -> DTO 1개
					SearchPropertyDTO dto = new SearchPropertyDTO();

					// 모든매물 seq
					dto.setSeqProperty(rs.getInt("seqProperty_lp"));
					dto.setSeqLessorProperty(rs.getInt("seqLessorProperty"));
					dto.setSeqContractorProperty(rs.getInt("seqContractorProperty"));

					// 중개인 seq
					dto.setSeqContractor(rs.getInt("seqContractor"));

					// 1. 방옵션
					dto.setRoomType(rs.getString("roomType"));
					dto.setSpacing(rs.getString("spacing"));

					System.out.println(dto.getRoomType());
					System.out.println(dto.getSpacing());

					// 2. 계약형태
					dto.setContractTypeDetail(rs.getString("contractType"));
					System.out.println(dto.getContractTypeDetail());

					// 보증금
					String deposit = String.format("%,d" + "원", rs.getInt("deposit"));
					dto.setDeposit(deposit);
					System.out.println(dto.getDeposit());

					// 월세
					String monthlyRent = String.format("%,d" + "원", rs.getInt("monthlyPay"));
					dto.setMonthlyRent(monthlyRent);

					// 매매

					String temp;
					String dealing = "";

					temp = rs.getString("dealing");

					System.out.println(temp);
					if (temp == null) {
						dealing = "";
						dto.setDealing(dealing);
					}

					else {
						dealing = String.format("%,d" + "원", Integer.parseInt(temp));
						dto.setDealing(dealing);
					}

					// System.out.println(dto.getDealing());

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

					// System.out.println(dto.getLocation());
					// 7. 이미지
					dto.setPath(rs.getString("imagePath"));

					// System.out.println(dto.getPath());

					// 8. 입주 가능 or 계약완료
					dto.setAvailable(rs.getString("available"));

					// System.out.println(dto.getAvailable());

					// 9. 중개인 정보
					dto.setCompanyName(rs.getString("companyName"));
					dto.setTel(rs.getString("tel"));
					dto.setName(rs.getString("nameC"));

					// 최종넣기
					dto.setSeqContractor(rs.getInt("seqContractor"));

					// System.out.println(dto.getSeqContractor());
					dto.setOccupancyDate(rs.getString("occupancyDate"));
					// System.out.println(dto.getOccupancyDate());

					dto.setTitle(rs.getString("title"));
					// System.out.println(dto.getTitle());

					dto.setContent(rs.getString("content"));
					// System.out.println(dto.getContent());

					list.add(dto);
				}

				return list;

			} catch (Exception e) {

				System.out.println("list: " + e);
				System.out.println("SearchPropertyDAO.propertyDetailUserVer()");
				e.printStackTrace();
			}

			return null;
		}
		
		
		
		
		
		
		//중개인이 올린 매물리스트
		public ArrayList<SearchPropertyDTO> contractorListUserVer(HashMap<String, String> map) {
			
			try {

				String where = "";
				
				if (map.get("search") != null) {
					
//					where = String.format("where location like '%%%s%%' or seqContractorProperty like '%%%s%%'", map.get("search"), map.get("search"));
					where = String.format("where location like '%%%s%%'", map.get("search"));
				} else if (map.get("search2") != null) {
					where = String.format("where location like '%%%s%%'", map.get("search2"));
				}
				
				String sql = String.format("select * from (select a.*, rownum as rnum from (select * from vwSearchProperty %s order by seqContractorProperty desc) a) where rnum between %s and %s", where, map.get("begin"), map.get("end"));
				
				pstat = conn.prepareStatement(sql);

				rs = pstat.executeQuery();

				// ResultSet -> ArrayList<DTO>
				ArrayList<SearchPropertyDTO> list = new ArrayList<SearchPropertyDTO>();

				while (rs.next()) {
					// 레코드 1줄 -> DTO 1개
					SearchPropertyDTO dto = new SearchPropertyDTO();

					// 매물 seq
					dto.setSeqContractorProperty(rs.getInt("seqContractorProperty"));
					
					//계약여부
					dto.setAvailable(rs.getString("available"));
					
					// 1. 방옵션
					dto.setRoomType(rs.getString("roomType"));
					dto.setSpacing(rs.getString("spacing"));

					System.out.println(dto.getRoomType());
					System.out.println(dto.getSpacing());

					// 2. 계약형태
					dto.setContractTypeDetail(rs.getString("contractType"));
					System.out.println(dto.getContractTypeDetail());

					// 보증금
					String deposit = String.format("%,d" + "원", rs.getInt("deposit"));
					dto.setDeposit(deposit);
					System.out.println(dto.getDeposit());

					// 월세
					String monthlyRent = String.format("%,d" + "원", rs.getInt("monthlyPay"));
					dto.setMonthlyRent(monthlyRent);

					// 매매

					String temp;
					String dealing = "";

					temp = rs.getString("dealing");

					System.out.println(temp);
					if (temp == null) {
						dealing = "";
						dto.setDealing(dealing);
					}

					else {
						dealing = String.format("%,d" + "원", Integer.parseInt(temp));
						dto.setDealing(dealing);
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

					// System.out.println(dto.getLocation());
					// 7. 이미지
					dto.setPath(rs.getString("imagePath"));

					// System.out.println(dto.getPath());

					// System.out.println(dto.getSeqContractor());
					dto.setOccupancyDate(rs.getString("occupancyDate"));
					// System.out.println(dto.getOccupancyDate());

					dto.setTitle(rs.getString("title"));
					// System.out.println(dto.getTitle());

					dto.setContent(rs.getString("content"));
					// System.out.println(dto.getContent());
					
					// 9. 중개인 정보
					dto.setCompanyName(rs.getString("companyName"));
					dto.setTel(rs.getString("tel"));
					dto.setName(rs.getString("nameC"));
					
					list.add(dto);
					System.out.println(list.size());
				}

				return list;

			} catch (Exception e) {
				System.out.println("list: " + e);
				System.out.println("SearchPropertyDAO.contractorListUserVer()");
				e.printStackTrace();
			}

			return null;
		}

		
		//중개인이 올린 매물 총 페이지 수
		public int getTotalCountContractor(HashMap<String, String> map) {
			
			try {
				String where = "";
				
				if (map.get("search") != null) {
					where = String.format("where companyName like '%%%s%%' or seqContractorProperty like '%%%s%%'", map.get("search"), map.get("search"));
				}
				
				String sql = String.format("select count(*) as cnt from vwSearchProperty %s", where);
				
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				
				if (rs.next()) {
					return rs.getInt("cnt");
				}
				
			} catch (Exception e) {
				System.out.println("SearchPropertyDAO.getTotalCountContractor()");
				e.printStackTrace();
			}
			
			return 0;
		}
	
	
	
}
