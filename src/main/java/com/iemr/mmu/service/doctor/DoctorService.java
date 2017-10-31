package com.iemr.mmu.service.doctor;

import java.util.List;

import com.iemr.mmu.data.doctor.CancerAbdominalExamination;
import com.iemr.mmu.data.doctor.CancerBreastExamination;
import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.data.doctor.CancerGynecologicalExamination;
import com.iemr.mmu.data.doctor.CancerLymphNodeDetails;
import com.iemr.mmu.data.doctor.CancerOralExamination;
import com.iemr.mmu.data.doctor.CancerSignAndSymptoms;

public interface DoctorService {

	public Long saveCancerAbdominalExaminationData(CancerAbdominalExamination cancerAbdominalExamination);

	public Long saveCancerBreastExaminationData(CancerBreastExamination cancerBreastExamination);

	public Long saveCancerDiagnosisData(CancerDiagnosis cancerDiagnosis);

	public Long saveCancerGynecologicalExaminationData(CancerGynecologicalExamination cancerGynecologicalExamination);

	public int saveLymphNodeDetails(List<CancerLymphNodeDetails> cancerLymphNodeDetails);

	public Long saveCancerOralExaminationData(CancerOralExamination cancerOralExamination);

	public Long saveCancerSignAndSymptomsData(CancerSignAndSymptoms cancerSignAndSymptoms);

	public String updateBenStatus(Long benVisitID, String c);
}
