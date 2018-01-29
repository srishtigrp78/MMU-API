package com.iemr.mmu.service.cancerScreening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.repo.doctor.CancerDiagnosisRepo;

@Service
public class CSOncologistServiceImpl implements CSOncologistService {
	
	private CancerDiagnosisRepo cancerDiagnosisRepo;
	
	@Autowired
	public void setCancerDiagnosisRepo(CancerDiagnosisRepo cancerDiagnosisRepo) {
		this.cancerDiagnosisRepo = cancerDiagnosisRepo;
	}
	
	@Override
	public int updateCancerDiagnosisDetailsByOncologist(CancerDiagnosis cancerDiagnosis) {
		int response = 0;
		try {
			response = cancerDiagnosisRepo.updateDetailsByOncologist(cancerDiagnosis.getProvisionalDiagnosisOncologist(), 
					cancerDiagnosis.getBeneficiaryRegID(), cancerDiagnosis.getBenVisitID(), cancerDiagnosis.getModifiedBy());

		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}
}
