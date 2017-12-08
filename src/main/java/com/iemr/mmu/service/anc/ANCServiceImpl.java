package com.iemr.mmu.service.anc;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.anc.ANCCareDetails;
import com.iemr.mmu.data.anc.ANCWomenVaccineDetail;
import com.iemr.mmu.data.anc.BenAdherence;
import com.iemr.mmu.data.anc.BenMedHistory;
import com.iemr.mmu.data.anc.BencomrbidityCondDetails;
import com.iemr.mmu.data.anc.PhyGeneralExamination;
import com.iemr.mmu.data.anc.PhyHeadToToeExamination;
import com.iemr.mmu.data.anc.SysCardiovascularExamination;
import com.iemr.mmu.data.anc.SysCentralNervousExamination;
import com.iemr.mmu.data.anc.SysGastrointestinalExamination;
import com.iemr.mmu.data.anc.SysGenitourinarySystemExamination;
import com.iemr.mmu.data.anc.SysMusculoskeletalSystemExamination;
import com.iemr.mmu.data.anc.SysObstetricExamination;
import com.iemr.mmu.data.anc.SysRespiratoryExamination;
import com.iemr.mmu.data.anc.WrapperAncFindings;
import com.iemr.mmu.data.anc.WrapperAncImmunization;
import com.iemr.mmu.data.anc.WrapperBenInvestigationANC;
import com.iemr.mmu.data.anc.WrapperComorbidCondDetails;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.data.quickConsultation.BenClinicalObservations;
import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;
import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;
import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;
import com.iemr.mmu.repo.nurse.anc.ANCCareRepo;
import com.iemr.mmu.repo.nurse.anc.ANCWomenVaccineRepo;
import com.iemr.mmu.repo.nurse.anc.BenAdherenceRepo;
import com.iemr.mmu.repo.nurse.anc.BenMedHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BencomrbidityCondRepo;
import com.iemr.mmu.repo.nurse.anc.PhyGeneralExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.PhyHeadToToeExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysCardiovascularExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysCentralNervousExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysGastrointestinalExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysGenitourinarySystemExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysMusculoskeletalSystemExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysObstetricExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysRespiratoryExaminationRepo;
import com.iemr.mmu.repo.quickConsultation.BenChiefComplaintRepo;
import com.iemr.mmu.repo.quickConsultation.BenClinicalObservationsRepo;
import com.iemr.mmu.repo.quickConsultation.LabTestOrderDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescribedDrugDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.mmu.service.quickConsultation.QuickConsultationServiceImpl;

@Service
public class ANCServiceImpl implements ANCService {

	private ANCCareRepo ancCareRepo;
	private ANCWomenVaccineRepo ancWomenVaccineRepo;
	private BenAdherenceRepo benAdherenceRepo;
	private BenChiefComplaintRepo benChiefComplaintRepo;
	private PrescriptionDetailRepo prescriptionDetailRepo;

	@Autowired
	public void setBenChiefComplaintRepo(BenChiefComplaintRepo benChiefComplaintRepo) {
		this.benChiefComplaintRepo = benChiefComplaintRepo;
	}

	private QuickConsultationServiceImpl quickConsultationServiceImpl;

	@Autowired
	public void setEmergencyCasesheetServiceImpl(QuickConsultationServiceImpl quickConsultationServiceImpl) {
		this.quickConsultationServiceImpl = quickConsultationServiceImpl;
	}

	private LabTestOrderDetailRepo labTestOrderDetailRepo;

	@Autowired
	public void setLabTestOrderDetailRepo(LabTestOrderDetailRepo labTestOrderDetailRepo) {
		this.labTestOrderDetailRepo = labTestOrderDetailRepo;
	}

	@Autowired
	public void setPrescriptionDetailRepo(PrescriptionDetailRepo prescriptionDetailRepo) {
		this.prescriptionDetailRepo = prescriptionDetailRepo;
	}

	private PhyGeneralExaminationRepo phyGeneralExaminationRepo;
	private PhyHeadToToeExaminationRepo phyHeadToToeExaminationRepo;
	private SysCardiovascularExaminationRepo sysCardiovascularExaminationRepo;
	private SysCentralNervousExaminationRepo sysCentralNervousExaminationRepo;
	private SysGastrointestinalExaminationRepo sysGastrointestinalExaminationRepo;
	private SysGenitourinarySystemExaminationRepo sysGenitourinarySystemExaminationRepo;
	private SysMusculoskeletalSystemExaminationRepo sysMusculoskeletalSystemExaminationRepo;
	private SysObstetricExaminationRepo sysObstetricExaminationRepo;
	private SysRespiratoryExaminationRepo sysRespiratoryExaminationRepo;

	private NurseServiceImpl nurseServiceImpl;
	private BenMedHistoryRepo benMedHistoryRepo;
	private BencomrbidityCondRepo bencomrbidityCondRepo;
	
	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
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

	@Autowired
	public void setPhyGeneralExaminationRepo(PhyGeneralExaminationRepo phyGeneralExaminationRepo) {
		this.phyGeneralExaminationRepo = phyGeneralExaminationRepo;
	}

	@Autowired
	public void setPhyHeadToToeExaminationRepo(PhyHeadToToeExaminationRepo phyHeadToToeExaminationRepo) {
		this.phyHeadToToeExaminationRepo = phyHeadToToeExaminationRepo;
	}

	@Autowired
	public void setSysCardiovascularExaminationRepo(SysCardiovascularExaminationRepo sysCardiovascularExaminationRepo) {
		this.sysCardiovascularExaminationRepo = sysCardiovascularExaminationRepo;
	}

	@Autowired
	public void setSysCentralNervousExaminationRepo(SysCentralNervousExaminationRepo sysCentralNervousExaminationRepo) {
		this.sysCentralNervousExaminationRepo = sysCentralNervousExaminationRepo;
	}

	@Autowired
	public void setSysGastrointestinalExaminationRepo(
			SysGastrointestinalExaminationRepo sysGastrointestinalExaminationRepo) {
		this.sysGastrointestinalExaminationRepo = sysGastrointestinalExaminationRepo;
	}

	@Autowired
	public void setSysGenitourinarySystemExaminationRepo(
			SysGenitourinarySystemExaminationRepo sysGenitourinarySystemExaminationRepo) {
		this.sysGenitourinarySystemExaminationRepo = sysGenitourinarySystemExaminationRepo;
	}

	@Autowired
	public void setSysMusculoskeletalSystemExaminationRepo(
			SysMusculoskeletalSystemExaminationRepo sysMusculoskeletalSystemExaminationRepo) {
		this.sysMusculoskeletalSystemExaminationRepo = sysMusculoskeletalSystemExaminationRepo;
	}

	@Autowired
	public void setSysObstetricExaminationRepo(SysObstetricExaminationRepo sysObstetricExaminationRepo) {
		this.sysObstetricExaminationRepo = sysObstetricExaminationRepo;
	}

	@Autowired
	public void setSysRespiratoryExaminationRepo(SysRespiratoryExaminationRepo sysRespiratoryExaminationRepo) {
		this.sysRespiratoryExaminationRepo = sysRespiratoryExaminationRepo;
	}
	
	@Autowired
	public void setBenMedHistoryRepo(BenMedHistoryRepo benMedHistoryRepo) {
		this.benMedHistoryRepo = benMedHistoryRepo;
	}
	
	@Autowired
	public void setBencomrbidityCondRepo(BencomrbidityCondRepo bencomrbidityCondRepo) {
		this.bencomrbidityCondRepo = bencomrbidityCondRepo;
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

	public Integer saveBenInvestigationFromDoc(WrapperBenInvestigationANC wrapperBenInvestigationANC) {
		int r = 0;
		ArrayList<LabTestOrderDetail> LabTestOrderDetailList = new ArrayList<>();
		ArrayList<LabTestOrderDetail> investigationList = wrapperBenInvestigationANC.getLaboratoryList();
		if (investigationList != null && investigationList.size() > 0) {

			for (LabTestOrderDetail testData : investigationList) {

				testData.setBeneficiaryRegID(wrapperBenInvestigationANC.getBeneficiaryRegID());
				testData.setBenVisitID(wrapperBenInvestigationANC.getBenVisitID());
				testData.setProviderServiceMapID(wrapperBenInvestigationANC.getProviderServiceMapID());
				testData.setCreatedBy(wrapperBenInvestigationANC.getCreatedBy());
				testData.setPrescriptionID(wrapperBenInvestigationANC.getPrescriptionID());

				LabTestOrderDetailList.add(testData);
			}
			ArrayList<LabTestOrderDetail> LabTestOrderDetailListRS = (ArrayList<LabTestOrderDetail>) labTestOrderDetailRepo
					.save(LabTestOrderDetailList);

			if (LabTestOrderDetailListRS != null && LabTestOrderDetailListRS.size() > 0) {
				r = 1;
			}
		} else {
			r = 1;
		}
		return r;
	}

	@Override
	public Long saveBenInvestigation(WrapperBenInvestigationANC wrapperBenInvestigationANC) {
		Long r = null;
		PrescriptionDetail prescriptionDetail = new PrescriptionDetail();
		prescriptionDetail.setBeneficiaryRegID(wrapperBenInvestigationANC.getBeneficiaryRegID());
		prescriptionDetail.setBenVisitID(wrapperBenInvestigationANC.getBenVisitID());
		prescriptionDetail.setProviderServiceMapID(wrapperBenInvestigationANC.getProviderServiceMapID());
		prescriptionDetail.setCreatedBy(wrapperBenInvestigationANC.getCreatedBy());

		Long prescriptionID = quickConsultationServiceImpl.saveBenPrescriptionForANC(prescriptionDetail);

		if (prescriptionID != null && prescriptionID > 0) {
			ArrayList<LabTestOrderDetail> LabTestOrderDetailList = new ArrayList<>();
			ArrayList<LabTestOrderDetail> investigationList = wrapperBenInvestigationANC.getLaboratoryList();
			if (investigationList != null && investigationList.size() > 0) {

				for (LabTestOrderDetail testData : investigationList) {

					testData.setPrescriptionID(prescriptionID);
					testData.setBeneficiaryRegID(wrapperBenInvestigationANC.getBeneficiaryRegID());
					testData.setBenVisitID(wrapperBenInvestigationANC.getBenVisitID());
					testData.setProviderServiceMapID(wrapperBenInvestigationANC.getProviderServiceMapID());
					testData.setCreatedBy(wrapperBenInvestigationANC.getCreatedBy());

					LabTestOrderDetailList.add(testData);
				}
				ArrayList<LabTestOrderDetail> LabTestOrderDetailListRS = (ArrayList<LabTestOrderDetail>) labTestOrderDetailRepo
						.save(LabTestOrderDetailList);

				if (prescriptionID > 0 && LabTestOrderDetailListRS.size() > 0) {
					r = prescriptionID;
				}

			} else {
				r = prescriptionID;
			}
		}

		return r;

	}

	@Override
	public int saveBenAncCareDetails(ANCCareDetails ancCareDetailsOBJ) throws ParseException {
		int r = 0;
		if (ancCareDetailsOBJ.getLmpDate() != null && !ancCareDetailsOBJ.getLmpDate().isEmpty()
				&& ancCareDetailsOBJ.getLmpDate().length() >= 10) {
			String lmpDate = ancCareDetailsOBJ.getLmpDate().split("T")[0];
			ancCareDetailsOBJ
					.setLastMenstrualPeriod_LMP(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(lmpDate).getTime()));
		}
		if (ancCareDetailsOBJ.getExpDelDt() != null && !ancCareDetailsOBJ.getExpDelDt().isEmpty()
				&& ancCareDetailsOBJ.getExpDelDt().length() >= 10) {
			String edDate = ancCareDetailsOBJ.getExpDelDt().split("T")[0];
			ancCareDetailsOBJ
					.setExpectedDateofDelivery(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(edDate).getTime()));
		}
		ANCCareDetails ancCareDetailsRS = ancCareRepo.save(ancCareDetailsOBJ);
		if (ancCareDetailsRS != null) {
			r = 1;
		}
		return r;
	}

	@Override
	public int saveAncImmunizationDetails(WrapperAncImmunization wrapperAncImmunizationOBJ) throws ParseException {
		int r = 0;
		List<ANCWomenVaccineDetail> ancWomenVaccineDetailList = getANCWomenVaccineDetail(wrapperAncImmunizationOBJ);
		List<ANCWomenVaccineDetail> ancWomenVaccineDetailRSList = (List<ANCWomenVaccineDetail>) ancWomenVaccineRepo
				.save(ancWomenVaccineDetailList);
		if (ancWomenVaccineDetailRSList != null && ancWomenVaccineDetailRSList.size() > 0)
			r = 1;
		return r;
	}

	private List<ANCWomenVaccineDetail> getANCWomenVaccineDetail(WrapperAncImmunization wrapperAncImmunizationOBJ)
			throws ParseException {
		List<ANCWomenVaccineDetail> ancWomenVaccineDetailList = new ArrayList<ANCWomenVaccineDetail>();
		ANCWomenVaccineDetail ancWomenVaccineDetail;
		if (wrapperAncImmunizationOBJ != null) {

			// TT-1 details
			ancWomenVaccineDetail = new ANCWomenVaccineDetail();
			ancWomenVaccineDetail.setBeneficiaryRegID(wrapperAncImmunizationOBJ.getBeneficiaryRegID());
			ancWomenVaccineDetail.setBenVisitID(wrapperAncImmunizationOBJ.getBenVisitID());
			ancWomenVaccineDetail.setProviderServiceMapID(wrapperAncImmunizationOBJ.getProviderServiceMapID());
			ancWomenVaccineDetail.setCreatedBy(wrapperAncImmunizationOBJ.getCreatedBy());
			ancWomenVaccineDetail.setVaccineName("TT-1");
			ancWomenVaccineDetail.setStatus(wrapperAncImmunizationOBJ.gettT_1Status());
			if (wrapperAncImmunizationOBJ.getDateReceivedForTT_1() != null
					&& wrapperAncImmunizationOBJ.getDateReceivedForTT_1().length() >= 10) {
				String TT_1 = wrapperAncImmunizationOBJ.getDateReceivedForTT_1().split("T")[0];
				ancWomenVaccineDetail
						.setReceivedDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(TT_1).getTime()));
			}
			ancWomenVaccineDetail.setReceivedFacilityName(wrapperAncImmunizationOBJ.getFacilityNameOfTT_1());
			ancWomenVaccineDetailList.add(ancWomenVaccineDetail);

			// TT-2 details
			ancWomenVaccineDetail = new ANCWomenVaccineDetail();
			ancWomenVaccineDetail.setBeneficiaryRegID(wrapperAncImmunizationOBJ.getBeneficiaryRegID());
			ancWomenVaccineDetail.setBenVisitID(wrapperAncImmunizationOBJ.getBenVisitID());
			ancWomenVaccineDetail.setProviderServiceMapID(wrapperAncImmunizationOBJ.getProviderServiceMapID());
			ancWomenVaccineDetail.setCreatedBy(wrapperAncImmunizationOBJ.getCreatedBy());
			ancWomenVaccineDetail.setVaccineName("TT-2");
			ancWomenVaccineDetail.setStatus(wrapperAncImmunizationOBJ.gettT_2Status());
			if (wrapperAncImmunizationOBJ.getDateReceivedForTT_2() != null
					&& wrapperAncImmunizationOBJ.getDateReceivedForTT_2().length() >= 10) {
				String TT_2 = wrapperAncImmunizationOBJ.getDateReceivedForTT_2().split("T")[0];
				ancWomenVaccineDetail
						.setReceivedDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(TT_2).getTime()));
			}
			ancWomenVaccineDetail.setReceivedFacilityName(wrapperAncImmunizationOBJ.getFacilityNameOfTT_2());
			ancWomenVaccineDetailList.add(ancWomenVaccineDetail);

			// TT-3 (Booster) details
			ancWomenVaccineDetail = new ANCWomenVaccineDetail();
			ancWomenVaccineDetail.setBeneficiaryRegID(wrapperAncImmunizationOBJ.getBeneficiaryRegID());
			ancWomenVaccineDetail.setBenVisitID(wrapperAncImmunizationOBJ.getBenVisitID());
			ancWomenVaccineDetail.setProviderServiceMapID(wrapperAncImmunizationOBJ.getProviderServiceMapID());
			ancWomenVaccineDetail.setCreatedBy(wrapperAncImmunizationOBJ.getCreatedBy());
			ancWomenVaccineDetail.setVaccineName("TT-Booster");
			ancWomenVaccineDetail.setStatus(wrapperAncImmunizationOBJ.gettT_3Status());
			if (wrapperAncImmunizationOBJ.getDateReceivedForTT_3() != null
					&& wrapperAncImmunizationOBJ.getDateReceivedForTT_3().length() >= 10) {
				String TT_3 = wrapperAncImmunizationOBJ.getDateReceivedForTT_3().split("T")[0];
				ancWomenVaccineDetail
						.setReceivedDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(TT_3).getTime()));
			}
			ancWomenVaccineDetail.setReceivedFacilityName(wrapperAncImmunizationOBJ.getFacilityNameOfTT_3());
			ancWomenVaccineDetailList.add(ancWomenVaccineDetail);

		}
		return ancWomenVaccineDetailList;
	}

	public int savePhyGeneralExamination(PhyGeneralExamination generalExamination) {
		int generalExaminationID = 0;
		String TypeOfDangerSigns = "";
		if (null != generalExamination.getTypeOfDangerSigns() && generalExamination.getTypeOfDangerSigns().size() > 0) {
			for (String TypeOfDangerSign : generalExamination.getTypeOfDangerSigns()) {
				TypeOfDangerSigns += TypeOfDangerSign + ",";
			}
			generalExamination.setTypeOfDangerSign(TypeOfDangerSigns);
		}

		PhyGeneralExamination response = phyGeneralExaminationRepo.save(generalExamination);
		if (null != response) {
			generalExaminationID = 1;
		}
		return generalExaminationID;
	}

	@Override
	public int savePhyHeadToToeExamination(PhyHeadToToeExamination headToToeExamination) {
		int examinationID = 0;
		PhyHeadToToeExamination response = phyHeadToToeExaminationRepo.save(headToToeExamination);

		if (null != response) {
			examinationID = 1;
		}
		return examinationID;
	}

	@Override
	public int saveSysCardiovascularExamination(SysCardiovascularExamination cardiovascularExamination) {
		int examinationID = 0;
		SysCardiovascularExamination response = sysCardiovascularExaminationRepo.save(cardiovascularExamination);

		if (null != response) {
			examinationID = 1;
		}
		return examinationID;
	}

	@Override
	public int saveSysCentralNervousExamination(SysCentralNervousExamination centralNervousExamination) {
		// TODO Auto-generated method stub
		int r = 0;
		SysCentralNervousExamination centralNervousExaminationRS = sysCentralNervousExaminationRepo
				.save(centralNervousExamination);
		if (centralNervousExaminationRS != null) {
			r = 1;
		}
		return r;
	}

	@Override
	public int saveSysGastrointestinalExamination(SysGastrointestinalExamination gastrointestinalExamination) {
		int examinationID = 0;
		SysGastrointestinalExamination response = sysGastrointestinalExaminationRepo.save(gastrointestinalExamination);
		if (null != response) {
			examinationID = 1;
		}
		return examinationID;
	}

	@Override
	public int saveSysGenitourinarySystemExamination(SysGenitourinarySystemExamination genitourinarySystemExamination) {
		// TODO Auto-generated method stub
		int r = 0;
		SysGenitourinarySystemExamination sysGenitourinarySystemExaminationRS = sysGenitourinarySystemExaminationRepo
				.save(genitourinarySystemExamination);
		if (null != sysGenitourinarySystemExaminationRS) {
			r = 1;
		}
		return r;
	}

	@Override
	public int saveSysMusculoskeletalSystemExamination(
			SysMusculoskeletalSystemExamination musculoskeletalSystemExamination) {
		// TODO Auto-generated method stub
		int r = 0;
		SysMusculoskeletalSystemExamination musculoskeletalSystemExaminationRS = sysMusculoskeletalSystemExaminationRepo
				.save(musculoskeletalSystemExamination);
		if (null != musculoskeletalSystemExaminationRS) {
			r = 1;
		}
		return r;
	}

	@Override
	public int saveSysObstetricExamination(SysObstetricExamination obstetricExamination) {
		// TODO Auto-generated method stub
		int r = 0;
		SysObstetricExamination obstetricExaminationRS = sysObstetricExaminationRepo.save(obstetricExamination);
		if (obstetricExaminationRS != null)
			r = 1;
		return r;
	}

	@Override
	public int saveSysRespiratoryExamination(SysRespiratoryExamination respiratoryExamination) {
		// TODO Auto-generated method stub
		int r = 0;
		SysRespiratoryExamination respiratoryExaminationRS = sysRespiratoryExaminationRepo.save(respiratoryExamination);
		if (respiratoryExaminationRS != null)
			r = 1;
		return r;
	}

	@Override
	public String getANCExaminationDetailsData(Long benRegID, Long benVisitID) {
		Map<String, Object> examinationDetailsMap = new HashMap<String, Object>();

		examinationDetailsMap.put("generalExamination", getGeneralExaminationData(benRegID, benVisitID));
		examinationDetailsMap.put("headToToeExamination", getHeadToToeExaminationData(benRegID, benVisitID));
		examinationDetailsMap.put("gastrointestinalExamination",
				getSysGastrointestinalExamination(benRegID, benVisitID));
		examinationDetailsMap.put("cardiovascularExamination", getCardiovascularExamination(benRegID, benVisitID));
		examinationDetailsMap.put("respiratoryExamination", getRespiratoryExamination(benRegID, benVisitID));
		examinationDetailsMap.put("centralNervousExamination", getSysCentralNervousExamination(benRegID, benVisitID));
		examinationDetailsMap.put("musculoskeletalExamination", getMusculoskeletalExamination(benRegID, benVisitID));
		examinationDetailsMap.put("genitourinaryExamination", getGenitourinaryExamination(benRegID, benVisitID));
		examinationDetailsMap.put("obstetricExamination", getSysObstetricExamination(benRegID, benVisitID));

		return new Gson().toJson(examinationDetailsMap);
	}

	private PhyGeneralExamination getGeneralExaminationData(Long benRegID, Long benVisitID) {
		PhyGeneralExamination phyGeneralExaminationData = phyGeneralExaminationRepo
				.getPhyGeneralExaminationData(benRegID, benVisitID);
		if (null != phyGeneralExaminationData) {
			String dSign = phyGeneralExaminationData.getTypeOfDangerSign();
			if (dSign != null && dSign.length() > 0) {
				String[] typeDangerSignArr = dSign.split(",");
				if (typeDangerSignArr != null && typeDangerSignArr.length > 0) {
					ArrayList<String> typeOfDangerSigns = new ArrayList<>();
					for (String typeDangerSign : typeDangerSignArr) {
						typeOfDangerSigns.add(typeDangerSign);
					}
					phyGeneralExaminationData.setTypeOfDangerSigns(typeOfDangerSigns);
				}
			} else {
				ArrayList<String> typeOfDangerSignsTmp = new ArrayList<>();
				phyGeneralExaminationData.setTypeOfDangerSigns(typeOfDangerSignsTmp);
			}

		}
		return phyGeneralExaminationData;

	}

	private PhyHeadToToeExamination getHeadToToeExaminationData(Long benRegID, Long benVisitID) {
		PhyHeadToToeExamination phyHeadToToeExaminationData = phyHeadToToeExaminationRepo
				.getPhyHeadToToeExaminationData(benRegID, benVisitID);

		return phyHeadToToeExaminationData;

	}

	private SysGastrointestinalExamination getSysGastrointestinalExamination(Long benRegID, Long benVisitID) {
		SysGastrointestinalExamination sysGastrointestinalExaminationData = sysGastrointestinalExaminationRepo
				.getSSysGastrointestinalExamination(benRegID, benVisitID);

		return sysGastrointestinalExaminationData;
	}

	private SysCardiovascularExamination getCardiovascularExamination(Long benRegID, Long benVisitID) {
		SysCardiovascularExamination sysCardiovascularExaminationData = sysCardiovascularExaminationRepo
				.getSysCardiovascularExaminationData(benRegID, benVisitID);

		return sysCardiovascularExaminationData;
	}

	private SysRespiratoryExamination getRespiratoryExamination(Long benRegID, Long benVisitID) {
		SysRespiratoryExamination sysRespiratoryExaminationData = sysRespiratoryExaminationRepo
				.getSysRespiratoryExaminationData(benRegID, benVisitID);

		return sysRespiratoryExaminationData;
	}

	private SysCentralNervousExamination getSysCentralNervousExamination(Long benRegID, Long benVisitID) {
		SysCentralNervousExamination sysCentralNervousExaminationData = sysCentralNervousExaminationRepo
				.getSysCentralNervousExaminationData(benRegID, benVisitID);

		return sysCentralNervousExaminationData;
	}

	private SysMusculoskeletalSystemExamination getMusculoskeletalExamination(Long benRegID, Long benVisitID) {
		SysMusculoskeletalSystemExamination sysMusculoskeletalSystemExaminationData = sysMusculoskeletalSystemExaminationRepo
				.getSysMusculoskeletalSystemExamination(benRegID, benVisitID);

		return sysMusculoskeletalSystemExaminationData;
	}

	private SysGenitourinarySystemExamination getGenitourinaryExamination(Long benRegID, Long benVisitID) {
		SysGenitourinarySystemExamination sysGenitourinarySystemExaminationData = sysGenitourinarySystemExaminationRepo
				.getSysGenitourinarySystemExaminationData(benRegID, benVisitID);

		return sysGenitourinarySystemExaminationData;
	}

	private SysObstetricExamination getSysObstetricExamination(Long benRegID, Long benVisitID) {
		SysObstetricExamination sysObstetricExaminationData = sysObstetricExaminationRepo
				.getSysObstetricExaminationData(benRegID, benVisitID);

		return sysObstetricExaminationData;
	}

	public String getBenVisitDetailsFrmNurseANC(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();

		resMap.put("ANCNurseVisitDetail",
				nurseServiceImpl.getBenDataFrmNurseToDocVisitDetailsScreen(benRegID, benVisitID));

		resMap.put("BenAdherence", getBenAdherence(benRegID, benVisitID));

		resMap.put("BenChiefComplaints", getBenChiefComplaints(benRegID, benVisitID));

		resMap.put("LabTestOrders", getLabTestOrders(benRegID, benVisitID));

		return resMap.toString();
	}

	@Override
	public String getBenAdherence(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> resList = benAdherenceRepo.getBenAdherence(beneficiaryRegID, benVisitID);
		BenAdherence benAdherences = BenAdherence.getBenAdherences(resList);
		return new Gson().toJson(benAdherences);
	}

	@Override
	public String getBenChiefComplaints(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> resList = benChiefComplaintRepo.getBenChiefComplaints(beneficiaryRegID, benVisitID);
		ArrayList<BenChiefComplaint> benChiefComplaints = BenChiefComplaint.getBenChiefComplaints(resList);
		return new Gson().toJson(benChiefComplaints);
	}

	@Override
	public String getLabTestOrders(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> resList = labTestOrderDetailRepo.getLabTestOrderDetails(beneficiaryRegID, benVisitID);
		WrapperBenInvestigationANC labTestOrderDetails = LabTestOrderDetail.getLabTestOrderDetails(resList);
		return new Gson().toJson(labTestOrderDetails);
	}

	public String getBenANCDetailsFrmNurseANC(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();

		resMap.put("ANCCareDetail", getANCCareDetails(benRegID, benVisitID));

		resMap.put("ANCWomenVaccineDetails", getANCWomenVaccineDetails(benRegID, benVisitID));

		return resMap.toString();
	}

	@Override
	public String getANCCareDetails(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> resList = ancCareRepo.getANCCareDetails(beneficiaryRegID, benVisitID);
		ANCCareDetails ancCareDetails = ANCCareDetails.getANCCareDetails(resList);
		return new Gson().toJson(ancCareDetails);
	}

	@Override
	public String getANCWomenVaccineDetails(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> resList = ancWomenVaccineRepo.getANCWomenVaccineDetails(beneficiaryRegID, benVisitID);
		WrapperAncImmunization ancWomenVaccineDetails = ANCWomenVaccineDetail.getANCWomenVaccineDetails(resList);
		return new Gson().toJson(ancWomenVaccineDetails);
	}

	@Override
	public Integer saveAncDocFindings(WrapperAncFindings wrapperAncFindings) {
		int i = 0;
		BenClinicalObservations benClinicalObservationsRS = benClinicalObservationsRepo
				.save(getBenClinicalObservations(wrapperAncFindings));
		System.out.println("hii");
		ArrayList<BenChiefComplaint> benChiefComplaintListRS = (ArrayList<BenChiefComplaint>) benChiefComplaintRepo
				.save(getBenChiefComplaint(wrapperAncFindings));
		System.out.println("hii");
		if (benClinicalObservationsRS != null && benChiefComplaintListRS != null) {
			i = 1;
		}
		return i;
	}

	private ArrayList<BenChiefComplaint> getBenChiefComplaint(WrapperAncFindings wrapperAncFindings) {
		ArrayList<BenChiefComplaint> benChiefComplaintList = new ArrayList<>();
		BenChiefComplaint benChiefComplaint;
		if (wrapperAncFindings != null && wrapperAncFindings.getComplaints() != null
				&& wrapperAncFindings.getComplaints().size() > 0) {
			for (Map<String, Object> complaintsDetails : wrapperAncFindings.getComplaints()) {
				benChiefComplaint = new BenChiefComplaint();
				benChiefComplaint.setBeneficiaryRegID(wrapperAncFindings.getBeneficiaryRegID());
				benChiefComplaint.setBenVisitID(wrapperAncFindings.getBenVisitID());
				benChiefComplaint.setProviderServiceMapID(wrapperAncFindings.getProviderServiceMapID());
				benChiefComplaint.setCreatedBy(wrapperAncFindings.getCreatedBy());

				if (complaintsDetails.containsKey("chiefComplaintID")) {
					Double d = (Double) complaintsDetails.get("chiefComplaintID");
					benChiefComplaint.setChiefComplaintID(d.intValue());
				}
				if (complaintsDetails.containsKey("chiefComplaint"))
					benChiefComplaint.setChiefComplaint((String) complaintsDetails.get("chiefComplaint"));
				if (complaintsDetails.containsKey("duration"))
					benChiefComplaint.setDuration(Integer.parseInt(complaintsDetails.get("duration").toString()));
				if (complaintsDetails.containsKey("unitOfDuration"))
					benChiefComplaint.setUnitOfDuration((String) complaintsDetails.get("unitOfDuration"));
				if (complaintsDetails.containsKey("description"))
					benChiefComplaint.setDescription((String) complaintsDetails.get("description"));

				benChiefComplaintList.add(benChiefComplaint);
			}
		}
		return benChiefComplaintList;
	}

	private BenClinicalObservationsRepo benClinicalObservationsRepo;

	@Autowired
	private void setBenClinicalObservationsRepo(BenClinicalObservationsRepo benClinicalObservationsRepo) {
		this.benClinicalObservationsRepo = benClinicalObservationsRepo;
	}

	private BenClinicalObservations getBenClinicalObservations(WrapperAncFindings wrapperAncFindings) {
		BenClinicalObservations benClinicalObservations = new BenClinicalObservations();
		benClinicalObservations.setBeneficiaryRegID(wrapperAncFindings.getBeneficiaryRegID());
		benClinicalObservations.setBenVisitID(wrapperAncFindings.getBenVisitID());
		benClinicalObservations.setProviderServiceMapID(wrapperAncFindings.getProviderServiceMapID());
		benClinicalObservations.setCreatedBy(wrapperAncFindings.getCreatedBy());
		benClinicalObservations.setClinicalObservation(wrapperAncFindings.getClinicalObservation());
		benClinicalObservations.setOtherSymptoms(wrapperAncFindings.getOtherSymptoms());

		return benClinicalObservations;
	}

	public Long saveBenANCDiagnosis(PrescriptionDetail prescriptionDetail) {
		Long prescriptionID = null;
		PrescriptionDetail res = prescriptionDetailRepo.save(prescriptionDetail);
		if (null != res && res.getPrescriptionID() > 0) {
			prescriptionID = res.getPrescriptionID();
		}
		return prescriptionID;
	}

	private PrescribedDrugDetailRepo prescribedDrugDetailRepo;

	@Autowired
	public void setPrescribedDrugDetailRepo(PrescribedDrugDetailRepo prescribedDrugDetailRepo) {
		this.prescribedDrugDetailRepo = prescribedDrugDetailRepo;
	}

	@Override
	public Integer saveBenANCPrescription(List<PrescribedDrugDetail> prescribedDrugDetailList) {
		Integer r = null;
		List<PrescribedDrugDetail> prescribedDrugDetailListRS = (List<PrescribedDrugDetail>) prescribedDrugDetailRepo
				.save(prescribedDrugDetailList);
		if (prescribedDrugDetailList.size() > 0 && prescribedDrugDetailListRS != null
				&& prescribedDrugDetailListRS.size() > 0) {
			r = prescribedDrugDetailListRS.size();
		}
		return r;
	}
	
	@Override
	public Integer saveBenANCPastHistory(BenMedHistory benMedHistory) {
		Integer r = null;
		ArrayList<BenMedHistory> benMedHistoryList = benMedHistory.getBenPastHistory();
		ArrayList<BenMedHistory> res = (ArrayList<BenMedHistory>) benMedHistoryRepo.save(benMedHistoryList);
		if(null != res && res.size()>0){
			r = res.size();
		}
		return r;
	}
	
	@Override
	public Integer saveBenANCComorbidConditions(WrapperComorbidCondDetails wrapperComorbidCondDetails) {
		Integer r = null;
		ArrayList<BencomrbidityCondDetails> bencomrbidityCondDetailsList = wrapperComorbidCondDetails.getComrbidityConds();
		ArrayList<BencomrbidityCondDetails> res = (ArrayList<BencomrbidityCondDetails>) bencomrbidityCondRepo.save(bencomrbidityCondDetailsList);
		if(null != res && res.size()>0){
			r = res.size();
		}
		return r;
	}
}
