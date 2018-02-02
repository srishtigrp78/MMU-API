package com.iemr.mmu.service.common.transaction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.data.anc.BenAllergyHistory;
import com.iemr.mmu.data.anc.BenFamilyHistory;
import com.iemr.mmu.data.anc.BenMedHistory;
import com.iemr.mmu.data.anc.BenMedicationHistory;
import com.iemr.mmu.data.anc.BenMenstrualDetails;
import com.iemr.mmu.data.anc.BenPersonalHabit;
import com.iemr.mmu.data.anc.BencomrbidityCondDetails;
import com.iemr.mmu.data.anc.ChildOptionalVaccineDetail;
import com.iemr.mmu.data.anc.ChildVaccineDetail1;
import com.iemr.mmu.data.anc.FemaleObstetricHistory;
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
import com.iemr.mmu.repo.nurse.anc.BenFamilyHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenMedHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenMedicationHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenMenstrualDetailsRepo;
import com.iemr.mmu.repo.nurse.anc.BenPersonalHabitRepo;
import com.iemr.mmu.repo.nurse.anc.BencomrbidityCondRepo;
import com.iemr.mmu.repo.nurse.anc.ChildOptionalVaccineDetailRepo;
import com.iemr.mmu.repo.nurse.anc.ChildVaccineDetail1Repo;
import com.iemr.mmu.repo.nurse.anc.FemaleObstetricHistoryRepo;
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
	
}
