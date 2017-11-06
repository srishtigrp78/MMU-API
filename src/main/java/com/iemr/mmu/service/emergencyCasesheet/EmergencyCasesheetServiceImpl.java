package com.iemr.mmu.service.emergencyCasesheet;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iemr.mmu.data.emergencyCasesheet.BenChiefComplaint;
import com.iemr.mmu.data.emergencyCasesheet.BenClinicalObservations;
import com.iemr.mmu.data.emergencyCasesheet.LabTestOrderDetail;
import com.iemr.mmu.data.emergencyCasesheet.PrescribedDrugDetail;
import com.iemr.mmu.data.emergencyCasesheet.PrescriptionDetail;
import com.iemr.mmu.repo.emergencyCasesheet.BenChiefComplaintRepo;
import com.iemr.mmu.repo.emergencyCasesheet.BenClinicalObservationsRepo;
import com.iemr.mmu.repo.emergencyCasesheet.LabTestOrderDetailRepo;
import com.iemr.mmu.repo.emergencyCasesheet.PrescribedDrugDetailRepo;
import com.iemr.mmu.repo.emergencyCasesheet.PrescriptionDetailRepo;

@Service
public class EmergencyCasesheetServiceImpl implements EmergencyCasesheetService{

	private BenChiefComplaintRepo benChiefComplaintRepo;
	private BenClinicalObservationsRepo benClinicalObservationsRepo;
	private PrescriptionDetailRepo prescriptionDetailRepo;
	private PrescribedDrugDetailRepo prescribedDrugDetailRepo;
	private LabTestOrderDetailRepo labTestOrderDetailRepo;
	
	public void setBenChiefComplaintRepo(BenChiefComplaintRepo benChiefComplaintRepo) {
		this.benChiefComplaintRepo = benChiefComplaintRepo;
	}
	
	public void setBenClinicalObservationsRepo(BenClinicalObservationsRepo benClinicalObservationsRepo) {
		this.benClinicalObservationsRepo = benClinicalObservationsRepo;
	}
	
	public void setPrescriptionDetailRepo(PrescriptionDetailRepo prescriptionDetailRepo) {
		this.prescriptionDetailRepo = prescriptionDetailRepo;
	}
	
	public void setPrescribedDrugDetailRepo(PrescribedDrugDetailRepo prescribedDrugDetailRepo) {
		this.prescribedDrugDetailRepo = prescribedDrugDetailRepo;
	}
	
	public void setLabTestOrderDetailRepo(LabTestOrderDetailRepo labTestOrderDetailRepo) {
		this.labTestOrderDetailRepo = labTestOrderDetailRepo;
	}
	
	@Override
	public Long saveBeneficiaryChiefComplaint(BenChiefComplaint benChiefComplaint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long saveBeneficiaryClinicalObservations(BenClinicalObservations benClinicalObservations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long saveBeneficiaryPrescription(PrescriptionDetail prescriptionDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long saveBeneficiaryPrescribedDrugDetail(PrescribedDrugDetail prescribedDrugDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long saveBeneficiaryLabTestOrderDetails(List<LabTestOrderDetail> labTestOrderDetail) {
		// TODO Auto-generated method stub
		return null;
	}

}
