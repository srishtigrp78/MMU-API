package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class ChildVaccineDetail1Test {
    @Autowired
    private ChildVaccineDetail1 childVaccineDetail1;
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        ChildVaccineDetail1 actualChildVaccineDetail1 = new ChildVaccineDetail1();
        actualChildVaccineDetail1.setActualReceivingAge("Actual Receiving Age");
        actualChildVaccineDetail1.setBenVisitID(1L);
        actualChildVaccineDetail1.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualChildVaccineDetail1.setCaptureDate(captureDate);
        actualChildVaccineDetail1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualChildVaccineDetail1.setCreatedDate(createdDate);
        actualChildVaccineDetail1.setDefaultReceivingAge("Default Receiving Age");
        actualChildVaccineDetail1.setDeleted(true);
        actualChildVaccineDetail1.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualChildVaccineDetail1.setLastModDate(lastModDate);
        actualChildVaccineDetail1.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualChildVaccineDetail1.setParkingPlaceID(1);
        actualChildVaccineDetail1.setProcessed("Processed");
        actualChildVaccineDetail1.setProviderServiceMapID(1);
        Timestamp receivedDate = mock(Timestamp.class);
        actualChildVaccineDetail1.setReceivedDate(receivedDate);
        actualChildVaccineDetail1.setReceivedFacilityName("Received Facility Name");
        actualChildVaccineDetail1.setReservedForChange("Reserved For Change");
        actualChildVaccineDetail1.setSctCode("Sct Code");
        actualChildVaccineDetail1.setSctTerm("Sct Term");
        actualChildVaccineDetail1.setStatus(true);
        actualChildVaccineDetail1.setStatus("Status");
        actualChildVaccineDetail1.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualChildVaccineDetail1.setSyncedDate(syncedDate);
        actualChildVaccineDetail1.setVaccineName("Vaccine Name");
        ArrayList<String> vaccineNameList = new ArrayList<>();
        actualChildVaccineDetail1.setVaccineNameList(vaccineNameList);
        ArrayList<Object> vaccines = new ArrayList<>();
        actualChildVaccineDetail1.setVaccines(vaccines);
        actualChildVaccineDetail1.setVanID(1);
        actualChildVaccineDetail1.setVanSerialNo(1L);
        actualChildVaccineDetail1.setVehicalNo("Vehical No");
        actualChildVaccineDetail1.setVisitCode(1L);
        String actualActualReceivingAge = actualChildVaccineDetail1.getActualReceivingAge();
        Long actualBenVisitID = actualChildVaccineDetail1.getBenVisitID();
        Long actualBeneficiaryRegID = actualChildVaccineDetail1.getBeneficiaryRegID();
        Date actualCaptureDate = actualChildVaccineDetail1.getCaptureDate();
        String actualCreatedBy = actualChildVaccineDetail1.getCreatedBy();
        Timestamp actualCreatedDate = actualChildVaccineDetail1.getCreatedDate();
        String actualDefaultReceivingAge = actualChildVaccineDetail1.getDefaultReceivingAge();
        Boolean actualDeleted = actualChildVaccineDetail1.getDeleted();
        Long actualID = actualChildVaccineDetail1.getID();
        Timestamp actualLastModDate = actualChildVaccineDetail1.getLastModDate();
        String actualModifiedBy = actualChildVaccineDetail1.getModifiedBy();
        Integer actualParkingPlaceID = actualChildVaccineDetail1.getParkingPlaceID();
        String actualProcessed = actualChildVaccineDetail1.getProcessed();
        Integer actualProviderServiceMapID = actualChildVaccineDetail1.getProviderServiceMapID();
        Timestamp actualReceivedDate = actualChildVaccineDetail1.getReceivedDate();
        String actualReceivedFacilityName = actualChildVaccineDetail1.getReceivedFacilityName();
        String actualReservedForChange = actualChildVaccineDetail1.getReservedForChange();
        String actualSctCode = actualChildVaccineDetail1.getSctCode();
        String actualSctTerm = actualChildVaccineDetail1.getSctTerm();
        Boolean actualStatus = actualChildVaccineDetail1.getStatus();
        String actualSyncedBy = actualChildVaccineDetail1.getSyncedBy();
        Timestamp actualSyncedDate = actualChildVaccineDetail1.getSyncedDate();
        String actualVaccineName = actualChildVaccineDetail1.getVaccineName();
        List<String> actualVaccineNameList = actualChildVaccineDetail1.getVaccineNameList();
        List actualVaccines = actualChildVaccineDetail1.getVaccines();
        Integer actualVanID = actualChildVaccineDetail1.getVanID();
        Long actualVanSerialNo = actualChildVaccineDetail1.getVanSerialNo();
        String actualVehicalNo = actualChildVaccineDetail1.getVehicalNo();
        Long actualVisitCode = actualChildVaccineDetail1.getVisitCode();

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
        assertTrue(actualStatus);
        assertSame(vaccineNameList, actualVaccineNameList);
        assertSame(vaccines, actualVaccines);
        assertSame(captureDate, actualCaptureDate);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(receivedDate, actualReceivedDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        ChildVaccineDetail1 actualChildVaccineDetail1 = new ChildVaccineDetail1("Default Receiving Age");
        actualChildVaccineDetail1.setActualReceivingAge("Actual Receiving Age");
        actualChildVaccineDetail1.setBenVisitID(1L);
        actualChildVaccineDetail1.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualChildVaccineDetail1.setCaptureDate(captureDate);
        actualChildVaccineDetail1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualChildVaccineDetail1.setCreatedDate(createdDate);
        actualChildVaccineDetail1.setDefaultReceivingAge("Default Receiving Age");
        actualChildVaccineDetail1.setDeleted(true);
        actualChildVaccineDetail1.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualChildVaccineDetail1.setLastModDate(lastModDate);
        actualChildVaccineDetail1.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualChildVaccineDetail1.setParkingPlaceID(1);
        actualChildVaccineDetail1.setProcessed("Processed");
        actualChildVaccineDetail1.setProviderServiceMapID(1);
        Timestamp receivedDate = mock(Timestamp.class);
        actualChildVaccineDetail1.setReceivedDate(receivedDate);
        actualChildVaccineDetail1.setReceivedFacilityName("Received Facility Name");
        actualChildVaccineDetail1.setReservedForChange("Reserved For Change");
        actualChildVaccineDetail1.setSctCode("Sct Code");
        actualChildVaccineDetail1.setSctTerm("Sct Term");
        actualChildVaccineDetail1.setStatus(true);
        actualChildVaccineDetail1.setStatus("Status");
        actualChildVaccineDetail1.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualChildVaccineDetail1.setSyncedDate(syncedDate);
        actualChildVaccineDetail1.setVaccineName("Vaccine Name");
        ArrayList<String> vaccineNameList = new ArrayList<>();
        actualChildVaccineDetail1.setVaccineNameList(vaccineNameList);
        ArrayList<Object> vaccines = new ArrayList<>();
        actualChildVaccineDetail1.setVaccines(vaccines);
        actualChildVaccineDetail1.setVanID(1);
        actualChildVaccineDetail1.setVanSerialNo(1L);
        actualChildVaccineDetail1.setVehicalNo("Vehical No");
        actualChildVaccineDetail1.setVisitCode(1L);
        String actualActualReceivingAge = actualChildVaccineDetail1.getActualReceivingAge();
        Long actualBenVisitID = actualChildVaccineDetail1.getBenVisitID();
        Long actualBeneficiaryRegID = actualChildVaccineDetail1.getBeneficiaryRegID();
        Date actualCaptureDate = actualChildVaccineDetail1.getCaptureDate();
        String actualCreatedBy = actualChildVaccineDetail1.getCreatedBy();
        Timestamp actualCreatedDate = actualChildVaccineDetail1.getCreatedDate();
        String actualDefaultReceivingAge = actualChildVaccineDetail1.getDefaultReceivingAge();
        Boolean actualDeleted = actualChildVaccineDetail1.getDeleted();
        Long actualID = actualChildVaccineDetail1.getID();
        Timestamp actualLastModDate = actualChildVaccineDetail1.getLastModDate();
        String actualModifiedBy = actualChildVaccineDetail1.getModifiedBy();
        Integer actualParkingPlaceID = actualChildVaccineDetail1.getParkingPlaceID();
        String actualProcessed = actualChildVaccineDetail1.getProcessed();
        Integer actualProviderServiceMapID = actualChildVaccineDetail1.getProviderServiceMapID();
        Timestamp actualReceivedDate = actualChildVaccineDetail1.getReceivedDate();
        String actualReceivedFacilityName = actualChildVaccineDetail1.getReceivedFacilityName();
        String actualReservedForChange = actualChildVaccineDetail1.getReservedForChange();
        String actualSctCode = actualChildVaccineDetail1.getSctCode();
        String actualSctTerm = actualChildVaccineDetail1.getSctTerm();
        Boolean actualStatus = actualChildVaccineDetail1.getStatus();
        String actualSyncedBy = actualChildVaccineDetail1.getSyncedBy();
        Timestamp actualSyncedDate = actualChildVaccineDetail1.getSyncedDate();
        String actualVaccineName = actualChildVaccineDetail1.getVaccineName();
        List<String> actualVaccineNameList = actualChildVaccineDetail1.getVaccineNameList();
        List actualVaccines = actualChildVaccineDetail1.getVaccines();
        Integer actualVanID = actualChildVaccineDetail1.getVanID();
        Long actualVanSerialNo = actualChildVaccineDetail1.getVanSerialNo();
        String actualVehicalNo = actualChildVaccineDetail1.getVehicalNo();
        Long actualVisitCode = actualChildVaccineDetail1.getVisitCode();

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
        assertTrue(actualStatus);
        assertSame(vaccineNameList, actualVaccineNameList);
        assertSame(vaccines, actualVaccines);
        assertSame(captureDate, actualCaptureDate);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(receivedDate, actualReceivedDate);
        assertSame(syncedDate, actualSyncedDate);
    }
    @Test
    void testGettersAndSetters3() {
        // Arrange and Act
        ChildVaccineDetail1 actualChildVaccineDetail1 = new ChildVaccineDetail1("Default Receiving Age", "Vaccine Name",
                true, "Sct Code", "Sct Term");
        actualChildVaccineDetail1.setActualReceivingAge("Actual Receiving Age");
        actualChildVaccineDetail1.setBenVisitID(1L);
        actualChildVaccineDetail1.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualChildVaccineDetail1.setCaptureDate(captureDate);
        actualChildVaccineDetail1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualChildVaccineDetail1.setCreatedDate(createdDate);
        actualChildVaccineDetail1.setDefaultReceivingAge("Default Receiving Age");
        actualChildVaccineDetail1.setDeleted(true);
        actualChildVaccineDetail1.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualChildVaccineDetail1.setLastModDate(lastModDate);
        actualChildVaccineDetail1.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualChildVaccineDetail1.setParkingPlaceID(1);
        actualChildVaccineDetail1.setProcessed("Processed");
        actualChildVaccineDetail1.setProviderServiceMapID(1);
        Timestamp receivedDate = mock(Timestamp.class);
        actualChildVaccineDetail1.setReceivedDate(receivedDate);
        actualChildVaccineDetail1.setReceivedFacilityName("Received Facility Name");
        actualChildVaccineDetail1.setReservedForChange("Reserved For Change");
        actualChildVaccineDetail1.setSctCode("Sct Code");
        actualChildVaccineDetail1.setSctTerm("Sct Term");
        actualChildVaccineDetail1.setStatus(true);
        actualChildVaccineDetail1.setStatus("Status");
        actualChildVaccineDetail1.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualChildVaccineDetail1.setSyncedDate(syncedDate);
        actualChildVaccineDetail1.setVaccineName("Vaccine Name");
        ArrayList<String> vaccineNameList = new ArrayList<>();
        actualChildVaccineDetail1.setVaccineNameList(vaccineNameList);
        ArrayList<Object> vaccines = new ArrayList<>();
        actualChildVaccineDetail1.setVaccines(vaccines);
        actualChildVaccineDetail1.setVanID(1);
        actualChildVaccineDetail1.setVanSerialNo(1L);
        actualChildVaccineDetail1.setVehicalNo("Vehical No");
        actualChildVaccineDetail1.setVisitCode(1L);
        String actualActualReceivingAge = actualChildVaccineDetail1.getActualReceivingAge();
        Long actualBenVisitID = actualChildVaccineDetail1.getBenVisitID();
        Long actualBeneficiaryRegID = actualChildVaccineDetail1.getBeneficiaryRegID();
        Date actualCaptureDate = actualChildVaccineDetail1.getCaptureDate();
        String actualCreatedBy = actualChildVaccineDetail1.getCreatedBy();
        Timestamp actualCreatedDate = actualChildVaccineDetail1.getCreatedDate();
        String actualDefaultReceivingAge = actualChildVaccineDetail1.getDefaultReceivingAge();
        Boolean actualDeleted = actualChildVaccineDetail1.getDeleted();
        Long actualID = actualChildVaccineDetail1.getID();
        Timestamp actualLastModDate = actualChildVaccineDetail1.getLastModDate();
        String actualModifiedBy = actualChildVaccineDetail1.getModifiedBy();
        Integer actualParkingPlaceID = actualChildVaccineDetail1.getParkingPlaceID();
        String actualProcessed = actualChildVaccineDetail1.getProcessed();
        Integer actualProviderServiceMapID = actualChildVaccineDetail1.getProviderServiceMapID();
        Timestamp actualReceivedDate = actualChildVaccineDetail1.getReceivedDate();
        String actualReceivedFacilityName = actualChildVaccineDetail1.getReceivedFacilityName();
        String actualReservedForChange = actualChildVaccineDetail1.getReservedForChange();
        String actualSctCode = actualChildVaccineDetail1.getSctCode();
        String actualSctTerm = actualChildVaccineDetail1.getSctTerm();
        Boolean actualStatus = actualChildVaccineDetail1.getStatus();
        String actualSyncedBy = actualChildVaccineDetail1.getSyncedBy();
        Timestamp actualSyncedDate = actualChildVaccineDetail1.getSyncedDate();
        String actualVaccineName = actualChildVaccineDetail1.getVaccineName();
        List<String> actualVaccineNameList = actualChildVaccineDetail1.getVaccineNameList();
        List actualVaccines = actualChildVaccineDetail1.getVaccines();
        Integer actualVanID = actualChildVaccineDetail1.getVanID();
        Long actualVanSerialNo = actualChildVaccineDetail1.getVanSerialNo();
        String actualVehicalNo = actualChildVaccineDetail1.getVehicalNo();
        Long actualVisitCode = actualChildVaccineDetail1.getVisitCode();

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
        assertTrue(actualStatus);
        assertSame(vaccineNameList, actualVaccineNameList);
        assertSame(vaccines, actualVaccines);
        assertSame(captureDate, actualCaptureDate);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(receivedDate, actualReceivedDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testNewChildVaccineDetail1() {
        // Arrange
        Date createdDate = mock(Date.class);

        // Act
        ChildVaccineDetail1 actualChildVaccineDetail1 = new ChildVaccineDetail1(createdDate, "Default Receiving Age",
                "Vaccine Name", true);

        // Assert
        assertEquals("Default Receiving Age", actualChildVaccineDetail1.getDefaultReceivingAge());
        assertEquals("Vaccine Name", actualChildVaccineDetail1.getVaccineName());
        assertSame(createdDate, actualChildVaccineDetail1.getCaptureDate());
    }

    @Test
    void testNewChildVaccineDetail12() {
        // Arrange
        Date createdDate = mock(Date.class);

        // Act
        ChildVaccineDetail1 actualChildVaccineDetail1 = new ChildVaccineDetail1(createdDate, "Default Receiving Age",
                "Vaccine Name", false);

        // Assert
        assertEquals("Default Receiving Age", actualChildVaccineDetail1.getDefaultReceivingAge());
        assertEquals("Vaccine Name", actualChildVaccineDetail1.getVaccineName());
        assertSame(createdDate, actualChildVaccineDetail1.getCaptureDate());
    }
}
