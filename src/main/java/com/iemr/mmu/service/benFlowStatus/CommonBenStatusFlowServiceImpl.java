package com.iemr.mmu.service.benFlowStatus;

import java.sql.Date;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;
import com.iemr.mmu.utils.mapper.InputMapper;

/***
 * 
 * @author NE298657
 *
 */
@Service
public class CommonBenStatusFlowServiceImpl implements CommonBenStatusFlowService {
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;
	private BenVisitDetailRepo benVisitDetailRepo;

	@Autowired
	public void setBenVisitDetailRepo(BenVisitDetailRepo benVisitDetailRepo) {
		this.benVisitDetailRepo = benVisitDetailRepo;
	}

	@Autowired
	public void setBeneficiaryFlowStatusRepo(BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo) {
		this.beneficiaryFlowStatusRepo = beneficiaryFlowStatusRepo;
	}

	public int createBenFlowRecord(String requestOBJ, Long beneficiaryRegID, Long beneficiaryID) {
		BeneficiaryFlowStatus objRS = null;
		int returnOBJ = 0;
		try {
			BeneficiaryFlowStatus obj = getBenFlowRecordObj(requestOBJ, beneficiaryRegID, beneficiaryID);

			if (beneficiaryRegID != null && beneficiaryID != null && beneficiaryRegID > 0 && beneficiaryID > 0) {
				objRS = beneficiaryFlowStatusRepo.save(obj);
				if (objRS != null)
					returnOBJ = 1;
				else
					returnOBJ = 0;
			} else {
				ArrayList<Long> benFlowIDList = beneficiaryFlowStatusRepo
						.checkBenAlreadyInNurseWorkList(obj.getBeneficiaryRegID());
				if (benFlowIDList != null && benFlowIDList.size() > 0) {
					returnOBJ = 3;
				} else {
					objRS = beneficiaryFlowStatusRepo.save(obj);
					if (objRS != null)
						returnOBJ = 1;
					else
						returnOBJ = 0;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnOBJ;
	}

	public int updateBenFlowNurseAfterNurseActivity(Long benFlowID, Long benRegID, Long benVisitID, String visitReason,
			String visitCategory, Short nurseFlag, Short docFlag, Short labIteration) {
		int i = 0;
		try {
			i = beneficiaryFlowStatusRepo.updateBenFlowStatusAfterNurseActivity(benFlowID, benRegID, benVisitID,
					visitReason, visitCategory, nurseFlag, docFlag, labIteration);
			System.out.println("hello");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private BeneficiaryFlowStatus getBenFlowRecordObj(String requestOBJ, Long beneficiaryRegID, Long beneficiaryID)
			throws Exception {

		BeneficiaryFlowStatus obj = InputMapper.gson().fromJson(requestOBJ, BeneficiaryFlowStatus.class);
		if (obj.getI_bendemographics().getDistrictName() != null)
			obj.setDistrictName(obj.getI_bendemographics().getDistrictName());
		if (obj.getI_bendemographics().getDistrictBranchName() != null)
			obj.setVillageName(obj.getI_bendemographics().getDistrictBranchName());
		if (beneficiaryRegID != null && obj.getBeneficiaryRegID() == null)
			obj.setBeneficiaryRegID(beneficiaryRegID);
		if (beneficiaryID != null && obj.getBeneficiaryID() == null)
			obj.setBeneficiaryID(beneficiaryID);

		if (obj.getBenPhoneMaps() != null && obj.getBenPhoneMaps().size() > 0
				&& obj.getBenPhoneMaps().get(0).getPhoneNo() != null)
			obj.setPreferredPhoneNum(obj.getBenPhoneMaps().get(0).getPhoneNo());

		if (obj.getGenderID() == null)
			obj.setGenderID(obj.getM_gender().getGenderID());

		if (obj.getGenderName() == null)
			obj.setGenderName(obj.getM_gender().getGenderName());

		String ageDetails = "";
		int age_val = 0;
		if (obj.getdOB() != null) {

			Date date = new Date(obj.getdOB().getTime());
			Calendar cal = Calendar.getInstance();

			cal.setTime(date);

			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);

			java.time.LocalDate todayDate = java.time.LocalDate.now();
			java.time.LocalDate birthdate = java.time.LocalDate.of(year, month, day);
			Period p = Period.between(birthdate, todayDate);

			int d = p.getDays();
			int m = p.getMonths();
			int y = p.getYears();
			// System.out.println("helloo...");

			if (y > 0) {
				ageDetails = y + " years - " + m + " months";
				age_val = y;
			} else {
				if (m > 0) {
					ageDetails = m + " months - " + d + " days";
				} else {
					ageDetails = d + " days";
				}
			}

		}

		obj.setAge(ageDetails);
		obj.setBen_age_val(age_val);

		if (obj.getLastName() != null)
			obj.setBenName(obj.getFirstName() + " " + obj.getLastName());
		else
			obj.setBenName(obj.getFirstName());

		Short benVisitCount = benVisitDetailRepo.getVisitCountForBeneficiary(obj.getBeneficiaryRegID());

		if (benVisitCount != null && benVisitCount >= 0) {
			benVisitCount = (short) (benVisitCount + 1);
		} else {
			benVisitCount = 1;
		}
		obj.setBenVisitNo(benVisitCount);
		obj.setNurseFlag((short) 1);
		obj.setDoctorFlag((short) 0);
		obj.setPharmacist_flag((short) 0);
		obj.setAgentId(obj.getCreatedBy());
		return obj;
	}

}
