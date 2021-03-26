package com.myhome.contractor.upload;

/**
 * @author 박지현
 * 중개인과 매칭된 임대인의 매물 올리기 DTO
 * 
 * */
public class UploadLessorDTO {
		
		private int seqContractor;
		private int seqLessorProperty;
		private int state;
		
		
		public int getSeqContractor() {
			return seqContractor;
		}
		public void setSeqContractor(int seqContractor) {
			this.seqContractor = seqContractor;
		}
		public int getSeqLessorProperty() {
			return seqLessorProperty;
		}
		public void setSeqLessorProperty(int seqLessorProperty) {
			this.seqLessorProperty = seqLessorProperty;
		}
		public int getState() {
			return state;
		}
		public void setState(int state) {
			this.state = state;
		}
		
		
}
