package com.iemr.mmu.service.masterservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.masterdata.registrar.CommunityMaster;
import com.iemr.mmu.data.masterdata.registrar.GenderMaster;
import com.iemr.mmu.data.masterdata.registrar.GovIdEntityType;
import com.iemr.mmu.data.masterdata.registrar.IncomeStatusMaster;
import com.iemr.mmu.data.masterdata.registrar.MaritalStatusMaster;
import com.iemr.mmu.data.masterdata.registrar.OccupationMaster;
import com.iemr.mmu.data.masterdata.registrar.QualificationMaster;
import com.iemr.mmu.data.masterdata.registrar.ReligionMaster;
import com.iemr.mmu.data.registrar.BeneficiaryData;
import com.iemr.mmu.repo.masterrepo.CommunityMasterRepo;
import com.iemr.mmu.repo.masterrepo.GenderMasterRepo;
import com.iemr.mmu.repo.masterrepo.GovIdEntityTypeRepo;
import com.iemr.mmu.repo.masterrepo.IncomeStatusMasterRepo;
import com.iemr.mmu.repo.masterrepo.MaritalStatusMasterRepo;
import com.iemr.mmu.repo.masterrepo.OccupationMasterRepo;
import com.iemr.mmu.repo.masterrepo.QualificationMasterRepo;
import com.iemr.mmu.repo.masterrepo.ReligionMasterRepo;
import com.iemr.mmu.repo.registrar.BeneficiaryImageRepo;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenData;

@Service
public class RegistrarServiceMasterDataImpl implements RegistrarServiceMasterData {

	private CommunityMasterRepo communityMasterRepo;
	private GenderMasterRepo genderMasterRepo;
	private GovIdEntityTypeRepo govIdEntityTypeRepo;
	private IncomeStatusMasterRepo incomeStatusMasterRepo;
	private MaritalStatusMasterRepo maritalStatusMasterRepo;
	private OccupationMasterRepo occupationMasterRepo;
	private QualificationMasterRepo qualificationMasterRepo;
	private ReligionMasterRepo religionMasterRepo;
	private RegistrarRepoBenData registrarRepoBenData;
	private BeneficiaryImageRepo beneficiaryImageRepo;

	@Autowired
	public void setBeneficiaryImageRepo(BeneficiaryImageRepo beneficiaryImageRepo) {
		this.beneficiaryImageRepo = beneficiaryImageRepo;
	}

	@Autowired
	public void setCommunityMasterRepo(CommunityMasterRepo communityMasterRepo) {
		this.communityMasterRepo = communityMasterRepo;
	}

	@Autowired
	public void setGenderMasterRepo(GenderMasterRepo genderMasterRepo) {
		this.genderMasterRepo = genderMasterRepo;
	}

	@Autowired
	public void setGovIdEntityTypeRepo(GovIdEntityTypeRepo govIdEntityTypeRepo) {
		this.govIdEntityTypeRepo = govIdEntityTypeRepo;
	}

	@Autowired
	public void setIncomeStatusMasterRepo(IncomeStatusMasterRepo incomeStatusMasterRepo) {
		this.incomeStatusMasterRepo = incomeStatusMasterRepo;
	}

	@Autowired
	public void setMaritalStatusMasterRepo(MaritalStatusMasterRepo maritalStatusMasterRepo) {
		this.maritalStatusMasterRepo = maritalStatusMasterRepo;
	}

	@Autowired
	public void setOccupationMasterRepo(OccupationMasterRepo occupationMasterRepo) {
		this.occupationMasterRepo = occupationMasterRepo;
	}

	@Autowired
	public void setQualificationMasterRepo(QualificationMasterRepo qualificationMasterRepo) {
		this.qualificationMasterRepo = qualificationMasterRepo;
	}

	@Autowired
	public void setReligionMasterRepo(ReligionMasterRepo religionMasterRepo) {
		this.religionMasterRepo = religionMasterRepo;
	}

	@Autowired
	public void setRegistrarRepoBenData(RegistrarRepoBenData registrarRepoBenData) {
		this.registrarRepoBenData = registrarRepoBenData;
	}

	public String getRegMasterData() {
		Map<String, Object> resMap = new HashMap<String, Object>();
		ArrayList<Object[]> cm = communityMasterRepo.getCommunityMaster();
		ArrayList<Object[]> gm = genderMasterRepo.getGenderMaster();
		ArrayList<Object[]> gietm = govIdEntityTypeRepo.getGovIdEntityMaster();
		ArrayList<Object[]> ogietm = govIdEntityTypeRepo.getOtherGovIdEntityMaster();
		ArrayList<Object[]> ism = incomeStatusMasterRepo.getIncomeStatusMaster();
		ArrayList<Object[]> msm = maritalStatusMasterRepo.getMaritalStatusMaster();
		ArrayList<Object[]> om = occupationMasterRepo.getOccupationMaster();
		ArrayList<Object[]> qm = qualificationMasterRepo.getQualificationMaster();
		ArrayList<Object[]> rm = religionMasterRepo.getReligionMaster();

		System.out.println("hello....");
		try {
			resMap.put("communityMaster", CommunityMaster.getCommunityMasterData(cm));
			resMap.put("genderMaster", GenderMaster.getGenderMasterData(gm));
			resMap.put("govIdEntityMaster", GovIdEntityType.getGovIdEntityTypeData(gietm));
			resMap.put("otherGovIdEntityMaster", GovIdEntityType.getGovIdEntityTypeData(ogietm));
			resMap.put("incomeMaster", IncomeStatusMaster.getIncomeStatusMasterData(ism));
			resMap.put("maritalStatusMaster", MaritalStatusMaster.getMaritalStatusMasterData(msm));
			resMap.put("occupationMaster", OccupationMaster.getOccupationMasterData(om));
			resMap.put("qualificationMaster", QualificationMaster.getQualificationMasterData(qm));
			resMap.put("religionMaster", ReligionMaster.getReligionMasterData(rm));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("helloo");
		System.out.println(new Gson().toJson(resMap));
		return new Gson().toJson(resMap);

	}

	@Override
	public String getBenDetailsByRegID(Long beneficiaryRegID) {
		List<Object[]> benDetailsList = registrarRepoBenData.getBenDetailsByRegID(beneficiaryRegID);
		BeneficiaryData benDetails = BeneficiaryData.getBeneficiaryData(benDetailsList).get(0);
		//String benImage = beneficiaryImageRepo.getBenImage(beneficiaryRegID);
		benDetails.setImage(beneficiaryImageRepo.getBenImage(beneficiaryRegID));
		if (benDetails != null) {
			if (benDetails.getGenderID() != null) {
				if (benDetails.getGenderID() == 1) {
					benDetails.setGenderName("Male");
				} else if (benDetails.getGenderID() == 2) {
					benDetails.setGenderName("Female");
				} else {
					if (benDetails.getGenderID() == 3) {
						benDetails.setGenderName("Transgender");
					}
				}
			}
		}
		return new Gson().toJson(benDetails);
	}

}
