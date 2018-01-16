package com.iemr.mmu.service.quickConsultation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.data.quickConsultation.BenClinicalObservations;
import com.iemr.mmu.data.quickConsultation.ExternalLabTestOrder;
import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;
import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;
import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;
import com.iemr.mmu.repo.quickConsultation.BenChiefComplaintRepo;
import com.iemr.mmu.repo.quickConsultation.BenClinicalObservationsRepo;
import com.iemr.mmu.repo.quickConsultation.ExternalTestOrderRepo;
import com.iemr.mmu.repo.quickConsultation.LabTestOrderDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescribedDrugDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
import com.iemr.mmu.service.doctor.DoctorServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.mapper.InputMapper;

@Service
public class QuickConsultationServiceImpl implements QuickConsultationService {
	private BenChiefComplaintRepo benChiefComplaintRepo;
	private BenClinicalObservationsRepo benClinicalObservationsRepo;
	private PrescriptionDetailRepo prescriptionDetailRepo;
	private PrescribedDrugDetailRepo prescribedDrugDetailRepo;
	private LabTestOrderDetailRepo labTestOrderDetailRepo;
	private ExternalTestOrderRepo externalTestOrderRepo;
	private NurseServiceImpl nurseServiceImpl;
	private DoctorServiceImpl doctorServiceImpl;
	private BenVisitDetailRepo benVisitDetailRepo;

	@Autowired
	public void setBeneficiaryVisitDetail(BenVisitDetailRepo benVisitDetailRepo) {
		this.benVisitDetailRepo = benVisitDetailRepo;
	}

	@Autowired
	public void setDoctorServiceImpl(DoctorServiceImpl doctorServiceImpl) {
		this.doctorServiceImpl = doctorServiceImpl;
	}

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

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
		if (null != prescription && prescription.getPrescriptionID() > 0) {
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

	@Override
	public Integer quickConsultNurseDataInsert(JsonObject jsnOBJ) {
		Integer returnOBJ = 0;
		BeneficiaryVisitDetail benVisitDetailsOBJ = InputMapper.gson().fromJson(jsnOBJ.get("visitDetails"),
				BeneficiaryVisitDetail.class);
		Long benVisitID = nurseServiceImpl.saveBeneficiaryVisitDetails(benVisitDetailsOBJ);

		if (benVisitID != null && benVisitID > 0) {
			BenAnthropometryDetail benAnthropometryDetail = InputMapper.gson().fromJson(jsnOBJ.get("vitalsDetails"),
					BenAnthropometryDetail.class);
			benAnthropometryDetail.setBenVisitID(benVisitID);
			Long benAnthropometryID = nurseServiceImpl
					.saveBeneficiaryPhysicalAnthropometryDetails(benAnthropometryDetail);
			BenPhysicalVitalDetail benPhysicalVitalDetail = InputMapper.gson().fromJson(jsnOBJ.get("vitalsDetails"),
					BenPhysicalVitalDetail.class);
			benPhysicalVitalDetail.setBenVisitID(benVisitID);
			Long benPhysicalVitalID = nurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(benPhysicalVitalDetail);
			if (benAnthropometryID != null && benAnthropometryID > 0 && benPhysicalVitalID != null
					&& benPhysicalVitalID > 0) {
				Integer i = nurseServiceImpl.updateBeneficiaryStatus('N', benVisitDetailsOBJ.getBeneficiaryRegID());
				returnOBJ = 1;

			} else {

			}
		} else {
			// Error in beneficiary visit creation...
		}
		return returnOBJ;
	}

	@Override
	public Integer quickConsultDoctorDataInsert(JsonObject quickConsultDoctorOBJ){
		Integer returnOBJ = 0;
		Long benChiefComplaintID = saveBeneficiaryChiefComplaint(quickConsultDoctorOBJ);
		Long clinicalObservationID = saveBeneficiaryClinicalObservations(quickConsultDoctorOBJ);
		Long prescriptionID = saveBeneficiaryPrescription(quickConsultDoctorOBJ);

		Long prescribedDrugID = null;
		Long labTestOrderID = null;

		if (prescriptionID != null && prescriptionID > 0) {

			prescribedDrugID = saveBeneficiaryPrescribedDrugDetail(quickConsultDoctorOBJ, prescriptionID);

			labTestOrderID = saveBeneficiaryLabTestOrderDetails(quickConsultDoctorOBJ, prescriptionID);

		}
		if ((null != benChiefComplaintID && benChiefComplaintID > 0)
				&& (null != clinicalObservationID && clinicalObservationID > 0)
				&& (prescriptionID != null && prescriptionID > 0)) {
			if (quickConsultDoctorOBJ.has("benVisitID") && !quickConsultDoctorOBJ.get("benVisitID").isJsonNull()) {
				Integer i = benVisitDetailRepo.updateBenFlowStatus("D",quickConsultDoctorOBJ.get("benVisitID").getAsLong());
			}
			returnOBJ = 1;
		}
		return returnOBJ;
	}

}
