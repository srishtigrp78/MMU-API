package com.iemr.mmu.data.anc;

import java.util.ArrayList;

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
			
			String OtherDeliveryPlace = femaleObstetricHistory.getOtherDeliveryPlace();
			
			String OtherPregComplicationType = femaleObstetricHistory.getOtherPregComplicationType();
			
			String OtherDeliveryComplicationType = femaleObstetricHistory.getOtherDeliveryComplicationType();
			
			String OtherNewBornComplication = femaleObstetricHistory.getOtherNewBornComplication();
			
			String OtherPostNatalComplication = femaleObstetricHistory.getOtherPostNatalComplication();
			
			String OtherPostpartumComplicationType = femaleObstetricHistory.getOtherPostpartumComplicationType();
			
			femaleObstetricHistory.setDeliveryPlace(femaleObstetricHistory.getDeliveryPlace() +"-"+OtherDeliveryPlace);
			
			femaleObstetricHistory.setPregComplicationType(femaleObstetricHistory.getPregComplicationType()+"-"+OtherPregComplicationType);
			
			femaleObstetricHistory.setDeliveryComplicationType(femaleObstetricHistory.getDeliveryComplicationType()+"-"+OtherDeliveryComplicationType);
			
			femaleObstetricHistory.setNewBornComplication(femaleObstetricHistory.getNewBornComplication()+"-"+OtherNewBornComplication);
			
			femaleObstetricHistory.setPostNatalComplication(femaleObstetricHistory.getPostNatalComplication()+"-"+OtherPostNatalComplication);
			
			femaleObstetricHistory.setPostpartumComplicationType(femaleObstetricHistory.getPostpartumComplicationType()+"-"+OtherPostpartumComplicationType);

		}
		return femaleObstetricHistoryList;
	}
}
