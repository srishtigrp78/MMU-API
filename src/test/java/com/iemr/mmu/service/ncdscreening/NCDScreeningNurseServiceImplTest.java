package com.iemr.mmu.service.ncdscreening;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.mmu.data.ncdScreening.NCDScreening;
import com.iemr.mmu.repo.nurse.ncdscreening.NCDScreeningRepo;

@ExtendWith(MockitoExtension.class)
class NCDScreeningNurseServiceImplTest {
	@InjectMocks
	private NCDScreeningNurseServiceImpl nCDScreeningNurseServiceImpl;

	@Mock
	private NCDScreeningRepo nCDScreeningRepo;

	@Test
	void testSetNcdScreeningRepo() {
		// TODO: Diffblue Cover was only able to create a partial test for this method:
		// Reason: Missing observers.
		// Diffblue Cover was unable to create an assertion.
		// Add getters for the following fields or make them package-private:
		// NCDScreeningNurseServiceImpl.ncdScreeningRepo

		// Arrange and Act
		(new NCDScreeningNurseServiceImpl()).setNcdScreeningRepo(mock(NCDScreeningRepo.class));
	}

	@Test
	void testSaveNCDScreeningDetails() {
		// Arrange
		NCDScreening ncdScreening = new NCDScreening();
		ncdScreening.setActionForScreenPositive("Action For Screen Positive");
		ncdScreening.setBenFlowID(1L);
		ncdScreening.setBenVisitID(1L);
		ncdScreening.setBeneficiaryRegID(1L);
		ncdScreening.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		ncdScreening.setCreatedDate(mock(Timestamp.class));
		ncdScreening.setDeleted(true);
		ncdScreening.setFileIDs(new String[] { "File IDs" });
		ncdScreening.setID(1L);
		ncdScreening.setIsBPPrescribed(true);
		ncdScreening.setIsBloodGlucosePrescribed(true);
		ncdScreening.setIsScreeningComplete(true);
		ncdScreening.setLastModDate(mock(Timestamp.class));
		ncdScreening.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		ncdScreening.setNcdScreeningConditionID("Ncd Screening Condition ID");
		ncdScreening.setNcdScreeningConditionList(new ArrayList<>());
		ncdScreening.setNcdScreeningReasonID(1);
		ncdScreening.setNcdScreeningVisitNo((short) 1);
		ncdScreening.setNextScreeningDate("2020-03-01");
		ncdScreening.setNextScreeningDateDB(mock(Timestamp.class));
		ncdScreening.setParkingPlaceID(1);
		ncdScreening.setProcessed("Processed");
		ncdScreening.setProviderServiceMapID(1);
		ncdScreening.setReasonForScreening("Just cause");
		ncdScreening.setReservedForChange("Reserved For Change");
		ncdScreening.setScreeningCondition("Screening Condition");
		ncdScreening.setSyncedBy("Synced By");
		ncdScreening.setSyncedDate(mock(Timestamp.class));
		ncdScreening.setVanID(1);
		ncdScreening.setVanSerialNo(1L);
		ncdScreening.setVehicalNo("Vehical No");
		ncdScreening.setVisitCode(1L);
		when(nCDScreeningRepo.save(Mockito.<NCDScreening>any())).thenReturn(ncdScreening);

		NCDScreening ncdScreening2 = new NCDScreening();
		ncdScreening2.setActionForScreenPositive("Action For Screen Positive");
		ncdScreening2.setBenFlowID(1L);
		ncdScreening2.setBenVisitID(1L);
		ncdScreening2.setBeneficiaryRegID(1L);
		ncdScreening2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		ncdScreening2.setCreatedDate(mock(Timestamp.class));
		ncdScreening2.setDeleted(true);
		ncdScreening2.setFileIDs(new String[] { "File IDs" });
		ncdScreening2.setID(1L);
		ncdScreening2.setIsBPPrescribed(true);
		ncdScreening2.setIsBloodGlucosePrescribed(true);
		ncdScreening2.setIsScreeningComplete(true);
		ncdScreening2.setLastModDate(mock(Timestamp.class));
		ncdScreening2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		ncdScreening2.setNcdScreeningConditionID("Ncd Screening Condition ID");
		ncdScreening2.setNcdScreeningConditionList(new ArrayList<>());
		ncdScreening2.setNcdScreeningReasonID(1);
		ncdScreening2.setNcdScreeningVisitNo((short) 1);
		ncdScreening2.setNextScreeningDate("2020-03-01");
		ncdScreening2.setNextScreeningDateDB(mock(Timestamp.class));
		ncdScreening2.setParkingPlaceID(1);
		ncdScreening2.setProcessed("Processed");
		ncdScreening2.setProviderServiceMapID(1);
		ncdScreening2.setReasonForScreening("Just cause");
		ncdScreening2.setReservedForChange("Reserved For Change");
		ncdScreening2.setScreeningCondition("Screening Condition");
		ncdScreening2.setSyncedBy("Synced By");
		ncdScreening2.setSyncedDate(mock(Timestamp.class));
		ncdScreening2.setVanID(1);
		ncdScreening2.setVanSerialNo(1L);
		ncdScreening2.setVehicalNo("Vehical No");
		ncdScreening2.setVisitCode(1L);

		// Act
		Long actualSaveNCDScreeningDetailsResult = nCDScreeningNurseServiceImpl.saveNCDScreeningDetails(ncdScreening2);

		// Assert
		verify(nCDScreeningRepo).save(Mockito.<NCDScreening>any());
		assertEquals(1L, actualSaveNCDScreeningDetailsResult.longValue());
	}

	@Test
	@Disabled("TODO: Complete this test")
	void testGetNCDScreeningDetails() {

		// Arrange
		NCDScreening ncdScreening = new NCDScreening();
		ncdScreening.setActionForScreenPositive("Action For Screen Positive");
		ncdScreening.setBenFlowID(1L);
		ncdScreening.setBenVisitID(1L);
		ncdScreening.setBeneficiaryRegID(1L);
		ncdScreening.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		ncdScreening.setCreatedDate(mock(Timestamp.class));
		ncdScreening.setDeleted(true);
		ncdScreening.setFileIDs(new String[] { "File IDs" });
		ncdScreening.setID(1L);
		ncdScreening.setIsBPPrescribed(true);
		ncdScreening.setIsBloodGlucosePrescribed(true);
		ncdScreening.setIsScreeningComplete(true);
		ncdScreening.setLastModDate(mock(Timestamp.class));
		ncdScreening.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		ncdScreening.setNcdScreeningConditionID("Ncd Screening Condition ID");
		ncdScreening.setNcdScreeningConditionList(new ArrayList<>());
		ncdScreening.setNcdScreeningReasonID(1);
		ncdScreening.setNcdScreeningVisitNo((short) 1);
		ncdScreening.setNextScreeningDate("2020-03-01");
		ncdScreening.setNextScreeningDateDB(mock(Timestamp.class));
		ncdScreening.setParkingPlaceID(1);
		ncdScreening.setProcessed("Processed");
		ncdScreening.setProviderServiceMapID(1);
		ncdScreening.setReasonForScreening("Just cause");
		ncdScreening.setReservedForChange("Reserved For Change");
		ncdScreening.setScreeningCondition("Screening Condition");
		ncdScreening.setSyncedBy("Synced By");
		ncdScreening.setSyncedDate(mock(Timestamp.class));
		ncdScreening.setVanID(1);
		ncdScreening.setVanSerialNo(1L);
		ncdScreening.setVehicalNo("Vehical No");
		ncdScreening.setVisitCode(1L);
		when(nCDScreeningRepo.getNCDScreeningDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(ncdScreening);

		// Act
		nCDScreeningNurseServiceImpl.getNCDScreeningDetails(1L, 1L);
	}

	@Test
	void testUpdateNCDScreeningDetails() {
		// Arrange
		when(nCDScreeningRepo.updateNCDScreeningDetails(Mockito.<String>any(), Mockito.<String>any(),
				Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<Timestamp>any(), Mockito.<String>any(),
				Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Boolean>any(), Mockito.<Boolean>any())).thenReturn(1);

		NCDScreening ncdScreening = new NCDScreening();
		ncdScreening.setActionForScreenPositive("Action For Screen Positive");
		ncdScreening.setBenFlowID(1L);
		ncdScreening.setBenVisitID(1L);
		ncdScreening.setBeneficiaryRegID(1L);
		ncdScreening.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		ncdScreening.setCreatedDate(mock(Timestamp.class));
		ncdScreening.setDeleted(true);
		ncdScreening.setFileIDs(new String[] { "File IDs" });
		ncdScreening.setID(1L);
		ncdScreening.setIsBPPrescribed(true);
		ncdScreening.setIsBloodGlucosePrescribed(true);
		ncdScreening.setIsScreeningComplete(true);
		ncdScreening.setLastModDate(mock(Timestamp.class));
		ncdScreening.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		ncdScreening.setNcdScreeningConditionID("Ncd Screening Condition ID");
		ncdScreening.setNcdScreeningConditionList(new ArrayList<>());
		ncdScreening.setNcdScreeningReasonID(1);
		ncdScreening.setNcdScreeningVisitNo((short) 1);
		ncdScreening.setNextScreeningDate("2020-03-01");
		ncdScreening.setNextScreeningDateDB(mock(Timestamp.class));
		ncdScreening.setParkingPlaceID(1);
		ncdScreening.setProcessed("Processed");
		ncdScreening.setProviderServiceMapID(1);
		ncdScreening.setReasonForScreening("Just cause");
		ncdScreening.setReservedForChange("Reserved For Change");
		ncdScreening.setScreeningCondition("Screening Condition");
		ncdScreening.setSyncedBy("Synced By");
		ncdScreening.setSyncedDate(mock(Timestamp.class));
		ncdScreening.setVanID(1);
		ncdScreening.setVanSerialNo(1L);
		ncdScreening.setVehicalNo("Vehical No");
		ncdScreening.setVisitCode(1L);

		// Act
		Integer actualUpdateNCDScreeningDetailsResult = nCDScreeningNurseServiceImpl
				.updateNCDScreeningDetails(ncdScreening);

		// Assert
		verify(nCDScreeningRepo).updateNCDScreeningDetails(Mockito.<String>any(), Mockito.<String>any(),
				Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<Timestamp>any(), Mockito.<String>any(),
				Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Boolean>any(), Mockito.<Boolean>any());
		assertEquals(1, actualUpdateNCDScreeningDetailsResult.intValue());
	}

	@Test
	void testUpdateNCDScreeningDetails2() {
		// Arrange
		when(nCDScreeningRepo.updateNCDScreeningDetails(Mockito.<String>any(), Mockito.<String>any(),
				Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<Timestamp>any(), Mockito.<String>any(),
				Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Boolean>any(), Mockito.<Boolean>any())).thenReturn(1);

		ArrayList<Map<String, Object>> ncdScreeningConditionList = new ArrayList<>();
		ncdScreeningConditionList.add(new HashMap<>());

		NCDScreening ncdScreening = new NCDScreening();
		ncdScreening.setActionForScreenPositive("Action For Screen Positive");
		ncdScreening.setBenFlowID(1L);
		ncdScreening.setBenVisitID(1L);
		ncdScreening.setBeneficiaryRegID(1L);
		ncdScreening.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		ncdScreening.setCreatedDate(mock(Timestamp.class));
		ncdScreening.setDeleted(true);
		ncdScreening.setFileIDs(new String[] { "File IDs" });
		ncdScreening.setID(1L);
		ncdScreening.setIsBPPrescribed(true);
		ncdScreening.setIsBloodGlucosePrescribed(true);
		ncdScreening.setIsScreeningComplete(true);
		ncdScreening.setLastModDate(mock(Timestamp.class));
		ncdScreening.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		ncdScreening.setNcdScreeningConditionID("Ncd Screening Condition ID");
		ncdScreening.setNcdScreeningConditionList(ncdScreeningConditionList);
		ncdScreening.setNcdScreeningReasonID(1);
		ncdScreening.setNcdScreeningVisitNo((short) 1);
		ncdScreening.setNextScreeningDate("2020-03-01");
		ncdScreening.setNextScreeningDateDB(mock(Timestamp.class));
		ncdScreening.setParkingPlaceID(1);
		ncdScreening.setProcessed("Processed");
		ncdScreening.setProviderServiceMapID(1);
		ncdScreening.setReasonForScreening("Just cause");
		ncdScreening.setReservedForChange("Reserved For Change");
		ncdScreening.setScreeningCondition("Screening Condition");
		ncdScreening.setSyncedBy("Synced By");
		ncdScreening.setSyncedDate(mock(Timestamp.class));
		ncdScreening.setVanID(1);
		ncdScreening.setVanSerialNo(1L);
		ncdScreening.setVehicalNo("Vehical No");
		ncdScreening.setVisitCode(1L);

		// Act
		Integer actualUpdateNCDScreeningDetailsResult = nCDScreeningNurseServiceImpl
				.updateNCDScreeningDetails(ncdScreening);

		// Assert
		verify(nCDScreeningRepo).updateNCDScreeningDetails(Mockito.<String>any(), Mockito.<String>any(),
				Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<Timestamp>any(), Mockito.<String>any(),
				Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Boolean>any(), Mockito.<Boolean>any());
		assertEquals("null", ncdScreening.getNcdScreeningConditionID());
		assertEquals("null", ncdScreening.getScreeningCondition());
		assertEquals(1, actualUpdateNCDScreeningDetailsResult.intValue());
	}

	@Test
	void testUpdateNCDScreeningDetails3() {
		// Arrange
		when(nCDScreeningRepo.updateNCDScreeningDetails(Mockito.<String>any(), Mockito.<String>any(),
				Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<Timestamp>any(), Mockito.<String>any(),
				Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Boolean>any(), Mockito.<Boolean>any())).thenReturn(1);

		ArrayList<Map<String, Object>> ncdScreeningConditionList = new ArrayList<>();
		ncdScreeningConditionList.add(new HashMap<>());
		ncdScreeningConditionList.add(new HashMap<>());

		NCDScreening ncdScreening = new NCDScreening();
		ncdScreening.setActionForScreenPositive("Action For Screen Positive");
		ncdScreening.setBenFlowID(1L);
		ncdScreening.setBenVisitID(1L);
		ncdScreening.setBeneficiaryRegID(1L);
		ncdScreening.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		ncdScreening.setCreatedDate(mock(Timestamp.class));
		ncdScreening.setDeleted(true);
		ncdScreening.setFileIDs(new String[] { "File IDs" });
		ncdScreening.setID(1L);
		ncdScreening.setIsBPPrescribed(true);
		ncdScreening.setIsBloodGlucosePrescribed(true);
		ncdScreening.setIsScreeningComplete(true);
		ncdScreening.setLastModDate(mock(Timestamp.class));
		ncdScreening.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		ncdScreening.setNcdScreeningConditionID("Ncd Screening Condition ID");
		ncdScreening.setNcdScreeningConditionList(ncdScreeningConditionList);
		ncdScreening.setNcdScreeningReasonID(1);
		ncdScreening.setNcdScreeningVisitNo((short) 1);
		ncdScreening.setNextScreeningDate("2020-03-01");
		ncdScreening.setNextScreeningDateDB(mock(Timestamp.class));
		ncdScreening.setParkingPlaceID(1);
		ncdScreening.setProcessed("Processed");
		ncdScreening.setProviderServiceMapID(1);
		ncdScreening.setReasonForScreening("Just cause");
		ncdScreening.setReservedForChange("Reserved For Change");
		ncdScreening.setScreeningCondition("Screening Condition");
		ncdScreening.setSyncedBy("Synced By");
		ncdScreening.setSyncedDate(mock(Timestamp.class));
		ncdScreening.setVanID(1);
		ncdScreening.setVanSerialNo(1L);
		ncdScreening.setVehicalNo("Vehical No");
		ncdScreening.setVisitCode(1L);

		// Act
		Integer actualUpdateNCDScreeningDetailsResult = nCDScreeningNurseServiceImpl
				.updateNCDScreeningDetails(ncdScreening);

		// Assert
		verify(nCDScreeningRepo).updateNCDScreeningDetails(Mockito.<String>any(), Mockito.<String>any(),
				Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<Timestamp>any(), Mockito.<String>any(),
				Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
				Mockito.<Boolean>any(), Mockito.<Boolean>any());
		assertEquals("null,null", ncdScreening.getNcdScreeningConditionID());
		assertEquals("null,null", ncdScreening.getScreeningCondition());
		assertEquals(1, actualUpdateNCDScreeningDetailsResult.intValue());
	}
}
