package com.iemr.mmu.service.emergencyCasesheet;

import java.util.List;

import com.iemr.mmu.data.emergencyCasesheet.BenChiefComplaint;
import com.iemr.mmu.data.emergencyCasesheet.BenClinicalObservations;
import com.iemr.mmu.data.emergencyCasesheet.LabTestOrderDetail;
import com.iemr.mmu.data.emergencyCasesheet.PrescribedDrugDetail;
import com.iemr.mmu.data.emergencyCasesheet.PrescriptionDetail;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;

public interface EmergencyCasesheetService {
	
	public Long saveBeneficiaryChiefComplaint(BenChiefComplaint benChiefComplaint);
		
	public Long saveBeneficiaryClinicalObservations(BenClinicalObservations benClinicalObservations);
	
	public Long saveBeneficiaryPrescription(PrescriptionDetail prescriptionDetail);
	
	public Long saveBeneficiaryPrescribedDrugDetail(PrescribedDrugDetail prescribedDrugDetail);
	
	public Long saveBeneficiaryLabTestOrderDetails(List<LabTestOrderDetail> labTestOrderDetail);
}
