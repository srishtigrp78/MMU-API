package com.iemr.mmu.service.registrar;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.registrar.BenGovIdMapping;
import com.iemr.mmu.data.registrar.BeneficiaryData;
import com.iemr.mmu.data.registrar.BeneficiaryDemographicData;
import com.iemr.mmu.data.registrar.BeneficiaryPhoneMapping;
import com.iemr.mmu.data.registrar.V_BenAdvanceSearch;
import com.iemr.mmu.data.registrar.WrapperRegWorklist;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenData;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenDemoData;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenGovIdMapping;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenPhoneMapData;
import com.iemr.mmu.repo.registrar.ReistrarRepoBenSearch;

@Service
public class RegistrarServiceImpl implements RegistrarService {
	private RegistrarRepoBenData registrarRepoBenData;
	private RegistrarRepoBenDemoData registrarRepoBenDemoData;
	private RegistrarRepoBenPhoneMapData registrarRepoBenPhoneMapData;
	private RegistrarRepoBenGovIdMapping registrarRepoBenGovIdMapping;
	private ReistrarRepoBenSearch reistrarRepoBenSearch;

	@Autowired
	public void setRegistrarRepoBenData(RegistrarRepoBenData registrarRepoBenData) {
		this.registrarRepoBenData = registrarRepoBenData;
	}

	@Autowired
	public void setRegistrarRepoBenDemoData(RegistrarRepoBenDemoData registrarRepoBenDemoData) {
		this.registrarRepoBenDemoData = registrarRepoBenDemoData;
	}

	@Autowired
	public void setRegistrarRepoBenPhoneMapData(RegistrarRepoBenPhoneMapData registrarRepoBenPhoneMapData) {
		this.registrarRepoBenPhoneMapData = registrarRepoBenPhoneMapData;
	}

	@Autowired
	public void setRegistrarRepoBenGovIdMapping(RegistrarRepoBenGovIdMapping registrarRepoBenGovIdMapping) {
		this.registrarRepoBenGovIdMapping = registrarRepoBenGovIdMapping;
	}

	@Autowired
	public void setReistrarRepoAdvanceBenSearch(ReistrarRepoBenSearch reistrarRepoBenSearch) {
		this.reistrarRepoBenSearch = reistrarRepoBenSearch;
	}

	@Override
	public BeneficiaryData createBeneficiary(JsonObject benD) {
		Long benRegID = null;
		// Call repository for saving data in
		// Table: i_beneficairy
		// Persistence Class: BeneficiaryData
		BeneficiaryData benData = registrarRepoBenData.save(getBenOBJ(benD));
		return benData;
	}

	@Override
	public Long createBeneficiaryDemographic(JsonObject benD, Long benRegID) {
		Long tmpBenDemoID = null;
		// Call repository for saving data in
		// Table: i_bendemographics
		// Persistence Class: BeneficiaryDemographicData
		BeneficiaryDemographicData benDemoData = registrarRepoBenDemoData.save(getBenDemoOBJ(benD, benRegID));
		if (benDemoData != null) {
			tmpBenDemoID = benDemoData.getBenDemographicsID();
		}
		return tmpBenDemoID;
	}

	@Override
	public Long createBeneficiaryPhoneMapping(JsonObject benD, Long benRegID) {
		Long tmpBenPhonMapID = null;
		// Call repository for saving data in
		// Table: m_benphonemap
		// Persistence Class: BeneficiaryPhoneMapping
		BeneficiaryPhoneMapping benPhoneMap = registrarRepoBenPhoneMapData.save(getBenPhoneOBJ(benD, benRegID));
		if (benPhoneMap != null) {
			tmpBenPhonMapID = benPhoneMap.getBenPhMapID();
		}
		return tmpBenPhonMapID;
	}

	public int createBenGovIdMapping(JsonObject benD, Long benRegID) {
		Long tempBenGovMapID = null;
		// Call repository for saving Data to table m_bengovidmap and
		// Persistence Class = BenGovIdMapping
		System.out.println("hello");
		ArrayList<BenGovIdMapping> benGovIDMap = (ArrayList<BenGovIdMapping>) registrarRepoBenGovIdMapping
				.save(BenGovIdMapping.getBenGovIdMappingOBJList(benD, benRegID));
		System.out.println("hello");
		return benGovIDMap.size();
	}

	@Override
	public String getRegWorkList(int i) {
		// Call repository for fetching data from
		// Table: i_beneficiary, i_bendemographics, m_benphonemap
		// Persistence Class: BeneficiaryData, BeneficiaryDemographicData,
		// ...................BeneficiaryPhoneMapping
		List<Object[]> resList = registrarRepoBenData.getRegistrarWorkList(i);
		System.out.println("helloo.....");
		return WrapperRegWorklist.getRegistrarWorkList(resList);
	}

	@Override
	public String getQuickSearchBenData(String benID) {
		// List<Object[]> resList = registrarRepoBenData.getQuickSearch(benID);
		List<Object[]> resList = reistrarRepoBenSearch.getQuickSearch(benID);
		System.out.println("hello...");
		return WrapperRegWorklist.getRegistrarWorkList(resList);
	}

	public String getAdvanceSearchBenData(V_BenAdvanceSearch v_BenAdvanceSearch) {
		try {
			String benID = "%%";
			String benFirstName = "%%";
			String benLastName = "%%";
			String benGenderID = "%%";
			String fatherName = "%%";
			String phoneNo = "%%";
			String aadharNo = "%%";
			String govIDNo = "%%";
			String districtID = "%%";

			if (null != v_BenAdvanceSearch.getBeneficiaryID()) {
				benID = v_BenAdvanceSearch.getBeneficiaryID();
			}
			if (null != v_BenAdvanceSearch.getFirstName()) {
				benFirstName = v_BenAdvanceSearch.getFirstName();
			}
			if (null != v_BenAdvanceSearch.getLastName()) {
				benLastName = v_BenAdvanceSearch.getLastName();
			}
			if (null != v_BenAdvanceSearch.getGenderID()) {
				benGenderID = v_BenAdvanceSearch.getGenderID() + "";
			}
			if (null != v_BenAdvanceSearch.getFatherName()) {
				fatherName = v_BenAdvanceSearch.getFatherName();
			}
			if (null != v_BenAdvanceSearch.getPhoneNo()) {
				phoneNo = v_BenAdvanceSearch.getPhoneNo();
			}
			if (null != v_BenAdvanceSearch.getAadharNo()) {
				aadharNo = v_BenAdvanceSearch.getAadharNo();
			}
			if (null != v_BenAdvanceSearch.getGovtIdentityNo()) {
				govIDNo = v_BenAdvanceSearch.getGovtIdentityNo();
			}
			if (null != v_BenAdvanceSearch.getDistrictID()) {
				districtID = v_BenAdvanceSearch.getDistrictID() + "";
			}
			System.out.println("helloo");
			/*
			 * reistrarRepoBenSearch.getAdvanceBenSearchList(benID,
			 * benFirstName, benLastName, benGenderID, fatherName, phoneNo,
			 * aadharNo, govIDNo, districtID);
			 */
			ArrayList<Object[]> resList = reistrarRepoBenSearch.getAdvanceBenSearchList("ben1");
			System.out.println("helloo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "helloo";
	}

	public BeneficiaryData getBenOBJ(JsonObject benD) {
		// Initializing BeneficiaryData Class Object...

		BeneficiaryData benData = new BeneficiaryData();
		if (!benD.get("firstName").isJsonNull())
			benData.setFirstName(benD.get("firstName").getAsString());
		if (!benD.get("lastName").isJsonNull())
			benData.setLastName(benD.get("lastName").getAsString());
		if (!benD.get("gender").isJsonNull())
			benData.setGenderID(benD.get("gender").getAsShort());
		if (!benD.get("dob").isJsonNull()) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
			java.util.Date parsedDate;
			try {
				parsedDate = dateFormat.parse(benD.get("dob").getAsString());
				Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
				benData.setDob(timestamp);
				System.out.println("hello");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (!benD.get("maritalStatus").isJsonNull())
			benData.setMaritalStatusID(benD.get("maritalStatus").getAsShort());
		if (!benD.get("createdBy").isJsonNull())
			benData.setCreatedBy(benD.get("createdBy").getAsString());
		if (!benD.get("fatherName").isJsonNull())
			benData.setFatherName(benD.get("fatherName").getAsString());
		if (benD.has("husbandName")) {
			if (!benD.get("husbandName").isJsonNull())
				benData.setSpouseName(benD.get("husbandName").getAsString());
		}
		if (!benD.get("aadharNo").isJsonNull())
			benData.setAadharNo(benD.get("aadharNo").getAsString());
		return benData;
	}

	public BeneficiaryDemographicData getBenDemoOBJ(JsonObject benD, Long benRegID) {
		// Initializing BeneficiaryDemographicData Class Object...
		BeneficiaryDemographicData benDemoData = new BeneficiaryDemographicData();
		benDemoData.setBeneficiaryRegID(benRegID);
		if (!benD.get("countryID").isJsonNull())
			benDemoData.setCountryID(benD.get("countryID").getAsInt());
		if (!benD.get("stateID").isJsonNull())
			benDemoData.setStateID(benD.get("stateID").getAsInt());
		if (!benD.get("districtID").isJsonNull())
			benDemoData.setDistrictID(benD.get("districtID").getAsInt());
		if (!benD.get("areaID").isJsonNull())
			benDemoData.setAreaID(benD.get("areaID").getAsInt());
		if (!benD.get("servicePointID").isJsonNull())
			benDemoData.setServicePointID(benD.get("servicePointID").getAsInt());
		if (!benD.get("villageID").isJsonNull())
			benDemoData.setDistrictBranchID(benD.get("villageID").getAsInt());

		if (!benD.get("createdBy").isJsonNull())
			benDemoData.setCreatedBy(benD.get("createdBy").getAsString());

		if (!benD.get("community").isJsonNull())
			benDemoData.setCommunityID(benD.get("community").getAsShort());
		if (!benD.get("religion").isJsonNull())
			benDemoData.setReligionID(benD.get("religion").getAsShort());
		if (!benD.get("occupation").isJsonNull())
			benDemoData.setOccupationID(benD.get("occupation").getAsShort());
		if (!benD.get("educationQualification").isJsonNull())
			benDemoData.setEducationID(benD.get("educationQualification").getAsShort());
		if (!benD.get("income").isJsonNull())
			benDemoData.setIncomeStatusID(benD.get("income").getAsShort());
		return benDemoData;
	}

	public BeneficiaryPhoneMapping getBenPhoneOBJ(JsonObject benD, Long benRegID) {
		// Initializing BeneficiaryPhoneMapping Class Object...
		BeneficiaryPhoneMapping benPhoneMap = new BeneficiaryPhoneMapping();
		benPhoneMap.setBenificiaryRegID(benRegID);
		if (!benD.get("phoneNo").isJsonNull())
			benPhoneMap.setPhoneNo(benD.get("phoneNo").getAsString());
		if (!benD.get("createdBy").isJsonNull())
			benPhoneMap.setCreatedBy(benD.get("createdBy").getAsString());
		return benPhoneMap;
	}

}
