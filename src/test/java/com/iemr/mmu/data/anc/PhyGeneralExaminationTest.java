package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class PhyGeneralExaminationTest {
   
    @Test
    void testGettersAndSetters() {
        // Arrange
        PhyGeneralExamination phyGeneralExamination = new PhyGeneralExamination();

        // Act
        phyGeneralExamination.setBenVisitID(1L);
        phyGeneralExamination.setBeneficiaryRegID(1L);
        phyGeneralExamination.setBuiltAndAppearance("Built And Appearance");
        phyGeneralExamination.setClubbing("Clubbing");
        phyGeneralExamination.setCoherence("Coherence");
        phyGeneralExamination.setComfortness("Comfortness");
        phyGeneralExamination.setConsciousness("Consciousness");
        phyGeneralExamination.setCooperation("Cooperation");
        phyGeneralExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        phyGeneralExamination.setCreatedDate(createdDate);
        phyGeneralExamination.setCyanosis("Cyanosis");
        phyGeneralExamination.setDangerSigns("Danger Signs");
        phyGeneralExamination.setDeleted(true);
        phyGeneralExamination.setEdema("Edema");
        phyGeneralExamination.setEdemaType("Edema Type");
        phyGeneralExamination.setExtentOfEdema("Extent Of Edema");
        phyGeneralExamination.setFoetalMovements("Foetal Movements");
        phyGeneralExamination.setGait("Gait");
        phyGeneralExamination.setID(1L);
        phyGeneralExamination.setJaundice("Jaundice");
        Timestamp lastModDate = mock(Timestamp.class);
        phyGeneralExamination.setLastModDate(lastModDate);
        phyGeneralExamination.setLymphadenopathy("Lymphadenopathy");
        phyGeneralExamination.setLymphnodesInvolved("Lymphnodes Involved");
        phyGeneralExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        phyGeneralExamination.setPallor("Pallor");
        phyGeneralExamination.setParkingPlaceID(1);
        phyGeneralExamination.setProcessed("Processed");
        phyGeneralExamination.setProviderServiceMapID(1);
        phyGeneralExamination.setQuickening("Quickening");
        phyGeneralExamination.setReservedForChange("Reserved For Change");
        phyGeneralExamination.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        phyGeneralExamination.setSyncedDate(syncedDate);
        phyGeneralExamination.setTypeOfDangerSign("Type Of Danger Sign");
        ArrayList<String> typeOfDangerSigns = new ArrayList<>();
        phyGeneralExamination.setTypeOfDangerSigns(typeOfDangerSigns);
        phyGeneralExamination.setTypeOfLymphadenopathy("Type Of Lymphadenopathy");
        phyGeneralExamination.setVanSerialNo(1L);
        phyGeneralExamination.setVehicalNo("Vehical No");
        phyGeneralExamination.setVisitCode(1L);
        Long actualBenVisitID = phyGeneralExamination.getBenVisitID();
        Long actualBeneficiaryRegID = phyGeneralExamination.getBeneficiaryRegID();
        String actualBuiltAndAppearance = phyGeneralExamination.getBuiltAndAppearance();
        String actualClubbing = phyGeneralExamination.getClubbing();
        String actualCoherence = phyGeneralExamination.getCoherence();
        String actualComfortness = phyGeneralExamination.getComfortness();
        String actualConsciousness = phyGeneralExamination.getConsciousness();
        String actualCooperation = phyGeneralExamination.getCooperation();
        String actualCreatedBy = phyGeneralExamination.getCreatedBy();
        Timestamp actualCreatedDate = phyGeneralExamination.getCreatedDate();
        String actualCyanosis = phyGeneralExamination.getCyanosis();
        String actualDangerSigns = phyGeneralExamination.getDangerSigns();
        Boolean actualDeleted = phyGeneralExamination.getDeleted();
        String actualEdema = phyGeneralExamination.getEdema();
        String actualEdemaType = phyGeneralExamination.getEdemaType();
        String actualExtentOfEdema = phyGeneralExamination.getExtentOfEdema();
        String actualFoetalMovements = phyGeneralExamination.getFoetalMovements();
        String actualGait = phyGeneralExamination.getGait();
        Long actualID = phyGeneralExamination.getID();
        String actualJaundice = phyGeneralExamination.getJaundice();
        Timestamp actualLastModDate = phyGeneralExamination.getLastModDate();
        String actualLymphadenopathy = phyGeneralExamination.getLymphadenopathy();
        String actualLymphnodesInvolved = phyGeneralExamination.getLymphnodesInvolved();
        String actualModifiedBy = phyGeneralExamination.getModifiedBy();
        String actualPallor = phyGeneralExamination.getPallor();
        Integer actualParkingPlaceID = phyGeneralExamination.getParkingPlaceID();
        String actualProcessed = phyGeneralExamination.getProcessed();
        Integer actualProviderServiceMapID = phyGeneralExamination.getProviderServiceMapID();
        String actualQuickening = phyGeneralExamination.getQuickening();
        String actualReservedForChange = phyGeneralExamination.getReservedForChange();
        String actualSyncedBy = phyGeneralExamination.getSyncedBy();
        Timestamp actualSyncedDate = phyGeneralExamination.getSyncedDate();
        String actualTypeOfDangerSign = phyGeneralExamination.getTypeOfDangerSign();
        List<String> actualTypeOfDangerSigns = phyGeneralExamination.getTypeOfDangerSigns();
        String actualTypeOfLymphadenopathy = phyGeneralExamination.getTypeOfLymphadenopathy();
        Long actualVanSerialNo = phyGeneralExamination.getVanSerialNo();
        String actualVehicalNo = phyGeneralExamination.getVehicalNo();
        Long actualVisitCode = phyGeneralExamination.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Built And Appearance", actualBuiltAndAppearance);
        assertEquals("Clubbing", actualClubbing);
        assertEquals("Coherence", actualCoherence);
        assertEquals("Comfortness", actualComfortness);
        assertEquals("Consciousness", actualConsciousness);
        assertEquals("Cooperation", actualCooperation);
        assertEquals("Cyanosis", actualCyanosis);
        assertEquals("Danger Signs", actualDangerSigns);
        assertEquals("Edema Type", actualEdemaType);
        assertEquals("Edema", actualEdema);
        assertEquals("Extent Of Edema", actualExtentOfEdema);
        assertEquals("Foetal Movements", actualFoetalMovements);
        assertEquals("Gait", actualGait);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Jaundice", actualJaundice);
        assertEquals("Lymphadenopathy", actualLymphadenopathy);
        assertEquals("Lymphnodes Involved", actualLymphnodesInvolved);
        assertEquals("Pallor", actualPallor);
        assertEquals("Processed", actualProcessed);
        assertEquals("Quickening", actualQuickening);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Type Of Danger Sign", actualTypeOfDangerSign);
        assertEquals("Type Of Lymphadenopathy", actualTypeOfLymphadenopathy);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualDeleted);
        assertSame(typeOfDangerSigns, actualTypeOfDangerSigns);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }
}
