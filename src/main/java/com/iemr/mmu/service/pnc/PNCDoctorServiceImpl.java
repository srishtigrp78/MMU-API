package com.iemr.mmu.service.pnc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.pnc.PNCDiagnosis;
import com.iemr.mmu.repo.nurse.pnc.PNCDiagnosisRepo;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
import com.iemr.mmu.utils.exception.IEMRException;
import com.iemr.mmu.utils.mapper.InputMapper;

@Service
public class PNCDoctorServiceImpl implements PNCDoctorService {

	private PNCDiagnosisRepo pncDiagnosisRepo;
	private PrescriptionDetailRepo prescriptionDetailRepo;

	@Autowired
	public void setPrescriptionDetailRepo(PrescriptionDetailRepo prescriptionDetailRepo) {
		this.prescriptionDetailRepo = prescriptionDetailRepo;
	}

	@Autowired
	public void setPncDiagnosisRepo(PNCDiagnosisRepo pncDiagnosisRepo) {
		this.pncDiagnosisRepo = pncDiagnosisRepo;
	}

	public Long saveBenPNCDiagnosis(JsonObject obj, Long prescriptionID) throws IEMRException {
		Long ID = null;
		PNCDiagnosis pncDiagnosis = InputMapper.gson().fromJson(obj, PNCDiagnosis.class);
		pncDiagnosis.setPrescriptionID(prescriptionID);

		PNCDiagnosis res = pncDiagnosisRepo.save(pncDiagnosis);
		if (null != res && res.getID() > 0) {
			ID = res.getID();
		}
		return ID;
	}

	public String getPNCDiagnosisDetails(Long beneficiaryRegID, Long visitCode) {
		String externalInvestigation = prescriptionDetailRepo.getExternalinvestigationForVisitCode(beneficiaryRegID,
				visitCode);
		ArrayList<Object[]> resList = pncDiagnosisRepo.getPNCDiagnosisDetails(beneficiaryRegID, visitCode);
		PNCDiagnosis pncDiagnosisDetails = PNCDiagnosis.getPNCDiagnosisDetails(resList);
		if (externalInvestigation != null)
			pncDiagnosisDetails.setExternalInvestigation(externalInvestigation);
		return new Gson().toJson(pncDiagnosisDetails);
	}

	public int updateBenPNCDiagnosis(PNCDiagnosis pncDiagnosis, Long prescriptionID) throws IEMRException {
		int res = 0;
		int recordsAvailable = 0;
		String processed = pncDiagnosisRepo.getPNCDiagnosisStatus(pncDiagnosis.getBeneficiaryRegID(),
				pncDiagnosis.getVisitCode());

		if (null != processed) {
			recordsAvailable = 1;
		}

		if (null != processed && !processed.equals("N")) {
			processed = "U";
		} else {
			processed = "N";
		}
		if (recordsAvailable > 0) {
			pncDiagnosis.setModifiedBy(pncDiagnosis.getCreatedBy());
			res = pncDiagnosisRepo.updatePNCDiagnosis(pncDiagnosis.getProvisionalDiagnosis(),
					pncDiagnosis.getConfirmatoryDiagnosis(), pncDiagnosis.getIsMaternalDeath(),
					pncDiagnosis.getPlaceOfDeath(), pncDiagnosis.getDateOfDeath(), pncDiagnosis.getCauseOfDeath(),
					pncDiagnosis.getModifiedBy(), processed, pncDiagnosis.getBeneficiaryRegID(),
					pncDiagnosis.getVisitCode());
		} else {
			pncDiagnosis.setPrescriptionID(prescriptionID);
			PNCDiagnosis pncDiagnosisRes = pncDiagnosisRepo.save(pncDiagnosis);
			if (null != pncDiagnosisRes && pncDiagnosisRes.getID() > 0) {
				res = 1;
			}

		}

		return res;
	}
}
