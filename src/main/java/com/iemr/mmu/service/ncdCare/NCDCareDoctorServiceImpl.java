package com.iemr.mmu.service.ncdCare;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.anc.ANCDiagnosis;
import com.iemr.mmu.data.ncdcare.NCDCareDiagnosis;
import com.iemr.mmu.repo.nurse.ncdcare.NCDCareDiagnosisRepo;
import com.iemr.mmu.utils.exception.IEMRException;
import com.iemr.mmu.utils.mapper.InputMapper;

@Service
public class NCDCareDoctorServiceImpl implements NCDCareDoctorService
{
	private NCDCareDiagnosisRepo ncdCareDiagnosisRepo;

	@Autowired
	public void setNcdCareDiagnosisRepo(NCDCareDiagnosisRepo ncdCareDiagnosisRepo)
	{
		this.ncdCareDiagnosisRepo = ncdCareDiagnosisRepo;
	}
	
	public long saveNCDDiagnosisData(NCDCareDiagnosis ncdDiagnosis){
		long res = 0;
		
		NCDCareDiagnosis diagnosis = ncdCareDiagnosisRepo.save(ncdDiagnosis);
		if(null!= diagnosis){
			res = diagnosis.getID();
		}
		return res;
	}
	
	public String getNCDCareDiagnosisDetails(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> resList = ncdCareDiagnosisRepo.getNCDCareDiagnosisDetails(beneficiaryRegID, benVisitID);
		NCDCareDiagnosis ncdCareDiagnosisDetails = NCDCareDiagnosis.getNCDCareDiagnosisDetails(resList);
		return new Gson().toJson(ncdCareDiagnosisDetails);
	}
	
	public int updateBenNCDCareDiagnosis(NCDCareDiagnosis ncdCareDiagnosis, Long prescriptionID) throws IEMRException {
		int res = 0;
		int recordsAvailable = 0;
		String processed = ncdCareDiagnosisRepo.getNCDCareDiagnosisStatus(ncdCareDiagnosis.getBeneficiaryRegID(), ncdCareDiagnosis.getBenVisitID());
		
		if (null != processed) {
			recordsAvailable = 1;
		}
		
		if (null != processed && !processed.equals("N")) {
			processed = "U";
		} else {
			processed = "N";
		}
		if(recordsAvailable>0){
			ncdCareDiagnosis.setModifiedBy(ncdCareDiagnosis.getCreatedBy());
			res = ncdCareDiagnosisRepo.updateNCDCareDiagnosis(ncdCareDiagnosis.getNcdCareCondition(), ncdCareDiagnosis.getNcdComplication(), 
					ncdCareDiagnosis.getNcdCareType(), ncdCareDiagnosis.getModifiedBy(), processed, ncdCareDiagnosis.getBeneficiaryRegID(), 
					ncdCareDiagnosis.getBenVisitID(), ncdCareDiagnosis.getPrescriptionID());
		}else{
			ncdCareDiagnosis.setPrescriptionID(prescriptionID);
			NCDCareDiagnosis ncdCareDiagnosisRes  = ncdCareDiagnosisRepo.save(ncdCareDiagnosis);
			if(null != ncdCareDiagnosisRes && ncdCareDiagnosisRes.getID()>0){
				res = 1;
			}
		}
		
		return res;
	}
}
