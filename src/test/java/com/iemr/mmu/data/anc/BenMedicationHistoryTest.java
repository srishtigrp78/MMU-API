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
class BenMedicationHistoryTest {
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        BenMedicationHistory actualBenMedicationHistory = new BenMedicationHistory();
        actualBenMedicationHistory.setBenVisitID(1L);
        actualBenMedicationHistory.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenMedicationHistory.setCaptureDate(captureDate);
        actualBenMedicationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenMedicationHistory.setCreatedDate(createdDate);
        actualBenMedicationHistory.setCurrentMedication("Current Medication");
        actualBenMedicationHistory.setDeleted(true);
        actualBenMedicationHistory.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenMedicationHistory.setLastModDate(lastModDate);
        Date medication_year = mock(Date.class);
        actualBenMedicationHistory.setMedication_year(medication_year);
        actualBenMedicationHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenMedicationHistory.setParkingPlaceID(1);
        actualBenMedicationHistory.setProcessed("Processed");
        actualBenMedicationHistory.setProviderServiceMapID(1);
        actualBenMedicationHistory.setReservedForChange("Reserved For Change");
        actualBenMedicationHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenMedicationHistory.setSyncedDate(syncedDate);
        actualBenMedicationHistory.setTimePeriodAgo(1);
        actualBenMedicationHistory.setTimePeriodUnit("Time Period Unit");
        actualBenMedicationHistory.setVanID(1);
        actualBenMedicationHistory.setVanSerialNo(1L);
        actualBenMedicationHistory.setVehicalNo("Vehical No");
        actualBenMedicationHistory.setVisitCode(1L);
        Timestamp year = mock(Timestamp.class);
        actualBenMedicationHistory.setYear(year);
        Long actualBenVisitID = actualBenMedicationHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenMedicationHistory.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenMedicationHistory.getCaptureDate();
        String actualCreatedBy = actualBenMedicationHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenMedicationHistory.getCreatedDate();
        String actualCurrentMedication = actualBenMedicationHistory.getCurrentMedication();
        Boolean actualDeleted = actualBenMedicationHistory.getDeleted();
        Long actualID = actualBenMedicationHistory.getID();
        Timestamp actualLastModDate = actualBenMedicationHistory.getLastModDate();
        Date actualMedication_year = actualBenMedicationHistory.getMedication_year();
        String actualModifiedBy = actualBenMedicationHistory.getModifiedBy();
        Integer actualParkingPlaceID = actualBenMedicationHistory.getParkingPlaceID();
        String actualProcessed = actualBenMedicationHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenMedicationHistory.getProviderServiceMapID();
        String actualReservedForChange = actualBenMedicationHistory.getReservedForChange();
        String actualSyncedBy = actualBenMedicationHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenMedicationHistory.getSyncedDate();
        Integer actualTimePeriodAgo = actualBenMedicationHistory.getTimePeriodAgo();
        String actualTimePeriodUnit = actualBenMedicationHistory.getTimePeriodUnit();
        Integer actualVanID = actualBenMedicationHistory.getVanID();
        Long actualVanSerialNo = actualBenMedicationHistory.getVanSerialNo();
        String actualVehicalNo = actualBenMedicationHistory.getVehicalNo();
        Long actualVisitCode = actualBenMedicationHistory.getVisitCode();
        Timestamp actualYear = actualBenMedicationHistory.getYear();

        // Assert that nothing has changed
        assertEquals("Current Medication", actualCurrentMedication);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Time Period Unit", actualTimePeriodUnit);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualTimePeriodAgo.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualDeleted);
        assertSame(captureDate, actualCaptureDate);
        assertSame(medication_year, actualMedication_year);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
        assertSame(year, actualYear);
    }

    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        BenMedicationHistory actualBenMedicationHistory = new BenMedicationHistory("Current Medication", 1,
                "Time Period Unit", 1L);
        actualBenMedicationHistory.setBenVisitID(1L);
        actualBenMedicationHistory.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenMedicationHistory.setCaptureDate(captureDate);
        actualBenMedicationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenMedicationHistory.setCreatedDate(createdDate);
        actualBenMedicationHistory.setCurrentMedication("Current Medication");
        actualBenMedicationHistory.setDeleted(true);
        actualBenMedicationHistory.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenMedicationHistory.setLastModDate(lastModDate);
        Date medication_year = mock(Date.class);
        actualBenMedicationHistory.setMedication_year(medication_year);
        actualBenMedicationHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenMedicationHistory.setParkingPlaceID(1);
        actualBenMedicationHistory.setProcessed("Processed");
        actualBenMedicationHistory.setProviderServiceMapID(1);
        actualBenMedicationHistory.setReservedForChange("Reserved For Change");
        actualBenMedicationHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenMedicationHistory.setSyncedDate(syncedDate);
        actualBenMedicationHistory.setTimePeriodAgo(1);
        actualBenMedicationHistory.setTimePeriodUnit("Time Period Unit");
        actualBenMedicationHistory.setVanID(1);
        actualBenMedicationHistory.setVanSerialNo(1L);
        actualBenMedicationHistory.setVehicalNo("Vehical No");
        actualBenMedicationHistory.setVisitCode(1L);
        Timestamp year = mock(Timestamp.class);
        actualBenMedicationHistory.setYear(year);
        Long actualBenVisitID = actualBenMedicationHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenMedicationHistory.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenMedicationHistory.getCaptureDate();
        String actualCreatedBy = actualBenMedicationHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenMedicationHistory.getCreatedDate();
        String actualCurrentMedication = actualBenMedicationHistory.getCurrentMedication();
        Boolean actualDeleted = actualBenMedicationHistory.getDeleted();
        Long actualID = actualBenMedicationHistory.getID();
        Timestamp actualLastModDate = actualBenMedicationHistory.getLastModDate();
        Date actualMedication_year = actualBenMedicationHistory.getMedication_year();
        String actualModifiedBy = actualBenMedicationHistory.getModifiedBy();
        Integer actualParkingPlaceID = actualBenMedicationHistory.getParkingPlaceID();
        String actualProcessed = actualBenMedicationHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenMedicationHistory.getProviderServiceMapID();
        String actualReservedForChange = actualBenMedicationHistory.getReservedForChange();
        String actualSyncedBy = actualBenMedicationHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenMedicationHistory.getSyncedDate();
        Integer actualTimePeriodAgo = actualBenMedicationHistory.getTimePeriodAgo();
        String actualTimePeriodUnit = actualBenMedicationHistory.getTimePeriodUnit();
        Integer actualVanID = actualBenMedicationHistory.getVanID();
        Long actualVanSerialNo = actualBenMedicationHistory.getVanSerialNo();
        String actualVehicalNo = actualBenMedicationHistory.getVehicalNo();
        Long actualVisitCode = actualBenMedicationHistory.getVisitCode();
        Timestamp actualYear = actualBenMedicationHistory.getYear();

        // Assert that nothing has changed
        assertEquals("Current Medication", actualCurrentMedication);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Time Period Unit", actualTimePeriodUnit);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualTimePeriodAgo.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualDeleted);
        assertSame(captureDate, actualCaptureDate);
        assertSame(medication_year, actualMedication_year);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
        assertSame(year, actualYear);
    }

    @Test
    void testGettersAndSetters3() {
        // Arrange and Act
        BenMedicationHistory actualBenMedicationHistory = new BenMedicationHistory(mock(Date.class), "Current Medication",
                mock(Date.class));
        actualBenMedicationHistory.setBenVisitID(1L);
        actualBenMedicationHistory.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenMedicationHistory.setCaptureDate(captureDate);
        actualBenMedicationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenMedicationHistory.setCreatedDate(createdDate);
        actualBenMedicationHistory.setCurrentMedication("Current Medication");
        actualBenMedicationHistory.setDeleted(true);
        actualBenMedicationHistory.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenMedicationHistory.setLastModDate(lastModDate);
        Date medication_year = mock(Date.class);
        actualBenMedicationHistory.setMedication_year(medication_year);
        actualBenMedicationHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenMedicationHistory.setParkingPlaceID(1);
        actualBenMedicationHistory.setProcessed("Processed");
        actualBenMedicationHistory.setProviderServiceMapID(1);
        actualBenMedicationHistory.setReservedForChange("Reserved For Change");
        actualBenMedicationHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenMedicationHistory.setSyncedDate(syncedDate);
        actualBenMedicationHistory.setTimePeriodAgo(1);
        actualBenMedicationHistory.setTimePeriodUnit("Time Period Unit");
        actualBenMedicationHistory.setVanID(1);
        actualBenMedicationHistory.setVanSerialNo(1L);
        actualBenMedicationHistory.setVehicalNo("Vehical No");
        actualBenMedicationHistory.setVisitCode(1L);
        Timestamp year = mock(Timestamp.class);
        actualBenMedicationHistory.setYear(year);
        Long actualBenVisitID = actualBenMedicationHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenMedicationHistory.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenMedicationHistory.getCaptureDate();
        String actualCreatedBy = actualBenMedicationHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenMedicationHistory.getCreatedDate();
        String actualCurrentMedication = actualBenMedicationHistory.getCurrentMedication();
        Boolean actualDeleted = actualBenMedicationHistory.getDeleted();
        Long actualID = actualBenMedicationHistory.getID();
        Timestamp actualLastModDate = actualBenMedicationHistory.getLastModDate();
        Date actualMedication_year = actualBenMedicationHistory.getMedication_year();
        String actualModifiedBy = actualBenMedicationHistory.getModifiedBy();
        Integer actualParkingPlaceID = actualBenMedicationHistory.getParkingPlaceID();
        String actualProcessed = actualBenMedicationHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenMedicationHistory.getProviderServiceMapID();
        String actualReservedForChange = actualBenMedicationHistory.getReservedForChange();
        String actualSyncedBy = actualBenMedicationHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenMedicationHistory.getSyncedDate();
        Integer actualTimePeriodAgo = actualBenMedicationHistory.getTimePeriodAgo();
        String actualTimePeriodUnit = actualBenMedicationHistory.getTimePeriodUnit();
        Integer actualVanID = actualBenMedicationHistory.getVanID();
        Long actualVanSerialNo = actualBenMedicationHistory.getVanSerialNo();
        String actualVehicalNo = actualBenMedicationHistory.getVehicalNo();
        Long actualVisitCode = actualBenMedicationHistory.getVisitCode();
        Timestamp actualYear = actualBenMedicationHistory.getYear();

        // Assert that nothing has changed
        assertEquals("Current Medication", actualCurrentMedication);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Time Period Unit", actualTimePeriodUnit);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualTimePeriodAgo.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualDeleted);
        assertSame(captureDate, actualCaptureDate);
        assertSame(medication_year, actualMedication_year);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
        assertSame(year, actualYear);
    }
}
