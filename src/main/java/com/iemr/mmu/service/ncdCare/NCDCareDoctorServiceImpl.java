package com.iemr.mmu.service.ncdCare;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.anc.ANCDiagnosis;
import com.iemr.mmu.data.ncdcare.NCDCareDiagnosis;
import com.iemr.mmu.repo.nurse.ncdcare.NCDCareDiagnosisRepo;

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
}
