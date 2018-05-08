package com.iemr.mmu.service.common.transaction;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
import com.iemr.mmu.data.anc.SysRespiratoryExamination;
import com.iemr.mmu.data.anc.WrapperBenInvestigationANC;
import com.iemr.mmu.data.anc.WrapperChildOptionalVaccineDetail;
import com.iemr.mmu.data.anc.WrapperComorbidCondDetails;
import com.iemr.mmu.data.anc.WrapperFemaleObstetricHistory;
import com.iemr.mmu.data.anc.WrapperImmunizationHistory;
import com.iemr.mmu.data.anc.WrapperMedicationHistory;
import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;
import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;
import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;
import com.iemr.mmu.data.registrar.WrapperRegWorklist;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.nurse.BenAnthropometryRepo;
import com.iemr.mmu.repo.nurse.BenPhysicalVitalRepo;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;
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
import com.iemr.mmu.repo.nurse.anc.SysRespiratoryExaminationRepo;
import com.iemr.mmu.repo.quickConsultation.BenChiefComplaintRepo;
import com.iemr.mmu.repo.quickConsultation.LabTestOrderDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescribedDrugDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenData;
import com.iemr.mmu.repo.registrar.ReistrarRepoBenSearch;
import com.iemr.mmu.utils.mapper.InputMapper;

@Service
public class CommonNurseServiceImpl implements CommonNurseService {
	private BenVisitDetailRepo benVisitDetailRepo;
	private BenChiefComplaintRepo benChiefComplaintRepo;
	private BenMedHistoryRepo benMedHistoryRepo;
	private BencomrbidityCondRepo bencomrbidityCondRepo;
	private BenMedicationHistoryRepo benMedicationHistoryRepo;
	private FemaleObstetricHistoryRepo femaleObstetricHistoryRepo;
	private BenMenstrualDetailsRepo benMenstrualDetailsRepo;
	private BenFamilyHistoryRepo benFamilyHistoryRepo;
	private BenPersonalHabitRepo benPersonalHabitRepo;
	private BenAllergyHistoryRepo benAllergyHistoryRepo;
	private ChildOptionalVaccineDetailRepo childOptionalVaccineDetailRepo;
	private ChildVaccineDetail1Repo childVaccineDetail1Repo;
	private BenAnthropometryRepo benAnthropometryRepo;
	private BenPhysicalVitalRepo benPhysicalVitalRepo;
	private PhyGeneralExaminationRepo phyGeneralExaminationRepo;
	private PhyHeadToToeExaminationRepo phyHeadToToeExaminationRepo;
	private SysGastrointestinalExaminationRepo sysGastrointestinalExaminationRepo;
	private SysCardiovascularExaminationRepo sysCardiovascularExaminationRepo;
	private SysRespiratoryExaminationRepo sysRespiratoryExaminationRepo;
	private SysCentralNervousExaminationRepo sysCentralNervousExaminationRepo;
	private SysMusculoskeletalSystemExaminationRepo sysMusculoskeletalSystemExaminationRepo;
	private SysGenitourinarySystemExaminationRepo sysGenitourinarySystemExaminationRepo;
	private RegistrarRepoBenData registrarRepoBenData;
	private PrescriptionDetailRepo prescriptionDetailRepo;
	private LabTestOrderDetailRepo labTestOrderDetailRepo;
	private PrescribedDrugDetailRepo prescribedDrugDetailRepo;
	private ReistrarRepoBenSearch reistrarRepoBenSearch;
	private BenAdherenceRepo benAdherenceRepo;
	private BenChildDevelopmentHistoryRepo benChildDevelopmentHistoryRepo;
	private ChildFeedingDetailsRepo childFeedingDetailsRepo;
	private PerinatalHistoryRepo perinatalHistoryRepo;
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;

	@Autowired
	public void setBeneficiaryFlowStatusRepo(BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo) {
		this.beneficiaryFlowStatusRepo = beneficiaryFlowStatusRepo;
	}

	@Autowired
	public void setBenChildDevelopmentHistoryRepo(BenChildDevelopmentHistoryRepo benChildDevelopmentHistoryRepo) {
		this.benChildDevelopmentHistoryRepo = benChildDevelopmentHistoryRepo;
	}

	@Autowired
	public void setChildFeedingDetailsRepo(ChildFeedingDetailsRepo childFeedingDetailsRepo) {
		this.childFeedingDetailsRepo = childFeedingDetailsRepo;
	}

	@Autowired
	public void setPerinatalHistoryRepo(PerinatalHistoryRepo perinatalHistoryRepo) {
		this.perinatalHistoryRepo = perinatalHistoryRepo;
	}

	@Autowired
	public void setBenAdherenceRepo(BenAdherenceRepo benAdherenceRepo) {
		this.benAdherenceRepo = benAdherenceRepo;
	}

	@Autowired
	public void setReistrarRepoBenSearch(ReistrarRepoBenSearch reistrarRepoBenSearch) {
		this.reistrarRepoBenSearch = reistrarRepoBenSearch;
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
	public void setPrescriptionDetailRepo(PrescriptionDetailRepo prescriptionDetailRepo) {
		this.prescriptionDetailRepo = prescriptionDetailRepo;
	}

	@Autowired
	public void setPhyGeneralExaminationRepo(PhyGeneralExaminationRepo phyGeneralExaminationRepo) {
		this.phyGeneralExaminationRepo = phyGeneralExaminationRepo;
	}

	@Autowired
	public void setRegistrarRepoBenData(RegistrarRepoBenData registrarRepoBenData) {
		this.registrarRepoBenData = registrarRepoBenData;
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
	public void setSysCentralNervousExaminationRepo(SysCentralNervousExaminationRepo sysCentralNervousExaminationRepo) {
		this.sysCentralNervousExaminationRepo = sysCentralNervousExaminationRepo;
	}

	@Autowired
	public void setSysRespiratoryExaminationRepo(SysRespiratoryExaminationRepo sysRespiratoryExaminationRepo) {
		this.sysRespiratoryExaminationRepo = sysRespiratoryExaminationRepo;
	}

	@Autowired
	public void setSysCardiovascularExaminationRepo(SysCardiovascularExaminationRepo sysCardiovascularExaminationRepo) {
		this.sysCardiovascularExaminationRepo = sysCardiovascularExaminationRepo;
	}

	@Autowired
	public void setSysGastrointestinalExaminationRepo(
			SysGastrointestinalExaminationRepo sysGastrointestinalExaminationRepo) {
		this.sysGastrointestinalExaminationRepo = sysGastrointestinalExaminationRepo;
	}

	@Autowired
	public void setPhyHeadToToeExaminationRepo(PhyHeadToToeExaminationRepo phyHeadToToeExaminationRepo) {
		this.phyHeadToToeExaminationRepo = phyHeadToToeExaminationRepo;
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
	public void setChildVaccineDetail1Repo(ChildVaccineDetail1Repo childVaccineDetail1Repo) {
		this.childVaccineDetail1Repo = childVaccineDetail1Repo;
	}

	@Autowired
	public void setChildOptionalVaccineDetailRepo(ChildOptionalVaccineDetailRepo childOptionalVaccineDetailRepo) {
		this.childOptionalVaccineDetailRepo = childOptionalVaccineDetailRepo;
	}

	@Autowired
	public void setBenAllergyHistoryRepo(BenAllergyHistoryRepo benAllergyHistoryRepo) {
		this.benAllergyHistoryRepo = benAllergyHistoryRepo;
	}

	@Autowired
	public void setBenPersonalHabitRepo(BenPersonalHabitRepo benPersonalHabitRepo) {
		this.benPersonalHabitRepo = benPersonalHabitRepo;
	}

	@Autowired
	public void setBenFamilyHistoryRepo(BenFamilyHistoryRepo benFamilyHistoryRepo) {
		this.benFamilyHistoryRepo = benFamilyHistoryRepo;
	}

	@Autowired
	public void setBenMenstrualDetailsRepo(BenMenstrualDetailsRepo benMenstrualDetailsRepo) {
		this.benMenstrualDetailsRepo = benMenstrualDetailsRepo;
	}

	@Autowired
	public void setFemaleObstetricHistoryRepo(FemaleObstetricHistoryRepo femaleObstetricHistoryRepo) {
		this.femaleObstetricHistoryRepo = femaleObstetricHistoryRepo;
	}

	@Autowired
	public void setBenMedicationHistoryRepo(BenMedicationHistoryRepo benMedicationHistoryRepo) {
		this.benMedicationHistoryRepo = benMedicationHistoryRepo;
	}

	@Autowired
	public void setBencomrbidityCondRepo(BencomrbidityCondRepo bencomrbidityCondRepo) {
		this.bencomrbidityCondRepo = bencomrbidityCondRepo;
	}

	@Autowired
	public void setBenMedHistoryRepo(BenMedHistoryRepo benMedHistoryRepo) {
		this.benMedHistoryRepo = benMedHistoryRepo;
	}

	@Autowired
	public void setBenChiefComplaintRepo(BenChiefComplaintRepo benChiefComplaintRepo) {
		this.benChiefComplaintRepo = benChiefComplaintRepo;
	}

	@Autowired
	public void setBenVisitDetailRepo(BenVisitDetailRepo benVisitDetailRepo) {
		this.benVisitDetailRepo = benVisitDetailRepo;
	}

	public Integer updateBeneficiaryStatus(Character c, Long benRegID) {
		Integer i = registrarRepoBenData.updateBenFlowStatus(c, benRegID);
		return i;
	}

	/**
	 * Save beneficiary visit details data and return beneficiary visit ID.
	 * 
	 * @param beneficiaryVisitDetail
	 * @return
	 */
	@Override
	public Long saveBeneficiaryVisitDetails(BeneficiaryVisitDetail beneficiaryVisitDetail) {
		BeneficiaryVisitDetail response = null;

		// get the total no of visit for the beneficiary (visit count)
		Short benVisitCount = benVisitDetailRepo
				.getVisitCountForBeneficiary(beneficiaryVisitDetail.getBeneficiaryRegID());

		if (benVisitCount != null && benVisitCount >= 0) {
			benVisitCount = (short) (benVisitCount + 1);
		} else {
			benVisitCount = 1;
		}
		beneficiaryVisitDetail.setVisitNo(benVisitCount);

		response = benVisitDetailRepo.save(beneficiaryVisitDetail);

		if (response != null)
			return response.getBenVisitID();
		else
			return null;

	}

	/**
	 * Neeraj have created this for getting visit count of patient
	 * 
	 * @return
	 */
	public Short getBenVisitCount(Long benRegID) {
		Short benVisitCount = benVisitDetailRepo.getVisitCountForBeneficiary(benRegID);

		if (benVisitCount != null && benVisitCount >= 0) {
			benVisitCount = (short) (benVisitCount + 1);
		} else {
			benVisitCount = 1;
		}

		return benVisitCount;
	}

	public int updateBeneficiaryVisitDetails(BeneficiaryVisitDetail beneficiaryVisitDetail) {
		int response = 0;
		try {
			response = benVisitDetailRepo.updateBeneficiaryVisitDetail(beneficiaryVisitDetail.getVisitReasonID(),
					beneficiaryVisitDetail.getVisitReason(), beneficiaryVisitDetail.getVisitCategoryID(),
					beneficiaryVisitDetail.getVisitCategory(), beneficiaryVisitDetail.getPregnancyStatus(),
					beneficiaryVisitDetail.getrCHID(), beneficiaryVisitDetail.getHealthFacilityType(),
					beneficiaryVisitDetail.getHealthFacilityLocation(), beneficiaryVisitDetail.getModifiedBy(),
					beneficiaryVisitDetail.getBenVisitID());

		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}

	public BeneficiaryVisitDetail getCSVisitDetails(Long benRegID, Long benVisitID) {
		BeneficiaryVisitDetail benVisitDetailsOBJ = benVisitDetailRepo.getVisitDetails(benRegID, benVisitID);

		BeneficiaryVisitDetail benVisitDetailsOBJ1 = null;
		if (null != benVisitDetailsOBJ) {
			benVisitDetailsOBJ1 = new BeneficiaryVisitDetail(benVisitDetailsOBJ.getBenVisitID(),
					benVisitDetailsOBJ.getBeneficiaryRegID(), benVisitDetailsOBJ.getProviderServiceMapID(),
					benVisitDetailsOBJ.getVisitDateTime(), benVisitDetailsOBJ.getVisitNo(),
					benVisitDetailsOBJ.getVisitReasonID(), benVisitDetailsOBJ.getVisitReason(),
					benVisitDetailsOBJ.getVisitCategoryID(), benVisitDetailsOBJ.getVisitCategory(),
					benVisitDetailsOBJ.getPregnancyStatus(), benVisitDetailsOBJ.getrCHID(),
					benVisitDetailsOBJ.getHealthFacilityType(), benVisitDetailsOBJ.getHealthFacilityLocation(),
					benVisitDetailsOBJ.getReportFilePath(), benVisitDetailsOBJ.getDeleted(),
					benVisitDetailsOBJ.getProcessed(), benVisitDetailsOBJ.getCreatedBy(),
					benVisitDetailsOBJ.getCreatedDate(), benVisitDetailsOBJ.getModifiedBy(),
					benVisitDetailsOBJ.getLastModDate());

		}

		return benVisitDetailsOBJ1;
	}

	public int saveBenChiefComplaints(List<BenChiefComplaint> benChiefComplaintList) {
		int r = 0;
		List<BenChiefComplaint> benChiefComplaintListNew = new ArrayList<>();
		for (BenChiefComplaint obj : benChiefComplaintList) {
			if (obj.getChiefComplaintID() != null)
				benChiefComplaintListNew.add(obj);
		}
		if (benChiefComplaintListNew.size() > 0) {
			List<BenChiefComplaint> benChiefComplaintResultList = (List<BenChiefComplaint>) benChiefComplaintRepo
					.save(benChiefComplaintListNew);
			if (benChiefComplaintListNew.size() == benChiefComplaintResultList.size())
				r = 1;
		} else {
			r = 1;
		}
		return r;
	}

	public Long saveBenPastHistory(BenMedHistory benMedHistory) {
		Long pastHistorySuccessFlag = null;
		ArrayList<BenMedHistory> benMedHistoryList = benMedHistory.getBenPastHistory();
		if (null != benMedHistoryList && benMedHistoryList.size() > 0) {
			ArrayList<BenMedHistory> res = (ArrayList<BenMedHistory>) benMedHistoryRepo.save(benMedHistoryList);
			if (benMedHistoryList.size() == res.size()) {
				pastHistorySuccessFlag = new Long(1);
			}
		} else {
			pastHistorySuccessFlag = new Long(1);
		}
		return pastHistorySuccessFlag;
	}

	public Long saveBenComorbidConditions(WrapperComorbidCondDetails wrapperComorbidCondDetails) {
		Long comrbidSuccessFlag = null;
		ArrayList<BencomrbidityCondDetails> bencomrbidityCondDetailsList = wrapperComorbidCondDetails
				.getComrbidityConds();
		if (bencomrbidityCondDetailsList.size() > 0) {
			ArrayList<BencomrbidityCondDetails> res = (ArrayList<BencomrbidityCondDetails>) bencomrbidityCondRepo
					.save(bencomrbidityCondDetailsList);
			if (bencomrbidityCondDetailsList.size() == res.size()) {
				comrbidSuccessFlag = res.get(0).getID();
			}
		} else {
			comrbidSuccessFlag = new Long(1);
		}
		return comrbidSuccessFlag;
	}

	public Long saveBenMedicationHistory(WrapperMedicationHistory wrapperMedicationHistory) {
		Long medicationSuccessFlag = null;
		ArrayList<BenMedicationHistory> benMedicationHistoryList = wrapperMedicationHistory
				.getBenMedicationHistoryDetails();
		if (benMedicationHistoryList.size() > 0) {
			ArrayList<BenMedicationHistory> res = (ArrayList<BenMedicationHistory>) benMedicationHistoryRepo
					.save(benMedicationHistoryList);
			if (benMedicationHistoryList.size() == res.size()) {
				medicationSuccessFlag = res.get(0).getID();
			}
		} else {
			medicationSuccessFlag = new Long(1);
		}
		return medicationSuccessFlag;
	}

	public Long saveFemaleObstetricHistory(WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory) {
		Long obstetricSuccessFlag = null;

		ArrayList<FemaleObstetricHistory> FemaleObstetricHistorylist = wrapperFemaleObstetricHistory
				.getFemaleObstetricHistoryDetails();
		if (FemaleObstetricHistorylist.size() > 0) {
			ArrayList<FemaleObstetricHistory> res = (ArrayList<FemaleObstetricHistory>) femaleObstetricHistoryRepo
					.save(FemaleObstetricHistorylist);
			if (FemaleObstetricHistorylist.size() == res.size()) {
				obstetricSuccessFlag = new Long(1);
			}
		} else {
			obstetricSuccessFlag = new Long(1);
		}
		return obstetricSuccessFlag;
	}

	public Integer saveBenMenstrualHistory(BenMenstrualDetails benMenstrualDetails) {
		Integer menstrualHistorySuccessFlag = null;

		BenMenstrualDetails res = benMenstrualDetailsRepo.save(benMenstrualDetails);
		if (null != res && res.getBenMenstrualID() > 0) {
			menstrualHistorySuccessFlag = res.getBenMenstrualID();
		}
		return menstrualHistorySuccessFlag;
	}

	public Long saveBenFamilyHistory(BenFamilyHistory benFamilyHistory) {
		Long familyHistorySuccessFlag = null;

		ArrayList<BenFamilyHistory> familyHistoryList = benFamilyHistory.getBenFamilyHistory();
		if (familyHistoryList.size() > 0) {
			ArrayList<BenFamilyHistory> res = (ArrayList<BenFamilyHistory>) benFamilyHistoryRepo
					.save(familyHistoryList);
			if (familyHistoryList.size() == res.size()) {
				familyHistorySuccessFlag = new Long(1);
			}
		} else {
			familyHistorySuccessFlag = new Long(1);
		}
		return familyHistorySuccessFlag;
	}

	public Integer savePersonalHistory(BenPersonalHabit benPersonalHabit) {
		Integer personalHistorySuccessFlag = null;

		ArrayList<BenPersonalHabit> personalHabits = benPersonalHabit.getPersonalHistory();
		if (personalHabits.size() > 0) {
			ArrayList<BenPersonalHabit> res = (ArrayList<BenPersonalHabit>) benPersonalHabitRepo.save(personalHabits);
			if (personalHabits.size() == res.size()) {
				personalHistorySuccessFlag = 1;
			}
		} else {
			personalHistorySuccessFlag = 1;
		}
		return personalHistorySuccessFlag;
	}

	public Long saveAllergyHistory(BenAllergyHistory benAllergyHistory) {
		Long allergyHistorySuccessFlag = null;

		ArrayList<BenAllergyHistory> allergyList = benAllergyHistory.getBenAllergicHistory();
		if (allergyList.size() > 0) {
			ArrayList<BenAllergyHistory> res = (ArrayList<BenAllergyHistory>) benAllergyHistoryRepo.save(allergyList);
			if (allergyList.size() == res.size()) {
				allergyHistorySuccessFlag = new Long(1);
			}
		} else {
			allergyHistorySuccessFlag = new Long(1);
		}
		return allergyHistorySuccessFlag;
	}

	public Long saveChildOptionalVaccineDetail(WrapperChildOptionalVaccineDetail wrapperChildVaccineDetail) {
		Long childVaccineSuccessFlag = null;
		ArrayList<ChildOptionalVaccineDetail> childOptionalVaccineDetails = wrapperChildVaccineDetail
				.getChildOptionalVaccineDetails();
		if (childOptionalVaccineDetails.size() > 0) {
			ArrayList<ChildOptionalVaccineDetail> res = (ArrayList<ChildOptionalVaccineDetail>) childOptionalVaccineDetailRepo
					.save(childOptionalVaccineDetails);
			if (childOptionalVaccineDetails.size() == res.size()) {
				childVaccineSuccessFlag = new Long(1);
			}
		} else {
			childVaccineSuccessFlag = new Long(1);
		}
		return childVaccineSuccessFlag;
	}

	public Long saveImmunizationHistory(WrapperImmunizationHistory wrapperImmunizationHistory) {
		Long immunizationSuccessFlag = null;

		ArrayList<ChildVaccineDetail1> childVaccineDetails = wrapperImmunizationHistory.getBenChildVaccineDetails();
		ArrayList<ChildVaccineDetail1> res = (ArrayList<ChildVaccineDetail1>) childVaccineDetail1Repo
				.save(childVaccineDetails);
		if (null != res && res.size() > 0) {
			immunizationSuccessFlag = res.get(0).getID();
		}
		return immunizationSuccessFlag;
	}

	public Long saveBeneficiaryPhysicalAnthropometryDetails(BenAnthropometryDetail benAnthropometryDetail) {
		BenAnthropometryDetail response = benAnthropometryRepo.save(benAnthropometryDetail);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	public Long saveBeneficiaryPhysicalVitalDetails(BenPhysicalVitalDetail benPhysicalVitalDetail) {
		// ArrayList<Short> averageSystolicList = new ArrayList<>();
		// ArrayList<Short> averageDiastolicList = new ArrayList<>();

		short sysBP = 0;
		short dysBP = 0;
		int j = 0;

		if (benPhysicalVitalDetail.getSystolicBP_1stReading() != null
				&& benPhysicalVitalDetail.getDiastolicBP_1stReading() != null) {
			sysBP = (short) (sysBP + benPhysicalVitalDetail.getSystolicBP_1stReading());
			dysBP = (short) (dysBP + benPhysicalVitalDetail.getDiastolicBP_1stReading());
			j++;
		}
		if (benPhysicalVitalDetail.getSystolicBP_2ndReading() != null
				&& benPhysicalVitalDetail.getDiastolicBP_2ndReading() != null) {
			sysBP = (short) (sysBP + benPhysicalVitalDetail.getSystolicBP_2ndReading());
			dysBP = (short) (dysBP + benPhysicalVitalDetail.getDiastolicBP_2ndReading());
			j++;
		}
		if (benPhysicalVitalDetail.getSystolicBP_3rdReading() != null
				&& benPhysicalVitalDetail.getDiastolicBP_3rdReading() != null) {
			sysBP = (short) (sysBP + benPhysicalVitalDetail.getSystolicBP_3rdReading());
			dysBP = (short) (dysBP + benPhysicalVitalDetail.getDiastolicBP_3rdReading());
			j++;
		}

		if (j > 0) {
			benPhysicalVitalDetail.setAverageSystolicBP((short) (sysBP / j));
			benPhysicalVitalDetail.setAverageDiastolicBP((short) (dysBP / j));
		}
		/**
		 * 
		 * 
		 * Short systolicBP_1stReading =
		 * benPhysicalVitalDetail.getSystolicBP_1stReading(); Short
		 * diastolicBP_1stReading =
		 * benPhysicalVitalDetail.getDiastolicBP_1stReading(); if
		 * (systolicBP_1stReading != null && diastolicBP_1stReading != null) {
		 * averageSystolicList.add(systolicBP_1stReading);
		 * averageDiastolicList.add(diastolicBP_1stReading); }
		 * 
		 * Short systolicBP_2ndReading =
		 * benPhysicalVitalDetail.getSystolicBP_2ndReading(); Short
		 * diastolicBP_2ndReading =
		 * benPhysicalVitalDetail.getDiastolicBP_2ndReading(); if
		 * (systolicBP_2ndReading != null && diastolicBP_2ndReading != null) {
		 * averageSystolicList.add(systolicBP_2ndReading);
		 * averageDiastolicList.add(diastolicBP_2ndReading); }
		 * 
		 * Short systolicBP_3rdReading =
		 * benPhysicalVitalDetail.getSystolicBP_3rdReading(); Short
		 * diastolicBP_3rdReading =
		 * benPhysicalVitalDetail.getDiastolicBP_3rdReading(); if
		 * (systolicBP_3rdReading != null && diastolicBP_3rdReading != null) {
		 * averageSystolicList.add(systolicBP_3rdReading);
		 * averageDiastolicList.add(diastolicBP_3rdReading); }
		 * 
		 * Short averageSystolic = (short)
		 * ((averageSystolicList.stream().mapToInt(i -> i.shortValue()).sum()) /
		 * averageSystolicList.size()); Short averageDiastolic = (short)
		 * ((averageDiastolicList.stream().mapToInt(i -> i.shortValue()).sum())
		 * / averageDiastolicList.size());
		 * 
		 * benPhysicalVitalDetail.setAverageSystolicBP(averageSystolic);
		 * benPhysicalVitalDetail.setAverageDiastolicBP(averageDiastolic);
		 * 
		 */

		BenPhysicalVitalDetail response = benPhysicalVitalRepo.save(benPhysicalVitalDetail);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	public String getBeneficiaryPhysicalAnthropometryDetails(Long beneficiaryRegID, Long benVisitID) {
		BenAnthropometryDetail benAnthropometryDetail = benAnthropometryRepo.getBenAnthropometryDetail(beneficiaryRegID,
				benVisitID);
		return new Gson().toJson(benAnthropometryDetail);
	}

	public String getBeneficiaryPhysicalVitalDetails(Long beneficiaryRegID, Long benVisitID) {
		BenPhysicalVitalDetail benPhysicalVitalDetail = benPhysicalVitalRepo.getBenPhysicalVitalDetail(beneficiaryRegID,
				benVisitID);
		return new Gson().toJson(benPhysicalVitalDetail);
	}

	public int updateANCAnthropometryDetails(BenAnthropometryDetail anthropometryDetail) {
		Integer r = 0;
		if (null != anthropometryDetail) {

			String processed = benAnthropometryRepo.getBenAnthropometryStatus(anthropometryDetail.getBeneficiaryRegID(),
					anthropometryDetail.getBenVisitID());
			if (null != processed && !processed.equals("N")) {
				processed = "U";
			} else {
				processed = "N";
			}

			// anthropometryDetail.setModifiedBy(anthropometryDetail.getCreatedBy());
			r = benAnthropometryRepo.updateANCCareDetails(anthropometryDetail.getWeight_Kg(),
					anthropometryDetail.getHeight_cm(), anthropometryDetail.getbMI(),
					anthropometryDetail.getHeadCircumference_cm(),
					anthropometryDetail.getMidUpperArmCircumference_MUAC_cm(),
					anthropometryDetail.getHipCircumference_cm(), anthropometryDetail.getWaistCircumference_cm(),
					anthropometryDetail.getWaistHipRatio(), anthropometryDetail.getModifiedBy(), processed,
					anthropometryDetail.getBeneficiaryRegID(), anthropometryDetail.getBenVisitID());
		}
		return r;
	}

	public int updateANCPhysicalVitalDetails(BenPhysicalVitalDetail physicalVitalDetail) {
		Integer r = 0;
		if (null != physicalVitalDetail) {

			String processed = benPhysicalVitalRepo.getBenPhysicalVitalStatus(physicalVitalDetail.getBeneficiaryRegID(),
					physicalVitalDetail.getBenVisitID());
			if (null != processed && !processed.equals("N")) {
				processed = "U";
			} else {
				processed = "N";
			}

			physicalVitalDetail.setAverageSystolicBP(physicalVitalDetail.getSystolicBP_1stReading());
			physicalVitalDetail.setAverageDiastolicBP(physicalVitalDetail.getDiastolicBP_1stReading());
			r = benPhysicalVitalRepo.updatePhysicalVitalDetails(physicalVitalDetail.getTemperature(),
					physicalVitalDetail.getPulseRate(), physicalVitalDetail.getRespiratoryRate(),
					physicalVitalDetail.getSystolicBP_1stReading(), physicalVitalDetail.getDiastolicBP_1stReading(),
					physicalVitalDetail.getSystolicBP_2ndReading(), physicalVitalDetail.getDiastolicBP_2ndReading(),
					physicalVitalDetail.getSystolicBP_3rdReading(), physicalVitalDetail.getDiastolicBP_3rdReading(),
					physicalVitalDetail.getAverageSystolicBP(), physicalVitalDetail.getAverageDiastolicBP(),
					physicalVitalDetail.getBloodPressureStatusID(), physicalVitalDetail.getBloodPressureStatus(),
					physicalVitalDetail.getBloodGlucose_Fasting(), physicalVitalDetail.getBloodGlucose_Random(),
					physicalVitalDetail.getBloodGlucose_2hr_PP(), physicalVitalDetail.getBloodGlucose_NotSpecified(),
					physicalVitalDetail.getDiabeticStatusID(), physicalVitalDetail.getDiabeticStatus(),
					physicalVitalDetail.getCapillaryRefillTime(), physicalVitalDetail.getModifiedBy(), processed,
					physicalVitalDetail.getBeneficiaryRegID(), physicalVitalDetail.getBenVisitID());

		}
		return r;
	}

	public Long savePhyGeneralExamination(PhyGeneralExamination generalExamination) {
		Long generalExaminationID = null;
		String TypeOfDangerSigns = "";
		if (null != generalExamination.getTypeOfDangerSigns() && generalExamination.getTypeOfDangerSigns().size() > 0) {
			for (String TypeOfDangerSign : generalExamination.getTypeOfDangerSigns()) {
				TypeOfDangerSigns += TypeOfDangerSign + ",";
			}
			generalExamination.setTypeOfDangerSign(TypeOfDangerSigns);
		}

		PhyGeneralExamination response = phyGeneralExaminationRepo.save(generalExamination);
		if (null != response) {
			generalExaminationID = response.getID();
		}
		return generalExaminationID;
	}

	public Long savePhyHeadToToeExamination(PhyHeadToToeExamination headToToeExamination) {
		Long examinationID = null;
		PhyHeadToToeExamination response = phyHeadToToeExaminationRepo.save(headToToeExamination);

		if (null != response) {
			examinationID = response.getID();
		}
		return examinationID;
	}

	public Long saveSysGastrointestinalExamination(SysGastrointestinalExamination gastrointestinalExamination) {
		Long examinationID = null;
		SysGastrointestinalExamination response = sysGastrointestinalExaminationRepo.save(gastrointestinalExamination);
		if (null != response) {
			examinationID = response.getID();
		}
		return examinationID;
	}

	public Long saveSysCardiovascularExamination(SysCardiovascularExamination cardiovascularExamination) {
		Long examinationID = null;
		SysCardiovascularExamination response = sysCardiovascularExaminationRepo.save(cardiovascularExamination);

		if (null != response) {
			examinationID = response.getID();
		}
		return examinationID;
	}

	public Long saveSysRespiratoryExamination(SysRespiratoryExamination respiratoryExamination) {
		// TODO Auto-generated method stub
		Long r = null;
		SysRespiratoryExamination respiratoryExaminationRS = sysRespiratoryExaminationRepo.save(respiratoryExamination);
		if (respiratoryExaminationRS != null)
			r = respiratoryExaminationRS.getID();
		return r;
	}

	public Long saveSysCentralNervousExamination(SysCentralNervousExamination centralNervousExamination) {
		// TODO Auto-generated method stub
		Long r = null;
		SysCentralNervousExamination centralNervousExaminationRS = sysCentralNervousExaminationRepo
				.save(centralNervousExamination);
		if (centralNervousExaminationRS != null) {
			r = centralNervousExaminationRS.getID();
		}
		return r;
	}

	public Long saveSysMusculoskeletalSystemExamination(
			SysMusculoskeletalSystemExamination musculoskeletalSystemExamination) {
		// TODO Auto-generated method stub
		Long r = null;
		SysMusculoskeletalSystemExamination musculoskeletalSystemExaminationRS = sysMusculoskeletalSystemExaminationRepo
				.save(musculoskeletalSystemExamination);
		if (null != musculoskeletalSystemExaminationRS) {
			r = musculoskeletalSystemExaminationRS.getID();
		}
		return r;
	}

	public Long saveSysGenitourinarySystemExamination(
			SysGenitourinarySystemExamination genitourinarySystemExamination) {
		// TODO Auto-generated method stub
		Long r = null;
		SysGenitourinarySystemExamination sysGenitourinarySystemExaminationRS = sysGenitourinarySystemExaminationRepo
				.save(genitourinarySystemExamination);
		if (null != sysGenitourinarySystemExaminationRS) {
			r = sysGenitourinarySystemExaminationRS.getID();
		}
		return r;
	}

	public String fetchBenPastMedicalHistory(Long benRegID) {
		Map<String, Object> resMap = new HashMap<>();
		ArrayList<Object[]> benPastHistoryDataArray = benMedHistoryRepo.getBenPastHistory(benRegID);
		ArrayList<BenMedHistory> benMedHistoryArrayList = new ArrayList<>();
		if (benPastHistoryDataArray != null && benPastHistoryDataArray.size() > 0) {
			BenMedHistory benMedHistory;
			for (Object[] obj : benPastHistoryDataArray) {
				benMedHistory = new BenMedHistory((Date) obj[0], (String) obj[1], (String) obj[2], (Date) obj[3],
						(String) obj[4], (String) obj[5], (Date) obj[6]);
				benMedHistoryArrayList.add(benMedHistory);
			}
		}

		Map<String, String> columnMap = new HashMap<>();
		List<Map<String, String>> columns = new ArrayList<Map<String, String>>();

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Date of Capture");
		columnMap.put("keyName", "captureDate");
		columns.add(columnMap);

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

	public String fetchBenPersonalTobaccoHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> benPersonalHabits = (ArrayList<Object[]>) benPersonalHabitRepo
				.getBenPersonalTobaccoHabitDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column = new HashMap<>();
		column.put("columnName", "Date of Capture");
		column.put("keyName", "captureDate");
		columns.add(column);

		column = new HashMap<>();
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

		/*
		 * column = new HashMap<String, Object>(); column.put("columnName",
		 * "Tobacco Use Type ID"); column.put("keyName", "tobaccoUseTypeID");
		 * columns.add(column);
		 */

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
		column.put("columnName", "Tobacco Use Start Date");
		column.put("keyName", "tobacco_use_duration");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Risky Sexual Practices Status");
		column.put("keyName", "riskySexualPracticeStatus");
		columns.add(column);

		ArrayList<BenPersonalHabit> personalHabits = new ArrayList<BenPersonalHabit>();
		if (null != benPersonalHabits) {
			for (Object[] obj : benPersonalHabits) {

				BenPersonalHabit benPersonalHabit = new BenPersonalHabit((Date) obj[0], (String) obj[1],
						(String) obj[2], (String) obj[3], (String) obj[4], (String) obj[5], (Short) obj[6],
						(Date) obj[7], (Character) obj[8]);

				personalHabits.add(benPersonalHabit);
			}
		}

		response.put("columns", columns);
		response.put("data", personalHabits);
		return new Gson().toJson(response);

	}

	public String fetchBenPersonalAlcoholHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> benPersonalHabits = (ArrayList<Object[]>) benPersonalHabitRepo
				.getBenPersonalAlcoholHabitDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column = new HashMap<>();
		column.put("columnName", "Date of Capture");
		column.put("keyName", "captureDate");
		columns.add(column);

		column = new HashMap<>();
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

		/*
		 * column = new HashMap<String, Object>(); column.put("columnName",
		 * "Alcohol Type ID"); column.put("keyName", "alcoholTypeID");
		 * columns.add(column);
		 */
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
		column.put("columnName", "Alcohol Use Started Date");
		column.put("keyName", "alcohol_use_duration");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Risky Sexual Practices Status");
		column.put("keyName", "riskySexualPracticeStatus");
		columns.add(column);

		ArrayList<BenPersonalHabit> personalHabits = new ArrayList<BenPersonalHabit>();
		if (null != benPersonalHabits) {
			for (Object[] obj : benPersonalHabits) {
				BenPersonalHabit benPersonalHabit = new BenPersonalHabit((Date) obj[0], (String) obj[1],
						(String) obj[2], (String) obj[3], (String) obj[4], (String) obj[5], (String) obj[6],
						(String) obj[7], (Date) obj[8], (Character) obj[9]);
				personalHabits.add(benPersonalHabit);
			}
		}

		response.put("columns", columns);
		response.put("data", personalHabits);
		return new Gson().toJson(response);

	}

	public String fetchBenPersonalAllergyHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> benPersonalHabits = (ArrayList<Object[]>) benAllergyHistoryRepo
				.getBenPersonalAllergyDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column = new HashMap<>();
		column.put("columnName", "Date of Capture");
		column.put("keyName", "captureDate");
		columns.add(column);

		column = new HashMap<>();
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

		/*
		 * column = new HashMap<String, Object>(); column.put("columnName",
		 * "Allergic Reaction Type ID"); column.put("keyName",
		 * "allergicReactionTypeID"); columns.add(column);
		 */

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

				BenAllergyHistory benPersonalHabit = new BenAllergyHistory((Date) obj[0], (String) obj[1],
						(String) obj[2], (String) obj[3], (String) obj[4], (String) obj[5], (String) obj[6]);
				personalHabits.add(benPersonalHabit);
			}

		}

		response.put("columns", columns);
		response.put("data", personalHabits);
		return new Gson().toJson(response);

	}

	public String fetchBenPersonalMedicationHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> beMedicationHistory = benMedicationHistoryRepo
				.getBenMedicationHistoryDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column = new HashMap<>();
		column.put("columnName", "Date of Capture");
		column.put("keyName", "captureDate");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Current Medication");
		column.put("keyName", "currentMedication");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Date");
		column.put("keyName", "medication_year");
		columns.add(column);

		ArrayList<BenMedicationHistory> medicationHistory = new ArrayList<BenMedicationHistory>();
		if (null != beMedicationHistory) {
			for (Object[] obj : beMedicationHistory) {
				BenMedicationHistory history = new BenMedicationHistory((Date) obj[0], (String) obj[1], (Date) obj[2]);
				medicationHistory.add(history);
			}

		}

		response.put("columns", columns);
		response.put("data", medicationHistory);
		return new Gson().toJson(response);

	}

	public String fetchBenPersonalFamilyHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> benFamilyHistory = benFamilyHistoryRepo.getBenFamilyHistoryDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column = new HashMap<>();
		column.put("columnName", "Date of Capture");
		column.put("keyName", "captureDate");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Family Member");
		column.put("keyName", "familyMember");
		columns.add(column);

		/*
		 * column = new HashMap<String, Object>(); column.put("columnName",
		 * "Disease Type ID"); column.put("keyName", "diseaseTypeID");
		 * columns.add(column);
		 */

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
				BenFamilyHistory history = new BenFamilyHistory((Date) obj[0], (String) obj[1], (String) obj[2],
						(String) obj[3], (Boolean) obj[4], (String) obj[5], (Boolean) obj[6]);
				familyHistory.add(history);
			}

		}

		response.put("columns", columns);
		response.put("data", familyHistory);
		return new Gson().toJson(response);

	}

	public String fetchBenMenstrualHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> benMenstrualDetails = benMenstrualDetailsRepo.getBenMenstrualDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column = new HashMap<>();
		column.put("columnName", "Date of Capture");
		column.put("keyName", "captureDate");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Regularity");
		column.put("keyName", "regularity");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Cycle Length");
		column.put("keyName", "cycleLength");
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
		column.put("keyName", "lmp_date");
		columns.add(column);

		ArrayList<BenMenstrualDetails> menstrualDetails = new ArrayList<BenMenstrualDetails>();
		if (null != benMenstrualDetails) {
			for (Object[] obj : benMenstrualDetails) {

				BenMenstrualDetails history = new BenMenstrualDetails((Date) obj[0], (String) obj[1], (String) obj[2],
						(String) obj[3], (String) obj[4], (Date) obj[5]);
				menstrualDetails.add(history);
			}

		}

		response.put("columns", columns);
		response.put("data", menstrualDetails);
		return new Gson().toJson(response);

	}

	public String fetchBenPastObstetricHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> femaleObstetricHistory = femaleObstetricHistoryRepo
				.getBenFemaleObstetricHistoryDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column = new HashMap<>();
		column.put("columnName", "Date of Capture");
		column.put("keyName", "captureDate");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Preg Order");
		column.put("keyName", "pregOrder");
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
		column.put("columnName", "Duration Type");
		column.put("keyName", "durationType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Delivery Type");
		column.put("keyName", "deliveryType");
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
		column.put("columnName", "Delivery Complication Type");
		column.put("keyName", "deliveryComplicationType");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Other Delivery Complication");
		column.put("keyName", "otherDeliveryComplication");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Preg Outcome");
		column.put("keyName", "pregOutcome");
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

				FemaleObstetricHistory history = new FemaleObstetricHistory((Date) obj[0], (Short) obj[1],
						(String) obj[2], (String) obj[3], (String) obj[4], (String) obj[5], (String) obj[6],
						(String) obj[7], (String) obj[8], (String) obj[9], (String) obj[10], (String) obj[11],
						(String) obj[12], (String) obj[13], (String) obj[14], (String) obj[15], (String) obj[16],
						(String) obj[17]);
				femaleObstetricDetails.add(history);
			}

		}

		response.put("columns", columns);
		response.put("data", femaleObstetricDetails);
		return new Gson().toJson(response);

	}

	public String fetchBenComorbidityHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> bencomrbidityCondDetails = bencomrbidityCondRepo
				.getBencomrbidityCondDetails(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column = new HashMap<>();
		column.put("columnName", "Date of Capture");
		column.put("keyName", "captureDate");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Comorbid Condition");
		column.put("keyName", "comorbidCondition");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Other Comorbid Condition");
		column.put("keyName", "otherComorbidCondition");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Date");
		column.put("keyName", "date");
		columns.add(column);

		ArrayList<BencomrbidityCondDetails> bencomrbidityConds = new ArrayList<BencomrbidityCondDetails>();
		if (null != bencomrbidityCondDetails) {
			for (Object[] obj : bencomrbidityCondDetails) {

				BencomrbidityCondDetails history = new BencomrbidityCondDetails((Date) obj[0], (String) obj[1],
						(String) obj[2], (Date) obj[3]);
				bencomrbidityConds.add(history);
			}

		}

		response.put("columns", columns);
		response.put("data", bencomrbidityConds);
		return new Gson().toJson(response);

	}

	public String fetchBenImmunizationHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> childVaccineDetail = childVaccineDetail1Repo.getBenChildVaccineDetails(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column = new HashMap<>();
		column.put("columnName", "Date of Capture");
		column.put("keyName", "captureDate");
		columns.add(column);

		column = new HashMap<>();
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
				ChildVaccineDetail1 history = new ChildVaccineDetail1((Date) obj[0], (String) obj[1], (String) obj[2],
						(Boolean) obj[3]);
				childVaccineDetails.add(history);
			}
		}

		response.put("columns", columns);
		response.put("data", childVaccineDetails);
		return new Gson().toJson(response);

	}

	public String fetchBenOptionalVaccineHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> childOptionalVaccineDetail = childOptionalVaccineDetailRepo
				.getBenOptionalVaccineDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column = new HashMap<>();
		column.put("columnName", "Date of Capture");
		column.put("keyName", "captureDate");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Default Receiving Age");
		column.put("keyName", "defaultReceivingAge");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Vaccine Name");
		column.put("keyName", "vaccineName");
		columns.add(column);

		/** Later we will enable these two if needed **/
		/*
		 * column = new HashMap<String, Object>(); column.put("columnName",
		 * "Status"); column.put("keyName", "status"); columns.add(column);
		 * 
		 * column = new HashMap<String, Object>(); column.put("columnName",
		 * "Received Date"); column.put("keyName", "receivedDate");
		 * columns.add(column);
		 */

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
				ChildOptionalVaccineDetail history = new ChildOptionalVaccineDetail((Date) obj[0], (String) obj[1],
						(String) obj[2], (String) obj[3], (Timestamp) obj[4], (String) obj[5], (String) obj[6]);
				childOptionalVaccineDetails.add(history);
			}
		}

		response.put("columns", columns);
		response.put("data", childOptionalVaccineDetails);
		return new Gson().toJson(response);

	}

	public String getBenChiefComplaints(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> resList = benChiefComplaintRepo.getBenChiefComplaints(beneficiaryRegID, benVisitID);
		ArrayList<BenChiefComplaint> benChiefComplaints = BenChiefComplaint.getBenChiefComplaints(resList);
		return new Gson().toJson(benChiefComplaints);
	}

	public BenMedHistory getPastHistoryData(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> pastHistory = benMedHistoryRepo.getBenPastHistory(beneficiaryRegID, benVisitID);

		BenMedHistory medHistory = new BenMedHistory();
		BenMedHistory benMedHistory = medHistory.getBenPastHistory(pastHistory);
		return benMedHistory;
	}

	public WrapperComorbidCondDetails getComorbidityConditionsHistory(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> comrbidityConds = bencomrbidityCondRepo.getBencomrbidityCondDetails(beneficiaryRegID,
				benVisitID);

		WrapperComorbidCondDetails comrbidityCondDetails = WrapperComorbidCondDetails
				.getComorbidityDetails(comrbidityConds);
		return comrbidityCondDetails;
	}

	public WrapperMedicationHistory getMedicationHistory(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> medicationHistory = benMedicationHistoryRepo.getBenMedicationHistoryDetail(beneficiaryRegID,
				benVisitID);

		WrapperMedicationHistory wrapperMedicationHistory = WrapperMedicationHistory
				.getMedicationHistoryDetails(medicationHistory);
		return wrapperMedicationHistory;
	}

	public BenPersonalHabit getPersonalHistory(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> personalDetails = benPersonalHabitRepo.getBenPersonalHabitDetail(beneficiaryRegID,
				benVisitID);

		ArrayList<Object[]> allergyDetails = benAllergyHistoryRepo.getBenPersonalAllergyDetail(beneficiaryRegID,
				benVisitID);

		BenPersonalHabit personalHabits = BenPersonalHabit.getPersonalDetails(personalDetails);
		ArrayList<BenAllergyHistory> allergyList = BenAllergyHistory.getBenAllergicHistory(allergyDetails);
		if (null != allergyList && allergyList.size() > 0) {
			personalHabits.setAllergyStatus(allergyList.get(0).getAllergyStatus());
			personalHabits.setAllergicList(allergyList);
		}

		return personalHabits;
	}

	public BenFamilyHistory getFamilyHistory(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> familyHistory = benFamilyHistoryRepo.getBenFamilyHistoryDetail(beneficiaryRegID,
				benVisitID);
		BenFamilyHistory familyHistoryDetails = BenFamilyHistory.getBenFamilyHistory(familyHistory);

		return familyHistoryDetails;
	}

	public BenMenstrualDetails getMenstrualHistory(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> menstrualHistory = benMenstrualDetailsRepo.getBenMenstrualDetail(beneficiaryRegID,
				benVisitID);
		BenMenstrualDetails menstrualHistoryDetails = BenMenstrualDetails.getBenMenstrualDetails(menstrualHistory);

		return menstrualHistoryDetails;
	}

	public WrapperFemaleObstetricHistory getFemaleObstetricHistory(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> femaleObstetricHistory = femaleObstetricHistoryRepo
				.getBenFemaleObstetricHistoryDetail(beneficiaryRegID, benVisitID);
		WrapperFemaleObstetricHistory femaleObstetricHistoryDetails = WrapperFemaleObstetricHistory
				.getFemaleObstetricHistory(femaleObstetricHistory);

		return femaleObstetricHistoryDetails;
	}

	public WrapperChildOptionalVaccineDetail getChildOptionalVaccineHistory(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> childOptionalVaccineDetail = childOptionalVaccineDetailRepo
				.getBenOptionalVaccineDetail(beneficiaryRegID, benVisitID);
		WrapperChildOptionalVaccineDetail childOptionalVaccineDetails = WrapperChildOptionalVaccineDetail
				.getChildOptionalVaccineDetail(childOptionalVaccineDetail);

		return childOptionalVaccineDetails;
	}

	public WrapperImmunizationHistory getImmunizationHistory(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> childVaccineDetail = childVaccineDetail1Repo.getBenChildVaccineDetails(beneficiaryRegID,
				benVisitID);
		WrapperImmunizationHistory childVaccineDetails = WrapperImmunizationHistory
				.getChildVaccineDetail(childVaccineDetail);

		return childVaccineDetails;
	}

	public PhyGeneralExamination getGeneralExaminationData(Long benRegID, Long benVisitID) {
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

	public PhyHeadToToeExamination getHeadToToeExaminationData(Long benRegID, Long benVisitID) {
		PhyHeadToToeExamination phyHeadToToeExaminationData = phyHeadToToeExaminationRepo
				.getPhyHeadToToeExaminationData(benRegID, benVisitID);

		return phyHeadToToeExaminationData;

	}

	public SysGastrointestinalExamination getSysGastrointestinalExamination(Long benRegID, Long benVisitID) {
		SysGastrointestinalExamination sysGastrointestinalExaminationData = sysGastrointestinalExaminationRepo
				.getSSysGastrointestinalExamination(benRegID, benVisitID);

		return sysGastrointestinalExaminationData;
	}

	public SysCardiovascularExamination getCardiovascularExamination(Long benRegID, Long benVisitID) {
		SysCardiovascularExamination sysCardiovascularExaminationData = sysCardiovascularExaminationRepo
				.getSysCardiovascularExaminationData(benRegID, benVisitID);

		return sysCardiovascularExaminationData;
	}

	public SysRespiratoryExamination getRespiratoryExamination(Long benRegID, Long benVisitID) {
		SysRespiratoryExamination sysRespiratoryExaminationData = sysRespiratoryExaminationRepo
				.getSysRespiratoryExaminationData(benRegID, benVisitID);

		return sysRespiratoryExaminationData;
	}

	public SysCentralNervousExamination getSysCentralNervousExamination(Long benRegID, Long benVisitID) {
		SysCentralNervousExamination sysCentralNervousExaminationData = sysCentralNervousExaminationRepo
				.getSysCentralNervousExaminationData(benRegID, benVisitID);

		return sysCentralNervousExaminationData;
	}

	public SysMusculoskeletalSystemExamination getMusculoskeletalExamination(Long benRegID, Long benVisitID) {
		SysMusculoskeletalSystemExamination sysMusculoskeletalSystemExaminationData = sysMusculoskeletalSystemExaminationRepo
				.getSysMusculoskeletalSystemExamination(benRegID, benVisitID);

		return sysMusculoskeletalSystemExaminationData;
	}

	public SysGenitourinarySystemExamination getGenitourinaryExamination(Long benRegID, Long benVisitID) {
		SysGenitourinarySystemExamination sysGenitourinarySystemExaminationData = sysGenitourinarySystemExaminationRepo
				.getSysGenitourinarySystemExaminationData(benRegID, benVisitID);

		return sysGenitourinarySystemExaminationData;
	}

	public int updateBenChiefComplaints(List<BenChiefComplaint> benChiefComplaintList) {
		int r = 0;
		if (null != benChiefComplaintList && benChiefComplaintList.size() > 0) {
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

	public int updateBenPastHistoryDetails(BenMedHistory benMedHistory) throws ParseException {
		Integer r = 0;
		int delRes = 0;
		if (null != benMedHistory) {
			// Delete Existing past History of beneficiary before inserting
			// updated history
			ArrayList<Object[]> benMedHistoryStatuses = benMedHistoryRepo
					.getBenMedHistoryStatus(benMedHistory.getBeneficiaryRegID(), benMedHistory.getBenVisitID());

			for (Object[] obj : benMedHistoryStatuses) {
				String processed = (String) obj[1];
				if (null != processed && !"N".equals(processed)) {
					processed = "U";
				} else {
					processed = "N";
				}
				delRes = benMedHistoryRepo.deleteExistingBenMedHistory((Long) obj[0], processed);

			}

			ArrayList<BenMedHistory> benMedHistoryList = benMedHistory.getBenPastHistory();
			if (null != benMedHistoryList && benMedHistoryList.size() > 0) {
				ArrayList<BenMedHistory> res = (ArrayList<BenMedHistory>) benMedHistoryRepo.save(benMedHistoryList);
				if (benMedHistoryList.size() == res.size()) {
					r = 1;
				}
			} else {
				r = 1;
			}
		}
		return r;
	}

	public int updateBenComorbidConditions(WrapperComorbidCondDetails wrapperComorbidCondDetails) {
		int r = 0;
		int delRes = 0;
		if (null != wrapperComorbidCondDetails) {

			ArrayList<Object[]> benComorbidCondHistoryStatuses = bencomrbidityCondRepo
					.getBenComrbidityCondHistoryStatus(wrapperComorbidCondDetails.getBeneficiaryRegID(),
							wrapperComorbidCondDetails.getBenVisitID());

			for (Object[] obj : benComorbidCondHistoryStatuses) {
				String processed = (String) obj[1];
				if (null != processed && !"N".equals(processed)) {
					processed = "U";
				} else {
					processed = "N";
				}
				delRes = bencomrbidityCondRepo.deleteExistingBenComrbidityCondDetails((Long) obj[0], processed);

			}

			ArrayList<BencomrbidityCondDetails> bencomrbidityCondDetailsList = wrapperComorbidCondDetails
					.getComrbidityConds();
			if (null != bencomrbidityCondDetailsList && bencomrbidityCondDetailsList.size() > 0) {
				ArrayList<BencomrbidityCondDetails> res = (ArrayList<BencomrbidityCondDetails>) bencomrbidityCondRepo
						.save(bencomrbidityCondDetailsList);
				if (bencomrbidityCondDetailsList.size() == res.size()) {
					r = 1;
				}
			} else {
				r = 1;
			}
		}
		return r;
	}

	public int updateBenMedicationHistory(WrapperMedicationHistory wrapperMedicationHistory) {
		Integer r = 0;
		int delRes = 0;
		if (null != wrapperMedicationHistory) {

			ArrayList<Object[]> benMedicationHistoryStatuses = benMedicationHistoryRepo.getBenMedicationHistoryStatus(
					wrapperMedicationHistory.getBeneficiaryRegID(), wrapperMedicationHistory.getBenVisitID());

			for (Object[] obj : benMedicationHistoryStatuses) {
				String processed = (String) obj[1];
				if (null != processed && !"N".equals(processed)) {
					processed = "U";
				} else {
					processed = "N";
				}
				delRes = benMedicationHistoryRepo.deleteExistingBenMedicationHistory((Long) obj[0], processed);

			}

			ArrayList<BenMedicationHistory> benMedicationHistoryList = wrapperMedicationHistory
					.getBenMedicationHistoryDetails();
			if (null != benMedicationHistoryList && benMedicationHistoryList.size() > 0) {
				ArrayList<BenMedicationHistory> res = (ArrayList<BenMedicationHistory>) benMedicationHistoryRepo
						.save(benMedicationHistoryList);
				if (benMedicationHistoryList.size() == res.size()) {
					r = 1;
				}
			} else {
				r = 1;
			}
		}
		return r;
	}

	public int updateBenPersonalHistory(BenPersonalHabit benPersonalHabit) {
		Integer r = 0;
		int delRes = 0;
		if (null != benPersonalHabit) {

			ArrayList<Object[]> benPersonalHistoryStatuses = benPersonalHabitRepo.getBenPersonalHistoryStatus(
					benPersonalHabit.getBeneficiaryRegID(), benPersonalHabit.getBenVisitID());

			for (Object[] obj : benPersonalHistoryStatuses) {
				String processed = (String) obj[1];
				if (null != processed && !"N".equals(processed)) {
					processed = "U";
				} else {
					processed = "N";
				}
				delRes = benPersonalHabitRepo.deleteExistingBenPersonalHistory((Integer) obj[0], processed);

			}

			ArrayList<BenPersonalHabit> personalHabits = benPersonalHabit.getPersonalHistory();
			if (null != personalHabits && personalHabits.size() > 0) {
				ArrayList<BenPersonalHabit> res = (ArrayList<BenPersonalHabit>) benPersonalHabitRepo
						.save(personalHabits);
				if (personalHabits.size() > 0) {
					r = 1;
				}
			} else {
				r = 1;
			}
		}
		return r;
	}

	public int updateBenAllergicHistory(BenAllergyHistory benAllergyHistory) {
		Integer r = 0;
		int delRes = 0;
		if (null != benAllergyHistory) {

			ArrayList<Object[]> benAllergyHistoryStatuses = benAllergyHistoryRepo.getBenAllergyHistoryStatus(
					benAllergyHistory.getBeneficiaryRegID(), benAllergyHistory.getBenVisitID());

			for (Object[] obj : benAllergyHistoryStatuses) {
				String processed = (String) obj[1];
				if (null != processed && !"N".equals(processed)) {
					processed = "U";
				} else {
					processed = "N";
				}
				delRes = benAllergyHistoryRepo.deleteExistingBenAllergyHistory((Long) obj[0], processed);
			}

			ArrayList<BenAllergyHistory> allergyList = benAllergyHistory.getBenAllergicHistory();
			if (null != allergyList && allergyList.size() > 0) {
				ArrayList<BenAllergyHistory> res = (ArrayList<BenAllergyHistory>) benAllergyHistoryRepo
						.save(allergyList);
				if (allergyList.size() == res.size()) {
					r = 1;
				}
			} else {
				r = 1;
			}
		}
		return r;
	}

	public int updateBenFamilyHistory(BenFamilyHistory benFamilyHistory) {
		Integer r = 0;
		int delRes = 0;
		if (null != benFamilyHistory) {

			ArrayList<Object[]> benFamilyHistoryStatuses = benFamilyHistoryRepo.getBenFamilyHistoryStatus(
					benFamilyHistory.getBeneficiaryRegID(), benFamilyHistory.getBenVisitID());

			for (Object[] obj : benFamilyHistoryStatuses) {
				String processed = (String) obj[1];
				if (null != processed && !"N".equals(processed)) {
					processed = "U";
				} else {
					processed = "N";
				}
				delRes = benFamilyHistoryRepo.deleteExistingBenFamilyHistory((Long) obj[0], processed);
			}

			ArrayList<BenFamilyHistory> familyHistoryList = benFamilyHistory.getBenFamilyHistory();
			if (null != familyHistoryList && familyHistoryList.size() > 0) {
				ArrayList<BenFamilyHistory> res = (ArrayList<BenFamilyHistory>) benFamilyHistoryRepo
						.save(familyHistoryList);
				if (familyHistoryList.size() == res.size()) {
					r = 1;
				}
			} else {
				r = 1;
			}
		}
		return r;
	}

	public int updateMenstrualHistory(BenMenstrualDetails benMenstrualDetails) {
		int response = 0;
		int recordsAvailable = 0;
		if (null != benMenstrualDetails) {
			String processed = benMenstrualDetailsRepo.getBenMenstrualDetailStatus(
					benMenstrualDetails.getBeneficiaryRegID(), benMenstrualDetails.getBenVisitID());
			if (processed != null) {
				recordsAvailable = 1;
			}
			if (null != processed && !"N".equals(processed)) {
				processed = "U";
			} else {
				processed = "N";
			}
			if (recordsAvailable > 0) {
				response = benMenstrualDetailsRepo.updateMenstrualDetails(
						benMenstrualDetails.getMenstrualCycleStatusID(), benMenstrualDetails.getRegularity(),
						benMenstrualDetails.getMenstrualCyclelengthID(), benMenstrualDetails.getCycleLength(),
						benMenstrualDetails.getMenstrualFlowDurationID(), benMenstrualDetails.getBloodFlowDuration(),
						benMenstrualDetails.getMenstrualProblemID(), benMenstrualDetails.getProblemName(),
						benMenstrualDetails.getlMPDate(), benMenstrualDetails.getModifiedBy(), processed,
						benMenstrualDetails.getBeneficiaryRegID(), benMenstrualDetails.getBenVisitID());
			} else {
				benMenstrualDetails.setCreatedBy(benMenstrualDetails.getModifiedBy());
				BenMenstrualDetails menstrualDetails = benMenstrualDetailsRepo.save(benMenstrualDetails);
				if (null != menstrualDetails && menstrualDetails.getBenMenstrualID() > 0) {
					response = 1;
				}
			}
		}
		return response;
	}

	public int updatePastObstetricHistory(WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory) {
		Integer r = 0;
		int delRes = 0;
		if (null != wrapperFemaleObstetricHistory) {
			ArrayList<Object[]> benObstetricHistoryStatuses = femaleObstetricHistoryRepo.getBenObstetricHistoryStatus(
					wrapperFemaleObstetricHistory.getBeneficiaryRegID(), wrapperFemaleObstetricHistory.getBenVisitID());

			for (Object[] obj : benObstetricHistoryStatuses) {
				String processed = (String) obj[1];
				if (null != processed && !"N".equals(processed)) {
					processed = "U";
				} else {
					processed = "N";
				}
				delRes = femaleObstetricHistoryRepo.deleteExistingObstetricHistory((Long) obj[0], processed);
			}

			ArrayList<FemaleObstetricHistory> femaleObstetricHistoryDetails = wrapperFemaleObstetricHistory
					.getFemaleObstetricHistoryDetails();
			ArrayList<FemaleObstetricHistory> res = (ArrayList<FemaleObstetricHistory>) femaleObstetricHistoryRepo
					.save(femaleObstetricHistoryDetails);
			if (femaleObstetricHistoryDetails.size() == res.size()) {
				r = 1;
			}
		}
		return r;
	}

	public int updateChildOptionalVaccineDetail(WrapperChildOptionalVaccineDetail wrapperChildOptionalVaccineDetail) {
		Integer r = 0;
		int delRes = 0;
		if (null != wrapperChildOptionalVaccineDetail) {

			ArrayList<Object[]> benChildOptionalVaccineHistoryStatuses = childOptionalVaccineDetailRepo
					.getBenChildOptionalVaccineHistoryStatus(wrapperChildOptionalVaccineDetail.getBeneficiaryRegID(),
							wrapperChildOptionalVaccineDetail.getBenVisitID());

			for (Object[] obj : benChildOptionalVaccineHistoryStatuses) {
				String processed = (String) obj[1];
				if (null != processed && !"N".equals(processed)) {
					processed = "U";
				} else {
					processed = "N";
				}
				delRes = childOptionalVaccineDetailRepo.deleteExistingChildOptionalVaccineDetail((Long) obj[0],
						processed);
			}

			ArrayList<ChildOptionalVaccineDetail> childOptionalVaccineDetails = wrapperChildOptionalVaccineDetail
					.getChildOptionalVaccineDetails();
			if (null != childOptionalVaccineDetails && childOptionalVaccineDetails.size() > 0) {
				ArrayList<ChildOptionalVaccineDetail> res = (ArrayList<ChildOptionalVaccineDetail>) childOptionalVaccineDetailRepo
						.save(childOptionalVaccineDetails);
				if (childOptionalVaccineDetails.size() == res.size()) {
					r = 1;
				}
			} else {
				r = 1;
			}
		}
		return r;
	}

	public int updateChildImmunizationDetail(WrapperImmunizationHistory wrapperImmunizationHistory) {
		Integer r = 0;

		ArrayList<ChildVaccineDetail1> childVaccineDetails = wrapperImmunizationHistory.getBenChildVaccineDetails();

		if (null != childVaccineDetails) {
			String processed = "N";
			ChildVaccineDetail1 childVaccine = childVaccineDetails.get(0);
			ArrayList<Object[]> childVaccineStatuses = childVaccineDetail1Repo
					.getBenChildVaccineDetailStatus(childVaccine.getBeneficiaryRegID(), childVaccine.getBenVisitID());

			Map<String, String> vaccineStatuses = new HashMap<String, String>();

			for (Object[] obj : childVaccineStatuses) {
				vaccineStatuses.put((String) obj[0] + "-" + (String) obj[1], (String) obj[2]);
			}

			for (ChildVaccineDetail1 childVaccineDetail : childVaccineDetails) {

				processed = vaccineStatuses
						.get(childVaccineDetail.getDefaultReceivingAge() + "-" + childVaccineDetail.getVaccineName());
				if (null != processed && !processed.equals("N")) {
					processed = "U";
				} else {
					processed = "N";
				}
				r = childVaccineDetail1Repo.updateChildANCImmunization(childVaccineDetail.getStatus(),
						childVaccineDetail.getModifiedBy(), processed, childVaccineDetail.getBeneficiaryRegID(),
						childVaccineDetail.getBenVisitID(), childVaccineDetail.getDefaultReceivingAge(),
						childVaccineDetail.getVaccineName());
			}
		}
		return r;
	}

	public int updatePhyGeneralExamination(PhyGeneralExamination generalExamination) {
		int response = 0;
		String TypeOfDangerSigns = "";

		if (null != generalExamination) {

			String processed = phyGeneralExaminationRepo.getBenGeneralExaminationStatus(
					generalExamination.getBeneficiaryRegID(), generalExamination.getBenVisitID());
			if (null != processed && !"N".equals(processed)) {
				processed = "U";
			} else {
				processed = "N";
			}

			if (null != generalExamination.getTypeOfDangerSigns()
					&& generalExamination.getTypeOfDangerSigns().size() > 0) {
				for (String TypeOfDangerSign : generalExamination.getTypeOfDangerSigns()) {
					TypeOfDangerSigns += TypeOfDangerSign + ",";
				}
				generalExamination.setTypeOfDangerSign(TypeOfDangerSigns);
			}

			response = phyGeneralExaminationRepo.updatePhyGeneralExamination(generalExamination.getConsciousness(),
					generalExamination.getCoherence(), generalExamination.getCooperation(),
					generalExamination.getComfortness(), generalExamination.getBuiltAndAppearance(),
					generalExamination.getGait(), generalExamination.getDangerSigns(),
					generalExamination.getTypeOfDangerSign(), generalExamination.getPallor(),
					generalExamination.getJaundice(), generalExamination.getCyanosis(),
					generalExamination.getClubbing(), generalExamination.getLymphadenopathy(),
					generalExamination.getLymphnodesInvolved(), generalExamination.getTypeOfLymphadenopathy(),
					generalExamination.getEdema(), generalExamination.getExtentOfEdema(),
					generalExamination.getEdemaType(), generalExamination.getModifiedBy(), processed,
					generalExamination.getBeneficiaryRegID(), generalExamination.getBenVisitID());
		}
		return response;
	}

	public int updatePhyHeadToToeExamination(PhyHeadToToeExamination headToToeExamination) {
		int response = 0;
		if (null != headToToeExamination) {
			String processed = phyHeadToToeExaminationRepo.getBenHeadToToeExaminationStatus(
					headToToeExamination.getBeneficiaryRegID(), headToToeExamination.getBenVisitID());
			if (null != processed && !"N".equals(processed)) {
				processed = "U";
			} else {
				processed = "N";
			}
			response = phyHeadToToeExaminationRepo.updatePhyHeadToToeExamination(
					headToToeExamination.getHeadtoToeExam(), headToToeExamination.getHead(),
					headToToeExamination.getEyes(), headToToeExamination.getEars(), headToToeExamination.getNose(),
					headToToeExamination.getOralCavity(), headToToeExamination.getThroat(),
					headToToeExamination.getBreastAndNipples(), headToToeExamination.getTrunk(),
					headToToeExamination.getUpperLimbs(), headToToeExamination.getLowerLimbs(),
					headToToeExamination.getSkin(), headToToeExamination.getHair(), headToToeExamination.getNails(),
					headToToeExamination.getModifiedBy(), processed, headToToeExamination.getBeneficiaryRegID(),
					headToToeExamination.getBenVisitID());
		}
		return response;
	}

	public int updateSysCardiovascularExamination(SysCardiovascularExamination cardiovascular) {
		int response = 0;
		if (null != cardiovascular) {
			String processed = sysCardiovascularExaminationRepo.getBenCardiovascularExaminationStatus(
					cardiovascular.getBeneficiaryRegID(), cardiovascular.getBenVisitID());
			if (null != processed && !processed.equals("N")) {
				processed = "U";
			}
			response = sysCardiovascularExaminationRepo.updateSysCardiovascularExamination(
					cardiovascular.getJugularVenousPulse_JVP(), cardiovascular.getApexbeatLocation(),
					cardiovascular.getApexbeatType(), cardiovascular.getFirstHeartSound_S1(),
					cardiovascular.getSecondHeartSound_S2(), cardiovascular.getAdditionalHeartSounds(),
					cardiovascular.getMurmurs(), cardiovascular.getPericardialRub(), cardiovascular.getModifiedBy(),
					processed, cardiovascular.getBeneficiaryRegID(), cardiovascular.getBenVisitID());
		}
		return response;
	}

	public int updateSysRespiratoryExamination(SysRespiratoryExamination respiratory) {
		int r = 0;
		if (null != respiratory) {
			String processed = sysRespiratoryExaminationRepo
					.getBenRespiratoryExaminationStatus(respiratory.getBeneficiaryRegID(), respiratory.getBenVisitID());
			if (null != processed && !"N".equals(processed)) {
				processed = "U";
			} else {
				processed = "N";
			}
			r = sysRespiratoryExaminationRepo.updateSysRespiratoryExamination(respiratory.getTrachea(),
					respiratory.getInspection(), respiratory.getSignsOfRespiratoryDistress(),
					respiratory.getPalpation(), respiratory.getAuscultation(), respiratory.getAuscultation_Stridor(),
					respiratory.getAuscultation_BreathSounds(), respiratory.getAuscultation_Crepitations(),
					respiratory.getAuscultation_Wheezing(), respiratory.getAuscultation_PleuralRub(),
					respiratory.getAuscultation_ConductedSounds(), respiratory.getPercussion(),
					respiratory.getModifiedBy(), processed, respiratory.getBeneficiaryRegID(),
					respiratory.getBenVisitID());
		}
		return r;
	}

	public int updateSysCentralNervousExamination(SysCentralNervousExamination centralNervous) {
		int r = 0;
		if (null != centralNervous) {
			String processed = sysCentralNervousExaminationRepo.getBenCentralNervousExaminationStatus(
					centralNervous.getBeneficiaryRegID(), centralNervous.getBenVisitID());
			if (null != processed && !"N".equals(processed)) {
				processed = "U";
			} else {
				processed = "N";
			}
			r = sysCentralNervousExaminationRepo.updateSysCentralNervousExamination(centralNervous.getHandedness(),
					centralNervous.getCranialNervesExamination(), centralNervous.getMotorSystem(),
					centralNervous.getSensorySystem(), centralNervous.getAutonomicSystem(),
					centralNervous.getCerebellarSigns(), centralNervous.getSignsOfMeningealIrritation(),
					centralNervous.getSkull(), centralNervous.getModifiedBy(), processed,
					centralNervous.getBeneficiaryRegID(), centralNervous.getBenVisitID());
		}

		return r;
	}

	public int updateSysMusculoskeletalSystemExamination(SysMusculoskeletalSystemExamination musculoskeletalSystem) {
		int r = 0;
		if (null != musculoskeletalSystem) {
			String processed = sysMusculoskeletalSystemExaminationRepo.getBenMusculoskeletalSystemExaminationStatus(
					musculoskeletalSystem.getBeneficiaryRegID(), musculoskeletalSystem.getBenVisitID());
			if (null != processed && !"N".equals(processed)) {
				processed = "U";
			} else {
				processed = "N";
			}
			r = sysMusculoskeletalSystemExaminationRepo.updateSysMusculoskeletalSystemExamination(
					musculoskeletalSystem.getJoint_TypeOfJoint(), musculoskeletalSystem.getJoint_Laterality(),
					musculoskeletalSystem.getJoint_Abnormality(), musculoskeletalSystem.getUpperLimb_Laterality(),
					musculoskeletalSystem.getUpperLimb_Abnormality(), musculoskeletalSystem.getLowerLimb_Laterality(),
					musculoskeletalSystem.getLowerLimb_Abnormality(), musculoskeletalSystem.getChestWall(),
					musculoskeletalSystem.getSpine(), musculoskeletalSystem.getModifiedBy(), processed,
					musculoskeletalSystem.getBeneficiaryRegID(), musculoskeletalSystem.getBenVisitID());
		}
		return r;
	}

	public int updateSysGenitourinarySystemExamination(SysGenitourinarySystemExamination genitourinarySystem) {
		int r = 0;
		if (null != genitourinarySystem) {
			String processed = sysGenitourinarySystemExaminationRepo.getBenGenitourinarySystemExaminationStatus(
					genitourinarySystem.getBeneficiaryRegID(), genitourinarySystem.getBenVisitID());
			if (null != processed && !"N".equals(processed)) {
				processed = "U";
			} else {
				processed = "N";
			}
			r = sysGenitourinarySystemExaminationRepo.updateSysGenitourinarySystemExamination(
					genitourinarySystem.getRenalAngle(), genitourinarySystem.getSuprapubicRegion(),
					genitourinarySystem.getExternalGenitalia(), genitourinarySystem.getModifiedBy(), processed,
					genitourinarySystem.getBeneficiaryRegID(), genitourinarySystem.getBenVisitID());
		}
		return r;
	}

	public Long savePrescriptionDetailsAndGetPrescriptionID(Long benRegID, Long benVisitID, Integer psmID,
			String createdBy, String externalInvestigation) {
		PrescriptionDetail prescriptionDetail = new PrescriptionDetail();
		prescriptionDetail.setBeneficiaryRegID(benRegID);
		prescriptionDetail.setBenVisitID(benVisitID);
		prescriptionDetail.setProviderServiceMapID(psmID);
		prescriptionDetail.setCreatedBy(createdBy);
		prescriptionDetail.setExternalInvestigation(externalInvestigation);

		Long prescriptionID = saveBenPrescription(prescriptionDetail);
		return prescriptionID;
	}

	public Long saveBeneficiaryPrescription(JsonObject caseSheet) throws Exception {

		PrescriptionDetail prescriptionDetail = InputMapper.gson().fromJson(caseSheet, PrescriptionDetail.class);

		return saveBenPrescription(prescriptionDetail);
	}

	public Long saveBenPrescription(PrescriptionDetail prescription) {
		Long r = null;
		prescription.setPrescriptionID(null);
		PrescriptionDetail prescriptionRS = prescriptionDetailRepo.save(prescription);
		if (prescriptionRS != null && prescriptionRS.getPrescriptionID() > 0) {
			r = prescriptionRS.getPrescriptionID();
		}
		return r;
	}

	public Long saveBeneficiaryLabTestOrderDetails(JsonObject caseSheet, Long prescriptionID) {
		Long returnOBJ = null;
		ArrayList<LabTestOrderDetail> labTestOrderDetails = LabTestOrderDetail.getLabTestOrderDetailList(caseSheet,
				prescriptionID);

		if (labTestOrderDetails != null && labTestOrderDetails.size() > 0) {
			List<LabTestOrderDetail> labTestOrders = (List<LabTestOrderDetail>) labTestOrderDetailRepo
					.save(labTestOrderDetails);
			if (labTestOrderDetails.size() == labTestOrders.size()) {
				returnOBJ = new Long(1);
			}
		} else {
			returnOBJ = new Long(1);
		}

		return returnOBJ;
	}

	public Integer saveBenPrescribedDrugsList(List<PrescribedDrugDetail> prescribedDrugDetailList) {
		Integer r = 0;

		if (prescribedDrugDetailList.size() > 0) {
			List<PrescribedDrugDetail> prescribedDrugDetailListRS = (List<PrescribedDrugDetail>) prescribedDrugDetailRepo
					.save(prescribedDrugDetailList);
			if (prescribedDrugDetailList.size() == prescribedDrugDetailListRS.size()) {
				r = prescribedDrugDetailListRS.size();
			}
		} else {
			r = 1;
		}
		return r;
	}

	public int saveBenInvestigationDetails(WrapperBenInvestigationANC wrapperBenInvestigationANC) {
		Long investigationSuccessFlag = null;
		int res = 0;
		if (wrapperBenInvestigationANC != null) {
			Long prescriptionID = savePrescriptionDetailsAndGetPrescriptionID(
					wrapperBenInvestigationANC.getBeneficiaryRegID(), wrapperBenInvestigationANC.getBenVisitID(),
					wrapperBenInvestigationANC.getProviderServiceMapID(), wrapperBenInvestigationANC.getCreatedBy(),
					wrapperBenInvestigationANC.getExternalInvestigations());

			wrapperBenInvestigationANC.setPrescriptionID(prescriptionID);
			investigationSuccessFlag = saveBenInvestigation(wrapperBenInvestigationANC);
			if (investigationSuccessFlag != null && investigationSuccessFlag > 0) {
				// Investigation data saved successfully.
				res = 1;
			} else {
				// Something went wrong !!!
			}
		} else {
			// Invalid Data..
		}
		return res;
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
		}

		return r;

	}

	public String updateBenVisitStatusFlag(Long benVisitID, String c) {
		return updateBenStatus(benVisitID, c);
	}

	public String updateBenStatus(Long benVisitID, String c) {
		Map<String, String> resMap = new HashMap<>();
		Integer i = benVisitDetailRepo.updateBenFlowStatus(c, benVisitID);
		if (i != null && i > 0) {
			resMap.put("status", "Updated Successfully");
		}
		return new Gson().toJson(resMap);
	}

	public String getNurseWorkList() {
		List<Object[]> nurseWorkListData = reistrarRepoBenSearch.getNurseWorkList();
		// System.out.println("hello");
		return WrapperRegWorklist.getRegistrarWorkList(nurseWorkListData);
	}

	// New Nurse worklist.... 26-03-2018
	public String getNurseWorkListNew(Integer providerServiceMapId) {
		ArrayList<BeneficiaryFlowStatus> obj = beneficiaryFlowStatusRepo.getNurseWorklistNew(providerServiceMapId);

		return new Gson().toJson(obj);
	}

	// New Lab worklist.... 26-03-2018
	public String getLabWorkListNew(Integer providerServiceMapId) {
		ArrayList<BeneficiaryFlowStatus> obj = beneficiaryFlowStatusRepo.getLabWorklistNew(providerServiceMapId);

		return new Gson().toJson(obj);
	}

	// New radiologist worklist.... 26-03-2018
	public String getRadiologistWorkListNew(Integer providerServiceMapId) {
		ArrayList<BeneficiaryFlowStatus> obj = beneficiaryFlowStatusRepo
				.getRadiologistWorkListNew(providerServiceMapId);

		return new Gson().toJson(obj);
	}

	// New oncologist worklist.... 26-03-2018
	public String getOncologistWorkListNew(Integer providerServiceMapId) {
		ArrayList<BeneficiaryFlowStatus> obj = beneficiaryFlowStatusRepo.getOncologistWorkListNew(providerServiceMapId);

		return new Gson().toJson(obj);
	}

	// New pharma worklist.... 26-03-2018
	public String getPharmaWorkListNew(Integer providerServiceMapId) {
		ArrayList<BeneficiaryFlowStatus> obj = beneficiaryFlowStatusRepo.getPharmaWorkListNew(providerServiceMapId);

		return new Gson().toJson(obj);
	}

	public int saveBenAdherenceDetails(BenAdherence benAdherence) {
		int r = 0;
		BenAdherence benAdherenceOBJ = benAdherenceRepo.save(benAdherence);
		if (benAdherenceOBJ != null) {
			r = 1;
		}
		return r;
	}

	public Long saveChildDevelopmentHistory(BenChildDevelopmentHistory benChildDevelopmentHistory) {
		Long developmentSuccessFlag = null;

		BenChildDevelopmentHistory childDevelopmentHistory = BenChildDevelopmentHistory
				.getDevelopmentHistory(benChildDevelopmentHistory);
		BenChildDevelopmentHistory res = benChildDevelopmentHistoryRepo.save(childDevelopmentHistory);
		if (null != res && res.getID() > 0) {
			developmentSuccessFlag = res.getID();
		}
		return developmentSuccessFlag;
	}

	public Long saveChildFeedingHistory(ChildFeedingDetails childFeedingDetails) {
		Long feedingSuccessFlag = null;
		ChildFeedingDetails res = childFeedingDetailsRepo.save(childFeedingDetails);
		if (null != res && res.getID() > 0) {
			feedingSuccessFlag = res.getID();
		}
		return feedingSuccessFlag;
	}

	public Long savePerinatalHistory(PerinatalHistory perinatalHistory) {
		Long perinatalSuccessFlag = null;

		PerinatalHistory res = perinatalHistoryRepo.save(perinatalHistory);
		if (null != res && res.getID() > 0) {
			perinatalSuccessFlag = res.getID();
		}
		return perinatalSuccessFlag;
	}

	public String getBenAdherence(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> resList = benAdherenceRepo.getBenAdherence(beneficiaryRegID, benVisitID);
		BenAdherence benAdherences = BenAdherence.getBenAdherences(resList);
		return new Gson().toJson(benAdherences);
	}

	public String getLabTestOrders(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> resList = labTestOrderDetailRepo.getLabTestOrderDetails(beneficiaryRegID, benVisitID);
		WrapperBenInvestigationANC labTestOrderDetails = LabTestOrderDetail.getLabTestOrderDetails(resList);
		return new Gson().toJson(labTestOrderDetails);
	}

	public BenChildDevelopmentHistory getDevelopmentHistory(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> benChildDevelopmentHistory = benChildDevelopmentHistoryRepo
				.getBenDevelopmentDetails(beneficiaryRegID, benVisitID);
		BenChildDevelopmentHistory developmentHistoryDetails = BenChildDevelopmentHistory
				.getBenChildDevelopmentDetails(benChildDevelopmentHistory);
		return developmentHistoryDetails;
	}

	public PerinatalHistory getPerinatalHistory(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> benPerinatalHistory = perinatalHistoryRepo.getBenPerinatalDetails(beneficiaryRegID,
				benVisitID);
		PerinatalHistory perinatalHistoryDetails = PerinatalHistory.getBenPerinatalDetails(benPerinatalHistory);
		return perinatalHistoryDetails;
	}

	public ChildFeedingDetails getFeedingHistory(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> benFeedingHistory = childFeedingDetailsRepo.getBenFeedingDetails(beneficiaryRegID,
				benVisitID);
		ChildFeedingDetails feedingHistoryDetails = ChildFeedingDetails.getBenFeedingDetails(benFeedingHistory);
		return feedingHistoryDetails;
	}

	public String fetchBenPerinatalHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> perinatalHistoryDetail = perinatalHistoryRepo.getBenPerinatalDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column = new HashMap<>();
		column.put("columnName", "Date of Capture");
		column.put("keyName", "captureDate");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Place Of Delivery");
		column.put("keyName", "placeOfDelivery");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Other Place Of Delivery");
		column.put("keyName", "otherPlaceOfDelivery");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Type Of Delivery");
		column.put("keyName", "typeOfDelivery");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Complication At Birth");
		column.put("keyName", "complicationAtBirth");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Other Complication At Birth");
		column.put("keyName", "otherComplicationAtBirth");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Gestation");
		column.put("keyName", "gestation");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Birth Weight(kg)");
		column.put("keyName", "birthWeight_kg");
		columns.add(column);

		ArrayList<PerinatalHistory> PerinatalHistoryDetails = new ArrayList<PerinatalHistory>();
		if (null != perinatalHistoryDetail) {
			for (Object[] obj : perinatalHistoryDetail) {
				PerinatalHistory history = new PerinatalHistory((Date) obj[0], (String) obj[1], (String) obj[2],
						(String) obj[3], (String) obj[4], (String) obj[5], (String) obj[6], (Double) obj[7]);
				PerinatalHistoryDetails.add(history);
			}
		}

		response.put("columns", columns);
		response.put("data", PerinatalHistoryDetails);
		return new Gson().toJson(response);

	}

	public String fetchBenFeedingHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> feedingHistoryDetail = childFeedingDetailsRepo.getBenFeedingHistoryDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column = new HashMap<>();
		column.put("columnName", "Date of Capture");
		column.put("keyName", "captureDate");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Child ID");
		column.put("keyName", "childID");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Beneficiary Mother ID");
		column.put("keyName", "benMotherID");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Type Of Feed");
		column.put("keyName", "typeOfFeed");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Comp Feed Start Age");
		column.put("keyName", "compFeedStartAge");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "NoOf Comp Feed Per Day");
		column.put("keyName", "noOfCompFeedPerDay");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Food Intolerance Status");
		column.put("keyName", "foodIntoleranceStatus");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Type of Food Intolerance");
		column.put("keyName", "typeofFoodIntolerance");
		columns.add(column);

		ArrayList<ChildFeedingDetails> feedingHistoryDetails = new ArrayList<ChildFeedingDetails>();
		if (null != feedingHistoryDetail) {
			for (Object[] obj : feedingHistoryDetail) {
				ChildFeedingDetails history = new ChildFeedingDetails((Date) obj[0], (Long) obj[1], (Long) obj[2],
						(String) obj[3], (String) obj[4], (Character) obj[5], (Character) obj[6], (String) obj[7]);
				feedingHistoryDetails.add(history);
			}
		}

		response.put("columns", columns);
		response.put("data", feedingHistoryDetails);
		return new Gson().toJson(response);

	}

	public String fetchBenDevelopmentHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> developmentHistoryDetail = benChildDevelopmentHistoryRepo
				.getBenDevelopmentHistoryDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column = new HashMap<>();
		column.put("columnName", "Date of Capture");
		column.put("keyName", "captureDate");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Gross Motor Milestone");
		column.put("keyName", "grossMotorMilestone");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Is GMM Attained");
		column.put("keyName", "isGMMAttained");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Fine Motor Milestone");
		column.put("keyName", "fineMotorMilestone");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Is FMM Attained");
		column.put("keyName", "isFMMAttained");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Social Milestone");
		column.put("keyName", "socialMilestone");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Is SM Attained");
		column.put("keyName", "isSMAttained");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Language Milestone");
		column.put("keyName", "languageMilestone");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Is LM Attained");
		column.put("keyName", "isLMAttained");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Development Problem");
		column.put("keyName", "developmentProblem");
		columns.add(column);

		ArrayList<BenChildDevelopmentHistory> developmentHistoryDetails = new ArrayList<BenChildDevelopmentHistory>();
		if (null != developmentHistoryDetail) {
			for (Object[] obj : developmentHistoryDetail) {

				BenChildDevelopmentHistory history = new BenChildDevelopmentHistory((Date) obj[0], (String) obj[1],
						(Boolean) obj[2], (String) obj[3], (Boolean) obj[4], (String) obj[5], (Boolean) obj[6],
						(String) obj[7], (Boolean) obj[8], (String) obj[9]);
				developmentHistoryDetails.add(history);
			}
		}

		response.put("columns", columns);
		response.put("data", developmentHistoryDetails);
		return new Gson().toJson(response);

	}

	public int updateChildFeedingHistory(ChildFeedingDetails childFeedingDetails) {
		int response = 0;
		int recordsAvailable = 0;
		if (null != childFeedingDetails) {
			String processed = childFeedingDetailsRepo.getBenChildFeedingDetailStatus(
					childFeedingDetails.getBeneficiaryRegID(), childFeedingDetails.getBenVisitID());
			if (null != processed) {
				recordsAvailable = 1;
			}
			if (null != processed && !"N".equals(processed)) {
				processed = "U";
			} else {
				processed = "N";
			}
			if (recordsAvailable > 0) {
				response = childFeedingDetailsRepo.updateFeedingDetails(childFeedingDetails.getChildID(),
						childFeedingDetails.getBenMotherID(), childFeedingDetails.getTypeOfFeed(),
						childFeedingDetails.getCompFeedStartAge(), childFeedingDetails.getNoOfCompFeedPerDay(),
						childFeedingDetails.getFoodIntoleranceStatus(), childFeedingDetails.getTypeofFoodIntolerance(),
						childFeedingDetails.getModifiedBy(), processed, childFeedingDetails.getBeneficiaryRegID(),
						childFeedingDetails.getBenVisitID());
			} else {
				childFeedingDetails.setCreatedBy(childFeedingDetails.getModifiedBy());
				ChildFeedingDetails feedingDetails = childFeedingDetailsRepo.save(childFeedingDetails);
				if (null != feedingDetails && feedingDetails.getID() > 0) {
					response = 1;
				}
			}
		}
		return response;
	}

	public int updatePerinatalHistory(PerinatalHistory perinatalHistory) {
		int response = 0;
		int recordsAvailable = 0;
		if (null != perinatalHistory) {
			String processed = perinatalHistoryRepo.getPerinatalHistoryStatus(perinatalHistory.getBeneficiaryRegID(),
					perinatalHistory.getBenVisitID());
			if (null != processed) {
				recordsAvailable = 1;
			}
			if (null != processed && !"N".equals(processed)) {
				processed = "U";
			} else {
				processed = "N";
			}
			if (recordsAvailable > 0) {
				response = perinatalHistoryRepo.updatePerinatalDetails(perinatalHistory.getDeliveryPlaceID(),
						perinatalHistory.getPlaceOfDelivery(), perinatalHistory.getOtherPlaceOfDelivery(),
						perinatalHistory.getDeliveryTypeID(), perinatalHistory.getTypeOfDelivery(),
						perinatalHistory.getComplicationAtBirthID(), perinatalHistory.getComplicationAtBirth(),
						perinatalHistory.getOtherComplicationAtBirth(), perinatalHistory.getGestation(),
						perinatalHistory.getBirthWeight_kg(), perinatalHistory.getModifiedBy(), processed,
						perinatalHistory.getBeneficiaryRegID(), perinatalHistory.getBenVisitID());
			} else {
				perinatalHistory.setCreatedBy(perinatalHistory.getModifiedBy());
				PerinatalHistory perinatalRes = perinatalHistoryRepo.save(perinatalHistory);
				if (null != perinatalRes && perinatalRes.getID() > 0) {
					response = 1;
				}

			}
		}
		return response;
	}

	public int updateChildDevelopmentHistory(BenChildDevelopmentHistory childDevelopmentDetails) {
		int response = 0;
		int recordsAvailable = 0;
		if (null != childDevelopmentDetails) {
			String processed = benChildDevelopmentHistoryRepo.getDevelopmentHistoryStatus(
					childDevelopmentDetails.getBeneficiaryRegID(), childDevelopmentDetails.getBenVisitID());
			if (null != processed) {
				recordsAvailable = 1;
			}
			if (null != processed && !"N".equals(processed)) {
				processed = "U";
			} else {
				processed = "N";
			}
			BenChildDevelopmentHistory childDevelopmentHistory = BenChildDevelopmentHistory
					.getDevelopmentHistory(childDevelopmentDetails);
			if (recordsAvailable > 0) {
				response = benChildDevelopmentHistoryRepo.updatePerinatalDetails(
						childDevelopmentHistory.getGrossMotorMilestone(), childDevelopmentHistory.getIsGMMAttained(),
						childDevelopmentHistory.getFineMotorMilestone(), childDevelopmentHistory.getIsFMMAttained(),
						childDevelopmentHistory.getSocialMilestone(), childDevelopmentHistory.getIsSMAttained(),
						childDevelopmentHistory.getLanguageMilestone(), childDevelopmentHistory.getIsLMAttained(),
						childDevelopmentHistory.getDevelopmentProblem(), childDevelopmentHistory.getModifiedBy(),
						processed, childDevelopmentHistory.getBeneficiaryRegID(),
						childDevelopmentHistory.getBenVisitID());
			} else {
				childDevelopmentHistory.setCreatedBy(childDevelopmentHistory.getModifiedBy());
				BenChildDevelopmentHistory developmentDetails = benChildDevelopmentHistoryRepo
						.save(childDevelopmentHistory);
				if (null != developmentDetails && developmentDetails.getID() > 0) {
					response = 1;
				}
			}
		}
		return response;
	}

	public int updateSysGastrointestinalExamination(SysGastrointestinalExamination gastrointestinalExamination) {
		int response = 0;
		if (null != gastrointestinalExamination) {
			String processed = sysGastrointestinalExaminationRepo.getBenGastrointestinalExaminationStatus(
					gastrointestinalExamination.getBeneficiaryRegID(), gastrointestinalExamination.getBenVisitID());
			if (null != processed && !"N".equals(processed)) {
				processed = "U";
			} else {
				processed = "N";
			}
			response = sysGastrointestinalExaminationRepo.updateSysGastrointestinalExamination(
					gastrointestinalExamination.getInspection(), gastrointestinalExamination.getPalpation(),
					gastrointestinalExamination.getPalpation_AbdomenTexture(),
					gastrointestinalExamination.getPalpation_Liver(), gastrointestinalExamination.getPalpation_Spleen(),
					gastrointestinalExamination.getPalpation_Tenderness(),
					gastrointestinalExamination.getPalpation_LocationOfTenderness(),
					gastrointestinalExamination.getPercussion(), gastrointestinalExamination.getAuscultation(),
					gastrointestinalExamination.getAnalRegion(), gastrointestinalExamination.getModifiedBy(), processed,
					gastrointestinalExamination.getBeneficiaryRegID(), gastrointestinalExamination.getBenVisitID());
		}
		return response;
	}

	public Map<String, Object> getGraphicalTrendData(Long benRegID, String visitCategory) {
		Map<String, Object> returnOBJ = new HashMap<>();

		ArrayList<Map<String, Object>> weightList = new ArrayList<>();
		ArrayList<Map<String, Object>> bpList = new ArrayList<>();
		ArrayList<Map<String, Object>> bgList = new ArrayList<>();

		Map<String, Object> weightOBJ;
		Map<String, Object> bpObj;
		Map<String, Object> bgOBJ;

		if (visitCategory.equalsIgnoreCase("cancerScreening")) {

		} else {
			ArrayList<Object[]> benAnthro = benAnthropometryRepo.getBenAnthropometryDetailForGraphtrends(benRegID);
			ArrayList<Object[]> benVital = benPhysicalVitalRepo.getBenPhysicalVitalDetailForGraphTrends(benRegID);

			if (benAnthro != null && benAnthro.size() > 0) {
				for (Object[] objArr : benAnthro) {
					weightOBJ = new HashMap<>();
					weightOBJ.put("weight", objArr[0]);
					weightOBJ.put("date", objArr[1]);

					weightList.add(weightOBJ);
				}
			}

			if (benVital != null && benVital.size() > 0) {
				for (Object[] objArr : benVital) {
					if (objArr[0] != null && (Short) objArr[0] > 0 && objArr[1] != null && (Short) objArr[1] > 0) {
						bpObj = new HashMap<>();
						bpObj.put("avgSysBP", objArr[0]);
						bpObj.put("avgDysBP", objArr[1]);
						bpObj.put("date", objArr[5]);

						bpList.add(bpObj);
					}
					if (objArr[2] != null || objArr[3] != null || objArr[4] != null) {
						bgOBJ = new HashMap<>();
						bgOBJ.put("bg_fasting", objArr[2]);
						bgOBJ.put("bg_random", objArr[3]);
						bgOBJ.put("bg_2hr_pp", objArr[4]);
						bgOBJ.put("date", objArr[5]);

						bgList.add(bgOBJ);
					}
				}
			}

			returnOBJ.put("weightList", weightList);
			returnOBJ.put("bpList", bpList);
			returnOBJ.put("bgList", bgList);
		}
		return returnOBJ;
	}
}
