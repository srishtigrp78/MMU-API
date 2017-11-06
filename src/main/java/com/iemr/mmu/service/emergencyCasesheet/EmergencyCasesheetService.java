package com.iemr.mmu.service.emergencyCasesheet;

import java.util.List;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.emergencyCasesheet.BenChiefComplaint;
import com.iemr.mmu.data.emergencyCasesheet.BenClinicalObservations;
import com.iemr.mmu.data.emergencyCasesheet.LabTestOrderDetail;
import com.iemr.mmu.data.emergencyCasesheet.PrescribedDrugDetail;
import com.iemr.mmu.data.emergencyCasesheet.PrescriptionDetail;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;

public interface EmergencyCasesheetService {
	
	public Long saveBeneficiaryChiefComplaint(JsonObject benChiefComplaint);
		
	public Long saveBeneficiaryClinicalObservations(JsonObject benClinicalObservations);
	
	public Long saveBeneficiaryPrescription(JsonObject prescriptionDetail);
	
	public Long saveBeneficiaryPrescribedDrugDetail(JsonObject prescribedDrugDetail, Long prescriptionID);
	
	public Long saveBeneficiaryLabTestOrderDetails(JsonObject labTestOrderDetail, Long prescriptionID);
}
