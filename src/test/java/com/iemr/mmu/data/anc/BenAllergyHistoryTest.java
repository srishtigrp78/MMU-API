package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class BenAllergyHistoryTest {
    @Autowired
    private BenAllergyHistory benAllergyHistory;

    
    @Test
    void testGetBenAllergicHistory() {
        // Arrange
        BenAllergyHistory benAllergyHistory2 = new BenAllergyHistory();
        benAllergyHistory2.setAllergicList(new ArrayList<>());

        // Act and Assert
        assertTrue(benAllergyHistory2.getBenAllergicHistory().isEmpty());
    }

    
    @Test
    void testGetBenAllergicHistory2() {
        // Arrange
        ArrayList<Map<String, Object>> allergicList = new ArrayList<>();
        allergicList.add(new HashMap<>());

        BenAllergyHistory benAllergyHistory2 = new BenAllergyHistory();
        benAllergyHistory2.setAllergicList(allergicList);

        // Act and Assert
        assertEquals(1, benAllergyHistory2.getBenAllergicHistory().size());
        assertEquals(1, benAllergyHistory2.getAllergicList().get(0).size());
    }

    @Test
    void testGetBenAllergicHistory3() {
        // Arrange
        BenAllergyHistory benAllergyHistory2 = new BenAllergyHistory(mock(Date.class), "Allergy Status", "Allergy Type",
                "Allergen Name", "Allergic Reaction Type", "Other Allergic Reaction", "Remarks");
        benAllergyHistory2.setAllergicList(new ArrayList<>());

        // Act and Assert
        assertEquals(1, benAllergyHistory2.getBenAllergicHistory().size());
    }

    
    @Test
    void testGetBenAllergicHistory4() {
        // Arrange
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("snomedCode", "42");

        ArrayList<Map<String, Object>> allergicList = new ArrayList<>();
        allergicList.add(stringObjectMap);

        BenAllergyHistory benAllergyHistory2 = new BenAllergyHistory();
        benAllergyHistory2.setAllergicList(allergicList);

        // Act and Assert
        assertEquals(1, benAllergyHistory2.getBenAllergicHistory().size());
    }

    
    @Test
    void testGetBenAllergicHistory5() {
        // Arrange
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("allergyName", "42");
        stringObjectMap.put("snomedCode", "42");

        ArrayList<Map<String, Object>> allergicList = new ArrayList<>();
        allergicList.add(stringObjectMap);

        BenAllergyHistory benAllergyHistory2 = new BenAllergyHistory();
        benAllergyHistory2.setAllergicList(allergicList);

        // Act and Assert
        assertEquals(1, benAllergyHistory2.getBenAllergicHistory().size());
    }

   
    @Test
    void testGetBenAllergicHistory6() {
        // Arrange
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("allergyType", "42");

        ArrayList<Map<String, Object>> allergicList = new ArrayList<>();
        allergicList.add(stringObjectMap);

        BenAllergyHistory benAllergyHistory2 = new BenAllergyHistory();
        benAllergyHistory2.setAllergicList(allergicList);

        // Act and Assert
        assertEquals(1, benAllergyHistory2.getBenAllergicHistory().size());
        assertEquals(2, benAllergyHistory2.getAllergicList().get(0).size());
    }

    @Test
    void testGetBenAllergicHistory7() {
        // Arrange and Act
        ArrayList<BenAllergyHistory> actualBenAllergicHistory = BenAllergyHistory.getBenAllergicHistory(new ArrayList<>());

        // Assert
        assertTrue(actualBenAllergicHistory.isEmpty());
    }

    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        BenAllergyHistory actualBenAllergyHistory = new BenAllergyHistory();
        ArrayList<Map<String, Object>> allergicList = new ArrayList<>();
        actualBenAllergyHistory.setAllergicList(allergicList);
        actualBenAllergyHistory.setAllergicReactionType("Allergic Reaction Type");
        actualBenAllergyHistory.setAllergicReactionTypeID("Allergic Reaction Type ID");
        actualBenAllergyHistory.setAllergyName("Allergy Name");
        actualBenAllergyHistory.setAllergyStatus("Allergy Status");
        actualBenAllergyHistory.setAllergyType("Allergy Type");
        actualBenAllergyHistory.setBenVisitID(1L);
        actualBenAllergyHistory.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenAllergyHistory.setCaptureDate(captureDate);
        actualBenAllergyHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenAllergyHistory.setCreatedDate(createdDate);
        actualBenAllergyHistory.setDeleted(true);
        actualBenAllergyHistory.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenAllergyHistory.setLastModDate(lastModDate);
        actualBenAllergyHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenAllergyHistory.setOtherAllergicReaction("Other Allergic Reaction");
        actualBenAllergyHistory.setParkingPlaceID(1);
        actualBenAllergyHistory.setProcessed("Processed");
        actualBenAllergyHistory.setProviderServiceMapID(1);
        actualBenAllergyHistory.setRemarks("Remarks");
        actualBenAllergyHistory.setReservedForChange("Reserved For Change");
        actualBenAllergyHistory.setSnomedCode("Snomed Code");
        actualBenAllergyHistory.setSnomedTerm("Snomed Term");
        actualBenAllergyHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenAllergyHistory.setSyncedDate(syncedDate);
        ArrayList<Map<String, String>> typeOfAllergicReactions = new ArrayList<>();
        actualBenAllergyHistory.setTypeOfAllergicReactions(typeOfAllergicReactions);
        actualBenAllergyHistory.setVanID(1);
        actualBenAllergyHistory.setVanSerialNo(1L);
        actualBenAllergyHistory.setVehicalNo("Vehical No");
        actualBenAllergyHistory.setVisitCode(1L);
        List<Map<String, Object>> actualAllergicList = actualBenAllergyHistory.getAllergicList();
        String actualAllergicReactionType = actualBenAllergyHistory.getAllergicReactionType();
        String actualAllergicReactionTypeID = actualBenAllergyHistory.getAllergicReactionTypeID();
        String actualAllergyName = actualBenAllergyHistory.getAllergyName();
        String actualAllergyStatus = actualBenAllergyHistory.getAllergyStatus();
        String actualAllergyType = actualBenAllergyHistory.getAllergyType();
        Long actualBenVisitID = actualBenAllergyHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenAllergyHistory.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenAllergyHistory.getCaptureDate();
        String actualCreatedBy = actualBenAllergyHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenAllergyHistory.getCreatedDate();
        Boolean actualDeleted = actualBenAllergyHistory.getDeleted();
        Long actualID = actualBenAllergyHistory.getID();
        Timestamp actualLastModDate = actualBenAllergyHistory.getLastModDate();
        String actualModifiedBy = actualBenAllergyHistory.getModifiedBy();
        String actualOtherAllergicReaction = actualBenAllergyHistory.getOtherAllergicReaction();
        Integer actualParkingPlaceID = actualBenAllergyHistory.getParkingPlaceID();
        String actualProcessed = actualBenAllergyHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenAllergyHistory.getProviderServiceMapID();
        String actualRemarks = actualBenAllergyHistory.getRemarks();
        String actualReservedForChange = actualBenAllergyHistory.getReservedForChange();
        String actualSnomedCode = actualBenAllergyHistory.getSnomedCode();
        String actualSnomedTerm = actualBenAllergyHistory.getSnomedTerm();
        String actualSyncedBy = actualBenAllergyHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenAllergyHistory.getSyncedDate();
        List<Map<String, String>> actualTypeOfAllergicReactions = actualBenAllergyHistory.getTypeOfAllergicReactions();
        Integer actualVanID = actualBenAllergyHistory.getVanID();
        Long actualVanSerialNo = actualBenAllergyHistory.getVanSerialNo();
        String actualVehicalNo = actualBenAllergyHistory.getVehicalNo();
        Long actualVisitCode = actualBenAllergyHistory.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Allergic Reaction Type ID", actualAllergicReactionTypeID);
        assertEquals("Allergic Reaction Type", actualAllergicReactionType);
        assertEquals("Allergy Name", actualAllergyName);
        assertEquals("Allergy Status", actualAllergyStatus);
        assertEquals("Allergy Type", actualAllergyType);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Allergic Reaction", actualOtherAllergicReaction);
        assertEquals("Processed", actualProcessed);
        assertEquals("Remarks", actualRemarks);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Snomed Code", actualSnomedCode);
        assertEquals("Snomed Term", actualSnomedTerm);
        assertEquals("Synced By", actualSyncedBy);
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
        assertSame(allergicList, actualAllergicList);
        assertSame(typeOfAllergicReactions, actualTypeOfAllergicReactions);
        assertSame(captureDate, actualCaptureDate);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        BenAllergyHistory actualBenAllergyHistory = new BenAllergyHistory("Allergy Status", "Allergy Type", "Allergen Name",
                "Allergic Reaction Type ID", "Allergic Reaction Type", "Other Allergic Reaction", "Remarks", 1L, "Snomed Code",
                "Snomed Term");
        ArrayList<Map<String, Object>> allergicList = new ArrayList<>();
        actualBenAllergyHistory.setAllergicList(allergicList);
        actualBenAllergyHistory.setAllergicReactionType("Allergic Reaction Type");
        actualBenAllergyHistory.setAllergicReactionTypeID("Allergic Reaction Type ID");
        actualBenAllergyHistory.setAllergyName("Allergy Name");
        actualBenAllergyHistory.setAllergyStatus("Allergy Status");
        actualBenAllergyHistory.setAllergyType("Allergy Type");
        actualBenAllergyHistory.setBenVisitID(1L);
        actualBenAllergyHistory.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenAllergyHistory.setCaptureDate(captureDate);
        actualBenAllergyHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenAllergyHistory.setCreatedDate(createdDate);
        actualBenAllergyHistory.setDeleted(true);
        actualBenAllergyHistory.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenAllergyHistory.setLastModDate(lastModDate);
        actualBenAllergyHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenAllergyHistory.setOtherAllergicReaction("Other Allergic Reaction");
        actualBenAllergyHistory.setParkingPlaceID(1);
        actualBenAllergyHistory.setProcessed("Processed");
        actualBenAllergyHistory.setProviderServiceMapID(1);
        actualBenAllergyHistory.setRemarks("Remarks");
        actualBenAllergyHistory.setReservedForChange("Reserved For Change");
        actualBenAllergyHistory.setSnomedCode("Snomed Code");
        actualBenAllergyHistory.setSnomedTerm("Snomed Term");
        actualBenAllergyHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenAllergyHistory.setSyncedDate(syncedDate);
        ArrayList<Map<String, String>> typeOfAllergicReactions = new ArrayList<>();
        actualBenAllergyHistory.setTypeOfAllergicReactions(typeOfAllergicReactions);
        actualBenAllergyHistory.setVanID(1);
        actualBenAllergyHistory.setVanSerialNo(1L);
        actualBenAllergyHistory.setVehicalNo("Vehical No");
        actualBenAllergyHistory.setVisitCode(1L);
        List<Map<String, Object>> actualAllergicList = actualBenAllergyHistory.getAllergicList();
        String actualAllergicReactionType = actualBenAllergyHistory.getAllergicReactionType();
        String actualAllergicReactionTypeID = actualBenAllergyHistory.getAllergicReactionTypeID();
        String actualAllergyName = actualBenAllergyHistory.getAllergyName();
        String actualAllergyStatus = actualBenAllergyHistory.getAllergyStatus();
        String actualAllergyType = actualBenAllergyHistory.getAllergyType();
        Long actualBenVisitID = actualBenAllergyHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenAllergyHistory.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenAllergyHistory.getCaptureDate();
        String actualCreatedBy = actualBenAllergyHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenAllergyHistory.getCreatedDate();
        Boolean actualDeleted = actualBenAllergyHistory.getDeleted();
        Long actualID = actualBenAllergyHistory.getID();
        Timestamp actualLastModDate = actualBenAllergyHistory.getLastModDate();
        String actualModifiedBy = actualBenAllergyHistory.getModifiedBy();
        String actualOtherAllergicReaction = actualBenAllergyHistory.getOtherAllergicReaction();
        Integer actualParkingPlaceID = actualBenAllergyHistory.getParkingPlaceID();
        String actualProcessed = actualBenAllergyHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenAllergyHistory.getProviderServiceMapID();
        String actualRemarks = actualBenAllergyHistory.getRemarks();
        String actualReservedForChange = actualBenAllergyHistory.getReservedForChange();
        String actualSnomedCode = actualBenAllergyHistory.getSnomedCode();
        String actualSnomedTerm = actualBenAllergyHistory.getSnomedTerm();
        String actualSyncedBy = actualBenAllergyHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenAllergyHistory.getSyncedDate();
        List<Map<String, String>> actualTypeOfAllergicReactions = actualBenAllergyHistory.getTypeOfAllergicReactions();
        Integer actualVanID = actualBenAllergyHistory.getVanID();
        Long actualVanSerialNo = actualBenAllergyHistory.getVanSerialNo();
        String actualVehicalNo = actualBenAllergyHistory.getVehicalNo();
        Long actualVisitCode = actualBenAllergyHistory.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Allergic Reaction Type ID", actualAllergicReactionTypeID);
        assertEquals("Allergic Reaction Type", actualAllergicReactionType);
        assertEquals("Allergy Name", actualAllergyName);
        assertEquals("Allergy Status", actualAllergyStatus);
        assertEquals("Allergy Type", actualAllergyType);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Allergic Reaction", actualOtherAllergicReaction);
        assertEquals("Processed", actualProcessed);
        assertEquals("Remarks", actualRemarks);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Snomed Code", actualSnomedCode);
        assertEquals("Snomed Term", actualSnomedTerm);
        assertEquals("Synced By", actualSyncedBy);
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
        assertSame(allergicList, actualAllergicList);
        assertSame(typeOfAllergicReactions, actualTypeOfAllergicReactions);
        assertSame(captureDate, actualCaptureDate);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters3() {
        // Arrange and Act
        BenAllergyHistory actualBenAllergyHistory = new BenAllergyHistory(mock(Date.class), "Allergy Status",
                "Allergy Type", "Allergen Name", "Allergic Reaction Type", "Other Allergic Reaction", "Remarks");
        ArrayList<Map<String, Object>> allergicList = new ArrayList<>();
        actualBenAllergyHistory.setAllergicList(allergicList);
        actualBenAllergyHistory.setAllergicReactionType("Allergic Reaction Type");
        actualBenAllergyHistory.setAllergicReactionTypeID("Allergic Reaction Type ID");
        actualBenAllergyHistory.setAllergyName("Allergy Name");
        actualBenAllergyHistory.setAllergyStatus("Allergy Status");
        actualBenAllergyHistory.setAllergyType("Allergy Type");
        actualBenAllergyHistory.setBenVisitID(1L);
        actualBenAllergyHistory.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenAllergyHistory.setCaptureDate(captureDate);
        actualBenAllergyHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenAllergyHistory.setCreatedDate(createdDate);
        actualBenAllergyHistory.setDeleted(true);
        actualBenAllergyHistory.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenAllergyHistory.setLastModDate(lastModDate);
        actualBenAllergyHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenAllergyHistory.setOtherAllergicReaction("Other Allergic Reaction");
        actualBenAllergyHistory.setParkingPlaceID(1);
        actualBenAllergyHistory.setProcessed("Processed");
        actualBenAllergyHistory.setProviderServiceMapID(1);
        actualBenAllergyHistory.setRemarks("Remarks");
        actualBenAllergyHistory.setReservedForChange("Reserved For Change");
        actualBenAllergyHistory.setSnomedCode("Snomed Code");
        actualBenAllergyHistory.setSnomedTerm("Snomed Term");
        actualBenAllergyHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenAllergyHistory.setSyncedDate(syncedDate);
        ArrayList<Map<String, String>> typeOfAllergicReactions = new ArrayList<>();
        actualBenAllergyHistory.setTypeOfAllergicReactions(typeOfAllergicReactions);
        actualBenAllergyHistory.setVanID(1);
        actualBenAllergyHistory.setVanSerialNo(1L);
        actualBenAllergyHistory.setVehicalNo("Vehical No");
        actualBenAllergyHistory.setVisitCode(1L);
        List<Map<String, Object>> actualAllergicList = actualBenAllergyHistory.getAllergicList();
        String actualAllergicReactionType = actualBenAllergyHistory.getAllergicReactionType();
        String actualAllergicReactionTypeID = actualBenAllergyHistory.getAllergicReactionTypeID();
        String actualAllergyName = actualBenAllergyHistory.getAllergyName();
        String actualAllergyStatus = actualBenAllergyHistory.getAllergyStatus();
        String actualAllergyType = actualBenAllergyHistory.getAllergyType();
        Long actualBenVisitID = actualBenAllergyHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenAllergyHistory.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenAllergyHistory.getCaptureDate();
        String actualCreatedBy = actualBenAllergyHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenAllergyHistory.getCreatedDate();
        Boolean actualDeleted = actualBenAllergyHistory.getDeleted();
        Long actualID = actualBenAllergyHistory.getID();
        Timestamp actualLastModDate = actualBenAllergyHistory.getLastModDate();
        String actualModifiedBy = actualBenAllergyHistory.getModifiedBy();
        String actualOtherAllergicReaction = actualBenAllergyHistory.getOtherAllergicReaction();
        Integer actualParkingPlaceID = actualBenAllergyHistory.getParkingPlaceID();
        String actualProcessed = actualBenAllergyHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenAllergyHistory.getProviderServiceMapID();
        String actualRemarks = actualBenAllergyHistory.getRemarks();
        String actualReservedForChange = actualBenAllergyHistory.getReservedForChange();
        String actualSnomedCode = actualBenAllergyHistory.getSnomedCode();
        String actualSnomedTerm = actualBenAllergyHistory.getSnomedTerm();
        String actualSyncedBy = actualBenAllergyHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenAllergyHistory.getSyncedDate();
        List<Map<String, String>> actualTypeOfAllergicReactions = actualBenAllergyHistory.getTypeOfAllergicReactions();
        Integer actualVanID = actualBenAllergyHistory.getVanID();
        Long actualVanSerialNo = actualBenAllergyHistory.getVanSerialNo();
        String actualVehicalNo = actualBenAllergyHistory.getVehicalNo();
        Long actualVisitCode = actualBenAllergyHistory.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Allergic Reaction Type ID", actualAllergicReactionTypeID);
        assertEquals("Allergic Reaction Type", actualAllergicReactionType);
        assertEquals("Allergy Name", actualAllergyName);
        assertEquals("Allergy Status", actualAllergyStatus);
        assertEquals("Allergy Type", actualAllergyType);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Allergic Reaction", actualOtherAllergicReaction);
        assertEquals("Processed", actualProcessed);
        assertEquals("Remarks", actualRemarks);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Snomed Code", actualSnomedCode);
        assertEquals("Snomed Term", actualSnomedTerm);
        assertEquals("Synced By", actualSyncedBy);
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
        assertSame(allergicList, actualAllergicList);
        assertSame(typeOfAllergicReactions, actualTypeOfAllergicReactions);
        assertSame(captureDate, actualCaptureDate);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }
}
