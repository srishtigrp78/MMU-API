package com.iemr.mmu.service.nurse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
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

	@Autowired
	private BenVisitDetailRepo benVisitDetailRepo;
	
	@Autowired
	private BenPersonalCancerDietHistoryRepo benPersonalCancerDietHistoryRepo;
	
	@Autowired
	private BenPersonalCancerHistoryRepo benPersonalCancerHistoryRepo;
	
	@Autowired
	private BenCancerVitalDetailRepo benCancerVitalDetailRepo;
	
	@Autowired
	public void setBenFamilyCancerHistoryRepo(BenFamilyCancerHistoryRepo benFamilyCancerHistoryRepo) {
		this.benFamilyCancerHistoryRepo = benFamilyCancerHistoryRepo;
	}

	@Autowired
	public void setBenObstetricCancerHistoryRepo(BenObstetricCancerHistoryRepo benObstetricCancerHistoryRepo) {
		this.benObstetricCancerHistoryRepo = benObstetricCancerHistoryRepo;
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
	public BeneficiaryVisitDetail saveBeneficiaryVisitDetails(BeneficiaryVisitDetail beneficiaryVisitDetail) {
		BeneficiaryVisitDetail response = benVisitDetailRepo.save(beneficiaryVisitDetail);
		return response;
	}

	@Override
	public BenFamilyCancerHistory saveBenFamilyCancerHistory(BenFamilyCancerHistory benFamilyCancerHistory) {
		BenFamilyCancerHistory response = benFamilyCancerHistoryRepo.save(benFamilyCancerHistory);
		return response;
	}

	@Override
	public BenObstetricCancerHistory saveBenObstetricCancerHistory(
			BenObstetricCancerHistory benObstetricCancerHistory) {
		BenObstetricCancerHistory response = benObstetricCancerHistoryRepo.save(benObstetricCancerHistory);
		return response;
	}

	@Override
	public BenPersonalCancerDietHistory saveBenPersonalCancerDietHistory(
			BenPersonalCancerDietHistory benPersonalCancerDietHistory) {
		BenPersonalCancerDietHistory response = benPersonalCancerDietHistoryRepo.save(benPersonalCancerDietHistory);
		return response;
	}

	@Override
	public BenPersonalCancerHistory saveBenPersonalCancerHistory(BenPersonalCancerHistory benPersonalCancerHistory) {
		BenPersonalCancerHistory response = benPersonalCancerHistoryRepo.save(benPersonalCancerHistory);
		return response;
	}

	@Override
	public BenCancerVitalDetail saveBenVitalDetail(BenCancerVitalDetail benCancerVitalDetail) {
		BenCancerVitalDetail response = benCancerVitalDetailRepo.save(benCancerVitalDetail);
		return response;
	}
}
