package com.iemr.mmu.service.anc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.anc.ANCDiagnosis;
import com.iemr.mmu.data.anc.WrapperAncFindings;
import com.iemr.mmu.data.anc.WrapperBenInvestigationANC;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.data.quickConsultation.BenClinicalObservations;
import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;
import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;
import com.iemr.mmu.repo.nurse.anc.ANCDiagnosisRepo;
import com.iemr.mmu.repo.quickConsultation.BenChiefComplaintRepo;
import com.iemr.mmu.repo.quickConsultation.BenClinicalObservationsRepo;
import com.iemr.mmu.repo.quickConsultation.LabTestOrderDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescribedDrugDetailRepo;
import com.iemr.mmu.utils.exception.IEMRException;
import com.iemr.mmu.utils.mapper.InputMapper;

@Service
public class ANCDoctorServiceImpl implements ANCDoctorService {
	private BenClinicalObservationsRepo benClinicalObservationsRepo;
	private BenChiefComplaintRepo benChiefComplaintRepo;
	private ANCDiagnosisRepo ancDiagnosisRepo;
	private LabTestOrderDetailRepo labTestOrderDetailRepo;
	private PrescribedDrugDetailRepo prescribedDrugDetailRepo;

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

	public Integer saveANCFindings(JsonObject obj) throws Exception {
		WrapperAncFindings wrapperAncFindings = InputMapper.gson().fromJson(obj, WrapperAncFindings.class);
		return saveAncDocFindings(wrapperAncFindings);

	}

	public Integer saveAncDocFindings(WrapperAncFindings wrapperAncFindings) {
		int i = 0;
		BenClinicalObservations benClinicalObservationsRS = benClinicalObservationsRepo
				.save(getBenClinicalObservations(wrapperAncFindings));
		ArrayList<BenChiefComplaint> benChiefComplaintListRS = (ArrayList<BenChiefComplaint>) benChiefComplaintRepo
				.save(getBenChiefComplaint(wrapperAncFindings));
		if (benClinicalObservationsRS != null && benChiefComplaintListRS != null) {
			i = 1;
		}
		return i;
	}

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

	private ArrayList<BenChiefComplaint> getBenChiefComplaint(WrapperAncFindings wrapperAncFindings) {
		ArrayList<BenChiefComplaint> benChiefComplaintList = new ArrayList<>();
		BenChiefComplaint benChiefComplaint;
		if (wrapperAncFindings != null && wrapperAncFindings.getComplaints() != null
				&& wrapperAncFindings.getComplaints().size() > 0) {
			for (Map<String, Object> complaintsDetails : wrapperAncFindings.getComplaints()) {
				benChiefComplaint = new BenChiefComplaint();
				benChiefComplaint.setBeneficiaryRegID(wrapperAncFindings.getBeneficiaryRegID());
				benChiefComplaint.setBenVisitID(wrapperAncFindings.getBenVisitID());
				benChiefComplaint.setProviderServiceMapID(wrapperAncFindings.getProviderServiceMapID());
				benChiefComplaint.setCreatedBy(wrapperAncFindings.getCreatedBy());

				if (complaintsDetails.containsKey("chiefComplaintID")) {
					Double d = (Double) complaintsDetails.get("chiefComplaintID");
					benChiefComplaint.setChiefComplaintID(d.intValue());
				}
				if (complaintsDetails.containsKey("chiefComplaint"))
					benChiefComplaint.setChiefComplaint((String) complaintsDetails.get("chiefComplaint"));
				if (complaintsDetails.containsKey("duration"))
					benChiefComplaint.setDuration(Integer.parseInt(complaintsDetails.get("duration").toString()));
				if (complaintsDetails.containsKey("unitOfDuration"))
					benChiefComplaint.setUnitOfDuration((String) complaintsDetails.get("unitOfDuration"));
				if (complaintsDetails.containsKey("description"))
					benChiefComplaint.setDescription((String) complaintsDetails.get("description"));

				benChiefComplaintList.add(benChiefComplaint);
			}
		}
		return benChiefComplaintList;
	}

	public Long saveBenANCDiagnosis(JsonObject obj) throws IEMRException {
		Long ID = null;
		ANCDiagnosis ancDiagnosis = InputMapper.gson().fromJson(obj, ANCDiagnosis.class);
		ANCDiagnosis res = ancDiagnosisRepo.save(ancDiagnosis);
		if (null != res && res.getID() > 0) {
			ID = res.getID();
		}
		return ID;
	}

	public Long saveBenInvestigation(WrapperBenInvestigationANC wrapperBenInvestigationANC) {
		Long r = null;

		ArrayList<LabTestOrderDetail> LabTestOrderDetailList = new ArrayList<>();
		ArrayList<LabTestOrderDetail> investigationList = wrapperBenInvestigationANC.getLaboratoryList();
		if (investigationList != null && investigationList.size() > 0) {

			for (LabTestOrderDetail testData : investigationList) {

				testData.setPrescriptionID(wrapperBenInvestigationANC.getPrescriptionID());
				testData.setBeneficiaryRegID(wrapperBenInvestigationANC.getBeneficiaryRegID());
				testData.setBenVisitID(wrapperBenInvestigationANC.getBenVisitID());
				testData.setProviderServiceMapID(wrapperBenInvestigationANC.getProviderServiceMapID());
				testData.setCreatedBy(wrapperBenInvestigationANC.getCreatedBy());

				LabTestOrderDetailList.add(testData);
			}
			ArrayList<LabTestOrderDetail> LabTestOrderDetailListRS = (ArrayList<LabTestOrderDetail>) labTestOrderDetailRepo
					.save(LabTestOrderDetailList);

			if (LabTestOrderDetailListRS.size() == investigationList.size()) {
				r = new Long(1);
			}

		} else {
			r = new Long(1);
			;
		}

		return r;

	}

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

}
