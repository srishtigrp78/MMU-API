package com.iemr.mmu.service.quickConsultation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.data.quickConsultation.BenClinicalObservations;
import com.iemr.mmu.data.quickConsultation.ExternalLabTestOrder;
import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;
import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;
import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;
import com.iemr.mmu.repo.quickConsultation.BenChiefComplaintRepo;
import com.iemr.mmu.repo.quickConsultation.BenClinicalObservationsRepo;
import com.iemr.mmu.repo.quickConsultation.ExternalTestOrderRepo;
import com.iemr.mmu.repo.quickConsultation.LabTestOrderDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescribedDrugDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
import com.iemr.utils.mapper.InputMapper;

@Service
public class QuickConsultationServiceImpl implements QuickConsultationService {

	private InputMapper inputMapper = new InputMapper();

	private BenChiefComplaintRepo benChiefComplaintRepo;
	private BenClinicalObservationsRepo benClinicalObservationsRepo;
	private PrescriptionDetailRepo prescriptionDetailRepo;
	private PrescribedDrugDetailRepo prescribedDrugDetailRepo;
	private LabTestOrderDetailRepo labTestOrderDetailRepo;
	private ExternalTestOrderRepo externalTestOrderRepo;

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

	@Autowired
	public void setExternalTestOrderRepo(ExternalTestOrderRepo externalTestOrderRepo) {
		this.externalTestOrderRepo = externalTestOrderRepo;
	}

	@Override
	public Long saveBeneficiaryChiefComplaint(JsonObject caseSheet) {
		ArrayList<BenChiefComplaint> benChiefComplaints = BenChiefComplaint.getBenChiefComplaintList(caseSheet);

		List<BenChiefComplaint> chiefComplaints = (List<BenChiefComplaint>) benChiefComplaintRepo
				.save(benChiefComplaints);
		if (null != chiefComplaints && chiefComplaints.size() > 0) {
			for (BenChiefComplaint chiefComplaint : chiefComplaints) {
				return chiefComplaint.getBenChiefComplaintID();
			}
		}

		return null;
	}

	@Override
	public Long saveBeneficiaryClinicalObservations(JsonObject caseSheet) {

		BenClinicalObservations benClinicalObservations = InputMapper.gson().fromJson(caseSheet,
				BenClinicalObservations.class);
		BenClinicalObservations benClinicalObservation = benClinicalObservationsRepo.save(benClinicalObservations);
		if (null != benClinicalObservation && benClinicalObservation.getClinicalObservationID() > 0) {
			return benClinicalObservation.getClinicalObservationID();
		}
		return null;
	}

	@Override
	public Long saveBeneficiaryPrescription(JsonObject caseSheet) {

		PrescriptionDetail prescriptionDetail = InputMapper.gson().fromJson(caseSheet, PrescriptionDetail.class);

		PrescriptionDetail prescription = prescriptionDetailRepo.save(prescriptionDetail);
		if (null != prescriptionDetail && prescriptionDetail.getPrescriptionID() > 0) {
			return prescriptionDetail.getPrescriptionID();
		}
		return null;
	}

	// Prescription for ANC...
	public Long saveBenPrescriptionForANC(PrescriptionDetail prescription) {
		Long r = null;
		PrescriptionDetail prescriptionRS = prescriptionDetailRepo.save(prescription);
		if (prescriptionRS != null && prescriptionRS.getPrescriptionID() > 0) {
			r = prescriptionRS.getPrescriptionID();
		}
		return r;
	}

	@Override
	public Long saveBeneficiaryPrescribedDrugDetail(JsonObject caseSheet, Long prescriptionID) {

		ArrayList<PrescribedDrugDetail> prescriptionDetails = PrescribedDrugDetail
				.getBenPrescribedDrugDetailList(caseSheet, prescriptionID);

		List<PrescribedDrugDetail> prescribedDrugs = (List<PrescribedDrugDetail>) prescribedDrugDetailRepo
				.save(prescriptionDetails);

		if (null != prescribedDrugs && prescribedDrugs.size() > 0) {
			for (PrescribedDrugDetail prescribedDrug : prescribedDrugs) {
				return prescribedDrug.getPrescribedDrugID();
			}
		}
		return null;
	}

	@Override
	public Long saveBeneficiaryLabTestOrderDetails(JsonObject caseSheet, Long prescriptionID) {

		ArrayList<LabTestOrderDetail> labTestOrderDetails = LabTestOrderDetail.getLabTestOrderDetailList(caseSheet,
				prescriptionID);

		List<LabTestOrderDetail> labTestOrders = (List<LabTestOrderDetail>) labTestOrderDetailRepo
				.save(labTestOrderDetails);

		if (null != labTestOrders && labTestOrders.size() >= 0) {
			for (LabTestOrderDetail labTestOrder : labTestOrders) {
				return labTestOrder.getLabTestOrderID();
			}
		}

		return null;
	}

	@Override
	public Long saveBeneficiaryExternalLabTestOrderDetails(JsonObject caseSheet) {

		ExternalLabTestOrder externalLabTestOrder = ExternalLabTestOrder.getExternalLabTestOrderList(caseSheet);
		ExternalLabTestOrder externalTestOrder = externalTestOrderRepo.save(externalLabTestOrder);

		if (null != externalTestOrder && externalTestOrder.getExternalTestOrderID() > 0) {
			return externalTestOrder.getExternalTestOrderID();
		}
		return null;
	}

}
