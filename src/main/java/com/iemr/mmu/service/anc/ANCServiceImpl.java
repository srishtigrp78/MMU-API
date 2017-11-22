package com.iemr.mmu.service.anc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.data.anc.ANCCareDetails;
import com.iemr.mmu.data.anc.ANCWomenVaccineDetail;
import com.iemr.mmu.data.anc.BenAdherence;
import com.iemr.mmu.repo.nurse.anc.ANCCareRepo;
import com.iemr.mmu.repo.nurse.anc.ANCWomenVaccineRepo;
import com.iemr.mmu.repo.nurse.anc.BenAdherenceRepo;

@Service
public class ANCServiceImpl implements ANCService {

	private ANCCareRepo ancCareRepo;
	private ANCWomenVaccineRepo ancWomenVaccineRepo;
	private BenAdherenceRepo benAdherenceRepo;

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
	public void saveBenChiefComplaints() {
	}

	@Override
	public void saveBenInvestigation() {
	}

}
