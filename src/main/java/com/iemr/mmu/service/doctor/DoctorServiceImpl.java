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
import com.iemr.mmu.repo.nurse.BenFamilyCancerHistoryRepo;

@Service
public class DoctorServiceImpl implements DoctorService{

	private CancerAbdominalExaminationRepo cancerAbdominalExaminationRepo;
	private CancerBreastExaminationRepo cancerBreastExaminationRepo;
	private CancerDiagnosisRepo cancerDiagnosisRepo;
	private CancerGynecologicalExaminationRepo cancerGynecologicalExaminationRepo;
	private CancerLymphNodeExaminationRepo cancerLymphNodeExaminationRepo;
	private CancerOralExaminationRepo cancerOralExaminationRepo;
	private CancerSignAndSymptomsRepo cancerSignAndSymptomsRepo;
	
	@Autowired
	public void setCancerAbdominalExaminationRepo(CancerAbdominalExaminationRepo cancerAbdominalExaminationRepo) {
		this.cancerAbdominalExaminationRepo = cancerAbdominalExaminationRepo;
	}
	
	@Autowired
	public void setCancerBreastExaminationRepo(CancerBreastExaminationRepo cancerBreastExaminationRepo) {
		this.cancerBreastExaminationRepo = cancerBreastExaminationRepo;
	}
	
	@Autowired
	public void setCancerDiagnosisRepo(CancerDiagnosisRepo cancerDiagnosisRepo) {
		this.cancerDiagnosisRepo = cancerDiagnosisRepo;
	}
	
	@Autowired
	public void setCancerGynecologicalExaminationRepo(
			CancerGynecologicalExaminationRepo cancerGynecologicalExaminationRepo) {
		this.cancerGynecologicalExaminationRepo = cancerGynecologicalExaminationRepo;
	}
	
	@Autowired
	public void setCancerLymphNodeExaminationRepo(CancerLymphNodeExaminationRepo cancerLymphNodeExaminationRepo) {
		this.cancerLymphNodeExaminationRepo = cancerLymphNodeExaminationRepo;
	}
	
	@Autowired
	public void setCancerOralExaminationRepo(CancerOralExaminationRepo cancerOralExaminationRepo) {
		this.cancerOralExaminationRepo = cancerOralExaminationRepo;
	}
	
	@Autowired
	public void setCancerSignAndSymptomsRepo(CancerSignAndSymptomsRepo cancerSignAndSymptomsRepo) {
		this.cancerSignAndSymptomsRepo = cancerSignAndSymptomsRepo;
	}
	
	@Override
	public Long saveCancerAbdominalExaminationData(
			CancerAbdominalExamination cancerAbdominalExamination) {
		CancerAbdominalExamination response = cancerAbdominalExaminationRepo.save(cancerAbdominalExamination);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Override
	public Long saveCancerBreastExaminationData(CancerBreastExamination cancerBreastExamination) {
		CancerBreastExamination response = cancerBreastExaminationRepo.save(cancerBreastExamination);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Override
	public Long saveCancerDiagnosisData(CancerDiagnosis cancerDiagnosis) {
		CancerDiagnosis response = cancerDiagnosisRepo.save(cancerDiagnosis);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Override
	public Long saveCancerGynecologicalExaminationData(
			CancerGynecologicalExamination cancerGynecologicalExamination) {
		List<String> typeOfLesionList = cancerGynecologicalExamination.getTypeOfLesionList();
		String typeOfLesionData = "";
		if(typeOfLesionList != null && typeOfLesionList.size()>0){
			for(String typeOfLesion:typeOfLesionList){
				typeOfLesionData+=typeOfLesion+",";
			}
		}
		cancerGynecologicalExamination.setTypeOfLesion(typeOfLesionData);
		
		CancerGynecologicalExamination response = cancerGynecologicalExaminationRepo.save(cancerGynecologicalExamination);
		if (response != null)
			return response.getID();
		else
			return null;
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
	public Long saveCancerOralExaminationData(CancerOralExamination cancerOralExamination) {
		List<String> preMalignantLesionTypeList = cancerOralExamination.getPreMalignantLesionTypeList();
		String preMalignantLesionTypeData="";
		if(preMalignantLesionTypeList != null && preMalignantLesionTypeList.size()>0){
			for(String preMalignantLesionType : cancerOralExamination.getPreMalignantLesionTypeList()){
				preMalignantLesionTypeData += preMalignantLesionType+",";
			}
		}
		cancerOralExamination.setPreMalignantLesionType(preMalignantLesionTypeData);
		
		CancerOralExamination response = cancerOralExaminationRepo.save(cancerOralExamination);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Override
	public Long saveCancerSignAndSymptomsData(CancerSignAndSymptoms cancerSignAndSymptoms) {
		CancerSignAndSymptoms response = cancerSignAndSymptomsRepo.save(cancerSignAndSymptoms);
		if (response != null)
			return response.getID();
		else
			return null;
	}

}
