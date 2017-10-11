package com.iemr.mmu.service.doctor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.doctor.CancerAbdominalExamination;
import com.iemr.mmu.data.doctor.CancerBreastExamination;
import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.data.doctor.CancerGynecologicalExamination;
import com.iemr.mmu.data.doctor.CancerLymphNodeDetails;
import com.iemr.mmu.data.doctor.CancerOralExamination;
import com.iemr.mmu.data.doctor.CancerSignAndSymptoms;
import com.iemr.mmu.data.masterdata.doctor.PreMalignantLesion;
import com.iemr.mmu.data.masterdata.nurse.CancerDiseaseType;
import com.iemr.mmu.data.masterdata.nurse.CancerPersonalHabitType;
import com.iemr.mmu.data.masterdata.nurse.FamilyMemberType;
import com.iemr.mmu.data.masterdata.nurse.VisitCategory;
import com.iemr.mmu.data.masterdata.nurse.VisitReason;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.repo.doctor.CancerAbdominalExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerBreastExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerDiagnosisRepo;
import com.iemr.mmu.repo.doctor.CancerGynecologicalExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerLymphNodeExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerOralExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerSignAndSymptomsRepo;
import com.iemr.mmu.repo.masterrepo.doctor.PreMalignantLesionMasterRepo;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private CancerAbdominalExaminationRepo cancerAbdominalExaminationRepo;
	
	@Autowired
	private CancerBreastExaminationRepo cancerBreastExaminationRepo;
	
	@Autowired
	private CancerDiagnosisRepo cancerDiagnosisRepo;
	
	@Autowired
	private CancerGynecologicalExaminationRepo cancerGynecologicalExaminationRepo;
	
	@Autowired
	private CancerLymphNodeExaminationRepo cancerLymphNodeExaminationRepo;
	
	@Autowired
	private CancerOralExaminationRepo cancerOralExaminationRepo;
	
	@Autowired 
	private CancerSignAndSymptomsRepo cancerSignAndSymptomsRepo;
	
	@Override
	public CancerAbdominalExamination saveCancerAbdominalExaminationData(
			CancerAbdominalExamination cancerAbdominalExamination) {
		CancerAbdominalExamination response = cancerAbdominalExaminationRepo.save(cancerAbdominalExamination);
		return response;
	}

	@Override
	public CancerBreastExamination saveCancerBreastExaminationData(CancerBreastExamination cancerBreastExamination) {
		CancerBreastExamination response = cancerBreastExaminationRepo.save(cancerBreastExamination);
		return response;
	}

	@Override
	public CancerDiagnosis saveCancerDiagnosisData(CancerDiagnosis cancerDiagnosis) {
		CancerDiagnosis response = cancerDiagnosisRepo.save(cancerDiagnosis);
		return response;
	}

	@Override
	public CancerGynecologicalExamination saveCancerGynecologicalExaminationData(
			CancerGynecologicalExamination cancerGynecologicalExamination) {
		
		String typeOfLesionData = "";
		for(String typeOfLesion:cancerGynecologicalExamination.getTypeOfLesionList()){
			typeOfLesionData+=typeOfLesion+",";
		}
		cancerGynecologicalExamination.setTypeOfLesion(typeOfLesionData);
		
		CancerGynecologicalExamination response = cancerGynecologicalExaminationRepo.save(cancerGynecologicalExamination);
		return response;
	}

	@Override
	public int saveLymphNodeDetails(List<CancerLymphNodeDetails> cancerLymphNodeDetails) {
		int responseData = 0;
		List<CancerLymphNodeDetails> response = (List<CancerLymphNodeDetails>) cancerLymphNodeExaminationRepo
				.save(cancerLymphNodeDetails);
		for (CancerLymphNodeDetails obj : response) {
			if (obj.getID() > 0)
				responseData = 1;
		}
		return responseData;
	}

	@Override
	public CancerOralExamination saveCancerOralExaminationData(CancerOralExamination cancerOralExamination) {
		
		String preMalignantLesionTypeData="";
		for(String preMalignantLesionType : cancerOralExamination.getPreMalignantLesionTypeList()){
			preMalignantLesionTypeData += preMalignantLesionType+",";
		}
		cancerOralExamination.setPreMalignantLesionType(preMalignantLesionTypeData);
		
		CancerOralExamination response = cancerOralExaminationRepo.save(cancerOralExamination);
		return response;
	}

	@Override
	public CancerSignAndSymptoms saveCancerSignAndSymptomsData(CancerSignAndSymptoms cancerSignAndSymptoms) {
		CancerSignAndSymptoms response = cancerSignAndSymptomsRepo.save(cancerSignAndSymptoms);
		return response;
	}

}
