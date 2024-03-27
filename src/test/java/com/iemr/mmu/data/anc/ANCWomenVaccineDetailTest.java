package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class ANCWomenVaccineDetailTest {
   
    @Test
    void testGetANCWomenVaccineDetails() {
        ArrayList<Object[]> resList = new ArrayList<>();
        resList.add(new Object[]{"42"});
       // ANCWomenVaccineDetail.getANCWomenVaccineDetails(resList);
    }

    @Test
    void testGetANCWomenVaccineDetails2() {
        ANCWomenVaccineDetail.getANCWomenVaccineDetails(new ArrayList<>());
    }

    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        ANCWomenVaccineDetail actualAncWomenVaccineDetail = new ANCWomenVaccineDetail();
        actualAncWomenVaccineDetail.setBenVisitID(1L);
        actualAncWomenVaccineDetail.setBeneficiaryRegID(1L);
        actualAncWomenVaccineDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualAncWomenVaccineDetail.setCreatedDate(createdDate);
        actualAncWomenVaccineDetail.setDeleted(true);
        actualAncWomenVaccineDetail.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualAncWomenVaccineDetail.setLastModDate(lastModDate);
        actualAncWomenVaccineDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualAncWomenVaccineDetail.setParkingPlaceID(1);
        actualAncWomenVaccineDetail.setProcessed("Processed");
        actualAncWomenVaccineDetail.setProviderServiceMapID(1);
        Date receivedDate = mock(Date.class);
        actualAncWomenVaccineDetail.setReceivedDate(receivedDate);
        actualAncWomenVaccineDetail.setReceivedFacilityName("Received Facility Name");
        actualAncWomenVaccineDetail.setReservedForChange("Reserved For Change");
        actualAncWomenVaccineDetail.setStatus("Status");
        actualAncWomenVaccineDetail.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualAncWomenVaccineDetail.setSyncedDate(syncedDate);
        actualAncWomenVaccineDetail.setVaccineName("Vaccine Name");
        actualAncWomenVaccineDetail.setVanID(1);
        actualAncWomenVaccineDetail.setVanSerialNo(1L);
        actualAncWomenVaccineDetail.setVehicalNo("Vehical No");
        actualAncWomenVaccineDetail.setVisitCode(1L);
        Long actualBenVisitID = actualAncWomenVaccineDetail.getBenVisitID();
        Long actualBeneficiaryRegID = actualAncWomenVaccineDetail.getBeneficiaryRegID();
        String actualCreatedBy = actualAncWomenVaccineDetail.getCreatedBy();
        Timestamp actualCreatedDate = actualAncWomenVaccineDetail.getCreatedDate();
        Boolean actualDeleted = actualAncWomenVaccineDetail.getDeleted();
        Long actualID = actualAncWomenVaccineDetail.getID();
        Timestamp actualLastModDate = actualAncWomenVaccineDetail.getLastModDate();
        String actualModifiedBy = actualAncWomenVaccineDetail.getModifiedBy();
        Integer actualParkingPlaceID = actualAncWomenVaccineDetail.getParkingPlaceID();
        String actualProcessed = actualAncWomenVaccineDetail.getProcessed();
        Integer actualProviderServiceMapID = actualAncWomenVaccineDetail.getProviderServiceMapID();
        Date actualReceivedDate = actualAncWomenVaccineDetail.getReceivedDate();
        String actualReceivedFacilityName = actualAncWomenVaccineDetail.getReceivedFacilityName();
        String actualReservedForChange = actualAncWomenVaccineDetail.getReservedForChange();
        String actualStatus = actualAncWomenVaccineDetail.getStatus();
        String actualSyncedBy = actualAncWomenVaccineDetail.getSyncedBy();
        Timestamp actualSyncedDate = actualAncWomenVaccineDetail.getSyncedDate();
        String actualVaccineName = actualAncWomenVaccineDetail.getVaccineName();
        Integer actualVanID = actualAncWomenVaccineDetail.getVanID();
        Long actualVanSerialNo = actualAncWomenVaccineDetail.getVanSerialNo();
        String actualVehicalNo = actualAncWomenVaccineDetail.getVehicalNo();
        Long actualVisitCode = actualAncWomenVaccineDetail.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Processed", actualProcessed);
        assertEquals("Received Facility Name", actualReceivedFacilityName);
        assertEquals("Reserved For Change", actualReservedForChange);
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
        assertSame(receivedDate, actualReceivedDate);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        ANCWomenVaccineDetail actualAncWomenVaccineDetail = new ANCWomenVaccineDetail(1L, 1L, 1L, 1, "Vaccine Name",
                "Status", mock(Date.class), "Received Facility Name");
        actualAncWomenVaccineDetail.setBenVisitID(1L);
        actualAncWomenVaccineDetail.setBeneficiaryRegID(1L);
        actualAncWomenVaccineDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualAncWomenVaccineDetail.setCreatedDate(createdDate);
        actualAncWomenVaccineDetail.setDeleted(true);
        actualAncWomenVaccineDetail.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualAncWomenVaccineDetail.setLastModDate(lastModDate);
        actualAncWomenVaccineDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualAncWomenVaccineDetail.setParkingPlaceID(1);
        actualAncWomenVaccineDetail.setProcessed("Processed");
        actualAncWomenVaccineDetail.setProviderServiceMapID(1);
        Date receivedDate = mock(Date.class);
        actualAncWomenVaccineDetail.setReceivedDate(receivedDate);
        actualAncWomenVaccineDetail.setReceivedFacilityName("Received Facility Name");
        actualAncWomenVaccineDetail.setReservedForChange("Reserved For Change");
        actualAncWomenVaccineDetail.setStatus("Status");
        actualAncWomenVaccineDetail.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualAncWomenVaccineDetail.setSyncedDate(syncedDate);
        actualAncWomenVaccineDetail.setVaccineName("Vaccine Name");
        actualAncWomenVaccineDetail.setVanID(1);
        actualAncWomenVaccineDetail.setVanSerialNo(1L);
        actualAncWomenVaccineDetail.setVehicalNo("Vehical No");
        actualAncWomenVaccineDetail.setVisitCode(1L);
        Long actualBenVisitID = actualAncWomenVaccineDetail.getBenVisitID();
        Long actualBeneficiaryRegID = actualAncWomenVaccineDetail.getBeneficiaryRegID();
        String actualCreatedBy = actualAncWomenVaccineDetail.getCreatedBy();
        Timestamp actualCreatedDate = actualAncWomenVaccineDetail.getCreatedDate();
        Boolean actualDeleted = actualAncWomenVaccineDetail.getDeleted();
        Long actualID = actualAncWomenVaccineDetail.getID();
        Timestamp actualLastModDate = actualAncWomenVaccineDetail.getLastModDate();
        String actualModifiedBy = actualAncWomenVaccineDetail.getModifiedBy();
        Integer actualParkingPlaceID = actualAncWomenVaccineDetail.getParkingPlaceID();
        String actualProcessed = actualAncWomenVaccineDetail.getProcessed();
        Integer actualProviderServiceMapID = actualAncWomenVaccineDetail.getProviderServiceMapID();
        Date actualReceivedDate = actualAncWomenVaccineDetail.getReceivedDate();
        String actualReceivedFacilityName = actualAncWomenVaccineDetail.getReceivedFacilityName();
        String actualReservedForChange = actualAncWomenVaccineDetail.getReservedForChange();
        String actualStatus = actualAncWomenVaccineDetail.getStatus();
        String actualSyncedBy = actualAncWomenVaccineDetail.getSyncedBy();
        Timestamp actualSyncedDate = actualAncWomenVaccineDetail.getSyncedDate();
        String actualVaccineName = actualAncWomenVaccineDetail.getVaccineName();
        Integer actualVanID = actualAncWomenVaccineDetail.getVanID();
        Long actualVanSerialNo = actualAncWomenVaccineDetail.getVanSerialNo();
        String actualVehicalNo = actualAncWomenVaccineDetail.getVehicalNo();
        Long actualVisitCode = actualAncWomenVaccineDetail.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Processed", actualProcessed);
        assertEquals("Received Facility Name", actualReceivedFacilityName);
        assertEquals("Reserved For Change", actualReservedForChange);
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
        assertSame(receivedDate, actualReceivedDate);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }
}
