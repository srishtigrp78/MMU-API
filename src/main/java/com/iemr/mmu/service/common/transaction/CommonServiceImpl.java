package com.iemr.mmu.service.common.transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.service.anc.ANCServiceImpl;
import com.iemr.mmu.service.generalOPD.GeneralOPDServiceImpl;
import com.iemr.mmu.service.ncdCare.NCDCareServiceImpl;
import com.iemr.mmu.service.pnc.PNCServiceImpl;
import com.iemr.mmu.service.quickConsultation.QuickConsultationServiceImpl;

@Service
public class CommonServiceImpl implements CommonService {

	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;
	private ANCServiceImpl ancServiceImpl;
	private PNCServiceImpl pncServiceImpl;
	private GeneralOPDServiceImpl generalOPDServiceImpl;
	private NCDCareServiceImpl ncdCareServiceImpl;
	private QuickConsultationServiceImpl quickConsultationServiceImpl;
	

	@Autowired
	public void setQuickConsultationServiceImpl(QuickConsultationServiceImpl quickConsultationServiceImpl) {
		this.quickConsultationServiceImpl = quickConsultationServiceImpl;
	}

	@Autowired
	public void setNcdCareServiceImpl(NCDCareServiceImpl ncdCareServiceImpl) {
		this.ncdCareServiceImpl = ncdCareServiceImpl;
	}

	@Autowired
	public void setGeneralOPDServiceImpl(GeneralOPDServiceImpl generalOPDServiceImpl) {
		this.generalOPDServiceImpl = generalOPDServiceImpl;
	}

	@Autowired
	public void setPncServiceImpl(PNCServiceImpl pncServiceImpl) {
		this.pncServiceImpl = pncServiceImpl;
	}

	@Autowired
	public void setAncServiceImpl(ANCServiceImpl ancServiceImpl) {
		this.ancServiceImpl = ancServiceImpl;
	}

	@Autowired
	public void setBeneficiaryFlowStatusRepo(BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo) {
		this.beneficiaryFlowStatusRepo = beneficiaryFlowStatusRepo;
	}

	public String getCaseSheetPrintDataForBeneficiary(BeneficiaryFlowStatus benFlowOBJ, String Authorization) {
		String visitCategory = benFlowOBJ.getVisitCategory();
		String caseSheetData = null;

		if (null != visitCategory && visitCategory.length() > 0) {
			switch (visitCategory) {
			case "ANC": {
				caseSheetData = getANC_PrintData(benFlowOBJ);
			}
				break;
			case "PNC": {
				caseSheetData = getPNC_PrintData(benFlowOBJ);
			}
				break;
			case "General OPD": {
				caseSheetData = getGenOPD_PrintData(benFlowOBJ);
			}
				break;
			case "NCD care": {
				caseSheetData = getNCDcare_PrintData(benFlowOBJ);
			}
				break;
			case "General OPD (QC)": {
				caseSheetData = getQC_PrintData(benFlowOBJ);
			}
				break;
			default: {
				caseSheetData = "Invalid VisitCategory";
			}
			}
		}
		return caseSheetData;
	}

	private String getANC_PrintData(BeneficiaryFlowStatus benFlowOBJ) {
		Map<String, Object> caseSheetData = new HashMap<>();

		caseSheetData.put("nurseData",
				ancServiceImpl.getBenANCNurseData(benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitID()));

		caseSheetData.put("doctorData", ancServiceImpl
				.getBenCaseRecordFromDoctorANC(benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitID()));

		caseSheetData.put("BeneficiaryData",
				getBenDetails(benFlowOBJ.getBenFlowID(), benFlowOBJ.getBeneficiaryRegID()));

		return caseSheetData.toString();
	}

	private String getCancerScreening_PrintData() {
		return null;
	}

	private String getGenOPD_PrintData(BeneficiaryFlowStatus benFlowOBJ) {
		Map<String, Object> caseSheetData = new HashMap<>();

		caseSheetData.put("nurseData", generalOPDServiceImpl
				.getBenGeneralOPDNurseData(benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitID()));

		caseSheetData.put("doctorData", generalOPDServiceImpl
				.getBenCaseRecordFromDoctorGeneralOPD(benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitID()));

		caseSheetData.put("BeneficiaryData",
				getBenDetails(benFlowOBJ.getBenFlowID(), benFlowOBJ.getBeneficiaryRegID()));

		return caseSheetData.toString();
	}

	private String getNCDcare_PrintData(BeneficiaryFlowStatus benFlowOBJ) {
		Map<String, Object> caseSheetData = new HashMap<>();

		caseSheetData.put("nurseData", ncdCareServiceImpl
				.getBenNCDCareNurseData(benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitID()));

		caseSheetData.put("doctorData", ncdCareServiceImpl
				.getBenCaseRecordFromDoctorNCDCare(benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitID()));

		caseSheetData.put("BeneficiaryData",
				getBenDetails(benFlowOBJ.getBenFlowID(), benFlowOBJ.getBeneficiaryRegID()));

		return caseSheetData.toString();
	}

	private String getPNC_PrintData(BeneficiaryFlowStatus benFlowOBJ) {
		Map<String, Object> caseSheetData = new HashMap<>();

		caseSheetData.put("nurseData",
				pncServiceImpl.getBenPNCNurseData(benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitID()));

		caseSheetData.put("doctorData", pncServiceImpl
				.getBenCaseRecordFromDoctorPNC(benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitID()));

		caseSheetData.put("BeneficiaryData",
				getBenDetails(benFlowOBJ.getBenFlowID(), benFlowOBJ.getBeneficiaryRegID()));

		return caseSheetData.toString();
	}

	private String getQC_PrintData(BeneficiaryFlowStatus benFlowOBJ) {
		Map<String, Object> caseSheetData = new HashMap<>();

		caseSheetData.put("nurseData", quickConsultationServiceImpl
				.getBenQuickConsultNurseData(benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitID()));

		caseSheetData.put("doctorData", quickConsultationServiceImpl
				.getBenCaseRecordFromDoctorQuickConsult(benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitID()));

		caseSheetData.put("BeneficiaryData",
				getBenDetails(benFlowOBJ.getBenFlowID(), benFlowOBJ.getBeneficiaryRegID()));

		return caseSheetData.toString();
	}

	private String getBenDetails(Long benFlowID, Long benRegID) {
		ArrayList<Object[]> tmpOBJ = beneficiaryFlowStatusRepo.getBenDetailsForLeftSidePanel(benRegID, benFlowID);
		BeneficiaryFlowStatus obj = BeneficiaryFlowStatus.getBeneficiaryFlowStatusForLeftPanel(tmpOBJ);
		return new Gson().toJson(obj);
	}

}
