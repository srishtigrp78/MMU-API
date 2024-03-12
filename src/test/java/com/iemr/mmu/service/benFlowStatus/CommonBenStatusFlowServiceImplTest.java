//package com.iemr.mmu.service.benFlowStatus;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.sql.Date;
//import java.sql.Timestamp;
//import java.time.Instant;
//import java.time.Period;
//import java.util.ArrayList;
//import java.util.Calendar;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//
//import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
//import com.iemr.mmu.data.nurse.CommonUtilityClass;
//import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
//import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;
//import com.iemr.mmu.utils.mapper.InputMapper;
//
//import javassist.NotFoundException;
//
//@ExtendWith(MockitoExtension.class)
//class CommonBenStatusFlowServiceImplTest {
//	@Mock
//	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
//	@Mock
//	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;
//	@Mock
//	private BenVisitDetailRepo benVisitDetailRepo;
//
//	@InjectMocks
//	CommonBenStatusFlowServiceImpl commonBenStatusFlowService;
//
//	@Test
//	void testUpdateBenFlowNurseAfterNurseActivity() {
//		Long benFlowID = 1L;
//		Long benRegID = 1L;
//		Long benVisitID = 1L;
//		String visitReason = "test";
//		String visitCategory = "test";
//		Short nurseFlag = 1;
//		Short docFlag = 1;
//		Short labIteration = 1;
//		Short radiologistFlag = 1;
//		Short oncologistFlag = 1;
//		Long visitCode = 1L;
//		Integer vanID = 1;
//
//		int i = 0;
//
//		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterNurseActivity(benFlowID, benRegID, benVisitID,
//				visitReason, visitCategory, nurseFlag, docFlag, labIteration, radiologistFlag, oncologistFlag,
//				visitCode, vanID)).thenReturn(i);
//
//		int expResponse = commonBenStatusFlowService.updateBenFlowNurseAfterNurseActivity(benFlowID, benRegID,
//				benVisitID, visitReason, visitCategory, nurseFlag, docFlag, labIteration, radiologistFlag,
//				oncologistFlag, visitCode, vanID);
//
//		assertEquals(expResponse,
//				commonBenStatusFlowService.updateBenFlowNurseAfterNurseActivity(benFlowID, benRegID, benVisitID,
//						visitReason, visitCategory, nurseFlag, docFlag, labIteration, radiologistFlag, oncologistFlag,
//						visitCode, vanID));
//	}
//
//	@Test
//	void testUpdateBenFlowNurseAfterNurseActivity_Exception() {
//
//		Long benFlowID = 1L;
//		Long benRegID = 1L;
//		Long benVisitID = 1L;
//		String visitReason = "test";
//		String visitCategory = "test";
//		Short nurseFlag = 1;
//		Short docFlag = 1;
//		Short labIteration = 1;
//		Short radiologistFlag = 1;
//		Short oncologistFlag = 1;
//		Long visitCode = 1L;
//		Integer vanID = 1;
//
//		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterNurseActivity(benFlowID, benRegID, benVisitID,
//				visitReason, visitCategory, nurseFlag, docFlag, labIteration, radiologistFlag, oncologistFlag,
//				visitCode, vanID)).thenThrow(RuntimeException.class);
//
//		int response = commonBenStatusFlowService.updateBenFlowNurseAfterNurseActivity(benFlowID, benRegID, benVisitID,
//				visitReason, visitCategory, nurseFlag, docFlag, labIteration, radiologistFlag, oncologistFlag,
//				visitCode, vanID);
//		assertEquals(response,
//				commonBenStatusFlowService.updateBenFlowNurseAfterNurseActivity(benFlowID, benRegID, benVisitID,
//						visitReason, visitCategory, nurseFlag, docFlag, labIteration, radiologistFlag, oncologistFlag,
//						visitCode, vanID));
//
//	}
//
//	@Test
//	void testUpdateBenFlowtableAfterNurseSaveForTMReferred_isTMCDonetrue() {
//		CommonUtilityClass commonUtilityClass = new CommonUtilityClass();
//
//		Boolean isTMCDone = true;
//		Boolean isMedicinePrescribed = true;
//
//		Long tmpBenFlowID = commonUtilityClass.getBenFlowID();
//		Long tmpBeneficiaryID = commonUtilityClass.getBeneficiaryID();
//		Long tmpBenVisitID = commonUtilityClass.getBenVisitID();
//		Long tmpbeneficiaryRegID = commonUtilityClass.getBeneficiaryRegID();
//		Short specialistFlag = null;
//		Short pharmaFalg = null;
//		int i = 0;
//
//		specialistFlag = 200;
//		pharmaFalg = 1;
//
//		when(i = beneficiaryFlowStatusRepo.updateBenFlowStatusTMReferred(tmpBenFlowID, tmpbeneficiaryRegID,
//				specialistFlag, pharmaFalg)).thenReturn(i);
//
//		int expResponse = commonBenStatusFlowService.updateBenFlowtableAfterNurseSaveForTMReferred(commonUtilityClass,
//				isTMCDone, isMedicinePrescribed);
//
//		assertTrue(isTMCDone);
//		assertTrue(isMedicinePrescribed);
//
//		assertEquals(expResponse, commonBenStatusFlowService
//				.updateBenFlowtableAfterNurseSaveForTMReferred(commonUtilityClass, isTMCDone, isMedicinePrescribed));
//
//	}
//
//	@Test
//	void testUpdateBenFlowtableAfterNurseSaveForTMReferred_isTMCDonefalse() {
//		CommonUtilityClass commonUtilityClass = new CommonUtilityClass();
//
//		Boolean isTMCDone = false;
//		Boolean isMedicinePrescribed = false;
//
//		Long tmpBenFlowID = commonUtilityClass.getBenFlowID();
//		Long tmpBeneficiaryID = commonUtilityClass.getBeneficiaryID();
//		Long tmpBenVisitID = commonUtilityClass.getBenVisitID();
//		Long tmpbeneficiaryRegID = commonUtilityClass.getBeneficiaryRegID();
//		Short specialistFlag = null;
//		Short pharmaFalg = null;
//
//		specialistFlag = 300;
//		pharmaFalg = 0;
//
//		assertFalse(isTMCDone);
//		assertFalse(isMedicinePrescribed);
//	}
//
//	@Test
//	void testUpdateBenFlowtableAfterNurseSaveForTMReferred_Exceptiion() {
//		CommonUtilityClass commonUtilityClass = new CommonUtilityClass();
//
//		Boolean isTMCDone = true;
//		Boolean isMedicinePrescribed = true;
//
//		Long tmpBenFlowID = commonUtilityClass.getBenFlowID();
//		Long tmpBeneficiaryID = commonUtilityClass.getBeneficiaryID();
//		Long tmpBenVisitID = commonUtilityClass.getBenVisitID();
//		Long tmpbeneficiaryRegID = commonUtilityClass.getBeneficiaryRegID();
//		Short specialistFlag = null;
//		Short pharmaFalg = null;
//
//		when(beneficiaryFlowStatusRepo.updateBenFlowStatusTMReferred(tmpBenFlowID, tmpbeneficiaryRegID, specialistFlag,
//				pharmaFalg)).thenThrow(RuntimeException.class);
//
//		int response = commonBenStatusFlowService.updateBenFlowtableAfterNurseSaveForTMReferred(commonUtilityClass,
//				isTMCDone, isMedicinePrescribed);
//
//		assertEquals(response, commonBenStatusFlowService
//				.updateBenFlowtableAfterNurseSaveForTMReferred(commonUtilityClass, isTMCDone, isMedicinePrescribed));
//	}
//
//	@Test
//	void testUpdateBenFlowNurseAfterNurseUpdateNCD_Screening_Success() {
//		Long benFlowID = 1L;
//		Long benRegID = 1L;
//		Short nurseFlag = 1;
//
//		int i = 0;
//
//		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterNurseDataUpdateNCD_Screening(benFlowID, benRegID,
//				nurseFlag)).thenReturn(i);
//
//		int expResponse = commonBenStatusFlowService.updateBenFlowNurseAfterNurseUpdateNCD_Screening(benFlowID,
//				benRegID, nurseFlag);
//
//		assertEquals(expResponse, commonBenStatusFlowService.updateBenFlowNurseAfterNurseUpdateNCD_Screening(benFlowID,
//				benRegID, nurseFlag));
//	}
//
//	@Test
//	void testUpdateBenFlowNurseAfterNurseUpdateNCD_Screening_Exception() {
//		Long benFlowID = 1L;
//		Long benRegID = 1L;
//		Short nurseFlag = 1;
//
//		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterNurseDataUpdateNCD_Screening(benFlowID, benRegID,
//				nurseFlag)).thenThrow(RuntimeException.class);
//
//		int response = commonBenStatusFlowService.updateBenFlowNurseAfterNurseUpdateNCD_Screening(benFlowID, benRegID,
//				nurseFlag);
//
//		assertEquals(response, commonBenStatusFlowService.updateBenFlowNurseAfterNurseUpdateNCD_Screening(benFlowID,
//				benRegID, nurseFlag));
//	}
//
//	@Test
//	void testUpdateBenFlowAfterDocData_true() {
//		Long benFlowID = 1L;
//		Long benRegID = 1L;
//		Long benID = 1L;
//		Long benVisitID = 1L;
//		short docFlag = 1;
//		short pharmaFlag = 1;
//		short oncologistFlag = 1;
//		short tcSpecialistFlag = 1;
//		int tcUserID = 12345;
//		Timestamp tcDate = Timestamp.valueOf("2024-03-05 10:15:30");
//
//		int i = 0;
//
//		Short pharmaF = 1;
//
//		// when(beneficiaryFlowStatusRepo.getPharmaFlag(benFlowID)).thenReturn(pharmaF);
//
//		Short pharmaF1;
//
//		pharmaF1 = pharmaF;
//
//		int expresponse = commonBenStatusFlowService.updateBenFlowAfterDocData(benFlowID, benRegID, benID, benVisitID,
//				docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate);
//
//		assertTrue(pharmaF != null && pharmaF == 1);
//		assertEquals(expresponse, commonBenStatusFlowService.updateBenFlowAfterDocData(benFlowID, benRegID, benID,
//				benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate));
//	}
//
//	@Test
//	void testUpdateBenFlowAfterDocData_false() {
//		Long benFlowID = 1L;
//		Long benRegID = 1L;
//		Long benID = 1L;
//		Long benVisitID = 1L;
//		short docFlag = 1;
//		short pharmaFlag = 1;
//		short oncologistFlag = 1;
//		short tcSpecialistFlag = 1;
//		int tcUserID = 12345;
//		Timestamp tcDate = Timestamp.valueOf("2024-03-05 10:15:30");
//
//		int i = 0;
//
//		Short pharmaF = 2;
//
//		// when(beneficiaryFlowStatusRepo.getPharmaFlag(benFlowID)).thenReturn(pharmaF);
//
//		Short pharmaF1;
//
//		pharmaF1 = pharmaFlag;
//
//		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivity(benFlowID, benRegID, benID, docFlag,
//				pharmaF1, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate)).thenReturn(i);
//
//		int expresponse = commonBenStatusFlowService.updateBenFlowAfterDocData(benFlowID, benRegID, benID, benVisitID,
//				docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate);
//
//		assertTrue(pharmaF == null || pharmaF != 1);
//
//		assertEquals(expresponse, commonBenStatusFlowService.updateBenFlowAfterDocData(benFlowID, benRegID, benID,
//				benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate));
//	}
//
//	@Test
//	void testUpdateBenFlowAfterDocData_Exception() {
//		Long benFlowID = 1L;
//		Long benRegID = 1L;
//		Long benID = 1L;
//		Long benVisitID = 1L;
//		short docFlag = 1;
//		short pharmaFlag = 1;
//		short oncologistFlag = 1;
//		short tcSpecialistFlag = 1;
//		int tcUserID = 12345;
//		Timestamp tcDate = Timestamp.valueOf("2024-03-05 10:15:30");
//
//		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivity(benFlowID, benRegID, benID, docFlag,
//				pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate)).thenThrow(RuntimeException.class);
//
//		int response = commonBenStatusFlowService.updateBenFlowAfterDocData(benFlowID, benRegID, benID, benVisitID,
//				docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate);
//
//		assertEquals(response, commonBenStatusFlowService.updateBenFlowAfterDocData(benFlowID, benRegID, benID,
//				benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate));
//
//	}
//
////	@Test
////	void testUpdateBenFlowAfterDocDataUpdate_true() throws Exception {
////		Long benFlowID = 1L;
////		Long benRegID = 1L;
////		Long benID = 1L;
////		Long benVisitID = 1L;
////		short docFlag = 1;
////		short pharmaFlag = 1;
////		short oncologistFlag = 1;
////		short tcSpecialistFlag = 1;
////		int tcUserID = 1;
////		Timestamp tcDate = Timestamp.valueOf("2024-01-01 00:00:01");
////		int i = 0;
////		Short pharmaF = null;
////
////		when(beneficiaryFlowStatusRepo.getPharmaFlag(benFlowID)).thenReturn(pharmaF);
////
////		int expResponse = commonBenStatusFlowService.updateBenFlowAfterDocDataUpdate(benFlowID, benRegID, benID,
////				benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate);
////
////		Short pharmaF1;
////
////		pharmaF1 = pharmaF;
////
////		assertTrue(pharmaF != null && pharmaF == 1);
////		assertEquals(expResponse, commonBenStatusFlowService.updateBenFlowAfterDocDataUpdate(benFlowID, benRegID, benID,
////				benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate));
////	}
//
//	@Test
//	void testUpdateBenFlowAfterDocDataUpdate_false() throws Exception {
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
//		// when(beneficiaryFlowStatusRepo.getPharmaFlag(benFlowID)).thenReturn(pharmaF);
//
//		Short pharmaF1;
//
//		pharmaF1 = pharmaF;
//
//		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivity(benFlowID, benRegID, benID, docFlag,
//				pharmaF1, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate)).thenReturn(i);
//
//		int expResponse = commonBenStatusFlowService.updateBenFlowAfterDocDataUpdate(benFlowID, benRegID, benID,
//				benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate);
//
//		assertTrue(pharmaF == null || pharmaF == 1);
//	}
//
//
//	@Test
//	void testUpdateBenFlowAfterDocDataUpdateWDF_true() throws Exception {
//		Long benFlowID = 1L;
//		Long benRegID = 1L;
//		Long benID = 1L;
//		Long benVisitID = 1L;
//		short docFlag = 1;
//		short pharmaFlag = 1;
//		short oncologistFlag = 1;
//		int tcUserID = 1;
//		Timestamp tcDate = Timestamp.valueOf("2024-01-01 00:00:01");
//
//		int i = 0;
//		Short pharmaF = 1;
//
//		when(beneficiaryFlowStatusRepo.getPharmaFlag(benFlowID)).thenReturn(pharmaF);
//
//		Short pharmaF1;
//
//		pharmaF1 = pharmaF;
//
//		int expResponse = commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateWDF(benFlowID, benRegID, benID,
//				benVisitID, docFlag, pharmaFlag, oncologistFlag, tcUserID, tcDate);
//
//		assertTrue(pharmaF != null && pharmaF == 1);
//		assertEquals(expResponse, commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateWDF(benFlowID, benRegID,
//				benID, benVisitID, docFlag, pharmaFlag, oncologistFlag, tcUserID, tcDate));
//	}
//
//	@Test
//	void testUpdateBenFlowAfterDocDataUpdateWDF_false() throws Exception {
//		Long benFlowID = 1L;
//		Long benRegID = 1L;
//		Long benID = 1L;
//		Long benVisitID = 1L;
//		short docFlag = 1;
//		short pharmaFlag = 1;
//		short oncologistFlag = 1;
//		int tcUserID = 1;
//		Timestamp tcDate = Timestamp.valueOf("2024-01-01 00:00:01");
//
//		int i = 0;
//		Short pharmaF = 0;
//
//		when(beneficiaryFlowStatusRepo.getPharmaFlag(benFlowID)).thenReturn(pharmaF);
//
//		Short pharmaF1;
//
//		pharmaF1 = pharmaFlag;
//
//		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivityWDF(benFlowID, benRegID, benID, docFlag,
//				pharmaF1, oncologistFlag, tcUserID, tcDate)).thenReturn(i);
//
//		int expResponse = commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateWDF(benFlowID, benRegID, benID,
//				benVisitID, docFlag, pharmaFlag, oncologistFlag, tcUserID, tcDate);
//
//		assertTrue(pharmaF == null || pharmaF != 1);
//		assertEquals(expResponse, commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateWDF(benFlowID, benRegID,
//				benID, benVisitID, docFlag, pharmaFlag, oncologistFlag, tcUserID, tcDate));
//	}
//
//	@Test
//	void testUpdateBenFlowAfterDocDataUpdateWDF_Exception() throws Exception {
//
//		when(beneficiaryFlowStatusRepo.getPharmaFlag(any())).thenThrow(RuntimeException.class);
//
//		int response = commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateWDF(any(), any(), any(), any(), any(),
//				any(), any(), any(), any());
//
//		assertEquals(response, commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateWDF(any(), any(), any(), any(),
//				any(), any(), any(), any(), any()));
//	}
//
//	@Test
//	void testUpdateBenFlowAfterDocDataUpdateTCSpecialist_true() throws Exception {
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
//
//		int i = 0;
//		Short pharmaF = 1;
//
//		when(beneficiaryFlowStatusRepo.getPharmaFlag(benFlowID)).thenReturn(pharmaF);
//		Short pharmaF1;
//
//		pharmaF1 = pharmaF;
//
//		int expResponse = commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateTCSpecialist(benFlowID, benRegID,
//				benID, benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate);
//
//		assertTrue(pharmaF != null && pharmaF == 1);
//		assertEquals(expResponse, commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateTCSpecialist(benFlowID,
//				benRegID, benID, benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate));
//
//	}
//
//	@Test
//	void testUpdateBenFlowAfterDocDataUpdateTCSpecialist_false() throws Exception {
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
//
//		int i = 0;
//		Short pharmaF = null;
//
//		when(beneficiaryFlowStatusRepo.getPharmaFlag(benFlowID)).thenReturn(pharmaF);
//		Short pharmaF1;
//
//		pharmaF1 = pharmaFlag;
//		int expResponse = commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateTCSpecialist(benFlowID, benRegID,
//				benID, benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate);
//
//		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivityTCSpecialist(benFlowID, benRegID, benID,
//				pharmaF1, oncologistFlag, tcSpecialistFlag)).thenReturn(i);
//
//		assertTrue(pharmaF == null || pharmaF != 1);
//		assertEquals(expResponse, commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateTCSpecialist(benFlowID,
//				benRegID, benID, benVisitID, docFlag, pharmaFlag, oncologistFlag, tcSpecialistFlag, tcUserID, tcDate));
//
//	}
//
//	@Test
//	void testUpdateBenFlowAfterDocDataUpdateTCSpecialist_Exception() throws Exception {
//
//		when(beneficiaryFlowStatusRepo.getPharmaFlag(any())).thenThrow(RuntimeException.class);
//
//		int response = commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateTCSpecialist(any(), any(), any(),
//				any(), any(), any(), any(), any(), any(), any());
//		assertEquals(response, commonBenStatusFlowService.updateBenFlowAfterDocDataUpdateTCSpecialist(any(), any(),
//				any(), any(), any(), any(), any(), any(), any(), any()));
//	}
//
//	@Test
//	void testUpdateFlowAfterLabResultEntry() {
//		Long benFlowID = 1L;
//		Long benRegID = 1L;
//		Long benVisitID = 1L;
//		Short nurseFlag = 1;
//		Short doctorFlag = 1;
//		Short labFlag = 1;
//		int i = 1;
//
//		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterLabResultEntry(benFlowID, benRegID, nurseFlag,
//				doctorFlag, labFlag)).thenReturn(i);
//
//		int expResponse = commonBenStatusFlowService.updateFlowAfterLabResultEntry(benFlowID, benRegID, benVisitID,
//				nurseFlag, doctorFlag, labFlag);
//
//		assertEquals(expResponse, commonBenStatusFlowService.updateFlowAfterLabResultEntry(benFlowID, benRegID,
//				benVisitID, nurseFlag, doctorFlag, labFlag));
//	}
//
//	@Test
//	void testUpdateFlowAfterLabResultEntryForTCSpecialist() {
//		Long benFlowID = 1L;
//		Long benRegID = 1L;
//		Long benVisitID = 1L;
//		Short nurseFlag = 1;
//		Short doctorFlag = 1;
//		Short labFlag = 1;
//		int i = 1;
//
//		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterLabResultEntryForSpecialist(benFlowID, benRegID,
//				nurseFlag)).thenReturn(i);
//
//		int expResponse = commonBenStatusFlowService.updateFlowAfterLabResultEntryForTCSpecialist(benFlowID, benRegID,
//				labFlag);
//
//		assertEquals(expResponse,
//				commonBenStatusFlowService.updateFlowAfterLabResultEntryForTCSpecialist(benFlowID, benRegID, labFlag));
//	}
//
//}
package com.iemr.mmu.service.benFlowStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.iemr.mmu.data.nurse.CommonUtilityClass;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CommonBenStatusFlowServiceImplTest {

	@Test
	void testCreateBenFlowRecord() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange, Act and Assert
		assertEquals(0, (new CommonBenStatusFlowServiceImpl()).createBenFlowRecord("Request OBJ", 1L, 1L));
		assertEquals(0,
				(new CommonBenStatusFlowServiceImpl()).createBenFlowRecord("yyyy-MM-dd'T'HH:mm:ss.SSS", 1L, 1L));
		assertEquals(0, (new CommonBenStatusFlowServiceImpl()).createBenFlowRecord("", 1L, 1L));
	}

	@Test
	void testCreateBenFlowRecord2() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBenVisitDetailRepo(mock(BenVisitDetailRepo.class));

		// Act and Assert
		assertEquals(0, commonBenStatusFlowServiceImpl.createBenFlowRecord("Request OBJ", 1L, 1L));
	}

	@Test
	void testUpdateBenFlowNurseAfterNurseActivity() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange, Act and Assert
		assertEquals(0, (new CommonBenStatusFlowServiceImpl()).updateBenFlowNurseAfterNurseActivity(1L, 1L, 1L,
				"Just cause", "Visit Category", (short) 1, (short) 1, (short) 1, (short) 1, (short) 1, 1L, 1));
	}

	@Test
	void testUpdateBenFlowNurseAfterNurseActivity2() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBenVisitDetailRepo(mock(BenVisitDetailRepo.class));

		// Act and Assert
		assertEquals(0, commonBenStatusFlowServiceImpl.updateBenFlowNurseAfterNurseActivity(1L, 1L, 1L, "Just cause",
				"Visit Category", (short) 1, (short) 1, (short) 1, (short) 1, (short) 1, 1L, 1));
	}

	@Test
	void testUpdateBenFlowNurseAfterNurseActivity3() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterNurseActivity(Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Short>any(),
				Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Long>any(), Mockito.<Integer>any())).thenReturn(1);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateBenFlowNurseAfterNurseActivityResult = commonBenStatusFlowServiceImpl
				.updateBenFlowNurseAfterNurseActivity(1L, 1L, 1L, "Just cause", "Visit Category", (short) 1, (short) 1,
						(short) 1, (short) 1, (short) 1, 1L, 1);

		// Assert
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterNurseActivity(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any(), eq("Just cause"), eq("Visit Category"), Mockito.<Short>any(),
				Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Long>any(), Mockito.<Integer>any());
		assertEquals(1, actualUpdateBenFlowNurseAfterNurseActivityResult);
	}

	@Test
	void testUpdateBenFlowtableAfterNurseSaveForTMReferred() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();

		CommonUtilityClass commonUtilityClass = new CommonUtilityClass();
		commonUtilityClass.setBenFlowID(1L);
		commonUtilityClass.setBenVisitID(1L);
		commonUtilityClass.setBeneficiaryID(1L);
		commonUtilityClass.setBeneficiaryRegID(1L);
		commonUtilityClass.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		commonUtilityClass.setFacilityID(1);
		commonUtilityClass.setIsSpecialist(true);
		commonUtilityClass.setParkingPlaceID(1);
		commonUtilityClass.setProviderServiceMapID(1);
		commonUtilityClass.setServiceID((short) 1);
		commonUtilityClass.setSessionID(1);
		commonUtilityClass.setVanID(1);
		commonUtilityClass.setVisitCode(1L);

		// Act and Assert
		assertEquals(0, commonBenStatusFlowServiceImpl.updateBenFlowtableAfterNurseSaveForTMReferred(commonUtilityClass,
				true, true));
	}

	@Test
	void testUpdateBenFlowtableAfterNurseSaveForTMReferred2() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		CommonUtilityClass commonUtilityClass = mock(CommonUtilityClass.class);
		when(commonUtilityClass.getBenFlowID()).thenReturn(1L);
		when(commonUtilityClass.getBenVisitID()).thenReturn(1L);
		when(commonUtilityClass.getBeneficiaryID()).thenReturn(1L);
		when(commonUtilityClass.getBeneficiaryRegID()).thenReturn(1L);
		doNothing().when(commonUtilityClass).setBenFlowID(Mockito.<Long>any());
		doNothing().when(commonUtilityClass).setBenVisitID(Mockito.<Long>any());
		doNothing().when(commonUtilityClass).setBeneficiaryID(Mockito.<Long>any());
		doNothing().when(commonUtilityClass).setBeneficiaryRegID(Mockito.<Long>any());
		doNothing().when(commonUtilityClass).setCreatedBy(Mockito.<String>any());
		doNothing().when(commonUtilityClass).setFacilityID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setIsSpecialist(Mockito.<Boolean>any());
		doNothing().when(commonUtilityClass).setParkingPlaceID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setServiceID(Mockito.<Short>any());
		doNothing().when(commonUtilityClass).setSessionID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setVanID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setVisitCode(Mockito.<Long>any());
		commonUtilityClass.setBenFlowID(1L);
		commonUtilityClass.setBenVisitID(1L);
		commonUtilityClass.setBeneficiaryID(1L);
		commonUtilityClass.setBeneficiaryRegID(1L);
		commonUtilityClass.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		commonUtilityClass.setFacilityID(1);
		commonUtilityClass.setIsSpecialist(true);
		commonUtilityClass.setParkingPlaceID(1);
		commonUtilityClass.setProviderServiceMapID(1);
		commonUtilityClass.setServiceID((short) 1);
		commonUtilityClass.setSessionID(1);
		commonUtilityClass.setVanID(1);
		commonUtilityClass.setVisitCode(1L);

		// Act
		int actualUpdateBenFlowtableAfterNurseSaveForTMReferredResult = commonBenStatusFlowServiceImpl
				.updateBenFlowtableAfterNurseSaveForTMReferred(commonUtilityClass, true, true);

		// Assert
		verify(commonUtilityClass).getBenFlowID();
		verify(commonUtilityClass).getBenVisitID();
		verify(commonUtilityClass).getBeneficiaryID();
		verify(commonUtilityClass).getBeneficiaryRegID();
		verify(commonUtilityClass).setBenFlowID(Mockito.<Long>any());
		verify(commonUtilityClass).setBenVisitID(Mockito.<Long>any());
		verify(commonUtilityClass).setBeneficiaryID(Mockito.<Long>any());
		verify(commonUtilityClass).setBeneficiaryRegID(Mockito.<Long>any());
		verify(commonUtilityClass).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(commonUtilityClass).setFacilityID(Mockito.<Integer>any());
		verify(commonUtilityClass).setIsSpecialist(Mockito.<Boolean>any());
		verify(commonUtilityClass).setParkingPlaceID(Mockito.<Integer>any());
		verify(commonUtilityClass).setProviderServiceMapID(Mockito.<Integer>any());
		verify(commonUtilityClass).setServiceID(Mockito.<Short>any());
		verify(commonUtilityClass).setSessionID(Mockito.<Integer>any());
		verify(commonUtilityClass).setVanID(Mockito.<Integer>any());
		verify(commonUtilityClass).setVisitCode(Mockito.<Long>any());
		assertEquals(0, actualUpdateBenFlowtableAfterNurseSaveForTMReferredResult);
	}

	@Test
	void testUpdateBenFlowtableAfterNurseSaveForTMReferred3() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusTMReferred(Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Short>any(), Mockito.<Short>any())).thenReturn(1);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);
		CommonUtilityClass commonUtilityClass = mock(CommonUtilityClass.class);
		when(commonUtilityClass.getBenFlowID()).thenReturn(1L);
		when(commonUtilityClass.getBenVisitID()).thenReturn(1L);
		when(commonUtilityClass.getBeneficiaryID()).thenReturn(1L);
		when(commonUtilityClass.getBeneficiaryRegID()).thenReturn(1L);
		doNothing().when(commonUtilityClass).setBenFlowID(Mockito.<Long>any());
		doNothing().when(commonUtilityClass).setBenVisitID(Mockito.<Long>any());
		doNothing().when(commonUtilityClass).setBeneficiaryID(Mockito.<Long>any());
		doNothing().when(commonUtilityClass).setBeneficiaryRegID(Mockito.<Long>any());
		doNothing().when(commonUtilityClass).setCreatedBy(Mockito.<String>any());
		doNothing().when(commonUtilityClass).setFacilityID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setIsSpecialist(Mockito.<Boolean>any());
		doNothing().when(commonUtilityClass).setParkingPlaceID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setServiceID(Mockito.<Short>any());
		doNothing().when(commonUtilityClass).setSessionID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setVanID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setVisitCode(Mockito.<Long>any());
		commonUtilityClass.setBenFlowID(1L);
		commonUtilityClass.setBenVisitID(1L);
		commonUtilityClass.setBeneficiaryID(1L);
		commonUtilityClass.setBeneficiaryRegID(1L);
		commonUtilityClass.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		commonUtilityClass.setFacilityID(1);
		commonUtilityClass.setIsSpecialist(true);
		commonUtilityClass.setParkingPlaceID(1);
		commonUtilityClass.setProviderServiceMapID(1);
		commonUtilityClass.setServiceID((short) 1);
		commonUtilityClass.setSessionID(1);
		commonUtilityClass.setVanID(1);
		commonUtilityClass.setVisitCode(1L);

		// Act
		int actualUpdateBenFlowtableAfterNurseSaveForTMReferredResult = commonBenStatusFlowServiceImpl
				.updateBenFlowtableAfterNurseSaveForTMReferred(commonUtilityClass, true, true);

		// Assert
		verify(commonUtilityClass).getBenFlowID();
		verify(commonUtilityClass).getBenVisitID();
		verify(commonUtilityClass).getBeneficiaryID();
		verify(commonUtilityClass).getBeneficiaryRegID();
		verify(commonUtilityClass).setBenFlowID(Mockito.<Long>any());
		verify(commonUtilityClass).setBenVisitID(Mockito.<Long>any());
		verify(commonUtilityClass).setBeneficiaryID(Mockito.<Long>any());
		verify(commonUtilityClass).setBeneficiaryRegID(Mockito.<Long>any());
		verify(commonUtilityClass).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(commonUtilityClass).setFacilityID(Mockito.<Integer>any());
		verify(commonUtilityClass).setIsSpecialist(Mockito.<Boolean>any());
		verify(commonUtilityClass).setParkingPlaceID(Mockito.<Integer>any());
		verify(commonUtilityClass).setProviderServiceMapID(Mockito.<Integer>any());
		verify(commonUtilityClass).setServiceID(Mockito.<Short>any());
		verify(commonUtilityClass).setSessionID(Mockito.<Integer>any());
		verify(commonUtilityClass).setVanID(Mockito.<Integer>any());
		verify(commonUtilityClass).setVisitCode(Mockito.<Long>any());
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusTMReferred(Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Short>any(), Mockito.<Short>any());
		assertEquals(1, actualUpdateBenFlowtableAfterNurseSaveForTMReferredResult);
	}

	@Test
	void testUpdateBenFlowtableAfterNurseSaveForTMReferred4() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusTMReferred(Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Short>any(), Mockito.<Short>any())).thenReturn(1);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);
		CommonUtilityClass commonUtilityClass = mock(CommonUtilityClass.class);
		when(commonUtilityClass.getBenFlowID()).thenReturn(1L);
		when(commonUtilityClass.getBenVisitID()).thenReturn(1L);
		when(commonUtilityClass.getBeneficiaryID()).thenReturn(1L);
		when(commonUtilityClass.getBeneficiaryRegID()).thenReturn(1L);
		doNothing().when(commonUtilityClass).setBenFlowID(Mockito.<Long>any());
		doNothing().when(commonUtilityClass).setBenVisitID(Mockito.<Long>any());
		doNothing().when(commonUtilityClass).setBeneficiaryID(Mockito.<Long>any());
		doNothing().when(commonUtilityClass).setBeneficiaryRegID(Mockito.<Long>any());
		doNothing().when(commonUtilityClass).setCreatedBy(Mockito.<String>any());
		doNothing().when(commonUtilityClass).setFacilityID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setIsSpecialist(Mockito.<Boolean>any());
		doNothing().when(commonUtilityClass).setParkingPlaceID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setServiceID(Mockito.<Short>any());
		doNothing().when(commonUtilityClass).setSessionID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setVanID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setVisitCode(Mockito.<Long>any());
		commonUtilityClass.setBenFlowID(1L);
		commonUtilityClass.setBenVisitID(1L);
		commonUtilityClass.setBeneficiaryID(1L);
		commonUtilityClass.setBeneficiaryRegID(1L);
		commonUtilityClass.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		commonUtilityClass.setFacilityID(1);
		commonUtilityClass.setIsSpecialist(true);
		commonUtilityClass.setParkingPlaceID(1);
		commonUtilityClass.setProviderServiceMapID(1);
		commonUtilityClass.setServiceID((short) 1);
		commonUtilityClass.setSessionID(1);
		commonUtilityClass.setVanID(1);
		commonUtilityClass.setVisitCode(1L);

		// Act
		int actualUpdateBenFlowtableAfterNurseSaveForTMReferredResult = commonBenStatusFlowServiceImpl
				.updateBenFlowtableAfterNurseSaveForTMReferred(commonUtilityClass, false, true);

		// Assert
		verify(commonUtilityClass).getBenFlowID();
		verify(commonUtilityClass).getBenVisitID();
		verify(commonUtilityClass).getBeneficiaryID();
		verify(commonUtilityClass).getBeneficiaryRegID();
		verify(commonUtilityClass).setBenFlowID(Mockito.<Long>any());
		verify(commonUtilityClass).setBenVisitID(Mockito.<Long>any());
		verify(commonUtilityClass).setBeneficiaryID(Mockito.<Long>any());
		verify(commonUtilityClass).setBeneficiaryRegID(Mockito.<Long>any());
		verify(commonUtilityClass).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(commonUtilityClass).setFacilityID(Mockito.<Integer>any());
		verify(commonUtilityClass).setIsSpecialist(Mockito.<Boolean>any());
		verify(commonUtilityClass).setParkingPlaceID(Mockito.<Integer>any());
		verify(commonUtilityClass).setProviderServiceMapID(Mockito.<Integer>any());
		verify(commonUtilityClass).setServiceID(Mockito.<Short>any());
		verify(commonUtilityClass).setSessionID(Mockito.<Integer>any());
		verify(commonUtilityClass).setVanID(Mockito.<Integer>any());
		verify(commonUtilityClass).setVisitCode(Mockito.<Long>any());
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusTMReferred(Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Short>any(), Mockito.<Short>any());
		assertEquals(1, actualUpdateBenFlowtableAfterNurseSaveForTMReferredResult);
	}

	@Test
	void testUpdateBenFlowtableAfterNurseSaveForTMReferred5() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusTMReferred(Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Short>any(), Mockito.<Short>any())).thenReturn(1);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);
		CommonUtilityClass commonUtilityClass = mock(CommonUtilityClass.class);
		when(commonUtilityClass.getBenFlowID()).thenReturn(1L);
		when(commonUtilityClass.getBenVisitID()).thenReturn(1L);
		when(commonUtilityClass.getBeneficiaryID()).thenReturn(1L);
		when(commonUtilityClass.getBeneficiaryRegID()).thenReturn(1L);
		doNothing().when(commonUtilityClass).setBenFlowID(Mockito.<Long>any());
		doNothing().when(commonUtilityClass).setBenVisitID(Mockito.<Long>any());
		doNothing().when(commonUtilityClass).setBeneficiaryID(Mockito.<Long>any());
		doNothing().when(commonUtilityClass).setBeneficiaryRegID(Mockito.<Long>any());
		doNothing().when(commonUtilityClass).setCreatedBy(Mockito.<String>any());
		doNothing().when(commonUtilityClass).setFacilityID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setIsSpecialist(Mockito.<Boolean>any());
		doNothing().when(commonUtilityClass).setParkingPlaceID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setServiceID(Mockito.<Short>any());
		doNothing().when(commonUtilityClass).setSessionID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setVanID(Mockito.<Integer>any());
		doNothing().when(commonUtilityClass).setVisitCode(Mockito.<Long>any());
		commonUtilityClass.setBenFlowID(1L);
		commonUtilityClass.setBenVisitID(1L);
		commonUtilityClass.setBeneficiaryID(1L);
		commonUtilityClass.setBeneficiaryRegID(1L);
		commonUtilityClass.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		commonUtilityClass.setFacilityID(1);
		commonUtilityClass.setIsSpecialist(true);
		commonUtilityClass.setParkingPlaceID(1);
		commonUtilityClass.setProviderServiceMapID(1);
		commonUtilityClass.setServiceID((short) 1);
		commonUtilityClass.setSessionID(1);
		commonUtilityClass.setVanID(1);
		commonUtilityClass.setVisitCode(1L);

		// Act
		int actualUpdateBenFlowtableAfterNurseSaveForTMReferredResult = commonBenStatusFlowServiceImpl
				.updateBenFlowtableAfterNurseSaveForTMReferred(commonUtilityClass, true, false);

		// Assert
		verify(commonUtilityClass).getBenFlowID();
		verify(commonUtilityClass).getBenVisitID();
		verify(commonUtilityClass).getBeneficiaryID();
		verify(commonUtilityClass).getBeneficiaryRegID();
		verify(commonUtilityClass).setBenFlowID(Mockito.<Long>any());
		verify(commonUtilityClass).setBenVisitID(Mockito.<Long>any());
		verify(commonUtilityClass).setBeneficiaryID(Mockito.<Long>any());
		verify(commonUtilityClass).setBeneficiaryRegID(Mockito.<Long>any());
		verify(commonUtilityClass).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(commonUtilityClass).setFacilityID(Mockito.<Integer>any());
		verify(commonUtilityClass).setIsSpecialist(Mockito.<Boolean>any());
		verify(commonUtilityClass).setParkingPlaceID(Mockito.<Integer>any());
		verify(commonUtilityClass).setProviderServiceMapID(Mockito.<Integer>any());
		verify(commonUtilityClass).setServiceID(Mockito.<Short>any());
		verify(commonUtilityClass).setSessionID(Mockito.<Integer>any());
		verify(commonUtilityClass).setVanID(Mockito.<Integer>any());
		verify(commonUtilityClass).setVisitCode(Mockito.<Long>any());
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusTMReferred(Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Short>any(), Mockito.<Short>any());
		assertEquals(1, actualUpdateBenFlowtableAfterNurseSaveForTMReferredResult);
	}

	@Test
	void testUpdateBenFlowNurseAfterNurseUpdateNCD_Screening() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange, Act and Assert
		assertEquals(0, (new CommonBenStatusFlowServiceImpl()).updateBenFlowNurseAfterNurseUpdateNCD_Screening(1L, 1L,
				(short) 7));
		assertEquals(0, (new CommonBenStatusFlowServiceImpl()).updateBenFlowNurseAfterNurseUpdateNCD_Screening(5L, 5L,
				(short) 7));
	}

	@Test
	void testUpdateBenFlowNurseAfterNurseUpdateNCD_Screening2() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBenVisitDetailRepo(mock(BenVisitDetailRepo.class));

		// Act and Assert
		assertEquals(0,
				commonBenStatusFlowServiceImpl.updateBenFlowNurseAfterNurseUpdateNCD_Screening(1L, 1L, (short) 7));
	}

	@Test
	void testUpdateBenFlowNurseAfterNurseUpdateNCD_Screening3() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterNurseDataUpdateNCD_Screening(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any())).thenReturn(3);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateBenFlowNurseAfterNurseUpdateNCD_ScreeningResult = commonBenStatusFlowServiceImpl
				.updateBenFlowNurseAfterNurseUpdateNCD_Screening(1L, 1L, (short) 7);

		// Assert
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterNurseDataUpdateNCD_Screening(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any());
		assertEquals(3, actualUpdateBenFlowNurseAfterNurseUpdateNCD_ScreeningResult);
	}

	@Test
	void testUpdateBenFlowNurseAfterNurseUpdateNCD_Screening4() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterNurseDataUpdateNCD_Screening(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any())).thenReturn(3);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateBenFlowNurseAfterNurseUpdateNCD_ScreeningResult = commonBenStatusFlowServiceImpl
				.updateBenFlowNurseAfterNurseUpdateNCD_Screening(2L, 1L, (short) 7);

		// Assert
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterNurseDataUpdateNCD_Screening(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any());
		assertEquals(3, actualUpdateBenFlowNurseAfterNurseUpdateNCD_ScreeningResult);
	}

	@Test
	void testUpdateBenFlowNurseAfterNurseUpdateNCD_Screening5() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterNurseDataUpdateNCD_Screening(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any())).thenReturn(3);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateBenFlowNurseAfterNurseUpdateNCD_ScreeningResult = commonBenStatusFlowServiceImpl
				.updateBenFlowNurseAfterNurseUpdateNCD_Screening(3L, 1L, (short) 7);

		// Assert
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterNurseDataUpdateNCD_Screening(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any());
		assertEquals(3, actualUpdateBenFlowNurseAfterNurseUpdateNCD_ScreeningResult);
	}

	@Test
	void testUpdateBenFlowAfterDocData() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange, Act and Assert
		assertEquals(0, (new CommonBenStatusFlowServiceImpl()).updateBenFlowAfterDocData(1L, 1L, 1L, 1L, (short) 1,
				(short) 1, (short) 1, (short) 1, 1, mock(Timestamp.class)));
	}

	@Test
	void testUpdateBenFlowAfterDocData2() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivity(Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any(), anyInt(), Mockito.<Timestamp>any())).thenReturn(1);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateBenFlowAfterDocDataResult = commonBenStatusFlowServiceImpl.updateBenFlowAfterDocData(1L, 1L, 1L,
				1L, (short) 1, (short) 1, (short) 1, (short) 1, 1, mock(Timestamp.class));

		// Assert
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterDoctorActivity(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any(), Mockito.<Short>any(), anyInt(), Mockito.<Timestamp>any());
		assertEquals(1, actualUpdateBenFlowAfterDocDataResult);
	}

	@Test
	void testUpdateBenFlowAfterDocDataUpdate() throws Exception {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivity(Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any(), anyInt(), Mockito.<Timestamp>any())).thenReturn(1);
		when(beneficiaryFlowStatusRepo.getPharmaFlag(Mockito.<Long>any())).thenReturn((short) 1);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateBenFlowAfterDocDataUpdateResult = commonBenStatusFlowServiceImpl
				.updateBenFlowAfterDocDataUpdate(1L, 1L, 1L, 1L, (short) 1, (short) 1, (short) 1, (short) 1, 1,
						mock(Timestamp.class));

		// Assert
		verify(beneficiaryFlowStatusRepo).getPharmaFlag(Mockito.<Long>any());
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterDoctorActivity(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any(), Mockito.<Short>any(), anyInt(), Mockito.<Timestamp>any());
		assertEquals(1, actualUpdateBenFlowAfterDocDataUpdateResult);
	}

	@Test
	void testUpdateBenFlowAfterDocDataUpdate2() throws Exception {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivity(Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any(), anyInt(), Mockito.<Timestamp>any())).thenReturn(1);
		when(beneficiaryFlowStatusRepo.getPharmaFlag(Mockito.<Long>any())).thenReturn((short) 9);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateBenFlowAfterDocDataUpdateResult = commonBenStatusFlowServiceImpl
				.updateBenFlowAfterDocDataUpdate(1L, 1L, 1L, 1L, (short) 1, (short) 1, (short) 1, (short) 1, 1,
						mock(Timestamp.class));

		// Assert
		verify(beneficiaryFlowStatusRepo).getPharmaFlag(Mockito.<Long>any());
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterDoctorActivity(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any(), Mockito.<Short>any(), anyInt(), Mockito.<Timestamp>any());
		assertEquals(1, actualUpdateBenFlowAfterDocDataUpdateResult);
	}

	@Test
	void testUpdateBenFlowAfterDocDataUpdate3() throws Exception {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivity(Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any(), anyInt(), Mockito.<Timestamp>any())).thenReturn(1);
		when(beneficiaryFlowStatusRepo.getPharmaFlag(Mockito.<Long>any())).thenReturn(null);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateBenFlowAfterDocDataUpdateResult = commonBenStatusFlowServiceImpl
				.updateBenFlowAfterDocDataUpdate(1L, 1L, 1L, 1L, (short) 1, (short) 1, (short) 1, (short) 1, 1,
						mock(Timestamp.class));

		// Assert
		verify(beneficiaryFlowStatusRepo).getPharmaFlag(Mockito.<Long>any());
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterDoctorActivity(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any(), Mockito.<Short>any(), anyInt(), Mockito.<Timestamp>any());
		assertEquals(1, actualUpdateBenFlowAfterDocDataUpdateResult);
	}

	@Test
	void testUpdateBenFlowAfterDocDataUpdateWDF() throws Exception {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivityWDF(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any(), anyInt(), Mockito.<Timestamp>any())).thenReturn(1);
		when(beneficiaryFlowStatusRepo.getPharmaFlag(Mockito.<Long>any())).thenReturn((short) 1);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateBenFlowAfterDocDataUpdateWDFResult = commonBenStatusFlowServiceImpl
				.updateBenFlowAfterDocDataUpdateWDF(1L, 1L, 1L, 1L, (short) 1, (short) 1, (short) 1, 1,
						mock(Timestamp.class));

		// Assert
		verify(beneficiaryFlowStatusRepo).getPharmaFlag(Mockito.<Long>any());
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterDoctorActivityWDF(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any(), anyInt(), Mockito.<Timestamp>any());
		assertEquals(1, actualUpdateBenFlowAfterDocDataUpdateWDFResult);
	}

	@Test
	void testUpdateBenFlowAfterDocDataUpdateWDF2() throws Exception {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivityWDF(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any(), anyInt(), Mockito.<Timestamp>any())).thenReturn(1);
		when(beneficiaryFlowStatusRepo.getPharmaFlag(Mockito.<Long>any())).thenReturn((short) 8);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateBenFlowAfterDocDataUpdateWDFResult = commonBenStatusFlowServiceImpl
				.updateBenFlowAfterDocDataUpdateWDF(1L, 1L, 1L, 1L, (short) 1, (short) 1, (short) 1, 1,
						mock(Timestamp.class));

		// Assert
		verify(beneficiaryFlowStatusRepo).getPharmaFlag(Mockito.<Long>any());
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterDoctorActivityWDF(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any(), anyInt(), Mockito.<Timestamp>any());
		assertEquals(1, actualUpdateBenFlowAfterDocDataUpdateWDFResult);
	}

	@Test
	void testUpdateBenFlowAfterDocDataUpdateWDF3() throws Exception {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivityWDF(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any(), anyInt(), Mockito.<Timestamp>any())).thenReturn(1);
		when(beneficiaryFlowStatusRepo.getPharmaFlag(Mockito.<Long>any())).thenReturn(null);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateBenFlowAfterDocDataUpdateWDFResult = commonBenStatusFlowServiceImpl
				.updateBenFlowAfterDocDataUpdateWDF(1L, 1L, 1L, 1L, (short) 1, (short) 1, (short) 1, 1,
						mock(Timestamp.class));

		// Assert
		verify(beneficiaryFlowStatusRepo).getPharmaFlag(Mockito.<Long>any());
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterDoctorActivityWDF(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any(), anyInt(), Mockito.<Timestamp>any());
		assertEquals(1, actualUpdateBenFlowAfterDocDataUpdateWDFResult);
	}

	@Test
	void testUpdateBenFlowAfterDocDataUpdateTCSpecialist() throws Exception {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivityTCSpecialist(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any())).thenReturn(1);
		when(beneficiaryFlowStatusRepo.getPharmaFlag(Mockito.<Long>any())).thenReturn((short) 1);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateBenFlowAfterDocDataUpdateTCSpecialistResult = commonBenStatusFlowServiceImpl
				.updateBenFlowAfterDocDataUpdateTCSpecialist(1L, 1L, 1L, 1L, (short) 1, (short) 1, (short) 1, (short) 1,
						1, mock(Timestamp.class));

		// Assert
		verify(beneficiaryFlowStatusRepo).getPharmaFlag(Mockito.<Long>any());
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterDoctorActivityTCSpecialist(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any());
		assertEquals(1, actualUpdateBenFlowAfterDocDataUpdateTCSpecialistResult);
	}

	@Test
	void testUpdateBenFlowAfterDocDataUpdateTCSpecialist2() throws Exception {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivityTCSpecialist(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any())).thenReturn(1);
		when(beneficiaryFlowStatusRepo.getPharmaFlag(Mockito.<Long>any())).thenReturn((short) 6);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateBenFlowAfterDocDataUpdateTCSpecialistResult = commonBenStatusFlowServiceImpl
				.updateBenFlowAfterDocDataUpdateTCSpecialist(1L, 1L, 1L, 1L, (short) 1, (short) 1, (short) 1, (short) 1,
						1, mock(Timestamp.class));

		// Assert
		verify(beneficiaryFlowStatusRepo).getPharmaFlag(Mockito.<Long>any());
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterDoctorActivityTCSpecialist(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any());
		assertEquals(1, actualUpdateBenFlowAfterDocDataUpdateTCSpecialistResult);
	}

	@Test
	void testUpdateBenFlowAfterDocDataUpdateTCSpecialist3() throws Exception {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterDoctorActivityTCSpecialist(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any())).thenReturn(1);
		when(beneficiaryFlowStatusRepo.getPharmaFlag(Mockito.<Long>any())).thenReturn(null);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateBenFlowAfterDocDataUpdateTCSpecialistResult = commonBenStatusFlowServiceImpl
				.updateBenFlowAfterDocDataUpdateTCSpecialist(1L, 1L, 1L, 1L, (short) 1, (short) 1, (short) 1, (short) 1,
						1, mock(Timestamp.class));

		// Assert
		verify(beneficiaryFlowStatusRepo).getPharmaFlag(Mockito.<Long>any());
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterDoctorActivityTCSpecialist(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(),
				Mockito.<Short>any());
		assertEquals(1, actualUpdateBenFlowAfterDocDataUpdateTCSpecialistResult);
	}

	@Test
	void testUpdateFlowAfterLabResultEntry() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterLabResultEntry(Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any())).thenReturn(3);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateFlowAfterLabResultEntryResult = commonBenStatusFlowServiceImpl.updateFlowAfterLabResultEntry(1L,
				1L, 1L, (short) 7, (short) 7, (short) 7);

		// Assert
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterLabResultEntry(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any());
		assertEquals(3, actualUpdateFlowAfterLabResultEntryResult);
	}

	@Test
	void testUpdateFlowAfterLabResultEntry2() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterLabResultEntry(Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any())).thenReturn(3);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateFlowAfterLabResultEntryResult = commonBenStatusFlowServiceImpl.updateFlowAfterLabResultEntry(2L,
				1L, 1L, (short) 7, (short) 7, (short) 7);

		// Assert
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterLabResultEntry(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any());
		assertEquals(3, actualUpdateFlowAfterLabResultEntryResult);
	}

	@Test
	void testUpdateFlowAfterLabResultEntry3() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterLabResultEntry(Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any())).thenReturn(3);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateFlowAfterLabResultEntryResult = commonBenStatusFlowServiceImpl.updateFlowAfterLabResultEntry(3L,
				1L, 1L, (short) 7, (short) 7, (short) 7);

		// Assert
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterLabResultEntry(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any());
		assertEquals(3, actualUpdateFlowAfterLabResultEntryResult);
	}

	@Test
	void testUpdateFlowAfterLabResultEntryForTCSpecialist() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterLabResultEntryForSpecialist(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any())).thenReturn(3);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateFlowAfterLabResultEntryForTCSpecialistResult = commonBenStatusFlowServiceImpl
				.updateFlowAfterLabResultEntryForTCSpecialist(1L, 1L, (short) 7);

		// Assert
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterLabResultEntryForSpecialist(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any());
		assertEquals(3, actualUpdateFlowAfterLabResultEntryForTCSpecialistResult);
	}

	@Test
	void testUpdateFlowAfterLabResultEntryForTCSpecialist2() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterLabResultEntryForSpecialist(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any())).thenReturn(3);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateFlowAfterLabResultEntryForTCSpecialistResult = commonBenStatusFlowServiceImpl
				.updateFlowAfterLabResultEntryForTCSpecialist(2L, 1L, (short) 7);

		// Assert
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterLabResultEntryForSpecialist(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any());
		assertEquals(3, actualUpdateFlowAfterLabResultEntryForTCSpecialistResult);
	}

	@Test
	void testUpdateFlowAfterLabResultEntryForTCSpecialist3() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo = mock(BeneficiaryFlowStatusRepo.class);
		when(beneficiaryFlowStatusRepo.updateBenFlowStatusAfterLabResultEntryForSpecialist(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any())).thenReturn(3);

		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(beneficiaryFlowStatusRepo);

		// Act
		int actualUpdateFlowAfterLabResultEntryForTCSpecialistResult = commonBenStatusFlowServiceImpl
				.updateFlowAfterLabResultEntryForTCSpecialist(3L, 1L, (short) 7);

		// Assert
		verify(beneficiaryFlowStatusRepo).updateBenFlowStatusAfterLabResultEntryForSpecialist(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Short>any());
		assertEquals(3, actualUpdateFlowAfterLabResultEntryForTCSpecialistResult);
	}

	@Test
	void testGettersAndSetters() {
		// TODO: Diffblue Cover was only able to create a partial test for this method:
		// Reason: Missing observers.
		// Diffblue Cover was unable to create an assertion.
		// Add getters for the following fields or make them package-private:
		// CommonBenStatusFlowServiceImpl.benVisitDetailRepo
		// CommonBenStatusFlowServiceImpl.beneficiaryFlowStatusRepo
		// CommonBenStatusFlowServiceImpl.logger
		// CommonBenStatusFlowServiceImpl.nurseWL

		// Arrange
		CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl = new CommonBenStatusFlowServiceImpl();

		// Act
		commonBenStatusFlowServiceImpl.setBenVisitDetailRepo(mock(BenVisitDetailRepo.class));
		commonBenStatusFlowServiceImpl.setBeneficiaryFlowStatusRepo(mock(BeneficiaryFlowStatusRepo.class));
	}
}
