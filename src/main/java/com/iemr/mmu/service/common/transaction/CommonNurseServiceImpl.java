package com.iemr.mmu.service.common.transaction;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
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
import com.iemr.mmu.data.anc.WrapperChildOptionalVaccineDetail;
import com.iemr.mmu.data.anc.WrapperComorbidCondDetails;
import com.iemr.mmu.data.anc.WrapperFemaleObstetricHistory;
import com.iemr.mmu.data.anc.WrapperImmunizationHistory;
import com.iemr.mmu.data.anc.WrapperMedicationHistory;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.repo.nurse.BenAnthropometryRepo;
import com.iemr.mmu.repo.nurse.BenPhysicalVitalRepo;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;
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
import com.iemr.mmu.repo.registrar.RegistrarRepoBenData;

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
	private PerinatalHistoryRepo perinatalHistoryRepo;
	private ChildFeedingDetailsRepo childFeedingDetailsRepo;
	private BenChildDevelopmentHistoryRepo benChildDevelopmentHistoryRepo;
	
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

	public int saveBenChiefComplaints(List<BenChiefComplaint> benChiefComplaintList) {
		int r = 0;
		List<BenChiefComplaint> benChiefComplaintResultList = (List<BenChiefComplaint>) benChiefComplaintRepo
				.save(benChiefComplaintList);

		if (benChiefComplaintResultList != null && benChiefComplaintResultList.size() > 0) {
			r = benChiefComplaintResultList.size();
		}
		return r;
	}
	
	public Long saveBenPastHistory(BenMedHistory benMedHistory) {
		Long pastHistorySuccessFlag = null;
		ArrayList<BenMedHistory> benMedHistoryList = benMedHistory.getBenPastHistory();
		ArrayList<BenMedHistory> res = (ArrayList<BenMedHistory>) benMedHistoryRepo.save(benMedHistoryList);
		if (null != res && res.size() > 0) {
			pastHistorySuccessFlag = res.get(0).getBenMedHistoryID();
		}
		return pastHistorySuccessFlag;
	}
	
	public Long saveBenComorbidConditions(WrapperComorbidCondDetails wrapperComorbidCondDetails) {
		Long comrbidSuccessFlag = null;
		ArrayList<BencomrbidityCondDetails> bencomrbidityCondDetailsList = wrapperComorbidCondDetails
				.getComrbidityConds();
		ArrayList<BencomrbidityCondDetails> res = (ArrayList<BencomrbidityCondDetails>) bencomrbidityCondRepo
				.save(bencomrbidityCondDetailsList);
		if (null != res && res.size() > 0) {
			comrbidSuccessFlag = res.get(0).getID();
		}
		return comrbidSuccessFlag;
	}
	
	public Long saveBenMedicationHistory(WrapperMedicationHistory wrapperMedicationHistory) {
		Long medicationSuccessFlag = null;
		ArrayList<BenMedicationHistory> benMedicationHistoryList = wrapperMedicationHistory
				.getBenMedicationHistoryDetails();
		ArrayList<BenMedicationHistory> res = (ArrayList<BenMedicationHistory>) benMedicationHistoryRepo
				.save(benMedicationHistoryList);
		if (null != res && res.size() > 0) {
			medicationSuccessFlag = res.get(0).getID();
		}
		return medicationSuccessFlag;
	}
	
	public Long saveFemaleObstetricHistory(WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory) {
		Long obstetricSuccessFlag = null;

		ArrayList<FemaleObstetricHistory> FemaleObstetricHistorylist = wrapperFemaleObstetricHistory
				.getFemaleObstetricHistoryDetails();
		ArrayList<FemaleObstetricHistory> res = (ArrayList<FemaleObstetricHistory>) femaleObstetricHistoryRepo
				.save(FemaleObstetricHistorylist);
		if (null != res && res.size() > 0) {
			obstetricSuccessFlag = res.get(0).getObstetricHistoryID();
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
		ArrayList<BenFamilyHistory> res = (ArrayList<BenFamilyHistory>) benFamilyHistoryRepo.save(familyHistoryList);
		if (null != res && res.size() > 0) {
			familyHistorySuccessFlag = res.get(0).getID();
		}
		return familyHistorySuccessFlag;
	}
	
	public Integer savePersonalHistory(BenPersonalHabit benPersonalHabit) {
		Integer personalHistorySuccessFlag = null;

		ArrayList<BenPersonalHabit> personalHabits = benPersonalHabit.getPersonalHistory();
		ArrayList<BenPersonalHabit> res = (ArrayList<BenPersonalHabit>) benPersonalHabitRepo.save(personalHabits);
		if (null != res && res.size() > 0) {
			personalHistorySuccessFlag = res.get(0).getBenPersonalHabitID();
		}
		return personalHistorySuccessFlag;
	}

	public Long saveAllergyHistory(BenAllergyHistory benAllergyHistory) {
		Long allergyHistorySuccessFlag = null;

		ArrayList<BenAllergyHistory> allergyList = benAllergyHistory.getBenAllergicHistory();
		ArrayList<BenAllergyHistory> res = (ArrayList<BenAllergyHistory>) benAllergyHistoryRepo.save(allergyList);
		if (null != res && res.size() > 0) {
			allergyHistorySuccessFlag = res.get(0).getID();
		}
		return allergyHistorySuccessFlag;
	}
	
	public Long saveChildOptionalVaccineDetail(WrapperChildOptionalVaccineDetail wrapperChildVaccineDetail) {
		Long childVaccineSuccessFlag = null;
		ArrayList<ChildOptionalVaccineDetail> childOptionalVaccineDetails = wrapperChildVaccineDetail
				.getChildOptionalVaccineDetails();
		ArrayList<ChildOptionalVaccineDetail> res = (ArrayList<ChildOptionalVaccineDetail>) childOptionalVaccineDetailRepo
				.save(childOptionalVaccineDetails);
		if (null != res && res.size() > 0) {
			childVaccineSuccessFlag = res.get(0).getID();
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
			r = genitourinarySystemExamination.getID();
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
				benMedHistory = new BenMedHistory((Date) obj[0], (String) obj[1], (String) obj[2], (Date) obj[3], (String) obj[4],
						(String) obj[5], (Date) obj[6]);
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

/*		column = new HashMap<String, Object>();
		column.put("columnName", "Tobacco Use Type ID");
		column.put("keyName", "tobaccoUseTypeID");
		columns.add(column);*/

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

				BenPersonalHabit benPersonalHabit = new BenPersonalHabit((Date) obj[0], (String) obj[1], (String) obj[2],
						(String) obj[3], (String) obj[4], (String) obj[5], (Short) obj[6], (Date) obj[7], (Character) obj[8]);

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

/*		column = new HashMap<String, Object>();
		column.put("columnName", "Alcohol Type ID");
		column.put("keyName", "alcoholTypeID");
		columns.add(column);
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
				BenPersonalHabit benPersonalHabit = new BenPersonalHabit((Date) obj[0], (String) obj[1], (String) obj[2],
						(String) obj[3], (String) obj[4], (String) obj[5], (String) obj[6],
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

		/*column = new HashMap<String, Object>();
		column.put("columnName", "Allergic Reaction Type ID");
		column.put("keyName", "allergicReactionTypeID");
		columns.add(column);*/

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
				
				BenAllergyHistory benPersonalHabit = new BenAllergyHistory((Date) obj[0], (String) obj[1], (String) obj[2],
						(String) obj[3], (String) obj[4], (String) obj[5], (String) obj[6]);
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

		/*column = new HashMap<String, Object>();
		column.put("columnName", "Disease Type ID");
		column.put("keyName", "diseaseTypeID");
		columns.add(column);*/

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
				
				BenMenstrualDetails history = new BenMenstrualDetails((Date) obj[0], (String) obj[1], (String) obj[2], (String) obj[3], (String) obj[4],
						(Date) obj[5]);
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
						(String) obj[2], (String) obj[3],  (String) obj[4], 
						(String) obj[5],  (String) obj[6], (String) obj[7], 
						(String) obj[8], (String) obj[9],  (String) obj[10],
						(String) obj[11], (String) obj[12],  (String) obj[13], (String) obj[14],
						(String) obj[15],  (String) obj[16], (String) obj[17]);
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

				BencomrbidityCondDetails history = new BencomrbidityCondDetails((Date) obj[0], (String) obj[1], (String) obj[2],
						(Date) obj[3]);
				bencomrbidityConds.add(history);
			}

		}

		response.put("columns", columns);
		response.put("data", bencomrbidityConds);
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

		/** Later we will enable these two if needed**/
	/*	column = new HashMap<String, Object>();
		column.put("columnName", "Status");
		column.put("keyName", "status");
		columns.add(column);

		column = new HashMap<String, Object>();
		column.put("columnName", "Received Date");
		column.put("keyName", "receivedDate");
		columns.add(column);*/

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
				ChildOptionalVaccineDetail history = new ChildOptionalVaccineDetail((Date) obj[0], (String) obj[1], (String) obj[2],
						(String) obj[3], (Timestamp) obj[4], (String) obj[5], (String) obj[6]);
				childOptionalVaccineDetails.add(history);
			}
		}

		response.put("columns", columns);
		response.put("data", childOptionalVaccineDetails);
		return new Gson().toJson(response);

	}
	
	public String fetchBenPerinatalHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> perinatalHistoryDetail = perinatalHistoryRepo
				.getBenPerinatalDetail(beneficiaryRegID);

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
		ArrayList<Object[]> feedingHistoryDetail = childFeedingDetailsRepo
				.getBenFeedingHistoryDetail(beneficiaryRegID);

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
						(String) obj[7], (Boolean) obj[8], (String) obj[9] );
				developmentHistoryDetails.add(history);
			}
		}

		response.put("columns", columns);
		response.put("data", developmentHistoryDetails);
		return new Gson().toJson(response);

	}
	
	
}
