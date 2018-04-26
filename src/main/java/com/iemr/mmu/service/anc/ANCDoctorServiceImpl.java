package com.iemr.mmu.service.anc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.anc.ANCCareDetails;
import com.iemr.mmu.data.anc.ANCDiagnosis;
import com.iemr.mmu.data.anc.WrapperAncFindings;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.data.quickConsultation.BenClinicalObservations;
import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;
import com.iemr.mmu.repo.nurse.anc.ANCDiagnosisRepo;
import com.iemr.mmu.repo.quickConsultation.BenChiefComplaintRepo;
import com.iemr.mmu.repo.quickConsultation.BenClinicalObservationsRepo;
import com.iemr.mmu.repo.quickConsultation.LabTestOrderDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescribedDrugDetailRepo;
import com.iemr.mmu.service.doctor.DoctorServiceImpl;
import com.iemr.mmu.utils.exception.IEMRException;
import com.iemr.mmu.utils.mapper.InputMapper;

@Service
public class ANCDoctorServiceImpl implements ANCDoctorService {
	private BenClinicalObservationsRepo benClinicalObservationsRepo;
	private BenChiefComplaintRepo benChiefComplaintRepo;
	private ANCDiagnosisRepo ancDiagnosisRepo;
	private LabTestOrderDetailRepo labTestOrderDetailRepo;
	private PrescribedDrugDetailRepo prescribedDrugDetailRepo;

	private DoctorServiceImpl doctorServiceImpl;

	@Autowired
	public void setDoctorServiceImpl(DoctorServiceImpl doctorServiceImpl) {
		this.doctorServiceImpl = doctorServiceImpl;
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
	public void setAncDiagnosisRepo(ANCDiagnosisRepo ancDiagnosisRepo) {
		this.ancDiagnosisRepo = ancDiagnosisRepo;
	}

	@Autowired
	public void setBenClinicalObservationsRepo(BenClinicalObservationsRepo benClinicalObservationsRepo) {
		this.benClinicalObservationsRepo = benClinicalObservationsRepo;
	}

	@Autowired
	public void setBenChiefComplaintRepo(BenChiefComplaintRepo benChiefComplaintRepo) {
		this.benChiefComplaintRepo = benChiefComplaintRepo;
	}

	/* Method Moved to common service, Can remove from here */
	public Integer saveANCFindings(JsonObject obj) throws Exception {
		WrapperAncFindings wrapperAncFindings = InputMapper.gson().fromJson(obj, WrapperAncFindings.class);
		return saveAncDocFindings(wrapperAncFindings);

	}

	/* Method Moved to common service, Can remove from here */
	public Integer saveAncDocFindings(WrapperAncFindings wrapperAncFindings) {
		int i = 0;
		BenClinicalObservations benClinicalObservationsRS = benClinicalObservationsRepo
				.save(getBenClinicalObservations(wrapperAncFindings));

		ArrayList<BenChiefComplaint> tmpBenCHiefComplaints = getBenChiefComplaint(wrapperAncFindings);
		if (tmpBenCHiefComplaints.size() > 0) {
			ArrayList<BenChiefComplaint> benChiefComplaintListRS = (ArrayList<BenChiefComplaint>) benChiefComplaintRepo
					.save(tmpBenCHiefComplaints);
		}
		if (benClinicalObservationsRS != null) {
			i = 1;

		}
		return i;
	}

	/* Method Moved to common service, Can remove from here */
	private BenClinicalObservations getBenClinicalObservations(WrapperAncFindings wrapperAncFindings) {
		BenClinicalObservations benClinicalObservations = new BenClinicalObservations();
		benClinicalObservations.setBeneficiaryRegID(wrapperAncFindings.getBeneficiaryRegID());
		benClinicalObservations.setBenVisitID(wrapperAncFindings.getBenVisitID());
		benClinicalObservations.setProviderServiceMapID(wrapperAncFindings.getProviderServiceMapID());
		benClinicalObservations.setCreatedBy(wrapperAncFindings.getCreatedBy());
		benClinicalObservations.setClinicalObservation(wrapperAncFindings.getClinicalObservation());
		benClinicalObservations.setOtherSymptoms(wrapperAncFindings.getOtherSymptoms());

		return benClinicalObservations;
	}

	/* Method Moved to common service, Can remove from here */
	@Deprecated
	private ArrayList<BenChiefComplaint> getBenChiefComplaint(WrapperAncFindings wrapperAncFindings) {
		ArrayList<BenChiefComplaint> benChiefComplaintList = new ArrayList<>();
		BenChiefComplaint benChiefComplaint;
		if (wrapperAncFindings != null && wrapperAncFindings.getComplaints() != null
				&& wrapperAncFindings.getComplaints().size() > 0) {
			for (BenChiefComplaint complaintsDetails : wrapperAncFindings.getComplaints()) {
				benChiefComplaint = new BenChiefComplaint();
				benChiefComplaint.setBeneficiaryRegID(wrapperAncFindings.getBeneficiaryRegID());
				benChiefComplaint.setBenVisitID(wrapperAncFindings.getBenVisitID());
				benChiefComplaint.setProviderServiceMapID(wrapperAncFindings.getProviderServiceMapID());
				benChiefComplaint.setCreatedBy(wrapperAncFindings.getCreatedBy());

				if (null != complaintsDetails.getChiefComplaintID()) {
					/*
					 * Double d = (Double)
					 * complaintsDetails.getChiefComplaintID(); if (d == null)
					 * continue;
					 */
					benChiefComplaint.setChiefComplaintID(complaintsDetails.getChiefComplaintID());
				}
				if (null != complaintsDetails.getChiefComplaint())
					benChiefComplaint.setChiefComplaint(complaintsDetails.getChiefComplaint());
				if (null != complaintsDetails.getDuration())
					benChiefComplaint.setDuration(complaintsDetails.getDuration());
				if (null != complaintsDetails.getUnitOfDuration())
					benChiefComplaint.setUnitOfDuration(complaintsDetails.getUnitOfDuration());
				if (null != complaintsDetails.getDescription())
					benChiefComplaint.setDescription(complaintsDetails.getDescription());

				benChiefComplaintList.add(benChiefComplaint);
			}
		}
		return benChiefComplaintList;
	}

	public Long saveBenANCDiagnosis(JsonObject obj, Long prescriptionID) throws IEMRException {
		Long ID = null;
		ANCDiagnosis ancDiagnosis = InputMapper.gson().fromJson(obj, ANCDiagnosis.class);
		ancDiagnosis.setPrescriptionID(prescriptionID);

		ANCDiagnosis res = ancDiagnosisRepo.save(ancDiagnosis);
		if (null != res && res.getID() > 0) {
			ID = res.getID();
		}
		return ID;
	}

	/*
	 * public Long saveBenInvestigation(WrapperBenInvestigationANC
	 * wrapperBenInvestigationANC) { Long r = null;
	 * 
	 * ArrayList<LabTestOrderDetail> LabTestOrderDetailList = new ArrayList<>();
	 * ArrayList<LabTestOrderDetail> investigationList =
	 * wrapperBenInvestigationANC.getLaboratoryList(); if (investigationList !=
	 * null && investigationList.size() > 0) {
	 * 
	 * for (LabTestOrderDetail testData : investigationList) {
	 * 
	 * testData.setPrescriptionID(wrapperBenInvestigationANC.getPrescriptionID()
	 * ); testData.setBeneficiaryRegID(wrapperBenInvestigationANC.
	 * getBeneficiaryRegID());
	 * testData.setBenVisitID(wrapperBenInvestigationANC.getBenVisitID());
	 * testData.setProviderServiceMapID(wrapperBenInvestigationANC.
	 * getProviderServiceMapID());
	 * testData.setCreatedBy(wrapperBenInvestigationANC.getCreatedBy());
	 * 
	 * LabTestOrderDetailList.add(testData); } ArrayList<LabTestOrderDetail>
	 * LabTestOrderDetailListRS = (ArrayList<LabTestOrderDetail>)
	 * labTestOrderDetailRepo .save(LabTestOrderDetailList);
	 * 
	 * if (LabTestOrderDetailListRS.size() == investigationList.size()) { r =
	 * new Long(1); }
	 * 
	 * } else { r = new Long(1); ; }
	 * 
	 * return r;
	 * 
	 * }
	 */
	@Deprecated
	public Integer saveBenANCPrescription(List<PrescribedDrugDetail> prescribedDrugDetailList) {
		Integer r = 0;
		List<PrescribedDrugDetail> prescribedDrugDetailListRS = (List<PrescribedDrugDetail>) prescribedDrugDetailRepo
				.save(prescribedDrugDetailList);
		if (prescribedDrugDetailList.size() > 0 && prescribedDrugDetailListRS != null
				&& prescribedDrugDetailListRS.size() > 0) {
			r = prescribedDrugDetailListRS.size();
		}
		return r;
	}

	/* Method moved to common service, Can remove from here */
	public String updateBenVisitStatusFlag(Long benVisitID, String c) {
		return doctorServiceImpl.updateBenStatus(benVisitID, c);
	}

	public String getANCDiagnosisDetails(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> resList = ancDiagnosisRepo.getANCDiagnosisDetails(beneficiaryRegID, benVisitID);
		ANCDiagnosis ancDiagnosisDetails = ANCDiagnosis.getANCDiagnosisDetails(resList);
		return new Gson().toJson(ancDiagnosisDetails);
	}

	public int updateBenANCDiagnosis(ANCDiagnosis ancDiagnosis, Long prescriptionID) throws IEMRException {
		int res = 0;
		int recordsAvailable = 0;
		String processed = ancDiagnosisRepo.getANCDiagnosisStatus(ancDiagnosis.getBeneficiaryRegID(),
				ancDiagnosis.getBenVisitID());

		if (null != processed) {
			recordsAvailable = 1;
		}

		if (null != processed && !processed.equals("N")) {
			processed = "U";
		} else {
			processed = "N";
		}
		if (recordsAvailable > 0) {
			ancDiagnosis.setModifiedBy(ancDiagnosis.getCreatedBy());
			res = ancDiagnosisRepo.updateANCDiagnosis(ancDiagnosis.getHighRiskStatus(),
					ancDiagnosis.getHighRiskCondition(), ancDiagnosis.getComplicationOfCurrentPregnancy(),
					ancDiagnosis.getIsMaternalDeath(), ancDiagnosis.getPlaceOfDeath(), ancDiagnosis.getDateOfDeath(),
					ancDiagnosis.getCauseOfDeath(), ancDiagnosis.getModifiedBy(), processed,
					ancDiagnosis.getBeneficiaryRegID(), ancDiagnosis.getBenVisitID(), ancDiagnosis.getPrescriptionID());
		} else {
			ancDiagnosis.setPrescriptionID(prescriptionID);
			ANCDiagnosis ancDiagnosisRes = ancDiagnosisRepo.save(ancDiagnosis);
			if (null != ancDiagnosisRes && ancDiagnosisRes.getID() > 0) {
				res = 1;
			}

		}

		return res;
	}
}
