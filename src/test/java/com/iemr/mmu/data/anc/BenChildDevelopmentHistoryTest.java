package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import org.springframework.test.annotation.DirtiesContext;

@ExtendWith(MockitoExtension.class)
class BenChildDevelopmentHistoryTest {
    @Test
    void testGetDevelopmentHistory() {
        // Arrange
        BenChildDevelopmentHistory benChildDevelopmentHistory = new BenChildDevelopmentHistory();
        benChildDevelopmentHistory.setBenVisitID(1L);
        benChildDevelopmentHistory.setBeneficiaryRegID(1L);
        benChildDevelopmentHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        benChildDevelopmentHistory.setCreatedDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setDeleted(true);
        benChildDevelopmentHistory.setDevelopmentProblem("Development Problem");
        benChildDevelopmentHistory.setDevelopmentProblems(new ArrayList<>());
        benChildDevelopmentHistory.setFineMotorMilestone("Fine Motor Milestone");
        benChildDevelopmentHistory.setFineMotorMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setGrossMotorMilestone("Gross Motor Milestone");
        benChildDevelopmentHistory.setGrossMotorMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setID(1L);
        benChildDevelopmentHistory.setIsFMMAttained(true);
        benChildDevelopmentHistory.setIsGMMAttained(true);
        benChildDevelopmentHistory.setIsLMAttained(true);
        benChildDevelopmentHistory.setIsSMAttained(true);
        benChildDevelopmentHistory.setLanguageMilestone("en");
        benChildDevelopmentHistory.setLanguageMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setLastModDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        benChildDevelopmentHistory.setParkingPlaceID(1);
        benChildDevelopmentHistory.setProcessed("Processed");
        benChildDevelopmentHistory.setProviderServiceMapID(1);
        benChildDevelopmentHistory.setReservedForChange("Reserved For Change");
        benChildDevelopmentHistory.setSocialMilestone("Social Milestone");
        benChildDevelopmentHistory.setSocialMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setSyncedBy("Synced By");
        benChildDevelopmentHistory.setSyncedDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setVanSerialNo(1L);
        benChildDevelopmentHistory.setVehicalNo("Vehical No");
        benChildDevelopmentHistory.setVisitCode(1L);

        // Act
        BenChildDevelopmentHistory actualDevelopmentHistory = BenChildDevelopmentHistory
                .getDevelopmentHistory(benChildDevelopmentHistory);

        // Assert
        assertEquals("", actualDevelopmentHistory.getDevelopmentProblem());
        assertEquals("", actualDevelopmentHistory.getFineMotorMilestone());
        assertEquals("", actualDevelopmentHistory.getGrossMotorMilestone());
        assertEquals("", actualDevelopmentHistory.getLanguageMilestone());
        assertEquals("", actualDevelopmentHistory.getSocialMilestone());
    }

    @Test
    void testGetDevelopmentHistory2() {
        // Arrange
        ArrayList<String> developmentProblems = new ArrayList<>();
        developmentProblems.add("foo");

        BenChildDevelopmentHistory benChildDevelopmentHistory = new BenChildDevelopmentHistory();
        benChildDevelopmentHistory.setBenVisitID(1L);
        benChildDevelopmentHistory.setBeneficiaryRegID(1L);
        benChildDevelopmentHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        benChildDevelopmentHistory.setCreatedDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setDeleted(true);
        benChildDevelopmentHistory.setDevelopmentProblem("Development Problem");
        benChildDevelopmentHistory.setDevelopmentProblems(developmentProblems);
        benChildDevelopmentHistory.setFineMotorMilestone("Fine Motor Milestone");
        benChildDevelopmentHistory.setFineMotorMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setGrossMotorMilestone("Gross Motor Milestone");
        benChildDevelopmentHistory.setGrossMotorMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setID(1L);
        benChildDevelopmentHistory.setIsFMMAttained(true);
        benChildDevelopmentHistory.setIsGMMAttained(true);
        benChildDevelopmentHistory.setIsLMAttained(true);
        benChildDevelopmentHistory.setIsSMAttained(true);
        benChildDevelopmentHistory.setLanguageMilestone("en");
        benChildDevelopmentHistory.setLanguageMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setLastModDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        benChildDevelopmentHistory.setParkingPlaceID(1);
        benChildDevelopmentHistory.setProcessed("Processed");
        benChildDevelopmentHistory.setProviderServiceMapID(1);
        benChildDevelopmentHistory.setReservedForChange("Reserved For Change");
        benChildDevelopmentHistory.setSocialMilestone("Social Milestone");
        benChildDevelopmentHistory.setSocialMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setSyncedBy("Synced By");
        benChildDevelopmentHistory.setSyncedDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setVanSerialNo(1L);
        benChildDevelopmentHistory.setVehicalNo("Vehical No");
        benChildDevelopmentHistory.setVisitCode(1L);

        // Act
        BenChildDevelopmentHistory actualDevelopmentHistory = BenChildDevelopmentHistory
                .getDevelopmentHistory(benChildDevelopmentHistory);

        // Assert
        assertEquals("", actualDevelopmentHistory.getFineMotorMilestone());
        assertEquals("", actualDevelopmentHistory.getGrossMotorMilestone());
        assertEquals("", actualDevelopmentHistory.getLanguageMilestone());
        assertEquals("", actualDevelopmentHistory.getSocialMilestone());
        assertEquals("foo,", actualDevelopmentHistory.getDevelopmentProblem());
    }

    @Test
    void testGetDevelopmentHistory3() {
        // Arrange
        ArrayList<String> fineMotorMilestones = new ArrayList<>();
        fineMotorMilestones.add("foo");

        BenChildDevelopmentHistory benChildDevelopmentHistory = new BenChildDevelopmentHistory();
        benChildDevelopmentHistory.setBenVisitID(1L);
        benChildDevelopmentHistory.setBeneficiaryRegID(1L);
        benChildDevelopmentHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        benChildDevelopmentHistory.setCreatedDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setDeleted(true);
        benChildDevelopmentHistory.setDevelopmentProblem("Development Problem");
        benChildDevelopmentHistory.setDevelopmentProblems(new ArrayList<>());
        benChildDevelopmentHistory.setFineMotorMilestone("Fine Motor Milestone");
        benChildDevelopmentHistory.setFineMotorMilestones(fineMotorMilestones);
        benChildDevelopmentHistory.setGrossMotorMilestone("Gross Motor Milestone");
        benChildDevelopmentHistory.setGrossMotorMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setID(1L);
        benChildDevelopmentHistory.setIsFMMAttained(true);
        benChildDevelopmentHistory.setIsGMMAttained(true);
        benChildDevelopmentHistory.setIsLMAttained(true);
        benChildDevelopmentHistory.setIsSMAttained(true);
        benChildDevelopmentHistory.setLanguageMilestone("en");
        benChildDevelopmentHistory.setLanguageMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setLastModDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        benChildDevelopmentHistory.setParkingPlaceID(1);
        benChildDevelopmentHistory.setProcessed("Processed");
        benChildDevelopmentHistory.setProviderServiceMapID(1);
        benChildDevelopmentHistory.setReservedForChange("Reserved For Change");
        benChildDevelopmentHistory.setSocialMilestone("Social Milestone");
        benChildDevelopmentHistory.setSocialMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setSyncedBy("Synced By");
        benChildDevelopmentHistory.setSyncedDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setVanSerialNo(1L);
        benChildDevelopmentHistory.setVehicalNo("Vehical No");
        benChildDevelopmentHistory.setVisitCode(1L);

        // Act
        BenChildDevelopmentHistory actualDevelopmentHistory = BenChildDevelopmentHistory
                .getDevelopmentHistory(benChildDevelopmentHistory);

        // Assert
        assertEquals("", actualDevelopmentHistory.getDevelopmentProblem());
        assertEquals("", actualDevelopmentHistory.getGrossMotorMilestone());
        assertEquals("", actualDevelopmentHistory.getLanguageMilestone());
        assertEquals("", actualDevelopmentHistory.getSocialMilestone());
        assertEquals("foo,", actualDevelopmentHistory.getFineMotorMilestone());
    }

    @Test
    void testGetDevelopmentHistory4() {
        // Arrange
        ArrayList<String> grossMotorMilestones = new ArrayList<>();
        grossMotorMilestones.add("foo");

        BenChildDevelopmentHistory benChildDevelopmentHistory = new BenChildDevelopmentHistory();
        benChildDevelopmentHistory.setBenVisitID(1L);
        benChildDevelopmentHistory.setBeneficiaryRegID(1L);
        benChildDevelopmentHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        benChildDevelopmentHistory.setCreatedDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setDeleted(true);
        benChildDevelopmentHistory.setDevelopmentProblem("Development Problem");
        benChildDevelopmentHistory.setDevelopmentProblems(new ArrayList<>());
        benChildDevelopmentHistory.setFineMotorMilestone("Fine Motor Milestone");
        benChildDevelopmentHistory.setFineMotorMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setGrossMotorMilestone("Gross Motor Milestone");
        benChildDevelopmentHistory.setGrossMotorMilestones(grossMotorMilestones);
        benChildDevelopmentHistory.setID(1L);
        benChildDevelopmentHistory.setIsFMMAttained(true);
        benChildDevelopmentHistory.setIsGMMAttained(true);
        benChildDevelopmentHistory.setIsLMAttained(true);
        benChildDevelopmentHistory.setIsSMAttained(true);
        benChildDevelopmentHistory.setLanguageMilestone("en");
        benChildDevelopmentHistory.setLanguageMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setLastModDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        benChildDevelopmentHistory.setParkingPlaceID(1);
        benChildDevelopmentHistory.setProcessed("Processed");
        benChildDevelopmentHistory.setProviderServiceMapID(1);
        benChildDevelopmentHistory.setReservedForChange("Reserved For Change");
        benChildDevelopmentHistory.setSocialMilestone("Social Milestone");
        benChildDevelopmentHistory.setSocialMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setSyncedBy("Synced By");
        benChildDevelopmentHistory.setSyncedDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setVanSerialNo(1L);
        benChildDevelopmentHistory.setVehicalNo("Vehical No");
        benChildDevelopmentHistory.setVisitCode(1L);

        // Act
        BenChildDevelopmentHistory actualDevelopmentHistory = BenChildDevelopmentHistory
                .getDevelopmentHistory(benChildDevelopmentHistory);

        // Assert
        assertEquals("", actualDevelopmentHistory.getDevelopmentProblem());
        assertEquals("", actualDevelopmentHistory.getFineMotorMilestone());
        assertEquals("", actualDevelopmentHistory.getLanguageMilestone());
        assertEquals("", actualDevelopmentHistory.getSocialMilestone());
        assertEquals("foo,", actualDevelopmentHistory.getGrossMotorMilestone());
    }

    @Test
    void testGetDevelopmentHistory5() {
        // Arrange
        ArrayList<String> languageMilestones = new ArrayList<>();
        languageMilestones.add("foo");

        BenChildDevelopmentHistory benChildDevelopmentHistory = new BenChildDevelopmentHistory();
        benChildDevelopmentHistory.setBenVisitID(1L);
        benChildDevelopmentHistory.setBeneficiaryRegID(1L);
        benChildDevelopmentHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        benChildDevelopmentHistory.setCreatedDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setDeleted(true);
        benChildDevelopmentHistory.setDevelopmentProblem("Development Problem");
        benChildDevelopmentHistory.setDevelopmentProblems(new ArrayList<>());
        benChildDevelopmentHistory.setFineMotorMilestone("Fine Motor Milestone");
        benChildDevelopmentHistory.setFineMotorMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setGrossMotorMilestone("Gross Motor Milestone");
        benChildDevelopmentHistory.setGrossMotorMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setID(1L);
        benChildDevelopmentHistory.setIsFMMAttained(true);
        benChildDevelopmentHistory.setIsGMMAttained(true);
        benChildDevelopmentHistory.setIsLMAttained(true);
        benChildDevelopmentHistory.setIsSMAttained(true);
        benChildDevelopmentHistory.setLanguageMilestone("en");
        benChildDevelopmentHistory.setLanguageMilestones(languageMilestones);
        benChildDevelopmentHistory.setLastModDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        benChildDevelopmentHistory.setParkingPlaceID(1);
        benChildDevelopmentHistory.setProcessed("Processed");
        benChildDevelopmentHistory.setProviderServiceMapID(1);
        benChildDevelopmentHistory.setReservedForChange("Reserved For Change");
        benChildDevelopmentHistory.setSocialMilestone("Social Milestone");
        benChildDevelopmentHistory.setSocialMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setSyncedBy("Synced By");
        benChildDevelopmentHistory.setSyncedDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setVanSerialNo(1L);
        benChildDevelopmentHistory.setVehicalNo("Vehical No");
        benChildDevelopmentHistory.setVisitCode(1L);

        // Act
        BenChildDevelopmentHistory actualDevelopmentHistory = BenChildDevelopmentHistory
                .getDevelopmentHistory(benChildDevelopmentHistory);

        // Assert
        assertEquals("", actualDevelopmentHistory.getDevelopmentProblem());
        assertEquals("", actualDevelopmentHistory.getFineMotorMilestone());
        assertEquals("", actualDevelopmentHistory.getGrossMotorMilestone());
        assertEquals("", actualDevelopmentHistory.getSocialMilestone());
        assertEquals("foo,", actualDevelopmentHistory.getLanguageMilestone());
    }

    @Test
    void testGetDevelopmentHistory6() {
        // Arrange
        ArrayList<String> socialMilestones = new ArrayList<>();
        socialMilestones.add("foo");

        BenChildDevelopmentHistory benChildDevelopmentHistory = new BenChildDevelopmentHistory();
        benChildDevelopmentHistory.setBenVisitID(1L);
        benChildDevelopmentHistory.setBeneficiaryRegID(1L);
        benChildDevelopmentHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        benChildDevelopmentHistory.setCreatedDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setDeleted(true);
        benChildDevelopmentHistory.setDevelopmentProblem("Development Problem");
        benChildDevelopmentHistory.setDevelopmentProblems(new ArrayList<>());
        benChildDevelopmentHistory.setFineMotorMilestone("Fine Motor Milestone");
        benChildDevelopmentHistory.setFineMotorMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setGrossMotorMilestone("Gross Motor Milestone");
        benChildDevelopmentHistory.setGrossMotorMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setID(1L);
        benChildDevelopmentHistory.setIsFMMAttained(true);
        benChildDevelopmentHistory.setIsGMMAttained(true);
        benChildDevelopmentHistory.setIsLMAttained(true);
        benChildDevelopmentHistory.setIsSMAttained(true);
        benChildDevelopmentHistory.setLanguageMilestone("en");
        benChildDevelopmentHistory.setLanguageMilestones(new ArrayList<>());
        benChildDevelopmentHistory.setLastModDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        benChildDevelopmentHistory.setParkingPlaceID(1);
        benChildDevelopmentHistory.setProcessed("Processed");
        benChildDevelopmentHistory.setProviderServiceMapID(1);
        benChildDevelopmentHistory.setReservedForChange("Reserved For Change");
        benChildDevelopmentHistory.setSocialMilestone("Social Milestone");
        benChildDevelopmentHistory.setSocialMilestones(socialMilestones);
        benChildDevelopmentHistory.setSyncedBy("Synced By");
        benChildDevelopmentHistory.setSyncedDate(mock(Timestamp.class));
        benChildDevelopmentHistory.setVanSerialNo(1L);
        benChildDevelopmentHistory.setVehicalNo("Vehical No");
        benChildDevelopmentHistory.setVisitCode(1L);

        // Act
        BenChildDevelopmentHistory actualDevelopmentHistory = BenChildDevelopmentHistory
                .getDevelopmentHistory(benChildDevelopmentHistory);

        // Assert
        assertEquals("", actualDevelopmentHistory.getDevelopmentProblem());
        assertEquals("", actualDevelopmentHistory.getFineMotorMilestone());
        assertEquals("", actualDevelopmentHistory.getGrossMotorMilestone());
        assertEquals("", actualDevelopmentHistory.getLanguageMilestone());
        assertEquals("foo,", actualDevelopmentHistory.getSocialMilestone());
    }

    @Test
    void testGetBenChildDevelopmentDetails() {
        // Arrange, Act and Assert
        assertNull(BenChildDevelopmentHistory.getBenChildDevelopmentDetails(new ArrayList<>()));
    }

    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        BenChildDevelopmentHistory actualBenChildDevelopmentHistory = new BenChildDevelopmentHistory();
        actualBenChildDevelopmentHistory.setBenVisitID(1L);
        actualBenChildDevelopmentHistory.setBeneficiaryRegID(1L);
        actualBenChildDevelopmentHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenChildDevelopmentHistory.setCreatedDate(createdDate);
        actualBenChildDevelopmentHistory.setDeleted(true);
        actualBenChildDevelopmentHistory.setDevelopmentProblem("Development Problem");
        ArrayList<String> developmentProblems = new ArrayList<>();
        actualBenChildDevelopmentHistory.setDevelopmentProblems(developmentProblems);
        actualBenChildDevelopmentHistory.setFineMotorMilestone("Fine Motor Milestone");
        ArrayList<String> fineMotorMilestones = new ArrayList<>();
        actualBenChildDevelopmentHistory.setFineMotorMilestones(fineMotorMilestones);
        actualBenChildDevelopmentHistory.setGrossMotorMilestone("Gross Motor Milestone");
        ArrayList<String> grossMotorMilestones = new ArrayList<>();
        actualBenChildDevelopmentHistory.setGrossMotorMilestones(grossMotorMilestones);
        actualBenChildDevelopmentHistory.setID(1L);
        actualBenChildDevelopmentHistory.setIsFMMAttained(true);
        actualBenChildDevelopmentHistory.setIsGMMAttained(true);
        actualBenChildDevelopmentHistory.setIsLMAttained(true);
        actualBenChildDevelopmentHistory.setIsSMAttained(true);
        actualBenChildDevelopmentHistory.setLanguageMilestone("en");
        ArrayList<String> languageMilestones = new ArrayList<>();
        actualBenChildDevelopmentHistory.setLanguageMilestones(languageMilestones);
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenChildDevelopmentHistory.setLastModDate(lastModDate);
        actualBenChildDevelopmentHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenChildDevelopmentHistory.setParkingPlaceID(1);
        actualBenChildDevelopmentHistory.setProcessed("Processed");
        actualBenChildDevelopmentHistory.setProviderServiceMapID(1);
        actualBenChildDevelopmentHistory.setReservedForChange("Reserved For Change");
        actualBenChildDevelopmentHistory.setSocialMilestone("Social Milestone");
        ArrayList<String> socialMilestones = new ArrayList<>();
        actualBenChildDevelopmentHistory.setSocialMilestones(socialMilestones);
        actualBenChildDevelopmentHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenChildDevelopmentHistory.setSyncedDate(syncedDate);
        actualBenChildDevelopmentHistory.setVanSerialNo(1L);
        actualBenChildDevelopmentHistory.setVehicalNo("Vehical No");
        actualBenChildDevelopmentHistory.setVisitCode(1L);
        Long actualBenVisitID = actualBenChildDevelopmentHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenChildDevelopmentHistory.getBeneficiaryRegID();
        String actualCreatedBy = actualBenChildDevelopmentHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenChildDevelopmentHistory.getCreatedDate();
        Boolean actualDeleted = actualBenChildDevelopmentHistory.getDeleted();
        String actualDevelopmentProblem = actualBenChildDevelopmentHistory.getDevelopmentProblem();
        List<String> actualDevelopmentProblems = actualBenChildDevelopmentHistory.getDevelopmentProblems();
        String actualFineMotorMilestone = actualBenChildDevelopmentHistory.getFineMotorMilestone();
        List<String> actualFineMotorMilestones = actualBenChildDevelopmentHistory.getFineMotorMilestones();
        String actualGrossMotorMilestone = actualBenChildDevelopmentHistory.getGrossMotorMilestone();
        List<String> actualGrossMotorMilestones = actualBenChildDevelopmentHistory.getGrossMotorMilestones();
        Long actualID = actualBenChildDevelopmentHistory.getID();
        Boolean actualIsFMMAttained = actualBenChildDevelopmentHistory.getIsFMMAttained();
        Boolean actualIsGMMAttained = actualBenChildDevelopmentHistory.getIsGMMAttained();
        Boolean actualIsLMAttained = actualBenChildDevelopmentHistory.getIsLMAttained();
        Boolean actualIsSMAttained = actualBenChildDevelopmentHistory.getIsSMAttained();
        String actualLanguageMilestone = actualBenChildDevelopmentHistory.getLanguageMilestone();
        List<String> actualLanguageMilestones = actualBenChildDevelopmentHistory.getLanguageMilestones();
        Timestamp actualLastModDate = actualBenChildDevelopmentHistory.getLastModDate();
        String actualModifiedBy = actualBenChildDevelopmentHistory.getModifiedBy();
        Integer actualParkingPlaceID = actualBenChildDevelopmentHistory.getParkingPlaceID();
        String actualProcessed = actualBenChildDevelopmentHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenChildDevelopmentHistory.getProviderServiceMapID();
        String actualReservedForChange = actualBenChildDevelopmentHistory.getReservedForChange();
        String actualSocialMilestone = actualBenChildDevelopmentHistory.getSocialMilestone();
        List<String> actualSocialMilestones = actualBenChildDevelopmentHistory.getSocialMilestones();
        String actualSyncedBy = actualBenChildDevelopmentHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenChildDevelopmentHistory.getSyncedDate();
        Long actualVanSerialNo = actualBenChildDevelopmentHistory.getVanSerialNo();
        String actualVehicalNo = actualBenChildDevelopmentHistory.getVehicalNo();
        Long actualVisitCode = actualBenChildDevelopmentHistory.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Development Problem", actualDevelopmentProblem);
        assertEquals("Fine Motor Milestone", actualFineMotorMilestone);
        assertEquals("Gross Motor Milestone", actualGrossMotorMilestone);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Social Milestone", actualSocialMilestone);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals("en", actualLanguageMilestone);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualDeleted);
        assertTrue(actualIsFMMAttained);
        assertTrue(actualIsGMMAttained);
        assertTrue(actualIsLMAttained);
        assertTrue(actualIsSMAttained);
        assertSame(developmentProblems, actualDevelopmentProblems);
        assertSame(fineMotorMilestones, actualFineMotorMilestones);
        assertSame(grossMotorMilestones, actualGrossMotorMilestones);
        assertSame(languageMilestones, actualLanguageMilestones);
        assertSame(socialMilestones, actualSocialMilestones);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        BenChildDevelopmentHistory actualBenChildDevelopmentHistory = new BenChildDevelopmentHistory(1L, 1L, 1,
                "Gross Motor Milestone", true, "Fine Motor Milestone", true, "Social Milestone", true, "en", true,
                "Development Problem", 1L);
        actualBenChildDevelopmentHistory.setBenVisitID(1L);
        actualBenChildDevelopmentHistory.setBeneficiaryRegID(1L);
        actualBenChildDevelopmentHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenChildDevelopmentHistory.setCreatedDate(createdDate);
        actualBenChildDevelopmentHistory.setDeleted(true);
        actualBenChildDevelopmentHistory.setDevelopmentProblem("Development Problem");
        ArrayList<String> developmentProblems = new ArrayList<>();
        actualBenChildDevelopmentHistory.setDevelopmentProblems(developmentProblems);
        actualBenChildDevelopmentHistory.setFineMotorMilestone("Fine Motor Milestone");
        ArrayList<String> fineMotorMilestones = new ArrayList<>();
        actualBenChildDevelopmentHistory.setFineMotorMilestones(fineMotorMilestones);
        actualBenChildDevelopmentHistory.setGrossMotorMilestone("Gross Motor Milestone");
        ArrayList<String> grossMotorMilestones = new ArrayList<>();
        actualBenChildDevelopmentHistory.setGrossMotorMilestones(grossMotorMilestones);
        actualBenChildDevelopmentHistory.setID(1L);
        actualBenChildDevelopmentHistory.setIsFMMAttained(true);
        actualBenChildDevelopmentHistory.setIsGMMAttained(true);
        actualBenChildDevelopmentHistory.setIsLMAttained(true);
        actualBenChildDevelopmentHistory.setIsSMAttained(true);
        actualBenChildDevelopmentHistory.setLanguageMilestone("en");
        ArrayList<String> languageMilestones = new ArrayList<>();
        actualBenChildDevelopmentHistory.setLanguageMilestones(languageMilestones);
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenChildDevelopmentHistory.setLastModDate(lastModDate);
        actualBenChildDevelopmentHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenChildDevelopmentHistory.setParkingPlaceID(1);
        actualBenChildDevelopmentHistory.setProcessed("Processed");
        actualBenChildDevelopmentHistory.setProviderServiceMapID(1);
        actualBenChildDevelopmentHistory.setReservedForChange("Reserved For Change");
        actualBenChildDevelopmentHistory.setSocialMilestone("Social Milestone");
        ArrayList<String> socialMilestones = new ArrayList<>();
        actualBenChildDevelopmentHistory.setSocialMilestones(socialMilestones);
        actualBenChildDevelopmentHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenChildDevelopmentHistory.setSyncedDate(syncedDate);
        actualBenChildDevelopmentHistory.setVanSerialNo(1L);
        actualBenChildDevelopmentHistory.setVehicalNo("Vehical No");
        actualBenChildDevelopmentHistory.setVisitCode(1L);
        Long actualBenVisitID = actualBenChildDevelopmentHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenChildDevelopmentHistory.getBeneficiaryRegID();
        String actualCreatedBy = actualBenChildDevelopmentHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenChildDevelopmentHistory.getCreatedDate();
        Boolean actualDeleted = actualBenChildDevelopmentHistory.getDeleted();
        String actualDevelopmentProblem = actualBenChildDevelopmentHistory.getDevelopmentProblem();
        List<String> actualDevelopmentProblems = actualBenChildDevelopmentHistory.getDevelopmentProblems();
        String actualFineMotorMilestone = actualBenChildDevelopmentHistory.getFineMotorMilestone();
        List<String> actualFineMotorMilestones = actualBenChildDevelopmentHistory.getFineMotorMilestones();
        String actualGrossMotorMilestone = actualBenChildDevelopmentHistory.getGrossMotorMilestone();
        List<String> actualGrossMotorMilestones = actualBenChildDevelopmentHistory.getGrossMotorMilestones();
        Long actualID = actualBenChildDevelopmentHistory.getID();
        Boolean actualIsFMMAttained = actualBenChildDevelopmentHistory.getIsFMMAttained();
        Boolean actualIsGMMAttained = actualBenChildDevelopmentHistory.getIsGMMAttained();
        Boolean actualIsLMAttained = actualBenChildDevelopmentHistory.getIsLMAttained();
        Boolean actualIsSMAttained = actualBenChildDevelopmentHistory.getIsSMAttained();
        String actualLanguageMilestone = actualBenChildDevelopmentHistory.getLanguageMilestone();
        List<String> actualLanguageMilestones = actualBenChildDevelopmentHistory.getLanguageMilestones();
        Timestamp actualLastModDate = actualBenChildDevelopmentHistory.getLastModDate();
        String actualModifiedBy = actualBenChildDevelopmentHistory.getModifiedBy();
        Integer actualParkingPlaceID = actualBenChildDevelopmentHistory.getParkingPlaceID();
        String actualProcessed = actualBenChildDevelopmentHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenChildDevelopmentHistory.getProviderServiceMapID();
        String actualReservedForChange = actualBenChildDevelopmentHistory.getReservedForChange();
        String actualSocialMilestone = actualBenChildDevelopmentHistory.getSocialMilestone();
        List<String> actualSocialMilestones = actualBenChildDevelopmentHistory.getSocialMilestones();
        String actualSyncedBy = actualBenChildDevelopmentHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenChildDevelopmentHistory.getSyncedDate();
        Long actualVanSerialNo = actualBenChildDevelopmentHistory.getVanSerialNo();
        String actualVehicalNo = actualBenChildDevelopmentHistory.getVehicalNo();
        Long actualVisitCode = actualBenChildDevelopmentHistory.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Development Problem", actualDevelopmentProblem);
        assertEquals("Fine Motor Milestone", actualFineMotorMilestone);
        assertEquals("Gross Motor Milestone", actualGrossMotorMilestone);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Social Milestone", actualSocialMilestone);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals("en", actualLanguageMilestone);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualDeleted);
        assertTrue(actualIsFMMAttained);
        assertTrue(actualIsGMMAttained);
        assertTrue(actualIsLMAttained);
        assertTrue(actualIsSMAttained);
        assertSame(developmentProblems, actualDevelopmentProblems);
        assertSame(fineMotorMilestones, actualFineMotorMilestones);
        assertSame(grossMotorMilestones, actualGrossMotorMilestones);
        assertSame(languageMilestones, actualLanguageMilestones);
        assertSame(socialMilestones, actualSocialMilestones);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters3() {
        // Arrange and Act
        BenChildDevelopmentHistory actualBenChildDevelopmentHistory = new BenChildDevelopmentHistory(mock(Date.class),
                "Gross Motor Milestone", true, "Fine Motor Milestone", true, "Social Milestone", true, "en", true,
                "Development Problem");
        actualBenChildDevelopmentHistory.setBenVisitID(1L);
        actualBenChildDevelopmentHistory.setBeneficiaryRegID(1L);
        actualBenChildDevelopmentHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenChildDevelopmentHistory.setCreatedDate(createdDate);
        actualBenChildDevelopmentHistory.setDeleted(true);
        actualBenChildDevelopmentHistory.setDevelopmentProblem("Development Problem");
        ArrayList<String> developmentProblems = new ArrayList<>();
        actualBenChildDevelopmentHistory.setDevelopmentProblems(developmentProblems);
        actualBenChildDevelopmentHistory.setFineMotorMilestone("Fine Motor Milestone");
        ArrayList<String> fineMotorMilestones = new ArrayList<>();
        actualBenChildDevelopmentHistory.setFineMotorMilestones(fineMotorMilestones);
        actualBenChildDevelopmentHistory.setGrossMotorMilestone("Gross Motor Milestone");
        ArrayList<String> grossMotorMilestones = new ArrayList<>();
        actualBenChildDevelopmentHistory.setGrossMotorMilestones(grossMotorMilestones);
        actualBenChildDevelopmentHistory.setID(1L);
        actualBenChildDevelopmentHistory.setIsFMMAttained(true);
        actualBenChildDevelopmentHistory.setIsGMMAttained(true);
        actualBenChildDevelopmentHistory.setIsLMAttained(true);
        actualBenChildDevelopmentHistory.setIsSMAttained(true);
        actualBenChildDevelopmentHistory.setLanguageMilestone("en");
        ArrayList<String> languageMilestones = new ArrayList<>();
        actualBenChildDevelopmentHistory.setLanguageMilestones(languageMilestones);
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenChildDevelopmentHistory.setLastModDate(lastModDate);
        actualBenChildDevelopmentHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenChildDevelopmentHistory.setParkingPlaceID(1);
        actualBenChildDevelopmentHistory.setProcessed("Processed");
        actualBenChildDevelopmentHistory.setProviderServiceMapID(1);
        actualBenChildDevelopmentHistory.setReservedForChange("Reserved For Change");
        actualBenChildDevelopmentHistory.setSocialMilestone("Social Milestone");
        ArrayList<String> socialMilestones = new ArrayList<>();
        actualBenChildDevelopmentHistory.setSocialMilestones(socialMilestones);
        actualBenChildDevelopmentHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenChildDevelopmentHistory.setSyncedDate(syncedDate);
        actualBenChildDevelopmentHistory.setVanSerialNo(1L);
        actualBenChildDevelopmentHistory.setVehicalNo("Vehical No");
        actualBenChildDevelopmentHistory.setVisitCode(1L);
        Long actualBenVisitID = actualBenChildDevelopmentHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenChildDevelopmentHistory.getBeneficiaryRegID();
        String actualCreatedBy = actualBenChildDevelopmentHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualBenChildDevelopmentHistory.getCreatedDate();
        Boolean actualDeleted = actualBenChildDevelopmentHistory.getDeleted();
        String actualDevelopmentProblem = actualBenChildDevelopmentHistory.getDevelopmentProblem();
        List<String> actualDevelopmentProblems = actualBenChildDevelopmentHistory.getDevelopmentProblems();
        String actualFineMotorMilestone = actualBenChildDevelopmentHistory.getFineMotorMilestone();
        List<String> actualFineMotorMilestones = actualBenChildDevelopmentHistory.getFineMotorMilestones();
        String actualGrossMotorMilestone = actualBenChildDevelopmentHistory.getGrossMotorMilestone();
        List<String> actualGrossMotorMilestones = actualBenChildDevelopmentHistory.getGrossMotorMilestones();
        Long actualID = actualBenChildDevelopmentHistory.getID();
        Boolean actualIsFMMAttained = actualBenChildDevelopmentHistory.getIsFMMAttained();
        Boolean actualIsGMMAttained = actualBenChildDevelopmentHistory.getIsGMMAttained();
        Boolean actualIsLMAttained = actualBenChildDevelopmentHistory.getIsLMAttained();
        Boolean actualIsSMAttained = actualBenChildDevelopmentHistory.getIsSMAttained();
        String actualLanguageMilestone = actualBenChildDevelopmentHistory.getLanguageMilestone();
        List<String> actualLanguageMilestones = actualBenChildDevelopmentHistory.getLanguageMilestones();
        Timestamp actualLastModDate = actualBenChildDevelopmentHistory.getLastModDate();
        String actualModifiedBy = actualBenChildDevelopmentHistory.getModifiedBy();
        Integer actualParkingPlaceID = actualBenChildDevelopmentHistory.getParkingPlaceID();
        String actualProcessed = actualBenChildDevelopmentHistory.getProcessed();
        Integer actualProviderServiceMapID = actualBenChildDevelopmentHistory.getProviderServiceMapID();
        String actualReservedForChange = actualBenChildDevelopmentHistory.getReservedForChange();
        String actualSocialMilestone = actualBenChildDevelopmentHistory.getSocialMilestone();
        List<String> actualSocialMilestones = actualBenChildDevelopmentHistory.getSocialMilestones();
        String actualSyncedBy = actualBenChildDevelopmentHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualBenChildDevelopmentHistory.getSyncedDate();
        Long actualVanSerialNo = actualBenChildDevelopmentHistory.getVanSerialNo();
        String actualVehicalNo = actualBenChildDevelopmentHistory.getVehicalNo();
        Long actualVisitCode = actualBenChildDevelopmentHistory.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Development Problem", actualDevelopmentProblem);
        assertEquals("Fine Motor Milestone", actualFineMotorMilestone);
        assertEquals("Gross Motor Milestone", actualGrossMotorMilestone);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Social Milestone", actualSocialMilestone);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals("en", actualLanguageMilestone);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualDeleted);
        assertTrue(actualIsFMMAttained);
        assertTrue(actualIsGMMAttained);
        assertTrue(actualIsLMAttained);
        assertTrue(actualIsSMAttained);
        assertSame(developmentProblems, actualDevelopmentProblems);
        assertSame(fineMotorMilestones, actualFineMotorMilestones);
        assertSame(grossMotorMilestones, actualGrossMotorMilestones);
        assertSame(languageMilestones, actualLanguageMilestones);
        assertSame(socialMilestones, actualSocialMilestones);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }
}
