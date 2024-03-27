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
import java.util.List;
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
class BenFamilyHistoryTest {
    @InjectMocks
    private BenFamilyHistory benFamilyHistory;

    
    @Test
    void testGetBenFamilyHistory() {
        // Arrange, Act and Assert
        assertTrue((new BenFamilyHistory()).getBenFamilyHistory().isEmpty());
        assertNull(BenFamilyHistory.getBenFamilyHistory(new ArrayList<>()));
    }

    
    @Test
    void testGetBenFamilyHistory2() {
        // Arrange
        BenFamilyHistory benFamilyHistory2 = new BenFamilyHistory();
        benFamilyHistory2.setCaptureDate(mock(Date.class));

        // Act and Assert
        assertTrue(benFamilyHistory2.getBenFamilyHistory().isEmpty());
    }

    /**
     * Method under test: {@link BenFamilyHistory#getBenFamilyHistory()}
     */
    @Test
    void testGetBenFamilyHistory3() {
        // Arrange
        BenFamilyHistory benFamilyHistory2 = new BenFamilyHistory();
        benFamilyHistory2.setFamilyDiseaseList(new ArrayList<>());

        // Act and Assert
        assertTrue(benFamilyHistory2.getBenFamilyHistory().isEmpty());
    }

    @Test
    void testGetBenFamilyHistory4() {
        // Arrange
        ArrayList<Map<String, Object>> familyDiseaseList = new ArrayList<>();
        familyDiseaseList.add(new HashMap<>());

        BenFamilyHistory benFamilyHistory2 = new BenFamilyHistory();
        benFamilyHistory2.setFamilyDiseaseList(familyDiseaseList);

        // Act and Assert
        assertEquals(1, benFamilyHistory2.getBenFamilyHistory().size());
    }

    @Test
    void testGetBenFamilyHistory5() {
        // Arrange
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("diseaseTypeID", "42");

        ArrayList<Map<String, Object>> familyDiseaseList = new ArrayList<>();
        familyDiseaseList.add(stringObjectMap);

        BenFamilyHistory benFamilyHistory2 = new BenFamilyHistory();
        benFamilyHistory2.setFamilyDiseaseList(familyDiseaseList);

        // Act and Assert
        assertEquals(1, benFamilyHistory2.getBenFamilyHistory().size());
    }

    @Test
    void testGetBenFamilyHistory6() {
        // Arrange
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("diseaseType", "42");
        stringObjectMap.put("diseaseTypeID", "42");

        ArrayList<Map<String, Object>> familyDiseaseList = new ArrayList<>();
        familyDiseaseList.add(stringObjectMap);

        BenFamilyHistory benFamilyHistory2 = new BenFamilyHistory();
        benFamilyHistory2.setFamilyDiseaseList(familyDiseaseList);

        // Act and Assert
        assertEquals(1, benFamilyHistory2.getBenFamilyHistory().size());
    }

    @Test
    void testGetBenFamilyHistory7() {
        // Arrange
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("otherDiseaseType", "42");

        ArrayList<Map<String, Object>> familyDiseaseList = new ArrayList<>();
        familyDiseaseList.add(stringObjectMap);

        BenFamilyHistory benFamilyHistory2 = new BenFamilyHistory();
        benFamilyHistory2.setFamilyDiseaseList(familyDiseaseList);

        // Act and Assert
        assertEquals(1, benFamilyHistory2.getBenFamilyHistory().size());
    }

    @Test
    void testGetBenFamilyHistory8() {
        // Arrange
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("snomedCode", "42");

        ArrayList<Map<String, Object>> familyDiseaseList = new ArrayList<>();
        familyDiseaseList.add(stringObjectMap);

        BenFamilyHistory benFamilyHistory2 = new BenFamilyHistory();
        benFamilyHistory2.setFamilyDiseaseList(familyDiseaseList);

        // Act and Assert
        assertEquals(1, benFamilyHistory2.getBenFamilyHistory().size());
    }

    @Test
    void testGetBenFamilyHistory9() {
        // Arrange
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("snomedTerm", "42");

        ArrayList<Map<String, Object>> familyDiseaseList = new ArrayList<>();
        familyDiseaseList.add(stringObjectMap);

        BenFamilyHistory benFamilyHistory2 = new BenFamilyHistory();
        benFamilyHistory2.setFamilyDiseaseList(familyDiseaseList);

        // Act and Assert
        assertEquals(1, benFamilyHistory2.getBenFamilyHistory().size());
    }

    @Test
    void testGetBenFamilyHist() {
        // Arrange, Act and Assert
        assertTrue((new BenFamilyHistory()).getBenFamilyHist().isEmpty());
        assertNull(BenFamilyHistory.getBenFamilyHist(new ArrayList<>()));
    }

    @Test
    void testGetBenFamilyHist2() {
        // Arrange
        BenFamilyHistory benFamilyHistory2 = new BenFamilyHistory();
        benFamilyHistory2.setCaptureDate(mock(Date.class));

        // Act and Assert
        assertTrue(benFamilyHistory2.getBenFamilyHist().isEmpty());
    }

    @Test
    void testGetBenFamilyHist3() {
        // Arrange
        BenFamilyHistory benFamilyHistory2 = new BenFamilyHistory();
        benFamilyHistory2.setFamilyDiseaseList(new ArrayList<>());

        // Act and Assert
        assertTrue(benFamilyHistory2.getBenFamilyHist().isEmpty());
    }

    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        BenFamilyHistory actualBenFamilyHistory = new BenFamilyHistory();
        actualBenFamilyHistory.setBenVisitID(1L);
        actualBenFamilyHistory.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenFamilyHistory.setCaptureDate(captureDate);
        actualBenFamilyHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenFamilyHistory.setCreatedDate(createdDate);
        actualBenFamilyHistory.setDeleted(true);
        actualBenFamilyHistory.setDiseaseType("Disease Type");
        actualBenFamilyHistory.setDiseaseTypeID((short) 1);
        ArrayList<Map<String, Object>> familyDiseaseList = new ArrayList<>();
        actualBenFamilyHistory.setFamilyDiseaseList(familyDiseaseList);
        actualBenFamilyHistory.setFamilyMember("Family Member");
        actualBenFamilyHistory.setGeneticDisorder("Genetic Disorder");
        actualBenFamilyHistory.setID(1L);
        actualBenFamilyHistory.setIsConsanguineousMarrige(true);
        actualBenFamilyHistory.setIsConsanguineousMarrige("Is Consanguineous Marrige");
        actualBenFamilyHistory.setIsGeneticDisorder(true);
        actualBenFamilyHistory.setIsGeneticDisorder("Is Genetic Disorder");
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenFamilyHistory.setLastModDate(lastModDate);
        actualBenFamilyHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenFamilyHistory.setOtherDiseaseType("Other Disease Type");
        actualBenFamilyHistory.setParkingPlaceID(1);
        actualBenFamilyHistory.setProcessed("Processed");
        actualBenFamilyHistory.setProviderServiceMapID(1);
        actualBenFamilyHistory.setReservedForChange("Reserved For Change");
        actualBenFamilyHistory.setSnomedCode("Snomed Code");
        actualBenFamilyHistory.setSnomedTerm("Snomed Term");
        actualBenFamilyHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenFamilyHistory.setSyncedDate(syncedDate);
        actualBenFamilyHistory.setVanID(1);
        actualBenFamilyHistory.setVanSerialNo(1L);
        actualBenFamilyHistory.setVehicalNo("Vehical No");
        actualBenFamilyHistory.setVisitCode(1L);
        Long actualBenVisitID = actualBenFamilyHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenFamilyHistory.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenFamilyHistory.getCaptureDate();
        String actualCreatedBy = actualBenFamilyHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenFamilyHistory.getCreatedDate();
        Boolean actualDeleted = actualBenFamilyHistory.getDeleted();
        String actualDiseaseType = actualBenFamilyHistory.getDiseaseType();
        Short actualDiseaseTypeID = actualBenFamilyHistory.getDiseaseTypeID();
        List<Map<String, Object>> actualFamilyDiseaseList = actualBenFamilyHistory.getFamilyDiseaseList();
        String actualFamilyMember = actualBenFamilyHistory.getFamilyMember();
        String actualGeneticDisorder = actualBenFamilyHistory.getGeneticDisorder();
        Long actualID = actualBenFamilyHistory.getID();
        Boolean actualIsConsanguineousMarrige = actualBenFamilyHistory.getIsConsanguineousMarrige();
        Boolean actualIsGeneticDisorder = actualBenFamilyHistory.getIsGeneticDisorder();
        Timestamp actualLastModDate = actualBenFamilyHistory.getLastModDate();
        String actualModifiedBy = actualBenFamilyHistory.getModifiedBy();
        String actualOtherDiseaseType = actualBenFamilyHistory.getOtherDiseaseType();
        Integer actualParkingPlaceID = actualBenFamilyHistory.getParkingPlaceID();
        String actualProcessed = actualBenFamilyHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenFamilyHistory.getProviderServiceMapID();
        String actualReservedForChange = actualBenFamilyHistory.getReservedForChange();
        String actualSnomedCode = actualBenFamilyHistory.getSnomedCode();
        String actualSnomedTerm = actualBenFamilyHistory.getSnomedTerm();
        String actualSyncedBy = actualBenFamilyHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenFamilyHistory.getSyncedDate();
        Integer actualVanID = actualBenFamilyHistory.getVanID();
        Long actualVanSerialNo = actualBenFamilyHistory.getVanSerialNo();
        String actualVehicalNo = actualBenFamilyHistory.getVehicalNo();
        Long actualVisitCode = actualBenFamilyHistory.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Disease Type", actualDiseaseType);
        assertEquals("Family Member", actualFamilyMember);
        assertEquals("Genetic Disorder", actualGeneticDisorder);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Disease Type", actualOtherDiseaseType);
        assertEquals("Processed", actualProcessed);
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
        assertEquals((short) 1, actualDiseaseTypeID.shortValue());
        assertTrue(actualDeleted);
        assertTrue(actualIsConsanguineousMarrige);
        assertTrue(actualIsGeneticDisorder);
        assertSame(familyDiseaseList, actualFamilyDiseaseList);
        assertSame(captureDate, actualCaptureDate);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        BenFamilyHistory actualBenFamilyHistory = new BenFamilyHistory(1L, 1L, 1, true, "Genetic Disorder", true, 1L);
        actualBenFamilyHistory.setBenVisitID(1L);
        actualBenFamilyHistory.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenFamilyHistory.setCaptureDate(captureDate);
        actualBenFamilyHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenFamilyHistory.setCreatedDate(createdDate);
        actualBenFamilyHistory.setDeleted(true);
        actualBenFamilyHistory.setDiseaseType("Disease Type");
        actualBenFamilyHistory.setDiseaseTypeID((short) 1);
        ArrayList<Map<String, Object>> familyDiseaseList = new ArrayList<>();
        actualBenFamilyHistory.setFamilyDiseaseList(familyDiseaseList);
        actualBenFamilyHistory.setFamilyMember("Family Member");
        actualBenFamilyHistory.setGeneticDisorder("Genetic Disorder");
        actualBenFamilyHistory.setID(1L);
        actualBenFamilyHistory.setIsConsanguineousMarrige(true);
        actualBenFamilyHistory.setIsConsanguineousMarrige("Is Consanguineous Marrige");
        actualBenFamilyHistory.setIsGeneticDisorder(true);
        actualBenFamilyHistory.setIsGeneticDisorder("Is Genetic Disorder");
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenFamilyHistory.setLastModDate(lastModDate);
        actualBenFamilyHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenFamilyHistory.setOtherDiseaseType("Other Disease Type");
        actualBenFamilyHistory.setParkingPlaceID(1);
        actualBenFamilyHistory.setProcessed("Processed");
        actualBenFamilyHistory.setProviderServiceMapID(1);
        actualBenFamilyHistory.setReservedForChange("Reserved For Change");
        actualBenFamilyHistory.setSnomedCode("Snomed Code");
        actualBenFamilyHistory.setSnomedTerm("Snomed Term");
        actualBenFamilyHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenFamilyHistory.setSyncedDate(syncedDate);
        actualBenFamilyHistory.setVanID(1);
        actualBenFamilyHistory.setVanSerialNo(1L);
        actualBenFamilyHistory.setVehicalNo("Vehical No");
        actualBenFamilyHistory.setVisitCode(1L);
        Long actualBenVisitID = actualBenFamilyHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenFamilyHistory.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenFamilyHistory.getCaptureDate();
        String actualCreatedBy = actualBenFamilyHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenFamilyHistory.getCreatedDate();
        Boolean actualDeleted = actualBenFamilyHistory.getDeleted();
        String actualDiseaseType = actualBenFamilyHistory.getDiseaseType();
        Short actualDiseaseTypeID = actualBenFamilyHistory.getDiseaseTypeID();
        List<Map<String, Object>> actualFamilyDiseaseList = actualBenFamilyHistory.getFamilyDiseaseList();
        String actualFamilyMember = actualBenFamilyHistory.getFamilyMember();
        String actualGeneticDisorder = actualBenFamilyHistory.getGeneticDisorder();
        Long actualID = actualBenFamilyHistory.getID();
        Boolean actualIsConsanguineousMarrige = actualBenFamilyHistory.getIsConsanguineousMarrige();
        Boolean actualIsGeneticDisorder = actualBenFamilyHistory.getIsGeneticDisorder();
        Timestamp actualLastModDate = actualBenFamilyHistory.getLastModDate();
        String actualModifiedBy = actualBenFamilyHistory.getModifiedBy();
        String actualOtherDiseaseType = actualBenFamilyHistory.getOtherDiseaseType();
        Integer actualParkingPlaceID = actualBenFamilyHistory.getParkingPlaceID();
        String actualProcessed = actualBenFamilyHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenFamilyHistory.getProviderServiceMapID();
        String actualReservedForChange = actualBenFamilyHistory.getReservedForChange();
        String actualSnomedCode = actualBenFamilyHistory.getSnomedCode();
        String actualSnomedTerm = actualBenFamilyHistory.getSnomedTerm();
        String actualSyncedBy = actualBenFamilyHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenFamilyHistory.getSyncedDate();
        Integer actualVanID = actualBenFamilyHistory.getVanID();
        Long actualVanSerialNo = actualBenFamilyHistory.getVanSerialNo();
        String actualVehicalNo = actualBenFamilyHistory.getVehicalNo();
        Long actualVisitCode = actualBenFamilyHistory.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Disease Type", actualDiseaseType);
        assertEquals("Family Member", actualFamilyMember);
        assertEquals("Genetic Disorder", actualGeneticDisorder);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Disease Type", actualOtherDiseaseType);
        assertEquals("Processed", actualProcessed);
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
        assertEquals((short) 1, actualDiseaseTypeID.shortValue());
        assertTrue(actualDeleted);
        assertTrue(actualIsConsanguineousMarrige);
        assertTrue(actualIsGeneticDisorder);
        assertSame(familyDiseaseList, actualFamilyDiseaseList);
        assertSame(captureDate, actualCaptureDate);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters3() {
        // Arrange and Act
        BenFamilyHistory actualBenFamilyHistory = new BenFamilyHistory(1L, 1L, 1L, 1, true, "Genetic Disorder", true, 1L);
        actualBenFamilyHistory.setBenVisitID(1L);
        actualBenFamilyHistory.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenFamilyHistory.setCaptureDate(captureDate);
        actualBenFamilyHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenFamilyHistory.setCreatedDate(createdDate);
        actualBenFamilyHistory.setDeleted(true);
        actualBenFamilyHistory.setDiseaseType("Disease Type");
        actualBenFamilyHistory.setDiseaseTypeID((short) 1);
        ArrayList<Map<String, Object>> familyDiseaseList = new ArrayList<>();
        actualBenFamilyHistory.setFamilyDiseaseList(familyDiseaseList);
        actualBenFamilyHistory.setFamilyMember("Family Member");
        actualBenFamilyHistory.setGeneticDisorder("Genetic Disorder");
        actualBenFamilyHistory.setID(1L);
        actualBenFamilyHistory.setIsConsanguineousMarrige(true);
        actualBenFamilyHistory.setIsConsanguineousMarrige("Is Consanguineous Marrige");
        actualBenFamilyHistory.setIsGeneticDisorder(true);
        actualBenFamilyHistory.setIsGeneticDisorder("Is Genetic Disorder");
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenFamilyHistory.setLastModDate(lastModDate);
        actualBenFamilyHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenFamilyHistory.setOtherDiseaseType("Other Disease Type");
        actualBenFamilyHistory.setParkingPlaceID(1);
        actualBenFamilyHistory.setProcessed("Processed");
        actualBenFamilyHistory.setProviderServiceMapID(1);
        actualBenFamilyHistory.setReservedForChange("Reserved For Change");
        actualBenFamilyHistory.setSnomedCode("Snomed Code");
        actualBenFamilyHistory.setSnomedTerm("Snomed Term");
        actualBenFamilyHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenFamilyHistory.setSyncedDate(syncedDate);
        actualBenFamilyHistory.setVanID(1);
        actualBenFamilyHistory.setVanSerialNo(1L);
        actualBenFamilyHistory.setVehicalNo("Vehical No");
        actualBenFamilyHistory.setVisitCode(1L);
        Long actualBenVisitID = actualBenFamilyHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenFamilyHistory.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenFamilyHistory.getCaptureDate();
        String actualCreatedBy = actualBenFamilyHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenFamilyHistory.getCreatedDate();
        Boolean actualDeleted = actualBenFamilyHistory.getDeleted();
        String actualDiseaseType = actualBenFamilyHistory.getDiseaseType();
        Short actualDiseaseTypeID = actualBenFamilyHistory.getDiseaseTypeID();
        List<Map<String, Object>> actualFamilyDiseaseList = actualBenFamilyHistory.getFamilyDiseaseList();
        String actualFamilyMember = actualBenFamilyHistory.getFamilyMember();
        String actualGeneticDisorder = actualBenFamilyHistory.getGeneticDisorder();
        Long actualID = actualBenFamilyHistory.getID();
        Boolean actualIsConsanguineousMarrige = actualBenFamilyHistory.getIsConsanguineousMarrige();
        Boolean actualIsGeneticDisorder = actualBenFamilyHistory.getIsGeneticDisorder();
        Timestamp actualLastModDate = actualBenFamilyHistory.getLastModDate();
        String actualModifiedBy = actualBenFamilyHistory.getModifiedBy();
        String actualOtherDiseaseType = actualBenFamilyHistory.getOtherDiseaseType();
        Integer actualParkingPlaceID = actualBenFamilyHistory.getParkingPlaceID();
        String actualProcessed = actualBenFamilyHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenFamilyHistory.getProviderServiceMapID();
        String actualReservedForChange = actualBenFamilyHistory.getReservedForChange();
        String actualSnomedCode = actualBenFamilyHistory.getSnomedCode();
        String actualSnomedTerm = actualBenFamilyHistory.getSnomedTerm();
        String actualSyncedBy = actualBenFamilyHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenFamilyHistory.getSyncedDate();
        Integer actualVanID = actualBenFamilyHistory.getVanID();
        Long actualVanSerialNo = actualBenFamilyHistory.getVanSerialNo();
        String actualVehicalNo = actualBenFamilyHistory.getVehicalNo();
        Long actualVisitCode = actualBenFamilyHistory.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Disease Type", actualDiseaseType);
        assertEquals("Family Member", actualFamilyMember);
        assertEquals("Genetic Disorder", actualGeneticDisorder);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Disease Type", actualOtherDiseaseType);
        assertEquals("Processed", actualProcessed);
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
        assertEquals((short) 1, actualDiseaseTypeID.shortValue());
        assertTrue(actualDeleted);
        assertTrue(actualIsConsanguineousMarrige);
        assertTrue(actualIsGeneticDisorder);
        assertSame(familyDiseaseList, actualFamilyDiseaseList);
        assertSame(captureDate, actualCaptureDate);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters4() {
        // Arrange and Act
        BenFamilyHistory actualBenFamilyHistory = new BenFamilyHistory(1L, "Family Member", (short) 1, "Disease Type",
                "Other Disease Type", "Snomed Code", "Snomed Term");
        actualBenFamilyHistory.setBenVisitID(1L);
        actualBenFamilyHistory.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenFamilyHistory.setCaptureDate(captureDate);
        actualBenFamilyHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenFamilyHistory.setCreatedDate(createdDate);
        actualBenFamilyHistory.setDeleted(true);
        actualBenFamilyHistory.setDiseaseType("Disease Type");
        actualBenFamilyHistory.setDiseaseTypeID((short) 1);
        ArrayList<Map<String, Object>> familyDiseaseList = new ArrayList<>();
        actualBenFamilyHistory.setFamilyDiseaseList(familyDiseaseList);
        actualBenFamilyHistory.setFamilyMember("Family Member");
        actualBenFamilyHistory.setGeneticDisorder("Genetic Disorder");
        actualBenFamilyHistory.setID(1L);
        actualBenFamilyHistory.setIsConsanguineousMarrige(true);
        actualBenFamilyHistory.setIsConsanguineousMarrige("Is Consanguineous Marrige");
        actualBenFamilyHistory.setIsGeneticDisorder(true);
        actualBenFamilyHistory.setIsGeneticDisorder("Is Genetic Disorder");
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenFamilyHistory.setLastModDate(lastModDate);
        actualBenFamilyHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenFamilyHistory.setOtherDiseaseType("Other Disease Type");
        actualBenFamilyHistory.setParkingPlaceID(1);
        actualBenFamilyHistory.setProcessed("Processed");
        actualBenFamilyHistory.setProviderServiceMapID(1);
        actualBenFamilyHistory.setReservedForChange("Reserved For Change");
        actualBenFamilyHistory.setSnomedCode("Snomed Code");
        actualBenFamilyHistory.setSnomedTerm("Snomed Term");
        actualBenFamilyHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenFamilyHistory.setSyncedDate(syncedDate);
        actualBenFamilyHistory.setVanID(1);
        actualBenFamilyHistory.setVanSerialNo(1L);
        actualBenFamilyHistory.setVehicalNo("Vehical No");
        actualBenFamilyHistory.setVisitCode(1L);
        Long actualBenVisitID = actualBenFamilyHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenFamilyHistory.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenFamilyHistory.getCaptureDate();
        String actualCreatedBy = actualBenFamilyHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenFamilyHistory.getCreatedDate();
        Boolean actualDeleted = actualBenFamilyHistory.getDeleted();
        String actualDiseaseType = actualBenFamilyHistory.getDiseaseType();
        Short actualDiseaseTypeID = actualBenFamilyHistory.getDiseaseTypeID();
        List<Map<String, Object>> actualFamilyDiseaseList = actualBenFamilyHistory.getFamilyDiseaseList();
        String actualFamilyMember = actualBenFamilyHistory.getFamilyMember();
        String actualGeneticDisorder = actualBenFamilyHistory.getGeneticDisorder();
        Long actualID = actualBenFamilyHistory.getID();
        Boolean actualIsConsanguineousMarrige = actualBenFamilyHistory.getIsConsanguineousMarrige();
        Boolean actualIsGeneticDisorder = actualBenFamilyHistory.getIsGeneticDisorder();
        Timestamp actualLastModDate = actualBenFamilyHistory.getLastModDate();
        String actualModifiedBy = actualBenFamilyHistory.getModifiedBy();
        String actualOtherDiseaseType = actualBenFamilyHistory.getOtherDiseaseType();
        Integer actualParkingPlaceID = actualBenFamilyHistory.getParkingPlaceID();
        String actualProcessed = actualBenFamilyHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenFamilyHistory.getProviderServiceMapID();
        String actualReservedForChange = actualBenFamilyHistory.getReservedForChange();
        String actualSnomedCode = actualBenFamilyHistory.getSnomedCode();
        String actualSnomedTerm = actualBenFamilyHistory.getSnomedTerm();
        String actualSyncedBy = actualBenFamilyHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenFamilyHistory.getSyncedDate();
        Integer actualVanID = actualBenFamilyHistory.getVanID();
        Long actualVanSerialNo = actualBenFamilyHistory.getVanSerialNo();
        String actualVehicalNo = actualBenFamilyHistory.getVehicalNo();
        Long actualVisitCode = actualBenFamilyHistory.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Disease Type", actualDiseaseType);
        assertEquals("Family Member", actualFamilyMember);
        assertEquals("Genetic Disorder", actualGeneticDisorder);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Disease Type", actualOtherDiseaseType);
        assertEquals("Processed", actualProcessed);
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
        assertEquals((short) 1, actualDiseaseTypeID.shortValue());
        assertTrue(actualDeleted);
        assertTrue(actualIsConsanguineousMarrige);
        assertTrue(actualIsGeneticDisorder);
        assertSame(familyDiseaseList, actualFamilyDiseaseList);
        assertSame(captureDate, actualCaptureDate);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters5() {
        // Arrange and Act
        BenFamilyHistory actualBenFamilyHistory = new BenFamilyHistory("Family Member", (short) 1, "Disease Type",
                "Other Disease Type", "Snomed Code", "Snomed Term");
        actualBenFamilyHistory.setBenVisitID(1L);
        actualBenFamilyHistory.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenFamilyHistory.setCaptureDate(captureDate);
        actualBenFamilyHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenFamilyHistory.setCreatedDate(createdDate);
        actualBenFamilyHistory.setDeleted(true);
        actualBenFamilyHistory.setDiseaseType("Disease Type");
        actualBenFamilyHistory.setDiseaseTypeID((short) 1);
        ArrayList<Map<String, Object>> familyDiseaseList = new ArrayList<>();
        actualBenFamilyHistory.setFamilyDiseaseList(familyDiseaseList);
        actualBenFamilyHistory.setFamilyMember("Family Member");
        actualBenFamilyHistory.setGeneticDisorder("Genetic Disorder");
        actualBenFamilyHistory.setID(1L);
        actualBenFamilyHistory.setIsConsanguineousMarrige(true);
        actualBenFamilyHistory.setIsConsanguineousMarrige("Is Consanguineous Marrige");
        actualBenFamilyHistory.setIsGeneticDisorder(true);
        actualBenFamilyHistory.setIsGeneticDisorder("Is Genetic Disorder");
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenFamilyHistory.setLastModDate(lastModDate);
        actualBenFamilyHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenFamilyHistory.setOtherDiseaseType("Other Disease Type");
        actualBenFamilyHistory.setParkingPlaceID(1);
        actualBenFamilyHistory.setProcessed("Processed");
        actualBenFamilyHistory.setProviderServiceMapID(1);
        actualBenFamilyHistory.setReservedForChange("Reserved For Change");
        actualBenFamilyHistory.setSnomedCode("Snomed Code");
        actualBenFamilyHistory.setSnomedTerm("Snomed Term");
        actualBenFamilyHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenFamilyHistory.setSyncedDate(syncedDate);
        actualBenFamilyHistory.setVanID(1);
        actualBenFamilyHistory.setVanSerialNo(1L);
        actualBenFamilyHistory.setVehicalNo("Vehical No");
        actualBenFamilyHistory.setVisitCode(1L);
        Long actualBenVisitID = actualBenFamilyHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenFamilyHistory.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenFamilyHistory.getCaptureDate();
        String actualCreatedBy = actualBenFamilyHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenFamilyHistory.getCreatedDate();
        Boolean actualDeleted = actualBenFamilyHistory.getDeleted();
        String actualDiseaseType = actualBenFamilyHistory.getDiseaseType();
        Short actualDiseaseTypeID = actualBenFamilyHistory.getDiseaseTypeID();
        List<Map<String, Object>> actualFamilyDiseaseList = actualBenFamilyHistory.getFamilyDiseaseList();
        String actualFamilyMember = actualBenFamilyHistory.getFamilyMember();
        String actualGeneticDisorder = actualBenFamilyHistory.getGeneticDisorder();
        Long actualID = actualBenFamilyHistory.getID();
        Boolean actualIsConsanguineousMarrige = actualBenFamilyHistory.getIsConsanguineousMarrige();
        Boolean actualIsGeneticDisorder = actualBenFamilyHistory.getIsGeneticDisorder();
        Timestamp actualLastModDate = actualBenFamilyHistory.getLastModDate();
        String actualModifiedBy = actualBenFamilyHistory.getModifiedBy();
        String actualOtherDiseaseType = actualBenFamilyHistory.getOtherDiseaseType();
        Integer actualParkingPlaceID = actualBenFamilyHistory.getParkingPlaceID();
        String actualProcessed = actualBenFamilyHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenFamilyHistory.getProviderServiceMapID();
        String actualReservedForChange = actualBenFamilyHistory.getReservedForChange();
        String actualSnomedCode = actualBenFamilyHistory.getSnomedCode();
        String actualSnomedTerm = actualBenFamilyHistory.getSnomedTerm();
        String actualSyncedBy = actualBenFamilyHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenFamilyHistory.getSyncedDate();
        Integer actualVanID = actualBenFamilyHistory.getVanID();
        Long actualVanSerialNo = actualBenFamilyHistory.getVanSerialNo();
        String actualVehicalNo = actualBenFamilyHistory.getVehicalNo();
        Long actualVisitCode = actualBenFamilyHistory.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Disease Type", actualDiseaseType);
        assertEquals("Family Member", actualFamilyMember);
        assertEquals("Genetic Disorder", actualGeneticDisorder);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Disease Type", actualOtherDiseaseType);
        assertEquals("Processed", actualProcessed);
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
        assertEquals((short) 1, actualDiseaseTypeID.shortValue());
        assertTrue(actualDeleted);
        assertTrue(actualIsConsanguineousMarrige);
        assertTrue(actualIsGeneticDisorder);
        assertSame(familyDiseaseList, actualFamilyDiseaseList);
        assertSame(captureDate, actualCaptureDate);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

   
    @Test
    void testNewBenFamilyHistory() {
        // Arrange
        Date createdDate = mock(Date.class);

        // Act
        BenFamilyHistory actualBenFamilyHistory = new BenFamilyHistory(createdDate, "Family Member", "Disease Type",
                "Other Disease Type", true, "Genetic Disorder", true);

        // Assert
        assertEquals("Disease Type", actualBenFamilyHistory.getDiseaseType());
        assertEquals("Family Member", actualBenFamilyHistory.getFamilyMember());
        assertEquals("Genetic Disorder", actualBenFamilyHistory.getGeneticDisorder());
        assertEquals("Other Disease Type", actualBenFamilyHistory.getOtherDiseaseType());
        assertSame(createdDate, actualBenFamilyHistory.getCaptureDate());
    }

    
    @Test
    void testNewBenFamilyHistory2() {
        // Arrange
        Date createdDate = mock(Date.class);

        // Act
        BenFamilyHistory actualBenFamilyHistory = new BenFamilyHistory(createdDate, "Family Member", "Disease Type",
                "Other Disease Type", false, "Genetic Disorder", true);

        // Assert
        assertEquals("Disease Type", actualBenFamilyHistory.getDiseaseType());
        assertEquals("Family Member", actualBenFamilyHistory.getFamilyMember());
        assertEquals("Genetic Disorder", actualBenFamilyHistory.getGeneticDisorder());
        assertEquals("Other Disease Type", actualBenFamilyHistory.getOtherDiseaseType());
        assertSame(createdDate, actualBenFamilyHistory.getCaptureDate());
    }

  
    @Test
    void testNewBenFamilyHistory3() {
        // Arrange
        Date createdDate = mock(Date.class);

        // Act
        BenFamilyHistory actualBenFamilyHistory = new BenFamilyHistory(createdDate, "Family Member", "Disease Type",
                "Other Disease Type", true, "Genetic Disorder", false);

        // Assert
        assertEquals("Disease Type", actualBenFamilyHistory.getDiseaseType());
        assertEquals("Family Member", actualBenFamilyHistory.getFamilyMember());
        assertEquals("Genetic Disorder", actualBenFamilyHistory.getGeneticDisorder());
        assertEquals("Other Disease Type", actualBenFamilyHistory.getOtherDiseaseType());
        assertSame(createdDate, actualBenFamilyHistory.getCaptureDate());
    }
}
