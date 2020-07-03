package com.iemr.mmu.service.common.transaction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
import com.iemr.mmu.data.common.DocFileManager;
import com.iemr.mmu.data.nurse.CommonUtilityClass;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.provider.ProviderServiceMappingRepo;
import com.iemr.mmu.service.anc.ANCServiceImpl;
import com.iemr.mmu.service.cancerScreening.CSNurseServiceImpl;
import com.iemr.mmu.service.cancerScreening.CSServiceImpl;
import com.iemr.mmu.service.covid19.Covid19ServiceImpl;
import com.iemr.mmu.service.generalOPD.GeneralOPDServiceImpl;
import com.iemr.mmu.service.ncdCare.NCDCareServiceImpl;
import com.iemr.mmu.service.pnc.PNCServiceImpl;
import com.iemr.mmu.service.quickConsultation.QuickConsultationServiceImpl;
import com.iemr.mmu.utils.exception.IEMRException;
import com.iemr.mmu.utils.mapper.InputMapper;

@Service
@PropertySource("classpath:application.properties")
public class CommonServiceImpl implements CommonService {

	@Value("${fileBasePath}")
	private String fileBasePath;
	
	@Autowired
	private Covid19ServiceImpl covid19ServiceImpl;

	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;
	private ANCServiceImpl ancServiceImpl;
	private PNCServiceImpl pncServiceImpl;
	private GeneralOPDServiceImpl generalOPDServiceImpl;
	private NCDCareServiceImpl ncdCareServiceImpl;
	private QuickConsultationServiceImpl quickConsultationServiceImpl;
	private CommonNurseServiceImpl commonNurseServiceImpl;
	private CSNurseServiceImpl cSNurseServiceImpl;
	private CSServiceImpl csServiceImpl;
	@Autowired
	private ProviderServiceMappingRepo providerServiceMappingRepo;

	@Autowired
	public void setCsServiceImpl(CSServiceImpl csServiceImpl) {
		this.csServiceImpl = csServiceImpl;
	}

	@Autowired
	public void setcSNurseServiceImpl(CSNurseServiceImpl cSNurseServiceImpl) {
		this.cSNurseServiceImpl = cSNurseServiceImpl;
	}

	@Autowired
	public void setCommonNurseServiceImpl(CommonNurseServiceImpl commonNurseServiceImpl) {
		this.commonNurseServiceImpl = commonNurseServiceImpl;
	}

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
			case "Cancer Screening": {
				caseSheetData = getCancerScreening_PrintData(benFlowOBJ);
			}
				break;
			case "COVID-19 Screening": {
				caseSheetData = getCovid19_PrintData(benFlowOBJ);
			}
				break;
			default: {
				caseSheetData = "Invalid VisitCategory";
			}
			}
		}
		return caseSheetData;
	}

	private String getCovid19_PrintData(BeneficiaryFlowStatus benFlowOBJ) {
		Map<String, Object> caseSheetData = new HashMap<>();

		caseSheetData.put("nurseData", covid19ServiceImpl.getBenCovidNurseData(benFlowOBJ.getBeneficiaryRegID(),
				benFlowOBJ.getBenVisitCode()));

		caseSheetData.put("doctorData", covid19ServiceImpl
				.getBenCaseRecordFromDoctorCovid19(benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitCode()));

		caseSheetData.put("BeneficiaryData",
				getBenDetails(benFlowOBJ.getBenFlowID(), benFlowOBJ.getBeneficiaryRegID()));

		caseSheetData.put("serviceID", 4);

		return caseSheetData.toString();
	}

	private String getANC_PrintData(BeneficiaryFlowStatus benFlowOBJ) {
		Map<String, Object> caseSheetData = new HashMap<>();

		caseSheetData.put("nurseData",
				ancServiceImpl.getBenANCNurseData(benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitCode()));

		caseSheetData.put("doctorData", ancServiceImpl.getBenCaseRecordFromDoctorANC(benFlowOBJ.getBeneficiaryRegID(),
				benFlowOBJ.getBenVisitCode()));

		caseSheetData.put("BeneficiaryData",
				getBenDetails(benFlowOBJ.getBenFlowID(), benFlowOBJ.getBeneficiaryRegID()));

		caseSheetData.put("serviceID", 2);

		return caseSheetData.toString();
	}

	private String getCancerScreening_PrintData(BeneficiaryFlowStatus benFlowOBJ) {
		Map<String, Object> caseSheetData = new HashMap<>();

		caseSheetData.put("nurseData", csServiceImpl.getBenNurseDataForCaseSheet(benFlowOBJ.getBeneficiaryRegID(),
				benFlowOBJ.getBenVisitCode()));
		caseSheetData.put("doctorData", csServiceImpl.getBenCaseRecordFromDoctorCS(benFlowOBJ.getBeneficiaryRegID(),
				benFlowOBJ.getBenVisitCode()));

		caseSheetData.put("BeneficiaryData",
				getBenDetails(benFlowOBJ.getBenFlowID(), benFlowOBJ.getBeneficiaryRegID()));

		caseSheetData.put("ImageAnnotatedData",
				new Gson().toJson(cSNurseServiceImpl.getCancerExaminationImageAnnotationCasesheet(
						benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitCode())));

		caseSheetData.put("serviceID", 2);

		return caseSheetData.toString();
	}

	private String getGenOPD_PrintData(BeneficiaryFlowStatus benFlowOBJ) {
		Map<String, Object> caseSheetData = new HashMap<>();

		caseSheetData.put("nurseData", generalOPDServiceImpl.getBenGeneralOPDNurseData(benFlowOBJ.getBeneficiaryRegID(),
				benFlowOBJ.getBenVisitCode()));

		caseSheetData.put("doctorData", generalOPDServiceImpl
				.getBenCaseRecordFromDoctorGeneralOPD(benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitCode()));

		caseSheetData.put("BeneficiaryData",
				getBenDetails(benFlowOBJ.getBenFlowID(), benFlowOBJ.getBeneficiaryRegID()));

		caseSheetData.put("serviceID", 2);

		return caseSheetData.toString();
	}

	private String getNCDcare_PrintData(BeneficiaryFlowStatus benFlowOBJ) {
		Map<String, Object> caseSheetData = new HashMap<>();

		caseSheetData.put("nurseData", ncdCareServiceImpl.getBenNCDCareNurseData(benFlowOBJ.getBeneficiaryRegID(),
				benFlowOBJ.getBenVisitCode()));

		caseSheetData.put("doctorData", ncdCareServiceImpl
				.getBenCaseRecordFromDoctorNCDCare(benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitCode()));

		caseSheetData.put("BeneficiaryData",
				getBenDetails(benFlowOBJ.getBenFlowID(), benFlowOBJ.getBeneficiaryRegID()));

		caseSheetData.put("serviceID", 2);

		return caseSheetData.toString();
	}

	private String getPNC_PrintData(BeneficiaryFlowStatus benFlowOBJ) {
		Map<String, Object> caseSheetData = new HashMap<>();

		caseSheetData.put("nurseData",
				pncServiceImpl.getBenPNCNurseData(benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitCode()));

		caseSheetData.put("doctorData", pncServiceImpl.getBenCaseRecordFromDoctorPNC(benFlowOBJ.getBeneficiaryRegID(),
				benFlowOBJ.getBenVisitCode()));

		caseSheetData.put("BeneficiaryData",
				getBenDetails(benFlowOBJ.getBenFlowID(), benFlowOBJ.getBeneficiaryRegID()));

		caseSheetData.put("serviceID", 2);

		return caseSheetData.toString();
	}

	private String getQC_PrintData(BeneficiaryFlowStatus benFlowOBJ) {
		Map<String, Object> caseSheetData = new HashMap<>();

		caseSheetData.put("nurseData", quickConsultationServiceImpl
				.getBenQuickConsultNurseData(benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitCode()));

		caseSheetData.put("doctorData", quickConsultationServiceImpl.getBenCaseRecordFromDoctorQuickConsult(
				benFlowOBJ.getBeneficiaryRegID(), benFlowOBJ.getBenVisitCode()));

		caseSheetData.put("BeneficiaryData",
				getBenDetails(benFlowOBJ.getBenFlowID(), benFlowOBJ.getBeneficiaryRegID()));

		caseSheetData.put("serviceID", 2);

		return caseSheetData.toString();
	}

		private String getBenDetails(Long benFlowID, Long benRegID) {
		ArrayList<Object[]> tmpOBJ = beneficiaryFlowStatusRepo.getBenDetailsForLeftSidePanel(benRegID, benFlowID);
		BeneficiaryFlowStatus obj = BeneficiaryFlowStatus.getBeneficiaryFlowStatusForLeftPanel(tmpOBJ);
		return new Gson().toJson(obj);
	}

	// ------- Fetch beneficiary all past history data ------------------
	public String getBenPastHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPastMedicalHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all past history data ----------

	// ------- Fetch beneficiary all Comorbid conditions history data
	// ------------------
	public String getComorbidHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenComorbidityHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Comorbid conditions history data
	/// --------

	// ------- Fetch beneficiary all Medication history data -----------
	public String getMedicationHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPersonalMedicationHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Medication history data --

	// ------- Fetch beneficiary all Personal Tobacco history data
	// ---------------
	public String getPersonalTobaccoHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPersonalTobaccoHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Personal Tobacco history data------

	// ------- Fetch beneficiary all Personal Alcohol history data
	// ---------------
	public String getPersonalAlcoholHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPersonalAlcoholHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Personal Alcohol history data
	/// ------

	// ------- Fetch beneficiary all Personal Allergy history data
	// ---------------
	public String getPersonalAllergyHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPersonalAllergyHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Personal Allergy history data------

	// ------- Fetch beneficiary all Family history data ---------------
	public String getFamilyHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPersonalFamilyHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Family history data ------

	// ------- Fetch beneficiary all Menstrual history data -----------
	public String getMenstrualHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenMenstrualHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Menstrual history data --

	// ------- Fetch beneficiary all past obstetric history data ---------------
	public String getObstetricHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPastObstetricHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all past obstetric history data ------

	// ------- Fetch beneficiary all Immunization history data ---------------
	public String getImmunizationHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenImmunizationHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Immunization history data ------

	// ------- Fetch beneficiary all Child Vaccine history data ---------------
	public String getChildVaccineHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenOptionalVaccineHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Child Vaccine history data ------

	// ------- Fetch beneficiary all Perinatal history data ---------------
	public String getBenPerinatalHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPerinatalHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Perinatal history data ------

	// ------- Fetch beneficiary all Feeding history data ---------------
	public String getBenFeedingHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenFeedingHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Feeding history data ------

	// ------- Fetch beneficiary all Development history data ---------------
	public String getBenDevelopmentHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenDevelopmentHistory(beneficiaryRegID);
	}

	// -- Fetch beneficiary previous visit details for case-record ---
	/**
	 * date : 08-09-2018
	 * 
	 * @throws IEMRException
	 */
	public String getBenPreviousVisitDataForCaseRecord(String comingRequest) throws IEMRException {
		CommonUtilityClass obj = InputMapper.gson().fromJson(comingRequest, CommonUtilityClass.class);
		// List<Short> flagList = new ArrayList<>();
		// flagList.add((short) 9);
		// flagList.add((short) 3);

		List<Integer> psmIDList = providerServiceMappingRepo.getProviderServiceMapIdForServiceID((short) 2);
		psmIDList.add(0);
		ArrayList<Object[]> resultList = beneficiaryFlowStatusRepo.getBenPreviousHistory(obj.getBeneficiaryRegID(),
				psmIDList);

		return new Gson().toJson(BeneficiaryFlowStatus.getBeneficiaryPastVisitHistory(resultList));
	}

	// end of Fetch beneficiary previous visit details for case-record

	// files upload/save start
	@Override
	public String saveFiles(List<DocFileManager> docFileManagerList) throws IOException {
		ArrayList<Map<String, String>> responseList = new ArrayList<>();
		// this will come from property file
		// String basePath = "C:/apps/Neeraj/mmuDoc";
		String basePath = fileBasePath;

		String currDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

		if (docFileManagerList.size() > 0) {
			basePath += docFileManagerList.get(0).getVanID();
			File file = new File(basePath + "/" + currDate);

			if (file.isDirectory()) {
				responseList = createFile(docFileManagerList, basePath, currDate);
			} else {
				// create a new directory
				Files.createDirectories(Paths.get(basePath + "/" + currDate));
				responseList = createFile(docFileManagerList, basePath, currDate);
			}
		}

		return new Gson().toJson(responseList);
	}

	private ArrayList<Map<String, String>> createFile(List<DocFileManager> docFileManagerList, String basePath,
			String currDate) throws IOException {
		ArrayList<Map<String, String>> responseList = new ArrayList<>();
		Map<String, String> responseMap;

		for (DocFileManager dFM : docFileManagerList) {
			if (dFM.getFileName() != null && dFM.getFileExtension() != null) {
				responseMap = new HashMap<>();
				dFM.setFileName(dFM.getFileName().replace("`", "").replace("'", "").replace("$", "").replace("\\", "")
						.replace("/", "").replace("~", "").replace("`", "").replace("!", "").replace("@", "")
						.replace("#", "").replace("$", "").replace("%", "").replace("^", "").replace("&", "")
						.replace("*", "").replace("(", "").replace(")", "").replace("{", "").replace("}", "")
						.replace("[", "").replace("]", "").replace("|", "").replace("\\", "").replace(":", "")
						.replace(";", "").replace("-", "").replace("_", "").replace("+", "").replace("=", "")
						.replace("\"", "").replace("'", ""));

				Long currTimestamp = System.currentTimeMillis();
				FileOutputStream FOS = new FileOutputStream(
						basePath + "/" + currDate + "/" + currTimestamp + dFM.getFileName());

				FOS.write(Base64.getDecoder().decode(dFM.getFileContent()));

				responseMap.put("fileName", dFM.getFileName());
				responseMap.put("filePath", basePath + "/" + currDate + "/" + currTimestamp + dFM.getFileName());
//						+ System.currentTimeMillis() + dFM.getFileExtension());
//				returnOBJ[i] = basePath + "/" + currDate + "/" + dFM.getFileName() + System.currentTimeMillis()
//						+ dFM.getFileExtension();

				FOS.flush();
				FOS.close();
				responseList.add(responseMap);
			}
		}
		return responseList;
	}

	// load file as resource
	@Override
	public Resource loadFileAsResource(String file, String path) throws IOException {
		try {
			Path filePath = Paths.get(path).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists())
				return resource;
			else
				throw new FileNotFoundException();
		} catch (Exception e) {
			throw new FileNotFoundException();
		}
	}

	// End files upload/save start
}
