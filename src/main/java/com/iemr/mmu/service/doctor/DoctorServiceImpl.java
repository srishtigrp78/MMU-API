package com.iemr.mmu.service.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.data.doctor.CancerAbdominalExamination;
import com.iemr.mmu.data.doctor.CancerBreastExamination;
import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.data.doctor.CancerGynecologicalExamination;
import com.iemr.mmu.data.doctor.CancerLymphNodeDetails;
import com.iemr.mmu.data.doctor.CancerOralExamination;
import com.iemr.mmu.data.doctor.CancerSignAndSymptoms;
import com.iemr.mmu.repo.doctor.CancerAbdominalExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerBreastExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerDiagnosisRepo;
import com.iemr.mmu.repo.doctor.CancerGynecologicalExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerLymphNodeExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerOralExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerSignAndSymptomsRepo;

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
	
	@Autowired CancerSignAndSymptomsRepo cancerSignAndSymptomsRepo;
	
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
		CancerGynecologicalExamination response = cancerGynecologicalExaminationRepo.save(cancerGynecologicalExamination);
		return response;
	}

	@Override
	public CancerLymphNodeDetails saveLymphNodeDetails(CancerLymphNodeDetails cancerLymphNodeDetails) {
		CancerLymphNodeDetails response = cancerLymphNodeExaminationRepo.save(cancerLymphNodeDetails);
		return response;
	}

	@Override
	public CancerOralExamination saveCancerOralExaminationData(CancerOralExamination cancerOralExamination) {
		CancerOralExamination response = cancerOralExaminationRepo.save(cancerOralExamination);
		return response;
	}

	@Override
	public CancerSignAndSymptoms saveCancerSignAndSymptomsData(CancerSignAndSymptoms cancerSignAndSymptoms) {
		CancerSignAndSymptoms response = cancerSignAndSymptomsRepo.save(cancerSignAndSymptoms);
		return response;
	}

}
