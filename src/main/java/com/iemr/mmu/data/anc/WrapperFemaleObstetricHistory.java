package com.iemr.mmu.data.anc;

import java.util.ArrayList;

public class WrapperFemaleObstetricHistory {

	private Long beneficiaryRegID;
	private Long benVisitID;
	private Integer providerServiceMapID;
	private String createdBy;
	private Short totalNoOfPreg;

	private ArrayList<FemaleObstetricHistory> femaleObstetricHistoryList;

	public ArrayList<FemaleObstetricHistory> getFemaleObstetricHistoryList() {
		return femaleObstetricHistoryList;
	}

	public void setFemaleObstetricHistoryList(ArrayList<FemaleObstetricHistory> femaleObstetricHistoryList) {
		this.femaleObstetricHistoryList = femaleObstetricHistoryList;
	}

	public ArrayList<FemaleObstetricHistory> getFemaleObstetricHistoryDetails() {
		if (femaleObstetricHistoryList != null && femaleObstetricHistoryList.size() > 0) {
			for (FemaleObstetricHistory femaleObstetricHistory : femaleObstetricHistoryList) {

				femaleObstetricHistory.setBeneficiaryRegID(beneficiaryRegID);
				femaleObstetricHistory.setBenVisitID(benVisitID);
				femaleObstetricHistory.setProviderServiceMapID(providerServiceMapID);
				femaleObstetricHistory.setCreatedBy(createdBy);
				femaleObstetricHistory.setTotalNoOfPreg(totalNoOfPreg);

			}
		} else {
			FemaleObstetricHistory tmpOBJ = new FemaleObstetricHistory();
			tmpOBJ.setBeneficiaryRegID(beneficiaryRegID);
			tmpOBJ.setBenVisitID(benVisitID);
			tmpOBJ.setProviderServiceMapID(providerServiceMapID);
			tmpOBJ.setCreatedBy(createdBy);
			tmpOBJ.setTotalNoOfPreg(totalNoOfPreg);
			femaleObstetricHistoryList = new ArrayList<FemaleObstetricHistory>();
			femaleObstetricHistoryList.add(tmpOBJ);
		}
		return femaleObstetricHistoryList;
	}

	public static WrapperFemaleObstetricHistory getFemaleObstetricHistory(ArrayList<Object[]> FemaleObstetricHistory) {
		WrapperFemaleObstetricHistory WFO = new WrapperFemaleObstetricHistory();
		WFO.femaleObstetricHistoryList = new ArrayList<FemaleObstetricHistory>();

		if (null != FemaleObstetricHistory && FemaleObstetricHistory.size() > 0) {
			Object[] obj1 = FemaleObstetricHistory.get(0);
			WFO.beneficiaryRegID = (Long) obj1[0];
			WFO.benVisitID = (Long) obj1[1];
			WFO.providerServiceMapID = (Integer) obj1[2];
			WFO.totalNoOfPreg = (Short) obj1[4];
			if( null != WFO.totalNoOfPreg  && WFO.totalNoOfPreg >0){
				for (Object[] obj : FemaleObstetricHistory) {
	
					FemaleObstetricHistory obstetricHistory = new FemaleObstetricHistory((Short) obj[3], (Short) obj[5],
							(String) obj[6], (String) obj[7], (Short) obj[8], (String) obj[9], (Short) obj[10],
							(String) obj[11], (Short) obj[12], (String) obj[13], (String) obj[14], (Short) obj[15],
							(String) obj[16], (String) obj[17], (Short) obj[18], (String) obj[19], (Short) obj[20],
							(String) obj[21], (String) obj[22], (Short) obj[23], (String) obj[24], (String) obj[25],
							(String) obj[26], (Short) obj[27], (String) obj[28], (String) obj[29]);
	
					WFO.femaleObstetricHistoryList.add(obstetricHistory);
	
				}
			}
		}
		return WFO;
	}

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public Long getBenVisitID() {
		return benVisitID;
	}

	public void setBenVisitID(Long benVisitID) {
		this.benVisitID = benVisitID;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Short getTotalNoOfPreg() {
		return totalNoOfPreg;
	}

	public void setTotalNoOfPreg(Short totalNoOfPreg) {
		this.totalNoOfPreg = totalNoOfPreg;
	}

}
