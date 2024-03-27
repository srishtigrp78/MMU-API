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
class BenPersonalHabitTest {
    @InjectMocks
    private BenPersonalHabit benPersonalHabit;

    @Test
    void testGetPersonalHistory() {
        // Arrange
        ArrayList<Map<String, String>> tobaccoList = new ArrayList<>();
        tobaccoList.add(new HashMap<>());

        BenPersonalHabit benPersonalHabit2 = new BenPersonalHabit(mock(Date.class), "Dietary Type",
                "Physical Activity Type", "Tobacco Use Status", "Tobacco Use Type", "Other Tobacco Use Type", (short) 1,
                mock(Date.class), 'A');
        benPersonalHabit2.setAlcoholList(new ArrayList<>());
        benPersonalHabit2.setTobaccoList(tobaccoList);

        // Act and Assert
        assertEquals(1, benPersonalHabit2.getPersonalHistory().size());
    }

    @Test
    void testGetPersonalHistory2() {
        // Arrange
        ArrayList<Map<String, String>> tobaccoList = new ArrayList<>();
        tobaccoList.add(new HashMap<>());

        ArrayList<Map<String, String>> alcoholList = new ArrayList<>();
        alcoholList.add(new HashMap<>());

        BenPersonalHabit benPersonalHabit2 = new BenPersonalHabit(mock(Date.class), "Dietary Type",
                "Physical Activity Type", "Tobacco Use Status", "Tobacco Use Type", "Other Tobacco Use Type", (short) 1,
                mock(Date.class), 'A');
        benPersonalHabit2.setAlcoholList(alcoholList);
        benPersonalHabit2.setTobaccoList(tobaccoList);

        // Act and Assert
        assertEquals(1, benPersonalHabit2.getPersonalHistory().size());
    }

    @Test
    void testGetPersonalHistory3() {
        // Arrange
        ArrayList<Map<String, String>> tobaccoList = new ArrayList<>();
        tobaccoList.add(new HashMap<>());

        ArrayList<Map<String, String>> alcoholList = new ArrayList<>();
        alcoholList.add(new HashMap<>());
        alcoholList.add(new HashMap<>());

        BenPersonalHabit benPersonalHabit2 = new BenPersonalHabit(mock(Date.class), "Dietary Type",
                "Physical Activity Type", "Tobacco Use Status", "Tobacco Use Type", "Other Tobacco Use Type", (short) 1,
                mock(Date.class), 'A');
        benPersonalHabit2.setAlcoholList(alcoholList);
        benPersonalHabit2.setTobaccoList(tobaccoList);

        // Act and Assert
        assertEquals(2, benPersonalHabit2.getPersonalHistory().size());
    }
    @Test
    void testGetPersonalDetails() {
        // Arrange, Act and Assert
        assertNull(BenPersonalHabit.getPersonalDetails(new ArrayList<>()));
    }

    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        BenPersonalHabit actualBenPersonalHabit = new BenPersonalHabit();
        Timestamp alcoholDuration = mock(Timestamp.class);
        actualBenPersonalHabit.setAlcoholDuration(alcoholDuration);
        actualBenPersonalHabit.setAlcoholIntakeFrequency("Alcohol Intake Frequency");
        actualBenPersonalHabit.setAlcoholIntakeStatus("Alcohol Intake Status");
        ArrayList<Map<String, String>> alcoholList = new ArrayList<>();
        actualBenPersonalHabit.setAlcoholList(alcoholList);
        actualBenPersonalHabit.setAlcoholType("Alcohol Type");
        actualBenPersonalHabit.setAlcoholTypeID("Alcohol Type ID");
        Date alcohol_use_duration = mock(Date.class);
        actualBenPersonalHabit.setAlcohol_use_duration(alcohol_use_duration);
        ArrayList<BenAllergyHistory> allergicList = new ArrayList<>();
        actualBenPersonalHabit.setAllergicList(allergicList);
        actualBenPersonalHabit.setAllergyStatus("Allergy Status");
        actualBenPersonalHabit.setAvgAlcoholConsumption("Avg Alcohol Consumption");
        actualBenPersonalHabit.setBenPersonalHabitID(1);
        actualBenPersonalHabit.setBenVisitID(1L);
        actualBenPersonalHabit.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenPersonalHabit.setCaptureDate(captureDate);
        actualBenPersonalHabit.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenPersonalHabit.setCreatedDate(createdDate);
        actualBenPersonalHabit.setDeleted(true);
        actualBenPersonalHabit.setDietaryType("Dietary Type");
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenPersonalHabit.setLastModDate(lastModDate);
        actualBenPersonalHabit.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenPersonalHabit.setNumberperDay((short) 1);
        actualBenPersonalHabit.setOtherAlcoholType("Other Alcohol Type");
        actualBenPersonalHabit.setOtherTobaccoUseType("Other Tobacco Use Type");
        actualBenPersonalHabit.setParkingPlaceID(1);
        actualBenPersonalHabit.setPhysicalActivityType("Physical Activity Type");
        actualBenPersonalHabit.setProcessed("Processed");
        actualBenPersonalHabit.setProviderServiceMapID(1);
        actualBenPersonalHabit.setReservedForChange("Reserved For Change");
        actualBenPersonalHabit.setRiskySexualPracticeStatus("Risky Sexual Practice Status");
        actualBenPersonalHabit.setRiskySexualPracticesStatus('A');
        actualBenPersonalHabit.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenPersonalHabit.setSyncedDate(syncedDate);
        ArrayList<Map<String, String>> tobaccoList = new ArrayList<>();
        actualBenPersonalHabit.setTobaccoList(tobaccoList);
        Timestamp tobaccoUseDuration = mock(Timestamp.class);
        actualBenPersonalHabit.setTobaccoUseDuration(tobaccoUseDuration);
        actualBenPersonalHabit.setTobaccoUseStatus("Tobacco Use Status");
        actualBenPersonalHabit.setTobaccoUseType("Tobacco Use Type");
        actualBenPersonalHabit.setTobaccoUseTypeID("Tobacco Use Type ID");
        Date tobacco_use_duration = mock(Date.class);
        actualBenPersonalHabit.setTobacco_use_duration(tobacco_use_duration);
        actualBenPersonalHabit.setVanID(1);
        actualBenPersonalHabit.setVanSerialNo(1L);
        actualBenPersonalHabit.setVehicalNo("Vehical No");
        actualBenPersonalHabit.setVisitCode(1L);
        Timestamp actualAlcoholDuration = actualBenPersonalHabit.getAlcoholDuration();
        String actualAlcoholIntakeFrequency = actualBenPersonalHabit.getAlcoholIntakeFrequency();
        String actualAlcoholIntakeStatus = actualBenPersonalHabit.getAlcoholIntakeStatus();
        List<Map<String, String>> actualAlcoholList = actualBenPersonalHabit.getAlcoholList();
        String actualAlcoholType = actualBenPersonalHabit.getAlcoholType();
        String actualAlcoholTypeID = actualBenPersonalHabit.getAlcoholTypeID();
        Date actualAlcohol_use_duration = actualBenPersonalHabit.getAlcohol_use_duration();
        List<BenAllergyHistory> actualAllergicList = actualBenPersonalHabit.getAllergicList();
        String actualAllergyStatus = actualBenPersonalHabit.getAllergyStatus();
        String actualAvgAlcoholConsumption = actualBenPersonalHabit.getAvgAlcoholConsumption();
        Integer actualBenPersonalHabitID = actualBenPersonalHabit.getBenPersonalHabitID();
        Long actualBenVisitID = actualBenPersonalHabit.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenPersonalHabit.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenPersonalHabit.getCaptureDate();
        String actualCreatedBy = actualBenPersonalHabit.getCreatedBy();
        Timestamp actualCreatedDate = actualBenPersonalHabit.getCreatedDate();
        Boolean actualDeleted = actualBenPersonalHabit.getDeleted();
        String actualDietaryType = actualBenPersonalHabit.getDietaryType();
        Timestamp actualLastModDate = actualBenPersonalHabit.getLastModDate();
        String actualModifiedBy = actualBenPersonalHabit.getModifiedBy();
        Short actualNumberperDay = actualBenPersonalHabit.getNumberperDay();
        String actualOtherAlcoholType = actualBenPersonalHabit.getOtherAlcoholType();
        String actualOtherTobaccoUseType = actualBenPersonalHabit.getOtherTobaccoUseType();
        Integer actualParkingPlaceID = actualBenPersonalHabit.getParkingPlaceID();
        String actualPhysicalActivityType = actualBenPersonalHabit.getPhysicalActivityType();
        String actualProcessed = actualBenPersonalHabit.getProcessed();
        Integer actualProviderServiceMapID = actualBenPersonalHabit.getProviderServiceMapID();
        String actualReservedForChange = actualBenPersonalHabit.getReservedForChange();
        String actualRiskySexualPracticeStatus = actualBenPersonalHabit.getRiskySexualPracticeStatus();
        Character actualRiskySexualPracticesStatus = actualBenPersonalHabit.getRiskySexualPracticesStatus();
        String actualSyncedBy = actualBenPersonalHabit.getSyncedBy();
        Timestamp actualSyncedDate = actualBenPersonalHabit.getSyncedDate();
        List<Map<String, String>> actualTobaccoList = actualBenPersonalHabit.getTobaccoList();
        Timestamp actualTobaccoUseDuration = actualBenPersonalHabit.getTobaccoUseDuration();
        String actualTobaccoUseStatus = actualBenPersonalHabit.getTobaccoUseStatus();
        String actualTobaccoUseType = actualBenPersonalHabit.getTobaccoUseType();
        String actualTobaccoUseTypeID = actualBenPersonalHabit.getTobaccoUseTypeID();
        Date actualTobacco_use_duration = actualBenPersonalHabit.getTobacco_use_duration();
        Integer actualVanID = actualBenPersonalHabit.getVanID();
        Long actualVanSerialNo = actualBenPersonalHabit.getVanSerialNo();
        String actualVehicalNo = actualBenPersonalHabit.getVehicalNo();
        Long actualVisitCode = actualBenPersonalHabit.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Alcohol Intake Frequency", actualAlcoholIntakeFrequency);
        assertEquals("Alcohol Intake Status", actualAlcoholIntakeStatus);
        assertEquals("Alcohol Type ID", actualAlcoholTypeID);
        assertEquals("Alcohol Type", actualAlcoholType);
        assertEquals("Allergy Status", actualAllergyStatus);
        assertEquals("Avg Alcohol Consumption", actualAvgAlcoholConsumption);
        assertEquals("Dietary Type", actualDietaryType);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Alcohol Type", actualOtherAlcoholType);
        assertEquals("Other Tobacco Use Type", actualOtherTobaccoUseType);
        assertEquals("Physical Activity Type", actualPhysicalActivityType);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Risky Sexual Practice Status", actualRiskySexualPracticeStatus);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Tobacco Use Status", actualTobaccoUseStatus);
        assertEquals("Tobacco Use Type ID", actualTobaccoUseTypeID);
        assertEquals("Tobacco Use Type", actualTobaccoUseType);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals('A', actualRiskySexualPracticesStatus.charValue());
        assertEquals(1, actualBenPersonalHabitID.intValue());
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals((short) 1, actualNumberperDay.shortValue());
        assertTrue(actualDeleted);
        assertSame(alcoholList, actualAlcoholList);
        assertSame(allergicList, actualAllergicList);
        assertSame(tobaccoList, actualTobaccoList);
        assertSame(alcohol_use_duration, actualAlcohol_use_duration);
        assertSame(captureDate, actualCaptureDate);
        assertSame(tobacco_use_duration, actualTobacco_use_duration);
        assertSame(alcoholDuration, actualAlcoholDuration);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
        assertSame(tobaccoUseDuration, actualTobaccoUseDuration);
    }
    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        BenPersonalHabit actualBenPersonalHabit = new BenPersonalHabit(1L, 1L, 1, "Dietary Type", "Physical Activity Type",
                "Tobacco Use Status", "Alcohol Intake Status", 'A');
        Timestamp alcoholDuration = mock(Timestamp.class);
        actualBenPersonalHabit.setAlcoholDuration(alcoholDuration);
        actualBenPersonalHabit.setAlcoholIntakeFrequency("Alcohol Intake Frequency");
        actualBenPersonalHabit.setAlcoholIntakeStatus("Alcohol Intake Status");
        ArrayList<Map<String, String>> alcoholList = new ArrayList<>();
        actualBenPersonalHabit.setAlcoholList(alcoholList);
        actualBenPersonalHabit.setAlcoholType("Alcohol Type");
        actualBenPersonalHabit.setAlcoholTypeID("Alcohol Type ID");
        Date alcohol_use_duration = mock(Date.class);
        actualBenPersonalHabit.setAlcohol_use_duration(alcohol_use_duration);
        ArrayList<BenAllergyHistory> allergicList = new ArrayList<>();
        actualBenPersonalHabit.setAllergicList(allergicList);
        actualBenPersonalHabit.setAllergyStatus("Allergy Status");
        actualBenPersonalHabit.setAvgAlcoholConsumption("Avg Alcohol Consumption");
        actualBenPersonalHabit.setBenPersonalHabitID(1);
        actualBenPersonalHabit.setBenVisitID(1L);
        actualBenPersonalHabit.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenPersonalHabit.setCaptureDate(captureDate);
        actualBenPersonalHabit.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenPersonalHabit.setCreatedDate(createdDate);
        actualBenPersonalHabit.setDeleted(true);
        actualBenPersonalHabit.setDietaryType("Dietary Type");
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenPersonalHabit.setLastModDate(lastModDate);
        actualBenPersonalHabit.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenPersonalHabit.setNumberperDay((short) 1);
        actualBenPersonalHabit.setOtherAlcoholType("Other Alcohol Type");
        actualBenPersonalHabit.setOtherTobaccoUseType("Other Tobacco Use Type");
        actualBenPersonalHabit.setParkingPlaceID(1);
        actualBenPersonalHabit.setPhysicalActivityType("Physical Activity Type");
        actualBenPersonalHabit.setProcessed("Processed");
        actualBenPersonalHabit.setProviderServiceMapID(1);
        actualBenPersonalHabit.setReservedForChange("Reserved For Change");
        actualBenPersonalHabit.setRiskySexualPracticeStatus("Risky Sexual Practice Status");
        actualBenPersonalHabit.setRiskySexualPracticesStatus('A');
        actualBenPersonalHabit.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenPersonalHabit.setSyncedDate(syncedDate);
        ArrayList<Map<String, String>> tobaccoList = new ArrayList<>();
        actualBenPersonalHabit.setTobaccoList(tobaccoList);
        Timestamp tobaccoUseDuration = mock(Timestamp.class);
        actualBenPersonalHabit.setTobaccoUseDuration(tobaccoUseDuration);
        actualBenPersonalHabit.setTobaccoUseStatus("Tobacco Use Status");
        actualBenPersonalHabit.setTobaccoUseType("Tobacco Use Type");
        actualBenPersonalHabit.setTobaccoUseTypeID("Tobacco Use Type ID");
        Date tobacco_use_duration = mock(Date.class);
        actualBenPersonalHabit.setTobacco_use_duration(tobacco_use_duration);
        actualBenPersonalHabit.setVanID(1);
        actualBenPersonalHabit.setVanSerialNo(1L);
        actualBenPersonalHabit.setVehicalNo("Vehical No");
        actualBenPersonalHabit.setVisitCode(1L);
        Timestamp actualAlcoholDuration = actualBenPersonalHabit.getAlcoholDuration();
        String actualAlcoholIntakeFrequency = actualBenPersonalHabit.getAlcoholIntakeFrequency();
        String actualAlcoholIntakeStatus = actualBenPersonalHabit.getAlcoholIntakeStatus();
        List<Map<String, String>> actualAlcoholList = actualBenPersonalHabit.getAlcoholList();
        String actualAlcoholType = actualBenPersonalHabit.getAlcoholType();
        String actualAlcoholTypeID = actualBenPersonalHabit.getAlcoholTypeID();
        Date actualAlcohol_use_duration = actualBenPersonalHabit.getAlcohol_use_duration();
        List<BenAllergyHistory> actualAllergicList = actualBenPersonalHabit.getAllergicList();
        String actualAllergyStatus = actualBenPersonalHabit.getAllergyStatus();
        String actualAvgAlcoholConsumption = actualBenPersonalHabit.getAvgAlcoholConsumption();
        Integer actualBenPersonalHabitID = actualBenPersonalHabit.getBenPersonalHabitID();
        Long actualBenVisitID = actualBenPersonalHabit.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenPersonalHabit.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenPersonalHabit.getCaptureDate();
        String actualCreatedBy = actualBenPersonalHabit.getCreatedBy();
        Timestamp actualCreatedDate = actualBenPersonalHabit.getCreatedDate();
        Boolean actualDeleted = actualBenPersonalHabit.getDeleted();
        String actualDietaryType = actualBenPersonalHabit.getDietaryType();
        Timestamp actualLastModDate = actualBenPersonalHabit.getLastModDate();
        String actualModifiedBy = actualBenPersonalHabit.getModifiedBy();
        Short actualNumberperDay = actualBenPersonalHabit.getNumberperDay();
        String actualOtherAlcoholType = actualBenPersonalHabit.getOtherAlcoholType();
        String actualOtherTobaccoUseType = actualBenPersonalHabit.getOtherTobaccoUseType();
        Integer actualParkingPlaceID = actualBenPersonalHabit.getParkingPlaceID();
        String actualPhysicalActivityType = actualBenPersonalHabit.getPhysicalActivityType();
        String actualProcessed = actualBenPersonalHabit.getProcessed();
        Integer actualProviderServiceMapID = actualBenPersonalHabit.getProviderServiceMapID();
        String actualReservedForChange = actualBenPersonalHabit.getReservedForChange();
        String actualRiskySexualPracticeStatus = actualBenPersonalHabit.getRiskySexualPracticeStatus();
        Character actualRiskySexualPracticesStatus = actualBenPersonalHabit.getRiskySexualPracticesStatus();
        String actualSyncedBy = actualBenPersonalHabit.getSyncedBy();
        Timestamp actualSyncedDate = actualBenPersonalHabit.getSyncedDate();
        List<Map<String, String>> actualTobaccoList = actualBenPersonalHabit.getTobaccoList();
        Timestamp actualTobaccoUseDuration = actualBenPersonalHabit.getTobaccoUseDuration();
        String actualTobaccoUseStatus = actualBenPersonalHabit.getTobaccoUseStatus();
        String actualTobaccoUseType = actualBenPersonalHabit.getTobaccoUseType();
        String actualTobaccoUseTypeID = actualBenPersonalHabit.getTobaccoUseTypeID();
        Date actualTobacco_use_duration = actualBenPersonalHabit.getTobacco_use_duration();
        Integer actualVanID = actualBenPersonalHabit.getVanID();
        Long actualVanSerialNo = actualBenPersonalHabit.getVanSerialNo();
        String actualVehicalNo = actualBenPersonalHabit.getVehicalNo();
        Long actualVisitCode = actualBenPersonalHabit.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Alcohol Intake Frequency", actualAlcoholIntakeFrequency);
        assertEquals("Alcohol Intake Status", actualAlcoholIntakeStatus);
        assertEquals("Alcohol Type ID", actualAlcoholTypeID);
        assertEquals("Alcohol Type", actualAlcoholType);
        assertEquals("Allergy Status", actualAllergyStatus);
        assertEquals("Avg Alcohol Consumption", actualAvgAlcoholConsumption);
        assertEquals("Dietary Type", actualDietaryType);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Alcohol Type", actualOtherAlcoholType);
        assertEquals("Other Tobacco Use Type", actualOtherTobaccoUseType);
        assertEquals("Physical Activity Type", actualPhysicalActivityType);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Risky Sexual Practice Status", actualRiskySexualPracticeStatus);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Tobacco Use Status", actualTobaccoUseStatus);
        assertEquals("Tobacco Use Type ID", actualTobaccoUseTypeID);
        assertEquals("Tobacco Use Type", actualTobaccoUseType);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals('A', actualRiskySexualPracticesStatus.charValue());
        assertEquals(1, actualBenPersonalHabitID.intValue());
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals((short) 1, actualNumberperDay.shortValue());
        assertTrue(actualDeleted);
        assertSame(alcoholList, actualAlcoholList);
        assertSame(allergicList, actualAllergicList);
        assertSame(tobaccoList, actualTobaccoList);
        assertSame(alcohol_use_duration, actualAlcohol_use_duration);
        assertSame(captureDate, actualCaptureDate);
        assertSame(tobacco_use_duration, actualTobacco_use_duration);
        assertSame(alcoholDuration, actualAlcoholDuration);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
        assertSame(tobaccoUseDuration, actualTobaccoUseDuration);
    }

    @Test
    void testGettersAndSetters3() {
        // Arrange and Act
        BenPersonalHabit actualBenPersonalHabit = new BenPersonalHabit("Tobacco Use Type ID", "Tobacco Use Type",
                "Other Tobacco Use Type", (short) 1, mock(Timestamp.class), "Alcohol Type ID", "Alcohol Type",
                "Other Alcohol Type", "Alcohol Intake Frequency", "Avg Alcohol Consumption", mock(Timestamp.class),
                mock(Timestamp.class), 1L);
        Timestamp alcoholDuration = mock(Timestamp.class);
        actualBenPersonalHabit.setAlcoholDuration(alcoholDuration);
        actualBenPersonalHabit.setAlcoholIntakeFrequency("Alcohol Intake Frequency");
        actualBenPersonalHabit.setAlcoholIntakeStatus("Alcohol Intake Status");
        ArrayList<Map<String, String>> alcoholList = new ArrayList<>();
        actualBenPersonalHabit.setAlcoholList(alcoholList);
        actualBenPersonalHabit.setAlcoholType("Alcohol Type");
        actualBenPersonalHabit.setAlcoholTypeID("Alcohol Type ID");
        Date alcohol_use_duration = mock(Date.class);
        actualBenPersonalHabit.setAlcohol_use_duration(alcohol_use_duration);
        ArrayList<BenAllergyHistory> allergicList = new ArrayList<>();
        actualBenPersonalHabit.setAllergicList(allergicList);
        actualBenPersonalHabit.setAllergyStatus("Allergy Status");
        actualBenPersonalHabit.setAvgAlcoholConsumption("Avg Alcohol Consumption");
        actualBenPersonalHabit.setBenPersonalHabitID(1);
        actualBenPersonalHabit.setBenVisitID(1L);
        actualBenPersonalHabit.setBeneficiaryRegID(1L);
        Date captureDate = mock(Date.class);
        actualBenPersonalHabit.setCaptureDate(captureDate);
        actualBenPersonalHabit.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenPersonalHabit.setCreatedDate(createdDate);
        actualBenPersonalHabit.setDeleted(true);
        actualBenPersonalHabit.setDietaryType("Dietary Type");
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenPersonalHabit.setLastModDate(lastModDate);
        actualBenPersonalHabit.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenPersonalHabit.setNumberperDay((short) 1);
        actualBenPersonalHabit.setOtherAlcoholType("Other Alcohol Type");
        actualBenPersonalHabit.setOtherTobaccoUseType("Other Tobacco Use Type");
        actualBenPersonalHabit.setParkingPlaceID(1);
        actualBenPersonalHabit.setPhysicalActivityType("Physical Activity Type");
        actualBenPersonalHabit.setProcessed("Processed");
        actualBenPersonalHabit.setProviderServiceMapID(1);
        actualBenPersonalHabit.setReservedForChange("Reserved For Change");
        actualBenPersonalHabit.setRiskySexualPracticeStatus("Risky Sexual Practice Status");
        actualBenPersonalHabit.setRiskySexualPracticesStatus('A');
        actualBenPersonalHabit.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenPersonalHabit.setSyncedDate(syncedDate);
        ArrayList<Map<String, String>> tobaccoList = new ArrayList<>();
        actualBenPersonalHabit.setTobaccoList(tobaccoList);
        Timestamp tobaccoUseDuration = mock(Timestamp.class);
        actualBenPersonalHabit.setTobaccoUseDuration(tobaccoUseDuration);
        actualBenPersonalHabit.setTobaccoUseStatus("Tobacco Use Status");
        actualBenPersonalHabit.setTobaccoUseType("Tobacco Use Type");
        actualBenPersonalHabit.setTobaccoUseTypeID("Tobacco Use Type ID");
        Date tobacco_use_duration = mock(Date.class);
        actualBenPersonalHabit.setTobacco_use_duration(tobacco_use_duration);
        actualBenPersonalHabit.setVanID(1);
        actualBenPersonalHabit.setVanSerialNo(1L);
        actualBenPersonalHabit.setVehicalNo("Vehical No");
        actualBenPersonalHabit.setVisitCode(1L);
        Timestamp actualAlcoholDuration = actualBenPersonalHabit.getAlcoholDuration();
        String actualAlcoholIntakeFrequency = actualBenPersonalHabit.getAlcoholIntakeFrequency();
        String actualAlcoholIntakeStatus = actualBenPersonalHabit.getAlcoholIntakeStatus();
        List<Map<String, String>> actualAlcoholList = actualBenPersonalHabit.getAlcoholList();
        String actualAlcoholType = actualBenPersonalHabit.getAlcoholType();
        String actualAlcoholTypeID = actualBenPersonalHabit.getAlcoholTypeID();
        Date actualAlcohol_use_duration = actualBenPersonalHabit.getAlcohol_use_duration();
        List<BenAllergyHistory> actualAllergicList = actualBenPersonalHabit.getAllergicList();
        String actualAllergyStatus = actualBenPersonalHabit.getAllergyStatus();
        String actualAvgAlcoholConsumption = actualBenPersonalHabit.getAvgAlcoholConsumption();
        Integer actualBenPersonalHabitID = actualBenPersonalHabit.getBenPersonalHabitID();
        Long actualBenVisitID = actualBenPersonalHabit.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenPersonalHabit.getBeneficiaryRegID();
        Date actualCaptureDate = actualBenPersonalHabit.getCaptureDate();
        String actualCreatedBy = actualBenPersonalHabit.getCreatedBy();
        Timestamp actualCreatedDate = actualBenPersonalHabit.getCreatedDate();
        Boolean actualDeleted = actualBenPersonalHabit.getDeleted();
        String actualDietaryType = actualBenPersonalHabit.getDietaryType();
        Timestamp actualLastModDate = actualBenPersonalHabit.getLastModDate();
        String actualModifiedBy = actualBenPersonalHabit.getModifiedBy();
        Short actualNumberperDay = actualBenPersonalHabit.getNumberperDay();
        String actualOtherAlcoholType = actualBenPersonalHabit.getOtherAlcoholType();
        String actualOtherTobaccoUseType = actualBenPersonalHabit.getOtherTobaccoUseType();
        Integer actualParkingPlaceID = actualBenPersonalHabit.getParkingPlaceID();
        String actualPhysicalActivityType = actualBenPersonalHabit.getPhysicalActivityType();
        String actualProcessed = actualBenPersonalHabit.getProcessed();
        Integer actualProviderServiceMapID = actualBenPersonalHabit.getProviderServiceMapID();
        String actualReservedForChange = actualBenPersonalHabit.getReservedForChange();
        String actualRiskySexualPracticeStatus = actualBenPersonalHabit.getRiskySexualPracticeStatus();
        Character actualRiskySexualPracticesStatus = actualBenPersonalHabit.getRiskySexualPracticesStatus();
        String actualSyncedBy = actualBenPersonalHabit.getSyncedBy();
        Timestamp actualSyncedDate = actualBenPersonalHabit.getSyncedDate();
        List<Map<String, String>> actualTobaccoList = actualBenPersonalHabit.getTobaccoList();
        Timestamp actualTobaccoUseDuration = actualBenPersonalHabit.getTobaccoUseDuration();
        String actualTobaccoUseStatus = actualBenPersonalHabit.getTobaccoUseStatus();
        String actualTobaccoUseType = actualBenPersonalHabit.getTobaccoUseType();
        String actualTobaccoUseTypeID = actualBenPersonalHabit.getTobaccoUseTypeID();
        Date actualTobacco_use_duration = actualBenPersonalHabit.getTobacco_use_duration();
        Integer actualVanID = actualBenPersonalHabit.getVanID();
        Long actualVanSerialNo = actualBenPersonalHabit.getVanSerialNo();
        String actualVehicalNo = actualBenPersonalHabit.getVehicalNo();
        Long actualVisitCode = actualBenPersonalHabit.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Alcohol Intake Frequency", actualAlcoholIntakeFrequency);
        assertEquals("Alcohol Intake Status", actualAlcoholIntakeStatus);
        assertEquals("Alcohol Type ID", actualAlcoholTypeID);
        assertEquals("Alcohol Type", actualAlcoholType);
        assertEquals("Allergy Status", actualAllergyStatus);
        assertEquals("Avg Alcohol Consumption", actualAvgAlcoholConsumption);
        assertEquals("Dietary Type", actualDietaryType);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Alcohol Type", actualOtherAlcoholType);
        assertEquals("Other Tobacco Use Type", actualOtherTobaccoUseType);
        assertEquals("Physical Activity Type", actualPhysicalActivityType);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Risky Sexual Practice Status", actualRiskySexualPracticeStatus);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Tobacco Use Status", actualTobaccoUseStatus);
        assertEquals("Tobacco Use Type ID", actualTobaccoUseTypeID);
        assertEquals("Tobacco Use Type", actualTobaccoUseType);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals('A', actualRiskySexualPracticesStatus.charValue());
        assertEquals(1, actualBenPersonalHabitID.intValue());
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals((short) 1, actualNumberperDay.shortValue());
        assertTrue(actualDeleted);
        assertSame(alcoholList, actualAlcoholList);
        assertSame(allergicList, actualAllergicList);
        assertSame(tobaccoList, actualTobaccoList);
        assertSame(alcohol_use_duration, actualAlcohol_use_duration);
        assertSame(captureDate, actualCaptureDate);
        assertSame(tobacco_use_duration, actualTobacco_use_duration);
        assertSame(alcoholDuration, actualAlcoholDuration);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
        assertSame(tobaccoUseDuration, actualTobaccoUseDuration);
    }

    @Test
    void testNewBenPersonalHabit() {
        // Arrange
        Date createdDate = mock(Date.class);
        Date tobaccoUseDuration = mock(Date.class);

        // Act
        BenPersonalHabit actualBenPersonalHabit = new BenPersonalHabit(createdDate, "Dietary Type",
                "Physical Activity Type", "Tobacco Use Status", "Tobacco Use Type", "Other Tobacco Use Type", (short) 1,
                tobaccoUseDuration, 'A');

        // Assert
        assertEquals("Dietary Type", actualBenPersonalHabit.getDietaryType());
        assertEquals("Other Tobacco Use Type", actualBenPersonalHabit.getOtherTobaccoUseType());
        assertEquals("Physical Activity Type", actualBenPersonalHabit.getPhysicalActivityType());
        assertEquals("Tobacco Use Status", actualBenPersonalHabit.getTobaccoUseStatus());
        assertEquals("Tobacco Use Type", actualBenPersonalHabit.getTobaccoUseType());
        assertEquals((short) 1, actualBenPersonalHabit.getNumberperDay().shortValue());
        assertSame(createdDate, actualBenPersonalHabit.getCaptureDate());
        assertSame(tobaccoUseDuration, actualBenPersonalHabit.getTobacco_use_duration());
    }

    @Test
    void testNewBenPersonalHabit2() {
        // Arrange
        Date createdDate = mock(Date.class);
        Date tobaccoUseDuration = mock(Date.class);

        // Act
        BenPersonalHabit actualBenPersonalHabit = new BenPersonalHabit(createdDate, "Dietary Type",
                "Physical Activity Type", "Tobacco Use Status", "Tobacco Use Type", "Other Tobacco Use Type", (short) 1,
                tobaccoUseDuration, '0');

        // Assert
        assertEquals("Dietary Type", actualBenPersonalHabit.getDietaryType());
        assertEquals("No", actualBenPersonalHabit.getRiskySexualPracticeStatus());
        assertEquals("Other Tobacco Use Type", actualBenPersonalHabit.getOtherTobaccoUseType());
        assertEquals("Physical Activity Type", actualBenPersonalHabit.getPhysicalActivityType());
        assertEquals("Tobacco Use Status", actualBenPersonalHabit.getTobaccoUseStatus());
        assertEquals("Tobacco Use Type", actualBenPersonalHabit.getTobaccoUseType());
        assertEquals((short) 1, actualBenPersonalHabit.getNumberperDay().shortValue());
        assertSame(createdDate, actualBenPersonalHabit.getCaptureDate());
        assertSame(tobaccoUseDuration, actualBenPersonalHabit.getTobacco_use_duration());
    }

    @Test
    void testNewBenPersonalHabit3() {
        // Arrange
        Date createdDate = mock(Date.class);
        Date tobaccoUseDuration = mock(Date.class);

        // Act
        BenPersonalHabit actualBenPersonalHabit = new BenPersonalHabit(createdDate, "Dietary Type",
                "Physical Activity Type", "Tobacco Use Status", "Tobacco Use Type", "Other Tobacco Use Type", (short) 1,
                tobaccoUseDuration, '1');

        // Assert
        assertEquals("Dietary Type", actualBenPersonalHabit.getDietaryType());
        assertEquals("Other Tobacco Use Type", actualBenPersonalHabit.getOtherTobaccoUseType());
        assertEquals("Physical Activity Type", actualBenPersonalHabit.getPhysicalActivityType());
        assertEquals("Tobacco Use Status", actualBenPersonalHabit.getTobaccoUseStatus());
        assertEquals("Tobacco Use Type", actualBenPersonalHabit.getTobaccoUseType());
        assertEquals("Yes", actualBenPersonalHabit.getRiskySexualPracticeStatus());
        assertEquals((short) 1, actualBenPersonalHabit.getNumberperDay().shortValue());
        assertSame(createdDate, actualBenPersonalHabit.getCaptureDate());
        assertSame(tobaccoUseDuration, actualBenPersonalHabit.getTobacco_use_duration());
    }

    @Test
    void testNewBenPersonalHabit4() {
        // Arrange
        Date createdDate = mock(Date.class);
        Date tobaccoUseDuration = mock(Date.class);

        // Act
        BenPersonalHabit actualBenPersonalHabit = new BenPersonalHabit(createdDate, "Dietary Type",
                "Physical Activity Type", "Tobacco Use Status", "Tobacco Use Type", "Other Tobacco Use Type", (short) 1,
                tobaccoUseDuration, null);

        // Assert
        assertEquals("Dietary Type", actualBenPersonalHabit.getDietaryType());
        assertEquals("Other Tobacco Use Type", actualBenPersonalHabit.getOtherTobaccoUseType());
        assertEquals("Physical Activity Type", actualBenPersonalHabit.getPhysicalActivityType());
        assertEquals("Tobacco Use Status", actualBenPersonalHabit.getTobaccoUseStatus());
        assertEquals("Tobacco Use Type", actualBenPersonalHabit.getTobaccoUseType());
        assertEquals((short) 1, actualBenPersonalHabit.getNumberperDay().shortValue());
        assertSame(createdDate, actualBenPersonalHabit.getCaptureDate());
        assertSame(tobaccoUseDuration, actualBenPersonalHabit.getTobacco_use_duration());
    }

    @Test
    void testNewBenPersonalHabit5() {
        // Arrange
        Date createdDate = mock(Date.class);
        Date alcoholDuration = mock(Date.class);

        // Act
        BenPersonalHabit actualBenPersonalHabit = new BenPersonalHabit(createdDate, "Dietary Type",
                "Physical Activity Type", "Alcohol Intake Status", "Alcohol Type", "Other Alcohol Type",
                "Alcohol Intake Frequency", "Avg Alcohol Consumption", alcoholDuration, 'A');

        // Assert
        assertEquals("Alcohol Intake Frequency", actualBenPersonalHabit.getAlcoholIntakeFrequency());
        assertEquals("Alcohol Intake Status", actualBenPersonalHabit.getAlcoholIntakeStatus());
        assertEquals("Alcohol Type", actualBenPersonalHabit.getAlcoholType());
        assertEquals("Avg Alcohol Consumption", actualBenPersonalHabit.getAvgAlcoholConsumption());
        assertEquals("Dietary Type", actualBenPersonalHabit.getDietaryType());
        assertEquals("Other Alcohol Type", actualBenPersonalHabit.getOtherAlcoholType());
        assertEquals("Physical Activity Type", actualBenPersonalHabit.getPhysicalActivityType());
        assertEquals("Yes", actualBenPersonalHabit.getRiskySexualPracticeStatus());
        assertSame(alcoholDuration, actualBenPersonalHabit.getAlcohol_use_duration());
        assertSame(createdDate, actualBenPersonalHabit.getCaptureDate());
    }

    @Test
    void testNewBenPersonalHabit6() {
        // Arrange
        Date createdDate = mock(Date.class);
        Date alcoholDuration = mock(Date.class);

        // Act
        BenPersonalHabit actualBenPersonalHabit = new BenPersonalHabit(createdDate, "Dietary Type",
                "Physical Activity Type", "Alcohol Intake Status", "Alcohol Type", "Other Alcohol Type",
                "Alcohol Intake Frequency", "Avg Alcohol Consumption", alcoholDuration, '0');

        // Assert
        assertEquals("Alcohol Intake Frequency", actualBenPersonalHabit.getAlcoholIntakeFrequency());
        assertEquals("Alcohol Intake Status", actualBenPersonalHabit.getAlcoholIntakeStatus());
        assertEquals("Alcohol Type", actualBenPersonalHabit.getAlcoholType());
        assertEquals("Avg Alcohol Consumption", actualBenPersonalHabit.getAvgAlcoholConsumption());
        assertEquals("Dietary Type", actualBenPersonalHabit.getDietaryType());
        assertEquals("No", actualBenPersonalHabit.getRiskySexualPracticeStatus());
        assertEquals("Other Alcohol Type", actualBenPersonalHabit.getOtherAlcoholType());
        assertEquals("Physical Activity Type", actualBenPersonalHabit.getPhysicalActivityType());
        assertSame(alcoholDuration, actualBenPersonalHabit.getAlcohol_use_duration());
        assertSame(createdDate, actualBenPersonalHabit.getCaptureDate());
    }
}
