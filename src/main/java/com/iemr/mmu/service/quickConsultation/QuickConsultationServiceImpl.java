package com.iemr.mmu.service.quickConsultation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
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
import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.service.generalOPD.GeneralOPDDoctorServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;

@Service
public class QuickConsultationServiceImpl implements QuickConsultationService {
	private BenChiefComplaintRepo benChiefComplaintRepo;
	private BenClinicalObservationsRepo benClinicalObservationsRepo;
	private PrescriptionDetailRepo prescriptionDetailRepo;
	private PrescribedDrugDetailRepo prescribedDrugDetailRepo;
	private LabTestOrderDetailRepo labTestOrderDetailRepo;
	private ExternalTestOrderRepo externalTestOrderRepo;
	private NurseServiceImpl nurseServiceImpl;
	private BenVisitDetailRepo benVisitDetailRepo;
	private CommonNurseServiceImpl commonNurseServiceImpl;
	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;
	
	private CommonDoctorServiceImpl commonDoctorServiceImpl;
	private GeneralOPDDoctorServiceImpl generalOPDDoctorServiceImpl;

	@Autowired
	public void setCommonDoctorServiceImpl(CommonDoctorServiceImpl commonDoctorServiceImpl) {
		this.commonDoctorServiceImpl = commonDoctorServiceImpl;
	}
	
	@Autowired
	public void setGeneralOPDDoctorServiceImpl(GeneralOPDDoctorServiceImpl generalOPDDoctorServiceImpl) {
		this.generalOPDDoctorServiceImpl = generalOPDDoctorServiceImpl;
	}
	
	@Autowired
	public void setCommonBenStatusFlowServiceImpl(CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl) {
		this.commonBenStatusFlowServiceImpl = commonBenStatusFlowServiceImpl;
	}

	@Autowired
	public void setCommonNurseServiceImpl(CommonNurseServiceImpl commonNurseServiceImpl) {
		this.commonNurseServiceImpl = commonNurseServiceImpl;
	}

	@Autowired
	public void setBeneficiaryVisitDetail(BenVisitDetailRepo benVisitDetailRepo) {
		this.benVisitDetailRepo = benVisitDetailRepo;
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
	public Long saveBeneficiaryClinicalObservations(JsonObject caseSheet) throws Exception {

		BenClinicalObservations benClinicalObservations = InputMapper.gson().fromJson(caseSheet,
				BenClinicalObservations.class);
		BenClinicalObservations benClinicalObservation = benClinicalObservationsRepo.save(benClinicalObservations);
		if (null != benClinicalObservation && benClinicalObservation.getClinicalObservationID() > 0) {
			return benClinicalObservation.getClinicalObservationID();
		}
		return null;
	}

	@Deprecated
	@Override
	public Long saveBeneficiaryPrescription(JsonObject caseSheet) throws Exception {

		PrescriptionDetail prescriptionDetail = InputMapper.gson().fromJson(caseSheet, PrescriptionDetail.class);

		PrescriptionDetail prescription = prescriptionDetailRepo.save(prescriptionDetail);
		if (null != prescription && prescription.getPrescriptionID() > 0) {
			return prescriptionDetail.getPrescriptionID();
		}
		return null;
	}

	// Prescription for ANC...
	/*@Deprecated*/
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
		Long prescribedDrugSuccessFlag = null;
		ArrayList<PrescribedDrugDetail> prescriptionDetails = PrescribedDrugDetail
				.getBenPrescribedDrugDetailList(caseSheet, prescriptionID);

		/*
		 * List<PrescribedDrugDetail> prescribedDrugs =
		 * (List<PrescribedDrugDetail>) prescribedDrugDetailRepo
		 * .save(prescriptionDetails);
		 * 
		 * if (null != prescribedDrugs && prescribedDrugs.size() > 0) { for
		 * (PrescribedDrugDetail prescribedDrug : prescribedDrugs) { return
		 * prescribedDrug.getPrescribedDrugID(); } }
		 */

		Integer r = commonNurseServiceImpl.saveBenPrescribedDrugsList(prescriptionDetails);
		if (r > 0 && r != null) {
			prescribedDrugSuccessFlag = new Long(r);
		}

		return prescribedDrugSuccessFlag;
	}

	@Deprecated
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
	public Integer quickConsultNurseDataInsert(JsonObject jsnOBJ) throws Exception {
		Integer returnOBJ = 0;
		if (jsnOBJ != null && jsnOBJ.has("visitDetails") && !jsnOBJ.get("visitDetails").isJsonNull()) {

			BeneficiaryVisitDetail benVisitDetailsOBJ = InputMapper.gson().fromJson(jsnOBJ.get("visitDetails"),
					BeneficiaryVisitDetail.class);
			Long benVisitID = commonNurseServiceImpl.saveBeneficiaryVisitDetails(benVisitDetailsOBJ);

			// Getting benflowID for ben status update
			Long benFlowID = null;
			if (jsnOBJ.has("benFlowID")) {
				benFlowID = jsnOBJ.get("benFlowID").getAsLong();
			}

			if (benVisitID != null && benVisitID > 0) {
				BenAnthropometryDetail benAnthropometryDetail = InputMapper.gson().fromJson(jsnOBJ.get("vitalsDetails"),
						BenAnthropometryDetail.class);
				benAnthropometryDetail.setBenVisitID(benVisitID);
				Long benAnthropometryID = commonNurseServiceImpl
						.saveBeneficiaryPhysicalAnthropometryDetails(benAnthropometryDetail);
				BenPhysicalVitalDetail benPhysicalVitalDetail = InputMapper.gson().fromJson(jsnOBJ.get("vitalsDetails"),
						BenPhysicalVitalDetail.class);
				benPhysicalVitalDetail.setBenVisitID(benVisitID);
				Long benPhysicalVitalID = commonNurseServiceImpl
						.saveBeneficiaryPhysicalVitalDetails(benPhysicalVitalDetail);
				if (benAnthropometryID != null && benAnthropometryID > 0 && benPhysicalVitalID != null
						&& benPhysicalVitalID > 0) {
					Integer i = commonNurseServiceImpl.updateBeneficiaryStatus('N',
							benVisitDetailsOBJ.getBeneficiaryRegID());

					returnOBJ = 1;

					/**
					 * We have to write new code to update ben status flow new
					 * logic
					 */

					int j = updateBenStatusFlagAfterNurseSaveSuccess(benVisitDetailsOBJ, benVisitID, benFlowID);

				} else {

				}
			} else {
				// Error in beneficiary visit creation...
			}
		}
		return returnOBJ;
	}

	// method for updating ben flow status flag for nurse
	private int updateBenStatusFlagAfterNurseSaveSuccess(BeneficiaryVisitDetail benVisitDetailsOBJ, Long benVisitID,
			Long benFlowID) {
		short nurseFlag = (short) 9;
		short docFlag = (short) 1;
		short labIteration = (short) 0;

		int i = commonBenStatusFlowServiceImpl.updateBenFlowNurseAfterNurseActivity(benFlowID,
				benVisitDetailsOBJ.getBeneficiaryRegID(), benVisitID, benVisitDetailsOBJ.getVisitReason(),
				benVisitDetailsOBJ.getVisitCategory(), nurseFlag, docFlag, labIteration, (short) 0, (short) 0);

		return i;
	}

	@Override
	public Integer quickConsultDoctorDataInsert(JsonObject quickConsultDoctorOBJ) throws Exception {
		Integer returnOBJ = 0;
		Long benChiefComplaintID = saveBeneficiaryChiefComplaint(quickConsultDoctorOBJ);
		Long clinicalObservationID = saveBeneficiaryClinicalObservations(quickConsultDoctorOBJ);
		Long prescriptionID = commonNurseServiceImpl.saveBeneficiaryPrescription(quickConsultDoctorOBJ);

		Long prescribedDrugID = null;
		Long labTestOrderID = null;

		JsonArray testList = quickConsultDoctorOBJ.getAsJsonArray("labTestOrders");
		JsonArray drugList = quickConsultDoctorOBJ.getAsJsonArray("prescribedDrugs");

		if (prescriptionID != null && prescriptionID > 0) {

			prescribedDrugID = saveBeneficiaryPrescribedDrugDetail(quickConsultDoctorOBJ, prescriptionID);

			labTestOrderID = commonNurseServiceImpl.saveBeneficiaryLabTestOrderDetails(quickConsultDoctorOBJ,
					prescriptionID);

		}
		if ((null != benChiefComplaintID && benChiefComplaintID > 0)
				&& (null != clinicalObservationID && clinicalObservationID > 0)
				&& (prescriptionID != null && prescriptionID > 0)) {

			// New code for ben fow logic
			short pharmaFalg;
			short docFlag;
			short labFalg;

			Long tmpBenFlowID = quickConsultDoctorOBJ.get("benFlowID").getAsLong();
			Long tmpBeneficiaryID = quickConsultDoctorOBJ.get("beneficiaryID").getAsLong();
			Long tmpBenVisitID = quickConsultDoctorOBJ.get("benVisitID").getAsLong();
			Long tmpbeneficiaryRegID = quickConsultDoctorOBJ.get("beneficiaryRegID").getAsLong();

			if (testList != null && !testList.isJsonNull() && testList.size() > 0 && drugList != null
					&& !drugList.isJsonNull() && drugList.size() > 0) {
				if (drugList.get(0) != null && !drugList.get(0).isJsonNull()) {
					JsonObject firstDrugDetails = drugList.get(0).getAsJsonObject();
					if (firstDrugDetails.get("drug") == null || firstDrugDetails.get("drug").isJsonNull()) {
						// drug not prescribed
						pharmaFalg = (short) 0;
					} else {
						pharmaFalg = (short) 1;
					}

				} else {
					pharmaFalg = (short) 0;
				}

				docFlag = (short) 2;

			} else {
				// either lab or drug or both no prescribed
				if (drugList.get(0) != null && !drugList.get(0).isJsonNull()) {
					JsonObject firstDrugDetails = drugList.get(0).getAsJsonObject();
					if (firstDrugDetails.get("drug") == null || firstDrugDetails.get("drug").isJsonNull()) {
						// drug not prescribed
						pharmaFalg = (short) 0;
					} else {
						pharmaFalg = (short) 1;
					}

				} else {
					pharmaFalg = (short) 0;
				}

				docFlag = (short) 9;

			}

			int l = commonBenStatusFlowServiceImpl.updateBenFlowAfterDocData(tmpBenFlowID, tmpbeneficiaryRegID,
					tmpBeneficiaryID, tmpBenVisitID, docFlag, pharmaFalg, (short) 0);

			// End of new code

			// if (quickConsultDoctorOBJ.has("benVisitID") &&
			// !quickConsultDoctorOBJ.get("benVisitID").isJsonNull()) {
			// Integer i = benVisitDetailRepo.updateBenFlowStatus("D",
			// quickConsultDoctorOBJ.get("benVisitID").getAsLong());
			// }

			returnOBJ = 1;
		}
		return returnOBJ;
	}

	// ------- Start Fetch (Nurse data to Doctor screen) ----------------
	public String getBenDataFrmNurseToDocVisitDetailsScreen(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();
		BeneficiaryVisitDetail benVisitDetailsOBJ = commonNurseServiceImpl.getCSVisitDetails(benRegID, benVisitID);

		if (null != benVisitDetailsOBJ) {

			resMap.put("benVisitDetails", benVisitDetailsOBJ);
		}

		return new Gson().toJson(resMap);
	}

	public String getBeneficiaryVitalDetails(Long beneficiaryRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();

		resMap.put("benAnthropometryDetail",
				commonNurseServiceImpl.getBeneficiaryPhysicalAnthropometryDetails(beneficiaryRegID, benVisitID));
		resMap.put("benPhysicalVitalDetail",
				commonNurseServiceImpl.getBeneficiaryPhysicalVitalDetails(beneficiaryRegID, benVisitID));

		return resMap.toString();
	}

	// ------- END of Fetch (Nurse data to Doctor screen) ----------------
	
	public String getBenCaseRecordFromDoctorQuickConsult(Long benRegID, Long benVisitID) {
		/*Map<String, Object> resMap = new HashMap<>();

		resMap.put("findings", commonDoctorServiceImpl.getFindingsDetails(benRegID, benVisitID));
		
		resMap.put("diagnosis", generalOPDDoctorServiceImpl.getGeneralOPDDiagnosisDetails(benRegID, benVisitID));

		resMap.put("investigation", commonDoctorServiceImpl.getInvestigationDetails(benRegID, benVisitID));

		resMap.put("prescription", commonDoctorServiceImpl.getPrescribedDrugs(benRegID, benVisitID));*/


		
		List<Object> resList =new ArrayList<Object>();
		resList.add(commonDoctorServiceImpl.getFindingsDetails(benRegID, benVisitID));
				resList.add(commonDoctorServiceImpl.getInvestigationDetails(benRegID, benVisitID));
		resList.add(commonDoctorServiceImpl.getPrescribedDrugs(benRegID, benVisitID));
		
		return resList.toString();
	}
}
