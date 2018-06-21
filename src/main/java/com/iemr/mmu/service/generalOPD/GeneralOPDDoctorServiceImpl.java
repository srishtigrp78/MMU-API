package com.iemr.mmu.service.generalOPD;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.anc.ANCDiagnosis;
import com.iemr.mmu.data.anc.WrapperBenInvestigationANC;
import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;
import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
import com.iemr.mmu.utils.exception.IEMRException;
import com.iemr.mmu.utils.mapper.InputMapper;

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

	public String getGeneralOPDDiagnosisDetails(Long beneficiaryRegID, Long visitCode) {
		ArrayList<Object[]> diagnosisDetails = prescriptionDetailRepo.getGeneralOPDDiagnosisDetails(beneficiaryRegID,
				visitCode);
		PrescriptionDetail diagnosisList = PrescriptionDetail.getGeneralOPDDiagnosis(diagnosisDetails);

		return new Gson().toJson(diagnosisList);
	}

	public int updateBenGeneralOPDDiagnosis(PrescriptionDetail prescription) throws Exception {
		int res = 0;
		int recordsAvailable = 0;
		String processed = prescriptionDetailRepo.getGeneralOPDDiagnosisStatus(prescription.getBeneficiaryRegID(),
				prescription.getVisitCode(), prescription.getPrescriptionID());

		if (null != processed) {
			recordsAvailable = 1;
		}

		if (null != processed && !processed.equals("N")) {
			processed = "U";
		} else {
			processed = "N";
		}
		if (recordsAvailable > 0) {
			prescription.setModifiedBy(prescription.getCreatedBy());
			res = prescriptionDetailRepo.updateGeneralOPDDiagnosis(prescription.getDiagnosisProvided(),
					prescription.getInstruction(), prescription.getModifiedBy(), processed,
					prescription.getBeneficiaryRegID(), prescription.getVisitCode(), prescription.getPrescriptionID());
		}
		return res;
	}
}
