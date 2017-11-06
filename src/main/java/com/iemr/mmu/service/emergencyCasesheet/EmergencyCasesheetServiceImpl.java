package com.iemr.mmu.service.emergencyCasesheet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.emergencyCasesheet.BenChiefComplaint;
import com.iemr.mmu.data.emergencyCasesheet.BenClinicalObservations;
import com.iemr.mmu.data.emergencyCasesheet.LabTestOrderDetail;
import com.iemr.mmu.data.emergencyCasesheet.PrescribedDrugDetail;
import com.iemr.mmu.data.emergencyCasesheet.PrescriptionDetail;
import com.iemr.mmu.data.emergencyCasesheet.WrapperEmergencyCaseSheet;
import com.iemr.mmu.repo.emergencyCasesheet.BenChiefComplaintRepo;
import com.iemr.mmu.repo.emergencyCasesheet.BenClinicalObservationsRepo;
import com.iemr.mmu.repo.emergencyCasesheet.LabTestOrderDetailRepo;
import com.iemr.mmu.repo.emergencyCasesheet.PrescribedDrugDetailRepo;
import com.iemr.mmu.repo.emergencyCasesheet.PrescriptionDetailRepo;
import com.iemr.utils.mapper.InputMapper;

@Service
public class EmergencyCasesheetServiceImpl implements EmergencyCasesheetService{

	private InputMapper inputMapper = new InputMapper();
	
	private BenChiefComplaintRepo benChiefComplaintRepo;
	private BenClinicalObservationsRepo benClinicalObservationsRepo;
	private PrescriptionDetailRepo prescriptionDetailRepo;
	private PrescribedDrugDetailRepo prescribedDrugDetailRepo;
	private LabTestOrderDetailRepo labTestOrderDetailRepo;
	
	@Autowired
	public void setBenChiefComplaintRepo(BenChiefComplaintRepo benChiefComplaintRepo) {
		this.benChiefComplaintRepo = benChiefComplaintRepo;
	}
	@Autowired
	public void setBenClinicalObservationsRepo(BenClinicalObservationsRepo benClinicalObservationsRepo) {
		this.benClinicalObservationsRepo = benClinicalObservationsRepo;
	}
	@Autowired
	public void setPrescriptionDetailRepo(PrescriptionDetailRepo prescriptionDetailRepo) {
		this.prescriptionDetailRepo = prescriptionDetailRepo;
	}
	@Autowired
	public void setPrescribedDrugDetailRepo(PrescribedDrugDetailRepo prescribedDrugDetailRepo) {
		this.prescribedDrugDetailRepo = prescribedDrugDetailRepo;
	}
	@Autowired
	public void setLabTestOrderDetailRepo(LabTestOrderDetailRepo labTestOrderDetailRepo) {
		this.labTestOrderDetailRepo = labTestOrderDetailRepo;
	}
	
	@Override
	public Long saveBeneficiaryChiefComplaint(JsonObject caseSheet) {
		ArrayList<BenChiefComplaint> benChiefComplaints = BenChiefComplaint.getBenChiefComplaintList(caseSheet);
		
		List<BenChiefComplaint> chiefComplaints = (List<BenChiefComplaint>) benChiefComplaintRepo.save(benChiefComplaints);
		if(null != chiefComplaints && chiefComplaints.size()>0){
			for (BenChiefComplaint chiefComplaint: chiefComplaints ){
				return chiefComplaint.getBenChiefComplaintID();
			}
		}
		
		return null;
	}

	@Override
	public Long saveBeneficiaryClinicalObservations(JsonObject caseSheet) {
		
		BenClinicalObservations benClinicalObservations = InputMapper.gson().fromJson(caseSheet,BenClinicalObservations.class);
		BenClinicalObservations benClinicalObservation = benClinicalObservationsRepo.save(benClinicalObservations);
		if(null != benClinicalObservation && benClinicalObservation.getClinicalObservationID()>0){
			return benClinicalObservation.getClinicalObservationID();
		}
		return null;
	}

	@Override
	public Long saveBeneficiaryPrescription(JsonObject caseSheet) {
		
		PrescriptionDetail prescriptionDetail = InputMapper.gson().fromJson(caseSheet,PrescriptionDetail.class);
		
		PrescriptionDetail prescription = prescriptionDetailRepo.save(prescriptionDetail);
		if(null != prescriptionDetail && prescriptionDetail.getPrescriptionID()>0){
			return prescriptionDetail.getPrescriptionID();
		}
		return null;
	}

	@Override
	public Long saveBeneficiaryPrescribedDrugDetail(JsonObject caseSheet, Long prescriptionID) {
		
		ArrayList<PrescribedDrugDetail> prescriptionDetails = PrescribedDrugDetail.getBenPrescribedDrugDetailList(caseSheet, prescriptionID);
		
		List<PrescribedDrugDetail> prescribedDrugs = (List<PrescribedDrugDetail>) prescribedDrugDetailRepo.save(prescriptionDetails);
		
		if(null != prescribedDrugs && prescribedDrugs.size()>0){
			for (PrescribedDrugDetail prescribedDrug: prescribedDrugs ){
				return prescribedDrug.getPrescribedDrugID();
			}
		}
		return null;
	}

	@Override
	public Long saveBeneficiaryLabTestOrderDetails(JsonObject caseSheet, Long prescriptionID) {
		
		ArrayList<LabTestOrderDetail> labTestOrderDetails = LabTestOrderDetail.getLabTestOrderDetailList(caseSheet, prescriptionID);
		
		List<LabTestOrderDetail> labTestOrders = (List<LabTestOrderDetail>) labTestOrderDetailRepo.save(labTestOrderDetails);
		
		if(null != labTestOrders && labTestOrders.size()>0){
			for (LabTestOrderDetail labTestOrder: labTestOrders ){
				return labTestOrder.getLabTestOrderID();
			}
		}
		
		return null;
	}

}
