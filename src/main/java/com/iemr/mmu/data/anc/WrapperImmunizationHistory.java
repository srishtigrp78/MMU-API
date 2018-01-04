package com.iemr.mmu.data.anc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WrapperImmunizationHistory {
	private Long beneficiaryRegID;
	private Long benVisitID;
	private Integer providerServiceMapID;
	private String createdBy;
	
	private ArrayList<ChildVaccineDetail1> immunizationList;

	public ArrayList<ChildVaccineDetail1> getImmunizationList() {
		return immunizationList;
	}

	public void setImmunizationList(ArrayList<ChildVaccineDetail1> immunizationList) {
		this.immunizationList = immunizationList;
	}
	
	public ArrayList<ChildVaccineDetail1> getBenChildVaccineDetails(){
		
		ArrayList<ChildVaccineDetail1> childVaccineDetailList = new ArrayList<ChildVaccineDetail1>();
		for(ChildVaccineDetail1 childVaccineDetail:immunizationList){
				
			List<Map<String,String>> vaccinesList = childVaccineDetail.getVaccines();
			for(Map<String,String> vaccine :vaccinesList){
				ChildVaccineDetail1 vaccineDetail = new ChildVaccineDetail1(childVaccineDetail.getDefaultReceivingAge(), vaccine.get("vaccine"), vaccine.get("status"));
				vaccineDetail.setBeneficiaryRegID(beneficiaryRegID);
				vaccineDetail.setBenVisitID(benVisitID);
				vaccineDetail.setProviderServiceMapID(providerServiceMapID);
				vaccineDetail.setCreatedBy(createdBy);
				
				childVaccineDetailList.add(vaccineDetail);
			}
			
		}
		return childVaccineDetailList;
	}
	
	public static WrapperImmunizationHistory getChildVaccineDetail(ArrayList<Object[]> childVaccineDetail){
		WrapperImmunizationHistory WIH = new WrapperImmunizationHistory();
		WIH.immunizationList = new ArrayList<ChildVaccineDetail1>();
		
		if(null != childVaccineDetail && childVaccineDetail.size()>0){
			Object[] obj1 = childVaccineDetail.get(0);
			WIH.beneficiaryRegID = (Long)obj1[0];
			WIH.benVisitID = (Long)obj1[1];
			WIH.providerServiceMapID = (Integer)obj1[2];
			List<Map<String,String>> vaccinesList = new ArrayList<Map<String,String>>();
			for(Object[] obj: childVaccineDetail){
				
				ChildVaccineDetail1 childVaccine= new ChildVaccineDetail1((String)obj[3], (String)obj[4], (String)obj[5]);
				
				WIH.immunizationList.add(childVaccine);
				
			}
		}
		return WIH;
	}
}
