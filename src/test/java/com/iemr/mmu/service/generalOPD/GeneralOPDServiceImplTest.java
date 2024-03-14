package com.iemr.mmu.service.generalOPD;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyShort;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.nurse.CommonUtilityClass;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.service.labtechnician.LabTechnicianServiceImpl;
import com.iemr.mmu.service.tele_consultation.TeleConsultationServiceImpl;

@ExtendWith(MockitoExtension.class)
class GeneralOPDServiceImplTest {
	@Mock
	private CommonNurseServiceImpl commonNurseServiceImpl;
	@Mock
	private GeneralOPDNurseServiceImpl generalOPDNurseServiceImpl;
	@Mock
	private CommonDoctorServiceImpl commonDoctorServiceImpl;
	@Mock
	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;
	@Mock
	private GeneralOPDDoctorServiceImpl generalOPDDoctorServiceImpl;
	@Mock
	private LabTechnicianServiceImpl labTechnicianServiceImpl;
	@Mock
	private TeleConsultationServiceImpl teleConsultationServiceImpl;
	@Mock
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;

	@InjectMocks
	GeneralOPDServiceImpl generalOPDService;

	private GeneralOPDServiceImpl generalOPDServiceImpl;
	private JsonObject requestOBJ;
	private CommonUtilityClass nurseUtilityClass;

//	@Test
//	void testSaveNurseData() {
//		fail("Not yet implemented");
//	}

	
	@Test
	void testSaveBenVisitDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBenGeneralOPDHistoryDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBenVitalDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBenExaminationDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveDoctorData() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBenVisitDetailsFrmNurseGOPD() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBenHistoryDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBeneficiaryVitalDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testGetExaminationDetailsData() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateVisitDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBenHistoryDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBenVitalDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBenExaminationDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBenGeneralOPDNurseData() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBenCaseRecordFromDoctorGeneralOPD() {
		fail("Not yet implemented");
	}

//	@Test
//	void testUpdateGeneralOPDDoctorData() {
//		fail("Not yet implemented");
//	}

	@Test
	void whenRequestObjIsNull_thenReturnNull() throws Exception {
		Long result = generalOPDService.updateGeneralOPDDoctorData(null, "AuthorizationToken");
		assertNull(result);
	}

	@Test
	void whenTcRequestIsSuccessful_thenReturnSuccessFlag() throws Exception {
		// Initialize a JsonObject representing a successful TC request scenario
		JsonObject requestOBJ = new JsonObject();

		JsonObject tcRequest = new JsonObject();
		tcRequest.addProperty("userID", 123); // Assuming a valid user ID is required
		tcRequest.addProperty("allocationDate", "2024-03-13");
		tcRequest.addProperty("fromTime", "10:00");
		tcRequest.addProperty("toTime", "11:00");

		JsonObject serviceDetails = new JsonObject();
		serviceDetails.addProperty("serviceID", 4); // Assuming 4 is the ID for a TC service
		serviceDetails.addProperty("createdBy", "doctor");

		requestOBJ.add("tcRequest", tcRequest);
		requestOBJ.add("commonUtilityClass", serviceDetails); // Simulating the common utility class data

		// Assuming that slot booking always succeeds and TC request creation returns a
		// positive flag
		when(commonDoctorServiceImpl.callTmForSpecialistSlotBook(any(), anyString())).thenReturn(1);
		when(teleConsultationServiceImpl.createTCRequest(any())).thenReturn(1);

		// Call the method under test
		Long result = generalOPDService.updateGeneralOPDDoctorData(requestOBJ, "AuthorizationToken");

		// Verify and assert outcomes
		assertNotNull(result);
		assertEquals(1, result);
	}

	@Test
	void whenSlotBookingFails_thenThrowException() {
		// Set up a JsonObject that would trigger a slot booking process
		JsonObject requestOBJ = new JsonObject();

		JsonObject tcRequest = new JsonObject();
		tcRequest.addProperty("userID", 123); // Assuming this would normally trigger slot booking
		tcRequest.addProperty("allocationDate", "2024-03-13");
		tcRequest.addProperty("fromTime", "10:00");
		tcRequest.addProperty("toTime", "11:00");

		JsonObject serviceDetails = new JsonObject();
		serviceDetails.addProperty("serviceID", 4); // Simulating the service ID that requires slot booking
		serviceDetails.addProperty("createdBy", "doctor");

		requestOBJ.add("tcRequest", tcRequest);
		requestOBJ.add("commonUtilityClass", serviceDetails);

		// Mock the behavior to simulate slot booking failure
		// when(commonDoctorServiceImpl.callTmForSpecialistSlotBook(any(),
		// anyString())).thenReturn(0);

		// Assert that an exception is expected to be thrown due to slot booking failure
		assertThrows(RuntimeException.class, () -> {
			generalOPDService.updateGeneralOPDDoctorData(requestOBJ, "AuthorizationToken");
		});
	}

}
