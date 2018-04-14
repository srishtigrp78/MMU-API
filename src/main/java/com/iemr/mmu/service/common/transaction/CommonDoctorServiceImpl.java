package com.iemr.mmu.service.common.transaction;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.anc.ANCDiagnosis;
import com.iemr.mmu.data.anc.WrapperAncFindings;
import com.iemr.mmu.data.doctor.BenReferDetails;
import com.iemr.mmu.data.masterdata.anc.ServiceMaster;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.data.quickConsultation.BenClinicalObservations;
import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;
import com.iemr.mmu.data.registrar.WrapperRegWorklist;
import com.iemr.mmu.repo.doctor.BenReferDetailsRepo;
import com.iemr.mmu.repo.doctor.DocWorkListRepo;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;
import com.iemr.mmu.repo.nurse.anc.ANCDiagnosisRepo;
import com.iemr.mmu.repo.quickConsultation.BenChiefComplaintRepo;
import com.iemr.mmu.repo.quickConsultation.BenClinicalObservationsRepo;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.mmu.utils.exception.IEMRException;
import com.iemr.mmu.utils.mapper.InputMapper;

/***
 * 
 * @author NE298657
 *
 */
@Service
public class CommonDoctorServiceImpl {

	private BenClinicalObservationsRepo benClinicalObservationsRepo;
	private BenChiefComplaintRepo benChiefComplaintRepo;
	private ANCDiagnosisRepo ancDiagnosisRepo;
	private NurseServiceImpl nurseServiceImpl;
	private BenVisitDetailRepo benVisitDetailRepo;
	private DocWorkListRepo docWorkListRepo;
	private BenReferDetailsRepo benReferDetailsRepo;

	@Autowired
	public void setBenReferDetailsRepo(BenReferDetailsRepo benReferDetailsRepo) {
		this.benReferDetailsRepo = benReferDetailsRepo;
	}

	@Autowired
	public void setDocWorkListRepo(DocWorkListRepo docWorkListRepo) {
		this.docWorkListRepo = docWorkListRepo;
	}

	@Autowired
	public void setBenVisitDetailRepo(BenVisitDetailRepo benVisitDetailRepo) {
		this.benVisitDetailRepo = benVisitDetailRepo;
	}

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

	@Autowired
	public void setAncDiagnosisRepo(ANCDiagnosisRepo ancDiagnosisRepo) {
		this.ancDiagnosisRepo = ancDiagnosisRepo;
	}

	@Autowired
	public void setBenChiefComplaintRepo(BenChiefComplaintRepo benChiefComplaintRepo) {
		this.benChiefComplaintRepo = benChiefComplaintRepo;
	}

	@Autowired
	public void setBenClinicalObservationsRepo(BenClinicalObservationsRepo benClinicalObservationsRepo) {
		this.benClinicalObservationsRepo = benClinicalObservationsRepo;
	}

	public Integer saveFindings(JsonObject obj) throws Exception {
		int i = 0;
		BenClinicalObservations clinicalObservations = InputMapper.gson().fromJson(obj, BenClinicalObservations.class);
		BenClinicalObservations benClinicalObservationsRS = benClinicalObservationsRepo.save(clinicalObservations);
		if (benClinicalObservationsRS != null) {
			i = 1;
		}

		return i;

	}

	@Deprecated
	public Integer saveDocFindings(WrapperAncFindings wrapperAncFindings) {
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
					if (d == null)
						continue;
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

	// for now using from ancDoctorService only, because not there in Gen-OPD
	@Deprecated
	public Long saveBenDiagnosis(JsonObject obj) throws IEMRException {
		Long ID = null;
		ANCDiagnosis ancDiagnosis = InputMapper.gson().fromJson(obj, ANCDiagnosis.class);
		ANCDiagnosis res = ancDiagnosisRepo.save(ancDiagnosis);
		if (null != res && res.getID() > 0) {
			ID = res.getID();
		}
		return ID;
	}

	/* Moved to common Nurse Services */
	@Deprecated
	public Long savePrescriptionDetailsAndGetPrescriptionID(Long benRegID, Long benVisitID, Integer psmID,
			String createdBy) {
		PrescriptionDetail prescriptionDetail = new PrescriptionDetail();
		prescriptionDetail.setBeneficiaryRegID(benRegID);
		prescriptionDetail.setBenVisitID(benVisitID);
		prescriptionDetail.setProviderServiceMapID(psmID);
		prescriptionDetail.setCreatedBy(createdBy);

		Long prescriptionID = nurseServiceImpl.saveBenPrescription(prescriptionDetail);
		return prescriptionID;
	}

	@Deprecated
	public String updateBenVisitStatusFlag(Long benVisitID, String c) {
		return updateBenStatus(benVisitID, c);
	}

	@Deprecated
	public String updateBenStatus(Long benVisitID, String c) {
		Map<String, String> resMap = new HashMap<>();
		Integer i = benVisitDetailRepo.updateBenFlowStatus(c, benVisitID);
		if (i != null && i > 0) {
			resMap.put("status", "Updated Successfully");
		}
		return new Gson().toJson(resMap);
	}

	public String getDocWorkList() {
		List<Object[]> docWorkListData = docWorkListRepo.getDocWorkList();
		// System.out.println("hello");
		return WrapperRegWorklist.getDocWorkListData(docWorkListData);
	}

	public String fetchBenPreviousSignificantFindings(Long beneficiaryRegID) {
		ArrayList<Object[]> previousSignificantFindings = (ArrayList<Object[]>) benClinicalObservationsRepo
				.getPreviousSignificantFindings(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();

		ArrayList<BenClinicalObservations> clinicalObservations = new ArrayList<BenClinicalObservations>();
		if (null != clinicalObservations) {
			for (Object[] obj : previousSignificantFindings) {
				BenClinicalObservations clinicalObservation = new BenClinicalObservations((String) obj[1],
						(Date) obj[0]);
				clinicalObservations.add(clinicalObservation);
			}
		}

		response.put("findings", clinicalObservations);
		return new Gson().toJson(response);

	}

	public Long saveBenReferDetails(JsonObject obj) throws IEMRException {
		Long ID = null;
		BenReferDetails referDetails = InputMapper.gson().fromJson(obj, BenReferDetails.class);
		List<BenReferDetails> referDetailsList = new ArrayList<BenReferDetails>();

		BenReferDetails referDetailsTemp = null;

		if (referDetails.getRefrredToAdditionalServiceList() != null
				&& referDetails.getRefrredToAdditionalServiceList().size() > 0) {
			for (ServiceMaster sm : referDetails.getRefrredToAdditionalServiceList()) {
				referDetailsTemp = new BenReferDetails();
				referDetailsTemp.setBeneficiaryRegID(referDetails.getBeneficiaryRegID());
				referDetailsTemp.setBenVisitID(referDetails.getBenVisitID());
				referDetailsTemp.setProviderServiceMapID(referDetails.getProviderServiceMapID());
				referDetailsTemp.setVisitCode(referDetails.getVisitCode());
				referDetailsTemp.setCreatedBy(referDetails.getCreatedBy());
				if (referDetails.getReferredToInstituteID() != null
						&& referDetails.getReferredToInstituteName() != null) {
					referDetailsTemp.setReferredToInstituteID(referDetails.getReferredToInstituteID());
					referDetailsTemp.setReferredToInstituteName(referDetails.getReferredToInstituteName());
				}
				
				referDetailsTemp.setServiceID(sm.getServiceID());
				referDetailsTemp.setServiceName(sm.getServiceName());

				referDetailsList.add(referDetailsTemp);
			}
		} else {
			referDetailsList.add(referDetails);
		}

		ArrayList<BenReferDetails> res = (ArrayList<BenReferDetails>) benReferDetailsRepo.save(referDetailsList);
		if (null != res && res.size() > 0) {
			ID = res.get(0).getBenReferID();
		}
		return ID;
	}

}
