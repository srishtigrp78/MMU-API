package com.iemr.mmu.service.benFlowStatus;

import java.sql.Date;
import java.time.Period;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;

/***
 * 
 * @author NE298657
 *
 */
@Service
public class CommonBenStatusFlowServiceImpl implements CommonBenStatusFlowService {
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;
	private CommonNurseServiceImpl commonNurseServiceImpl;
	private BenVisitDetailRepo benVisitDetailRepo;

	@Autowired
	public void setBenVisitDetailRepo(BenVisitDetailRepo benVisitDetailRepo) {
		this.benVisitDetailRepo = benVisitDetailRepo;
	}

	@Autowired
	public void setCommonNurseServiceImpl(CommonNurseServiceImpl commonNurseServiceImpl) {
		this.commonNurseServiceImpl = commonNurseServiceImpl;
	}

	@Autowired
	public void setBeneficiaryFlowStatusRepo(BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo) {
		this.beneficiaryFlowStatusRepo = beneficiaryFlowStatusRepo;
	}

	public int createBenFlowRecord(String requestOBJ, Long beneficiaryRegID, Long beneficiaryID) throws Exception {
		BeneficiaryFlowStatus obj = getBenFlowRecordObj(requestOBJ, beneficiaryRegID, beneficiaryID);
		BeneficiaryFlowStatus objRS = beneficiaryFlowStatusRepo.save(obj);
		if (objRS != null)
			return 1;
		else
			return 0;
	}

	private BeneficiaryFlowStatus getBenFlowRecordObj(String requestOBJ, Long beneficiaryRegID, Long beneficiaryID)
			throws Exception {

		BeneficiaryFlowStatus obj = InputMapper.gson().fromJson(requestOBJ, BeneficiaryFlowStatus.class);
		obj.setDistrictName(obj.getPermanentAddress().getDistrict());
		obj.setVillageName(obj.getPermanentAddress().getVillage());
		obj.setBeneficiaryRegID(beneficiaryRegID);
		obj.setBeneficiaryID(beneficiaryID);

		String ageDetails = "";
		int age_val = 0;
		if (obj.getDob() != null) {

			Date date = new Date(obj.getDob().getTime());
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

		if (obj.getGenderID() == 1)
			obj.setGenderName("Male");
		else if (obj.getGenderID() == 2)
			obj.setGenderName("Female");
		else
			obj.setGenderName("Transgender");

		if (obj.getLastName() != null)
			obj.setBenName(obj.getFirstName() + " " + obj.getLastName());
		else
			obj.setBenName(obj.getFirstName());

		Short benVisitCount = benVisitDetailRepo.getVisitCountForBeneficiary(beneficiaryRegID);

		if (benVisitCount != null && benVisitCount >= 0) {
			benVisitCount = (short) (benVisitCount + 1);
		} else {
			benVisitCount = 1;
		}
		obj.setBenVisitNo(benVisitCount);
		obj.setNurseFlag((short) 1);
		obj.setDoctorFlag((short) 0);
		obj.setPharmacist_flag((short) 0);
		return obj;
	}
	
	public int nurseFlowCompleteBenMoveToDocWorklist(){
		return 0;
	}

}
