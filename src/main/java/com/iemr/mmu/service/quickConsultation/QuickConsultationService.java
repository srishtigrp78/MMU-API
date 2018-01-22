package com.iemr.mmu.service.quickConsultation;

import com.google.gson.JsonObject;

public interface QuickConsultationService {

	public Long saveBeneficiaryChiefComplaint(JsonObject benChiefComplaint);

	public Long saveBeneficiaryClinicalObservations(JsonObject benClinicalObservations) throws Exception;

	public Long saveBeneficiaryPrescription(JsonObject prescriptionDetail) throws Exception;

	public Long saveBeneficiaryPrescribedDrugDetail(JsonObject prescribedDrugDetail, Long prescriptionID);

	public Long saveBeneficiaryLabTestOrderDetails(JsonObject labTestOrderDetail, Long prescriptionID);

	public Long saveBeneficiaryExternalLabTestOrderDetails(JsonObject externalLabTestOrderDetail);

	public Integer quickConsultNurseDataInsert(JsonObject jsnOBJ) throws Exception;

	public Integer quickConsultDoctorDataInsert(JsonObject quickConsultDoctorOBJ) throws Exception;
}
