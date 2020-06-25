package com.iemr.mmu.service.covid19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonObject;
import com.iemr.mmu.repo.nurse.covid19.Covid19BenFeedbackRepo;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonServiceImpl;
import com.iemr.mmu.service.labtechnician.LabTechnicianServiceImpl;
import com.iemr.mmu.service.tele_consultation.TeleConsultationServiceImpl;

public class Covid19ServiceImpl implements Covid19Service {
	@Autowired
	private CommonNurseServiceImpl commonNurseServiceImpl;
	@Autowired
	private CommonDoctorServiceImpl commonDoctorServiceImpl;
	@Autowired
	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;
	@Autowired
	private LabTechnicianServiceImpl labTechnicianServiceImpl;
	@Autowired
	private CommonServiceImpl commonServiceImpl;
	@Autowired
	private TeleConsultationServiceImpl teleConsultationServiceImpl;
	
	@Autowired
	private Covid19BenFeedbackRepo covid19BenFeedbackRepo;
	@Autowired
	private PrescriptionDetailRepo prescriptionDetailRepo;
	
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Long saveCovid19NurseData(JsonObject requestOBJ, String Authorization) throws Exception{
		
		return null;
	}
	

}
