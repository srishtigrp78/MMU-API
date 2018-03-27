package com.iemr.mmu.service.ncdCare;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
