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
import com.iemr.mmu.data.anc.WrapperAncFindings;
import com.iemr.mmu.data.anc.WrapperBenInvestigationANC;
import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
import com.iemr.mmu.data.doctor.BenReferDetails;
import com.iemr.mmu.data.masterdata.anc.ServiceMaster;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.data.quickConsultation.BenClinicalObservations;
import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;
import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;
import com.iemr.mmu.data.registrar.WrapperRegWorklist;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.doctor.BenReferDetailsRepo;
import com.iemr.mmu.repo.doctor.DocWorkListRepo;
import com.iemr.mmu.repo.quickConsultation.BenChiefComplaintRepo;
import com.iemr.mmu.repo.quickConsultation.BenClinicalObservationsRepo;
import com.iemr.mmu.repo.quickConsultation.LabTestOrderDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescribedDrugDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
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
	private DocWorkListRepo docWorkListRepo;
	private BenReferDetailsRepo benReferDetailsRepo;
	private LabTestOrderDetailRepo labTestOrderDetailRepo;
	private PrescribedDrugDetailRepo prescribedDrugDetailRepo;
	private PrescriptionDetailRepo prescriptionDetailRepo;

	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;

	@Autowired
	public void setBeneficiaryFlowStatusRepo(BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo) {
		this.beneficiaryFlowStatusRepo = beneficiaryFlowStatusRepo;
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
	public void setBenReferDetailsRepo(BenReferDetailsRepo benReferDetailsRepo) {
		this.benReferDetailsRepo = benReferDetailsRepo;
	}

	@Autowired
	public void setDocWorkListRepo(DocWorkListRepo docWorkListRepo) {
		this.docWorkListRepo = docWorkListRepo;
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

	public Integer saveDocFindings(WrapperAncFindings wrapperAncFindings) {
		int i = 0;
		int clinicalObservationFlag = 0;
		int chiefComFlag = 0;
		BenClinicalObservations benClinicalObservationsRS = benClinicalObservationsRepo
				.save(getBenClinicalObservations(wrapperAncFindings));
		if (benClinicalObservationsRS != null) {
			clinicalObservationFlag = 1;
		}

		// ArrayList<BenChiefComplaint> tmpBenCHiefComplaints =
		// getBenChiefComplaint(wrapperAncFindings);
		ArrayList<BenChiefComplaint> tmpBenCHiefComplaints = wrapperAncFindings.getComplaints();
		ArrayList<BenChiefComplaint> tmpBenCHiefComplaintsTMP = new ArrayList<>();
		if (tmpBenCHiefComplaints.size() > 0) {
			for (BenChiefComplaint benChiefComplaint : tmpBenCHiefComplaints) {
				if (benChiefComplaint.getChiefComplaint() != null) {
					benChiefComplaint.setBeneficiaryRegID(wrapperAncFindings.getBeneficiaryRegID());
					benChiefComplaint.setBenVisitID(wrapperAncFindings.getBenVisitID());
					benChiefComplaint.setVisitCode(wrapperAncFindings.getVisitCode());
					benChiefComplaint.setProviderServiceMapID(wrapperAncFindings.getProviderServiceMapID());
					benChiefComplaint.setCreatedBy(wrapperAncFindings.getCreatedBy());

					tmpBenCHiefComplaintsTMP.add(benChiefComplaint);
				}
			}

		}
		if (tmpBenCHiefComplaintsTMP.size() > 0) {
			ArrayList<BenChiefComplaint> benChiefComplaintListRS = (ArrayList<BenChiefComplaint>) benChiefComplaintRepo
					.save(tmpBenCHiefComplaintsTMP);
			if (tmpBenCHiefComplaintsTMP.size() == benChiefComplaintListRS.size()) {
				chiefComFlag = 1;
			}
		} else {
			chiefComFlag = 1;
		}

		if (clinicalObservationFlag > 0 && chiefComFlag > 0)
			i = 1;

		return i;
	}

	private BenClinicalObservations getBenClinicalObservations(WrapperAncFindings wrapperAncFindings) {
		BenClinicalObservations benClinicalObservations = new BenClinicalObservations();
		benClinicalObservations.setBeneficiaryRegID(wrapperAncFindings.getBeneficiaryRegID());
		benClinicalObservations.setBenVisitID(wrapperAncFindings.getBenVisitID());
		benClinicalObservations.setVisitCode(wrapperAncFindings.getVisitCode());
		benClinicalObservations.setProviderServiceMapID(wrapperAncFindings.getProviderServiceMapID());
		benClinicalObservations.setCreatedBy(wrapperAncFindings.getCreatedBy());
		benClinicalObservations.setClinicalObservation(wrapperAncFindings.getClinicalObservation());
		benClinicalObservations.setOtherSymptoms(wrapperAncFindings.getOtherSymptoms());
		benClinicalObservations.setSignificantFindings(wrapperAncFindings.getSignificantFindings());
		benClinicalObservations.setIsForHistory(wrapperAncFindings.getIsForHistory());
		benClinicalObservations.setModifiedBy(wrapperAncFindings.getModifiedBy());
		return benClinicalObservations;
	}

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
					 * Double d = (Double) complaintsDetails.getChiefComplaintID(); if (d == null)
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

	public String getDocWorkList() {
		List<Object[]> docWorkListData = docWorkListRepo.getDocWorkList();
		return WrapperRegWorklist.getDocWorkListData(docWorkListData);
	}

	// New doc worklist service
	public String getDocWorkListNew(Integer providerServiceMapId) {
		ArrayList<BeneficiaryFlowStatus> docWorkList = beneficiaryFlowStatusRepo
				.getDocWorkListNew(providerServiceMapId);
		return new Gson().toJson(docWorkList);
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
				if (sm.getServiceName() != null) {
					referDetailsTemp = new BenReferDetails();
					referDetailsTemp.setBeneficiaryRegID(referDetails.getBeneficiaryRegID());
					referDetailsTemp.setBenVisitID(referDetails.getBenVisitID());
					referDetailsTemp.setVisitCode(referDetails.getVisitCode());
					referDetailsTemp.setProviderServiceMapID(referDetails.getProviderServiceMapID());
					referDetailsTemp.setVisitCode(referDetails.getVisitCode());
					referDetailsTemp.setCreatedBy(referDetails.getCreatedBy());

					referDetailsTemp.setServiceID(sm.getServiceID());
					referDetailsTemp.setServiceName(sm.getServiceName());

					if (referDetails.getReferredToInstituteID() != null
							&& referDetails.getReferredToInstituteName() != null) {
						referDetailsTemp.setReferredToInstituteID(referDetails.getReferredToInstituteID());
						referDetailsTemp.setReferredToInstituteName(referDetails.getReferredToInstituteName());
					}

					referDetailsList.add(referDetailsTemp);
				}
			}
		} else {
			if (referDetails.getReferredToInstituteName() != null)
				referDetailsList.add(referDetails);
		}

		ArrayList<BenReferDetails> res = (ArrayList<BenReferDetails>) benReferDetailsRepo.save(referDetailsList);
		if (referDetailsList.size() == res.size()) {
			ID = new Long(1);
		}
		return ID;
	}

	public String getFindingsDetails(Long beneficiaryRegID, Long visitCode) {
		ArrayList<Object[]> clinicalObservationsList = benClinicalObservationsRepo.getFindingsData(beneficiaryRegID,
				visitCode);
		ArrayList<Object[]> chiefComplaintsList = benChiefComplaintRepo.getBenChiefComplaints(beneficiaryRegID,
				visitCode);

		WrapperAncFindings findings = WrapperAncFindings.getFindingsData(clinicalObservationsList, chiefComplaintsList);
		return new Gson().toJson(findings);
	}

	public String getInvestigationDetails(Long beneficiaryRegID, Long visitCode) {
		ArrayList<Object[]> labTestOrders = labTestOrderDetailRepo.getLabTestOrderDetails(beneficiaryRegID, visitCode);
		WrapperBenInvestigationANC labTestOrdersList = LabTestOrderDetail.getLabTestOrderDetails(labTestOrders);

		return new Gson().toJson(labTestOrdersList);
	}

	public String getPrescribedDrugs(Long beneficiaryRegID, Long visitCode) {
		// ArrayList<Object[]> prescriptions =
		// prescriptionDetailRepo.getBenPrescription(beneficiaryRegID, visitCode);
		//
		// PrescriptionDetail prescriptionData =
		// PrescriptionDetail.getPrescriptions(prescriptions);
		// if (null != prescriptionData) {
		ArrayList<Object[]> resList = prescribedDrugDetailRepo.getBenPrescribedDrugDetails(beneficiaryRegID, visitCode);

		ArrayList<PrescribedDrugDetail> prescribedDrugs = PrescribedDrugDetail.getprescribedDrugs(resList);
		// prescriptionData.setPrescribedDrugs(prescribedDrugs);
		// }

		return new Gson().toJson(prescribedDrugs);
	}

	/*
	 * public PrescriptionDetail getLatestPrescription(Long beneficiaryRegID, Long
	 * benVisitID) { ArrayList<Object[]> prescriptions =
	 * prescriptionDetailRepo.getBenPrescription(beneficiaryRegID, benVisitID);
	 * 
	 * PrescriptionDetail prescriptionData =
	 * PrescriptionDetail.getPrescriptions(prescriptions); return prescriptionData;
	 * }
	 */

	public String getReferralDetails(Long beneficiaryRegID, Long visitCode) {
		ArrayList<Object[]> resList = benReferDetailsRepo.getBenReferDetails(beneficiaryRegID, visitCode);

		BenReferDetails referDetails = BenReferDetails.getBenReferDetails(resList);

		return new Gson().toJson(referDetails);
	}

	public Integer updateDocFindings(WrapperAncFindings wrapperAncFindings) {
		int clinObsrvtnsRes = 0;
		int chiefCmpltsRes = 0;
		int updateFindingsRes = 0;

		BenClinicalObservations benClinicalObservations = getBenClinicalObservations(wrapperAncFindings);
		clinObsrvtnsRes = updateBenClinicalObservations(benClinicalObservations);

		ArrayList<BenChiefComplaint> tmpBenCHiefComplaints = wrapperAncFindings.getComplaints();
		ArrayList<BenChiefComplaint> tmpBenCHiefComplaintsTMP = new ArrayList<>();
		if (tmpBenCHiefComplaints.size() > 0) {
			for (BenChiefComplaint benChiefComplaint : tmpBenCHiefComplaints) {
				if (benChiefComplaint.getChiefComplaint() != null) {
					benChiefComplaint.setBeneficiaryRegID(wrapperAncFindings.getBeneficiaryRegID());
					benChiefComplaint.setBenVisitID(wrapperAncFindings.getBenVisitID());
					benChiefComplaint.setVisitCode(wrapperAncFindings.getVisitCode());
					benChiefComplaint.setProviderServiceMapID(wrapperAncFindings.getProviderServiceMapID());
					benChiefComplaint.setCreatedBy(wrapperAncFindings.getCreatedBy());

					tmpBenCHiefComplaintsTMP.add(benChiefComplaint);
				}
			}
			chiefCmpltsRes = updateDoctorBenChiefComplaints(tmpBenCHiefComplaintsTMP);

		} else {
			chiefCmpltsRes = 1;
		}
		if (clinObsrvtnsRes > 0 && chiefCmpltsRes > 0) {
			updateFindingsRes = 1;

		}
		return updateFindingsRes;
	}

	public int updateDoctorBenChiefComplaints(List<BenChiefComplaint> benChiefComplaintList) {
		int r = 0;
		if (null != benChiefComplaintList && benChiefComplaintList.size() > 0) {

			List<BenChiefComplaint> benChiefComplaintResultList = (List<BenChiefComplaint>) benChiefComplaintRepo
					.save(benChiefComplaintList);

			if (benChiefComplaintResultList != null && benChiefComplaintResultList.size() > 0) {
				r = benChiefComplaintResultList.size();
			}
		} else {
			r = 1;
		}
		return r;
	}

	public int updateBenClinicalObservations(BenClinicalObservations benClinicalObservations) {
		Integer r = 0;
		int recordsAvailable = 0;
		if (null != benClinicalObservations) {
			String processed = benClinicalObservationsRepo.getBenClinicalObservationStatus(
					benClinicalObservations.getBeneficiaryRegID(), benClinicalObservations.getVisitCode());

			if (null != processed) {
				recordsAvailable = 1;
			}

			if (null != processed && !processed.equals("N")) {
				processed = "U";
			} else {
				processed = "N";
			}
			if (recordsAvailable > 0) {
				r = benClinicalObservationsRepo.updateBenClinicalObservations(
						benClinicalObservations.getClinicalObservation(), benClinicalObservations.getOtherSymptoms(),
						benClinicalObservations.getSignificantFindings(), benClinicalObservations.getIsForHistory(),
						benClinicalObservations.getCreatedBy(), processed,
						benClinicalObservations.getBeneficiaryRegID(), benClinicalObservations.getVisitCode());
			} else {
				BenClinicalObservations observationsRes = benClinicalObservationsRepo.save(benClinicalObservations);
				if (null != observationsRes && observationsRes.getClinicalObservationID() > 0) {
					r = 1;
				}
			}
		}
		return r;
	}

	public Long updateBenReferDetails(JsonObject referObj) throws IEMRException {
		Long ID = null;
		int delRes = 0;
		BenReferDetails referDetails = InputMapper.gson().fromJson(referObj, BenReferDetails.class);
		List<BenReferDetails> referDetailsList = new ArrayList<BenReferDetails>();

		BenReferDetails referDetailsTemp = null;

		ArrayList<Object[]> benReferDetailsStatuses = benReferDetailsRepo
				.getBenReferDetailsStatus(referDetails.getBeneficiaryRegID(), referDetails.getVisitCode());

		for (Object[] obj : benReferDetailsStatuses) {
			String processed = (String) obj[1];
			if (null != processed && !"N".equals(processed)) {
				processed = "U";
			} else {
				processed = "N";
			}
			benReferDetailsRepo.updateReferredInstituteName(referDetails.getReferredToInstituteID(),
					referDetails.getReferredToInstituteName(), (Long) obj[0], processed);
		}

		if (referDetails.getRefrredToAdditionalServiceList() != null
				&& referDetails.getRefrredToAdditionalServiceList().size() > 0) {
			for (ServiceMaster sm : referDetails.getRefrredToAdditionalServiceList()) {
				if (sm.getServiceName() != null) {
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
			}
		} else {
			if (referDetails.getReferredToInstituteName() != null)
				referDetailsList.add(referDetails);
		}

		ArrayList<BenReferDetails> res = (ArrayList<BenReferDetails>) benReferDetailsRepo.save(referDetailsList);
		if (referDetailsList.size() == res.size()) {
			ID = new Long(1);
		}
		return ID;
	}

}
