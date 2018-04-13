package com.iemr.mmu.service.generalOPD;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.anc.BenChildDevelopmentHistory;
import com.iemr.mmu.data.anc.ChildFeedingDetails;
import com.iemr.mmu.data.anc.FemaleObstetricHistory;
import com.iemr.mmu.data.anc.PerinatalHistory;
import com.iemr.mmu.data.anc.SysGastrointestinalExamination;
import com.iemr.mmu.data.anc.WrapperFemaleObstetricHistory;
import com.iemr.mmu.data.anc.WrapperImmunizationHistory;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.repo.nurse.anc.BenChildDevelopmentHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.ChildFeedingDetailsRepo;
import com.iemr.mmu.repo.nurse.anc.PerinatalHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.SysGastrointestinalExaminationRepo;

@Service
public class GeneralOPDNurseServiceImpl implements GeneralOPDNurseService {
	private BenChildDevelopmentHistoryRepo benChildDevelopmentHistoryRepo;
	private ChildFeedingDetailsRepo childFeedingDetailsRepo;
	private PerinatalHistoryRepo perinatalHistoryRepo;
	private SysGastrointestinalExaminationRepo sysGastrointestinalExaminationRepo;

	@Autowired
	public void setSysGastrointestinalExaminationRepo(
			SysGastrointestinalExaminationRepo sysGastrointestinalExaminationRepo) {
		this.sysGastrointestinalExaminationRepo = sysGastrointestinalExaminationRepo;
	}

	@Autowired
	public void setPerinatalHistoryRepo(PerinatalHistoryRepo perinatalHistoryRepo) {
		this.perinatalHistoryRepo = perinatalHistoryRepo;
	}

	@Autowired
	public void setChildFeedingDetailsRepo(ChildFeedingDetailsRepo childFeedingDetailsRepo) {
		this.childFeedingDetailsRepo = childFeedingDetailsRepo;
	}

	@Autowired
	public void setBenChildDevelopmentHistoryRepo(BenChildDevelopmentHistoryRepo benChildDevelopmentHistoryRepo) {
		this.benChildDevelopmentHistoryRepo = benChildDevelopmentHistoryRepo;
	}

	@Deprecated
	public Long saveChildDevelopmentHistory(BenChildDevelopmentHistory benChildDevelopmentHistory) {
		Long developmentSuccessFlag = null;

		BenChildDevelopmentHistory childDevelopmentHistory = BenChildDevelopmentHistory
				.getDevelopmentHistory(benChildDevelopmentHistory);
		BenChildDevelopmentHistory res = benChildDevelopmentHistoryRepo.save(childDevelopmentHistory);
		if (null != res && res.getID() > 0) {
			developmentSuccessFlag = res.getID();
		}
		return developmentSuccessFlag;
	}

	@Deprecated
	public Long saveChildFeedingHistory(ChildFeedingDetails childFeedingDetails) {
		Long feedingSuccessFlag = null;
		ChildFeedingDetails res = childFeedingDetailsRepo.save(childFeedingDetails);
		if (null != res && res.getID() > 0) {
			feedingSuccessFlag = res.getID();
		}
		return feedingSuccessFlag;
	}

	@Deprecated
	public Long savePerinatalHistory(PerinatalHistory perinatalHistory) {
		Long perinatalSuccessFlag = null;

		PerinatalHistory res = perinatalHistoryRepo.save(perinatalHistory);
		if (null != res && res.getID() > 0) {
			perinatalSuccessFlag = res.getID();
		}
		return perinatalSuccessFlag;
	}

	@Deprecated
	public Long saveSysGastrointestinalExamination(SysGastrointestinalExamination gastrointestinalExamination) {
		Long examinationID = null;
		SysGastrointestinalExamination response = sysGastrointestinalExaminationRepo.save(gastrointestinalExamination);
		if (null != response) {
			examinationID = response.getID();
		}
		return examinationID;
	}

	@Deprecated
	public String fetchBenPerinatalHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> perinatalHistoryDetail = perinatalHistoryRepo.getBenPerinatalDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column = new HashMap<>();
		column.put("columnName", "Date of Capture");
		column.put("keyName", "captureDate");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Place Of Delivery");
		column.put("keyName", "placeOfDelivery");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Other Place Of Delivery");
		column.put("keyName", "otherPlaceOfDelivery");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Type Of Delivery");
		column.put("keyName", "typeOfDelivery");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Complication At Birth");
		column.put("keyName", "complicationAtBirth");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Other Complication At Birth");
		column.put("keyName", "otherComplicationAtBirth");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Gestation");
		column.put("keyName", "gestation");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Birth Weight(kg)");
		column.put("keyName", "birthWeight_kg");
		columns.add(column);

		ArrayList<PerinatalHistory> PerinatalHistoryDetails = new ArrayList<PerinatalHistory>();
		if (null != perinatalHistoryDetail) {
			for (Object[] obj : perinatalHistoryDetail) {
				PerinatalHistory history = new PerinatalHistory((Date) obj[0], (String) obj[1], (String) obj[2],
						(String) obj[3], (String) obj[4], (String) obj[5], (String) obj[6], (Double) obj[7]);
				PerinatalHistoryDetails.add(history);
			}
		}

		response.put("columns", columns);
		response.put("data", PerinatalHistoryDetails);
		return new Gson().toJson(response);

	}

	@Deprecated
	public String fetchBenFeedingHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> feedingHistoryDetail = childFeedingDetailsRepo.getBenFeedingHistoryDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column = new HashMap<>();
		column.put("columnName", "Date of Capture");
		column.put("keyName", "captureDate");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Child ID");
		column.put("keyName", "childID");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Beneficiary Mother ID");
		column.put("keyName", "benMotherID");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Type Of Feed");
		column.put("keyName", "typeOfFeed");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Comp Feed Start Age");
		column.put("keyName", "compFeedStartAge");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "NoOf Comp Feed Per Day");
		column.put("keyName", "noOfCompFeedPerDay");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Food Intolerance Status");
		column.put("keyName", "foodIntoleranceStatus");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Type of Food Intolerance");
		column.put("keyName", "typeofFoodIntolerance");
		columns.add(column);

		ArrayList<ChildFeedingDetails> feedingHistoryDetails = new ArrayList<ChildFeedingDetails>();
		if (null != feedingHistoryDetail) {
			for (Object[] obj : feedingHistoryDetail) {
				ChildFeedingDetails history = new ChildFeedingDetails((Date) obj[0], (Long) obj[1], (Long) obj[2],
						(String) obj[3], (String) obj[4], (Character) obj[5], (Character) obj[6], (String) obj[7]);
				feedingHistoryDetails.add(history);
			}
		}

		response.put("columns", columns);
		response.put("data", feedingHistoryDetails);
		return new Gson().toJson(response);

	}

	@Deprecated
	public String fetchBenDevelopmentHistory(Long beneficiaryRegID) {
		ArrayList<Object[]> developmentHistoryDetail = benChildDevelopmentHistoryRepo
				.getBenDevelopmentHistoryDetail(beneficiaryRegID);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> columns = new ArrayList<Map<String, Object>>();
		Map<String, Object> column = new HashMap<String, Object>();

		column = new HashMap<>();
		column.put("columnName", "Date of Capture");
		column.put("keyName", "captureDate");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Gross Motor Milestone");
		column.put("keyName", "grossMotorMilestone");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Is GMM Attained");
		column.put("keyName", "isGMMAttained");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Fine Motor Milestone");
		column.put("keyName", "fineMotorMilestone");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Is FMM Attained");
		column.put("keyName", "isFMMAttained");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Social Milestone");
		column.put("keyName", "socialMilestone");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Is SM Attained");
		column.put("keyName", "isSMAttained");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Language Milestone");
		column.put("keyName", "languageMilestone");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Is LM Attained");
		column.put("keyName", "isLMAttained");
		columns.add(column);

		column = new HashMap<>();
		column.put("columnName", "Development Problem");
		column.put("keyName", "developmentProblem");
		columns.add(column);

		ArrayList<BenChildDevelopmentHistory> developmentHistoryDetails = new ArrayList<BenChildDevelopmentHistory>();
		if (null != developmentHistoryDetail) {
			for (Object[] obj : developmentHistoryDetail) {

				BenChildDevelopmentHistory history = new BenChildDevelopmentHistory((Date) obj[0], (String) obj[1],
						(Boolean) obj[2], (String) obj[3], (Boolean) obj[4], (String) obj[5], (Boolean) obj[6],
						(String) obj[7], (Boolean) obj[8], (String) obj[9]);
				developmentHistoryDetails.add(history);
			}
		}

		response.put("columns", columns);
		response.put("data", developmentHistoryDetails);
		return new Gson().toJson(response);

	}

	@Deprecated
	public BenChildDevelopmentHistory getDevelopmentHistory(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> benChildDevelopmentHistory = benChildDevelopmentHistoryRepo
				.getBenDevelopmentDetails(beneficiaryRegID, benVisitID);
		BenChildDevelopmentHistory developmentHistoryDetails = BenChildDevelopmentHistory
				.getBenChildDevelopmentDetails(benChildDevelopmentHistory);
		return developmentHistoryDetails;
	}

	@Deprecated
	public PerinatalHistory getPerinatalHistory(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> benPerinatalHistory = perinatalHistoryRepo.getBenPerinatalDetails(beneficiaryRegID,
				benVisitID);
		PerinatalHistory perinatalHistoryDetails = PerinatalHistory.getBenPerinatalDetails(benPerinatalHistory);
		return perinatalHistoryDetails;
	}

	@Deprecated
	public ChildFeedingDetails getFeedingHistory(Long beneficiaryRegID, Long benVisitID) {
		ArrayList<Object[]> benFeedingHistory = childFeedingDetailsRepo.getBenFeedingDetails(beneficiaryRegID,
				benVisitID);
		ChildFeedingDetails feedingHistoryDetails = ChildFeedingDetails.getBenFeedingDetails(benFeedingHistory);
		return feedingHistoryDetails;
	}

	@Deprecated
	public SysGastrointestinalExamination getSysGastrointestinalExamination(Long benRegID, Long benVisitID) {
		SysGastrointestinalExamination sysGastrointestinalExaminationData = sysGastrointestinalExaminationRepo
				.getSSysGastrointestinalExamination(benRegID, benVisitID);

		return sysGastrointestinalExaminationData;
	}

	@Deprecated
	public int updateSysGastrointestinalExamination(SysGastrointestinalExamination gastrointestinalExamination) {
		int response = 0;
		if (null != gastrointestinalExamination) {
			String processed = sysGastrointestinalExaminationRepo.getBenGastrointestinalExaminationStatus(
					gastrointestinalExamination.getBeneficiaryRegID(), gastrointestinalExamination.getBenVisitID());
			if (null != processed && !"N".equals(processed)) {
				processed = "U";
			} else {
				processed = "N";
			}
			response = sysGastrointestinalExaminationRepo.updateSysGastrointestinalExamination(
					gastrointestinalExamination.getInspection(), gastrointestinalExamination.getPalpation(),
					gastrointestinalExamination.getPalpation_AbdomenTexture(),
					gastrointestinalExamination.getPalpation_Liver(), gastrointestinalExamination.getPalpation_Spleen(),
					gastrointestinalExamination.getPalpation_Tenderness(),
					gastrointestinalExamination.getPalpation_LocationOfTenderness(),
					gastrointestinalExamination.getPercussion(), gastrointestinalExamination.getAuscultation(),
					gastrointestinalExamination.getAnalRegion(), gastrointestinalExamination.getModifiedBy(), processed,
					gastrointestinalExamination.getBeneficiaryRegID(), gastrointestinalExamination.getBenVisitID());
		}
		return response;
	}

	@Deprecated
	/*Method moved to common Nurse services*/
	public int updateChildFeedingHistory(ChildFeedingDetails childFeedingDetails) {
		int response = 0;
		if (null != childFeedingDetails) {
			String processed = childFeedingDetailsRepo.getBenChildFeedingDetailStatus(
					childFeedingDetails.getBeneficiaryRegID(), childFeedingDetails.getBenVisitID());
			if (null != processed && !"N".equals(processed)) {
				processed = "U";
			} else {
				processed = "N";
			}
			response = childFeedingDetailsRepo.updateFeedingDetails(childFeedingDetails.getChildID(),
					childFeedingDetails.getBenMotherID(), childFeedingDetails.getTypeOfFeed(),
					childFeedingDetails.getCompFeedStartAge(), childFeedingDetails.getNoOfCompFeedPerDay(),
					childFeedingDetails.getFoodIntoleranceStatus(), childFeedingDetails.getTypeofFoodIntolerance(),
					childFeedingDetails.getModifiedBy(), processed,
					childFeedingDetails.getBeneficiaryRegID(), childFeedingDetails.getBenVisitID());
		}
		return response;
	}

	@Deprecated
	/*Method moved to common Nurse services*/
	public int updatePerinatalHistory(PerinatalHistory perinatalHistory) {
		int response = 0;
		if (null != perinatalHistory) {
			String processed = perinatalHistoryRepo.getPerinatalHistoryStatus(perinatalHistory.getBeneficiaryRegID(),
					perinatalHistory.getBenVisitID());
			if (null != processed && !"N".equals(processed)) {
				processed = "U";
			} else {
				processed = "N";
			}
			response = perinatalHistoryRepo.updatePerinatalDetails(perinatalHistory.getDeliveryPlaceID(),
					perinatalHistory.getPlaceOfDelivery(), perinatalHistory.getOtherPlaceOfDelivery(),
					perinatalHistory.getDeliveryTypeID(), perinatalHistory.getTypeOfDelivery(),
					perinatalHistory.getComplicationAtBirthID(), perinatalHistory.getComplicationAtBirth(),
					perinatalHistory.getOtherComplicationAtBirth(), perinatalHistory.getGestation(),
					perinatalHistory.getBirthWeight_kg(), perinatalHistory.getModifiedBy(),
					processed, perinatalHistory.getBeneficiaryRegID(),
					perinatalHistory.getBenVisitID());
		}
		return response;
	}

	@Deprecated
	/*Method moved to common Nurse services*/
	public int updateChildDevelopmentHistory(BenChildDevelopmentHistory childDevelopmentDetails) {
		int response = 0;
		if (null != childDevelopmentDetails) {
			String processed = benChildDevelopmentHistoryRepo.getDevelopmentHistoryStatus(childDevelopmentDetails.getBeneficiaryRegID(), 
					childDevelopmentDetails.getBenVisitID());
			if (null != processed && !"N".equals(processed)) {
				processed = "U";
			}else{
				processed = "N";
			}
			BenChildDevelopmentHistory childDevelopmentHistory = BenChildDevelopmentHistory
					.getDevelopmentHistory(childDevelopmentDetails);
			
			response = benChildDevelopmentHistoryRepo.updatePerinatalDetails(childDevelopmentHistory.getGrossMotorMilestone(), 
					childDevelopmentHistory.getIsGMMAttained(), childDevelopmentHistory.getFineMotorMilestone(), childDevelopmentHistory.getIsFMMAttained(), 
					childDevelopmentHistory.getSocialMilestone(), childDevelopmentHistory.getIsSMAttained(), childDevelopmentHistory.getLanguageMilestone(), 
					childDevelopmentHistory.getIsLMAttained(), childDevelopmentHistory.getDevelopmentProblem(), childDevelopmentHistory.getModifiedBy(), processed, 
					childDevelopmentHistory.getBeneficiaryRegID(), childDevelopmentHistory.getBenVisitID());
		}
		return response;
	}

}
