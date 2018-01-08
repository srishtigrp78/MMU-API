package com.iemr.mmu.data.anc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

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
				
			List<Map<String,Object>> vaccinesList = childVaccineDetail.getVaccines();
			for(Map<String,Object> vaccine :vaccinesList){
				ChildVaccineDetail1 vaccineDetail = new ChildVaccineDetail1(childVaccineDetail.getDefaultReceivingAge(), vaccine.get("vaccine").toString(), (Boolean)vaccine.get("status"));
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
			List<Map<String,Object>> vaccinesList = new ArrayList<Map<String,Object>>();
			ChildVaccineDetail1 childVaccine = null;
			Map<String,Object> vaccines = new HashMap<String,Object>();
			
			int size =childVaccineDetail.size();
			for(Object[] obj: childVaccineDetail){
				if(!(null!= childVaccine && childVaccine.getDefaultReceivingAge().equals((String)obj[3]))){
					
					if(null!= childVaccine){
						WIH.immunizationList.add(childVaccine);
					}
					vaccinesList = new ArrayList<Map<String,Object>>();
					childVaccine= new ChildVaccineDetail1((String)obj[3]);
				}
				
				vaccines = new HashMap<String,Object>();
				vaccines.put("vaccine", (String)obj[4]);
				vaccines.put("status",  (Boolean)obj[5]);
				vaccinesList.add(vaccines);
				childVaccine.setVaccines(vaccinesList);
				
				int index = childVaccineDetail.indexOf(obj);
				if(index==size-1){
					WIH.immunizationList.add(childVaccine);
				}
			}
		}
		return WIH;
	}
}
