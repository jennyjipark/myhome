package com.myhome.admin2.report;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.myhome.DBUtil;
/**
 * 신고 관련 DB 업무처리 클래스
 * @author 이대홍
 *
 */
public class ReportDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	private CallableStatement ct;

	public ReportDAO() {
		conn = DBUtil.open();
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("close : " + e);
		}
	}

	public ArrayList<ReportDTO> list(HashMap<String, String> map) {
		/*
		 * <option value="1"> 중고장터</option> seqUsed vwUsedReport <option value="2">
		 * 커뮤니티</option> seqCommunity vwCReport <option value="3"> 매물거래</option>
		 * seqProperty vwPCReport
		 * 
		 */

		try {
			String where = "";
			if (map.get("search") != null) {
				where = String.format(" where title like '%%%s%%' or " + "content like '%%%s%%'", map.get("search"),
						map.get("search"));
			}

			if (map.get("category").equals("1")) {

				String sql = String.format("select * from "
						+ "(select a.*, rownum as rnum from vwUsedReport a %s order by SeqReport desc) "
						+ "where rnum between %s and %s ", where, map.get("begin"), map.get("end"));

				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				ArrayList<ReportDTO> list = new ArrayList<ReportDTO>();

				while (rs.next()) {
					ReportDTO dto = new ReportDTO();

					dto.setSeqReport(rs.getString("seqReport"));
					dto.setpId(rs.getString("pId")); // 신고 한 사람
					dto.setpUser(rs.getString("pUser"));

					dto.setTitle(rs.getString("title"));
					dto.setReason(rs.getString("reason"));

					dto.setSeqUsed(rs.getString("SeqUsed")); // 해당 번호 알기

					dto.setState(rs.getString("state"));

					dto.setrUser(rs.getString("rUser")); // 신고 받는사람
					dto.setrId(rs.getString("rId"));

					list.add(dto);

				}
				
				rs.close();
				ps.close();
				
				return list;

				// seqCommunity
			} else if (map.get("category").equals("2")) {

				String sql = String.format(
						"select * from (select a.*, rownum as rnum from vwCReport a %s order by SeqReport desc) "
								+ "where rnum between %s and %s ",
						where, map.get("begin"), map.get("end"));

				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				ArrayList<ReportDTO> list = new ArrayList<ReportDTO>();

				while (rs.next()) {
					ReportDTO dto = new ReportDTO();

					dto.setSeqReport(rs.getString("seqReport"));
					dto.setrUser(rs.getString("rUser")); // 신고 한사람
					dto.setrId(rs.getString("rId"));

					dto.setTitle(rs.getString("title"));
					dto.setReason(rs.getString("reason"));

					dto.setSeqCommunity(rs.getString("seqCommunity")); // 해당 번호 알기

					dto.setState(rs.getString("state"));
					dto.setpId(rs.getString("pId")); // 신고 받는 사람
					dto.setpUser(rs.getString("pUser"));
					list.add(dto);

				}
				rs.close();
				ps.close();
				return list;

				// seqProperty vwPCReport
			} else if (map.get("category").equals("3")) {

				String sql = String.format(
						"select * from " + "(select a.*, rownum as rnum from vwPCReport a %s order by SeqReport desc) "
								+ "where rnum between %s and %s ",
						where, map.get("begin"), map.get("end"));

				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				ArrayList<ReportDTO> list = new ArrayList<ReportDTO>();

				while (rs.next()) {
					ReportDTO dto = new ReportDTO();

					dto.setSeqReport(rs.getString("seqReport"));
					dto.setpId(rs.getString("pId")); // 신고 한 사람
					dto.setpUser(rs.getString("pUser"));

					dto.setTitle(rs.getString("title"));
					dto.setReason(rs.getString("reason"));

					dto.setSeqProperty(rs.getString("seqProperty")); // 해당 번호 알기

					dto.setState(rs.getString("state"));

					dto.setrUser(rs.getString("rUser")); // 신고 받는사람
					dto.setrId(rs.getString("rId"));

					list.add(dto);

				}
				rs.close();
				ps.close();
				return list;

			}

		} catch (Exception e) {

			System.out.println(" report list : " + e);
		}

		return null;
	}

	public int totalCount(HashMap<String, String> map) {

		/*
		 * <option value="1"> 중고장터</option> seqUsed vwUsedReport <option value="2">
		 * 커뮤니티</option> seqCommunity vwCReport <option value="3"> 매물거래</option>
		 * seqProperty vwPCReport
		 * 
		 */

		try {
			String where = "";
			if (map.get("search") != null) {
				where = String.format(" where title like '%%%s%%' or " + "content like '%%%s%%'", map.get("search"),
						map.get("search"));
			}

			if (map.get("category").equals("1")) {

				String sql = String.format("select count(*) as count  from "
						+ "(select a.*, rownum as rnum from vwUsedReport a %s order by SeqReport desc) "
						+ "where rnum between %s and %s ", where, map.get("begin"), map.get("end"));

				st = conn.createStatement();
				rs = st.executeQuery(sql);

				if (rs.next()) {

					int result = rs.getInt("count");
					return result;
				}

				// seqCommunity
			} else if (map.get("category").equals("2")) {

				String sql = String.format("select count(*) as count  from "
						+ "(select a.*, rownum as rnum from vwCReport a %s order by SeqReport desc) "
						+ "where rnum between %s and %s ", where, map.get("begin"), map.get("end"));

				st = conn.createStatement();
				rs = st.executeQuery(sql);

				if (rs.next()) {
					
					int result = rs.getInt("count");
					return result;
				}

				// seqProperty vwPCReport
			} else if (map.get("category").equals("3")) {

				String sql = String.format("select count(*) as count from "
						+ "(select a.*, rownum as rnum from vwPCReport a %s order by SeqReport desc) "
						+ "where rnum between %s and %s ", where, map.get("begin"), map.get("end"));

				st = conn.createStatement();
				rs = st.executeQuery(sql);

				if (rs.next()) {
					int result = rs.getInt("count");
					return result;
				}

			}

		} catch (Exception e) {

			System.out.println("repot count : " + e);
		}

		return 0;
	}

	public ReportDTO view(String seq, String category) {
		/*
		 * <option value="1"> 중고장터</option> seqUsed vwUsedReport <option value="2">
		 * 커뮤니티</option> seqCommunity vwCReport <option value="3"> 매물거래</option>
		 * seqProperty vwPCReport
		 * 
		 */

		try {
			if (category.equals("1")) {

				String sql = String.format("select * from vwUsedReport where seqreport = %s", seq);

				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					ReportDTO dto = new ReportDTO();

					dto.setSeqReport(rs.getString("seqReport"));
					dto.setpId(rs.getString("pId")); // 신고 한 사람
					dto.setpUser(rs.getString("pUser"));

					dto.setTitle(rs.getString("title"));
					dto.setReason(rs.getString("reason"));

					dto.setSeqUsed(rs.getString("SeqUsed")); // 해당 번호 알기

					dto.setState(rs.getString("state"));

					dto.setrUser(rs.getString("rUser")); // 신고 받는사람
					dto.setrId(rs.getString("rId"));

					rs.close();
					ps.close();
					
					return dto;

				}

				// seqCommunity
			} else if (category.equals("2")) {

				String sql = String.format("select * from vwCReport where seqreport = %s", seq);

				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					ReportDTO dto = new ReportDTO();

					dto.setSeqReport(rs.getString("seqReport"));
					dto.setrUser(rs.getString("rUser")); // 신고 한사람
					dto.setrId(rs.getString("rId"));

					dto.setTitle(rs.getString("title"));
					dto.setReason(rs.getString("reason"));

					dto.setSeqCommunity(rs.getString("seqCommunity")); // 해당 번호 알기

					dto.setState(rs.getString("state"));
					dto.setpId(rs.getString("pId")); // 신고 받는 사람
					dto.setpUser(rs.getString("pUser"));

					rs.close();
					ps.close();
					
					return dto;

				}

				// seqProperty vwPCReport
			} else if (category.equals("3")) {

				String sql = String.format("select *  from vwPCReport a where seqreport = %s ", seq);

				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					ReportDTO dto = new ReportDTO();

					dto.setSeqReport(rs.getString("seqReport"));
					dto.setpId(rs.getString("pId")); // 신고 한 사람
					dto.setpUser(rs.getString("pUser"));

					dto.setTitle(rs.getString("title"));
					dto.setReason(rs.getString("reason"));

					dto.setSeqProperty(rs.getString("seqProperty")); // 해당 번호 알기

					dto.setState(rs.getString("state"));

					dto.setrUser(rs.getString("rUser")); // 신고 받는사람
					dto.setrId(rs.getString("rId"));

					
					rs.close();
					ps.close();
					
					return dto;

				}

			}

		} catch (Exception e) {

			System.out.println(" report list : " + e);
		}

		return null;

	}

	// 채팅 전송 ProcReportChat
	public int chatOk(String seqAdmin, String pUser, String rUser) {

		String sql = "{call ProcReportChat(?,?,?)}";

		try {
			ct = conn.prepareCall(sql);
			ct.setString(1, seqAdmin);
			ct.setString(2, pUser);
			ct.setString(3, rUser);

			
			int result = ct.executeUpdate();
			ct.close();
			return result;

		} catch (Exception e) {
			System.out.println("chatok : " + e);
		}

		return 0;
	} // chat

	// 처리중 완료
	public int reportCount(String puser, String category, String seqReport) {
		// ProcreportCount

		String sql = "{ call ProcreportCount (?)}";

		try {
			ct = conn.prepareCall(sql);
			ct.setString(1, puser);

			int result = ct.executeUpdate();

			ct.close();

			if (result == 1) {

				if (category.equals("1")) {

					sql = String.format("update tblUsedReport set state = '완료'  where seqUsedreport = %s", seqReport);

					ps = conn.prepareStatement(sql);
					
					int temp = ps.executeUpdate();
					return temp;

					// seqCommunity
				} else if (category.equals("2")) {

					sql = String.format("update tblCommunityReport set state = '완료' where seqcommunityreport = %s",
							seqReport);

					ps = conn.prepareStatement(sql);
					int temp = ps.executeUpdate();
					return temp;

					// seqProperty vwPCReport
				} else if (category.equals("3")) {

					sql = String.format(
							"update tblPropertyContractReport set state = '완료' where seqPropertyContractReport = %s ",
							seqReport);

					ps = conn.prepareStatement(sql);
					int temp = ps.executeUpdate();
					return temp;

				}

			} // result 프로지서 조건문

		} catch (Exception e) {
			System.out.println("count : " + e);
		}

		return 0;
	}// count

	// 카운트 성공 즉, 업무처리 완료 ProcReportCompleteChat
	public int chat(String seqAdmin, String pUser, String rUser) {

		String sql = "{call ProcReportCompleteChat(?,?,?)}";

		try {
			ct = conn.prepareCall(sql);
			ct.setString(1, seqAdmin);
			ct.setString(2, pUser);
			ct.setString(3, rUser);

			int result = ct.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			System.out.println("chat : " + e);
		}

		return 0;
	}

}
