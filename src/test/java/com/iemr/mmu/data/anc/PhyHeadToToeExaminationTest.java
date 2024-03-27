package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class PhyHeadToToeExaminationTest {
    @Test
    void testGettersAndSetters() {
        // Arrange
        PhyHeadToToeExamination phyHeadToToeExamination = new PhyHeadToToeExamination();

        // Act
        phyHeadToToeExamination.setBenVisitID(1L);
        phyHeadToToeExamination.setBeneficiaryRegID(1L);
        phyHeadToToeExamination.setBreastAndNipples("Breast And Nipples");
        phyHeadToToeExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        phyHeadToToeExamination.setCreatedDate(createdDate);
        phyHeadToToeExamination.setDeleted(true);
        phyHeadToToeExamination.setEars("Ears");
        phyHeadToToeExamination.setEyes("Eyes");
        phyHeadToToeExamination.setHair("Hair");
        phyHeadToToeExamination.setHead("Head");
        phyHeadToToeExamination.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        phyHeadToToeExamination.setLastModDate(lastModDate);
        phyHeadToToeExamination.setLowerLimbs("Lower Limbs");
        phyHeadToToeExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        phyHeadToToeExamination.setNails("Nails");
        phyHeadToToeExamination.setNose("Nose");
        phyHeadToToeExamination.setOralCavity("Oral Cavity");
        phyHeadToToeExamination.setParkingPlaceID(1);
        phyHeadToToeExamination.setProcessed("Processed");
        phyHeadToToeExamination.setProviderServiceMapID(1);
        phyHeadToToeExamination.setReservedForChange("Reserved For Change");
        phyHeadToToeExamination.setSkin("Skin");
        phyHeadToToeExamination.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        phyHeadToToeExamination.setSyncedDate(syncedDate);
        phyHeadToToeExamination.setThroat("Throat");
        phyHeadToToeExamination.setTrunk("Trunk");
        phyHeadToToeExamination.setUpperLimbs("Upper Limbs");
        phyHeadToToeExamination.setVanSerialNo(1L);
        phyHeadToToeExamination.setVehicalNo("Vehical No");
        phyHeadToToeExamination.setVisitCode(1L);
        phyHeadToToeExamination.setHeadtoToeExam("Headto Toe Exam");
        Long actualBenVisitID = phyHeadToToeExamination.getBenVisitID();
        Long actualBeneficiaryRegID = phyHeadToToeExamination.getBeneficiaryRegID();
        String actualBreastAndNipples = phyHeadToToeExamination.getBreastAndNipples();
        String actualCreatedBy = phyHeadToToeExamination.getCreatedBy();
        Timestamp actualCreatedDate = phyHeadToToeExamination.getCreatedDate();
        Boolean actualDeleted = phyHeadToToeExamination.getDeleted();
        String actualEars = phyHeadToToeExamination.getEars();
        String actualEyes = phyHeadToToeExamination.getEyes();
        String actualHair = phyHeadToToeExamination.getHair();
        String actualHead = phyHeadToToeExamination.getHead();
        String actualHeadtoToeExam = phyHeadToToeExamination.getHeadtoToeExam();
        Long actualID = phyHeadToToeExamination.getID();
        Timestamp actualLastModDate = phyHeadToToeExamination.getLastModDate();
        String actualLowerLimbs = phyHeadToToeExamination.getLowerLimbs();
        String actualModifiedBy = phyHeadToToeExamination.getModifiedBy();
        String actualNails = phyHeadToToeExamination.getNails();
        String actualNose = phyHeadToToeExamination.getNose();
        String actualOralCavity = phyHeadToToeExamination.getOralCavity();
        Integer actualParkingPlaceID = phyHeadToToeExamination.getParkingPlaceID();
        String actualProcessed = phyHeadToToeExamination.getProcessed();
        Integer actualProviderServiceMapID = phyHeadToToeExamination.getProviderServiceMapID();
        String actualReservedForChange = phyHeadToToeExamination.getReservedForChange();
        String actualSkin = phyHeadToToeExamination.getSkin();
        String actualSyncedBy = phyHeadToToeExamination.getSyncedBy();
        Timestamp actualSyncedDate = phyHeadToToeExamination.getSyncedDate();
        String actualThroat = phyHeadToToeExamination.getThroat();
        String actualTrunk = phyHeadToToeExamination.getTrunk();
        String actualUpperLimbs = phyHeadToToeExamination.getUpperLimbs();
        Long actualVanSerialNo = phyHeadToToeExamination.getVanSerialNo();
        String actualVehicalNo = phyHeadToToeExamination.getVehicalNo();
        Long actualVisitCode = phyHeadToToeExamination.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Breast And Nipples", actualBreastAndNipples);
        assertEquals("Ears", actualEars);
        assertEquals("Eyes", actualEyes);
        assertEquals("Hair", actualHair);
        assertEquals("Head", actualHead);
        assertEquals("Headto Toe Exam", actualHeadtoToeExam);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Lower Limbs", actualLowerLimbs);
        assertEquals("Nails", actualNails);
        assertEquals("Nose", actualNose);
        assertEquals("Oral Cavity", actualOralCavity);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Skin", actualSkin);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Throat", actualThroat);
        assertEquals("Trunk", actualTrunk);
        assertEquals("Upper Limbs", actualUpperLimbs);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualDeleted);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }
}
