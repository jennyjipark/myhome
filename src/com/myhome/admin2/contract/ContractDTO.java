package com.myhome.admin2.contract;
/**
 * 전자 계약관련 DB 업무 DTO 클래스
 * @author 이대홍
 */
public class ContractDTO {
/*

	tc.seqContract as seqC,                                         --계약번호
    tc.seqContractorProperty as seqcp,                         --매칭매물번호
    tcp.seqLessorProperty as seqlp,                             -- 임대인매물번호
    tlp.seqProperty as seqp,                                        -- 모든 매물번호
    as location, --위치
 	as deposit, -- 보증금
	as monthlyRent, -- 월세
 	as contractPeriod, -- 기간
 	as dealing,
 	as type,
    tc.seqUser as sequsert,                                             -- 임차인번호
    au.name as namet,
    end as idnumberT,
    au.phoneNumber as telt,
    tlp.seqUser as sequserl,                                             -- 임대인번호
    end as namel,
    end as iNumberl,
    end as telL,
    tcp.seqContractor as seqUserC,                                                -- 중개인번호
    end as namec,
    end as companyNumberC,
    end as telc,
    tc.tenantSign as tsign,
    tc.lessorSign as lsign,
    tc.contractorSign as csign,
    to_char(tc.contractDate,'yyyy-mm-dd') as cdate,
    tc.contractState as state,
    tc.contractcontent as content

	
*/	

	private String seqC; // 계약번호
	private String seqCP;	//매칭 매물번호
	private String seqLP; 	//임대인매물번호
	private String seqP;	//모든매물번호
	private String location;
	private String deposit;
	private String monthlyRent;
	private String contractPeriod;
	private String dealing;
	private String type;
	private String seqUserT; //임차인번호
	private String nameT;
	private String idnumberT;
	private String telT;
	private String seqUserL;
	private String nameL;
	private String idNumberL;
	private String telL;
	private String seqUserC;
	private String nameC;
	private String companyNumberC;
	private String telC;
	private String signT;
	private String signL;
	private String signC;
	private String contractDate;
	private String state;
	private String content;
	
	
	private String addL;
	private String addC;
	private String addT;
	
	public String getIdNumberL() {
		return idNumberL;
	}
	public void setIdNumberL(String idNumberL) {
		this.idNumberL = idNumberL;
	}
	
	
	
	public String getAddL() {
		return addL;
	}
	public void setAddL(String addL) {
		this.addL = addL;
	}
	public String getAddC() {
		return addC;
	}
	public void setAddC(String addC) {
		this.addC = addC;
	}
	public String getAddT() {
		return addT;
	}
	public void setAddT(String addT) {
		this.addT = addT;
	}
	public String getSeqC() {
		return seqC;
	}
	public void setSeqC(String seqC) {
		this.seqC = seqC;
	}
	public String getSeqCP() {
		return seqCP;
	}
	public void setSeqCP(String seqCP) {
		this.seqCP = seqCP;
	}
	public String getSeqLP() {
		return seqLP;
	}
	public void setSeqLP(String seqLP) {
		this.seqLP = seqLP;
	}
	public String getSeqP() {
		return seqP;
	}
	public void setSeqP(String seqP) {
		this.seqP = seqP;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getMonthlyRent() {
		return monthlyRent;
	}
	public void setMonthlyRent(String monthlyRent) {
		this.monthlyRent = monthlyRent;
	}
	public String getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	public String getDealing() {
		return dealing;
	}
	public void setDealing(String dealing) {
		this.dealing = dealing;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSeqUserT() {
		return seqUserT;
	}
	public void setSeqUserT(String seqUserT) {
		this.seqUserT = seqUserT;
	}
	public String getNameT() {
		return nameT;
	}
	public void setNameT(String nameT) {
		this.nameT = nameT;
	}
	public String getIdnumberT() {
		return idnumberT;
	}
	public void setIdnumberT(String idnumberT) {
		this.idnumberT = idnumberT;
	}
	
	
	
	public String getSeqUserL() {
		return seqUserL;
	}
	public void setSeqUserL(String seqUserL) {
		this.seqUserL = seqUserL;
	}
	public String getNameL() {
		return nameL;
	}
	public void setNameL(String nameL) {
		this.nameL = nameL;
	}
	
	
	
	public String getTelL() {
		return telL;
	}
	public void setTelL(String telL) {
		this.telL = telL;
	}
	public String getSeqUserC() {
		return seqUserC;
	}
	public void setSeqUserC(String seqUserC) {
		this.seqUserC = seqUserC;
	}
	public String getNameC() {
		return nameC;
	}
	public void setNameC(String nameC) {
		this.nameC = nameC;
	}
	public String getCompanyNumberC() {
		return companyNumberC;
	}
	public void setCompanyNumberC(String companyNumberC) {
		this.companyNumberC = companyNumberC;
	}
	public String getTelC() {
		return telC;
	}
	public void setTelC(String telC) {
		this.telC = telC;
	}
	public String getSignT() {
		return signT;
	}
	public void setSignT(String signT) {
		this.signT = signT;
	}
	public String getSignL() {
		return signL;
	}
	public void setSignL(String signL) {
		this.signL = signL;
	}
	public String getSignC() {
		return signC;
	}
	public void setSignC(String signC) {
		this.signC = signC;
	}
	public String getContractDate() {
		return contractDate;
	}
	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTelT() {
		return telT;
	}
	public void setTelT(String telT) {
		this.telT = telT;
	}


	
	
}
