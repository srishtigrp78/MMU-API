package com.iemr.mmu.service.casesheet;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.service.doctor.DoctorServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;

@Service
public class CaseSheetServiceImpl {

	private NurseServiceImpl nurseServiceImpl;
	private DoctorServiceImpl doctorServiceImpl;
	
	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}
	@Autowired
	public void setDoctorServiceImpl(DoctorServiceImpl doctorServiceImpl) {
		this.doctorServiceImpl = doctorServiceImpl;
	}
	
	public String getBenDataForCaseSheet(Long benRegID, Long benVisitID, Date visitDateTime) {
		Map<String, Object> caseSheetData = nurseServiceImpl.getBenNurseDataForCaseSheet(benRegID, benVisitID, visitDateTime);
		caseSheetData.putAll(doctorServiceImpl.getBenDoctorEnteredDataForCaseSheet(benRegID, benVisitID, visitDateTime));
		
		return new Gson().toJson(caseSheetData);
	}
}
