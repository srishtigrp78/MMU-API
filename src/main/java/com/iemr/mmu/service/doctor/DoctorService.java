package com.iemr.mmu.service.doctor;

import java.util.List;

import com.iemr.mmu.data.doctor.CancerAbdominalExamination;
import com.iemr.mmu.data.doctor.CancerBreastExamination;
import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.data.doctor.CancerGynecologicalExamination;
import com.iemr.mmu.data.doctor.CancerLymphNodeDetails;
import com.iemr.mmu.data.doctor.CancerOralExamination;
import com.iemr.mmu.data.doctor.CancerSignAndSymptoms;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;

public interface DoctorService {
	
	public CancerAbdominalExamination saveCancerAbdominalExaminationData(CancerAbdominalExamination cancerAbdominalExamination);
	
	public CancerBreastExamination saveCancerBreastExaminationData(CancerBreastExamination cancerBreastExamination);
	
	public CancerDiagnosis saveCancerDiagnosisData(CancerDiagnosis cancerDiagnosis);
	
	public CancerGynecologicalExamination saveCancerGynecologicalExaminationData(CancerGynecologicalExamination cancerGynecologicalExamination);
	
	public int saveLymphNodeDetails(List<CancerLymphNodeDetails> cancerLymphNodeDetails);
	
	public CancerOralExamination saveCancerOralExaminationData(CancerOralExamination cancerOralExamination);
	
	public CancerSignAndSymptoms saveCancerSignAndSymptomsData(CancerSignAndSymptoms cancerSignAndSymptoms);
}
