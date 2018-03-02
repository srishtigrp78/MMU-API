package com.iemr.mmu.service.common.transaction;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.data.common.BeneficiaryFlowStatus;
import com.iemr.mmu.data.registrar.BeneficiaryData;
import com.iemr.mmu.repo.common.BeneficiaryFlowStatusRepo;

/***
 * 
 * @author NE298657
 *
 */
@Service
public class CommonBenStatusFlowServiceImpl implements CommonBenStatusFlowService {
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;
	CommonNurseServiceImpl commonNurseServiceImpl;

	@Autowired
	public void setCommonNurseServiceImpl(CommonNurseServiceImpl commonNurseServiceImpl) {
		this.commonNurseServiceImpl = commonNurseServiceImpl;
	}

	@Autowired
	public void setBeneficiaryFlowStatusRepo(BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo) {
		this.beneficiaryFlowStatusRepo = beneficiaryFlowStatusRepo;
	}

	public Long updateBenFlowStatusFlagMain(String role, Long benRegID, Long benVisitID, Long benVisitCode,
			String visitReason, String visitCategory, Integer visitNo, Short nurseFlag, Short doctorFlag,
			Short pharmaFlag, Short labFlow, Short radiologistFlag, Short oncologistFlag, Short specialistFlag,
			String createdBy, String modifiedBy, BeneficiaryData benData, String phoneNo) {
		Long returnOBJ = null;
		if (role.equalsIgnoreCase("registrar")) {
			returnOBJ = updateFlagAfterRegistration(benData, phoneNo);
		}
		return returnOBJ;
	}

	private Long updateFlagAfterRegistration(BeneficiaryData benData, String phoneNo) {

		Short benVisitCnt = commonNurseServiceImpl.getBenVisitCount(benData.getBeneficiaryRegID());

		BeneficiaryFlowStatus bfs = new BeneficiaryFlowStatus();
		bfs.setBeneficiary_reg_id(benData.getBeneficiaryRegID());
		bfs.setBen_name(benData.getFirstName() + " " + benData.getLastName());
		bfs.setBen_dob(benData.getDob());

		String dob = benData.getDob().toString();
		dob = dob.split(" ")[0];
		int a = Integer.parseInt(dob.split("-")[0]);
		int b = Integer.parseInt(dob.split("-")[1]);
		int c = Integer.parseInt(dob.split("-")[2]);

		LocalDate today = LocalDate.now();
		LocalDate bdy = LocalDate.of(a, b, c);

		Period p = Period.between(bdy, today);

		String benAge;
		if (p.getYears() > 0) {
			benAge = (p.getYears() + " years - " + p.getMonths() + " months");
		} else {
			benAge = (p.getMonths() + " months - " + p.getDays() + " days");
		}

		bfs.setBen_age(benAge);
		bfs.setBen_age_val(p.getYears());
		bfs.setFather_name(benData.getFatherName());
		bfs.setSpouse_name(benData.getSpouseName());
		bfs.setBen_gender_val(benData.getGenderID());

		if (benData.getGenderID() == 1)
			bfs.setBen_gender("Male");
		else if (benData.getGenderID() == 2)
			bfs.setBen_gender("Female");
		else if (benData.getGenderID() == 3)
			bfs.setBen_gender("Transgender");

		bfs.setBen_phone_no(phoneNo);
		bfs.setCreated_by(benData.getCreatedBy());

		bfs.setNurse_flag((short) 1);
		bfs.setDoctor_flag((short) 0);
		bfs.setLab_technician_flag((short) 0);
		bfs.setPharmacist_flag((short) 0);
		bfs.setRadiologist_flag((short) 0);
		bfs.setOncologist_flag((short) 0);
		bfs.setSpecialist_flag((short) 0);

		bfs.setVisit_no(benVisitCnt);

		BeneficiaryFlowStatus bfsRS = beneficiaryFlowStatusRepo.save(bfs);
		if (bfsRS != null)
			return bfsRS.getBen_flow_id();
		else
			return null;
	}
}
