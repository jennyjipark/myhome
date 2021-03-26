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
 * @author 박지현
 * 중개인 전자계약 DAO
 * 
 * */
public class ContractDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;


	//생성자
	public ContractDAO() {

		try {

			this.conn = DBUtil.open();
			this.stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println("ContractorDAO()");
			e.printStackTrace();
		}

	}
	
	//내 전자계약 리스트
	public ArrayList<ContractDTO> list(HashMap<String, String> map, int seqC) {
		
		try {
			
			String where = "";
			
			if (map.get("search") != null) {
				
				where = String.format("where seqUserC = %d and nameL like '%%%s%%' or seqC  like '%%%s%%", seqC, map.get("search"), map.get("search"));
			} else {
				
				where = String.format("where seqUserC = %d", seqC);
				
			}
			
			String sql = String.format("select * from (select a.*, rownum as rnum from (select * from  vwContract %s order by seqC desc) a) where rnum between %s and %s", where, map.get("begin"), map.get("end"));
			
			//쿼리넘기기
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			//ResultSet -> ArrayList<DTO>
			ArrayList<ContractDTO> list = new ArrayList<ContractDTO>();

			while (rs.next()) {
				
				ContractDTO dto = new ContractDTO();
				
				//전자계약 번호
				dto.setSeqContract(rs.getInt("seqC"));
				
				//회원들 seq
				dto.setSeqUserC(rs.getInt("seqUserC"));
				dto.setSeqUserL(rs.getInt("seqUserL"));
				dto.setSeqUserT(rs.getInt("seqUserT"));
				
				//이름
				dto.setNameT(rs.getString("nameT"));
				dto.setNameC(rs.getString("nameC"));
				dto.setNameL(rs.getString("nameL"));
				
				//계약 상태
				dto.setState(rs.getString("state"));
				
			
				list.add(dto);				
			}

			return list; 
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	

	}

	//전자계약서 보기
	public ArrayList<ContractDTO> view(int seqContract) {
		
		try {
			
			//전자계약 뷰
			String sql = "select * from vContract where seqC = ?";
			
			//전자계약 번호 넘겨주기
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqContract);
			
			rs = pstat.executeQuery();
			
			//ResultSet -> ArrayList<DTO>
			ArrayList<ContractDTO> list = new ArrayList<ContractDTO>();

			while (rs.next()) {
				
				ContractDTO dto = new ContractDTO();
				
				//전자계약 번호
				dto.setSeqContract(rs.getInt("seqC"));
				
				//회원들 seq
				dto.setSeqUserC(rs.getInt("seqUserC"));
				dto.setSeqUserL(rs.getInt("seqUserL"));
				dto.setSeqUserT(rs.getInt("seqUserT"));
				
				//매물번호
				dto.setSeqCp(rs.getString("seqCp")); //중개인매물번호(매칭자동)
				dto.setSeqLp(rs.getString("seqLp")); //임대인 매물번호
				dto.setSeqp(rs.getString("seqP")); //모든 매물번호
				
				//이름
				dto.setCompanyName(rs.getString("companyName"));
				dto.setNameT(rs.getString("nameT"));
				dto.setNameC(rs.getString("nameC"));
				dto.setNameL(rs.getString("nameL"));
				
				//전화번호
				dto.setTelC(rs.getString("telC"));
				dto.setTelL(rs.getString("telL"));
				dto.setTelT(rs.getString("telT"));
				
				//사업자번호 & 주민번호
				dto.setBusinessNum(rs.getString("companyNumberC"));
				dto.setSsnL(rs.getString("iNumberL"));
				dto.setSsnT(rs.getString("idNumberT"));
				
				//* 는 직접 입력받는 란
				
				//* 주소
				dto.setAddressC(dto.getAddressC());
				dto.setAddressL(dto.getAddressL());
				dto.setAddressT(dto.getAddressT());
				
				//* 계약기간(계약한 날 + period)
 				dto.setContractPeriod(dto.getPeriod());
 				
 				//* 퍼센트
 				dto.setPercent(dto.getPercent());
				
 				
				//* 암호
				dto.setSignC(rs.getString("tSign"));
				dto.setSignL(rs.getString("lSign"));
				dto.setSignT(rs.getString("cSign"));
				
				//계약일
				dto.setContractDate(rs.getString("cdate"));
				
				//계약 상태
				dto.setState(rs.getString("state"));
				
				//매물주소
				dto.setLocation(rs.getString("location"));
				
				//보증금(천단위 콤마)
				String deposit = String.format("%,d" + "원", rs.getInt("deposit"));
				dto.setDeposit(deposit);
				
				//매매가격
				String dealing = String.format("%,d" + "원", rs.getInt("dealing"));
				dto.setDealing(dealing);
				
				//월세
				String monthly = String.format("%,d" + "원", rs.getInt("monthlyPay"));
				dto.setMonthlyRent(monthly);
				
			
				list.add(dto);				
			}

			return list; 
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	

	}


	//1. 아이디로 임차인 정보 가져오기
	public ArrayList<ContractDTO> getTenant(String id) {
		
		try {
			
			//임차인 정보
			String sql = "select * from vUser where id = ?";
			
			//아이디 넘겨주기
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			int seqTenant = 0; 
			
			ArrayList<ContractDTO> list = new ArrayList<ContractDTO>();
					
			while (rs.next()) {
				
				ContractDTO dto = new ContractDTO();
				
				seqTenant = rs.getInt("seqAllUser");
				dto.setSeqUserT(seqTenant);
				
				dto.setNameT(rs.getString("name"));
				dto.setTelT(rs.getString("phonenumber"));
				dto.setSsnT(rs.getString("idNumber"));
				dto.setAddressT(rs.getString("address"));
				
				System.out.println(dto.getTelT());
				list.add(dto);
			
			}
			
			return list;
					
		} catch (Exception e) {
			System.out.println(e + "getTenant()");
		}
		
		return null;
		
	}
	
	//2. 임대인 정보
		public ArrayList<ContractDTO> getLessor(int seqLessor) {
			
			try {
				
				//임대인 정보
				String sql = "select * from vUser where seqAlluser = ?";
				
				//번호 넘겨주기
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, seqLessor);
				
				rs = pstat.executeQuery();
				
				int seqTenant = 0; 
				
				ArrayList<ContractDTO> list = new ArrayList<ContractDTO>();
						
				while (rs.next()) {
					
					ContractDTO dto = new ContractDTO();
					
					seqTenant = rs.getInt("seqAllUser");
					dto.setSeqUserT(seqTenant);
					
					dto.setNameT(rs.getString("name"));
					dto.setTelT(rs.getString("phonenumber"));
					dto.setSsnT(rs.getString("idNumber"));
					dto.setAddressL(rs.getString("address"));
					
					list.add(dto);
				
				}
				
				return list;
						
			} catch (Exception e) {
				System.out.println(e + "getLessor()");
			}
			
			return null;
			
		}
	
	
	//전자계약서에 1차 넣기
	public int insertContract(int seqTenant, int seqContractorProperty) {
		
		try {
			
			//전자계약
			String sql = " insert into tblContract values (seqContract.nextVal, "
					+ "?, ?, '진행중', null, null, null, null, null)";
			
			//임차인번호, 전자계약 번호 넘겨주기
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqTenant);
			pstat.setInt(2, seqContractorProperty);
			
			
			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e + "insertContract()");
		}
		
		return 0;
	}
	
	
	//max seq
	public int maxSeq() {
		
		try {
			
			//전자계약 max seq
			String sql = "select max(seqContract) as maxSeq from tblContract";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				
				return rs.getInt("maxSeq");
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e + "insertContract()");
		}
		
		return 0;
	}
	
	
	//전자계약 작성1 - 매물, 중개인 정보
	public ArrayList<PropertyDTO> contractorProperty(int seqContrator) {

			try {

				String sql = "select * from vuploadProperty vup inner join tblContractor C on C.seqContractor = vup.seqContractor"
						+ " where c.seqContractor = ?";

				// 번호 넘겨주기
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, seqContrator);

				rs = pstat.executeQuery();

				// ResultSet -> ArrayList<DTO>
				ArrayList<PropertyDTO> list = new ArrayList<PropertyDTO>();

				while (rs.next()) {
					// 레코드 1줄 -> DTO 1개
					PropertyDTO dto = new PropertyDTO();

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
					dto.setBusinessNum(rs.getString("companyNumber"));

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
			}

			return null;
		}


	//전자계약 총 개수
	public int getTotalContract(HashMap<String, String> map, int seq) {
		
		try {
				
				String where = "";
				
				
				 if (map.get("search") != null) { 
					 
					 where = String.format("where seqUserC = %d and nameL like '%%%s%%' or seqC  like '%%%s%%'", seq, map.get("search"), map.get("search")); 
				
				 } else { 
					
					 where = String.format("where seqUserC = %d", seq); 
				 }
				
				String sql = String.format("select count(*) as cnt from vContract %s", where);
				
				System.out.println(sql);
				
				pstat = conn.prepareStatement(sql);
				rs = pstat.executeQuery();
				
				if (rs.next()) {
					
					return rs.getInt("cnt");
					
				}
				
			} catch (Exception e) {
				System.out.println("MatchingDAO.getTotalContract()");
				e.printStackTrace();
			}
			
			return 0;
		}

	}
	
	


