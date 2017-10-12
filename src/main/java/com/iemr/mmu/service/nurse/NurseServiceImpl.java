package com.iemr.mmu.service.nurse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.iemr.mmu.data.masterdata.nurse.CancerDiseaseType;
import com.iemr.mmu.data.masterdata.nurse.CancerPersonalHabitType;
import com.iemr.mmu.data.masterdata.nurse.FamilyMemberType;
import com.iemr.mmu.data.masterdata.nurse.VisitCategory;
import com.iemr.mmu.data.masterdata.nurse.VisitReason;
import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.repo.masterrepo.nurse.CancerDiseaseMasterRepo;
import com.iemr.mmu.repo.masterrepo.nurse.CancerPersonalHabitMasterRepo;
import com.iemr.mmu.repo.masterrepo.nurse.FamilyMemberMasterRepo;
import com.iemr.mmu.repo.masterrepo.nurse.VisitCategoryMasterRepo;
import com.iemr.mmu.repo.masterrepo.nurse.VisitReasonMasterRepo;
import com.iemr.mmu.repo.nurse.BenCancerVitalDetailRepo;
import com.iemr.mmu.repo.nurse.BenFamilyCancerHistoryRepo;
import com.iemr.mmu.repo.nurse.BenObstetricCancerHistoryRepo;
import com.iemr.mmu.repo.nurse.BenPersonalCancerDietHistoryRepo;
import com.iemr.mmu.repo.nurse.BenPersonalCancerHistoryRepo;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;

@Service
public class NurseServiceImpl implements NurseService {

	private BenFamilyCancerHistoryRepo benFamilyCancerHistoryRepo;
	private BenObstetricCancerHistoryRepo benObstetricCancerHistoryRepo;
	private BenVisitDetailRepo benVisitDetailRepo;
	private BenPersonalCancerDietHistoryRepo benPersonalCancerDietHistoryRepo;
	private BenPersonalCancerHistoryRepo benPersonalCancerHistoryRepo;
	private BenCancerVitalDetailRepo benCancerVitalDetailRepo;

	@Autowired
	private CancerDiseaseMasterRepo cancerDiseaseMasterRepo;

	@Autowired
	private CancerPersonalHabitMasterRepo cancerPersonalHabitMasterRepo;

	@Autowired
	private FamilyMemberMasterRepo familyMemberMasterRepo;

	@Autowired
	private VisitCategoryMasterRepo visitCategoryMasterRepo;

	@Autowired
	private VisitReasonMasterRepo visitReasonMasterRepo;

	@Autowired
	public void setBenFamilyCancerHistoryRepo(BenFamilyCancerHistoryRepo benFamilyCancerHistoryRepo) {
		this.benFamilyCancerHistoryRepo = benFamilyCancerHistoryRepo;
	}

	@Autowired
	public void setBenObstetricCancerHistoryRepo(BenObstetricCancerHistoryRepo benObstetricCancerHistoryRepo) {
		this.benObstetricCancerHistoryRepo = benObstetricCancerHistoryRepo;
	}

	@Autowired
	public void setBenVisitDetailRepo(BenVisitDetailRepo benVisitDetailRepo) {
		this.benVisitDetailRepo = benVisitDetailRepo;
	}

	@Autowired
	public void setBenPersonalCancerDietHistoryRepo(BenPersonalCancerDietHistoryRepo benPersonalCancerDietHistoryRepo) {
		this.benPersonalCancerDietHistoryRepo = benPersonalCancerDietHistoryRepo;
	}

	@Autowired
	public void BenPersonalCancerHistoryRepo(BenPersonalCancerHistoryRepo benPersonalCancerHistoryRepo) {
		this.benPersonalCancerHistoryRepo = benPersonalCancerHistoryRepo;
	}

	@Autowired
	public void BenCancerVitalDetailRepo(BenCancerVitalDetailRepo benCancerVitalDetailRepo) {
		this.benCancerVitalDetailRepo = benCancerVitalDetailRepo;
	}

	@Override
	public String savePatientVisitDetails() {
		BenFamilyCancerHistory obj = new BenFamilyCancerHistory();
		BenObstetricCancerHistory obj1 = new BenObstetricCancerHistory();
		obj.setCreatedBy("neeraj");
		obj1.setCreatedBy("neeraj");

		System.out.println("helloooo");
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/nurse/testrest1", obj,
				String.class);
		System.out.println("helloooo");
		ResponseEntity<String> response1 = restTemplate.postForEntity("http://localhost:8080/nurse/testrest2", obj1,
				String.class);
		System.out.println("helloooo");

		return "hii";
	}

	@Override
	public Long saveBeneficiaryVisitDetails(BeneficiaryVisitDetail beneficiaryVisitDetail) {
		BeneficiaryVisitDetail response = null;
		try {
			response = benVisitDetailRepo.save(beneficiaryVisitDetail);

		} catch (Exception e) {
			e.printStackTrace();

		}
		if (response != null)
			return response.getBenVisitID();
		else
			return null;

	}

	@Override
	public int saveBenFamilyCancerHistory(List<BenFamilyCancerHistory> benFamilyCancerHistoryList) {
		for (BenFamilyCancerHistory benFamilyCancerHistoryOBJ : benFamilyCancerHistoryList) {
			List<String> familyMenberList = benFamilyCancerHistoryOBJ.getFamilyMemberList();
			String familyMemberData = "";
			if (familyMenberList != null && familyMenberList.size() > 0) {
				for (String familyMember : familyMenberList) {
					familyMemberData += familyMember + ",";
				}
			}
			benFamilyCancerHistoryOBJ.setFamilyMember(familyMemberData);
			System.out.println("hello...");
		}
		int responseData = 0;
		List<BenFamilyCancerHistory> response = (List<BenFamilyCancerHistory>) benFamilyCancerHistoryRepo
				.save(benFamilyCancerHistoryList);
		for (BenFamilyCancerHistory obj : response) {
			if (obj.getID() > 0)
				responseData = 1;
		}
		return responseData;
	}

	@Override
	public Long saveBenObstetricCancerHistory(BenObstetricCancerHistory benObstetricCancerHistory) {
		BenObstetricCancerHistory response = benObstetricCancerHistoryRepo.save(benObstetricCancerHistory);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Override
	public Long saveBenPersonalCancerDietHistory(BenPersonalCancerDietHistory benPersonalCancerDietHistory) {
		List<String> personalOilConsumedList = benPersonalCancerDietHistory.getTypeOfOilConsumedList();
		String oilConsumedData = "";
		if (personalOilConsumedList != null && personalOilConsumedList.size() > 0) {
			for (String s : personalOilConsumedList) {
				oilConsumedData += s + ",";
			}
		}
		benPersonalCancerDietHistory.setTypeOfOilConsumed(oilConsumedData);
		BenPersonalCancerDietHistory response = benPersonalCancerDietHistoryRepo.save(benPersonalCancerDietHistory);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Override
	public Long saveBenPersonalCancerHistory(BenPersonalCancerHistory benPersonalCancerHistory) {
		List<String> typeOfTobaccoProductUseList = benPersonalCancerHistory.getTypeOfTobaccoProductList();
		String typeOfTobaccoProductUseConcat = "";
		if (typeOfTobaccoProductUseList != null && typeOfTobaccoProductUseList.size() > 0) {
			for (String s : typeOfTobaccoProductUseList) {
				typeOfTobaccoProductUseConcat += s + ",";
			}
		}
		benPersonalCancerHistory.setTypeOfTobaccoProduct(typeOfTobaccoProductUseConcat);
		BenPersonalCancerHistory response = benPersonalCancerHistoryRepo.save(benPersonalCancerHistory);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Override
	public Long saveBenVitalDetail(BenCancerVitalDetail benCancerVitalDetail) {
		BenCancerVitalDetail response = benCancerVitalDetailRepo.save(benCancerVitalDetail);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	public String getNurseMasterData() {
		Map<String, Object> resMap = new HashMap<String, Object>();
		ArrayList<Object[]> DiseaseTypes = cancerDiseaseMasterRepo.getCancerDiseaseMaster();
		ArrayList<Object[]> tobaccoUseStatus = cancerPersonalHabitMasterRepo
				.getCancerPersonalHabitTypeMaster("Tobacco Use Status");
		ArrayList<Object[]> alcoholUseStatus = cancerPersonalHabitMasterRepo
				.getCancerPersonalHabitTypeMaster("Alcohol Usage");
		ArrayList<Object[]> dietTypes = cancerPersonalHabitMasterRepo.getCancerPersonalHabitTypeMaster("Dietary Type ");
		ArrayList<Object[]> oilConsumed = cancerPersonalHabitMasterRepo
				.getCancerPersonalHabitTypeMaster("Oil Consumed");
		ArrayList<Object[]> physicalActivityType = cancerPersonalHabitMasterRepo
				.getCancerPersonalHabitTypeMaster("Physical Activity Type ");

		ArrayList<Object[]> familyMemberTypes = familyMemberMasterRepo.getFamilyMemberTypeMaster();
		ArrayList<Object[]> visitCategories = visitCategoryMasterRepo.getVisitCategoryMaster();
		ArrayList<Object[]> visitReasons = visitReasonMasterRepo.getVisitReasonMaster();

		try {
			resMap.put("CancerDiseaseType", CancerDiseaseType.getCancerDiseaseTypeMasterData(DiseaseTypes));
			resMap.put("tobaccoUseStatus",
					CancerPersonalHabitType.getCancerPersonalHabitTypeMasterData(tobaccoUseStatus));
			resMap.put("alcoholUseStatus",
					CancerPersonalHabitType.getCancerPersonalHabitTypeMasterData(alcoholUseStatus));
			resMap.put("dietTypes", CancerPersonalHabitType.getCancerPersonalHabitTypeMasterData(dietTypes));
			resMap.put("oilConsumed", CancerPersonalHabitType.getCancerPersonalHabitTypeMasterData(oilConsumed));
			resMap.put("physicalActivityType",
					CancerPersonalHabitType.getCancerPersonalHabitTypeMasterData(physicalActivityType));

			resMap.put("familyMemberTypes", FamilyMemberType.getFamilyMemberTypeMasterData(familyMemberTypes));
			resMap.put("visitCategories", VisitCategory.getVisitCategoryMasterData(visitCategories));
			resMap.put("visitReasons", VisitReason.getVisitReasonMasterData(visitReasons));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(new Gson().toJson(resMap));
		return new Gson().toJson(resMap);

	}

	@Override
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

	@Override
	public int updateBeneficiaryFamilyCancerHistory(List<BenFamilyCancerHistory> benFamilyCancerHistoryList) {
		int response = 0;
		try {
			for (BenFamilyCancerHistory benFamilyCancerHistory : benFamilyCancerHistoryList) {
				List<String> familyMenberList = benFamilyCancerHistory.getFamilyMemberList();
				String familyMemberData = "";
				for (String familyMember : familyMenberList) {
					familyMemberData += familyMember + ",";
				}
				benFamilyCancerHistory.setFamilyMember(familyMemberData);
				response = benFamilyCancerHistoryRepo.updateBenFamilyCancerHistory(
						benFamilyCancerHistory.getCancerDiseaseType(), benFamilyCancerHistory.getFamilyMember(),
						benFamilyCancerHistory.getModifiedBy(), benFamilyCancerHistory.getID());
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}

	@Override
	public int updateBenObstetricCancerHistory(BenObstetricCancerHistory benObstetricCancerHistory) {
		int response = 0;
		try {

			response = benObstetricCancerHistoryRepo.updateBenObstetricCancerHistory(
					benObstetricCancerHistory.getPregnancyStatus(), benObstetricCancerHistory.getIsUrinePregTest(),
					benObstetricCancerHistory.getPregnant_No(), benObstetricCancerHistory.getNoOfLivingChild(),
					benObstetricCancerHistory.getIsAbortion(), benObstetricCancerHistory.getIsOralContraceptiveUsed(),
					benObstetricCancerHistory.getIsHormoneReplacementTherapy(),
					benObstetricCancerHistory.getMenarche_Age(), benObstetricCancerHistory.getIsMenstrualCycleRegular(),
					benObstetricCancerHistory.getMenstrualCycleLength(),
					benObstetricCancerHistory.getMenstrualFlowDuration(),
					benObstetricCancerHistory.getMenstrualFlowType(), benObstetricCancerHistory.getIsDysmenorrhea(),
					benObstetricCancerHistory.getIsInterMenstrualBleeding(),
					benObstetricCancerHistory.getMenopauseAge(), benObstetricCancerHistory.getIsPostMenopauseBleeding(),
					benObstetricCancerHistory.getIsFoulSmellingDischarge(), benObstetricCancerHistory.getModifiedBy(),
					benObstetricCancerHistory.getID());

		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}

	@Override
	public int updateBenPersonalCancerHistory(BenPersonalCancerHistory benPersonalCancerHistory) {
		int response = 0;
		try {

			List<String> typeOfTobaccoProductList = benPersonalCancerHistory.getTypeOfTobaccoProductList();
			String typeOfTobaccoProductData = "";
			for (String typeOfTobaccoProduct : typeOfTobaccoProductList) {
				typeOfTobaccoProductData += typeOfTobaccoProduct + ",";
			}
			benPersonalCancerHistory.setTypeOfTobaccoProduct(typeOfTobaccoProductData);

			response = benPersonalCancerHistoryRepo.updateBenPersonalCancerHistory(
					benPersonalCancerHistory.getTobaccoUse(), benPersonalCancerHistory.getStartAge_year(),
					benPersonalCancerHistory.getEndAge_year(), benPersonalCancerHistory.getTypeOfTobaccoProduct(),
					benPersonalCancerHistory.getQuantityPerDay(), benPersonalCancerHistory.getIsFilteredCigaerette(),
					benPersonalCancerHistory.getIsCigaretteExposure(), benPersonalCancerHistory.getIsBetelNutChewing(),
					benPersonalCancerHistory.getDurationOfBetelQuid(), benPersonalCancerHistory.getAlcoholUse(),
					benPersonalCancerHistory.getSsAlcoholUsed(), benPersonalCancerHistory.getFrequencyOfAlcoholUsed(),
					benPersonalCancerHistory.getModifiedBy(), benPersonalCancerHistory.getID());

		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}

	@Override
	public int updateBenPersonalCancerDietHistory(BenPersonalCancerDietHistory benPersonalCancerDietHistory) {
		int response = 0;
		try {
			List<String> typeOfOilConsumedList = benPersonalCancerDietHistory.getTypeOfOilConsumedList();
			String typeOfOilConsumedData = "";
			for (String typeOfOilConsumed : typeOfOilConsumedList) {
				typeOfOilConsumedData += typeOfOilConsumed + ",";
			}
			benPersonalCancerDietHistory.setTypeOfOilConsumed(typeOfOilConsumedData);

			response = benPersonalCancerDietHistoryRepo.updateBenPersonalCancerDietHistory(
					benPersonalCancerDietHistory.getDietType(), benPersonalCancerDietHistory.getFruitConsumptionDays(),
					benPersonalCancerDietHistory.getFruitQuantityPerDay(),
					benPersonalCancerDietHistory.getVegetableConsumptionDays(),
					benPersonalCancerDietHistory.getVegetableQuantityPerDay(),
					benPersonalCancerDietHistory.getIntakeOfOutsidePreparedMeal(),
					benPersonalCancerDietHistory.getTypeOfOilConsumed(),
					benPersonalCancerDietHistory.getPhysicalActivityType(),
					benPersonalCancerDietHistory.getSsRadiationExposure(),
					benPersonalCancerDietHistory.getIsThyroidDisorder(), benPersonalCancerDietHistory.getModifiedBy(),
					benPersonalCancerDietHistory.getID());

		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}

	@Override
	public int updateBenVitalDetail(BenCancerVitalDetail benCancerVitalDetail) {
		int response = benCancerVitalDetailRepo.updateBenCancerVitalDetail(benCancerVitalDetail.getWeight_Kg(),
				benCancerVitalDetail.getHeight_cm(), benCancerVitalDetail.getWaistCircumference_cm(),
				benCancerVitalDetail.getBloodGlucose_Fasting(), benCancerVitalDetail.getBloodGlucose_Random(),
				benCancerVitalDetail.getBloodGlucose_2HrPostPrandial(), benCancerVitalDetail.getSystolicBP_1stReading(),
				benCancerVitalDetail.getDiastolicBP_1stReading(), benCancerVitalDetail.getSystolicBP_2ndReading(),
				benCancerVitalDetail.getDiastolicBP_2ndReading(), benCancerVitalDetail.getSystolicBP_3rdReading(),
				benCancerVitalDetail.getDiastolicBP_3rdReading(), benCancerVitalDetail.getHbA1C(),
				benCancerVitalDetail.getHemoglobin(), benCancerVitalDetail.getModifiedBy(),
				benCancerVitalDetail.getID());
		return response;
	}

	public String getBenDataFrmNurseToDocVisitDetailsScreen(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();
		BeneficiaryVisitDetail benVisitDetailsOBJ = benVisitDetailRepo.getVisitDetails(benRegID, benVisitID);

		BeneficiaryVisitDetail benVisitDetailsOBJ1 = new BeneficiaryVisitDetail(benVisitDetailsOBJ.getBenVisitID(),
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

		resMap.put("benVisitDetails", benVisitDetailsOBJ1);

		return new Gson().toJson(resMap);
	}

	public String getBenDataFrmNurseToDocHistoryScreen(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();

		resMap.put("benFamilyHistory", getBenFamilyHisData(benRegID, benVisitID));

		resMap.put("benObstetricHistory", getBenObstetricDetailsData(benRegID, benVisitID));

		resMap.put("benPersonalHistory", getBenPersonalCancerHistoryData(benRegID, benVisitID));

		resMap.put("benPersonalDietHistory", getBenPersonalCancerDietHistoryData(benRegID, benVisitID));

		return new Gson().toJson(resMap);
	}

	private BenPersonalCancerHistory getBenPersonalCancerHistoryData(Long benRegID, Long benVisitID) {
		BenPersonalCancerHistory benPersonalCancerHistory = benPersonalCancerHistoryRepo.getBenPersonalHistory(benRegID,
				benVisitID);
		return benPersonalCancerHistory;
	}

	private BenPersonalCancerDietHistory getBenPersonalCancerDietHistoryData(Long benRegID, Long benVisitID) {
		BenPersonalCancerDietHistory benPersonalCancerDietHistory = benPersonalCancerDietHistoryRepo
				.getBenPersonaDietHistory(benRegID, benVisitID);

		String s = benPersonalCancerDietHistory.getTypeOfOilConsumed();
		List<String> oilConsumedList = new ArrayList<>();
		if (s != null) {
			String[] arr = s.split(",");
			for (int i = 0; i < arr.length; i++) {
				oilConsumedList.add(arr[i]);
			}
			benPersonalCancerDietHistory.setTypeOfOilConsumedList(oilConsumedList);

		}
		return benPersonalCancerDietHistory;
	}

	private List<BenFamilyCancerHistory> getBenFamilyHisData(Long benRegID, Long benVisitID) {
		List<BenFamilyCancerHistory> benFamilyCancerHistoryList = benFamilyCancerHistoryRepo
				.getBenFamilyHistory(benRegID, benVisitID);
		if (benFamilyCancerHistoryList.size() > 0) {
			for (BenFamilyCancerHistory obj : benFamilyCancerHistoryList) {
				String s = obj.getFamilyMember();
				List<String> famMemlist = new ArrayList<>();
				if (s != null) {
					String[] arr = s.split(",");
					for (int i = 0; i < arr.length; i++) {
						famMemlist.add(arr[i]);
					}
				}
				obj.setFamilyMemberList(famMemlist);
				System.out.println("hello");
			}
		}

		return benFamilyCancerHistoryList;
	}

	private BenObstetricCancerHistory getBenObstetricDetailsData(Long benRegID, Long benVisitID) {
		BenObstetricCancerHistory benObstetricCancerHistoryData = benObstetricCancerHistoryRepo
				.getBenObstetricCancerHistory(benRegID, benVisitID);
		return benObstetricCancerHistoryData;
	}

	public String getBenDataFrmNurseToDocVitalScreen(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("benVitalDetails", getBenCancerVitalDetailData(benRegID, benVisitID));
		return new Gson().toJson(resMap);
	}

	private BenCancerVitalDetail getBenCancerVitalDetailData(Long benRegID, Long benVisitID) {
		BenCancerVitalDetail benCancerVitalDetail = benCancerVitalDetailRepo.getBenCancerVitalDetail(benRegID,
				benVisitID);
		return benCancerVitalDetail;
	}

}
