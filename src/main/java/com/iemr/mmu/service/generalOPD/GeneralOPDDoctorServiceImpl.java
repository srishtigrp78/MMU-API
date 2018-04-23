package com.iemr.mmu.service.generalOPD;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.anc.WrapperBenInvestigationANC;
import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;
import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;

/***
 * 
 * @author NE298657
 *
 */
@Service
public class GeneralOPDDoctorServiceImpl implements GeneralOPDDoctorService {
	
	private PrescriptionDetailRepo prescriptionDetailRepo;
	
	@Autowired
	public void setPrescriptionDetailRepo(PrescriptionDetailRepo prescriptionDetailRepo) {
		this.prescriptionDetailRepo = prescriptionDetailRepo;
	}
	
	public String getGeneralOPDDiagnosisDetails(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> diagnosisDetails = prescriptionDetailRepo.getGeneralOPDDiagnosisDetails(beneficiaryRegID, benVisitID);
		PrescriptionDetail diagnosisList = PrescriptionDetail.getGeneralOPDDiagnosis(diagnosisDetails);

		return new Gson().toJson(diagnosisList);
	}
}
