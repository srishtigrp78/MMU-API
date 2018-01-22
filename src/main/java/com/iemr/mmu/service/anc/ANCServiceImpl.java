package com.iemr.mmu.service.anc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.anc.WrapperAncImmunization;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.mapper.InputMapper;



@Service
public class ANCServiceImpl implements ANCService {
	
	private ANCNurseServiceImpl ancNurseServiceImpl;
	private NurseServiceImpl nurseServiceImpl;
	
	@Autowired
	public void setAncNurseServiceImpl(ANCNurseServiceImpl ancNurseServiceImpl) {
		this.ancNurseServiceImpl = ancNurseServiceImpl;
	}
	
	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}
	
	@Override
	public void saveANCNurseData(JsonObject requestOBJ) {
	// check if visit details data is not null
			if (requestOBJ != null && requestOBJ.has("visitDetails") && !requestOBJ.get("visitDetails").isJsonNull()) {
				// Call method to save visit details data
				Long benVisitID = saveBenVisitDetails(requestOBJ);
				// check if visit details data saved successfully
				if (benVisitID != null && benVisitID > 0) {
					// call method to save history data
					Long ancSaveSuccessFlag = saveBenANCDetails(requestOBJ, benVisitID);
					// call method to save vitals data
					Long historySaveSuccessFlag = saveBenANCHistoryDetails(requestOBJ, benVisitID);
					// call method to save Vital data
					Long vitalSaveSuccessFlag = saveBenANCVitalDetails(requestOBJ, benVisitID);
					// call method to save Examination data
					Long examtnSaveSuccessFlag = saveBenANCExaminationDetails(requestOBJ, benVisitID);
				} else {
					// Error in visit details saving or it is null
				}
			}
	}
	
	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for visitDetails data saving
	 */
	public Long saveBenVisitDetails(JsonObject requestOBJ) {
		
		BeneficiaryVisitDetail benVisitDetailsOBJ = InputMapper.gson().fromJson(requestOBJ.get("visitDetails"),
				BeneficiaryVisitDetail.class);
		Long benVisitID = nurseServiceImpl.saveBeneficiaryVisitDetails(benVisitDetailsOBJ);
		
		// Save Ben Chief Complaints
		//ancNurseServiceImpl.saveBenChiefComplaints(benChiefComplaintList);

		// Save Ben Adherence
		//ancNurseServiceImpl.saveBenAdherenceDetails(benAdherence);
		// Save Ben Investigations
		//ancNurseServiceImpl.saveBenInvestigation(wrapperBenInvestigationANC);
		// TODO  Save Ben Upload Files
		return benVisitID;
	}

	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for visitDetails data saving
	 */
	public Long saveBenANCDetails(JsonObject requestOBJ, Long benVisitID) {
		
		
		// Save Ben ANC Care Details
		//ancNurseServiceImpl.saveBenAncCareDetails(ancCareDetailsOBJ);
		// Save Ben ANC Obstetric Formula
		//WrapperAncImmunization wrapperAncImmunizationOBJ = InputMapper.gson().fromJson(requestObj, WrapperAncImmunization.class);
		//int r = ancServiceImpl.saveAncImmunizationDetails(wrapperAncImmunizationOBJ);
		return null;
	}
	
	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for visitDetails data saving
	 */
	public Long saveBenANCHistoryDetails(JsonObject requestOBJ, Long benVisitID) {
		
		
		// Save Past History
		// Save Comorbidity/concurrent Conditions
		// Save Medication History
		// Save Personal History
		// Save Family History
		// Save Menstrual History
		// Save Past Obstetric History
		
		/**For Female below 15 years..**/
		//Save Immunization History
		//Save Other/Optional Vaccines History
		return null;
	}
	
	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for visitDetails data saving
	 */
	public Long saveBenANCVitalDetails(JsonObject requestOBJ, Long benVisitID) {
		
		
		// Save Physical Anthropometry vital Details
		// Save Physical Vital Detail
		return null;
	}
	
	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for visitDetails data saving
	 */
	public Long saveBenANCExaminationDetails(JsonObject requestOBJ, Long benVisitID) {
		
		
		// Save Physical Anthropometry vital Details
		// Save Physical Vital Detail
		return null;
	}
	
}
