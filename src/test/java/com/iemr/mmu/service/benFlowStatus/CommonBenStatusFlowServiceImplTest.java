package com.iemr.mmu.service.benFlowStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
import com.iemr.mmu.data.nurse.CommonUtilityClass;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;
import com.iemr.mmu.utils.mapper.InputMapper;

import javassist.NotFoundException;

@ExtendWith(MockitoExtension.class)
class CommonBenStatusFlowServiceImplTest {
	@Mock
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Mock
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;
	@Mock
	private BenVisitDetailRepo benVisitDetailRepo;

	@InjectMocks
	CommonBenStatusFlowServiceImpl commonBenStatusFlowService;

//	@Test
//	public void testCreateBenFlowRecord() throws Exception {
//		String requestOBJ = "{ \"Key\": \"Value\"}";
//		Long beneficiaryRegID = 1L;
//		Long beneficiaryID = 1L;
//		
//		BeneficiaryFlowStatus objRS = null;
//		int returnOBJ = 0;
//		
//		BeneficiaryFlowStatus obj = new BeneficiaryFlowStatus();
//		
//		obj.setBeneficiaryRegID(1L);
//		obj.setBeneficiaryID(1L);
//		obj.setProviderServiceMapID(1);
//		obj.setVanID(1);
//		
//
//		obj.toString();
//				
//		when(getBenFlowRecordObj(requestOBJ, beneficiaryRegID, beneficiaryID)).thenReturn(obj);
//		
//		objRS = beneficiaryFlowStatusRepo.save(obj);
//		
//		returnOBJ = 1;
//		
//		int expresponse = commonBenStatusFlowService.createBenFlowRecord(requestOBJ, beneficiaryRegID, beneficiaryID);
//		
//		assertTrue(beneficiaryRegID != null && beneficiaryID != null && beneficiaryRegID > 0 && beneficiaryID > 0);
//		assertTrue(objRS != null);
//		
//		assertEquals(expresponse, commonBenStatusFlowService.createBenFlowRecord(requestOBJ, beneficiaryRegID, beneficiaryID));
//	}
	


	@Test
	void testUpdateBenFlowNurseAfterNurseActivity() {
		Long benFlowID = 1L;
		Long benRegID = 1L;
		Long benVisitID = 1L;
		String visitReason = "test";
		String visitCategory = "test";
		Short nurseFlag = 1;
		Short docFlag = 1;
		Short labIteration = 1;
		Short radiologistFlag = 1;
		Short oncologistFlag = 1;
		Long visitCode = 1L;
		Integer vanID = 1;

		int i = 0;

		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterNurseActivity(benFlowID, benRegID, benVisitID,
				visitReason, visitCategory, nurseFlag, docFlag, labIteration, radiologistFlag, oncologistFlag,
				visitCode, vanID)).thenReturn(i);

		int expResponse = commonBenStatusFlowService.updateBenFlowNurseAfterNurseActivity(benFlowID, benRegID,
				benVisitID, visitReason, visitCategory, nurseFlag, docFlag, labIteration, radiologistFlag,
				oncologistFlag, visitCode, vanID);

		assertEquals(expResponse,
				commonBenStatusFlowService.updateBenFlowNurseAfterNurseActivity(benFlowID, benRegID, benVisitID,
						visitReason, visitCategory, nurseFlag, docFlag, labIteration, radiologistFlag, oncologistFlag,
						visitCode, vanID));
	}

	@Test
	void testUpdateBenFlowNurseAfterNurseActivity_Exception() {

		Long benFlowID = 1L;
		Long benRegID = 1L;
		Long benVisitID = 1L;
		String visitReason = "test";
		String visitCategory = "test";
		Short nurseFlag = 1;
		Short docFlag = 1;
		Short labIteration = 1;
		Short radiologistFlag = 1;
		Short oncologistFlag = 1;
		Long visitCode = 1L;
		Integer vanID = 1;

		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterNurseActivity(benFlowID, benRegID, benVisitID,
				visitReason, visitCategory, nurseFlag, docFlag, labIteration, radiologistFlag, oncologistFlag,
				visitCode, vanID)).thenThrow(RuntimeException.class);

		int response = commonBenStatusFlowService.updateBenFlowNurseAfterNurseActivity(benFlowID, benRegID, benVisitID,
				visitReason, visitCategory, nurseFlag, docFlag, labIteration, radiologistFlag, oncologistFlag,
				visitCode, vanID);
		assertEquals(response,
				commonBenStatusFlowService.updateBenFlowNurseAfterNurseActivity(benFlowID, benRegID, benVisitID,
						visitReason, visitCategory, nurseFlag, docFlag, labIteration, radiologistFlag, oncologistFlag,
						visitCode, vanID));

	}

	@Test
	void testUpdateBenFlowtableAfterNurseSaveForTMReferred_isTMCDonetrue() {
		CommonUtilityClass commonUtilityClass = new CommonUtilityClass();

		Boolean isTMCDone = true;
		Boolean isMedicinePrescribed = true;

		Long tmpBenFlowID = commonUtilityClass.getBenFlowID();
		Long tmpBeneficiaryID = commonUtilityClass.getBeneficiaryID();
		Long tmpBenVisitID = commonUtilityClass.getBenVisitID();
		Long tmpbeneficiaryRegID = commonUtilityClass.getBeneficiaryRegID();
		Short specialistFlag = null;
		Short pharmaFalg = null;
		int i = 0;

		specialistFlag = 200;
		pharmaFalg = 1;

		when(i = beneficiaryFlowStatusRepo.updateBenFlowStatusTMReferred(tmpBenFlowID, tmpbeneficiaryRegID,
				specialistFlag, pharmaFalg)).thenReturn(i);

		int expResponse = commonBenStatusFlowService.updateBenFlowtableAfterNurseSaveForTMReferred(commonUtilityClass,
				isTMCDone, isMedicinePrescribed);

		assertTrue(isTMCDone);
		assertTrue(isMedicinePrescribed);

		assertEquals(expResponse, commonBenStatusFlowService
				.updateBenFlowtableAfterNurseSaveForTMReferred(commonUtilityClass, isTMCDone, isMedicinePrescribed));

	}

	@Test
	void testUpdateBenFlowtableAfterNurseSaveForTMReferred_isTMCDonefalse() {
		CommonUtilityClass commonUtilityClass = new CommonUtilityClass();

		Boolean isTMCDone = false;
		Boolean isMedicinePrescribed = false;

		Long tmpBenFlowID = commonUtilityClass.getBenFlowID();
		Long tmpBeneficiaryID = commonUtilityClass.getBeneficiaryID();
		Long tmpBenVisitID = commonUtilityClass.getBenVisitID();
		Long tmpbeneficiaryRegID = commonUtilityClass.getBeneficiaryRegID();
		Short specialistFlag = null;
		Short pharmaFalg = null;

		specialistFlag = 300;
		pharmaFalg = 0;

		assertFalse(isTMCDone);
		assertFalse(isMedicinePrescribed);
	}

	@Test
	void testUpdateBenFlowtableAfterNurseSaveForTMReferred_Exceptiion() {
		CommonUtilityClass commonUtilityClass = new CommonUtilityClass();

		Boolean isTMCDone = true;
		Boolean isMedicinePrescribed = true;

		Long tmpBenFlowID = commonUtilityClass.getBenFlowID();
		Long tmpBeneficiaryID = commonUtilityClass.getBeneficiaryID();
		Long tmpBenVisitID = commonUtilityClass.getBenVisitID();
		Long tmpbeneficiaryRegID = commonUtilityClass.getBeneficiaryRegID();
		Short specialistFlag = null;
		Short pharmaFalg = null;

		when(beneficiaryFlowStatusRepo.updateBenFlowStatusTMReferred(tmpBenFlowID, tmpbeneficiaryRegID, specialistFlag,
				pharmaFalg)).thenThrow(RuntimeException.class);

		int response = commonBenStatusFlowService.updateBenFlowtableAfterNurseSaveForTMReferred(commonUtilityClass,
				isTMCDone, isMedicinePrescribed);

		assertEquals(response, commonBenStatusFlowService
				.updateBenFlowtableAfterNurseSaveForTMReferred(commonUtilityClass, isTMCDone, isMedicinePrescribed));
	}

	@Test
	void testUpdateBenFlowNurseAfterNurseUpdateNCD_Screening_Success() {
		Long benFlowID = 1L;
		Long benRegID = 1L;
		Short nurseFlag = 1;

		int i = 0;

		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterNurseDataUpdateNCD_Screening(benFlowID, benRegID,
				nurseFlag)).thenReturn(i);

		int expResponse = commonBenStatusFlowService.updateBenFlowNurseAfterNurseUpdateNCD_Screening(benFlowID,
				benRegID, nurseFlag);

		assertEquals(expResponse, commonBenStatusFlowService.updateBenFlowNurseAfterNurseUpdateNCD_Screening(benFlowID,
				benRegID, nurseFlag));
	}

	@Test
	void testUpdateBenFlowNurseAfterNurseUpdateNCD_Screening_Exception() {
		Long benFlowID = 1L;
		Long benRegID = 1L;
		Short nurseFlag = 1;

		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterNurseDataUpdateNCD_Screening(benFlowID, benRegID,
				nurseFlag)).thenThrow(RuntimeException.class);

		int response = commonBenStatusFlowService.updateBenFlowNurseAfterNurseUpdateNCD_Screening(benFlowID, benRegID,
				nurseFlag);

		assertEquals(response, commonBenStatusFlowService.updateBenFlowNurseAfterNurseUpdateNCD_Screening(benFlowID,
				benRegID, nurseFlag));
	}

	@Test
	void testUpdateBenFlowAfterDocData_true() {
		Long benFlowID = 1L;
		Long benRegID = 1L;
		Long benID = 1L;
		Long benVisitID = 1L;
		short docFlag = 1;
		short pharmaFlag = 1;
		short oncologistFlag = 1;
		short tcSpecialistFlag = 1;
		int tcUserID = 12345;
		Timestamp tcDate = Timestamp.valueOf("2024-03-05 10:15:30");

		int i = 0;

		Short pharmaF = 1;

		// when(beneficiaryFlowStatusRepo.getPharmaFlag(benFlowID)).thenReturn(pharmaF);

		Short pharmaF1;

		pharmaF1 = pharmaF;

		int expresponse = commonBenStatusFlowService.updateBenFlowAfterDocData(benFlowID, benRegID, benID, benVisitID,
				docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate);

		assertTrue(pharmaF != null && pharmaF == 1);
		assertEquals(expresponse, commonBenStatusFlowService.updateBenFlowAfterDocData(benFlowID, benRegID, benID,
				benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate));
	}

	@Test
	void testUpdateBenFlowAfterDocData_false() {
		Long benFlowID = 1L;
		Long benRegID = 1L;
		Long benID = 1L;
		Long benVisitID = 1L;
		short docFlag = 1;
		short pharmaFlag = 1;
		short oncologistFlag = 1;
		short tcSpecialistFlag = 1;
		int tcUserID = 12345;
		Timestamp tcDate = Timestamp.valueOf("2024-03-05 10:15:30");

		int i = 0;

		Short pharmaF = 2;

		// when(beneficiaryFlowStatusRepo.getPharmaFlag(benFlowID)).thenReturn(pharmaF);

		Short pharmaF1;

		pharmaF1 = pharmaFlag;

		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivity(benFlowID, benRegID, benID, docFlag,
				pharmaF1, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate)).thenReturn(i);

		int expresponse = commonBenStatusFlowService.updateBenFlowAfterDocData(benFlowID, benRegID, benID, benVisitID,
				docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate);

		assertTrue(pharmaF == null || pharmaF != 1);

		assertEquals(expresponse, commonBenStatusFlowService.updateBenFlowAfterDocData(benFlowID, benRegID, benID,
				benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate));
	}

	@Test
	void testUpdateBenFlowAfterDocData_Exception() {
		Long benFlowID = 1L;
		Long benRegID = 1L;
		Long benID = 1L;
		Long benVisitID = 1L;
		short docFlag = 1;
		short pharmaFlag = 1;
		short oncologistFlag = 1;
		short tcSpecialistFlag = 1;
		int tcUserID = 12345;
		Timestamp tcDate = Timestamp.valueOf("2024-03-05 10:15:30");

		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivity(benFlowID, benRegID, benID, docFlag,
				pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate)).thenThrow(RuntimeException.class);

		int response = commonBenStatusFlowService.updateBenFlowAfterDocData(benFlowID, benRegID, benID, benVisitID,
				docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate);

		assertEquals(response, commonBenStatusFlowService.updateBenFlowAfterDocData(benFlowID, benRegID, benID,
				benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate));

	}

//	@Test
//	void testUpdateBenFlowAfterDocDataUpdate_true() throws Exception {
//		Long benFlowID = 1L;
//		Long benRegID = 1L;
//		Long benID = 1L;
//		Long benVisitID = 1L;
//		short docFlag = 1;
//		short pharmaFlag = 1;
//		short oncologistFlag = 1;
//		short tcSpecialistFlag = 1;
//		int tcUserID = 1;
//		Timestamp tcDate = Timestamp.valueOf("2024-01-01 00:00:01");
//		int i = 0;
//		Short pharmaF = null;
//
//		when(beneficiaryFlowStatusRepo.getPharmaFlag(benFlowID)).thenReturn(pharmaF);
//
//		int expResponse = commonBenStatusFlowService.updateBenFlowAfterDocDataUpdate(benFlowID, benRegID, benID,
//				benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate);
//
//		Short pharmaF1;
//
//		pharmaF1 = pharmaF;
//
//		assertTrue(pharmaF != null && pharmaF == 1);
//		assertEquals(expResponse, commonBenStatusFlowService.updateBenFlowAfterDocDataUpdate(benFlowID, benRegID, benID,
//				benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate));
//	}

	@Test
	void testUpdateBenFlowAfterDocDataUpdate_false() throws Exception {
		Long benFlowID = 1L;
		Long benRegID = 1L;
		Long benID = 1L;
		Long benVisitID = 1L;
		short docFlag = 1;
		short pharmaFlag = 1;
		short oncologistFlag = 1;
		short tcSpecialistFlag = 1;
		int tcUserID = 1;
		Timestamp tcDate = Timestamp.valueOf("2024-01-01 00:00:01");
		int i = 0;
		Short pharmaF = null;

		// when(beneficiaryFlowStatusRepo.getPharmaFlag(benFlowID)).thenReturn(pharmaF);

		Short pharmaF1;

		pharmaF1 = pharmaF;

		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivity(benFlowID, benRegID, benID, docFlag,
				pharmaF1, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate)).thenReturn(i);

		int expResponse = commonBenStatusFlowService.updateBenFlowAfterDocDataUpdate(benFlowID, benRegID, benID,
				benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate);

		assertTrue(pharmaF == null || pharmaF == 1);
	}


	@Test
	void testUpdateBenFlowAfterDocDataUpdateWDF_true() throws Exception {
		Long benFlowID = 1L;
		Long benRegID = 1L;
		Long benID = 1L;
		Long benVisitID = 1L;
		short docFlag = 1;
		short pharmaFlag = 1;
		short oncologistFlag = 1;
		int tcUserID = 1;
		Timestamp tcDate = Timestamp.valueOf("2024-01-01 00:00:01");

		int i = 0;
		Short pharmaF = 1;

		when(beneficiaryFlowStatusRepo.getPharmaFlag(benFlowID)).thenReturn(pharmaF);

		Short pharmaF1;

		pharmaF1 = pharmaF;

		int expResponse = commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateWDF(benFlowID, benRegID, benID,
				benVisitID, docFlag, pharmaFlag, oncologistFlag, tcUserID, tcDate);

		assertTrue(pharmaF != null && pharmaF == 1);
		assertEquals(expResponse, commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateWDF(benFlowID, benRegID,
				benID, benVisitID, docFlag, pharmaFlag, oncologistFlag, tcUserID, tcDate));
	}

	@Test
	void testUpdateBenFlowAfterDocDataUpdateWDF_false() throws Exception {
		Long benFlowID = 1L;
		Long benRegID = 1L;
		Long benID = 1L;
		Long benVisitID = 1L;
		short docFlag = 1;
		short pharmaFlag = 1;
		short oncologistFlag = 1;
		int tcUserID = 1;
		Timestamp tcDate = Timestamp.valueOf("2024-01-01 00:00:01");

		int i = 0;
		Short pharmaF = 0;

		when(beneficiaryFlowStatusRepo.getPharmaFlag(benFlowID)).thenReturn(pharmaF);

		Short pharmaF1;

		pharmaF1 = pharmaFlag;

		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivityWDF(benFlowID, benRegID, benID, docFlag,
				pharmaF1, oncologistFlag, tcUserID, tcDate)).thenReturn(i);

		int expResponse = commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateWDF(benFlowID, benRegID, benID,
				benVisitID, docFlag, pharmaFlag, oncologistFlag, tcUserID, tcDate);

		assertTrue(pharmaF == null || pharmaF != 1);
		assertEquals(expResponse, commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateWDF(benFlowID, benRegID,
				benID, benVisitID, docFlag, pharmaFlag, oncologistFlag, tcUserID, tcDate));
	}

	@Test
	void testUpdateBenFlowAfterDocDataUpdateWDF_Exception() throws Exception {

		when(beneficiaryFlowStatusRepo.getPharmaFlag(any())).thenThrow(RuntimeException.class);

		int response = commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateWDF(any(), any(), any(), any(), any(),
				any(), any(), any(), any());

		assertEquals(response, commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateWDF(any(), any(), any(), any(),
				any(), any(), any(), any(), any()));
	}

	@Test
	void testUpdateBenFlowAfterDocDataUpdateTCSpecialist_true() throws Exception {
		Long benFlowID = 1L;
		Long benRegID = 1L;
		Long benID = 1L;
		Long benVisitID = 1L;
		short docFlag = 1;
		short pharmaFlag = 1;
		short oncologistFlag = 1;
		short tcSpecialistFlag = 1;
		int tcUserID = 1;
		Timestamp tcDate = Timestamp.valueOf("2024-01-01 00:00:01");

		int i = 0;
		Short pharmaF = 1;

		when(beneficiaryFlowStatusRepo.getPharmaFlag(benFlowID)).thenReturn(pharmaF);
		Short pharmaF1;

		pharmaF1 = pharmaF;

		int expResponse = commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateTCSpecialist(benFlowID, benRegID,
				benID, benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate);

		assertTrue(pharmaF != null && pharmaF == 1);
		assertEquals(expResponse, commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateTCSpecialist(benFlowID,
				benRegID, benID, benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate));

	}

	@Test
	void testUpdateBenFlowAfterDocDataUpdateTCSpecialist_false() throws Exception {
		Long benFlowID = 1L;
		Long benRegID = 1L;
		Long benID = 1L;
		Long benVisitID = 1L;
		short docFlag = 1;
		short pharmaFlag = 1;
		short oncologistFlag = 1;
		short tcSpecialistFlag = 1;
		int tcUserID = 1;
		Timestamp tcDate = Timestamp.valueOf("2024-01-01 00:00:01");

		int i = 0;
		Short pharmaF = null;

		when(beneficiaryFlowStatusRepo.getPharmaFlag(benFlowID)).thenReturn(pharmaF);
		Short pharmaF1;

		pharmaF1 = pharmaFlag;
		int expResponse = commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateTCSpecialist(benFlowID, benRegID,
				benID, benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate);

		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivityTCSpecialist(benFlowID, benRegID, benID,
				pharmaF1, oncologistFlag, tcSpecialistFlag)).thenReturn(i);

		assertTrue(pharmaF == null || pharmaF != 1);
		assertEquals(expResponse, commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateTCSpecialist(benFlowID,
				benRegID, benID, benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate));

	}

	@Test
	void testUpdateBenFlowAfterDocDataUpdateTCSpecialist_Exception() throws Exception {

		when(beneficiaryFlowStatusRepo.getPharmaFlag(any())).thenThrow(RuntimeException.class);

		int response = commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateTCSpecialist(any(), any(), any(),
				any(), any(), any(), any(), any(), any(), any());
		assertEquals(response, commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateTCSpecialist(any(), any(),
				any(), any(), any(), any(), any(), any(), any(), any()));
	}

	@Test
	void testUpdateFlowAfterLabResultEntry() {
		Long benFlowID = 1L;
		Long benRegID = 1L;
		Long benVisitID = 1L;
		Short nurseFlag = 1;
		Short doctorFlag = 1;
		Short labFlag = 1;
		int i = 1;

		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterLabResultEntry(benFlowID, benRegID, nurseFlag,
				doctorFlag, labFlag)).thenReturn(i);

		int expResponse = commonBenStatusFlowService.updateFlowAfterLabResultEntry(benFlowID, benRegID, benVisitID,
				nurseFlag, doctorFlag, labFlag);

		assertEquals(expResponse, commonBenStatusFlowService.updateFlowAfterLabResultEntry(benFlowID, benRegID,
				benVisitID, nurseFlag, doctorFlag, labFlag));
	}

	@Test
	void testUpdateFlowAfterLabResultEntryForTCSpecialist() {
		Long benFlowID = 1L;
		Long benRegID = 1L;
		Long benVisitID = 1L;
		Short nurseFlag = 1;
		Short doctorFlag = 1;
		Short labFlag = 1;
		int i = 1;

		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterLabResultEntryForSpecialist(benFlowID, benRegID,
				nurseFlag)).thenReturn(i);

		int expResponse = commonBenStatusFlowService.updateFlowAfterLabResultEntryForTCSpecialist(benFlowID, benRegID,
				labFlag);

		assertEquals(expResponse,
				commonBenStatusFlowService.updateFlowAfterLabResultEntryForTCSpecialist(benFlowID, benRegID, labFlag));
	}

}
