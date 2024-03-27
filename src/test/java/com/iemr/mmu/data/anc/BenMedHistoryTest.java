package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class BenMedHistoryTest {
    @InjectMocks
    private BenMedHistory benMedHistory;

   
    @Test
    void testGetBenPastHistory() {
        // Arrange
        ArrayList<Map<String, Object>> pastIllness = new ArrayList<>();
        pastIllness.add(new HashMap<>());

        BenMedHistory benMedHistory2 = new BenMedHistory(mock(Date.class), "Illness Type", "Other Illness Type",
                mock(Date.class), "Surgery Type", "Other Surgery Type", mock(Date.class));
        benMedHistory2.setPastSurgery(new ArrayList<>());
        benMedHistory2.setPastIllness(pastIllness);

        // Act and Assert
        assertTrue(benMedHistory2.getBenPastHistory().isEmpty());
    }

    @Test
    void testGetBenPastHistory2() {
        // Arrange
        ArrayList<Map<String, Object>> pastIllness = new ArrayList<>();
        pastIllness.add(new HashMap<>());

        ArrayList<Map<String, Object>> pastSurgery = new ArrayList<>();
        pastSurgery.add(new HashMap<>());

        BenMedHistory benMedHistory2 = new BenMedHistory(mock(Date.class), "Illness Type", "Other Illness Type",
                mock(Date.class), "Surgery Type", "Other Surgery Type", mock(Date.class));
        benMedHistory2.setPastSurgery(pastSurgery);
        benMedHistory2.setPastIllness(pastIllness);

        // Act and Assert
        assertTrue(benMedHistory2.getBenPastHistory().isEmpty());
    }

    @Test
    void testGetBenPastHistory3() {
        // Arrange
        ArrayList<Map<String, Object>> pastIllness = new ArrayList<>();
        pastIllness.add(new HashMap<>());

        ArrayList<Map<String, Object>> pastSurgery = new ArrayList<>();
        pastSurgery.add(new HashMap<>());
        pastSurgery.add(new HashMap<>());

        BenMedHistory benMedHistory2 = new BenMedHistory(mock(Date.class), "Illness Type", "Other Illness Type",
                mock(Date.class), "Surgery Type", "Other Surgery Type", mock(Date.class));
        benMedHistory2.setPastSurgery(pastSurgery);
        benMedHistory2.setPastIllness(pastIllness);

        // Act and Assert
        assertTrue(benMedHistory2.getBenPastHistory().isEmpty());
    }

    @Test
    void testGetBenPastHistory4() {
        // Arrange
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("illnessType", "42");

        ArrayList<Map<String, Object>> pastIllness = new ArrayList<>();
        pastIllness.add(stringObjectMap);

        BenMedHistory benMedHistory2 = new BenMedHistory(mock(Date.class), "Illness Type", "Other Illness Type",
                mock(Date.class), "Surgery Type", "Other Surgery Type", mock(Date.class));
        benMedHistory2.setPastSurgery(new ArrayList<>());
        benMedHistory2.setPastIllness(pastIllness);

        // Act and Assert
        assertTrue(benMedHistory2.getBenPastHistory().isEmpty());
    }

    @Test
    void testGetBenPastHistory5() {
        // Arrange
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("otherIllnessType", "42");
        stringObjectMap.put("illnessType", "42");

        ArrayList<Map<String, Object>> pastIllness = new ArrayList<>();
        pastIllness.add(stringObjectMap);

        BenMedHistory benMedHistory2 = new BenMedHistory(mock(Date.class), "Illness Type", "Other Illness Type",
                mock(Date.class), "Surgery Type", "Other Surgery Type", mock(Date.class));
        benMedHistory2.setPastSurgery(new ArrayList<>());
        benMedHistory2.setPastIllness(pastIllness);

        // Act and Assert
        assertTrue(benMedHistory2.getBenPastHistory().isEmpty());
    }

    @Test
    void testGetBenPastHistory6() {
        // Arrange
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("illnessTypeID", "42");
        stringObjectMap.put("otherIllnessType", "42");
        stringObjectMap.put("illnessType", "42");

        ArrayList<Map<String, Object>> pastIllness = new ArrayList<>();
        pastIllness.add(stringObjectMap);

        BenMedHistory benMedHistory2 = new BenMedHistory(mock(Date.class), "Illness Type", "Other Illness Type",
                mock(Date.class), "Surgery Type", "Other Surgery Type", mock(Date.class));
        benMedHistory2.setPastSurgery(new ArrayList<>());
        benMedHistory2.setPastIllness(pastIllness);

        // Act and Assert
        assertEquals(1, benMedHistory2.getBenPastHistory().size());
    }

    @Test
    void testGetBenPastHistory7() {
        // Arrange
        BenMedHistory benMedHistory2 = new BenMedHistory();

        // Act and Assert
        assertNull(benMedHistory2.getBenPastHistory(new ArrayList<>()));
    }

    @Test
    void testGetBenPastHistory8() {
        // Arrange
        BenMedHistory benMedHistory2 = new BenMedHistory(mock(Date.class), "Illness Type", "Other Illness Type",
                mock(Date.class), "Surgery Type", "Other Surgery Type", mock(Date.class));

        // Act and Assert
        assertNull(benMedHistory2.getBenPastHistory(new ArrayList<>()));
    }

    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        BenMedHistory actualBenMedHistory = new BenMedHistory();
        actualBenMedHistory.setBenMedHistoryID(1L);
        actualBenMedHistory.setBenVisitID(1L);
        actualBenMedHistory.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenMedHistory.setCaptureDate(captureDate);
        actualBenMedHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenMedHistory.setCreatedDate(createdDate);
        actualBenMedHistory.setDeleted(true);
        actualBenMedHistory.setDrugComplianceID((short) 1);
        actualBenMedHistory.setIllnessType("Illness Type");
        actualBenMedHistory.setIllnessTypeID(1);
        actualBenMedHistory.setIllness_Type("Illness Type");
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenMedHistory.setLastModDate(lastModDate);
        actualBenMedHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenMedHistory.setOtherIllnessType("Other Illness Type");
        actualBenMedHistory.setOtherSurgeryType("Other Surgery Type");
        actualBenMedHistory.setOther_Illness_Type("Other Illness Type");
        actualBenMedHistory.setOther_Surgery_Type("Other Surgery Type");
        actualBenMedHistory.setParkingPlaceID(1);
        ArrayList<Map<String, Object>> pastIllness = new ArrayList<>();
        actualBenMedHistory.setPastIllness(pastIllness);
        ArrayList<Map<String, Object>> pastSurgery = new ArrayList<>();
        actualBenMedHistory.setPastSurgery(pastSurgery);
        actualBenMedHistory.setProcessed("Processed");
        actualBenMedHistory.setProviderServiceMapID(1);
        actualBenMedHistory.setReservedForChange("Reserved For Change");
        actualBenMedHistory.setSurgeryID(1);
        actualBenMedHistory.setSurgeryType("Surgery Type");
        actualBenMedHistory.setSurgery_Type("Surgery Type");
        actualBenMedHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenMedHistory.setSyncedDate(syncedDate);
        actualBenMedHistory.setVanID(1);
        actualBenMedHistory.setVanSerialNo(1L);
        actualBenMedHistory.setVehicalNo("Vehical No");
        actualBenMedHistory.setVisitCode(1L);
        Date year_Of_Illness = mock(Date.class);
        actualBenMedHistory.setYear_Of_Illness(year_Of_Illness);
        Date year_Of_Surgery = mock(Date.class);
        actualBenMedHistory.setYear_Of_Surgery(year_Of_Surgery);
        Timestamp yearofIllness = mock(Timestamp.class);
        actualBenMedHistory.setYearofIllness(yearofIllness);
        Timestamp yearofSurgery = mock(Timestamp.class);
        actualBenMedHistory.setYearofSurgery(yearofSurgery);
        Long actualBenMedHistoryID = actualBenMedHistory.getBenMedHistoryID();
        Long actualBenVisitID = actualBenMedHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenMedHistory.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenMedHistory.getCaptureDate();
        String actualCreatedBy = actualBenMedHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenMedHistory.getCreatedDate();
        Boolean actualDeleted = actualBenMedHistory.getDeleted();
        Short actualDrugComplianceID = actualBenMedHistory.getDrugComplianceID();
        String actualIllnessType = actualBenMedHistory.getIllnessType();
        Integer actualIllnessTypeID = actualBenMedHistory.getIllnessTypeID();
        String actualIllness_Type = actualBenMedHistory.getIllness_Type();
        Timestamp actualLastModDate = actualBenMedHistory.getLastModDate();
        String actualModifiedBy = actualBenMedHistory.getModifiedBy();
        String actualOtherIllnessType = actualBenMedHistory.getOtherIllnessType();
        String actualOtherSurgeryType = actualBenMedHistory.getOtherSurgeryType();
        String actualOther_Illness_Type = actualBenMedHistory.getOther_Illness_Type();
        String actualOther_Surgery_Type = actualBenMedHistory.getOther_Surgery_Type();
        Integer actualParkingPlaceID = actualBenMedHistory.getParkingPlaceID();
        ArrayList<Map<String, Object>> actualPastIllness = actualBenMedHistory.getPastIllness();
        ArrayList<Map<String, Object>> actualPastSurgery = actualBenMedHistory.getPastSurgery();
        String actualProcessed = actualBenMedHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenMedHistory.getProviderServiceMapID();
        String actualReservedForChange = actualBenMedHistory.getReservedForChange();
        Integer actualSurgeryID = actualBenMedHistory.getSurgeryID();
        String actualSurgeryType = actualBenMedHistory.getSurgeryType();
        String actualSurgery_Type = actualBenMedHistory.getSurgery_Type();
        String actualSyncedBy = actualBenMedHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenMedHistory.getSyncedDate();
        Integer actualVanID = actualBenMedHistory.getVanID();
        Long actualVanSerialNo = actualBenMedHistory.getVanSerialNo();
        String actualVehicalNo = actualBenMedHistory.getVehicalNo();
        Long actualVisitCode = actualBenMedHistory.getVisitCode();
        Date actualYear_Of_Illness = actualBenMedHistory.getYear_Of_Illness();
        Date actualYear_Of_Surgery = actualBenMedHistory.getYear_Of_Surgery();
        Timestamp actualYearofIllness = actualBenMedHistory.getYearofIllness();
        Timestamp actualYearofSurgery = actualBenMedHistory.getYearofSurgery();

        // Assert that nothing has changed
        assertEquals("Illness Type", actualIllnessType);
        assertEquals("Illness Type", actualIllness_Type);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Illness Type", actualOtherIllnessType);
        assertEquals("Other Illness Type", actualOther_Illness_Type);
        assertEquals("Other Surgery Type", actualOtherSurgeryType);
        assertEquals("Other Surgery Type", actualOther_Surgery_Type);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Surgery Type", actualSurgeryType);
        assertEquals("Surgery Type", actualSurgery_Type);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualIllnessTypeID.intValue());
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualSurgeryID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenMedHistoryID.longValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals((short) 1, actualDrugComplianceID.shortValue());
        assertTrue(actualDeleted);
        assertSame(pastIllness, actualPastIllness);
        assertSame(pastSurgery, actualPastSurgery);
        assertSame(captureDate, actualCaptureDate);
        assertSame(year_Of_Illness, actualYear_Of_Illness);
        assertSame(year_Of_Surgery, actualYear_Of_Surgery);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
        assertSame(yearofIllness, actualYearofIllness);
        assertSame(yearofSurgery, actualYearofSurgery);
    }

    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        BenMedHistory actualBenMedHistory = new BenMedHistory(1L, 1L, 1);
        actualBenMedHistory.setBenMedHistoryID(1L);
        actualBenMedHistory.setBenVisitID(1L);
        actualBenMedHistory.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenMedHistory.setCaptureDate(captureDate);
        actualBenMedHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenMedHistory.setCreatedDate(createdDate);
        actualBenMedHistory.setDeleted(true);
        actualBenMedHistory.setDrugComplianceID((short) 1);
        actualBenMedHistory.setIllnessType("Illness Type");
        actualBenMedHistory.setIllnessTypeID(1);
        actualBenMedHistory.setIllness_Type("Illness Type");
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenMedHistory.setLastModDate(lastModDate);
        actualBenMedHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenMedHistory.setOtherIllnessType("Other Illness Type");
        actualBenMedHistory.setOtherSurgeryType("Other Surgery Type");
        actualBenMedHistory.setOther_Illness_Type("Other Illness Type");
        actualBenMedHistory.setOther_Surgery_Type("Other Surgery Type");
        actualBenMedHistory.setParkingPlaceID(1);
        ArrayList<Map<String, Object>> pastIllness = new ArrayList<>();
        actualBenMedHistory.setPastIllness(pastIllness);
        ArrayList<Map<String, Object>> pastSurgery = new ArrayList<>();
        actualBenMedHistory.setPastSurgery(pastSurgery);
        actualBenMedHistory.setProcessed("Processed");
        actualBenMedHistory.setProviderServiceMapID(1);
        actualBenMedHistory.setReservedForChange("Reserved For Change");
        actualBenMedHistory.setSurgeryID(1);
        actualBenMedHistory.setSurgeryType("Surgery Type");
        actualBenMedHistory.setSurgery_Type("Surgery Type");
        actualBenMedHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenMedHistory.setSyncedDate(syncedDate);
        actualBenMedHistory.setVanID(1);
        actualBenMedHistory.setVanSerialNo(1L);
        actualBenMedHistory.setVehicalNo("Vehical No");
        actualBenMedHistory.setVisitCode(1L);
        Date year_Of_Illness = mock(Date.class);
        actualBenMedHistory.setYear_Of_Illness(year_Of_Illness);
        Date year_Of_Surgery = mock(Date.class);
        actualBenMedHistory.setYear_Of_Surgery(year_Of_Surgery);
        Timestamp yearofIllness = mock(Timestamp.class);
        actualBenMedHistory.setYearofIllness(yearofIllness);
        Timestamp yearofSurgery = mock(Timestamp.class);
        actualBenMedHistory.setYearofSurgery(yearofSurgery);
        Long actualBenMedHistoryID = actualBenMedHistory.getBenMedHistoryID();
        Long actualBenVisitID = actualBenMedHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenMedHistory.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenMedHistory.getCaptureDate();
        String actualCreatedBy = actualBenMedHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenMedHistory.getCreatedDate();
        Boolean actualDeleted = actualBenMedHistory.getDeleted();
        Short actualDrugComplianceID = actualBenMedHistory.getDrugComplianceID();
        String actualIllnessType = actualBenMedHistory.getIllnessType();
        Integer actualIllnessTypeID = actualBenMedHistory.getIllnessTypeID();
        String actualIllness_Type = actualBenMedHistory.getIllness_Type();
        Timestamp actualLastModDate = actualBenMedHistory.getLastModDate();
        String actualModifiedBy = actualBenMedHistory.getModifiedBy();
        String actualOtherIllnessType = actualBenMedHistory.getOtherIllnessType();
        String actualOtherSurgeryType = actualBenMedHistory.getOtherSurgeryType();
        String actualOther_Illness_Type = actualBenMedHistory.getOther_Illness_Type();
        String actualOther_Surgery_Type = actualBenMedHistory.getOther_Surgery_Type();
        Integer actualParkingPlaceID = actualBenMedHistory.getParkingPlaceID();
        ArrayList<Map<String, Object>> actualPastIllness = actualBenMedHistory.getPastIllness();
        ArrayList<Map<String, Object>> actualPastSurgery = actualBenMedHistory.getPastSurgery();
        String actualProcessed = actualBenMedHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenMedHistory.getProviderServiceMapID();
        String actualReservedForChange = actualBenMedHistory.getReservedForChange();
        Integer actualSurgeryID = actualBenMedHistory.getSurgeryID();
        String actualSurgeryType = actualBenMedHistory.getSurgeryType();
        String actualSurgery_Type = actualBenMedHistory.getSurgery_Type();
        String actualSyncedBy = actualBenMedHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenMedHistory.getSyncedDate();
        Integer actualVanID = actualBenMedHistory.getVanID();
        Long actualVanSerialNo = actualBenMedHistory.getVanSerialNo();
        String actualVehicalNo = actualBenMedHistory.getVehicalNo();
        Long actualVisitCode = actualBenMedHistory.getVisitCode();
        Date actualYear_Of_Illness = actualBenMedHistory.getYear_Of_Illness();
        Date actualYear_Of_Surgery = actualBenMedHistory.getYear_Of_Surgery();
        Timestamp actualYearofIllness = actualBenMedHistory.getYearofIllness();
        Timestamp actualYearofSurgery = actualBenMedHistory.getYearofSurgery();

        // Assert that nothing has changed
        assertEquals("Illness Type", actualIllnessType);
        assertEquals("Illness Type", actualIllness_Type);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Illness Type", actualOtherIllnessType);
        assertEquals("Other Illness Type", actualOther_Illness_Type);
        assertEquals("Other Surgery Type", actualOtherSurgeryType);
        assertEquals("Other Surgery Type", actualOther_Surgery_Type);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Surgery Type", actualSurgeryType);
        assertEquals("Surgery Type", actualSurgery_Type);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualIllnessTypeID.intValue());
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualSurgeryID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenMedHistoryID.longValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals((short) 1, actualDrugComplianceID.shortValue());
        assertTrue(actualDeleted);
        assertSame(pastIllness, actualPastIllness);
        assertSame(pastSurgery, actualPastSurgery);
        assertSame(captureDate, actualCaptureDate);
        assertSame(year_Of_Illness, actualYear_Of_Illness);
        assertSame(year_Of_Surgery, actualYear_Of_Surgery);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
        assertSame(yearofIllness, actualYearofIllness);
        assertSame(yearofSurgery, actualYearofSurgery);
    }

    @Test
    void testGettersAndSetters3() {
        // Arrange and Act
        BenMedHistory actualBenMedHistory = new BenMedHistory(mock(Date.class), "Illness Type", "Other Illness Type",
                mock(Date.class), "Surgery Type", "Other Surgery Type", mock(Date.class));
        actualBenMedHistory.setBenMedHistoryID(1L);
        actualBenMedHistory.setBenVisitID(1L);
        actualBenMedHistory.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenMedHistory.setCaptureDate(captureDate);
        actualBenMedHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenMedHistory.setCreatedDate(createdDate);
        actualBenMedHistory.setDeleted(true);
        actualBenMedHistory.setDrugComplianceID((short) 1);
        actualBenMedHistory.setIllnessType("Illness Type");
        actualBenMedHistory.setIllnessTypeID(1);
        actualBenMedHistory.setIllness_Type("Illness Type");
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenMedHistory.setLastModDate(lastModDate);
        actualBenMedHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenMedHistory.setOtherIllnessType("Other Illness Type");
        actualBenMedHistory.setOtherSurgeryType("Other Surgery Type");
        actualBenMedHistory.setOther_Illness_Type("Other Illness Type");
        actualBenMedHistory.setOther_Surgery_Type("Other Surgery Type");
        actualBenMedHistory.setParkingPlaceID(1);
        ArrayList<Map<String, Object>> pastIllness = new ArrayList<>();
        actualBenMedHistory.setPastIllness(pastIllness);
        ArrayList<Map<String, Object>> pastSurgery = new ArrayList<>();
        actualBenMedHistory.setPastSurgery(pastSurgery);
        actualBenMedHistory.setProcessed("Processed");
        actualBenMedHistory.setProviderServiceMapID(1);
        actualBenMedHistory.setReservedForChange("Reserved For Change");
        actualBenMedHistory.setSurgeryID(1);
        actualBenMedHistory.setSurgeryType("Surgery Type");
        actualBenMedHistory.setSurgery_Type("Surgery Type");
        actualBenMedHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenMedHistory.setSyncedDate(syncedDate);
        actualBenMedHistory.setVanID(1);
        actualBenMedHistory.setVanSerialNo(1L);
        actualBenMedHistory.setVehicalNo("Vehical No");
        actualBenMedHistory.setVisitCode(1L);
        Date year_Of_Illness = mock(Date.class);
        actualBenMedHistory.setYear_Of_Illness(year_Of_Illness);
        Date year_Of_Surgery = mock(Date.class);
        actualBenMedHistory.setYear_Of_Surgery(year_Of_Surgery);
        Timestamp yearofIllness = mock(Timestamp.class);
        actualBenMedHistory.setYearofIllness(yearofIllness);
        Timestamp yearofSurgery = mock(Timestamp.class);
        actualBenMedHistory.setYearofSurgery(yearofSurgery);
        Long actualBenMedHistoryID = actualBenMedHistory.getBenMedHistoryID();
        Long actualBenVisitID = actualBenMedHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenMedHistory.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenMedHistory.getCaptureDate();
        String actualCreatedBy = actualBenMedHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenMedHistory.getCreatedDate();
        Boolean actualDeleted = actualBenMedHistory.getDeleted();
        Short actualDrugComplianceID = actualBenMedHistory.getDrugComplianceID();
        String actualIllnessType = actualBenMedHistory.getIllnessType();
        Integer actualIllnessTypeID = actualBenMedHistory.getIllnessTypeID();
        String actualIllness_Type = actualBenMedHistory.getIllness_Type();
        Timestamp actualLastModDate = actualBenMedHistory.getLastModDate();
        String actualModifiedBy = actualBenMedHistory.getModifiedBy();
        String actualOtherIllnessType = actualBenMedHistory.getOtherIllnessType();
        String actualOtherSurgeryType = actualBenMedHistory.getOtherSurgeryType();
        String actualOther_Illness_Type = actualBenMedHistory.getOther_Illness_Type();
        String actualOther_Surgery_Type = actualBenMedHistory.getOther_Surgery_Type();
        Integer actualParkingPlaceID = actualBenMedHistory.getParkingPlaceID();
        ArrayList<Map<String, Object>> actualPastIllness = actualBenMedHistory.getPastIllness();
        ArrayList<Map<String, Object>> actualPastSurgery = actualBenMedHistory.getPastSurgery();
        String actualProcessed = actualBenMedHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenMedHistory.getProviderServiceMapID();
        String actualReservedForChange = actualBenMedHistory.getReservedForChange();
        Integer actualSurgeryID = actualBenMedHistory.getSurgeryID();
        String actualSurgeryType = actualBenMedHistory.getSurgeryType();
        String actualSurgery_Type = actualBenMedHistory.getSurgery_Type();
        String actualSyncedBy = actualBenMedHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenMedHistory.getSyncedDate();
        Integer actualVanID = actualBenMedHistory.getVanID();
        Long actualVanSerialNo = actualBenMedHistory.getVanSerialNo();
        String actualVehicalNo = actualBenMedHistory.getVehicalNo();
        Long actualVisitCode = actualBenMedHistory.getVisitCode();
        Date actualYear_Of_Illness = actualBenMedHistory.getYear_Of_Illness();
        Date actualYear_Of_Surgery = actualBenMedHistory.getYear_Of_Surgery();
        Timestamp actualYearofIllness = actualBenMedHistory.getYearofIllness();
        Timestamp actualYearofSurgery = actualBenMedHistory.getYearofSurgery();

        // Assert that nothing has changed
        assertEquals("Illness Type", actualIllnessType);
        assertEquals("Illness Type", actualIllness_Type);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Illness Type", actualOtherIllnessType);
        assertEquals("Other Illness Type", actualOther_Illness_Type);
        assertEquals("Other Surgery Type", actualOtherSurgeryType);
        assertEquals("Other Surgery Type", actualOther_Surgery_Type);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Surgery Type", actualSurgeryType);
        assertEquals("Surgery Type", actualSurgery_Type);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualIllnessTypeID.intValue());
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualSurgeryID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenMedHistoryID.longValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals((short) 1, actualDrugComplianceID.shortValue());
        assertTrue(actualDeleted);
        assertSame(pastIllness, actualPastIllness);
        assertSame(pastSurgery, actualPastSurgery);
        assertSame(captureDate, actualCaptureDate);
        assertSame(year_Of_Illness, actualYear_Of_Illness);
        assertSame(year_Of_Surgery, actualYear_Of_Surgery);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
        assertSame(yearofIllness, actualYearofIllness);
        assertSame(yearofSurgery, actualYearofSurgery);
    }

    @Test
    void testGettersAndSetters4() {
        // Arrange and Act
        BenMedHistory actualBenMedHistory = new BenMedHistory(mock(Timestamp.class), 1, "Illness Type",
                "Other Illness Type", 1, "Surgery Type", mock(Timestamp.class), "Other Surgery Type", mock(Timestamp.class),
                1L);
        actualBenMedHistory.setBenMedHistoryID(1L);
        actualBenMedHistory.setBenVisitID(1L);
        actualBenMedHistory.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenMedHistory.setCaptureDate(captureDate);
        actualBenMedHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenMedHistory.setCreatedDate(createdDate);
        actualBenMedHistory.setDeleted(true);
        actualBenMedHistory.setDrugComplianceID((short) 1);
        actualBenMedHistory.setIllnessType("Illness Type");
        actualBenMedHistory.setIllnessTypeID(1);
        actualBenMedHistory.setIllness_Type("Illness Type");
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenMedHistory.setLastModDate(lastModDate);
        actualBenMedHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenMedHistory.setOtherIllnessType("Other Illness Type");
        actualBenMedHistory.setOtherSurgeryType("Other Surgery Type");
        actualBenMedHistory.setOther_Illness_Type("Other Illness Type");
        actualBenMedHistory.setOther_Surgery_Type("Other Surgery Type");
        actualBenMedHistory.setParkingPlaceID(1);
        ArrayList<Map<String, Object>> pastIllness = new ArrayList<>();
        actualBenMedHistory.setPastIllness(pastIllness);
        ArrayList<Map<String, Object>> pastSurgery = new ArrayList<>();
        actualBenMedHistory.setPastSurgery(pastSurgery);
        actualBenMedHistory.setProcessed("Processed");
        actualBenMedHistory.setProviderServiceMapID(1);
        actualBenMedHistory.setReservedForChange("Reserved For Change");
        actualBenMedHistory.setSurgeryID(1);
        actualBenMedHistory.setSurgeryType("Surgery Type");
        actualBenMedHistory.setSurgery_Type("Surgery Type");
        actualBenMedHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenMedHistory.setSyncedDate(syncedDate);
        actualBenMedHistory.setVanID(1);
        actualBenMedHistory.setVanSerialNo(1L);
        actualBenMedHistory.setVehicalNo("Vehical No");
        actualBenMedHistory.setVisitCode(1L);
        Date year_Of_Illness = mock(Date.class);
        actualBenMedHistory.setYear_Of_Illness(year_Of_Illness);
        Date year_Of_Surgery = mock(Date.class);
        actualBenMedHistory.setYear_Of_Surgery(year_Of_Surgery);
        Timestamp yearofIllness = mock(Timestamp.class);
        actualBenMedHistory.setYearofIllness(yearofIllness);
        Timestamp yearofSurgery = mock(Timestamp.class);
        actualBenMedHistory.setYearofSurgery(yearofSurgery);
        Long actualBenMedHistoryID = actualBenMedHistory.getBenMedHistoryID();
        Long actualBenVisitID = actualBenMedHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenMedHistory.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenMedHistory.getCaptureDate();
        String actualCreatedBy = actualBenMedHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenMedHistory.getCreatedDate();
        Boolean actualDeleted = actualBenMedHistory.getDeleted();
        Short actualDrugComplianceID = actualBenMedHistory.getDrugComplianceID();
        String actualIllnessType = actualBenMedHistory.getIllnessType();
        Integer actualIllnessTypeID = actualBenMedHistory.getIllnessTypeID();
        String actualIllness_Type = actualBenMedHistory.getIllness_Type();
        Timestamp actualLastModDate = actualBenMedHistory.getLastModDate();
        String actualModifiedBy = actualBenMedHistory.getModifiedBy();
        String actualOtherIllnessType = actualBenMedHistory.getOtherIllnessType();
        String actualOtherSurgeryType = actualBenMedHistory.getOtherSurgeryType();
        String actualOther_Illness_Type = actualBenMedHistory.getOther_Illness_Type();
        String actualOther_Surgery_Type = actualBenMedHistory.getOther_Surgery_Type();
        Integer actualParkingPlaceID = actualBenMedHistory.getParkingPlaceID();
        ArrayList<Map<String, Object>> actualPastIllness = actualBenMedHistory.getPastIllness();
        ArrayList<Map<String, Object>> actualPastSurgery = actualBenMedHistory.getPastSurgery();
        String actualProcessed = actualBenMedHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenMedHistory.getProviderServiceMapID();
        String actualReservedForChange = actualBenMedHistory.getReservedForChange();
        Integer actualSurgeryID = actualBenMedHistory.getSurgeryID();
        String actualSurgeryType = actualBenMedHistory.getSurgeryType();
        String actualSurgery_Type = actualBenMedHistory.getSurgery_Type();
        String actualSyncedBy = actualBenMedHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenMedHistory.getSyncedDate();
        Integer actualVanID = actualBenMedHistory.getVanID();
        Long actualVanSerialNo = actualBenMedHistory.getVanSerialNo();
        String actualVehicalNo = actualBenMedHistory.getVehicalNo();
        Long actualVisitCode = actualBenMedHistory.getVisitCode();
        Date actualYear_Of_Illness = actualBenMedHistory.getYear_Of_Illness();
        Date actualYear_Of_Surgery = actualBenMedHistory.getYear_Of_Surgery();
        Timestamp actualYearofIllness = actualBenMedHistory.getYearofIllness();
        Timestamp actualYearofSurgery = actualBenMedHistory.getYearofSurgery();

        // Assert that nothing has changed
        assertEquals("Illness Type", actualIllnessType);
        assertEquals("Illness Type", actualIllness_Type);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Illness Type", actualOtherIllnessType);
        assertEquals("Other Illness Type", actualOther_Illness_Type);
        assertEquals("Other Surgery Type", actualOtherSurgeryType);
        assertEquals("Other Surgery Type", actualOther_Surgery_Type);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Surgery Type", actualSurgeryType);
        assertEquals("Surgery Type", actualSurgery_Type);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualIllnessTypeID.intValue());
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualSurgeryID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenMedHistoryID.longValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals((short) 1, actualDrugComplianceID.shortValue());
        assertTrue(actualDeleted);
        assertSame(pastIllness, actualPastIllness);
        assertSame(pastSurgery, actualPastSurgery);
        assertSame(captureDate, actualCaptureDate);
        assertSame(year_Of_Illness, actualYear_Of_Illness);
        assertSame(year_Of_Surgery, actualYear_Of_Surgery);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
        assertSame(yearofIllness, actualYearofIllness);
        assertSame(yearofSurgery, actualYearofSurgery);
    }
}
