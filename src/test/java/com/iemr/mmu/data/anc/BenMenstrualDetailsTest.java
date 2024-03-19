package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class BenMenstrualDetailsTest {
    @InjectMocks
    private BenMenstrualDetails benMenstrualDetails;

   
    @Test
    void testGetlMPDate() {
        // Arrange, Act and Assert
        assertNull((new BenMenstrualDetails()).getlMPDate());
        assertNull((new BenMenstrualDetails(mock(Date.class), "Regularity", "Cycle Length", "Blood Flow Duration",
                "Problem Name", mock(Date.class))).getlMPDate());
    }

    @Test
    void testGetBenMenstrualDetails() {
        // Arrange, Act and Assert
        assertNull(BenMenstrualDetails.getBenMenstrualDetails(new ArrayList<>()));
    }

    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        BenMenstrualDetails actualBenMenstrualDetails = new BenMenstrualDetails();
        actualBenMenstrualDetails.setBenMenstrualID(1);
        actualBenMenstrualDetails.setBenVisitID(1L);
        actualBenMenstrualDetails.setBeneficiaryRegID(1L);
        actualBenMenstrualDetails.setBloodFlowDuration("Blood Flow Duration");
        Date captureDate = mock(Date.class);
        actualBenMenstrualDetails.setCaptureDate(captureDate);
        actualBenMenstrualDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenMenstrualDetails.setCreatedDate(createdDate);
        actualBenMenstrualDetails.setCycleLength("Cycle Length");
        actualBenMenstrualDetails.setDeleted(true);
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenMenstrualDetails.setLastModDate(lastModDate);
        Date lmp_date = mock(Date.class);
        actualBenMenstrualDetails.setLmp_date(lmp_date);
        actualBenMenstrualDetails.setMenstrualCycleStatus("Menstrual Cycle Status");
        actualBenMenstrualDetails.setMenstrualCycleStatusID((short) 1);
        actualBenMenstrualDetails.setMenstrualCyclelengthID((short) 1);
        actualBenMenstrualDetails.setMenstrualFlowDurationID((short) 1);
        actualBenMenstrualDetails.setMenstrualProblemID("Menstrual Problem ID");
        ArrayList<Map<String, Object>> menstrualProblemList = new ArrayList<>();
        actualBenMenstrualDetails.setMenstrualProblemList(menstrualProblemList);
        actualBenMenstrualDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenMenstrualDetails.setParkingPlaceID(1);
        actualBenMenstrualDetails.setProblemName("Problem Name");
        actualBenMenstrualDetails.setProcessed("Processed");
        actualBenMenstrualDetails.setProviderServiceMapID(1);
        actualBenMenstrualDetails.setRegularity("Regularity");
        actualBenMenstrualDetails.setReservedForChange("Reserved For Change");
        actualBenMenstrualDetails.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenMenstrualDetails.setSyncedDate(syncedDate);
        actualBenMenstrualDetails.setVanID(1);
        actualBenMenstrualDetails.setVanSerialNo(1L);
        actualBenMenstrualDetails.setVehicalNo("Vehical No");
        actualBenMenstrualDetails.setVisitCode(1L);
        actualBenMenstrualDetails.setlMPDate(mock(Timestamp.class));
        Integer actualBenMenstrualID = actualBenMenstrualDetails.getBenMenstrualID();
        Long actualBenVisitID = actualBenMenstrualDetails.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenMenstrualDetails.getBeneficiaryRegID();
        String actualBloodFlowDuration = actualBenMenstrualDetails.getBloodFlowDuration();
        Date actualCaptureDate = actualBenMenstrualDetails.getCaptureDate();
        String actualCreatedBy = actualBenMenstrualDetails.getCreatedBy();
        Timestamp actualCreatedDate = actualBenMenstrualDetails.getCreatedDate();
        String actualCycleLength = actualBenMenstrualDetails.getCycleLength();
        Boolean actualDeleted = actualBenMenstrualDetails.getDeleted();
        Timestamp actualLastModDate = actualBenMenstrualDetails.getLastModDate();
        Date actualLmp_date = actualBenMenstrualDetails.getLmp_date();
        String actualMenstrualCycleStatus = actualBenMenstrualDetails.getMenstrualCycleStatus();
        Short actualMenstrualCycleStatusID = actualBenMenstrualDetails.getMenstrualCycleStatusID();
        Short actualMenstrualCyclelengthID = actualBenMenstrualDetails.getMenstrualCyclelengthID();
        Short actualMenstrualFlowDurationID = actualBenMenstrualDetails.getMenstrualFlowDurationID();
        String actualMenstrualProblemID = actualBenMenstrualDetails.getMenstrualProblemID();
        ArrayList<Map<String, Object>> actualMenstrualProblemList = actualBenMenstrualDetails.getMenstrualProblemList();
        String actualModifiedBy = actualBenMenstrualDetails.getModifiedBy();
        Integer actualParkingPlaceID = actualBenMenstrualDetails.getParkingPlaceID();
        String actualProblemName = actualBenMenstrualDetails.getProblemName();
        String actualProcessed = actualBenMenstrualDetails.getProcessed();
        Integer actualProviderServiceMapID = actualBenMenstrualDetails.getProviderServiceMapID();
        String actualRegularity = actualBenMenstrualDetails.getRegularity();
        String actualReservedForChange = actualBenMenstrualDetails.getReservedForChange();
        String actualSyncedBy = actualBenMenstrualDetails.getSyncedBy();
        Timestamp actualSyncedDate = actualBenMenstrualDetails.getSyncedDate();
        Integer actualVanID = actualBenMenstrualDetails.getVanID();
        Long actualVanSerialNo = actualBenMenstrualDetails.getVanSerialNo();
        String actualVehicalNo = actualBenMenstrualDetails.getVehicalNo();
        Long actualVisitCode = actualBenMenstrualDetails.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Blood Flow Duration", actualBloodFlowDuration);
        assertEquals("Cycle Length", actualCycleLength);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Menstrual Cycle Status", actualMenstrualCycleStatus);
        assertEquals("Menstrual Problem ID", actualMenstrualProblemID);
        assertEquals("Problem Name", actualProblemName);
        assertEquals("Processed", actualProcessed);
        assertEquals("Regularity", actualRegularity);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualBenMenstrualID.intValue());
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals((short) 1, actualMenstrualCycleStatusID.shortValue());
        assertEquals((short) 1, actualMenstrualCyclelengthID.shortValue());
        assertEquals((short) 1, actualMenstrualFlowDurationID.shortValue());
        assertTrue(actualDeleted);
        assertSame(menstrualProblemList, actualMenstrualProblemList);
        assertSame(captureDate, actualCaptureDate);
        assertSame(lmp_date, actualLmp_date);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }
    
    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        BenMenstrualDetails actualBenMenstrualDetails = new BenMenstrualDetails(1L, 1L, 1, (short) 1,
                "Menstrual Cycle Status", "Regularity", (short) 1, "Cycle Length", (short) 1, "Blood Flow Duration",
                "Menstrual Problem ID", "Problem Name", mock(Timestamp.class), 1L);
        actualBenMenstrualDetails.setBenMenstrualID(1);
        actualBenMenstrualDetails.setBenVisitID(1L);
        actualBenMenstrualDetails.setBeneficiaryRegID(1L);
        actualBenMenstrualDetails.setBloodFlowDuration("Blood Flow Duration");
        Date captureDate = mock(Date.class);
        actualBenMenstrualDetails.setCaptureDate(captureDate);
        actualBenMenstrualDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenMenstrualDetails.setCreatedDate(createdDate);
        actualBenMenstrualDetails.setCycleLength("Cycle Length");
        actualBenMenstrualDetails.setDeleted(true);
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenMenstrualDetails.setLastModDate(lastModDate);
        Date lmp_date = mock(Date.class);
        actualBenMenstrualDetails.setLmp_date(lmp_date);
        actualBenMenstrualDetails.setMenstrualCycleStatus("Menstrual Cycle Status");
        actualBenMenstrualDetails.setMenstrualCycleStatusID((short) 1);
        actualBenMenstrualDetails.setMenstrualCyclelengthID((short) 1);
        actualBenMenstrualDetails.setMenstrualFlowDurationID((short) 1);
        actualBenMenstrualDetails.setMenstrualProblemID("Menstrual Problem ID");
        ArrayList<Map<String, Object>> menstrualProblemList = new ArrayList<>();
        actualBenMenstrualDetails.setMenstrualProblemList(menstrualProblemList);
        actualBenMenstrualDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenMenstrualDetails.setParkingPlaceID(1);
        actualBenMenstrualDetails.setProblemName("Problem Name");
        actualBenMenstrualDetails.setProcessed("Processed");
        actualBenMenstrualDetails.setProviderServiceMapID(1);
        actualBenMenstrualDetails.setRegularity("Regularity");
        actualBenMenstrualDetails.setReservedForChange("Reserved For Change");
        actualBenMenstrualDetails.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenMenstrualDetails.setSyncedDate(syncedDate);
        actualBenMenstrualDetails.setVanID(1);
        actualBenMenstrualDetails.setVanSerialNo(1L);
        actualBenMenstrualDetails.setVehicalNo("Vehical No");
        actualBenMenstrualDetails.setVisitCode(1L);
        actualBenMenstrualDetails.setlMPDate(mock(Timestamp.class));
        Integer actualBenMenstrualID = actualBenMenstrualDetails.getBenMenstrualID();
        Long actualBenVisitID = actualBenMenstrualDetails.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenMenstrualDetails.getBeneficiaryRegID();
        String actualBloodFlowDuration = actualBenMenstrualDetails.getBloodFlowDuration();
        Date actualCaptureDate = actualBenMenstrualDetails.getCaptureDate();
        String actualCreatedBy = actualBenMenstrualDetails.getCreatedBy();
        Timestamp actualCreatedDate = actualBenMenstrualDetails.getCreatedDate();
        String actualCycleLength = actualBenMenstrualDetails.getCycleLength();
        Boolean actualDeleted = actualBenMenstrualDetails.getDeleted();
        Timestamp actualLastModDate = actualBenMenstrualDetails.getLastModDate();
        Date actualLmp_date = actualBenMenstrualDetails.getLmp_date();
        String actualMenstrualCycleStatus = actualBenMenstrualDetails.getMenstrualCycleStatus();
        Short actualMenstrualCycleStatusID = actualBenMenstrualDetails.getMenstrualCycleStatusID();
        Short actualMenstrualCyclelengthID = actualBenMenstrualDetails.getMenstrualCyclelengthID();
        Short actualMenstrualFlowDurationID = actualBenMenstrualDetails.getMenstrualFlowDurationID();
        String actualMenstrualProblemID = actualBenMenstrualDetails.getMenstrualProblemID();
        ArrayList<Map<String, Object>> actualMenstrualProblemList = actualBenMenstrualDetails.getMenstrualProblemList();
        String actualModifiedBy = actualBenMenstrualDetails.getModifiedBy();
        Integer actualParkingPlaceID = actualBenMenstrualDetails.getParkingPlaceID();
        String actualProblemName = actualBenMenstrualDetails.getProblemName();
        String actualProcessed = actualBenMenstrualDetails.getProcessed();
        Integer actualProviderServiceMapID = actualBenMenstrualDetails.getProviderServiceMapID();
        String actualRegularity = actualBenMenstrualDetails.getRegularity();
        String actualReservedForChange = actualBenMenstrualDetails.getReservedForChange();
        String actualSyncedBy = actualBenMenstrualDetails.getSyncedBy();
        Timestamp actualSyncedDate = actualBenMenstrualDetails.getSyncedDate();
        Integer actualVanID = actualBenMenstrualDetails.getVanID();
        Long actualVanSerialNo = actualBenMenstrualDetails.getVanSerialNo();
        String actualVehicalNo = actualBenMenstrualDetails.getVehicalNo();
        Long actualVisitCode = actualBenMenstrualDetails.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Blood Flow Duration", actualBloodFlowDuration);
        assertEquals("Cycle Length", actualCycleLength);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Menstrual Cycle Status", actualMenstrualCycleStatus);
        assertEquals("Menstrual Problem ID", actualMenstrualProblemID);
        assertEquals("Problem Name", actualProblemName);
        assertEquals("Processed", actualProcessed);
        assertEquals("Regularity", actualRegularity);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualBenMenstrualID.intValue());
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals((short) 1, actualMenstrualCycleStatusID.shortValue());
        assertEquals((short) 1, actualMenstrualCyclelengthID.shortValue());
        assertEquals((short) 1, actualMenstrualFlowDurationID.shortValue());
        assertTrue(actualDeleted);
        assertSame(menstrualProblemList, actualMenstrualProblemList);
        assertSame(captureDate, actualCaptureDate);
        assertSame(lmp_date, actualLmp_date);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters3() {
        // Arrange and Act
        BenMenstrualDetails actualBenMenstrualDetails = new BenMenstrualDetails(mock(Date.class), "Regularity",
                "Cycle Length", "Blood Flow Duration", "Problem Name", mock(Date.class));
        actualBenMenstrualDetails.setBenMenstrualID(1);
        actualBenMenstrualDetails.setBenVisitID(1L);
        actualBenMenstrualDetails.setBeneficiaryRegID(1L);
        actualBenMenstrualDetails.setBloodFlowDuration("Blood Flow Duration");
        Date captureDate = mock(Date.class);
        actualBenMenstrualDetails.setCaptureDate(captureDate);
        actualBenMenstrualDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenMenstrualDetails.setCreatedDate(createdDate);
        actualBenMenstrualDetails.setCycleLength("Cycle Length");
        actualBenMenstrualDetails.setDeleted(true);
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenMenstrualDetails.setLastModDate(lastModDate);
        Date lmp_date = mock(Date.class);
        actualBenMenstrualDetails.setLmp_date(lmp_date);
        actualBenMenstrualDetails.setMenstrualCycleStatus("Menstrual Cycle Status");
        actualBenMenstrualDetails.setMenstrualCycleStatusID((short) 1);
        actualBenMenstrualDetails.setMenstrualCyclelengthID((short) 1);
        actualBenMenstrualDetails.setMenstrualFlowDurationID((short) 1);
        actualBenMenstrualDetails.setMenstrualProblemID("Menstrual Problem ID");
        ArrayList<Map<String, Object>> menstrualProblemList = new ArrayList<>();
        actualBenMenstrualDetails.setMenstrualProblemList(menstrualProblemList);
        actualBenMenstrualDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenMenstrualDetails.setParkingPlaceID(1);
        actualBenMenstrualDetails.setProblemName("Problem Name");
        actualBenMenstrualDetails.setProcessed("Processed");
        actualBenMenstrualDetails.setProviderServiceMapID(1);
        actualBenMenstrualDetails.setRegularity("Regularity");
        actualBenMenstrualDetails.setReservedForChange("Reserved For Change");
        actualBenMenstrualDetails.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenMenstrualDetails.setSyncedDate(syncedDate);
        actualBenMenstrualDetails.setVanID(1);
        actualBenMenstrualDetails.setVanSerialNo(1L);
        actualBenMenstrualDetails.setVehicalNo("Vehical No");
        actualBenMenstrualDetails.setVisitCode(1L);
        actualBenMenstrualDetails.setlMPDate(mock(Timestamp.class));
        Integer actualBenMenstrualID = actualBenMenstrualDetails.getBenMenstrualID();
        Long actualBenVisitID = actualBenMenstrualDetails.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenMenstrualDetails.getBeneficiaryRegID();
        String actualBloodFlowDuration = actualBenMenstrualDetails.getBloodFlowDuration();
        Date actualCaptureDate = actualBenMenstrualDetails.getCaptureDate();
        String actualCreatedBy = actualBenMenstrualDetails.getCreatedBy();
        Timestamp actualCreatedDate = actualBenMenstrualDetails.getCreatedDate();
        String actualCycleLength = actualBenMenstrualDetails.getCycleLength();
        Boolean actualDeleted = actualBenMenstrualDetails.getDeleted();
        Timestamp actualLastModDate = actualBenMenstrualDetails.getLastModDate();
        Date actualLmp_date = actualBenMenstrualDetails.getLmp_date();
        String actualMenstrualCycleStatus = actualBenMenstrualDetails.getMenstrualCycleStatus();
        Short actualMenstrualCycleStatusID = actualBenMenstrualDetails.getMenstrualCycleStatusID();
        Short actualMenstrualCyclelengthID = actualBenMenstrualDetails.getMenstrualCyclelengthID();
        Short actualMenstrualFlowDurationID = actualBenMenstrualDetails.getMenstrualFlowDurationID();
        String actualMenstrualProblemID = actualBenMenstrualDetails.getMenstrualProblemID();
        ArrayList<Map<String, Object>> actualMenstrualProblemList = actualBenMenstrualDetails.getMenstrualProblemList();
        String actualModifiedBy = actualBenMenstrualDetails.getModifiedBy();
        Integer actualParkingPlaceID = actualBenMenstrualDetails.getParkingPlaceID();
        String actualProblemName = actualBenMenstrualDetails.getProblemName();
        String actualProcessed = actualBenMenstrualDetails.getProcessed();
        Integer actualProviderServiceMapID = actualBenMenstrualDetails.getProviderServiceMapID();
        String actualRegularity = actualBenMenstrualDetails.getRegularity();
        String actualReservedForChange = actualBenMenstrualDetails.getReservedForChange();
        String actualSyncedBy = actualBenMenstrualDetails.getSyncedBy();
        Timestamp actualSyncedDate = actualBenMenstrualDetails.getSyncedDate();
        Integer actualVanID = actualBenMenstrualDetails.getVanID();
        Long actualVanSerialNo = actualBenMenstrualDetails.getVanSerialNo();
        String actualVehicalNo = actualBenMenstrualDetails.getVehicalNo();
        Long actualVisitCode = actualBenMenstrualDetails.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Blood Flow Duration", actualBloodFlowDuration);
        assertEquals("Cycle Length", actualCycleLength);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Menstrual Cycle Status", actualMenstrualCycleStatus);
        assertEquals("Menstrual Problem ID", actualMenstrualProblemID);
        assertEquals("Problem Name", actualProblemName);
        assertEquals("Processed", actualProcessed);
        assertEquals("Regularity", actualRegularity);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualBenMenstrualID.intValue());
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals((short) 1, actualMenstrualCycleStatusID.shortValue());
        assertEquals((short) 1, actualMenstrualCyclelengthID.shortValue());
        assertEquals((short) 1, actualMenstrualFlowDurationID.shortValue());
        assertTrue(actualDeleted);
        assertSame(menstrualProblemList, actualMenstrualProblemList);
        assertSame(captureDate, actualCaptureDate);
        assertSame(lmp_date, actualLmp_date);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }
}
