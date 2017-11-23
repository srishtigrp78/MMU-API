package com.iemr.mmu.service.anc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.data.anc.ANCCareDetails;
import com.iemr.mmu.data.anc.ANCWomenVaccineDetail;
import com.iemr.mmu.data.anc.BenAdherence;
import com.iemr.mmu.data.anc.WrapperAncImmunization;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.repo.nurse.anc.ANCCareRepo;
import com.iemr.mmu.repo.nurse.anc.ANCWomenVaccineRepo;
import com.iemr.mmu.repo.nurse.anc.BenAdherenceRepo;
import com.iemr.mmu.repo.quickConsultation.BenChiefComplaintRepo;

@Service
public class ANCServiceImpl implements ANCService {

	private ANCCareRepo ancCareRepo;
	private ANCWomenVaccineRepo ancWomenVaccineRepo;
	private BenAdherenceRepo benAdherenceRepo;
	private BenChiefComplaintRepo benChiefComplaintRepo;

	@Autowired
	public void setBenChiefComplaintRepo(BenChiefComplaintRepo benChiefComplaintRepo) {
		this.benChiefComplaintRepo = benChiefComplaintRepo;
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

	@Override
	public void saveBenInvestigation() {
	}

	@Override
	public int saveBenAncCareDetails(ANCCareDetails ancCareDetailsOBJ) {
		int r = 0;
		ANCCareDetails ancCareDetailsRS = ancCareRepo.save(ancCareDetailsOBJ);
		if (ancCareDetailsRS != null) {
			r = 1;
		}
		return r;
	}

	@Override
	public int saveAncImmunizationDetails(WrapperAncImmunization wrapperAncImmunizationOBJ) {
		int r = 0;
		List<ANCWomenVaccineDetail> ancWomenVaccineDetailList = getANCWomenVaccineDetail(wrapperAncImmunizationOBJ);
		List<ANCWomenVaccineDetail> ancWomenVaccineDetailRSList = (List<ANCWomenVaccineDetail>) ancWomenVaccineRepo
				.save(ancWomenVaccineDetailList);
		if (ancWomenVaccineDetailRSList != null && ancWomenVaccineDetailRSList.size() > 0)
			r = 1;
		return r;
	}

	private List<ANCWomenVaccineDetail> getANCWomenVaccineDetail(WrapperAncImmunization wrapperAncImmunizationOBJ) {
		List<ANCWomenVaccineDetail> ancWomenVaccineDetailList = new ArrayList<ANCWomenVaccineDetail>();
		ANCWomenVaccineDetail ancWomenVaccineDetail;
		if (wrapperAncImmunizationOBJ != null) {
			if (wrapperAncImmunizationOBJ.gettT_1Status() != null) {
				ancWomenVaccineDetail = new ANCWomenVaccineDetail();
				ancWomenVaccineDetail.setBeneficiaryRegID(wrapperAncImmunizationOBJ.getBeneficiaryRegID());
				ancWomenVaccineDetail.setCreatedBy(wrapperAncImmunizationOBJ.getCreatedBy());
				ancWomenVaccineDetail.setVaccineName("TT-1");
				ancWomenVaccineDetail.setStatus(wrapperAncImmunizationOBJ.gettT_1Status());
				ancWomenVaccineDetail.setReceivedDate(wrapperAncImmunizationOBJ.getDateReceivedForTT_1());
				ancWomenVaccineDetail.setReceivedFacilityName(wrapperAncImmunizationOBJ.getFacilityNameOfTT_1());
				ancWomenVaccineDetailList.add(ancWomenVaccineDetail);
			}
			if (wrapperAncImmunizationOBJ.gettT_2Status() != null) {
				ancWomenVaccineDetail = new ANCWomenVaccineDetail();
				ancWomenVaccineDetail.setBeneficiaryRegID(wrapperAncImmunizationOBJ.getBeneficiaryRegID());
				ancWomenVaccineDetail.setCreatedBy(wrapperAncImmunizationOBJ.getCreatedBy());
				ancWomenVaccineDetail.setVaccineName("TT-2");
				ancWomenVaccineDetail.setStatus(wrapperAncImmunizationOBJ.gettT_2Status());
				ancWomenVaccineDetail.setReceivedDate(wrapperAncImmunizationOBJ.getDateReceivedForTT_2());
				ancWomenVaccineDetail.setReceivedFacilityName(wrapperAncImmunizationOBJ.getFacilityNameOfTT_2());
				ancWomenVaccineDetailList.add(ancWomenVaccineDetail);
			}
			if (wrapperAncImmunizationOBJ.gettT_3Status() != null) {
				ancWomenVaccineDetail = new ANCWomenVaccineDetail();
				ancWomenVaccineDetail.setBeneficiaryRegID(wrapperAncImmunizationOBJ.getBeneficiaryRegID());
				ancWomenVaccineDetail.setCreatedBy(wrapperAncImmunizationOBJ.getCreatedBy());
				ancWomenVaccineDetail.setVaccineName("TT-Booster");
				ancWomenVaccineDetail.setStatus(wrapperAncImmunizationOBJ.gettT_3Status());
				ancWomenVaccineDetail.setReceivedDate(wrapperAncImmunizationOBJ.getDateReceivedForTT_3());
				ancWomenVaccineDetail.setReceivedFacilityName(wrapperAncImmunizationOBJ.getFacilityNameOfTT_3());
				ancWomenVaccineDetailList.add(ancWomenVaccineDetail);
			}
		}
		return ancWomenVaccineDetailList;
	}

}
