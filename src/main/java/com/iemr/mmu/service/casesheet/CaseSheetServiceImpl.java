package com.iemr.mmu.service.casesheet;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.doctor.CancerExaminationImageAnnotation;
import com.iemr.mmu.data.doctor.WrapperCancerExamImgAnotasn;
import com.iemr.mmu.repo.doctor.CancerExaminationImageAnnotationRepo;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.mmu.service.registrar.RegistrarServiceImpl;

@Service
public class CaseSheetServiceImpl {

	private NurseServiceImpl nurseServiceImpl;
	private RegistrarServiceImpl registrarServiceImpl;
	private CancerExaminationImageAnnotationRepo cancerExaminationImageAnnotationRepo;

	@Autowired
	public void setCancerExaminationImageAnnotationRepo(
			CancerExaminationImageAnnotationRepo cancerExaminationImageAnnotationRepo) {
		this.cancerExaminationImageAnnotationRepo = cancerExaminationImageAnnotationRepo;
	}

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}


	@Autowired
	public void setRegistrarServiceImpl(RegistrarServiceImpl registrarServiceImpl) {
		this.registrarServiceImpl = registrarServiceImpl;
	}

//	public String getBenDataForCaseSheet(Long benRegID, Long benVisitID, Date visitDateTime) {
//		Map<String, Object> caseSheetData = nurseServiceImpl.getBenNurseDataForCaseSheet(benRegID, benVisitID,
//				visitDateTime);
//		caseSheetData
//				.putAll(doctorServiceImpl.getBenDoctorEnteredDataForCaseSheet(benRegID, benVisitID, visitDateTime));
//		caseSheetData.put("BeneficiaryDemographicData", registrarServiceImpl.getBeneficiaryPersonalDetails(benRegID));
//		return new Gson().toJson(caseSheetData);
//	}

	public String getBeneficiaryCaseSheetHistory(Long benRegID) {
		String caseSheetHistory = nurseServiceImpl.getBeneficiaryVisitHistory(benRegID);
		return caseSheetHistory;
	}

	
}
