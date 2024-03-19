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
class SysGastrointestinalExaminationTest {
   
    @Test
    void testGettersAndSetters() {
        // Arrange
        SysGastrointestinalExamination sysGastrointestinalExamination = new SysGastrointestinalExamination();

        // Act
        sysGastrointestinalExamination.setAnalRegion("us-east-2");
        sysGastrointestinalExamination.setAuscultation("Auscultation");
        sysGastrointestinalExamination.setBenVisitID(1L);
        sysGastrointestinalExamination.setBeneficiaryRegID(1L);
        sysGastrointestinalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        sysGastrointestinalExamination.setCreatedDate(createdDate);
        sysGastrointestinalExamination.setDeleted(true);
        sysGastrointestinalExamination.setID(1L);
        sysGastrointestinalExamination.setInspection("Inspection");
        Timestamp lastModDate = mock(Timestamp.class);
        sysGastrointestinalExamination.setLastModDate(lastModDate);
        sysGastrointestinalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        sysGastrointestinalExamination.setPalpation("Palpation");
        sysGastrointestinalExamination.setPalpation_AbdomenTexture("Palpation Abdomen Texture");
        sysGastrointestinalExamination.setPalpation_Liver("Palpation Liver");
        sysGastrointestinalExamination.setPalpation_LocationOfTenderness("Palpation Location Of Tenderness");
        sysGastrointestinalExamination.setPalpation_Spleen("Palpation Spleen");
        sysGastrointestinalExamination.setPalpation_Tenderness("Palpation Tenderness");
        sysGastrointestinalExamination.setParkingPlaceID(1);
        sysGastrointestinalExamination.setPercussion("Percussion");
        sysGastrointestinalExamination.setProcessed("Processed");
        sysGastrointestinalExamination.setProviderServiceMapID(1);
        sysGastrointestinalExamination.setReservedForChange("Reserved For Change");
        sysGastrointestinalExamination.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        sysGastrointestinalExamination.setSyncedDate(syncedDate);
        sysGastrointestinalExamination.setVanSerialNo(1L);
        sysGastrointestinalExamination.setVehicalNo("Vehical No");
        sysGastrointestinalExamination.setVisitCode(1L);
        String actualAnalRegion = sysGastrointestinalExamination.getAnalRegion();
        String actualAuscultation = sysGastrointestinalExamination.getAuscultation();
        Long actualBenVisitID = sysGastrointestinalExamination.getBenVisitID();
        Long actualBeneficiaryRegID = sysGastrointestinalExamination.getBeneficiaryRegID();
        String actualCreatedBy = sysGastrointestinalExamination.getCreatedBy();
        Timestamp actualCreatedDate = sysGastrointestinalExamination.getCreatedDate();
        Boolean actualDeleted = sysGastrointestinalExamination.getDeleted();
        Long actualID = sysGastrointestinalExamination.getID();
        String actualInspection = sysGastrointestinalExamination.getInspection();
        Timestamp actualLastModDate = sysGastrointestinalExamination.getLastModDate();
        String actualModifiedBy = sysGastrointestinalExamination.getModifiedBy();
        String actualPalpation = sysGastrointestinalExamination.getPalpation();
        String actualPalpation_AbdomenTexture = sysGastrointestinalExamination.getPalpation_AbdomenTexture();
        String actualPalpation_Liver = sysGastrointestinalExamination.getPalpation_Liver();
        String actualPalpation_LocationOfTenderness = sysGastrointestinalExamination.getPalpation_LocationOfTenderness();
        String actualPalpation_Spleen = sysGastrointestinalExamination.getPalpation_Spleen();
        String actualPalpation_Tenderness = sysGastrointestinalExamination.getPalpation_Tenderness();
        Integer actualParkingPlaceID = sysGastrointestinalExamination.getParkingPlaceID();
        String actualPercussion = sysGastrointestinalExamination.getPercussion();
        String actualProcessed = sysGastrointestinalExamination.getProcessed();
        Integer actualProviderServiceMapID = sysGastrointestinalExamination.getProviderServiceMapID();
        String actualReservedForChange = sysGastrointestinalExamination.getReservedForChange();
        String actualSyncedBy = sysGastrointestinalExamination.getSyncedBy();
        Timestamp actualSyncedDate = sysGastrointestinalExamination.getSyncedDate();
        Long actualVanSerialNo = sysGastrointestinalExamination.getVanSerialNo();
        String actualVehicalNo = sysGastrointestinalExamination.getVehicalNo();
        Long actualVisitCode = sysGastrointestinalExamination.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Auscultation", actualAuscultation);
        assertEquals("Inspection", actualInspection);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Palpation Abdomen Texture", actualPalpation_AbdomenTexture);
        assertEquals("Palpation Liver", actualPalpation_Liver);
        assertEquals("Palpation Location Of Tenderness", actualPalpation_LocationOfTenderness);
        assertEquals("Palpation Spleen", actualPalpation_Spleen);
        assertEquals("Palpation Tenderness", actualPalpation_Tenderness);
        assertEquals("Palpation", actualPalpation);
        assertEquals("Percussion", actualPercussion);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals("us-east-2", actualAnalRegion);
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
