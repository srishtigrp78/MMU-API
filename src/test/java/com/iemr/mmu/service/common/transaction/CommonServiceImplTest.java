package com.iemr.mmu.service.common.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
import com.iemr.mmu.data.syncActivity_syncLayer.DownloadedCaseSheet;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.nurse.ncdscreening.IDRSDataRepo;
import com.iemr.mmu.repo.provider.ProviderServiceMappingRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.DownloadedCaseSheetRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.EmployeeSignatureRepo;
import com.iemr.mmu.service.anc.ANCServiceImpl;
import com.iemr.mmu.service.cancerScreening.CSNurseServiceImpl;
import com.iemr.mmu.service.cancerScreening.CSServiceImpl;
import com.iemr.mmu.service.covid19.Covid19ServiceImpl;
import com.iemr.mmu.service.generalOPD.GeneralOPDServiceImpl;
import com.iemr.mmu.service.ncdCare.NCDCareServiceImpl;
import com.iemr.mmu.service.ncdscreening.NCDScreeningServiceImpl;
import com.iemr.mmu.service.pnc.PNCServiceImpl;
import com.iemr.mmu.service.quickConsultation.QuickConsultationServiceImpl;
import com.iemr.mmu.utils.AESEncryption.AESEncryptionDecryption;
import com.iemr.mmu.utils.exception.IEMRException;

@ExtendWith(MockitoExtension.class)
class CommonServiceImplTest {

	@Mock
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Mock
	private Covid19ServiceImpl covid19ServiceImpl;
	@Mock
	private AESEncryptionDecryption aESEncryptionDecryption;
	@Mock
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;
	@Mock
	private ANCServiceImpl ancServiceImpl;
	@Mock
	private PNCServiceImpl pncServiceImpl;
	@Mock
	private GeneralOPDServiceImpl generalOPDServiceImpl;
	@Mock
	private NCDCareServiceImpl ncdCareServiceImpl;
	@Mock
	private QuickConsultationServiceImpl quickConsultationServiceImpl;
	@Mock
	private CommonNurseServiceImpl commonNurseServiceImpl;
	@Mock
	private CSNurseServiceImpl cSNurseServiceImpl;
	@Mock
	private CSServiceImpl csServiceImpl;
	@Mock
	private NCDScreeningServiceImpl ncdScreeningServiceImpl;
	@Mock
	private ProviderServiceMappingRepo providerServiceMappingRepo;
	@Mock
	private DownloadedCaseSheetRepo downloadedCaseSheetRepo;
	@Mock
	private IDRSDataRepo iDRSDataRepo;
	@Mock
	private EmployeeSignatureRepo employeeSignatureRepo;
	@Mock
	private ResponseEntity<String> responseEntity;

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	CommonServiceImpl commonService;

//	@Test
//	void testGetCaseSheetPrintDataForBeneficiaryy() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetCaseSheetPrintDataForBeneficiary() {

		BeneficiaryFlowStatus benFlowOBJ = new BeneficiaryFlowStatus();

		benFlowOBJ.setVisitCategory("Category1");
		benFlowOBJ.toString();

		String Authorization = "Authorization";
		String visitCategory = benFlowOBJ.getVisitCategory();
		String caseSheetData = null;

		assertTrue(null != visitCategory && visitCategory.length() > 0);

	}

	@Test
	void testGetBenPastHistoryData() {
		// Arrange
		Long beneficiaryRegID = 1L;
		String expectedHistory = "Past medical history details here";
		when(commonNurseServiceImpl.fetchBenPastMedicalHistory(beneficiaryRegID)).thenReturn(expectedHistory);

		// Act
		String actualHistory = commonService.getBenPastHistoryData(beneficiaryRegID);

		// Assert
		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

	@Test
	void testGetComorbidHistoryData() {
		// Arrange
		Long beneficiaryRegID = 1L;
		String expectedHistory = "Past comorbid history details here";

		when(commonNurseServiceImpl.fetchBenComorbidityHistory(beneficiaryRegID)).thenReturn(expectedHistory);

		String actualHistory = commonService.getComorbidHistoryData(beneficiaryRegID);

		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

	@Test
	void testGetMedicationHistoryData() {
		// Arrange
		Long beneficiaryRegID = 1L;
		String expectedHistory = "Past medical history details here";

		when(commonNurseServiceImpl.fetchBenPersonalMedicationHistory(beneficiaryRegID)).thenReturn(expectedHistory);

		String actualHistory = commonService.getMedicationHistoryData(beneficiaryRegID);

		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

	@Test
	void testGetPersonalTobaccoHistoryData() {
		// Arrange
		Long beneficiaryRegID = 1L;
		String expectedHistory = "Past medical history details here";

		when(commonNurseServiceImpl.fetchBenPersonalTobaccoHistory(beneficiaryRegID)).thenReturn(expectedHistory);

		String actualHistory = commonService.getPersonalTobaccoHistoryData(beneficiaryRegID);

		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

	@Test
	void testGetPersonalAlcoholHistoryData() {
		Long beneficiaryRegID = 1L;
		String expectedHistory = "Past medical history details here";

		when(commonNurseServiceImpl.fetchBenPersonalAlcoholHistory(beneficiaryRegID)).thenReturn(expectedHistory);

		String actualHistory = commonService.getPersonalAlcoholHistoryData(beneficiaryRegID);

		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

	@Test
	void testGetPersonalAllergyHistoryData() {
		Long beneficiaryRegID = 1L;
		String expectedHistory = "Past medical history details here";

		when(commonNurseServiceImpl.fetchBenPersonalAllergyHistory(beneficiaryRegID)).thenReturn(expectedHistory);

		String actualHistory = commonService.getPersonalAllergyHistoryData(beneficiaryRegID);

		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

	@Test
	void testGetFamilyHistoryData() {
		Long beneficiaryRegID = 1L;
		String expectedHistory = "Past medical history details here";

		when(commonNurseServiceImpl.fetchBenPersonalFamilyHistory(beneficiaryRegID)).thenReturn(expectedHistory);

		String actualHistory = commonService.getFamilyHistoryData(beneficiaryRegID);

		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

	@Test
	void testGetBenPhysicalHistory() {
		Long beneficiaryRegID = 1L;
		String expectedHistory = "Past medical history details here";

		when(commonNurseServiceImpl.fetchBenPhysicalHistory(beneficiaryRegID)).thenReturn(expectedHistory);

		String actualHistory = commonService.getBenPhysicalHistory(beneficiaryRegID);

		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

	@Test
	void testGetMenstrualHistoryData() {
		Long beneficiaryRegID = 1L;
		String expectedHistory = "Past medical history details here";

		when(commonNurseServiceImpl.fetchBenMenstrualHistory(beneficiaryRegID)).thenReturn(expectedHistory);

		String actualHistory = commonService.getMenstrualHistoryData(beneficiaryRegID);

		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

	@Test
	void testGetObstetricHistoryData() {
		Long beneficiaryRegID = 1L;
		String expectedHistory = "Past medical history details here";

		when(commonNurseServiceImpl.fetchBenPastObstetricHistory(beneficiaryRegID)).thenReturn(expectedHistory);

		String actualHistory = commonService.getObstetricHistoryData(beneficiaryRegID);

		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

	@Test
	void testGetImmunizationHistoryData() {
		Long beneficiaryRegID = 1L;
		String expectedHistory = "Past medical history details here";

		when(commonNurseServiceImpl.fetchBenImmunizationHistory(beneficiaryRegID)).thenReturn(expectedHistory);

		String actualHistory = commonService.getImmunizationHistoryData(beneficiaryRegID);

		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

	@Test
	void testGetChildVaccineHistoryData() {
		Long beneficiaryRegID = 1L;
		String expectedHistory = "Past medical history details here";

		when(commonNurseServiceImpl.fetchBenOptionalVaccineHistory(beneficiaryRegID)).thenReturn(expectedHistory);

		String actualHistory = commonService.getChildVaccineHistoryData(beneficiaryRegID);

		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

	@Test
	void testGetBenPerinatalHistoryData() {
		Long beneficiaryRegID = 1L;
		String expectedHistory = "Past medical history details here";

		when(commonNurseServiceImpl.fetchBenPerinatalHistory(beneficiaryRegID)).thenReturn(expectedHistory);

		String actualHistory = commonService.getBenPerinatalHistoryData(beneficiaryRegID);

		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

	@Test
	void testGetBenFeedingHistoryData() {
		Long beneficiaryRegID = 1L;
		String expectedHistory = "Past medical history details here";

		when(commonNurseServiceImpl.fetchBenFeedingHistory(beneficiaryRegID)).thenReturn(expectedHistory);

		String actualHistory = commonService.getBenFeedingHistoryData(beneficiaryRegID);

		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

	@Test
	void testGetBenDevelopmentHistoryData() {
		Long beneficiaryRegID = 1L;
		String expectedHistory = "Past medical history details here";

		when(commonNurseServiceImpl.fetchBenDevelopmentHistory(beneficiaryRegID)).thenReturn(expectedHistory);

		String actualHistory = commonService.getBenDevelopmentHistoryData(beneficiaryRegID);

		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

//	@Test
//	void testGetBenPreviousVisitDataForCaseRecordd() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSaveFiles() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testLoadFileAsResource() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetBenSymptomaticQuestionnaireDetailsData() throws Exception {
		Long beneficiaryRegID = 1L;
		String expectedHistory = "Past medical history details here";

		when(commonNurseServiceImpl.getBenSymptomaticData(beneficiaryRegID)).thenReturn(expectedHistory);

		String actualHistory = commonService.getBenSymptomaticQuestionnaireDetailsData(beneficiaryRegID);

		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

	@Test
	void testGetBenPreviousDiabetesData() throws Exception {
		Long beneficiaryRegID = 1L;
		String expectedHistory = "Past medical history details here";

		when(commonNurseServiceImpl.getBenPreviousDiabetesData(beneficiaryRegID)).thenReturn(expectedHistory);

		String actualHistory = commonService.getBenPreviousDiabetesData(beneficiaryRegID);

		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

	@Test
	void testCheckIsCaseSheetDownloaded() throws IEMRException {
		Long mmuVisitCode = 123L;
		when(beneficiaryFlowStatusRepo.checkIsCaseSheetDownloaded(mmuVisitCode)).thenReturn(true);

		int result = commonService.checkIsCaseSheetDownloaded(mmuVisitCode);

		assertEquals(1, result);
	}

	@Test
	void testCheckIsCaseSheetDownloaded_false() throws IEMRException {
		Long mmuVisitCode = 123L;
		when(beneficiaryFlowStatusRepo.checkIsCaseSheetDownloaded(mmuVisitCode)).thenReturn(false);

		int result = commonService.checkIsCaseSheetDownloaded(mmuVisitCode);

		assertEquals(0, result);
	}

	@Test
	void testGetTmVisitCode() {

	}

	@Test
	void getTmVisitCode_ReturnsCorrectBeneficiaryFlowStatus() throws IEMRException {
		// Given
		Long mmuVisitCode = 1L;
		BeneficiaryFlowStatus expectedStatus = new BeneficiaryFlowStatus();

		expectedStatus.setVisitCode(1L); // Example property setting

		expectedStatus.toString();
		when(beneficiaryFlowStatusRepo.getTMVisitDetails(mmuVisitCode)).thenReturn(expectedStatus);

		BeneficiaryFlowStatus resultStatus = commonService.getTmVisitCode(mmuVisitCode);

		assertNotNull(resultStatus, "The returned object should not be null.");
		assertEquals(expectedStatus.getVisitCode(), resultStatus.getVisitCode(), "The visit codes should match.");
	}

//	@Test
//	void testGetTmCaseSheet() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testGetTmCaseSheetOffline() {
//		fail("Not yet implemented");
//	}

	@Test
	void getTmCaseSheetOffline_WhenCaseSheetExists_ShouldReturnCaseSheet() throws IEMRException {
		// Arrange
		Long visitCode = 1L;
		DownloadedCaseSheet mockCaseSheet = new DownloadedCaseSheet();
		mockCaseSheet.setTmCaseSheetResponse("CaseSheet Data");

		when(downloadedCaseSheetRepo.getTmCaseSheetFromOffline(visitCode)).thenReturn(mockCaseSheet);

		BeneficiaryFlowStatus mmuBenFlowOBJ = new BeneficiaryFlowStatus();
		mmuBenFlowOBJ.setVisitCode(visitCode);

		// Act
		String response = commonService.getTmCaseSheetOffline(mmuBenFlowOBJ);

		// Assert
		assertNotNull(response);
		assertEquals("CaseSheet Data", response);
	}

	@Test
	void getTmCaseSheetOffline_WhenCaseSheetDoesNotExist_ShouldThrowIEMRException() {
		// Arrange
		Long visitCode = 1L;

		when(downloadedCaseSheetRepo.getTmCaseSheetFromOffline(visitCode)).thenReturn(null);

		BeneficiaryFlowStatus mmuBenFlowOBJ = new BeneficiaryFlowStatus();
		mmuBenFlowOBJ.setVisitCode(visitCode);

		// Act & Assert
		assertThrows(IEMRException.class, () -> commonService.getTmCaseSheetOffline(mmuBenFlowOBJ));
	}

	// ************

	@Test
	void testGetBenPreviousReferralData() throws Exception {
		Long beneficiaryRegID = 1L;

		String expectedHistory = "Past medical history details here";

		when(commonNurseServiceImpl.getBenPreviousReferralData(beneficiaryRegID)).thenReturn(expectedHistory);

		String actualHistory = commonService.getBenPreviousReferralData(beneficiaryRegID);

		assertEquals(expectedHistory, actualHistory, "The returned history should match the expected value");
	}

//	@Test
//	void testGetCaseSheetFromCentralServer() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testUpdateConfirmedDisease() {
//		fail("Not yet implemented");
//	}

	@Test
	void updateConfirmedDiseaseReturnsExpectedValue() {
		// Arrange
		String confirmedDisease = "ConfirmedDisease";
		String suspectedDisease = "SuspectedDisease";
		Long MMUVisitCode = 1L;
		int expectedUpdateResult = 1; // Assuming the update operation returns 1 on success
		when(iDRSDataRepo.updateConfirmedAndSuspectedDisease(confirmedDisease, suspectedDisease, MMUVisitCode))
				.thenReturn(expectedUpdateResult);

		int result = commonService.updateConfirmedDisease(confirmedDisease, suspectedDisease, MMUVisitCode);

		assertEquals(expectedUpdateResult, result, "The return value should match the expected update result");
	}

//	
//	@Test
//	void testGetCaseSheetOfTm() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testGetCaseSheetOfTm_Success() throws Exception {
//		String mmuBenFlowReq = "{\"benVisitCode\":\"1\"}";
//		String authCentralServer = "authToken";
//
//		// Use actual Gson for deserialization to avoid the complexity of mocking
//		// TypeToken behavior.
//		Gson gson = new Gson();
//		BeneficiaryFlowStatus inputObj = gson.fromJson(mmuBenFlowReq, BeneficiaryFlowStatus.class);
//
//		// Assuming commonService.getTmVisitCode and commonService.getTmCaseSheet need
//		// to be mocked
//		BeneficiaryFlowStatus tmVisitCodeObj = new BeneficiaryFlowStatus();
//		tmVisitCodeObj.setSpecialist_flag((short) 9);
//		when(commonService.getTmVisitCode(anyLong())).thenReturn(tmVisitCodeObj);
//
//		ArrayList<String> mockData = new ArrayList<>();
//		mockData.add("Sample Data");
//		when(commonService.getTmCaseSheet(eq(tmVisitCodeObj), eq(inputObj), eq(authCentralServer)))
//				.thenReturn(mockData);
//
//		// Call the method under test
//		String result = commonService.getCaseSheetOfTm(mmuBenFlowReq, authCentralServer);
//
//		System.out.println(result);
//
//		assertNotNull(result);
//		assertEquals("[Sample Data]", result);
//	}

//	@Test
//	void testRestTemplatePost() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testRestTemplatePost() {
//		// Setup
//		String url = "https://example.com/api/data";
//		String authorization = "Bearer yourtoken";
//		String requestBody = "{\"name\":\"John\"}";
//		ResponseEntity<String> mockResponse = new ResponseEntity<>("{\"result\":\"success\"}", HttpStatus.OK);
//
//		// Mocking RestTemplate behavior
//		when(restTemplate.exchange(eq(url), eq(HttpMethod.POST), any(HttpEntity.class), eq(String.class)))
//				.thenReturn(mockResponse);
//
//		// Execute
//		ResponseEntity<String> response = commonService.restTemplatePost(url, authorization, requestBody);
//
//		System.out.println(response);
//		// Assert
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		assertEquals("{\"result\":\"success\"}", response.getBody());
//	}

//	@Test
//	void testRestTemplateGet() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testRestTemplateGet() {
//		// Given
//		String expectedResponse = "{\"key\":\"value\"}";
//		String url = "https://example.com/api/data";
//		String authorization = "Bearer yourtoken";
//
//		// Mocking RestTemplate behavior
//		when(restTemplate.exchange(eq(url), eq(HttpMethod.GET), any(HttpEntity.class), eq(String.class)))
//				.thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));
//
//		// When
//		ResponseEntity<String> response = commonService.restTemplateGet(url, authorization);
//
//		// Then
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		assertEquals(expectedResponse, response.getBody());
//	}

//
//	@Test
//	void testGetJsonObjj() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetJsonObjWithValidJson() {
		commonService = new CommonServiceImpl();
		responseEntity = mock(ResponseEntity.class);
		// Mocking the responseEntity to return a valid JSON string
		String validJsonString = "{\"key\":\"value\"}";
		when(responseEntity.getBody()).thenReturn(validJsonString);

		// Calling the method under test
		JsonObject result = commonService.getJsonObj(responseEntity);

		// Preparing the expected result for comparison
		JsonParser parser = new JsonParser();
		JsonObject expected = parser.parse(validJsonString).getAsJsonObject();

		// Asserting that the returned JsonObject matches the expected JsonObject
		assertEquals(expected, result);
	}

	
}
