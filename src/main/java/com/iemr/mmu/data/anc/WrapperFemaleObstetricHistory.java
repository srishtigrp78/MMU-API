package com.iemr.mmu.data.anc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import com.iemr.mmu.service.anc.Utility;

public class WrapperFemaleObstetricHistory {
	
	private Long beneficiaryRegID;
	private Long benVisitID;
	private Integer providerServiceMapID;
	private String createdBy;
	
	private ArrayList<FemaleObstetricHistory> femaleObstetricHistoryList;

	public ArrayList<FemaleObstetricHistory> getFemaleObstetricHistoryList() {
		return femaleObstetricHistoryList;
	}

	public void setFemaleObstetricHistoryList(ArrayList<FemaleObstetricHistory> femaleObstetricHistoryList) {
		this.femaleObstetricHistoryList = femaleObstetricHistoryList;
	}
	
	public ArrayList<FemaleObstetricHistory> getFemaleObstetricHistoryDetails(){
		for(FemaleObstetricHistory femaleObstetricHistory:femaleObstetricHistoryList){
		
			femaleObstetricHistory.setBeneficiaryRegID(beneficiaryRegID);
			femaleObstetricHistory.setBenVisitID(benVisitID);
			femaleObstetricHistory.setProviderServiceMapID(providerServiceMapID);
			femaleObstetricHistory.setCreatedBy(createdBy);
			
		}
		return femaleObstetricHistoryList;
	}
	
	public static WrapperFemaleObstetricHistory getFemaleObstetricHistory(ArrayList<Object[]> FemaleObstetricHistory){
		WrapperFemaleObstetricHistory WFO = new WrapperFemaleObstetricHistory();
		WFO.femaleObstetricHistoryList = new ArrayList<FemaleObstetricHistory>();
		
		if(null != FemaleObstetricHistory && FemaleObstetricHistory.size()>0){
			Object[] obj1 = FemaleObstetricHistory.get(0);
			WFO.beneficiaryRegID = (Long)obj1[0];
			WFO.benVisitID = (Long)obj1[1];
			WFO.providerServiceMapID = (Integer)obj1[2];
			
			for(Object[] obj: FemaleObstetricHistory){
			
				FemaleObstetricHistory obstetricHistory= new FemaleObstetricHistory((Short)obj[3], (Short)obj[4], (String)obj[5], (String)obj[6],
						(Short)obj[7], (String)obj[8], (Short)obj[9], (String)obj[10], (Short)obj[11], (String)obj[12], (String)obj[13], (Short)obj[14],
						(String)obj[15], (String)obj[16], (Short)obj[17], (String)obj[18], (Short)obj[19], (String)obj[20], (String)obj[21], (Short)obj[22],
						(String)obj[23], (String)obj[24], (String)obj[25], (Short)obj[26], (String)obj[27], (String)obj[28]);
				
				WFO.femaleObstetricHistoryList.add(obstetricHistory);
				
			}
		}
		return WFO;
	}
	
}
