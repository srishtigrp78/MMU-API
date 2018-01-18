package com.iemr.mmu.service.anc;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.anc.ANCCareDetails;
import com.iemr.mmu.data.anc.ANCDiagnosis;
import com.iemr.mmu.data.anc.ANCWomenVaccineDetail;
import com.iemr.mmu.data.anc.BenAdherence;
import com.iemr.mmu.data.anc.BenAllergyHistory;
import com.iemr.mmu.data.anc.BenChildDevelopmentHistory;
import com.iemr.mmu.data.anc.BenFamilyHistory;
import com.iemr.mmu.data.anc.BenMedHistory;
import com.iemr.mmu.data.anc.BenMedicationHistory;
import com.iemr.mmu.data.anc.BenMenstrualDetails;
import com.iemr.mmu.data.anc.BenPersonalHabit;
import com.iemr.mmu.data.anc.BencomrbidityCondDetails;
import com.iemr.mmu.data.anc.ChildFeedingDetails;
import com.iemr.mmu.data.anc.ChildOptionalVaccineDetail;
import com.iemr.mmu.data.anc.ChildVaccineDetail1;
import com.iemr.mmu.data.anc.FemaleObstetricHistory;
import com.iemr.mmu.data.anc.PerinatalHistory;
import com.iemr.mmu.data.anc.PhyGeneralExamination;
import com.iemr.mmu.data.anc.PhyHeadToToeExamination;
import com.iemr.mmu.data.anc.SysCardiovascularExamination;
import com.iemr.mmu.data.anc.SysCentralNervousExamination;
import com.iemr.mmu.data.anc.SysGastrointestinalExamination;
import com.iemr.mmu.data.anc.SysGenitourinarySystemExamination;
import com.iemr.mmu.data.anc.SysMusculoskeletalSystemExamination;
import com.iemr.mmu.data.anc.SysObstetricExamination;
import com.iemr.mmu.data.anc.SysRespiratoryExamination;
import com.iemr.mmu.data.anc.WrapperAncFindings;
import com.iemr.mmu.data.anc.WrapperAncImmunization;
import com.iemr.mmu.data.anc.WrapperBenInvestigationANC;
import com.iemr.mmu.data.anc.WrapperChildOptionalVaccineDetail;
import com.iemr.mmu.data.anc.WrapperComorbidCondDetails;
import com.iemr.mmu.data.anc.WrapperFemaleObstetricHistory;
import com.iemr.mmu.data.anc.WrapperImmunizationHistory;
import com.iemr.mmu.data.anc.WrapperMedicationHistory;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.data.quickConsultation.BenClinicalObservations;
import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;
import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;
import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;
import com.iemr.mmu.repo.nurse.BenAnthropometryRepo;
import com.iemr.mmu.repo.nurse.BenPhysicalVitalRepo;
import com.iemr.mmu.repo.nurse.anc.ANCCareRepo;
import com.iemr.mmu.repo.nurse.anc.ANCDiagnosisRepo;
import com.iemr.mmu.repo.nurse.anc.ANCWomenVaccineRepo;
import com.iemr.mmu.repo.nurse.anc.BenAdherenceRepo;
import com.iemr.mmu.repo.nurse.anc.BenAllergyHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenChildDevelopmentHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenFamilyHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenMedHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenMedicationHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenMenstrualDetailsRepo;
import com.iemr.mmu.repo.nurse.anc.BenPersonalHabitRepo;
import com.iemr.mmu.repo.nurse.anc.BencomrbidityCondRepo;
import com.iemr.mmu.repo.nurse.anc.ChildFeedingDetailsRepo;
import com.iemr.mmu.repo.nurse.anc.ChildOptionalVaccineDetailRepo;
import com.iemr.mmu.repo.nurse.anc.ChildVaccineDetail1Repo;
import com.iemr.mmu.repo.nurse.anc.FemaleObstetricHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.PerinatalHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.PhyGeneralExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.PhyHeadToToeExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysCardiovascularExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysCentralNervousExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysGastrointestinalExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysGenitourinarySystemExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysMusculoskeletalSystemExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysObstetricExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysRespiratoryExaminationRepo;
import com.iemr.mmu.repo.quickConsultation.BenChiefComplaintRepo;
import com.iemr.mmu.repo.quickConsultation.BenClinicalObservationsRepo;
import com.iemr.mmu.repo.quickConsultation.LabTestOrderDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescribedDrugDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
import com.iemr.mmu.service.cancerScreening.CancerScreeningServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.mmu.service.quickConsultation.QuickConsultationServiceImpl;

@Service
public class ANCServiceImpl implements ANCService {

	private ANCCareRepo ancCareRepo;
	private ANCWomenVaccineRepo ancWomenVaccineRepo;
	private BenAdherenceRepo benAdherenceRepo;
	private BenChiefComplaintRepo benChiefComplaintRepo;
	private PrescriptionDetailRepo prescriptionDetailRepo;

	private BenAnthropometryRepo benAnthropometryRepo;
	private BenPhysicalVitalRepo benPhysicalVitalRepo;

	private CancerScreeningServiceImpl cancerScreeningServiceImpl;
	
	@Autowired
	public void setBenChiefComplaintRepo(BenChiefComplaintRepo benChiefComplaintRepo) {
		this.benChiefComplaintRepo = benChiefComplaintRepo;
	}

	private QuickConsultationServiceImpl quickConsultationServiceImpl;

	@Autowired
	public void setEmergencyCasesheetServiceImpl(QuickConsultationServiceImpl quickConsultationServiceImpl) {
		this.quickConsultationServiceImpl = quickConsultationServiceImpl;
	}

	private LabTestOrderDetailRepo labTestOrderDetailRepo;

	@Autowired
	public void setLabTestOrderDetailRepo(LabTestOrderDetailRepo labTestOrderDetailRepo) {
		this.labTestOrderDetailRepo = labTestOrderDetailRepo;
	}

	@Autowired
	public void setPrescriptionDetailRepo(PrescriptionDetailRepo prescriptionDetailRepo) {
		this.prescriptionDetailRepo = prescriptionDetailRepo;
	}
	
	@Autowired
	public void setCancerScreeningServiceImpl(CancerScreeningServiceImpl cancerScreeningServiceImpl) {
		this.cancerScreeningServiceImpl = cancerScreeningServiceImpl;
	}

	private PhyGeneralExaminationRepo phyGeneralExaminationRepo;
	private PhyHeadToToeExaminationRepo phyHeadToToeExaminationRepo;
	private SysCardiovascularExaminationRepo sysCardiovascularExaminationRepo;
	private SysCentralNervousExaminationRepo sysCentralNervousExaminationRepo;
	private SysGastrointestinalExaminationRepo sysGastrointestinalExaminationRepo;
	private SysGenitourinarySystemExaminationRepo sysGenitourinarySystemExaminationRepo;
	private SysMusculoskeletalSystemExaminationRepo sysMusculoskeletalSystemExaminationRepo;
	private SysObstetricExaminationRepo sysObstetricExaminationRepo;
	private SysRespiratoryExaminationRepo sysRespiratoryExaminationRepo;

	private NurseServiceImpl nurseServiceImpl;
	private BenMedHistoryRepo benMedHistoryRepo;
	private BencomrbidityCondRepo bencomrbidityCondRepo;
	private BenMedicationHistoryRepo benMedicationHistoryRepo;
	private BenMenstrualDetailsRepo benMenstrualDetailsRepo;
	private FemaleObstetricHistoryRepo femaleObstetricHistoryRepo;
	private PerinatalHistoryRepo perinatalHistoryRepo;
	private ChildOptionalVaccineDetailRepo childOptionalVaccineDetailRepo;
	private BenChildDevelopmentHistoryRepo benChildDevelopmentHistoryRepo;
	private BenPersonalHabitRepo benPersonalHabitRepo;
	private BenAllergyHistoryRepo benAllergyHistoryRepo;
	private BenFamilyHistoryRepo benFamilyHistoryRepo;
	private ChildFeedingDetailsRepo childFeedingDetailsRepo;
	private ChildVaccineDetail1Repo childVaccineDetail1Repo;
	private ANCDiagnosisRepo ancDiagnosisRepo;

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

	@Autowired
	public void setBenAdherenceRepo(BenAdherenceRepo benAdherenceRepo) {
		this.benAdherenceRepo = benAdherenceRepo;
	}

	@Autowired
	public void setAncCareRepo(ANCCareRepo ancCareRepo) {
		this.ancCareRepo = ancCareRepo;
	}

	@Autowired
	public void setAncWomenVaccineRepo(ANCWomenVaccineRepo ancWomenVaccineRepo) {
		this.ancWomenVaccineRepo = ancWomenVaccineRepo;
	}

	@Autowired
	public void setPhyGeneralExaminationRepo(PhyGeneralExaminationRepo phyGeneralExaminationRepo) {
		this.phyGeneralExaminationRepo = phyGeneralExaminationRepo;
	}

	@Autowired
	public void setPhyHeadToToeExaminationRepo(PhyHeadToToeExaminationRepo phyHeadToToeExaminationRepo) {
		this.phyHeadToToeExaminationRepo = phyHeadToToeExaminationRepo;
	}

	@Autowired
	public void setSysCardiovascularExaminationRepo(SysCardiovascularExaminationRepo sysCardiovascularExaminationRepo) {
		this.sysCardiovascularExaminationRepo = sysCardiovascularExaminationRepo;
	}

	@Autowired
	public void setSysCentralNervousExaminationRepo(SysCentralNervousExaminationRepo sysCentralNervousExaminationRepo) {
		this.sysCentralNervousExaminationRepo = sysCentralNervousExaminationRepo;
	}

	@Autowired
	public void setSysGastrointestinalExaminationRepo(
			SysGastrointestinalExaminationRepo sysGastrointestinalExaminationRepo) {
		this.sysGastrointestinalExaminationRepo = sysGastrointestinalExaminationRepo;
	}

	@Autowired
	public void setSysGenitourinarySystemExaminationRepo(
			SysGenitourinarySystemExaminationRepo sysGenitourinarySystemExaminationRepo) {
		this.sysGenitourinarySystemExaminationRepo = sysGenitourinarySystemExaminationRepo;
	}

	@Autowired
	public void setSysMusculoskeletalSystemExaminationRepo(
			SysMusculoskeletalSystemExaminationRepo sysMusculoskeletalSystemExaminationRepo) {
		this.sysMusculoskeletalSystemExaminationRepo = sysMusculoskeletalSystemExaminationRepo;
	}

	@Autowired
	public void setSysObstetricExaminationRepo(SysObstetricExaminationRepo sysObstetricExaminationRepo) {
		this.sysObstetricExaminationRepo = sysObstetricExaminationRepo;
	}

	@Autowired
	public void setSysRespiratoryExaminationRepo(SysRespiratoryExaminationRepo sysRespiratoryExaminationRepo) {
		this.sysRespiratoryExaminationRepo = sysRespiratoryExaminationRepo;
	}

	@Autowired
	public void setBenMedHistoryRepo(BenMedHistoryRepo benMedHistoryRepo) {
		this.benMedHistoryRepo = benMedHistoryRepo;
	}

	@Autowired
	public void setBencomrbidityCondRepo(BencomrbidityCondRepo bencomrbidityCondRepo) {
		this.bencomrbidityCondRepo = bencomrbidityCondRepo;
	}

	@Autowired
	public void setBenMedicationHistoryRepo(BenMedicationHistoryRepo benMedicationHistoryRepo) {
		this.benMedicationHistoryRepo = benMedicationHistoryRepo;
	}

	@Autowired
	public void setBenMenstrualDetailsRepo(BenMenstrualDetailsRepo benMenstrualDetailsRepo) {
		this.benMenstrualDetailsRepo = benMenstrualDetailsRepo;
	}

	@Autowired
	public void setPerinatalHistoryRepo(PerinatalHistoryRepo perinatalHistoryRepo) {
		this.perinatalHistoryRepo = perinatalHistoryRepo;
	}

	@Autowired
	public void setBenChildDevelopmentHistoryRepo(BenChildDevelopmentHistoryRepo benChildDevelopmentHistoryRepo) {
		this.benChildDevelopmentHistoryRepo = benChildDevelopmentHistoryRepo;
	}

	@Autowired
	public void setBenPersonalHabitRepo(BenPersonalHabitRepo benPersonalHabitRepo) {
		this.benPersonalHabitRepo = benPersonalHabitRepo;
	}

	@Autowired
	public void setFemaleObstetricHistoryRepo(FemaleObstetricHistoryRepo femaleObstetricHistoryRepo) {
		this.femaleObstetricHistoryRepo = femaleObstetricHistoryRepo;
	}

	@Autowired
	public void setBenAllergyHistoryRepo(BenAllergyHistoryRepo benAllergyHistoryRepo) {
		this.benAllergyHistoryRepo = benAllergyHistoryRepo;
	}

	@Autowired
	public void setChildOptionalVaccineDetailRepo(ChildOptionalVaccineDetailRepo childOptionalVaccineDetailRepo) {
		this.childOptionalVaccineDetailRepo = childOptionalVaccineDetailRepo;
	}

	@Autowired
	public void setChildFeedingDetailsRepo(ChildFeedingDetailsRepo childFeedingDetailsRepo) {
		this.childFeedingDetailsRepo = childFeedingDetailsRepo;
	}

	@Autowired
	public void setBenFamilyHistoryRepo(BenFamilyHistoryRepo benFamilyHistoryRepo) {
		this.benFamilyHistoryRepo = benFamilyHistoryRepo;
	}

	@Autowired
	public void setChildVaccineDetail1Repo(ChildVaccineDetail1Repo childVaccineDetail1Repo) {
		this.childVaccineDetail1Repo = childVaccineDetail1Repo;
	}

	@Autowired
	public void setBenAnthropometryRepo(BenAnthropometryRepo benAnthropometryRepo) {
		this.benAnthropometryRepo = benAnthropometryRepo;
	}

	@Autowired
	public void setBenPhysicalVitalRepo(BenPhysicalVitalRepo benPhysicalVitalRepo) {
		this.benPhysicalVitalRepo = benPhysicalVitalRepo;
	}
	
	@Autowired
	public void setAncDiagnosisRepo(ANCDiagnosisRepo ancDiagnosisRepo) {
		this.ancDiagnosisRepo = ancDiagnosisRepo;
	}
	
	@Override
	public Long saveBeneficiaryANCDetails(ANCCareDetails ancCareDetails) {
		ANCCareDetails ancCareDetail = ancCareRepo.save(ancCareDetails);
		Long ancCareID = null;
		if (null != ancCareDetail && ancCareDetail.getID() > 0) {
			ancCareID = ancCareDetail.getID();
		}
		return ancCareID;
	}

	@Override
	public Long saveANCWomenVaccineDetails(List<ANCWomenVaccineDetail> ancWomenVaccineDetails) {
		List<ANCWomenVaccineDetail> ancWomenVaccineDetail = (List<ANCWomenVaccineDetail>) ancWomenVaccineRepo
				.save(ancWomenVaccineDetails);

		Long ancWomenVaccineID = null;
		if (null != ancWomenVaccineDetail && ancWomenVaccineDetail.size() > 0) {
			for (ANCWomenVaccineDetail ancWomenVaccine : ancWomenVaccineDetail) {
				ancWomenVaccineID = ancWomenVaccine.getID();
			}
		}
		return ancWomenVaccineID;
	}

	@Override
	public int saveBenAdherenceDetails(BenAdherence benAdherence) {
		int r = 0;
		BenAdherence benAdherenceOBJ = benAdherenceRepo.save(benAdherence);
		if (benAdherenceOBJ != null) {
			r = 1;
		}
		return r;
	}

	@Override
	public int saveBenChiefComplaints(List<BenChiefComplaint> benChiefComplaintList) {
		int r = 0;
		List<BenChiefComplaint> benChiefComplaintResultList = (List<BenChiefComplaint>) benChiefComplaintRepo
				.save(benChiefComplaintList);

		if (benChiefComplaintResultList != null && benChiefComplaintResultList.size() > 0) {
			r = benChiefComplaintResultList.size();
		}
		return r;
	}

	public Integer saveBenInvestigationFromDoc(WrapperBenInvestigationANC wrapperBenInvestigationANC) {
		int r = 0;
		ArrayList<LabTestOrderDetail> LabTestOrderDetailList = new ArrayList<>();
		ArrayList<LabTestOrderDetail> investigationList = wrapperBenInvestigationANC.getLaboratoryList();
		if (investigationList != null && investigationList.size() > 0) {

			for (LabTestOrderDetail testData : investigationList) {

				testData.setBeneficiaryRegID(wrapperBenInvestigationANC.getBeneficiaryRegID());
				testData.setBenVisitID(wrapperBenInvestigationANC.getBenVisitID());
				testData.setProviderServiceMapID(wrapperBenInvestigationANC.getProviderServiceMapID());
				testData.setCreatedBy(wrapperBenInvestigationANC.getCreatedBy());
				testData.setPrescriptionID(wrapperBenInvestigationANC.getPrescriptionID());

				LabTestOrderDetailList.add(testData);
			}
			ArrayList<LabTestOrderDetail> LabTestOrderDetailListRS = (ArrayList<LabTestOrderDetail>) labTestOrderDetailRepo
					.save(LabTestOrderDetailList);

			if (LabTestOrderDetailListRS != null && LabTestOrderDetailListRS.size() > 0) {
				r = 1;
			}
		} else {
			r = 1;
		}
		return r;
	}

	@Override
	public Long saveBenInvestigation(WrapperBenInvestigationANC wrapperBenInvestigationANC) {
		Long r = null;
		PrescriptionDetail prescriptionDetail = new PrescriptionDetail();
		prescriptionDetail.setBeneficiaryRegID(wrapperBenInvestigationANC.getBeneficiaryRegID());
		prescriptionDetail.setBenVisitID(wrapperBenInvestigationANC.getBenVisitID());
		prescriptionDetail.setProviderServiceMapID(wrapperBenInvestigationANC.getProviderServiceMapID());
		prescriptionDetail.setCreatedBy(wrapperBenInvestigationANC.getCreatedBy());

		Long prescriptionID = quickConsultationServiceImpl.saveBenPrescriptionForANC(prescriptionDetail);

		if (prescriptionID != null && prescriptionID > 0) {
			ArrayList<LabTestOrderDetail> LabTestOrderDetailList = new ArrayList<>();
			ArrayList<LabTestOrderDetail> investigationList = wrapperBenInvestigationANC.getLaboratoryList();
			if (investigationList != null && investigationList.size() > 0) {

				for (LabTestOrderDetail testData : investigationList) {

					testData.setPrescriptionID(prescriptionID);
					testData.setBeneficiaryRegID(wrapperBenInvestigationANC.getBeneficiaryRegID());
					testData.setBenVisitID(wrapperBenInvestigationANC.getBenVisitID());
					testData.setProviderServiceMapID(wrapperBenInvestigationANC.getProviderServiceMapID());
					testData.setCreatedBy(wrapperBenInvestigationANC.getCreatedBy());

					LabTestOrderDetailList.add(testData);
				}
				ArrayList<LabTestOrderDetail> LabTestOrderDetailListRS = (ArrayList<LabTestOrderDetail>) labTestOrderDetailRepo
						.save(LabTestOrderDetailList);

				if (prescriptionID > 0 && LabTestOrderDetailListRS.size() > 0) {
					r = prescriptionID;
				}

			} else {
				r = prescriptionID;
			}
		}

		return r;

	}

	@Override
	public int saveBenAncCareDetails(ANCCareDetails ancCareDetailsOBJ) throws ParseException {
		int r = 0;
		if (ancCareDetailsOBJ.getLmpDate() != null && !ancCareDetailsOBJ.getLmpDate().isEmpty()
				&& ancCareDetailsOBJ.getLmpDate().length() >= 10) {
			String lmpDate = ancCareDetailsOBJ.getLmpDate().split("T")[0];
			ancCareDetailsOBJ
			.setLastMenstrualPeriod_LMP(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(lmpDate).getTime()));
		}
		if (ancCareDetailsOBJ.getExpDelDt() != null && !ancCareDetailsOBJ.getExpDelDt().isEmpty()
				&& ancCareDetailsOBJ.getExpDelDt().length() >= 10) {
			String edDate = ancCareDetailsOBJ.getExpDelDt().split("T")[0];
			ancCareDetailsOBJ
			.setExpectedDateofDelivery(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(edDate).getTime()));
		}
		ANCCareDetails ancCareDetailsRS = ancCareRepo.save(ancCareDetailsOBJ);
		if (ancCareDetailsRS != null) {
			r = 1;
		}
		return r;
	}

	@Override
	public int saveAncImmunizationDetails(WrapperAncImmunization wrapperAncImmunizationOBJ) throws ParseException {
		int r = 0;
		List<ANCWomenVaccineDetail> ancWomenVaccineDetailList = getANCWomenVaccineDetail(wrapperAncImmunizationOBJ);
		List<ANCWomenVaccineDetail> ancWomenVaccineDetailRSList = (List<ANCWomenVaccineDetail>) ancWomenVaccineRepo
				.save(ancWomenVaccineDetailList);
		if (ancWomenVaccineDetailRSList != null && ancWomenVaccineDetailRSList.size() > 0)
			r = 1;
		return r;
	}

	private List<ANCWomenVaccineDetail> getANCWomenVaccineDetail(WrapperAncImmunization wrapperAncImmunizationOBJ)
			throws ParseException {
		List<ANCWomenVaccineDetail> ancWomenVaccineDetailList = new ArrayList<ANCWomenVaccineDetail>();
		ANCWomenVaccineDetail ancWomenVaccineDetail;
		if (wrapperAncImmunizationOBJ != null) {

			// TT-1 details
			ancWomenVaccineDetail = new ANCWomenVaccineDetail();
			ancWomenVaccineDetail.setBeneficiaryRegID(wrapperAncImmunizationOBJ.getBeneficiaryRegID());
			ancWomenVaccineDetail.setBenVisitID(wrapperAncImmunizationOBJ.getBenVisitID());
			ancWomenVaccineDetail.setProviderServiceMapID(wrapperAncImmunizationOBJ.getProviderServiceMapID());
			ancWomenVaccineDetail.setCreatedBy(wrapperAncImmunizationOBJ.getCreatedBy());
			ancWomenVaccineDetail.setID(wrapperAncImmunizationOBJ.gettT1ID());
			ancWomenVaccineDetail.setVaccineName("TT-1");
			ancWomenVaccineDetail.setStatus(wrapperAncImmunizationOBJ.gettT_1Status());
			if (wrapperAncImmunizationOBJ.getDateReceivedForTT_1() != null
					&& wrapperAncImmunizationOBJ.getDateReceivedForTT_1().length() >= 10) {
				String TT_1 = wrapperAncImmunizationOBJ.getDateReceivedForTT_1().split("T")[0];
				ancWomenVaccineDetail
				.setReceivedDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(TT_1).getTime()));
			}
			ancWomenVaccineDetail.setReceivedFacilityName(wrapperAncImmunizationOBJ.getFacilityNameOfTT_1());
			ancWomenVaccineDetail.setModifiedBy(wrapperAncImmunizationOBJ.getModifiedBy());
			ancWomenVaccineDetailList.add(ancWomenVaccineDetail);

			// TT-2 details
			ancWomenVaccineDetail = new ANCWomenVaccineDetail();
			ancWomenVaccineDetail.setBeneficiaryRegID(wrapperAncImmunizationOBJ.getBeneficiaryRegID());
			ancWomenVaccineDetail.setBenVisitID(wrapperAncImmunizationOBJ.getBenVisitID());
			ancWomenVaccineDetail.setProviderServiceMapID(wrapperAncImmunizationOBJ.getProviderServiceMapID());
			ancWomenVaccineDetail.setCreatedBy(wrapperAncImmunizationOBJ.getCreatedBy());
			ancWomenVaccineDetail.setID(wrapperAncImmunizationOBJ.gettT2ID());
			ancWomenVaccineDetail.setVaccineName("TT-2");
			ancWomenVaccineDetail.setStatus(wrapperAncImmunizationOBJ.gettT_2Status());
			if (wrapperAncImmunizationOBJ.getDateReceivedForTT_2() != null
					&& wrapperAncImmunizationOBJ.getDateReceivedForTT_2().length() >= 10) {
				String TT_2 = wrapperAncImmunizationOBJ.getDateReceivedForTT_2().split("T")[0];
				ancWomenVaccineDetail
				.setReceivedDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(TT_2).getTime()));
			}
			ancWomenVaccineDetail.setReceivedFacilityName(wrapperAncImmunizationOBJ.getFacilityNameOfTT_2());
			ancWomenVaccineDetail.setModifiedBy(wrapperAncImmunizationOBJ.getModifiedBy());
			ancWomenVaccineDetailList.add(ancWomenVaccineDetail);

			// TT-3 (Booster) details
			ancWomenVaccineDetail = new ANCWomenVaccineDetail();
			ancWomenVaccineDetail.setBeneficiaryRegID(wrapperAncImmunizationOBJ.getBeneficiaryRegID());
			ancWomenVaccineDetail.setBenVisitID(wrapperAncImmunizationOBJ.getBenVisitID());
			ancWomenVaccineDetail.setProviderServiceMapID(wrapperAncImmunizationOBJ.getProviderServiceMapID());
			ancWomenVaccineDetail.setCreatedBy(wrapperAncImmunizationOBJ.getCreatedBy());
			ancWomenVaccineDetail.setID(wrapperAncImmunizationOBJ.gettT3ID());
			ancWomenVaccineDetail.setVaccineName("TT-Booster");
			ancWomenVaccineDetail.setStatus(wrapperAncImmunizationOBJ.gettT_3Status());
			if (wrapperAncImmunizationOBJ.getDateReceivedForTT_3() != null
					&& wrapperAncImmunizationOBJ.getDateReceivedForTT_3().length() >= 10) {
				String TT_3 = wrapperAncImmunizationOBJ.getDateReceivedForTT_3().split("T")[0];
				ancWomenVaccineDetail
				.setReceivedDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(TT_3).getTime()));
			}
			ancWomenVaccineDetail.setReceivedFacilityName(wrapperAncImmunizationOBJ.getFacilityNameOfTT_3());
			ancWomenVaccineDetail.setModifiedBy(wrapperAncImmunizationOBJ.getModifiedBy());
			ancWomenVaccineDetailList.add(ancWomenVaccineDetail);

		}
		return ancWomenVaccineDetailList;
	}

	public int savePhyGeneralExamination(PhyGeneralExamination generalExamination) {
		int generalExaminationID = 0;
		String TypeOfDangerSigns = "";
		if (null != generalExamination.getTypeOfDangerSigns() && generalExamination.getTypeOfDangerSigns().size() > 0) {
			for (String TypeOfDangerSign : generalExamination.getTypeOfDangerSigns()) {
				TypeOfDangerSigns += TypeOfDangerSign + ",";
			}
			generalExamination.setTypeOfDangerSign(TypeOfDangerSigns);
		}

		PhyGeneralExamination response = phyGeneralExaminationRepo.save(generalExamination);
		if (null != response) {
			generalExaminationID = 1;
		}
		return generalExaminationID;
	}

	@Override
	public int savePhyHeadToToeExamination(PhyHeadToToeExamination headToToeExamination) {
		int examinationID = 0;
		PhyHeadToToeExamination response = phyHeadToToeExaminationRepo.save(headToToeExamination);

		if (null != response) {
			examinationID = 1;
		}
		return examinationID;
	}

	@Override
	public int saveSysCardiovascularExamination(SysCardiovascularExamination cardiovascularExamination) {
		int examinationID = 0;
		SysCardiovascularExamination response = sysCardiovascularExaminationRepo.save(cardiovascularExamination);

		if (null != response) {
			examinationID = 1;
		}
		return examinationID;
	}

	@Override
	public int saveSysCentralNervousExamination(SysCentralNervousExamination centralNervousExamination) {
		// TODO Auto-generated method stub
		int r = 0;
		SysCentralNervousExamination centralNervousExaminationRS = sysCentralNervousExaminationRepo
				.save(centralNervousExamination);
		if (centralNervousExaminationRS != null) {
			r = 1;
		}
		return r;
	}

	@Override
	public int saveSysGastrointestinalExamination(SysGastrointestinalExamination gastrointestinalExamination) {
		int examinationID = 0;
		SysGastrointestinalExamination response = sysGastrointestinalExaminationRepo.save(gastrointestinalExamination);
		if (null != response) {
			examinationID = 1;
		}
		return examinationID;
	}

	@Override
	public int saveSysGenitourinarySystemExamination(SysGenitourinarySystemExamination genitourinarySystemExamination) {
		// TODO Auto-generated method stub
		int r = 0;
		SysGenitourinarySystemExamination sysGenitourinarySystemExaminationRS = sysGenitourinarySystemExaminationRepo
				.save(genitourinarySystemExamination);
		if (null != sysGenitourinarySystemExaminationRS) {
			r = 1;
		}
		return r;
	}

	@Override
	public int saveSysMusculoskeletalSystemExamination(
			SysMusculoskeletalSystemExamination musculoskeletalSystemExamination) {
		// TODO Auto-generated method stub
		int r = 0;
		SysMusculoskeletalSystemExamination musculoskeletalSystemExaminationRS = sysMusculoskeletalSystemExaminationRepo
				.save(musculoskeletalSystemExamination);
		if (null != musculoskeletalSystemExaminationRS) {
			r = 1;
		}
		return r;
	}

	@Override
	public int saveSysObstetricExamination(SysObstetricExamination obstetricExamination) {
		// TODO Auto-generated method stub
		int r = 0;
		SysObstetricExamination obstetricExaminationRS = sysObstetricExaminationRepo.save(obstetricExamination);
		if (obstetricExaminationRS != null)
			r = 1;
		return r;
	}

	@Override
	public int saveSysRespiratoryExamination(SysRespiratoryExamination respiratoryExamination) {
		// TODO Auto-generated method stub
		int r = 0;
		SysRespiratoryExamination respiratoryExaminationRS = sysRespiratoryExaminationRepo.save(respiratoryExamination);
		if (respiratoryExaminationRS != null)
			r = 1;
		return r;
	}

	@Override
	public String getANCExaminationDetailsData(Long benRegID, Long benVisitID) {
		Map<String, Object> examinationDetailsMap = new HashMap<String, Object>();

		examinationDetailsMap.put("generalExamination", getGeneralExaminationData(benRegID, benVisitID));
		examinationDetailsMap.put("headToToeExamination", getHeadToToeExaminationData(benRegID, benVisitID));
		examinationDetailsMap.put("gastrointestinalExamination",
				getSysGastrointestinalExamination(benRegID, benVisitID));
		examinationDetailsMap.put("cardiovascularExamination", getCardiovascularExamination(benRegID, benVisitID));
		examinationDetailsMap.put("respiratoryExamination", getRespiratoryExamination(benRegID, benVisitID));
		examinationDetailsMap.put("centralNervousExamination", getSysCentralNervousExamination(benRegID, benVisitID));
		examinationDetailsMap.put("musculoskeletalExamination", getMusculoskeletalExamination(benRegID, benVisitID));
		examinationDetailsMap.put("genitourinaryExamination", getGenitourinaryExamination(benRegID, benVisitID));
		examinationDetailsMap.put("obstetricExamination", getSysObstetricExamination(benRegID, benVisitID));

		return new Gson().toJson(examinationDetailsMap);
	}

	private PhyGeneralExamination getGeneralExaminationData(Long benRegID, Long benVisitID) {
		PhyGeneralExamination phyGeneralExaminationData = phyGeneralExaminationRepo
				.getPhyGeneralExaminationData(benRegID, benVisitID);
		if (null != phyGeneralExaminationData) {
			String dSign = phyGeneralExaminationData.getTypeOfDangerSign();
			if (dSign != null && dSign.length() > 0) {
				String[] typeDangerSignArr = dSign.split(",");
				if (typeDangerSignArr != null && typeDangerSignArr.length > 0) {
					ArrayList<String> typeOfDangerSigns = new ArrayList<>();
					for (String typeDangerSign : typeDangerSignArr) {
						typeOfDangerSigns.add(typeDangerSign);
					}
					phyGeneralExaminationData.setTypeOfDangerSigns(typeOfDangerSigns);
				}
			} else {
				ArrayList<String> typeOfDangerSignsTmp = new ArrayList<>();
				phyGeneralExaminationData.setTypeOfDangerSigns(typeOfDangerSignsTmp);
			}

		}
		return phyGeneralExaminationData;

	}

	private PhyHeadToToeExamination getHeadToToeExaminationData(Long benRegID, Long benVisitID) {
		PhyHeadToToeExamination phyHeadToToeExaminationData = phyHeadToToeExaminationRepo
				.getPhyHeadToToeExaminationData(benRegID, benVisitID);

		return phyHeadToToeExaminationData;

	}

	private SysGastrointestinalExamination getSysGastrointestinalExamination(Long benRegID, Long benVisitID) {
		SysGastrointestinalExamination sysGastrointestinalExaminationData = sysGastrointestinalExaminationRepo
				.getSSysGastrointestinalExamination(benRegID, benVisitID);

		return sysGastrointestinalExaminationData;
	}

	private SysCardiovascularExamination getCardiovascularExamination(Long benRegID, Long benVisitID) {
		SysCardiovascularExamination sysCardiovascularExaminationData = sysCardiovascularExaminationRepo
				.getSysCardiovascularExaminationData(benRegID, benVisitID);

		return sysCardiovascularExaminationData;
	}

	private SysRespiratoryExamination getRespiratoryExamination(Long benRegID, Long benVisitID) {
		SysRespiratoryExamination sysRespiratoryExaminationData = sysRespiratoryExaminationRepo
				.getSysRespiratoryExaminationData(benRegID, benVisitID);

		return sysRespiratoryExaminationData;
	}

	private SysCentralNervousExamination getSysCentralNervousExamination(Long benRegID, Long benVisitID) {
		SysCentralNervousExamination sysCentralNervousExaminationData = sysCentralNervousExaminationRepo
				.getSysCentralNervousExaminationData(benRegID, benVisitID);

		return sysCentralNervousExaminationData;
	}

	private SysMusculoskeletalSystemExamination getMusculoskeletalExamination(Long benRegID, Long benVisitID) {
		SysMusculoskeletalSystemExamination sysMusculoskeletalSystemExaminationData = sysMusculoskeletalSystemExaminationRepo
				.getSysMusculoskeletalSystemExamination(benRegID, benVisitID);

		return sysMusculoskeletalSystemExaminationData;
	}

	private SysGenitourinarySystemExamination getGenitourinaryExamination(Long benRegID, Long benVisitID) {
		SysGenitourinarySystemExamination sysGenitourinarySystemExaminationData = sysGenitourinarySystemExaminationRepo
				.getSysGenitourinarySystemExaminationData(benRegID, benVisitID);

		return sysGenitourinarySystemExaminationData;
	}

	private SysObstetricExamination getSysObstetricExamination(Long benRegID, Long benVisitID) {
		SysObstetricExamination sysObstetricExaminationData = sysObstetricExaminationRepo
				.getSysObstetricExaminationData(benRegID, benVisitID);

		return sysObstetricExaminationData;
	}

	public String getBenVisitDetailsFrmNurseANC(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();

		resMap.put("ANCNurseVisitDetail",
				nurseServiceImpl.getCSVisitDetails(benRegID, benVisitID));

		resMap.put("BenAdherence", getBenAdherence(benRegID, benVisitID));

		resMap.put("BenChiefComplaints", getBenChiefComplaints(benRegID, benVisitID));

		resMap.put("LabTestOrders", getLabTestOrders(benRegID, benVisitID));

		return resMap.toString();
	}

	@Override
	public String getBenAdherence(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> resList = benAdherenceRepo.getBenAdherence(beneficiaryRegID, benVisitID);
		BenAdherence benAdherences = BenAdherence.getBenAdherences(resList);
		return new Gson().toJson(benAdherences);
	}

	@Override
	public String getBenChiefComplaints(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> resList = benChiefComplaintRepo.getBenChiefComplaints(beneficiaryRegID, benVisitID);
		ArrayList<BenChiefComplaint> benChiefComplaints = BenChiefComplaint.getBenChiefComplaints(resList);
		return new Gson().toJson(benChiefComplaints);
	}

	@Override
	public String getLabTestOrders(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> resList = labTestOrderDetailRepo.getLabTestOrderDetails(beneficiaryRegID, benVisitID);
		WrapperBenInvestigationANC labTestOrderDetails = LabTestOrderDetail.getLabTestOrderDetails(resList);
		return new Gson().toJson(labTestOrderDetails);
	}

	public String getBenANCDetailsFrmNurseANC(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();

		resMap.put("ANCCareDetail", getANCCareDetails(benRegID, benVisitID));

		resMap.put("ANCWomenVaccineDetails", getANCWomenVaccineDetails(benRegID, benVisitID));

		return resMap.toString();
	}

	@Override
	public String getANCCareDetails(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> resList = ancCareRepo.getANCCareDetails(beneficiaryRegID, benVisitID);
		ANCCareDetails ancCareDetails = ANCCareDetails.getANCCareDetails(resList);
		return new Gson().toJson(ancCareDetails);
	}

	@Override
	public String getANCWomenVaccineDetails(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> resList = ancWomenVaccineRepo.getANCWomenVaccineDetails(beneficiaryRegID, benVisitID);
		WrapperAncImmunization ancWomenVaccineDetails = ANCWomenVaccineDetail.getANCWomenVaccineDetails(resList);
		return new Gson().toJson(ancWomenVaccineDetails);
	}

	@Override
	public Integer saveAncDocFindings(WrapperAncFindings wrapperAncFindings) {
		int i = 0;
		BenClinicalObservations benClinicalObservationsRS = benClinicalObservationsRepo
				.save(getBenClinicalObservations(wrapperAncFindings));
		System.out.println("hii");
		ArrayList<BenChiefComplaint> benChiefComplaintListRS = (ArrayList<BenChiefComplaint>) benChiefComplaintRepo
				.save(getBenChiefComplaint(wrapperAncFindings));
		System.out.println("hii");
		if (benClinicalObservationsRS != null && benChiefComplaintListRS != null) {
			i = 1;
		}
		return i;
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

	private BenClinicalObservationsRepo benClinicalObservationsRepo;

	@Autowired
	private void setBenClinicalObservationsRepo(BenClinicalObservationsRepo benClinicalObservationsRepo) {
		this.benClinicalObservationsRepo = benClinicalObservationsRepo;
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

	public Long saveBenANCDiagnosis(PrescriptionDetail prescriptionDetail) {
		Long prescriptionID = null;
		PrescriptionDetail res = prescriptionDetailRepo.save(prescriptionDetail);
		if (null != res && res.getPrescriptionID() > 0) {
			prescriptionID = res.getPrescriptionID();
		}
		return prescriptionID;
	}

	public Long saveBenANCDiagnosis(ANCDiagnosis ancDiagnosis) {
		Long ID = null;
		ANCDiagnosis res = ancDiagnosisRepo.save(ancDiagnosis);
		if (null != res && res.getID() > 0) {
			ID = res.getID();
		}
		return ID;
	}
	
	private PrescribedDrugDetailRepo prescribedDrugDetailRepo;

	@Autowired
	public void setPrescribedDrugDetailRepo(PrescribedDrugDetailRepo prescribedDrugDetailRepo) {
		this.prescribedDrugDetailRepo = prescribedDrugDetailRepo;
	}

	@Override
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

	@Override
	public Integer saveBenANCPastHistory(BenMedHistory benMedHistory) {
		Integer r = 0;
		ArrayList<BenMedHistory> benMedHistoryList = benMedHistory.getBenPastHistory();
		ArrayList<BenMedHistory> res = (ArrayList<BenMedHistory>) benMedHistoryRepo.save(benMedHistoryList);
		if (null != res && res.size() > 0) {
			r = res.size();
		}
		return r;
	}

	@Override
	public Integer saveBenANCComorbidConditions(WrapperComorbidCondDetails wrapperComorbidCondDetails) {
		Integer r = 0;
		ArrayList<BencomrbidityCondDetails> bencomrbidityCondDetailsList = wrapperComorbidCondDetails
				.getComrbidityConds();
		ArrayList<BencomrbidityCondDetails> res = (ArrayList<BencomrbidityCondDetails>) bencomrbidityCondRepo
				.save(bencomrbidityCondDetailsList);
		if (null != res && res.size() > 0) {
			r = res.size();
		}
		return r;
	}

	@Override
	public Integer saveBenANCMedicationHistory(WrapperMedicationHistory wrapperMedicationHistory) {
		Integer r = 0;
		ArrayList<BenMedicationHistory> benMedicationHistoryList = wrapperMedicationHistory
				.getBenMedicationHistoryDetails();
		ArrayList<BenMedicationHistory> res = (ArrayList<BenMedicationHistory>) benMedicationHistoryRepo
				.save(benMedicationHistoryList);
		if (null != res && res.size() > 0) {
			r = res.size();
		}
		return r;
	}

	@Override
	public Integer saveBenANCMenstrualHistory(BenMenstrualDetails benMenstrualDetails) {
		Integer r = 0;

		BenMenstrualDetails res = benMenstrualDetailsRepo.save(benMenstrualDetails);
		if (null != res && res.getBenMenstrualID() > 0) {
			r = res.getBenMenstrualID();
		}
		return r;
	}

	@Override
	public Integer saveFemaleObstetricHistory(WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory) {
		Integer r = 0;

		ArrayList<FemaleObstetricHistory> FemaleObstetricHistorylist = wrapperFemaleObstetricHistory
				.getFemaleObstetricHistoryDetails();
		ArrayList<FemaleObstetricHistory> res = (ArrayList<FemaleObstetricHistory>) femaleObstetricHistoryRepo
				.save(FemaleObstetricHistorylist);
		if (null != res && res.size() > 0) {
			r = 1;
		}
		return r;
	}

	@Override
	public Integer savePerinatalHistory(PerinatalHistory perinatalHistory) {
		Integer r = 0;

		PerinatalHistory res = perinatalHistoryRepo.save(perinatalHistory);
		if (null != res && res.getID() > 0) {
			r = 1;
		}
		return r;
	}

	@Override
	public Integer saveChildOptionalVaccineDetail(WrapperChildOptionalVaccineDetail wrapperChildVaccineDetail) {
		Integer r = 0;
		ArrayList<ChildOptionalVaccineDetail> childOptionalVaccineDetails = wrapperChildVaccineDetail
				.getChildOptionalVaccineDetails();
		ArrayList<ChildOptionalVaccineDetail> res = (ArrayList<ChildOptionalVaccineDetail>) childOptionalVaccineDetailRepo
				.save(childOptionalVaccineDetails);
		if (null != res && res.size() > 0) {
			r = 1;
		}
		return r;
	}

	@Override
	public Integer saveChildDevelopmentHistory(BenChildDevelopmentHistory benChildDevelopmentHistory) {
		Integer r = 0;

		BenChildDevelopmentHistory childDevelopmentHistory = BenChildDevelopmentHistory
				.getDevelopmentHistory(benChildDevelopmentHistory);
		BenChildDevelopmentHistory res = benChildDevelopmentHistoryRepo.save(childDevelopmentHistory);
		if (null != res && res.getID() > 0) {
			r = 1;
		}
		return r;
	}

	@Override
	public Integer saveANCPersonalHistory(BenPersonalHabit benPersonalHabit) {
		Integer r = 0;

		ArrayList<BenPersonalHabit> personalHabits = benPersonalHabit.getPersonalHistory();
		ArrayList<BenPersonalHabit> res = (ArrayList<BenPersonalHabit>) benPersonalHabitRepo.save(personalHabits);
		if (null != res && res.size() > 0) {
			r = res.size();
		}
		return r;
	}

	@Override
	public Integer saveANCAllergyHistory(BenAllergyHistory benAllergyHistory) {
		Integer r = 0;

		ArrayList<BenAllergyHistory> allergyList = benAllergyHistory.getBenAllergicHistory();
		ArrayList<BenAllergyHistory> res = (ArrayList<BenAllergyHistory>) benAllergyHistoryRepo.save(allergyList);
		if (null != res && res.size() > 0) {
			r = res.size();
		}
		return r;
	}

	@Override
	public Integer saveANCBenFamilyHistory(BenFamilyHistory benFamilyHistory) {
		Integer r = 0;

		ArrayList<BenFamilyHistory> familyHistoryList = benFamilyHistory.getBenFamilyHistory();
		ArrayList<BenFamilyHistory> res = (ArrayList<BenFamilyHistory>) benFamilyHistoryRepo.save(familyHistoryList);
		if (null != res && res.size() > 0) {
			r = res.size();
		}
		return r;
	}

	@Override
	public Integer saveChildFeedingHistory(ChildFeedingDetails childFeedingDetails) {
		Integer r = 0;
		ChildFeedingDetails res = childFeedingDetailsRepo.save(childFeedingDetails);
		if (null != res && res.getID() > 0) {
			r = 1;
		}
		return r;
	}

	@Override
	public Integer saveANCImmunizationHistory(WrapperImmunizationHistory wrapperImmunizationHistory) {
		Integer r = 0;

		ArrayList<ChildVaccineDetail1> childVaccineDetails = wrapperImmunizationHistory.getBenChildVaccineDetails();
		ArrayList<ChildVaccineDetail1> res = (ArrayList<ChildVaccineDetail1>) childVaccineDetail1Repo
				.save(childVaccineDetails);
		if (null != res && res.size() > 0) {
			r = res.size();
		}
		return r;
	}

	@Override
	public String fetchBenPastMedicalHistory(Long benRegID) throws Exception {
		Map<String, Object> resMap = new HashMap<>();
		ArrayList<Object[]> benPastHistoryDataArray = benMedHistoryRepo.getBenPastHistory(benRegID);
		ArrayList<BenMedHistory> benMedHistoryArrayList = new ArrayList<>();
		if (benPastHistoryDataArray != null && benPastHistoryDataArray.size() > 0) {
			BenMedHistory benMedHistory;
			for (Object[] obj : benPastHistoryDataArray) {
				benMedHistory = new BenMedHistory((String) obj[0], (String) obj[1], (Date) obj[2], (String) obj[3],
						(String) obj[4], (Date) obj[5]);
				benMedHistoryArrayList.add(benMedHistory);
			}
		}

		Map<String, String> columnMap = new HashMap<>();
		List<Map<String, String>> columns = new ArrayList<Map<String, String>>();

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Illness Type");
		columnMap.put("keyName", "Illness_Type");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Other Illness Type");
		columnMap.put("keyName", "Other_Illness_Type");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Year Of Illness");
		columnMap.put("keyName", "Year_Of_Illness");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Surgery Type");
		columnMap.put("keyName", "Surgery_Type");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Other Surgery Type");
		columnMap.put("keyName", "Other_Surgery_Type");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Year Of Surgery");
		columnMap.put("keyName", "Year_Of_Surgery");
		columns.add(columnMap);

		resMap.put("columns", columns);
		resMap.put("data", benMedHistoryArrayList);

		return new Gson().toJson(resMap);

	}

	@Override
	public String fetchBenComorbidityHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> bencomrbidityCondDetails = bencomrbidityCondRepo.getBencomrbidityCondDetails(beneficiaryRegID);


		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column = new HashMap<String, Object>();
		column.put("columnName", "Comorbid Condition");
		column.put("keyName", "comorbidCondition");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Other Comorbid Condition");
		column.put("keyName", "otherComorbidCondition");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Year");
		column.put("keyName", "year");
		columns.add(column);



		ArrayList<BencomrbidityCondDetails> bencomrbidityConds = new ArrayList<BencomrbidityCondDetails>();
		if (null != bencomrbidityCondDetails) {
			for (Object[] obj : bencomrbidityCondDetails) {

				BencomrbidityCondDetails history = new BencomrbidityCondDetails((String)obj[0], (String)obj[1], (Timestamp)obj[2]);
				bencomrbidityConds.add(history);
			}

		}

		response.put("columns", columns);
		response.put("data", bencomrbidityConds);
		return new Gson().toJson(response);

	}

	@Override
	public String fetchBenPersonalTobaccoHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> benPersonalHabits = (ArrayList<Object[]>) benPersonalHabitRepo
				.getBenPersonalTobaccoHabitDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column.put("columnName", "Dietary Type");
		column.put("keyName", "dietaryType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Physical Activity Type");
		column.put("keyName", "physicalActivityType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Tobacco Use Status");
		column.put("keyName", "tobaccoUseStatus");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Tobacco Use Type ID");
		column.put("keyName", "tobaccoUseTypeID");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Tobacco Use Type");
		column.put("keyName", "tobaccoUseType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Other Tobacco Use Type");
		column.put("keyName", "otherTobaccoUseType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Number Per Day");
		column.put("keyName", "numberperDay");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Tobacco Use Duration");
		column.put("keyName", "tobaccoUseDuration");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Risky Sexual Practices Status");
		column.put("keyName", "riskySexualPracticesStatus");
		columns.add(column);

		ArrayList<BenPersonalHabit> personalHabits = new ArrayList<BenPersonalHabit>();
		if (null != benPersonalHabits) {
			for (Object[] obj : benPersonalHabits) {

				BenPersonalHabit benPersonalHabit = new BenPersonalHabit((String) obj[0], (String) obj[1],
						(String) obj[2], (String) obj[3], (String) obj[4], (String) obj[5], (Short) obj[6],
						(Timestamp) obj[7], (Character) obj[8]);

				personalHabits.add(benPersonalHabit);
			}
		}

		response.put("columns", columns);
		response.put("data", personalHabits);
		return new Gson().toJson(response);

	}

	@Override
	public String fetchBenPersonalAlcoholHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> benPersonalHabits = (ArrayList<Object[]>) benPersonalHabitRepo
				.getBenPersonalAlcoholHabitDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column.put("columnName", "Dietary Type");
		column.put("keyName", "dietaryType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Physical Activity Type");
		column.put("keyName", "physicalActivityType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Alcohol Intake Status");
		column.put("keyName", "alcoholIntakeStatus");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Alcohol Type ID");
		column.put("keyName", "alcoholTypeID");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Alcohol Type");
		column.put("keyName", "alcoholType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Other Alcohol Type");
		column.put("keyName", "otherAlcoholType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Alcohol Intake Frequency");
		column.put("keyName", "alcoholIntakeFrequency");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Avg Alcohol Consumption");
		column.put("keyName", "avgAlcoholConsumption");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Alcohol Duration");
		column.put("keyName", "alcoholDuration");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Risky Sexual Practices Status");
		column.put("keyName", "riskySexualPracticesStatus");
		columns.add(column);

		ArrayList<BenPersonalHabit> personalHabits = new ArrayList<BenPersonalHabit>();
		if (null != benPersonalHabits) {
			for (Object[] obj : benPersonalHabits) {
				BenPersonalHabit benPersonalHabit = new BenPersonalHabit((String) obj[0], (String) obj[1],
						(String) obj[2], (String) obj[3], (String) obj[4], (String) obj[5], (String) obj[6],
						(String) obj[7], (Timestamp) obj[8], (Character) obj[9]);
				personalHabits.add(benPersonalHabit);
			}
		}

		response.put("columns", columns);
		response.put("data", personalHabits);
		return new Gson().toJson(response);

	}

	@Override
	public String fetchBenPersonalAllergyHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> benPersonalHabits = (ArrayList<Object[]>) benAllergyHistoryRepo
				.getBenPersonalAllergyDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column.put("columnName", "Allergy Status");
		column.put("keyName", "allergyStatus");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Allergy Type");
		column.put("keyName", "allergyType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Allergy Name");
		column.put("keyName", "allergenName");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Allergic Reaction Type ID");
		column.put("keyName", "allergicReactionTypeID");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Allergic Reaction Type");
		column.put("keyName", "allergicReactionType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Other Allergic Reaction");
		column.put("keyName", "otherAllergicReaction");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Remarks");
		column.put("keyName", "remarks");
		columns.add(column);

		ArrayList<BenAllergyHistory> personalHabits = new ArrayList<BenAllergyHistory>();
		if (null != benPersonalHabits) {
			for (Object[] obj : benPersonalHabits) {
				BenAllergyHistory benPersonalHabit = new BenAllergyHistory((String) obj[0], (String) obj[1],
						(String) obj[2], (String) obj[3], (String) obj[4], (String) obj[5], (String) obj[6]);
				personalHabits.add(benPersonalHabit);
			}

		}

		response.put("columns", columns);
		response.put("data", personalHabits);
		return new Gson().toJson(response);

	}

	@Override
	public String fetchBenPersonalMedicationHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> beMedicationHistory = benMedicationHistoryRepo
				.getBenMedicationHistoryDetail(beneficiaryRegID);


		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column.put("columnName", "Current Medication");
		column.put("keyName", "currentMedication");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Year");
		column.put("keyName", "year");
		columns.add(column);

		ArrayList<BenMedicationHistory> medicationHistory = new ArrayList<BenMedicationHistory>();
		if (null != beMedicationHistory) {
			for (Object[] obj : beMedicationHistory) {
				BenMedicationHistory history = new BenMedicationHistory((String) obj[0], (Timestamp) obj[1]);
				medicationHistory.add(history);
			}

		}

		response.put("columns", columns);
		response.put("data", medicationHistory);
		return new Gson().toJson(response);

	}

	@Override
	public String fetchBenPersonalFamilyHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> benFamilyHistory = benFamilyHistoryRepo
				.getBenFamilyHistoryDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column.put("columnName", "Family Member");
		column.put("keyName", "familyMember");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Disease Type ID");
		column.put("keyName", "diseaseTypeID");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Disease Type");
		column.put("keyName", "diseaseType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Other Disease Type");
		column.put("keyName", "otherDiseaseType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Is Genetic Disorder");
		column.put("keyName", "isGeneticDisorder");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Genetic Disorder");
		column.put("keyName", "geneticDisorder");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Is Consanguineous Marrige");
		column.put("keyName", "isConsanguineousMarrige");
		columns.add(column);

		ArrayList<BenFamilyHistory> familyHistory = new ArrayList<BenFamilyHistory>();
		if (null != benFamilyHistory) {
			for (Object[] obj : benFamilyHistory) {
				BenFamilyHistory history = new BenFamilyHistory((String)obj[0], (Short)obj[1], (String)obj[2], (String)obj[3], (Boolean)obj[4],
						(String)obj[5], (Boolean)obj[6]);
				familyHistory.add(history);
			}

		}

		response.put("columns", columns);
		response.put("data", familyHistory);
		return new Gson().toJson(response);

	}

	@Override
	public String fetchBenMenstrualHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> benMenstrualDetails = benMenstrualDetailsRepo
				.getBenMenstrualDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column.put("columnName", "Menstrual Cycle Status ID");
		column.put("keyName", "menstrualCycleStatusID");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Regularity");
		column.put("keyName", "regularity");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Menstrual Cycle Length ID");
		column.put("keyName", "menstrualCyclelengthID");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Cycle Length");
		column.put("keyName", "cycleLength");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Menstrual Flow Duration ID");
		column.put("keyName", "menstrualFlowDurationID");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Blood Flow Duration");
		column.put("keyName", "bloodFlowDuration");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Problem Name");
		column.put("keyName", "problemName");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "LMPDate");
		column.put("keyName", "lMPDate");
		columns.add(column);

		ArrayList<BenMenstrualDetails> menstrualDetails = new ArrayList<BenMenstrualDetails>();
		if (null != benMenstrualDetails) {
			for (Object[] obj : benMenstrualDetails) {
				BenMenstrualDetails history = new BenMenstrualDetails((Short)obj[0], (String)obj[1], (Short)obj[2], (String)obj[3], 
						(Short)obj[4], (String)obj[5], (Short)obj[6], (String)obj[7], (Timestamp)obj[8]);
				menstrualDetails.add(history);
			}

		}

		response.put("columns", columns);
		response.put("data", menstrualDetails);
		return new Gson().toJson(response);

	}	

	@Override
	public String fetchBenPastObstetricHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> femaleObstetricHistory = femaleObstetricHistoryRepo.getBenFemaleObstetricHistoryDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column.put("columnName", "Preg Order");
		column.put("keyName", "pregOrder");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Preg Complication ID");
		column.put("keyName", "pregComplicationID");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Preg Complication Type");
		column.put("keyName", "pregComplicationType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Other Preg Complication");
		column.put("keyName", "otherPregComplication");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Preg Duration ID");
		column.put("keyName", "pregDurationID");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Duration Type");
		column.put("keyName", "durationType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Delivery Type ID");
		column.put("keyName", "deliveryTypeID");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Delivery Type");
		column.put("keyName", "deliveryType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Delivery Place ID");
		column.put("keyName", "deliveryPlaceID");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Delivery Place");
		column.put("keyName", "deliveryPlace");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Other Delivery Place");
		column.put("keyName", "otherDeliveryPlace");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Delivery Complication ID");
		column.put("keyName", "deliveryComplicationID");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Delivery Complication Type");
		column.put("keyName", "deliveryComplicationType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Other Delivery Complication");
		column.put("keyName", "otherDeliveryComplication");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Preg Outcome ID");
		column.put("keyName", "pregOutcomeID");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Preg Outcome");
		column.put("keyName", "pregOutcome");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Postpartum Complication ID");
		column.put("keyName", "postpartumComplicationID");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Postpartum Complication Type");
		column.put("keyName", "postpartumComplicationType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Other Postpartum CompType");
		column.put("keyName", "otherPostpartumCompType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Post Natal Complication ID");
		column.put("keyName", "postNatalComplicationID");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Post Natal Complication");
		column.put("keyName", "postNatalComplication");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Other Post Natal Complication");
		column.put("keyName", "otherPostNatalComplication");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Congenital Anomalies");
		column.put("keyName", "congenitalAnomalies");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "New Born Complication ID");
		column.put("keyName", "newBornComplicationID");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "New Born Complication");
		column.put("keyName", "newBornComplication");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Other New Born Complication");
		column.put("keyName", "otherNewBornComplication");
		columns.add(column);

		ArrayList<FemaleObstetricHistory> femaleObstetricDetails = new ArrayList<FemaleObstetricHistory>();
		if (null != femaleObstetricHistory) {
			for (Object[] obj : femaleObstetricHistory) {		

				FemaleObstetricHistory history = new FemaleObstetricHistory((Short)obj[0], (Short)obj[1], (String)obj[2], 
						(String)obj[3], (Short)obj[4], (String)obj[5], (Short)obj[6], (String)obj[7], (Short)obj[8], (String)obj[9],
						(String)obj[10], (Short)obj[11], (String)obj[12], (String)obj[13], (Short)obj[14], (String)obj[15], (Short)obj[16], 
						(String)obj[17],(String)obj[18], (Short)obj[19], (String)obj[20], (String)obj[21], (String)obj[22], (Short)obj[23],(String)obj[24], (String)obj[25]);
				femaleObstetricDetails.add(history);
			}

		}

		response.put("columns", columns);
		response.put("data", femaleObstetricDetails);
		return new Gson().toJson(response);

	}

	@Override
	public String fetchBenOptionalVaccineHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> childOptionalVaccineDetail = childOptionalVaccineDetailRepo.getBenOptionalVaccineDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column.put("columnName", "Default Receiving Age");
		column.put("keyName", "defaultReceivingAge");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Vaccine Name");
		column.put("keyName", "vaccineName");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Status");
		column.put("keyName", "status");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Received Date");
		column.put("keyName", "receivedDate");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Actual Receiving Age");
		column.put("keyName", "actualReceivingAge");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Received Facility Name");
		column.put("keyName", "receivedFacilityName");
		columns.add(column);

		ArrayList<ChildOptionalVaccineDetail> childOptionalVaccineDetails = new ArrayList<ChildOptionalVaccineDetail>();
		if (null != childOptionalVaccineDetail) {
			for (Object[] obj : childOptionalVaccineDetail) {
				ChildOptionalVaccineDetail history = new ChildOptionalVaccineDetail((String)obj[0], (String)obj[1], (String)obj[2], (Timestamp)obj[3], 
						(String)obj[4], (String)obj[5]);
				childOptionalVaccineDetails.add(history);
			}
		}

		response.put("columns", columns);
		response.put("data", childOptionalVaccineDetails);
		return new Gson().toJson(response);

	}

	@Override
	public String fetchBenImmunizationHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> childVaccineDetail = childVaccineDetail1Repo.getBenChildVaccineDetails(beneficiaryRegID);
	
		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column.put("columnName", "Default Receiving Age");
		column.put("keyName", "defaultReceivingAge");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Vaccine Name");
		column.put("keyName", "vaccineName");
		columns.add(column);
		
		column = new HashMap<String, Object>();
		column.put("columnName", "Status");
		column.put("keyName", "status");
		columns.add(column);

		
		ArrayList<ChildVaccineDetail1> childVaccineDetails = new ArrayList<ChildVaccineDetail1>();
		if (null != childVaccineDetail) {
			for (Object[] obj : childVaccineDetail) {
				ChildVaccineDetail1 history = new ChildVaccineDetail1((String)obj[0], (String)obj[1], (Boolean)obj[2]);
				childVaccineDetails.add(history);
			}
		}
		
		response.put("columns", columns);
		response.put("data", childVaccineDetails);
		return new Gson().toJson(response);

	}
	
	@Override
	public String getBenANCHistoryDetails(Long benRegID, Long benVisitID) {
		Map<String, Object> HistoryDetailsMap = new HashMap<String, Object>();

		HistoryDetailsMap.put("PastHistory", getPastHistoryData(benRegID, benVisitID));
		HistoryDetailsMap.put("ComorbidityConditions", getComorbidityConditionsHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("MedicationHistory", getMedicationHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("PersonalHistory", getPersonalHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("FamilyHistory", getFamilyHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("MenstrualHistory", getMenstrualHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("FemaleObstetricHistory", getFemaleObstetricHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("ImmunizationHistory", getImmunizationHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("childOptionalVaccineHistory", getChildOptionalVaccineHistory(benRegID, benVisitID));

		return new Gson().toJson(HistoryDetailsMap);
	}


	public BenMedHistory getPastHistoryData(Long beneficiaryRegID, Long benVisitID){
		ArrayList<Object[]>  pastHistory = benMedHistoryRepo.getBenPastHistory(beneficiaryRegID, benVisitID);

		BenMedHistory medHistory = new BenMedHistory();
		BenMedHistory benMedHistory = medHistory.getBenPastHistory(pastHistory);
		return benMedHistory;
	}

	public WrapperComorbidCondDetails getComorbidityConditionsHistory(Long beneficiaryRegID, Long benVisitID){
		ArrayList<Object[]>  comrbidityConds = bencomrbidityCondRepo.getBencomrbidityCondDetails(beneficiaryRegID, benVisitID);

		WrapperComorbidCondDetails comrbidityCondDetails = WrapperComorbidCondDetails.getComorbidityDetails(comrbidityConds);
		return comrbidityCondDetails;
	}

	public WrapperMedicationHistory getMedicationHistory(Long beneficiaryRegID, Long benVisitID){
		ArrayList<Object[]>  medicationHistory = benMedicationHistoryRepo.getBenMedicationHistoryDetail(beneficiaryRegID, benVisitID);

		WrapperMedicationHistory wrapperMedicationHistory = WrapperMedicationHistory.getMedicationHistoryDetails(medicationHistory);
		return wrapperMedicationHistory;
	}

	public BenPersonalHabit getPersonalHistory(Long beneficiaryRegID, Long benVisitID){
		ArrayList<Object[]>  personalDetails = benPersonalHabitRepo.getBenPersonalHabitDetail(beneficiaryRegID, benVisitID);

		ArrayList<Object[]>  allergyDetails = benAllergyHistoryRepo.getBenPersonalAllergyDetail(beneficiaryRegID, benVisitID);

		BenPersonalHabit personalHabits = BenPersonalHabit.getPersonalDetails(personalDetails);
		ArrayList<BenAllergyHistory>  allergyList= BenAllergyHistory.getBenAllergicHistory(allergyDetails);
		if(null != allergyList && allergyList.size()>0){
			personalHabits.setAllergyStatus(allergyList.get(0).getAllergyStatus());
			personalHabits.setAllergicList(allergyList);
		}


		return personalHabits;
	}

	public BenFamilyHistory getFamilyHistory(Long beneficiaryRegID, Long benVisitID){
		ArrayList<Object[]>  familyHistory = benFamilyHistoryRepo.getBenFamilyHistoryDetail(beneficiaryRegID, benVisitID);
		BenFamilyHistory familyHistoryDetails = BenFamilyHistory.getBenFamilyHistory(familyHistory);

		return familyHistoryDetails;
	}

	public BenMenstrualDetails getMenstrualHistory(Long beneficiaryRegID, Long benVisitID){
		ArrayList<Object[]>  menstrualHistory = benMenstrualDetailsRepo.getBenMenstrualDetail(beneficiaryRegID, benVisitID);
		BenMenstrualDetails menstrualHistoryDetails = BenMenstrualDetails.getBenMenstrualDetails(menstrualHistory);

		return menstrualHistoryDetails;
	}

	public WrapperFemaleObstetricHistory getFemaleObstetricHistory(Long beneficiaryRegID, Long benVisitID){
		ArrayList<Object[]>  femaleObstetricHistory = femaleObstetricHistoryRepo.getBenFemaleObstetricHistoryDetail(beneficiaryRegID, benVisitID);
		WrapperFemaleObstetricHistory femaleObstetricHistoryDetails = WrapperFemaleObstetricHistory.getFemaleObstetricHistory(femaleObstetricHistory);

		return femaleObstetricHistoryDetails;
	}

	public WrapperChildOptionalVaccineDetail getChildOptionalVaccineHistory(Long beneficiaryRegID, Long benVisitID){
		ArrayList<Object[]>  childOptionalVaccineDetail = childOptionalVaccineDetailRepo.getBenOptionalVaccineDetail(beneficiaryRegID, benVisitID);
		WrapperChildOptionalVaccineDetail childOptionalVaccineDetails = WrapperChildOptionalVaccineDetail.getChildOptionalVaccineDetail(childOptionalVaccineDetail);

		return childOptionalVaccineDetails;
	}

	
	public WrapperImmunizationHistory getImmunizationHistory(Long beneficiaryRegID, Long benVisitID){
		ArrayList<Object[]>  childVaccineDetail = childVaccineDetail1Repo.getBenChildVaccineDetails(beneficiaryRegID, benVisitID);
		WrapperImmunizationHistory childVaccineDetails = WrapperImmunizationHistory.getChildVaccineDetail(childVaccineDetail);
		
		return childVaccineDetails;
	}
	
	@Override
	public int updateBenAdherenceDetails(BenAdherence benAdherence) {
		int r = 0;
		String processed = benAdherenceRepo.getBenAdherenceDetailsStatus(benAdherence.getBeneficiaryRegID(), 
				benAdherence.getBenVisitID(), benAdherence.getID());
		if( null != processed && !"N".equals(processed)){
			processed = "U";
		}
		r = benAdherenceRepo.updateBenAdherence(benAdherence.getToDrugs(), benAdherence.getDrugReason(), benAdherence.getToReferral(), 
				benAdherence.getReferralReason(), benAdherence.getProgress(), benAdherence.getModifiedBy(), processed, benAdherence.getBeneficiaryRegID(), 
				benAdherence.getBenVisitID(), benAdherence.getID());
		/*BenAdherence  adherence= benAdherenceRepo.save(benAdherence);
		if(null !=adherence){
			r=1;
		}*/
		return r;
	}

	@Override
	public int updateBenChiefComplaints(List<BenChiefComplaint> benChiefComplaintList) {
		int r = 0;
		if(null != benChiefComplaintList && benChiefComplaintList.size()>0){
			benChiefComplaintRepo.deleteExistingBenChiefComplaints(benChiefComplaintList.get(0).getBeneficiaryRegID(), 
					benChiefComplaintList.get(0).getBenVisitID());
			
			List<BenChiefComplaint> benChiefComplaintResultList = (List<BenChiefComplaint>) benChiefComplaintRepo
						.save(benChiefComplaintList);
	
			if (benChiefComplaintResultList != null && benChiefComplaintResultList.size() > 0) {
				r = benChiefComplaintResultList.size();
			}
		}
		return r;
	}

	@Override
	public Long updateBenInvestigation(WrapperBenInvestigationANC wrapperBenInvestigationANC) {
		Long r = null;
		PrescriptionDetail prescriptionDetail = new PrescriptionDetail();
		prescriptionDetail.setBeneficiaryRegID(wrapperBenInvestigationANC.getBeneficiaryRegID());
		prescriptionDetail.setBenVisitID(wrapperBenInvestigationANC.getBenVisitID());
		prescriptionDetail.setProviderServiceMapID(wrapperBenInvestigationANC.getProviderServiceMapID());
		prescriptionDetail.setCreatedBy(wrapperBenInvestigationANC.getCreatedBy());

		Long prescriptionID = quickConsultationServiceImpl.saveBenPrescriptionForANC(prescriptionDetail);

		if (prescriptionID != null && prescriptionID > 0) {
			ArrayList<LabTestOrderDetail> LabTestOrderDetailList = new ArrayList<>();
			ArrayList<LabTestOrderDetail> investigationList = wrapperBenInvestigationANC.getLaboratoryList();
			if (investigationList != null && investigationList.size() > 0) {

				labTestOrderDetailRepo.deleteExistingLabTestOrderDetail(wrapperBenInvestigationANC.getBeneficiaryRegID(), wrapperBenInvestigationANC.getBenVisitID());

				for (LabTestOrderDetail testData : investigationList) {

					testData.setPrescriptionID(prescriptionID);
					testData.setBeneficiaryRegID(wrapperBenInvestigationANC.getBeneficiaryRegID());
					testData.setBenVisitID(wrapperBenInvestigationANC.getBenVisitID());
					testData.setProviderServiceMapID(wrapperBenInvestigationANC.getProviderServiceMapID());
					testData.setCreatedBy(wrapperBenInvestigationANC.getCreatedBy());

					LabTestOrderDetailList.add(testData);
				}
				ArrayList<LabTestOrderDetail> LabTestOrderDetailListRS = (ArrayList<LabTestOrderDetail>) labTestOrderDetailRepo
						.save(LabTestOrderDetailList);

				if (prescriptionID > 0 && LabTestOrderDetailListRS.size() > 0) {
					r = prescriptionID;
				}

			} else {
				r = prescriptionID;
			}
		}

		return r;

	}

	@Override
	public int updateBenAncCareDetails(ANCCareDetails ancCareDetailsOBJ) throws ParseException {
		int r = 0;
		
		String processed = ancCareRepo.getBenANCCareDetailsStatus(ancCareDetailsOBJ.getBeneficiaryRegID(), 
				ancCareDetailsOBJ.getBenVisitID());
		if( null != processed && !"N".equals(processed)){
			processed = "U";
		}
		
		if (ancCareDetailsOBJ.getLmpDate() != null && !ancCareDetailsOBJ.getLmpDate().isEmpty()
				&& ancCareDetailsOBJ.getLmpDate().length() >= 10) {
			String lmpDate = ancCareDetailsOBJ.getLmpDate().split("T")[0];
			ancCareDetailsOBJ
			.setLastMenstrualPeriod_LMP(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(lmpDate).getTime()));
		}
		if (ancCareDetailsOBJ.getExpDelDt() != null && !ancCareDetailsOBJ.getExpDelDt().isEmpty()
				&& ancCareDetailsOBJ.getExpDelDt().length() >= 10) {
			String edDate = ancCareDetailsOBJ.getExpDelDt().split("T")[0];
			ancCareDetailsOBJ
			.setExpectedDateofDelivery(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(edDate).getTime()));
		}
		r = ancCareRepo.updateANCCareDetails(ancCareDetailsOBJ.getComolaintType(), ancCareDetailsOBJ.getDuration(), 
				ancCareDetailsOBJ.getDescription(), ancCareDetailsOBJ.getaNCRegistrationDate(), ancCareDetailsOBJ.getaNCVisitNumber(), 
				ancCareDetailsOBJ.getLastMenstrualPeriod_LMP(), ancCareDetailsOBJ.getGestationalAgeOrPeriodofAmenorrhea_POA(), 
				ancCareDetailsOBJ.getTrimesterNumber(), ancCareDetailsOBJ.getExpectedDateofDelivery(), ancCareDetailsOBJ.getPrimiGravida(), 
				ancCareDetailsOBJ.getObstetricFormula(), ancCareDetailsOBJ.getGravida_G(), ancCareDetailsOBJ.getTermDeliveries_T(), 
				ancCareDetailsOBJ.getPretermDeliveries_P(), ancCareDetailsOBJ.getAbortions_A(), ancCareDetailsOBJ.getLivebirths_L(), 
				ancCareDetailsOBJ.getBloodGroup(), ancCareDetailsOBJ.getModifiedBy(), processed, ancCareDetailsOBJ.getBeneficiaryRegID(), ancCareDetailsOBJ.getBenVisitID());
		return r;
	}	

	@Override
	public int updateBenAncImmunizationDetails(WrapperAncImmunization wrapperAncImmunization) throws ParseException {
		int r = 0;
		
		List<ANCWomenVaccineDetail> ancWomenVaccineDetailList = getANCWomenVaccineDetail(wrapperAncImmunization);
		
		if(null != ancWomenVaccineDetailList){
			
			String processed = "N";
			ANCWomenVaccineDetail ancWomenVaccine = ancWomenVaccineDetailList.get(0);
			ArrayList<Object[]> ancWomenVaccineStatuses = ancWomenVaccineRepo.getBenANCWomenVaccineStatus(ancWomenVaccine.getBeneficiaryRegID(), 
					ancWomenVaccine.getBenVisitID());
			Map<String, String> womenVaccineStatuses = new HashMap<String, String>();
			
			for(Object[] obj : ancWomenVaccineStatuses){
				womenVaccineStatuses.put((String)obj[0], (String)obj[1]);
			}
			
			for(ANCWomenVaccineDetail ancWomenVaccineDetail : ancWomenVaccineDetailList){
				processed = womenVaccineStatuses.get(ancWomenVaccineDetail.getVaccineName());
				if(!processed.equals("N")){
					processed = "U";
				}
				
				r = ancWomenVaccineRepo.updateANCImmunizationDetails(ancWomenVaccineDetail.getStatus(), ancWomenVaccineDetail.getReceivedDate(),
					ancWomenVaccineDetail.getReceivedFacilityName(), ancWomenVaccineDetail.getModifiedBy(), processed, ancWomenVaccineDetail.getBeneficiaryRegID(),
					 ancWomenVaccineDetail.getBenVisitID(), ancWomenVaccineDetail.getVaccineName());
				
			}
		}
		return r;
	}

	@Override
	public int updateBenAncPastHistoryDetails(BenMedHistory benMedHistory) throws ParseException {
		Integer r = 0;
		if(null !=benMedHistory){
			//Delete Existing past History of beneficiary before inserting updated history
			benMedHistoryRepo.deleteExistingBenMedHistory(benMedHistory.getBeneficiaryRegID(), benMedHistory.getBenVisitID());

			ArrayList<BenMedHistory> benMedHistoryList = benMedHistory.getBenPastHistory();
			ArrayList<BenMedHistory> res = (ArrayList<BenMedHistory>) benMedHistoryRepo.save(benMedHistoryList);
			if (null != res && res.size() > 0) {
				r = res.size();
			}
		}
		return r;
	}

	@Override
	public Integer updateBenANCComorbidConditions(WrapperComorbidCondDetails wrapperComorbidCondDetails) {
		Integer r = 0;
		if(null != wrapperComorbidCondDetails){
			bencomrbidityCondRepo.deleteExistingBenComrbidityCondDetails(wrapperComorbidCondDetails.getBeneficiaryRegID(), 
					wrapperComorbidCondDetails.getBenVisitID());

			ArrayList<BencomrbidityCondDetails> bencomrbidityCondDetailsList = wrapperComorbidCondDetails
					.getComrbidityConds();
			ArrayList<BencomrbidityCondDetails> res = (ArrayList<BencomrbidityCondDetails>) bencomrbidityCondRepo
					.save(bencomrbidityCondDetailsList);
			if (null != res && res.size() > 0) {
				r = res.size();
			}
		}
		return r;
	}

	@Override
	public Integer updateBenANCMedicationHistory(WrapperMedicationHistory wrapperMedicationHistory) {
		Integer r = 0;
		if(null != wrapperMedicationHistory){
			benMedicationHistoryRepo.deleteExistingBenMedicationHistory(wrapperMedicationHistory.getBeneficiaryRegID(), 
					wrapperMedicationHistory.getBenVisitID());

			ArrayList<BenMedicationHistory> benMedicationHistoryList = wrapperMedicationHistory
					.getBenMedicationHistoryDetails();
			ArrayList<BenMedicationHistory> res = (ArrayList<BenMedicationHistory>) benMedicationHistoryRepo
					.save(benMedicationHistoryList);
			if (null != res && res.size() > 0) {
				r = res.size();
			}
		}
		return r;
	}

	@Override
	public Integer updateBenANCPersonalHistory(BenPersonalHabit benPersonalHabit) {
		Integer r = 0;
		if(null != benPersonalHabit){
			benPersonalHabitRepo.deleteExistingBenPersonalHistory(benPersonalHabit.getBeneficiaryRegID(), 
					benPersonalHabit.getBenVisitID());

			ArrayList<BenPersonalHabit> personalHabits = benPersonalHabit.getPersonalHistory();
			ArrayList<BenPersonalHabit> res = (ArrayList<BenPersonalHabit>) benPersonalHabitRepo.save(personalHabits);
			if (null != res && res.size() > 0) {
				r = res.size();
			}
		}
		return r;
	}

	@Override
	public Integer updateBenANCAllergicHistory(BenAllergyHistory benAllergyHistory) {
		Integer r = 0;
		if(null != benAllergyHistory){
			benAllergyHistoryRepo.deleteExistingBenAllergyHistory(benAllergyHistory.getBeneficiaryRegID(), 
					benAllergyHistory.getBenVisitID());

			ArrayList<BenAllergyHistory> allergyList = benAllergyHistory.getBenAllergicHistory();
			ArrayList<BenAllergyHistory> res = (ArrayList<BenAllergyHistory>) benAllergyHistoryRepo.save(allergyList);
			if (null != res && res.size() > 0) {
				r = res.size();
			}
		}
		return r;
	}

	@Override
	public Integer updateBenANCFamilyHistory(BenFamilyHistory benFamilyHistory) {
		Integer r = 0;
		if(null != benFamilyHistory){
			benFamilyHistoryRepo.deleteExistingBenFamilyHistory(benFamilyHistory.getBeneficiaryRegID(), 
					benFamilyHistory.getBenVisitID());

			ArrayList<BenFamilyHistory> familyHistoryList = benFamilyHistory.getBenFamilyHistory();
			ArrayList<BenFamilyHistory> res = (ArrayList<BenFamilyHistory>) benFamilyHistoryRepo.save(familyHistoryList);
			if (null != res && res.size() > 0) {
				r = res.size();
			}
		}
		return r;
	}

	@Override
	public Integer updateChildOptionalVaccineDetail(WrapperChildOptionalVaccineDetail wrapperChildOptionalVaccineDetail) {
		Integer r = 0;
		if(null != wrapperChildOptionalVaccineDetail){
			childOptionalVaccineDetailRepo.deleteExistingChildOptionalVaccineDetail(wrapperChildOptionalVaccineDetail.getBeneficiaryRegID(), 
					wrapperChildOptionalVaccineDetail.getBenVisitID());

			ArrayList<ChildOptionalVaccineDetail> childOptionalVaccineDetails = wrapperChildOptionalVaccineDetail
					.getChildOptionalVaccineDetails();
			ArrayList<ChildOptionalVaccineDetail> res = (ArrayList<ChildOptionalVaccineDetail>) childOptionalVaccineDetailRepo
					.save(childOptionalVaccineDetails);
			if (null != res && res.size() > 0) {
				r = 1;
			}
		}
		return r;
	}
	
	@Override
	public Integer updateANCChildImmunizationDetail(WrapperImmunizationHistory wrapperImmunizationHistory) {
		Integer r = 0;

		ArrayList<ChildVaccineDetail1> childVaccineDetails = wrapperImmunizationHistory.getBenChildVaccineDetails();
		
		if(null != childVaccineDetails){
			String processed = "N";
			ChildVaccineDetail1 childVaccine = childVaccineDetails.get(0);
			ArrayList<Object[]> childVaccineStatuses = childVaccineDetail1Repo.getBenChildVaccineDetailStatus(childVaccine.getBeneficiaryRegID(), 
					childVaccine.getBenVisitID());
			
			Map<String, String> vaccineStatuses = new HashMap<String, String>();
			
			for(Object[] obj : childVaccineStatuses){
				vaccineStatuses.put((String)obj[0]+"-"+(String)obj[1], (String)obj[2]);
			}
			
			for(ChildVaccineDetail1 childVaccineDetail:childVaccineDetails){
				
				processed = vaccineStatuses.get(childVaccineDetail.getDefaultReceivingAge()+"-"+childVaccineDetail.getVaccineName());
				if( null != processed && !processed.equals("N")){
					processed = "U";
				}
				r = childVaccineDetail1Repo.updateChildANCImmunization(
						childVaccineDetail.getStatus(), childVaccineDetail.getModifiedBy(), processed, childVaccineDetail.getBeneficiaryRegID(), 
						childVaccineDetail.getBenVisitID(), childVaccineDetail.getDefaultReceivingAge(), childVaccineDetail.getVaccineName());
			}
		}
		return r;
	}

	@Override
	public Integer updateANCAnthropometryDetails(BenAnthropometryDetail anthropometryDetail) {
		Integer r = 0;
		if(null != anthropometryDetail){
			
			String processed = benAnthropometryRepo.getBenAnthropometryStatus(anthropometryDetail.getBeneficiaryRegID(), 
					anthropometryDetail.getBenVisitID());
			if(!processed.equals("N")){
				processed = "U";
			}
			
//			anthropometryDetail.setModifiedBy(anthropometryDetail.getCreatedBy());
			r = benAnthropometryRepo.updateANCCareDetails(
					anthropometryDetail.getWeight_Kg(), 
					anthropometryDetail.getHeight_cm(), 
					anthropometryDetail.getbMI(),
					anthropometryDetail.getHeadCircumference_cm(), 
					anthropometryDetail.getMidUpperArmCircumference_MUAC_cm(), 
					anthropometryDetail.getHipCircumference_cm(), 
					anthropometryDetail.getWaistCircumference_cm(), 
					anthropometryDetail.getWaistHipRatio(), 
					anthropometryDetail.getModifiedBy(), 
					processed,
					anthropometryDetail.getBeneficiaryRegID(), 
					anthropometryDetail.getBenVisitID());
		}
		return r;
	}

	@Override
	public Integer updateANCPhysicalVitalDetails(BenPhysicalVitalDetail physicalVitalDetail) {
		Integer r = 0;
		if(null != physicalVitalDetail) {
			
			String processed = benPhysicalVitalRepo.getBenPhysicalVitalStatus(physicalVitalDetail.getBeneficiaryRegID(), 
					physicalVitalDetail.getBenVisitID());
			if(!processed.equals("N")){
				processed = "U";
			}
			
			physicalVitalDetail.setAverageSystolicBP(physicalVitalDetail.getSystolicBP_1stReading());
			physicalVitalDetail.setAverageDiastolicBP(physicalVitalDetail.getDiastolicBP_1stReading());
			r = benPhysicalVitalRepo.updateANCCareDetails(
					physicalVitalDetail.getTemperature(), 
					physicalVitalDetail.getPulseRate(), 
					physicalVitalDetail.getRespiratoryRate(), 
					physicalVitalDetail.getSystolicBP_1stReading(), 
					physicalVitalDetail.getDiastolicBP_1stReading(), 
					physicalVitalDetail.getAverageSystolicBP(),
					physicalVitalDetail.getAverageDiastolicBP(),
					physicalVitalDetail.getCapillaryRefillTime(), 
					physicalVitalDetail.getModifiedBy(), 
					processed,
					physicalVitalDetail.getBeneficiaryRegID(),
					physicalVitalDetail.getBenVisitID());
		}
		return r;
	}
	
	public int updatePhyGeneralExamination(PhyGeneralExamination generalExamination) {
		int response = 0;
		String TypeOfDangerSigns = "";
		
		if(null!=generalExamination){
			
			String processed = phyGeneralExaminationRepo.getBenGeneralExaminationStatus(generalExamination.getBeneficiaryRegID(), 
					generalExamination.getBenVisitID());
			if(!processed.equals("N")){
				processed = "U";
			}
			
			if (null != generalExamination.getTypeOfDangerSigns() && generalExamination.getTypeOfDangerSigns().size() > 0) {
				for (String TypeOfDangerSign : generalExamination.getTypeOfDangerSigns()) {
					TypeOfDangerSigns += TypeOfDangerSign + ",";
				}
				generalExamination.setTypeOfDangerSign(TypeOfDangerSigns);
			}
	
			response = phyGeneralExaminationRepo.updatePhyGeneralExamination(generalExamination.getConsciousness(), generalExamination.getCoherence(), 
					generalExamination.getCooperation(), generalExamination.getComfortness(), generalExamination.getBuiltAndAppearance(), generalExamination.getGait(), 
					generalExamination.getDangerSigns(), generalExamination.getTypeOfDangerSign(), generalExamination.getPallor(), generalExamination.getJaundice(), 
					generalExamination.getCyanosis(), generalExamination.getClubbing(), generalExamination.getLymphadenopathy(), generalExamination.getLymphnodesInvolved(),generalExamination.getTypeOfLymphadenopathy(),
					generalExamination.getEdema(), generalExamination.getExtentOfEdema(), generalExamination.getEdemaType(), generalExamination.getModifiedBy(), processed,
					generalExamination.getBeneficiaryRegID(), generalExamination.getBenVisitID());
		}
		return response;
	}
	
	@Override
	public int updatePhyHeadToToeExamination(PhyHeadToToeExamination headToToeExamination) {
		int response = 0;
		if(null!=headToToeExamination){
			String processed = phyHeadToToeExaminationRepo.getBenHeadToToeExaminationStatus(headToToeExamination.getBeneficiaryRegID(), 
					headToToeExamination.getBenVisitID());
			if(!processed.equals("N")){
				processed = "U";
			}
			response = phyHeadToToeExaminationRepo.updatePhyHeadToToeExamination(headToToeExamination.getHeadtoToeExam(), 
					headToToeExamination.getHead(), headToToeExamination.getEyes(), headToToeExamination.getEars(), headToToeExamination.getNose(), 
					headToToeExamination.getOralCavity(), headToToeExamination.getThroat(), headToToeExamination.getBreastAndNipples(), headToToeExamination.getTrunk(), 
					headToToeExamination.getUpperLimbs(), headToToeExamination.getLowerLimbs(), headToToeExamination.getSkin(), headToToeExamination.getHair(), 
					headToToeExamination.getNails(), headToToeExamination.getModifiedBy(), processed, headToToeExamination.getBeneficiaryRegID(), headToToeExamination.getBenVisitID());
		}
		return response;
	}
	
	@Override
	public int updateSysGastrointestinalExamination(SysGastrointestinalExamination gastrointestinalExamination) {
		int response = 0;
		if(null!=gastrointestinalExamination){
			String processed = sysGastrointestinalExaminationRepo.getBenGastrointestinalExaminationStatus(gastrointestinalExamination.getBeneficiaryRegID(), 
					gastrointestinalExamination.getBenVisitID());
			if(!processed.equals("N")){
				processed = "U";
			}
			response = sysGastrointestinalExaminationRepo.updateSysGastrointestinalExamination(gastrointestinalExamination.getInspection(), 
					gastrointestinalExamination.getPalpation(), gastrointestinalExamination.getPalpation_AbdomenTexture(), gastrointestinalExamination.getPalpation_Liver(), 
					gastrointestinalExamination.getPalpation_Spleen(), gastrointestinalExamination.getPalpation_Tenderness(), gastrointestinalExamination.getPalpation_LocationOfTenderness(),
					gastrointestinalExamination.getPercussion(), gastrointestinalExamination.getAuscultation(), gastrointestinalExamination.getAnalRegion(), 
					gastrointestinalExamination.getModifiedBy(), processed, gastrointestinalExamination.getBeneficiaryRegID(), gastrointestinalExamination.getBenVisitID());
		}
		return response;
	}
	
	@Override
	public int updateSysCardiovascularExamination(SysCardiovascularExamination cardiovascular) {
		int response = 0;
		if(null!=cardiovascular){
			String processed = sysCardiovascularExaminationRepo.getBenCardiovascularExaminationStatus(cardiovascular.getBeneficiaryRegID(), 
					cardiovascular.getBenVisitID());
			if(!processed.equals("N")){
				processed = "U";
			}
			response = sysCardiovascularExaminationRepo.updateSysCardiovascularExamination(cardiovascular.getJugularVenousPulse_JVP(), 
					cardiovascular.getApexbeatLocation(), cardiovascular.getApexbeatType(), cardiovascular.getFirstHeartSound_S1(), cardiovascular.getSecondHeartSound_S2(),
					cardiovascular.getAdditionalHeartSounds(), cardiovascular.getMurmurs(), cardiovascular.getPericardialRub(), cardiovascular.getModifiedBy(),
					processed, cardiovascular.getBeneficiaryRegID(), cardiovascular.getBenVisitID());
		}
		return response;
	}
	
	@Override
	public int updateSysRespiratoryExamination(SysRespiratoryExamination respiratory) {
		int r = 0;
		if(null!=respiratory){
			String processed = sysRespiratoryExaminationRepo.getBenRespiratoryExaminationStatus(respiratory.getBeneficiaryRegID(), 
					respiratory.getBenVisitID());
			if(!processed.equals("N")){
				processed = "U";
			}
			r = sysRespiratoryExaminationRepo.updateSysRespiratoryExamination(respiratory.getTrachea(), 
					respiratory.getInspection(), respiratory.getSignsOfRespiratoryDistress(), respiratory.getPalpation(), respiratory.getAuscultation(), 
					respiratory.getAuscultation_Stridor(), respiratory.getAuscultation_BreathSounds(), respiratory.getAuscultation_Crepitations(), 
					respiratory.getAuscultation_Wheezing(), respiratory.getAuscultation_PleuralRub(), respiratory.getAuscultation_ConductedSounds(), 
					respiratory.getPercussion(), respiratory.getModifiedBy(), processed, respiratory.getBeneficiaryRegID(), respiratory.getBenVisitID());
		}
		return r;
	}
	
	@Override
	public int updateSysCentralNervousExamination(SysCentralNervousExamination centralNervous) {
		int r = 0;
		if(null!=centralNervous){
			String processed = sysCentralNervousExaminationRepo.getBenCentralNervousExaminationStatus(centralNervous.getBeneficiaryRegID(), 
					centralNervous.getBenVisitID());
			if(!processed.equals("N")){
				processed = "U";
			}
			r = sysCentralNervousExaminationRepo.updateSysCentralNervousExamination(centralNervous.getHandedness(),
					centralNervous.getCranialNervesExamination(), centralNervous.getMotorSystem(), centralNervous.getSensorySystem(), centralNervous.getAutonomicSystem(),
					centralNervous.getCerebellarSigns(), centralNervous.getSignsOfMeningealIrritation(), centralNervous.getSkull(), centralNervous.getModifiedBy(),
					processed, centralNervous.getBeneficiaryRegID(), centralNervous.getBenVisitID());
		}
	
		return r;
	}
	
	@Override
	public int updateSysMusculoskeletalSystemExamination(SysMusculoskeletalSystemExamination musculoskeletalSystem) {
		int r = 0;
		if(null!=musculoskeletalSystem){
			String processed = sysMusculoskeletalSystemExaminationRepo.getBenMusculoskeletalSystemExaminationStatus(musculoskeletalSystem.getBeneficiaryRegID(), 
					musculoskeletalSystem.getBenVisitID());
			if(!processed.equals("N")){
				processed = "U";
			}
			r = sysMusculoskeletalSystemExaminationRepo.updateSysMusculoskeletalSystemExamination(musculoskeletalSystem.getJoint_TypeOfJoint(), 
					musculoskeletalSystem.getJoint_Laterality(), musculoskeletalSystem.getJoint_Abnormality(), musculoskeletalSystem.getUpperLimb_Laterality(), 
					musculoskeletalSystem.getUpperLimb_Laterality(), musculoskeletalSystem.getLowerLimb_Laterality(), musculoskeletalSystem.getLowerLimb_Abnormality(),
					musculoskeletalSystem.getChestWall(), musculoskeletalSystem.getSpine(), musculoskeletalSystem.getModifiedBy(), processed,
					musculoskeletalSystem.getBeneficiaryRegID(), musculoskeletalSystem.getBenVisitID());
		}
		return r;
	}
	
	@Override
	public int updateSysGenitourinarySystemExamination(SysGenitourinarySystemExamination genitourinarySystem) {
		int r = 0;
		if(null!=genitourinarySystem){
			String processed = sysGenitourinarySystemExaminationRepo.getBenGenitourinarySystemExaminationStatus(genitourinarySystem.getBeneficiaryRegID(), 
					genitourinarySystem.getBenVisitID());
			if(!processed.equals("N")){
				processed = "U";
			}
			r = sysGenitourinarySystemExaminationRepo.updateSysGenitourinarySystemExamination(
					genitourinarySystem.getRenalAngle(), genitourinarySystem.getSuprapubicRegion(), genitourinarySystem.getExternalGenitalia(), 
					genitourinarySystem.getModifiedBy(), processed, genitourinarySystem.getBeneficiaryRegID(), genitourinarySystem.getBenVisitID());
		}
		return r;
	}
	
	@Override
	public int updateSysObstetricExamination(SysObstetricExamination obstetricExamination) {
		int r = 0;
		if(null!=obstetricExamination){
			String processed = sysObstetricExaminationRepo.getBenObstetricExaminationStatus(obstetricExamination.getBeneficiaryRegID(), 
					obstetricExamination.getBenVisitID());
			if(!processed.equals("N")){
				processed = "U";
			}
			r = sysObstetricExaminationRepo.updateSysObstetricExamination(obstetricExamination.getFundalHeight(), 
					obstetricExamination.getfHAndPOA_Status(), obstetricExamination.getfHAndPOA_Interpretation(), obstetricExamination.getFetalMovements(), 
					obstetricExamination.getFetalHeartSounds(), obstetricExamination.getFetalHeartRate_BeatsPerMinute(), obstetricExamination.getFetalPositionOrLie(), 
					obstetricExamination.getFetalPresentation(), obstetricExamination.getAbdominalScars(), obstetricExamination.getModifiedBy(), processed, 
					obstetricExamination.getBeneficiaryRegID(), obstetricExamination.getBenVisitID());
		}
		return r;
	}

	@Override
	public int updateANCMenstrualHistory(BenMenstrualDetails benMenstrualDetails) {
		int response = 0;
		if(null != benMenstrualDetails) {
			String processed = benMenstrualDetailsRepo.getBenMenstrualDetailStatus(benMenstrualDetails.getBeneficiaryRegID(), 
					benMenstrualDetails.getBenVisitID());
			if(!processed.equals("N")){
				processed = "U";
			}
			response = benMenstrualDetailsRepo.updateMenstrualDetails(
					benMenstrualDetails.getMenstrualCycleStatusID(), 
					benMenstrualDetails.getRegularity(),
					benMenstrualDetails.getMenstrualCyclelengthID(), 
					benMenstrualDetails.getCycleLength(), 
					benMenstrualDetails.getMenstrualFlowDurationID(), 
					benMenstrualDetails.getBloodFlowDuration(), 
					benMenstrualDetails.getMenstrualProblemID(), 
					benMenstrualDetails.getProblemName(), 
					benMenstrualDetails.getlMPDate(), 
					benMenstrualDetails.getModifiedBy(), 
					processed,
					benMenstrualDetails.getBeneficiaryRegID(), 
					benMenstrualDetails.getBenVisitID()); 
		}
		return response;
	}

	@Override
	public int updateANCPastObstetricHistory(WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory) {
		Integer r = 0;
		if(null != wrapperFemaleObstetricHistory){
			femaleObstetricHistoryRepo.deleteExistingObstetricHistory(wrapperFemaleObstetricHistory.getBeneficiaryRegID(), wrapperFemaleObstetricHistory.getBenVisitID());

			ArrayList<FemaleObstetricHistory> femaleObstetricHistoryDetails = wrapperFemaleObstetricHistory
					.getFemaleObstetricHistoryDetails();
			ArrayList<FemaleObstetricHistory> res = (ArrayList<FemaleObstetricHistory>) femaleObstetricHistoryRepo
					.save(femaleObstetricHistoryDetails);
			if (null != res && res.size() > 0) {
				r = 1;
			}
		}
		return r;
	}

}
