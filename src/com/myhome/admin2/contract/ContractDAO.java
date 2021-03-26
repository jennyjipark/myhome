package com.myhome.admin2.contract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.myhome.DBUtil;
import com.myhome.admin2.Admin2;


/**
 * 전자 계약관련 DB업무를 처리하는 클래스 
 * 
 * @author 이대홍
 */
public class ContractDAO extends Admin2{


	@Override
	public ArrayList<ContractDTO> list(HashMap<String, String> map) {

		try {

			String where = "";

			if (map.get("search") != null) {
				where = String.format(" where "+ "content like '%%%s%%'", map.get("search"));
			}

			String sql = String.format("select * from "
					+ "(select a.*, rownum as rnum from vwContract a %s order by seqC desc) "
					+ "where rnum between %s and %s ", where, map.get("begin"),map.get("end"));

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			ArrayList<ContractDTO> list = new ArrayList<ContractDTO>();

			while (rs.next()) {
				ContractDTO dto = new ContractDTO();

				dto.setCompanyNumberC(rs.getString("companyNumberC"));
				dto.setContent(rs.getString("content"));
				dto.setContractDate(rs.getString("contractDate"));
				dto.setContractPeriod(rs.getString("contractPeriod"));
				dto.setDealing(rs.getString("dealing"));
				dto.setDeposit(rs.getString("deposit"));
				dto.setIdnumberT(rs.getString("idnumberT"));
		
				dto.setIdNumberL(rs.getString("idNumberL"));
				dto.setLocation(rs.getString("location"));
				dto.setMonthlyRent(rs.getString("monthlyRent"));
				
				dto.setNameC(rs.getString("nameC"));
				dto.setNameL(rs.getString("nameL"));
				dto.setNameT(rs.getString("nameT"));
				
				dto.setSeqC(rs.getString("seqC"));
				dto.setSeqCP(rs.getString("seqCP"));
				dto.setSeqLP(rs.getString("seqLP"));
				dto.setSeqP(rs.getString("seqP"));
				
				dto.setSeqUserC(rs.getString("seqUserC"));
				dto.setSeqUserL(rs.getString("seqUserL"));
				dto.setSeqUserT(rs.getString("seqUserT"));
				
				dto.setSignC(rs.getString("signC"));
				dto.setSignL(rs.getString("signL"));
				dto.setSignT(rs.getString("signT"));

				dto.setState(rs.getString("state"));
				
				dto.setTelC(rs.getString("telC"));
				dto.setTelL(rs.getString("telL"));
				dto.setTelT(rs.getString("telT"));
				
				dto.setType(rs.getString("type"));
				
				
				list.add(dto);

			}
			rs.close();
			ps.close();
			
			return list;

		} catch (Exception e) {

			System.out.println("contract list : " + e);
		}
		return null;

		
	}

	@Override
	public int totalCount(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		try {

			String where = "";

			if (map.get("search") != null) {
				where = String.format(" where " + "content like '%%%s%%'", map.get("search"));
			}

			String sql = String.format("select count(*) as count from vwcontract %s ", where);

			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				int result = rs.getInt("count");
				
				
				rs.close();
				st.close();
				
				return result;
			}

		} catch (Exception e) {
			System.out.println( " contract total : "+ e);
		}

		return 0;
		
		
		
	}

	public ContractDTO view(String seqC) {


		try {
			
			String sql = "select * from vwContract where seqC ="+seqC;
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				ContractDTO dto = new ContractDTO();

				dto.setCompanyNumberC(rs.getString("companyNumberC"));
				dto.setContent(rs.getString("content"));
				dto.setContractDate(rs.getString("contractDate"));
				dto.setContractPeriod(rs.getString("contractPeriod"));
				dto.setDealing(rs.getString("dealing"));
				dto.setDeposit(rs.getString("deposit"));
				dto.setIdnumberT(rs.getString("idnumberT"));
		
				dto.setIdNumberL(rs.getString("idNumberL"));
				dto.setLocation(rs.getString("location"));
				dto.setMonthlyRent(rs.getString("monthlyRent"));
				
				dto.setNameC(rs.getString("nameC"));
				dto.setNameL(rs.getString("nameL"));
				dto.setNameT(rs.getString("nameT"));
				
				dto.setSeqC(rs.getString("seqC"));
				dto.setSeqCP(rs.getString("seqCP"));
				dto.setSeqLP(rs.getString("seqLP"));
				dto.setSeqP(rs.getString("seqP"));
				
				dto.setSeqUserC(rs.getString("seqUserC"));
				dto.setSeqUserL(rs.getString("seqUserL"));
				dto.setSeqUserT(rs.getString("seqUserT"));
				
				dto.setSignC(rs.getString("signC"));
				dto.setSignL(rs.getString("signL"));
				dto.setSignT(rs.getString("signT"));

				dto.setState(rs.getString("state"));
				
				dto.setTelC(rs.getString("telC"));
				dto.setTelL(rs.getString("telL"));
				dto.setTelT(rs.getString("telT"));
				
				dto.setAddL(rs.getString("addL"));
				dto.setAddC(rs.getString("addC"));
				dto.setAddT(rs.getString("addT"));
				
				dto.setType(rs.getString("type"));
				
				rs.close();
				st.close();
				
				
				return dto;

			}

			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("view : "+e);
		}
		
		return null;
	}

	public int change(String seqAdmin, String seqC) {
		// TODO Auto-generated method stub
		String pass="";
		
		Random rnd = new Random();
		String[] abc = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u"
				,"v","w","x","y","z"};
	
		
		for(int i=0; i<7;i++) {
			pass += abc[rnd.nextInt(abc.length)]+rnd.nextInt(10);
		}
		
		try {
			String sql = "{ call procrepass(?,?,?) }";
			ct = conn.prepareCall(sql);
			ct.setString(1, seqAdmin);
			ct.setString(2, seqC);
			ct.setString(3, pass);
			
			int result = ct.executeUpdate();
			
			ct.close();
			return result;
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("change : "+e);
		}
		
		return 0;
	}

	public int state(String seqC) {
	
		try {
			String sql = "{ call procContractState( ? ) }";
		
			ct = conn.prepareCall(sql);
			ct.setString(1, seqC);
			
			int result = ct.executeUpdate();
			
			ct.close();
			return result;
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("state : "+e);
		}
		
		return 0;
	}

	
}
