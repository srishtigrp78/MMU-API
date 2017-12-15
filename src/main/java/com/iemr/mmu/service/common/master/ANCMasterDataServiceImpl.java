package com.iemr.mmu.service.common.master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.doctor.ChiefComplaintMaster;
import com.iemr.mmu.data.doctor.DrugDoseMaster;
import com.iemr.mmu.data.doctor.DrugDurationUnitMaster;
import com.iemr.mmu.data.doctor.DrugFormMaster;
import com.iemr.mmu.data.doctor.DrugFrequencyMaster;
import com.iemr.mmu.data.doctor.LabTestMaster;
import com.iemr.mmu.data.institution.Institute;
import com.iemr.mmu.data.masterdata.anc.AllergicReactionTypes;
import com.iemr.mmu.data.masterdata.anc.BirthComplication;
import com.iemr.mmu.data.masterdata.anc.BloodGroups;
import com.iemr.mmu.data.masterdata.anc.ChildVaccinations;
import com.iemr.mmu.data.masterdata.anc.ComorbidCondition;
import com.iemr.mmu.data.masterdata.anc.CompFeeds;
import com.iemr.mmu.data.masterdata.anc.ComplicationTypes;
import com.iemr.mmu.data.masterdata.anc.CounsellingType;
import com.iemr.mmu.data.masterdata.anc.DeliveryComplicationTypes;
import com.iemr.mmu.data.masterdata.anc.DeliveryPlace;
import com.iemr.mmu.data.masterdata.anc.DeliveryType;
import com.iemr.mmu.data.masterdata.anc.DevelopmentProblems;
import com.iemr.mmu.data.masterdata.anc.DiseaseType;
import com.iemr.mmu.data.masterdata.anc.FundalHeight;
import com.iemr.mmu.data.masterdata.anc.Gestation;
import com.iemr.mmu.data.masterdata.anc.GrossMotorMilestone;
import com.iemr.mmu.data.masterdata.anc.IllnessTypes;
import com.iemr.mmu.data.masterdata.anc.JointTypes;
import com.iemr.mmu.data.masterdata.anc.MenstrualCycleRange;
import com.iemr.mmu.data.masterdata.anc.MenstrualCycleStatus;
import com.iemr.mmu.data.masterdata.anc.MenstrualProblem;
import com.iemr.mmu.data.masterdata.anc.Musculoskeletal;
import com.iemr.mmu.data.masterdata.anc.NewBornComplication;
import com.iemr.mmu.data.masterdata.anc.PersonalHabitType;
import com.iemr.mmu.data.masterdata.anc.PostNatalComplication;
import com.iemr.mmu.data.masterdata.anc.PostpartumComplicationTypes;
import com.iemr.mmu.data.masterdata.anc.PregComplicationTypes;
import com.iemr.mmu.data.masterdata.anc.PregDuration;
import com.iemr.mmu.data.masterdata.anc.PregOutcome;
import com.iemr.mmu.data.masterdata.anc.ServiceMaster;
import com.iemr.mmu.data.masterdata.anc.SurgeryTypes;
import com.iemr.mmu.data.masterdata.nurse.CancerDiseaseType;
import com.iemr.mmu.data.masterdata.nurse.FamilyMemberType;
import com.iemr.mmu.repo.doctor.ChiefComplaintMasterRepo;
import com.iemr.mmu.repo.doctor.DrugDoseMasterRepo;
import com.iemr.mmu.repo.doctor.DrugDurationUnitMasterRepo;
import com.iemr.mmu.repo.doctor.DrugFormMasterRepo;
import com.iemr.mmu.repo.doctor.DrugFrequencyMasterRepo;
import com.iemr.mmu.repo.doctor.LabTestMasterRepo;
import com.iemr.mmu.repo.masterrepo.anc.AllergicReactionTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.BirthComplicationRepo;
import com.iemr.mmu.repo.masterrepo.anc.BloodGroupsRepo;
import com.iemr.mmu.repo.masterrepo.anc.ChildVaccinationsRepo;
import com.iemr.mmu.repo.masterrepo.anc.ComorbidConditionRepo;
import com.iemr.mmu.repo.masterrepo.anc.CompFeedsRepo;
import com.iemr.mmu.repo.masterrepo.anc.ComplicationTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.CounsellingTypeRepo;
import com.iemr.mmu.repo.masterrepo.anc.DeliveryComplicationTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.DeliveryPlaceRepo;
import com.iemr.mmu.repo.masterrepo.anc.DeliveryTypeRepo;
import com.iemr.mmu.repo.masterrepo.anc.DevelopmentProblemsRepo;
import com.iemr.mmu.repo.masterrepo.anc.DiseaseTypeRepo;
import com.iemr.mmu.repo.masterrepo.anc.FundalHeightRepo;
import com.iemr.mmu.repo.masterrepo.anc.GestationRepo;
import com.iemr.mmu.repo.masterrepo.anc.GrossMotorMilestoneRepo;
import com.iemr.mmu.repo.masterrepo.anc.IllnessTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.JointTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.MenstrualCycleRangeRepo;
import com.iemr.mmu.repo.masterrepo.anc.MenstrualCycleStatusRepo;
import com.iemr.mmu.repo.masterrepo.anc.MenstrualProblemRepo;
import com.iemr.mmu.repo.masterrepo.anc.MusculoskeletalRepo;
import com.iemr.mmu.repo.masterrepo.anc.NewBornComplicationRepo;
import com.iemr.mmu.repo.masterrepo.anc.PersonalHabitTypeRepo;
import com.iemr.mmu.repo.masterrepo.anc.PostNatalComplicationRepo;
import com.iemr.mmu.repo.masterrepo.anc.PostpartumComplicationTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.PregComplicationTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.PregDurationRepo;
import com.iemr.mmu.repo.masterrepo.anc.PregOutcomeRepo;
import com.iemr.mmu.repo.masterrepo.anc.ServiceMasterRepo;
import com.iemr.mmu.repo.masterrepo.anc.SurgeryTypesRepo;
import com.iemr.mmu.repo.masterrepo.doctor.InstituteRepo;
import com.iemr.mmu.repo.masterrepo.nurse.CancerDiseaseMasterRepo;
import com.iemr.mmu.repo.masterrepo.nurse.FamilyMemberMasterRepo;

@Service
public class ANCMasterDataServiceImpl {
	
	private AllergicReactionTypesRepo allergicReactionTypesRepo;
	private BirthComplicationRepo birthComplicationRepo;
	private BloodGroupsRepo bloodGroupsRepo;
	private ChildVaccinationsRepo childVaccinationsRepo;
	private DeliveryComplicationTypesRepo deliveryComplicationTypesRepo;
	private DeliveryPlaceRepo deliveryPlaceRepo;
	private DeliveryTypeRepo deliveryTypeRepo;
	private DevelopmentProblemsRepo developmentProblemsRepo;
	private GestationRepo gestationRepo;
	private IllnessTypesRepo illnessTypesRepo;
	private JointTypesRepo jointTypesRepo;
	private MenstrualCycleRangeRepo menstrualCycleRangeRepo;
	private MenstrualCycleStatusRepo menstrualCycleStatusRepo;
	private MenstrualProblemRepo menstrualProblemRepo;
	private MusculoskeletalRepo musculoskeletalRepo;
	private PostpartumComplicationTypesRepo postpartumComplicationTypesRepo;
	private PregComplicationTypesRepo pregComplicationTypesRepo;
	private PregDurationRepo pregDurationRepo;
	private SurgeryTypesRepo surgeryTypesRepo;
	private ComorbidConditionRepo comorbidConditionRepo;
	private CompFeedsRepo compFeedsRepo;
	private FundalHeightRepo fundalHeightRepo;
	private GrossMotorMilestoneRepo grossMotorMilestoneRepo;
	private ServiceMasterRepo serviceMasterRepo;
	private CounsellingTypeRepo counsellingTypeRepo;
	private InstituteRepo instituteRepo;
	private PersonalHabitTypeRepo personalHabitTypeRepo;
	private PostNatalComplicationRepo postNatalComplicationRepo;
	private PregOutcomeRepo pregOutcomeRepo;
	private DiseaseTypeRepo diseaseTypeRepo;
	private NewBornComplicationRepo newBornComplicationRepo;
	private ComplicationTypesRepo complicationTypesRepo;
	
	private ChiefComplaintMasterRepo chiefComplaintMasterRepo;
	private FamilyMemberMasterRepo familyMemberMasterRepo;
	private LabTestMasterRepo labTestMasterRepo;
	
	
	private DrugDoseMasterRepo drugDoseMasterRepo;
	private DrugDurationUnitMasterRepo drugDurationUnitMasterRepo;
	private DrugFormMasterRepo drugFormMasterRepo;
	private DrugFrequencyMasterRepo drugFrequencyMasterRepo;
	
	@Autowired
	public void setAllergicReactionTypesRepo(AllergicReactionTypesRepo allergicReactionTypesRepo) {
		this.allergicReactionTypesRepo = allergicReactionTypesRepo;
	}
	
	@Autowired
	public void setBirthComplicationRepo(BirthComplicationRepo birthComplicationRepo) {
		this.birthComplicationRepo = birthComplicationRepo;
	}
	
	@Autowired
	public void setBloodGroupsRepo(BloodGroupsRepo bloodGroupsRepo) {
		this.bloodGroupsRepo = bloodGroupsRepo;
	}
	
	@Autowired
	public void setChildVaccinationsRepo(ChildVaccinationsRepo childVaccinationsRepo) {
		this.childVaccinationsRepo = childVaccinationsRepo;
	}
	
	@Autowired
	public void setDeliveryComplicationTypesRepo(DeliveryComplicationTypesRepo deliveryComplicationTypesRepo) {
		this.deliveryComplicationTypesRepo = deliveryComplicationTypesRepo;
	}
	
	@Autowired
	public void setDeliveryPlaceRepo(DeliveryPlaceRepo deliveryPlaceRepo) {
		this.deliveryPlaceRepo = deliveryPlaceRepo;
	}
	
	@Autowired
	public void setDeliveryTypeRepo(DeliveryTypeRepo deliveryTypeRepo) {
		this.deliveryTypeRepo = deliveryTypeRepo;
	}
	
	@Autowired
	public void setDevelopmentProblemsRepo(DevelopmentProblemsRepo developmentProblemsRepo) {
		this.developmentProblemsRepo = developmentProblemsRepo;
	}
	
	@Autowired
	public void setGestationRepo(GestationRepo gestationRepo) {
		this.gestationRepo = gestationRepo;
	}
	
	@Autowired
	public void setIllnessTypesRepo(IllnessTypesRepo illnessTypesRepo) {
		this.illnessTypesRepo = illnessTypesRepo;
	}
	
	@Autowired
	public void setJointTypesRepo(JointTypesRepo jointTypesRepo) {
		this.jointTypesRepo = jointTypesRepo;
	}
	
	@Autowired
	public void setMenstrualCycleRangeRepo(MenstrualCycleRangeRepo menstrualCycleRangeRepo) {
		this.menstrualCycleRangeRepo = menstrualCycleRangeRepo;
	}
	
	@Autowired
	public void setMenstrualCycleStatusRepo(MenstrualCycleStatusRepo menstrualCycleStatusRepo) {
		this.menstrualCycleStatusRepo = menstrualCycleStatusRepo;
	}
	
	@Autowired
	public void setMenstrualProblemRepo(MenstrualProblemRepo menstrualProblemRepo) {
		this.menstrualProblemRepo = menstrualProblemRepo;
	}
	
	@Autowired
	public void setMusculoskeletalRepo(MusculoskeletalRepo musculoskeletalRepo) {
		this.musculoskeletalRepo = musculoskeletalRepo;
	}
	
	@Autowired
	public void setPostpartumComplicationTypesRepo(PostpartumComplicationTypesRepo postpartumComplicationTypesRepo) {
		this.postpartumComplicationTypesRepo = postpartumComplicationTypesRepo;
	}
	
	@Autowired
	public void setPregComplicationTypesRepo(PregComplicationTypesRepo pregComplicationTypesRepo) {
		this.pregComplicationTypesRepo = pregComplicationTypesRepo;
	}
	
	@Autowired
	public void setPregDurationRepo(PregDurationRepo pregDurationRepo) {
		this.pregDurationRepo = pregDurationRepo;
	}
	
	@Autowired
	public void setSurgeryTypesRepo(SurgeryTypesRepo surgeryTypesRepo) {
		this.surgeryTypesRepo = surgeryTypesRepo;
	}
	
	@Autowired
	public void setChiefComplaintMasterRepo(ChiefComplaintMasterRepo chiefComplaintMasterRepo) {
		this.chiefComplaintMasterRepo = chiefComplaintMasterRepo;
	}
	
	@Autowired
	public void setFamilyMemberMasterRepo(FamilyMemberMasterRepo familyMemberMasterRepo) {
		this.familyMemberMasterRepo = familyMemberMasterRepo;
	}
	
	@Autowired
	public void setLabTestMasterRepo(LabTestMasterRepo labTestMasterRepo) {
		this.labTestMasterRepo = labTestMasterRepo;
	}
	
	@Autowired
	public void setDrugDoseMasterRepo(DrugDoseMasterRepo drugDoseMasterRepo) {
		this.drugDoseMasterRepo = drugDoseMasterRepo;
	}
	
	@Autowired
	public void setDrugDurationUnitMasterRepo(DrugDurationUnitMasterRepo drugDurationUnitMasterRepo) {
		this.drugDurationUnitMasterRepo = drugDurationUnitMasterRepo;
	}
	
	@Autowired
	public void setDrugFormMasterRepo(DrugFormMasterRepo drugFormMasterRepo) {
		this.drugFormMasterRepo = drugFormMasterRepo;
	}
	
	@Autowired
	public void setDrugFrequencyMasterRepo(DrugFrequencyMasterRepo drugFrequencyMasterRepo) {
		this.drugFrequencyMasterRepo = drugFrequencyMasterRepo;
	}
	
	@Autowired
	public void setComorbidConditionRepo(ComorbidConditionRepo comorbidConditionRepo) {
		this.comorbidConditionRepo = comorbidConditionRepo;
	}
	
	@Autowired
	public void setCompFeedsRepo(CompFeedsRepo compFeedsRepo) {
		this.compFeedsRepo = compFeedsRepo;
	}
	
	@Autowired
	public void setFundalHeightRepo(FundalHeightRepo fundalHeightRepo) {
		this.fundalHeightRepo = fundalHeightRepo;
	}
	
	@Autowired
	public void setGrossMotorMilestoneRepo(GrossMotorMilestoneRepo grossMotorMilestoneRepo) {
		this.grossMotorMilestoneRepo = grossMotorMilestoneRepo;
	}
	
	@Autowired
	public void setServiceMasterRepo(ServiceMasterRepo serviceMasterRepo) {
		this.serviceMasterRepo = serviceMasterRepo;
	}
	
	@Autowired
	public void setCounsellingTypeRepo(CounsellingTypeRepo counsellingTypeRepo) {
		this.counsellingTypeRepo = counsellingTypeRepo;
	}
	
	@Autowired
	public void setInstituteRepo(InstituteRepo instituteRepo) {
		this.instituteRepo = instituteRepo;
	}
	
	@Autowired
	public void setPersonalHabitTypeRepo(PersonalHabitTypeRepo personalHabitTypeRepo) {
		this.personalHabitTypeRepo = personalHabitTypeRepo;
	}
	
	@Autowired
	public void setPostNatalComplicationRepo(PostNatalComplicationRepo postNatalComplicationRepo) {
		this.postNatalComplicationRepo = postNatalComplicationRepo;
	}
	
	@Autowired
	public void setPregOutcomeRepo(PregOutcomeRepo pregOutcomeRepo) {
		this.pregOutcomeRepo = pregOutcomeRepo;
	}
	
	@Autowired
	public void setDiseaseTypeRepo(DiseaseTypeRepo diseaseTypeRepo) {
		this.diseaseTypeRepo = diseaseTypeRepo;
	}
	
	@Autowired
	public void setNewBornComplicationRepo(NewBornComplicationRepo newBornComplicationRepo) {
		this.newBornComplicationRepo = newBornComplicationRepo;
	}
	
	@Autowired
	public void setComplicationTypesRepo(ComplicationTypesRepo complicationTypesRepo) {
		this.complicationTypesRepo = complicationTypesRepo;
	}
	
	public String getANCMasterDataForNurse() {
		Map<String, Object> resMap = new HashMap<String, Object>();
			
		ArrayList<Object[]> allergicReactionTypes = allergicReactionTypesRepo.getAllergicReactionTypes();
 //ArrayList<Object[]> birthComplications = birthComplicationRepo.getBirthComplicationTypes();
		ArrayList<Object[]> bloodGroups = bloodGroupsRepo.getBloodGroups();
		ArrayList<Object[]> childVaccinations = childVaccinationsRepo.getChildVaccinations();
 //ArrayList<Object[]> deliveryComplicationTypes = deliveryComplicationTypesRepo.getDeliveryComplicationTypes();
		ArrayList<Object[]> deliveryPlace = deliveryPlaceRepo.getDeliveryPlaces();
		ArrayList<Object[]> deliveryType = deliveryTypeRepo.getDeliveryTypes();
		ArrayList<Object[]> developmentProblems = developmentProblemsRepo.getDevelopmentProblems();
		ArrayList<Object[]> gestation = gestationRepo.getGestationTypes();
		ArrayList<Object[]> illnessTypes = illnessTypesRepo.getIllnessTypes();
		ArrayList<Object[]> jointTypes = jointTypesRepo.getJointTypes();
		ArrayList<Object[]> menstrualCycleLengths = menstrualCycleRangeRepo.getMenstrualCycleRanges("Cycle Length");
		ArrayList<Object[]> menstrualCycleBloodFlowDuration = menstrualCycleRangeRepo.getMenstrualCycleRanges(" Blood Flow Duration");
		ArrayList<Object[]> menstrualCycleStatus = menstrualCycleStatusRepo.getMenstrualCycleStatuses();
		ArrayList<Object[]> menstrualProblem = menstrualProblemRepo.getMenstrualProblems();
		ArrayList<Object[]> musculoskeletalLateralityTypes = musculoskeletalRepo.getMusculoskeletalvalues("Laterality");
		ArrayList<Object[]> musculoskeletalAbnormalityTypes = musculoskeletalRepo.getMusculoskeletalvalues("Abnormality");
  //ArrayList<Object[]> postpartumComplicationTypes = postpartumComplicationTypesRepo.getPostpartumComplicationTypes();
  //ArrayList<Object[]> pregComplicationTypes = pregComplicationTypesRepo.getPregComplicationTypes();
		ArrayList<Object[]> pregDuration = pregDurationRepo.getPregDurationTypes();
		ArrayList<Object[]> surgeryTypes = surgeryTypesRepo.getSurgeryTypes();
		ArrayList<Object[]> comorbidConditions = comorbidConditionRepo.getComorbidConditions();
		ArrayList<Object[]> grossMotorMilestones = grossMotorMilestoneRepo.getGrossMotorMilestones();
		ArrayList<Object[]> fundalHeights = fundalHeightRepo.getFundalHeights();
		ArrayList<Object[]> feedTypes = compFeedsRepo.getCompFeeds("Feed Type");
		ArrayList<Object[]> compFeedAges = compFeedsRepo.getCompFeeds("Comp Feed Age");
		ArrayList<Object[]> compFeedServings  = compFeedsRepo.getCompFeeds("Comp Feed Serving ");
   //ArrayList<Object[]> postNatalComplications = postNatalComplicationRepo.getPostNatalComplications();
		ArrayList<Object[]> pregOutcomes = pregOutcomeRepo.getPregOutcomes();
   //ArrayList<Object[]> newBornComplications = newBornComplicationRepo.getNewBornComplications();
		
		//complications  - moved to m_complication table
		ArrayList<Object[]> birthComplications = complicationTypesRepo.getComplicationTypes("Birth Complication");
		ArrayList<Object[]> deliveryComplicationTypes = complicationTypesRepo.getComplicationTypes("Delivery Complication");
		ArrayList<Object[]> postpartumComplicationTypes = complicationTypesRepo.getComplicationTypes("Postpartum Complication");
		ArrayList<Object[]> pregComplicationTypes = complicationTypesRepo.getComplicationTypes("Pregnancy Complication");
		ArrayList<Object[]> postNatalComplications = complicationTypesRepo.getComplicationTypes("Postnatal Complication");
		//newborn and birth complications are same
		//ArrayList<Object[]> newBornComplications = complicationTypesRepo.getComplicationTypes("Birth Complication");
		
		//existing
		ArrayList<Object[]> ccList = chiefComplaintMasterRepo.getChiefComplaintMaster();
		
		ArrayList<Object[]> DiseaseTypes = diseaseTypeRepo.getDiseaseTypes();
//		ArrayList<Object[]> tobaccoUseStatus = cancerPersonalHabitMasterRepo
//				.getCancerPersonalHabitTypeMaster("Tobacco Use Status");
//		ArrayList<Object[]> typeOfTobaccoProducts = cancerPersonalHabitMasterRepo
//				.getCancerPersonalHabitTypeMaster("Type of Tobacco Product");
//		ArrayList<Object[]> alcoholUseStatus = cancerPersonalHabitMasterRepo
//				.getCancerPersonalHabitTypeMaster("Alcohol Usage");
//		ArrayList<Object[]> typeOfAlcoholProducts = cancerPersonalHabitMasterRepo
//				.getCancerPersonalHabitTypeMaster("Type of Alcohol");
//		
//		ArrayList<Object[]> frequencyOfAlcoholIntake = cancerPersonalHabitMasterRepo
//				.getCancerPersonalHabitTypeMaster("Frequency of Alcohol Intake");
//		ArrayList<Object[]> quantityOfAlcoholIntake = cancerPersonalHabitMasterRepo
//				.getCancerPersonalHabitTypeMaster("Average Quantity of Alcohol consumption");
		
		ArrayList<Object[]> tobaccoUseStatus = personalHabitTypeRepo.getPersonalHabitTypeMaster("Tobacco Use Status");
		ArrayList<Object[]> typeOfTobaccoProducts = personalHabitTypeRepo.getPersonalHabitTypeMaster("Type of Tobacco Use");
		ArrayList<Object[]> alcoholUseStatus = personalHabitTypeRepo.getPersonalHabitTypeMaster("Alcohol Intake Status");
		ArrayList<Object[]> typeOfAlcoholProducts = personalHabitTypeRepo.getPersonalHabitTypeMaster("Type of Alcohol");
		ArrayList<Object[]> frequencyOfAlcoholIntake = personalHabitTypeRepo.getPersonalHabitTypeMaster("Frequency of Alcohol Intake");
		ArrayList<Object[]> quantityOfAlcoholIntake = personalHabitTypeRepo.getPersonalHabitTypeMaster("Average Quantity of Alcohol consumption");
		ArrayList<Object[]> familyMemberTypes = familyMemberMasterRepo.getFamilyMemberTypeMaster();
		ArrayList<Object[]> labTests = labTestMasterRepo.getLabTestMaster();
	
		resMap.put("AllergicReactionTypes", AllergicReactionTypes.getAllergicReactionTypes(allergicReactionTypes));
		resMap.put("bloodGroups", BloodGroups.getBloodGroups(bloodGroups));
		resMap.put("childVaccinations", ChildVaccinations.getChildVaccinations(childVaccinations));
		resMap.put("deliveryPlaces", DeliveryPlace.getDeliveryPlace(deliveryPlace));
		resMap.put("deliveryTypes", DeliveryType.getDeliveryType(deliveryType));
		resMap.put("developmentProblems", DevelopmentProblems.getDevelopmentProblems(developmentProblems));
		resMap.put("gestation", Gestation.getGestations(gestation));
		resMap.put("illnessTypes", IllnessTypes.getIllnessTypes(illnessTypes));
		resMap.put("jointTypes", JointTypes.getJointTypes(jointTypes));
		resMap.put("menstrualCycleLengths", MenstrualCycleRange.getMenstrualCycleRanges(menstrualCycleLengths));
		resMap.put("menstrualCycleBloodFlowDuration", MenstrualCycleRange.getMenstrualCycleRanges(menstrualCycleBloodFlowDuration));
		resMap.put("menstrualCycleStatus", MenstrualCycleStatus.getMenstrualCycleStatuses(menstrualCycleStatus));
		resMap.put("menstrualProblem", MenstrualProblem.getMenstrualProblems(menstrualProblem));
		resMap.put("musculoskeletalLateralityTypes", Musculoskeletal.getMusculoskeletals(musculoskeletalLateralityTypes));
		resMap.put("musculoskeletalAbnormalityTypes", Musculoskeletal.getMusculoskeletals(musculoskeletalAbnormalityTypes));
		resMap.put("pregDuration", PregDuration.getPregDurationValues(pregDuration));
		resMap.put("surgeryTypes", SurgeryTypes.getSurgeryTypes(surgeryTypes));
		resMap.put("comorbidConditions", ComorbidCondition.getComorbidConditions(comorbidConditions));
		resMap.put("grossMotorMilestones", GrossMotorMilestone.getGrossMotorMilestone(grossMotorMilestones));
		resMap.put("fundalHeights", FundalHeight.getFundalHeights(fundalHeights));
		resMap.put("feedTypes", CompFeeds.getCompFeeds(feedTypes));
		resMap.put("compFeedAges", CompFeeds.getCompFeeds(compFeedAges));
		resMap.put("compFeedServings", CompFeeds.getCompFeeds(compFeedServings));
		resMap.put("pregOutcomes", PregOutcome.getPregOutcomes(pregOutcomes));
		
		resMap.put("birthComplications", ComplicationTypes.getComplicationTypes(birthComplications));
		resMap.put("deliveryComplicationTypes", ComplicationTypes.getComplicationTypes(deliveryComplicationTypes));
		resMap.put("postpartumComplicationTypes", ComplicationTypes.getComplicationTypes(postpartumComplicationTypes));
		resMap.put("pregComplicationTypes", ComplicationTypes.getComplicationTypes(pregComplicationTypes));
		resMap.put("postNatalComplications", ComplicationTypes.getComplicationTypes(postNatalComplications));
		resMap.put("newBornComplications", ComplicationTypes.getComplicationTypes(birthComplications));
				
		//existing
		resMap.put("chiefComplaintMaster", ChiefComplaintMaster.getChiefComplaintMasters(ccList));
		resMap.put("DiseaseTypes", DiseaseType.getDiseaseTypes(DiseaseTypes));
		resMap.put("tobaccoUseStatus",
				PersonalHabitType.getPersonalHabitTypeMasterData(tobaccoUseStatus));
		resMap.put("typeOfTobaccoProducts",
				PersonalHabitType.getPersonalHabitTypeMasterData(typeOfTobaccoProducts));
		resMap.put("alcoholUseStatus",
				PersonalHabitType.getPersonalHabitTypeMasterData(alcoholUseStatus));
		resMap.put("typeOfAlcoholProducts",
				PersonalHabitType.getPersonalHabitTypeMasterData(typeOfAlcoholProducts));
		resMap.put("frequencyOfAlcoholIntake",
				PersonalHabitType.getPersonalHabitTypeMasterData(frequencyOfAlcoholIntake));
		resMap.put("quantityOfAlcoholIntake",
				PersonalHabitType.getPersonalHabitTypeMasterData(quantityOfAlcoholIntake));
		resMap.put("familyMemberTypes", FamilyMemberType.getFamilyMemberTypeMasterData(familyMemberTypes));
		
		resMap.put("labTests", LabTestMaster.getLabTestMasters(labTests));
		
		return new Gson().toJson(resMap);
	}
	
	
	public String getANCMasterDataForDoctor(int psmID) {
		Map<String, Object> resMap = new HashMap<>();
		ArrayList<Object[]> ccList = chiefComplaintMasterRepo.getChiefComplaintMaster();
		ArrayList<Object[]> ddmList = drugDoseMasterRepo.getDrugDoseMaster();
		ArrayList<Object[]> ddumList = drugDurationUnitMasterRepo.getDrugDurationUnitMaster();
		ArrayList<Object[]> dfmList = drugFormMasterRepo.getDrugFormMaster();
		ArrayList<Object[]> dfrmList = drugFrequencyMasterRepo.getDrugFrequencyMaster();
		ArrayList<Object[]> counsellingTypes = counsellingTypeRepo.getCounsellingTypes();
		ArrayList<Object[]> additionalServices = serviceMasterRepo.getAdditionalServices();
		
		Institute institute = new Institute();
		ArrayList<Object[]> instituteDetails = instituteRepo.getInstituteDetails(psmID);
		
		
		resMap.put("chiefComplaintMaster", ChiefComplaintMaster.getChiefComplaintMasters(ccList));
		resMap.put("drugDoseMaster", DrugDoseMaster.getDrugDoseMasters(ddmList));
		resMap.put("drugDurationUnitMaster", DrugDurationUnitMaster.getDrugDurationUnitMaster(ddumList));
		resMap.put("drugFormMaster", DrugFormMaster.getDrugFormMaster(dfmList));
		resMap.put("drugFrequencyMaster", DrugFrequencyMaster.getDrugFrequencyMaster(dfrmList));
		resMap.put("counsellingTypes", CounsellingType.getCounsellingType(counsellingTypes));
		resMap.put("higherHealthCare", institute.getinstituteDetails(instituteDetails));
		resMap.put("additionalServices", ServiceMaster.getServiceMaster(additionalServices));

		return new Gson().toJson(resMap);
	}

	
	
}
