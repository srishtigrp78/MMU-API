package com.iemr.mmu.service.ncdCare;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.ncdcare.NCDCareDiagnosis;
import com.iemr.mmu.repo.nurse.ncdcare.NCDCareDiagnosisRepo;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
import com.iemr.mmu.utils.exception.IEMRException;

@Service
public class NCDCareDoctorServiceImpl implements NCDCareDoctorService {
	private NCDCareDiagnosisRepo ncdCareDiagnosisRepo;
	private PrescriptionDetailRepo prescriptionDetailRepo;

	@Autowired
	public void setPrescriptionDetailRepo(PrescriptionDetailRepo prescriptionDetailRepo) {
		this.prescriptionDetailRepo = prescriptionDetailRepo;
	}

	@Autowired
	public void setNcdCareDiagnosisRepo(NCDCareDiagnosisRepo ncdCareDiagnosisRepo) {
		this.ncdCareDiagnosisRepo = ncdCareDiagnosisRepo;
	}

	public long saveNCDDiagnosisData(NCDCareDiagnosis ncdDiagnosis) {
		long res = 0;

		if (ncdDiagnosis.getNcdScreeningConditionArray() != null
				&& ncdDiagnosis.getNcdScreeningConditionArray().length > 0) {
			StringBuilder sb = new StringBuilder();
			for (String s : ncdDiagnosis.getNcdScreeningConditionArray()) {
				sb.append(s).append("||");
			}
			ncdDiagnosis.setNcdScreeningCondition((sb.delete((sb.length() - 2), (sb.length()))).toString());
		} else
			ncdDiagnosis.setNcdScreeningCondition(null);

		NCDCareDiagnosis diagnosis = ncdCareDiagnosisRepo.save(ncdDiagnosis);
		if (null != diagnosis) {
			res = diagnosis.getID();
		}
		return res;
	}

	public String getNCDCareDiagnosisDetails(Long beneficiaryRegID, Long visitCode) {
		String externalInvestigation = prescriptionDetailRepo.getExternalinvestigationForVisitCode(beneficiaryRegID,
				visitCode);
		ArrayList<Object[]> resList = ncdCareDiagnosisRepo.getNCDCareDiagnosisDetails(beneficiaryRegID, visitCode);
		NCDCareDiagnosis ncdCareDiagnosisDetails = NCDCareDiagnosis.getNCDCareDiagnosisDetails(resList);

		// 07-09-2021 parsing the || seperated ncd_condition to array of string, if
		// condition
		// 07-09-2021

		if (ncdCareDiagnosisDetails != null && ncdCareDiagnosisDetails.getNcdScreeningCondition() != null
				&& ncdCareDiagnosisDetails.getNcdScreeningCondition().length() > 0) {

			String[] ncdConditionArr = ncdCareDiagnosisDetails.getNcdScreeningCondition().split(Pattern.quote("||"));
			if (ncdConditionArr != null)
				ncdCareDiagnosisDetails.setNcdScreeningConditionArray(ncdConditionArr);
		}

		if (externalInvestigation != null)
			ncdCareDiagnosisDetails.setExternalInvestigation(externalInvestigation);
		return new Gson().toJson(ncdCareDiagnosisDetails);
	}

	public int updateBenNCDCareDiagnosis(NCDCareDiagnosis ncdCareDiagnosis) throws IEMRException {
		int res = 0;
		String processed = ncdCareDiagnosisRepo.getNCDCareDiagnosisStatus(ncdCareDiagnosis.getBeneficiaryRegID(),
				ncdCareDiagnosis.getVisitCode(), ncdCareDiagnosis.getPrescriptionID());

		if (null != processed && !processed.equals("N")) {
			processed = "U";
		}

		if (ncdCareDiagnosis.getNcdScreeningConditionArray() != null
				&& ncdCareDiagnosis.getNcdScreeningConditionArray().length > 0) {
			StringBuilder sb = new StringBuilder();
			for (String s : ncdCareDiagnosis.getNcdScreeningConditionArray()) {
				sb.append(s).append("||");
			}
			ncdCareDiagnosis.setNcdScreeningCondition((sb.delete((sb.length() - 2), (sb.length()))).toString());
		} else
			ncdCareDiagnosis.setNcdScreeningCondition(null);

		// ncdCareDiagnosis.setProcessed(processed);
		if (processed != null) {
			// 07-09-2021, moved below line from outside if block to inside for null check
			ncdCareDiagnosis.setProcessed(processed);
			res = ncdCareDiagnosisRepo.updateNCDCareDiagnosis(ncdCareDiagnosis.getNcdCareCondition(),
					ncdCareDiagnosis.getNcdComplication(), ncdCareDiagnosis.getNcdCareType(),
					ncdCareDiagnosis.getCreatedBy(), ncdCareDiagnosis.getProcessed(),
					ncdCareDiagnosis.getBeneficiaryRegID(), ncdCareDiagnosis.getVisitCode(),
					ncdCareDiagnosis.getPrescriptionID());
		} else {
			NCDCareDiagnosis ncdCareDiagnosisRes = ncdCareDiagnosisRepo.save(ncdCareDiagnosis);
			if (null != ncdCareDiagnosisRes && ncdCareDiagnosisRes.getID() > 0) {
				res = 1;
			}
		}

		return res;
	}
}
