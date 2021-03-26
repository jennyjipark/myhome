package com.myhome.user;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.myhome.DBUtil;
import com.myhome.member.MemberDTO;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;


/**
 * 회원에 관한 DB작업을 담당하는 클래스입니다.
 * @author 이준오
 *
 */
public class UserDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	private CallableStatement cstat;

	public UserDAO() {
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

	// user/mypageinfo.do -> 고객정보 요청
	/**
	 * 회원의 정보를 가져옵니다.
	 * @param seqAllUser 회원번호
	 * @return 회원정보
	 */
	public UserDTO getUserInfo(int seqAllUser) {

		try {

			String sql = "select * from vwUser where seqUser = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setInt(1, seqAllUser);

			rs = pstat.executeQuery();

			// System.out.println(rs.next());
			if (rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setNickname(rs.getString("nickname"));
				dto.setIdNumber(rs.getString("idNumber"));
				dto.setAddress(rs.getString("address"));
				dto.setPhonenumber(rs.getString("phonenumber"));
				dto.setEmail(rs.getString("email"));
				dto.setInterestroomtype(rs.getString("interestroomtype"));
				dto.setInterestlocation(rs.getString("interestlocation"));
				dto.setAlarm(rs.getInt("alarm"));

				return dto;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	/**
	 * 모든 닉네임을 가져옵니다.
	 * @return 닉네임
	 */
	public ArrayList<UserDTO> getAllNickname() {

		try {
			String sql = "select nickname from vwUser";

			stat = conn.createStatement();

			rs = stat.executeQuery(sql);

			ArrayList<UserDTO> dlist = new ArrayList<UserDTO>();

			while (rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setNickname(rs.getString("nickname"));
				dlist.add(dto);
			}

			return dlist;

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	// mypageinfo.do -> 회원정보 수정
	/**
	 * 회원의 정보를 수정하는 DB작업을 수행합니다.
	 * @param dto 수정할 회원정보
	 * @param seq 회원번호
	 * @return DB작업 처리결과
	 * @throws SQLException
	 */
	public int updateUser(UserDTO dto, int seq) throws SQLException {
		int result = 0;

		try {

			String sql = "update tblAlluser set password = ?, email = ?, nickname = ?, phonenumber = ?, address = ? where seqAlluser = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getPassword());
			pstat.setString(2, dto.getEmail());
			pstat.setString(3, dto.getNickname());
			pstat.setString(4, dto.getPhonenumber());
			pstat.setString(5, dto.getAddress());
			pstat.setInt(6, seq);

			int num = pstat.executeUpdate();

			String sql2 = "update tbluser set idNumber = ?, seqlocation = ?, seqPropertyRoomtypeDetail = ?, alarm = ? where sequser = ?";

			pstat = conn.prepareStatement(sql2);

			pstat.setString(1, dto.getIdNumber());
			pstat.setInt(2, dto.getSeqLocation());
			pstat.setInt(3, dto.getSeqPropertyRoomtypeDetail());
			pstat.setInt(4, dto.getAlarm());
			pstat.setInt(5, seq);

			int num2 = pstat.executeUpdate();

			if (num == 1 && num2 == 1) {
				result = 1;
			} else {
				result = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}
		conn.commit();
		return result;
	}

	// location에 따른 seqLocation을 요청
	/**
	 * 지역정보에 따른 seq를 가져옵니다.
	 * @param interestlocation 관심지역
	 * @return 지역번호
	 */
	public int getSeqLocation(String interestlocation) {

		int seq = 0;

		try {

			String sql = "select seqLocation from tblLocation where location = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, interestlocation);

			rs = pstat.executeQuery();

			if (rs.next()) {
				seq = rs.getInt("seqLocation");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return seq;
	}

	// 방 종류에 따른 seq를 요청
	/**
	 * 매물유형에 따른 seq를 가져옵니다.
	 * @param interestroomtype 관심 매물 유형
	 * @return 매물유형번호
	 */
	public int getSeqRoomtype(String interestroomtype) {

		int seq = 0;

		try {

			String sql = "select seqPropertyRoomtypeDetail from tblPropertyRoomtypeDetail where roomtype = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, interestroomtype);
			rs = pstat.executeQuery();

			if (rs.next()) {
				seq = rs.getInt("seqPropertyRoomtypeDetail");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return seq;

	}
	
	//removeuserok.do 에서 회원 삭제 요청
	/**
	 * 회원을 삭제하는 작업을 수행합니다.
	 * @param seq 회원번호
	 * @return DB작업 처리결과
	 * @throws SQLException
	 */
	public int removeUser(int seq) throws SQLException {
		int num = 0;
		
		try {
			//String sql = "{call 프로시저명(파라미터)";
			String sql = "{call procDeleteUser(?)}";
			
			conn.setAutoCommit(false);
			
			cstat = conn.prepareCall(sql);
			cstat.setInt(1,seq);
			
			num = cstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}
		conn.commit();
		return num;
	}
	
	
	//mypagelike.do -> 회원 매물 찜목록 요청
	/**
	 * 회원의 매물 찜목록을 가져옵니다.
	 * @param seq 회원번호
	 * @return 매물 찜목록
	 */
	public ArrayList<vwPropertyLikeDTO> getPropertyLike(int seq) {
		ArrayList<vwPropertyLikeDTO> list = new ArrayList<vwPropertyLikeDTO>();
		
		try {
			
			/*String sql ="{call procPropertyLike(?,?)}";
			
			cstat = conn.prepareCall(sql);
			
			cstat.setInt(1, seq);
			cstat.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstat.executeQuery();
			
			//Oracle(cursor) -> JDBC(ResultSet)
			rs = (ResultSet)cstat.getObject(2);
			
			
			
			//매물 찜목록 객체 생성
			vwPropertyLikeDTO pdto = new vwPropertyLikeDTO();
			
			//리스트에 담기
			while(rs.next()) {
				pdto.setSeqUser(rs.getInt("seqUser"));
				pdto.setImagePath(rs.getString("imagePath"));
				pdto.setDeposit(rs.getInt("deposit"));
				pdto.setMonthlyRent(rs.getInt("monthlyRent"));
				pdto.setDealing(rs.getInt("dealing"));
				pdto.setRoomtype(rs.getString("roomtype"));
				pdto.setLocation(rs.getString("location"));
				pdto.setSpacing(rs.getInt("spacing"));
				pdto.setFloor(rs.getString("floor"));
				
				list.add(pdto);
			}
			*/
			
			String sql = "select * from vwPropertylike where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, seq);
			
			rs = pstat.executeQuery();
			
			
			while(rs.next()) {
				
				vwPropertyLikeDTO pdto = new vwPropertyLikeDTO();
				pdto.setSeqUser(rs.getInt("seqUser"));
				pdto.setImagePath(rs.getString("imagePath"));
				pdto.setDeposit(rs.getInt("deposit"));
				pdto.setMonthlyRent(rs.getInt("monthlyRent"));
				pdto.setDealing(rs.getInt("dealing"));
				pdto.setRoomtype(rs.getString("roomtype"));
				pdto.setLocation(rs.getString("location"));
				pdto.setSpacing(rs.getInt("spacing"));
				pdto.setFloor(rs.getString("floor"));
				pdto.setSeqContractorProperty(rs.getInt("seqContractorProperty"));
				
				list.add(pdto);
				
			}
				
			System.out.println("servlet.plist"+list);
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
		
	}
	
	//mypagelike.do -> 회원 중고장터 찜목록 요청
	/**
	 * 회원의 중고장터 찜목록을 가져옵니다.
	 * @param seq 회원번호
	 * @return 중고장터 찜목록
	 */
	public ArrayList<vwUsedLikeDTO> getUsedLike(int seq) {

		ArrayList<vwUsedLikeDTO> list = new ArrayList<vwUsedLikeDTO>();
		try {
			
			/*
			 * String sql = "{call procUsedLike(?,?)}";
			 * 
			 * cstat = conn.prepareCall(sql);
			 * 
			 * cstat.setInt(1, seq); cstat.registerOutParameter(2, OracleTypes.CURSOR);
			 * 
			 * cstat.executeQuery();
			 * 
			 * //Oracle(cursor) -> JDBC(ResultSet) rs = (ResultSet)cstat.getObject(2);
			 * 
			 * 
			 * 
			 * //매물 찜목록 객체 생성 
			 * vwUsedLikeDTO udto = new vwUsedLikeDTO();
			 * 
			 * //리스트에 담기 while(rs.next()) { udto.setSeqUser(rs.getInt("seqUser"));
			 * udto.setSeqUsed(rs.getInt("seqUsed")); udto.setTitle(rs.getString("title"));
			 * udto.setSellNickname(rs.getString("sellnickname"));
			 * udto.setState(rs.getString("state"));
			 * udto.setImagePath(rs.getString("imagePath"));
			 * udto.setWriteDate(rs.getDate("writeDate"));
			 * udto.setTradeMode(rs.getString("tradeMode"));
			 * 
			 * list.add(udto); }
			 */
			
			String sql = "select * from vwUsedLike where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, seq);
			
			rs = pstat.executeQuery();
			
			
			while(rs.next()) {
				vwUsedLikeDTO udto = new vwUsedLikeDTO();
				 udto.setSeqUsed(rs.getInt("seqUsed")); 
				 udto.setTitle(rs.getString("title"));
				 udto.setSellNickname(rs.getString("sellnickname"));
				 udto.setState(rs.getString("state"));
				 udto.setImagePath(rs.getString("imagePath"));
				 udto.setWriteDate(rs.getDate("writeDate"));
				 udto.setTradeMode(rs.getString("tradeMode"));
				 udto.setPrice(rs.getInt("price"));
				 
				 list.add(udto);
				 
			}

			System.out.println("servlet.ulist"+list);

		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return list;
	}

}
