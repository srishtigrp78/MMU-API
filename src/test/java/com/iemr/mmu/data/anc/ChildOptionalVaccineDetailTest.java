package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Date;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ChildOptionalVaccineDetailTest {
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        ChildOptionalVaccineDetail actualChildOptionalVaccineDetail = new ChildOptionalVaccineDetail();
        actualChildOptionalVaccineDetail.setActualReceivingAge("Actual Receiving Age");
        actualChildOptionalVaccineDetail.setBenVisitID(1L);
        actualChildOptionalVaccineDetail.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualChildOptionalVaccineDetail.setCaptureDate(captureDate);
        actualChildOptionalVaccineDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualChildOptionalVaccineDetail.setCreatedDate(createdDate);
        actualChildOptionalVaccineDetail.setDefaultReceivingAge("Default Receiving Age");
        actualChildOptionalVaccineDetail.setDeleted(true);
        actualChildOptionalVaccineDetail.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualChildOptionalVaccineDetail.setLastModDate(lastModDate);
        actualChildOptionalVaccineDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualChildOptionalVaccineDetail.setParkingPlaceID(1);
        actualChildOptionalVaccineDetail.setProcessed("Processed");
        actualChildOptionalVaccineDetail.setProviderServiceMapID(1);
        Timestamp receivedDate = mock(Timestamp.class);
        actualChildOptionalVaccineDetail.setReceivedDate(receivedDate);
        actualChildOptionalVaccineDetail.setReceivedFacilityName("Received Facility Name");
        actualChildOptionalVaccineDetail.setReservedForChange("Reserved For Change");
        actualChildOptionalVaccineDetail.setSctCode("Sct Code");
        actualChildOptionalVaccineDetail.setSctTerm("Sct Term");
        actualChildOptionalVaccineDetail.setStatus("Status");
        actualChildOptionalVaccineDetail.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualChildOptionalVaccineDetail.setSyncedDate(syncedDate);
        actualChildOptionalVaccineDetail.setVaccineName("Vaccine Name");
        actualChildOptionalVaccineDetail.setVanID(1);
        actualChildOptionalVaccineDetail.setVanSerialNo(1L);
        actualChildOptionalVaccineDetail.setVehicalNo("Vehical No");
        actualChildOptionalVaccineDetail.setVisitCode(1L);
        String actualActualReceivingAge = actualChildOptionalVaccineDetail.getActualReceivingAge();
        Long actualBenVisitID = actualChildOptionalVaccineDetail.getBenVisitID();
        Long actualBeneficiaryRegID = actualChildOptionalVaccineDetail.getBeneficiaryRegID();
        Date actualCaptureDate = actualChildOptionalVaccineDetail.getCaptureDate();
        String actualCreatedBy = actualChildOptionalVaccineDetail.getCreatedBy();
        Timestamp actualCreatedDate = actualChildOptionalVaccineDetail.getCreatedDate();
        String actualDefaultReceivingAge = actualChildOptionalVaccineDetail.getDefaultReceivingAge();
        Boolean actualDeleted = actualChildOptionalVaccineDetail.getDeleted();
        Long actualID = actualChildOptionalVaccineDetail.getID();
        Timestamp actualLastModDate = actualChildOptionalVaccineDetail.getLastModDate();
        String actualModifiedBy = actualChildOptionalVaccineDetail.getModifiedBy();
        Integer actualParkingPlaceID = actualChildOptionalVaccineDetail.getParkingPlaceID();
        String actualProcessed = actualChildOptionalVaccineDetail.getProcessed();
        Integer actualProviderServiceMapID = actualChildOptionalVaccineDetail.getProviderServiceMapID();
        Timestamp actualReceivedDate = actualChildOptionalVaccineDetail.getReceivedDate();
        String actualReceivedFacilityName = actualChildOptionalVaccineDetail.getReceivedFacilityName();
        String actualReservedForChange = actualChildOptionalVaccineDetail.getReservedForChange();
        String actualSctCode = actualChildOptionalVaccineDetail.getSctCode();
        String actualSctTerm = actualChildOptionalVaccineDetail.getSctTerm();
        String actualStatus = actualChildOptionalVaccineDetail.getStatus();
        String actualSyncedBy = actualChildOptionalVaccineDetail.getSyncedBy();
        Timestamp actualSyncedDate = actualChildOptionalVaccineDetail.getSyncedDate();
        String actualVaccineName = actualChildOptionalVaccineDetail.getVaccineName();
        Integer actualVanID = actualChildOptionalVaccineDetail.getVanID();
        Long actualVanSerialNo = actualChildOptionalVaccineDetail.getVanSerialNo();
        String actualVehicalNo = actualChildOptionalVaccineDetail.getVehicalNo();
        Long actualVisitCode = actualChildOptionalVaccineDetail.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Actual Receiving Age", actualActualReceivingAge);
        assertEquals("Default Receiving Age", actualDefaultReceivingAge);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Processed", actualProcessed);
        assertEquals("Received Facility Name", actualReceivedFacilityName);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Sct Code", actualSctCode);
        assertEquals("Sct Term", actualSctTerm);
        assertEquals("Status", actualStatus);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vaccine Name", actualVaccineName);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualDeleted);
        assertSame(captureDate, actualCaptureDate);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(receivedDate, actualReceivedDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        ChildOptionalVaccineDetail actualChildOptionalVaccineDetail = new ChildOptionalVaccineDetail(
                "Default Receiving Age", "Vaccine Name", "Other Vaccine Name", "Status", mock(Timestamp.class),
                "Actual Receiving Age", "Received Facility Name", "Sct Code", "Sct Term");
        actualChildOptionalVaccineDetail.setActualReceivingAge("Actual Receiving Age");
        actualChildOptionalVaccineDetail.setBenVisitID(1L);
        actualChildOptionalVaccineDetail.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualChildOptionalVaccineDetail.setCaptureDate(captureDate);
        actualChildOptionalVaccineDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualChildOptionalVaccineDetail.setCreatedDate(createdDate);
        actualChildOptionalVaccineDetail.setDefaultReceivingAge("Default Receiving Age");
        actualChildOptionalVaccineDetail.setDeleted(true);
        actualChildOptionalVaccineDetail.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualChildOptionalVaccineDetail.setLastModDate(lastModDate);
        actualChildOptionalVaccineDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualChildOptionalVaccineDetail.setParkingPlaceID(1);
        actualChildOptionalVaccineDetail.setProcessed("Processed");
        actualChildOptionalVaccineDetail.setProviderServiceMapID(1);
        Timestamp receivedDate = mock(Timestamp.class);
        actualChildOptionalVaccineDetail.setReceivedDate(receivedDate);
        actualChildOptionalVaccineDetail.setReceivedFacilityName("Received Facility Name");
        actualChildOptionalVaccineDetail.setReservedForChange("Reserved For Change");
        actualChildOptionalVaccineDetail.setSctCode("Sct Code");
        actualChildOptionalVaccineDetail.setSctTerm("Sct Term");
        actualChildOptionalVaccineDetail.setStatus("Status");
        actualChildOptionalVaccineDetail.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualChildOptionalVaccineDetail.setSyncedDate(syncedDate);
        actualChildOptionalVaccineDetail.setVaccineName("Vaccine Name");
        actualChildOptionalVaccineDetail.setVanID(1);
        actualChildOptionalVaccineDetail.setVanSerialNo(1L);
        actualChildOptionalVaccineDetail.setVehicalNo("Vehical No");
        actualChildOptionalVaccineDetail.setVisitCode(1L);
        String actualActualReceivingAge = actualChildOptionalVaccineDetail.getActualReceivingAge();
        Long actualBenVisitID = actualChildOptionalVaccineDetail.getBenVisitID();
        Long actualBeneficiaryRegID = actualChildOptionalVaccineDetail.getBeneficiaryRegID();
        Date actualCaptureDate = actualChildOptionalVaccineDetail.getCaptureDate();
        String actualCreatedBy = actualChildOptionalVaccineDetail.getCreatedBy();
        Timestamp actualCreatedDate = actualChildOptionalVaccineDetail.getCreatedDate();
        String actualDefaultReceivingAge = actualChildOptionalVaccineDetail.getDefaultReceivingAge();
        Boolean actualDeleted = actualChildOptionalVaccineDetail.getDeleted();
        Long actualID = actualChildOptionalVaccineDetail.getID();
        Timestamp actualLastModDate = actualChildOptionalVaccineDetail.getLastModDate();
        String actualModifiedBy = actualChildOptionalVaccineDetail.getModifiedBy();
        Integer actualParkingPlaceID = actualChildOptionalVaccineDetail.getParkingPlaceID();
        String actualProcessed = actualChildOptionalVaccineDetail.getProcessed();
        Integer actualProviderServiceMapID = actualChildOptionalVaccineDetail.getProviderServiceMapID();
        Timestamp actualReceivedDate = actualChildOptionalVaccineDetail.getReceivedDate();
        String actualReceivedFacilityName = actualChildOptionalVaccineDetail.getReceivedFacilityName();
        String actualReservedForChange = actualChildOptionalVaccineDetail.getReservedForChange();
        String actualSctCode = actualChildOptionalVaccineDetail.getSctCode();
        String actualSctTerm = actualChildOptionalVaccineDetail.getSctTerm();
        String actualStatus = actualChildOptionalVaccineDetail.getStatus();
        String actualSyncedBy = actualChildOptionalVaccineDetail.getSyncedBy();
        Timestamp actualSyncedDate = actualChildOptionalVaccineDetail.getSyncedDate();
        String actualVaccineName = actualChildOptionalVaccineDetail.getVaccineName();
        Integer actualVanID = actualChildOptionalVaccineDetail.getVanID();
        Long actualVanSerialNo = actualChildOptionalVaccineDetail.getVanSerialNo();
        String actualVehicalNo = actualChildOptionalVaccineDetail.getVehicalNo();
        Long actualVisitCode = actualChildOptionalVaccineDetail.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Actual Receiving Age", actualActualReceivingAge);
        assertEquals("Default Receiving Age", actualDefaultReceivingAge);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Processed", actualProcessed);
        assertEquals("Received Facility Name", actualReceivedFacilityName);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Sct Code", actualSctCode);
        assertEquals("Sct Term", actualSctTerm);
        assertEquals("Status", actualStatus);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vaccine Name", actualVaccineName);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualDeleted);
        assertSame(captureDate, actualCaptureDate);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(receivedDate, actualReceivedDate);
        assertSame(syncedDate, actualSyncedDate);
    }

   
    @Test
    void testGettersAndSetters3() {
        // Arrange and Act
        ChildOptionalVaccineDetail actualChildOptionalVaccineDetail = new ChildOptionalVaccineDetail(mock(Date.class),
                "Default Receiving Age", "Vaccine Name", "Other Vaccine Name", "Status", mock(Timestamp.class),
                "Actual Receiving Age", "Received Facility Name");
        actualChildOptionalVaccineDetail.setActualReceivingAge("Actual Receiving Age");
        actualChildOptionalVaccineDetail.setBenVisitID(1L);
        actualChildOptionalVaccineDetail.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualChildOptionalVaccineDetail.setCaptureDate(captureDate);
        actualChildOptionalVaccineDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualChildOptionalVaccineDetail.setCreatedDate(createdDate);
        actualChildOptionalVaccineDetail.setDefaultReceivingAge("Default Receiving Age");
        actualChildOptionalVaccineDetail.setDeleted(true);
        actualChildOptionalVaccineDetail.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualChildOptionalVaccineDetail.setLastModDate(lastModDate);
        actualChildOptionalVaccineDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualChildOptionalVaccineDetail.setParkingPlaceID(1);
        actualChildOptionalVaccineDetail.setProcessed("Processed");
        actualChildOptionalVaccineDetail.setProviderServiceMapID(1);
        Timestamp receivedDate = mock(Timestamp.class);
        actualChildOptionalVaccineDetail.setReceivedDate(receivedDate);
        actualChildOptionalVaccineDetail.setReceivedFacilityName("Received Facility Name");
        actualChildOptionalVaccineDetail.setReservedForChange("Reserved For Change");
        actualChildOptionalVaccineDetail.setSctCode("Sct Code");
        actualChildOptionalVaccineDetail.setSctTerm("Sct Term");
        actualChildOptionalVaccineDetail.setStatus("Status");
        actualChildOptionalVaccineDetail.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualChildOptionalVaccineDetail.setSyncedDate(syncedDate);
        actualChildOptionalVaccineDetail.setVaccineName("Vaccine Name");
        actualChildOptionalVaccineDetail.setVanID(1);
        actualChildOptionalVaccineDetail.setVanSerialNo(1L);
        actualChildOptionalVaccineDetail.setVehicalNo("Vehical No");
        actualChildOptionalVaccineDetail.setVisitCode(1L);
        String actualActualReceivingAge = actualChildOptionalVaccineDetail.getActualReceivingAge();
        Long actualBenVisitID = actualChildOptionalVaccineDetail.getBenVisitID();
        Long actualBeneficiaryRegID = actualChildOptionalVaccineDetail.getBeneficiaryRegID();
        Date actualCaptureDate = actualChildOptionalVaccineDetail.getCaptureDate();
        String actualCreatedBy = actualChildOptionalVaccineDetail.getCreatedBy();
        Timestamp actualCreatedDate = actualChildOptionalVaccineDetail.getCreatedDate();
        String actualDefaultReceivingAge = actualChildOptionalVaccineDetail.getDefaultReceivingAge();
        Boolean actualDeleted = actualChildOptionalVaccineDetail.getDeleted();
        Long actualID = actualChildOptionalVaccineDetail.getID();
        Timestamp actualLastModDate = actualChildOptionalVaccineDetail.getLastModDate();
        String actualModifiedBy = actualChildOptionalVaccineDetail.getModifiedBy();
        Integer actualParkingPlaceID = actualChildOptionalVaccineDetail.getParkingPlaceID();
        String actualProcessed = actualChildOptionalVaccineDetail.getProcessed();
        Integer actualProviderServiceMapID = actualChildOptionalVaccineDetail.getProviderServiceMapID();
        Timestamp actualReceivedDate = actualChildOptionalVaccineDetail.getReceivedDate();
        String actualReceivedFacilityName = actualChildOptionalVaccineDetail.getReceivedFacilityName();
        String actualReservedForChange = actualChildOptionalVaccineDetail.getReservedForChange();
        String actualSctCode = actualChildOptionalVaccineDetail.getSctCode();
        String actualSctTerm = actualChildOptionalVaccineDetail.getSctTerm();
        String actualStatus = actualChildOptionalVaccineDetail.getStatus();
        String actualSyncedBy = actualChildOptionalVaccineDetail.getSyncedBy();
        Timestamp actualSyncedDate = actualChildOptionalVaccineDetail.getSyncedDate();
        String actualVaccineName = actualChildOptionalVaccineDetail.getVaccineName();
        Integer actualVanID = actualChildOptionalVaccineDetail.getVanID();
        Long actualVanSerialNo = actualChildOptionalVaccineDetail.getVanSerialNo();
        String actualVehicalNo = actualChildOptionalVaccineDetail.getVehicalNo();
        Long actualVisitCode = actualChildOptionalVaccineDetail.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Actual Receiving Age", actualActualReceivingAge);
        assertEquals("Default Receiving Age", actualDefaultReceivingAge);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Processed", actualProcessed);
        assertEquals("Received Facility Name", actualReceivedFacilityName);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Sct Code", actualSctCode);
        assertEquals("Sct Term", actualSctTerm);
        assertEquals("Status", actualStatus);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vaccine Name", actualVaccineName);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualDeleted);
        assertSame(captureDate, actualCaptureDate);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(receivedDate, actualReceivedDate);
        assertSame(syncedDate, actualSyncedDate);
    }
}
