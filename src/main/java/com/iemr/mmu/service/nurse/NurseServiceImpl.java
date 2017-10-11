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

}
