package com.iemr.mmu.service.quickConsultation;

import java.util.List;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.data.quickConsultation.BenClinicalObservations;
import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;
import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;
import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;

public interface QuickConsultationService {
	
	public Long saveBeneficiaryChiefComplaint(JsonObject benChiefComplaint);
		
	public Long saveBeneficiaryClinicalObservations(JsonObject benClinicalObservations);
	
	public Long saveBeneficiaryPrescription(JsonObject prescriptionDetail);
	
	public Long saveBeneficiaryPrescribedDrugDetail(JsonObject prescribedDrugDetail, Long prescriptionID);
	
	public Long saveBeneficiaryLabTestOrderDetails(JsonObject labTestOrderDetail, Long prescriptionID);
	
	public Long saveBeneficiaryExternalLabTestOrderDetails(JsonObject externalLabTestOrderDetail);
}
