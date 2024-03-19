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
class SysMusculoskeletalSystemExaminationTest {
   
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        SysMusculoskeletalSystemExamination actualSysMusculoskeletalSystemExamination = new SysMusculoskeletalSystemExamination();
        actualSysMusculoskeletalSystemExamination.setBenVisitID(1L);
        actualSysMusculoskeletalSystemExamination.setBeneficiaryRegID(1L);
        actualSysMusculoskeletalSystemExamination.setChestWall("Chest Wall");
        actualSysMusculoskeletalSystemExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualSysMusculoskeletalSystemExamination.setCreatedDate(createdDate);
        actualSysMusculoskeletalSystemExamination.setDeleted(true);
        actualSysMusculoskeletalSystemExamination.setID(1L);
        actualSysMusculoskeletalSystemExamination.setJoint_Abnormality("Joint Abnormality");
        actualSysMusculoskeletalSystemExamination.setJoint_Laterality("Joint Laterality");
        actualSysMusculoskeletalSystemExamination.setJoint_TypeOfJoint("Joint Type Of Joint");
        Timestamp lastModDate = mock(Timestamp.class);
        actualSysMusculoskeletalSystemExamination.setLastModDate(lastModDate);
        actualSysMusculoskeletalSystemExamination.setLowerLimb_Abnormality("Lower Limb Abnormality");
        actualSysMusculoskeletalSystemExamination.setLowerLimb_Laterality("Lower Limb Laterality");
        actualSysMusculoskeletalSystemExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualSysMusculoskeletalSystemExamination.setParkingPlaceID(1);
        actualSysMusculoskeletalSystemExamination.setProcessed("Processed");
        actualSysMusculoskeletalSystemExamination.setProviderServiceMapID(1);
        actualSysMusculoskeletalSystemExamination.setReservedForChange("Reserved For Change");
        actualSysMusculoskeletalSystemExamination.setSpine("Spine");
        actualSysMusculoskeletalSystemExamination.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualSysMusculoskeletalSystemExamination.setSyncedDate(syncedDate);
        actualSysMusculoskeletalSystemExamination.setUpperLimb_Abnormality("Upper Limb Abnormality");
        actualSysMusculoskeletalSystemExamination.setUpperLimb_Laterality("Upper Limb Laterality");
        actualSysMusculoskeletalSystemExamination.setVanSerialNo(1L);
        actualSysMusculoskeletalSystemExamination.setVehicalNo("Vehical No");
        actualSysMusculoskeletalSystemExamination.setVisitCode(1L);
        Long actualBenVisitID = actualSysMusculoskeletalSystemExamination.getBenVisitID();
        Long actualBeneficiaryRegID = actualSysMusculoskeletalSystemExamination.getBeneficiaryRegID();
        String actualChestWall = actualSysMusculoskeletalSystemExamination.getChestWall();
        String actualCreatedBy = actualSysMusculoskeletalSystemExamination.getCreatedBy();
        Timestamp actualCreatedDate = actualSysMusculoskeletalSystemExamination.getCreatedDate();
        Boolean actualDeleted = actualSysMusculoskeletalSystemExamination.getDeleted();
        Long actualID = actualSysMusculoskeletalSystemExamination.getID();
        String actualJoint_Abnormality = actualSysMusculoskeletalSystemExamination.getJoint_Abnormality();
        String actualJoint_Laterality = actualSysMusculoskeletalSystemExamination.getJoint_Laterality();
        String actualJoint_TypeOfJoint = actualSysMusculoskeletalSystemExamination.getJoint_TypeOfJoint();
        Timestamp actualLastModDate = actualSysMusculoskeletalSystemExamination.getLastModDate();
        String actualLowerLimb_Abnormality = actualSysMusculoskeletalSystemExamination.getLowerLimb_Abnormality();
        String actualLowerLimb_Laterality = actualSysMusculoskeletalSystemExamination.getLowerLimb_Laterality();
        String actualModifiedBy = actualSysMusculoskeletalSystemExamination.getModifiedBy();
        Integer actualParkingPlaceID = actualSysMusculoskeletalSystemExamination.getParkingPlaceID();
        String actualProcessed = actualSysMusculoskeletalSystemExamination.getProcessed();
        Integer actualProviderServiceMapID = actualSysMusculoskeletalSystemExamination.getProviderServiceMapID();
        String actualReservedForChange = actualSysMusculoskeletalSystemExamination.getReservedForChange();
        String actualSpine = actualSysMusculoskeletalSystemExamination.getSpine();
        String actualSyncedBy = actualSysMusculoskeletalSystemExamination.getSyncedBy();
        Timestamp actualSyncedDate = actualSysMusculoskeletalSystemExamination.getSyncedDate();
        String actualUpperLimb_Abnormality = actualSysMusculoskeletalSystemExamination.getUpperLimb_Abnormality();
        String actualUpperLimb_Laterality = actualSysMusculoskeletalSystemExamination.getUpperLimb_Laterality();
        Long actualVanSerialNo = actualSysMusculoskeletalSystemExamination.getVanSerialNo();
        String actualVehicalNo = actualSysMusculoskeletalSystemExamination.getVehicalNo();
        Long actualVisitCode = actualSysMusculoskeletalSystemExamination.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Chest Wall", actualChestWall);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Joint Abnormality", actualJoint_Abnormality);
        assertEquals("Joint Laterality", actualJoint_Laterality);
        assertEquals("Joint Type Of Joint", actualJoint_TypeOfJoint);
        assertEquals("Lower Limb Abnormality", actualLowerLimb_Abnormality);
        assertEquals("Lower Limb Laterality", actualLowerLimb_Laterality);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Spine", actualSpine);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Upper Limb Abnormality", actualUpperLimb_Abnormality);
        assertEquals("Upper Limb Laterality", actualUpperLimb_Laterality);
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

  
    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        SysMusculoskeletalSystemExamination actualSysMusculoskeletalSystemExamination = new SysMusculoskeletalSystemExamination(
                1L, 1L, 1L, "Joint Type Of Joint", "Joint Laterality", "Joint Abnormality", "Upper Limb Laterality",
                "Upper Limb Abnormality", "Lower Limb Laterality", "Lower Limb Abnormality", "Chest Wall", "Spine", true,
                "Processed", "Jan 1, 2020 8:00am GMT+0100", mock(Timestamp.class), "Jan 1, 2020 9:00am GMT+0100",
                mock(Timestamp.class));
        actualSysMusculoskeletalSystemExamination.setBenVisitID(1L);
        actualSysMusculoskeletalSystemExamination.setBeneficiaryRegID(1L);
        actualSysMusculoskeletalSystemExamination.setChestWall("Chest Wall");
        actualSysMusculoskeletalSystemExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualSysMusculoskeletalSystemExamination.setCreatedDate(createdDate);
        actualSysMusculoskeletalSystemExamination.setDeleted(true);
        actualSysMusculoskeletalSystemExamination.setID(1L);
        actualSysMusculoskeletalSystemExamination.setJoint_Abnormality("Joint Abnormality");
        actualSysMusculoskeletalSystemExamination.setJoint_Laterality("Joint Laterality");
        actualSysMusculoskeletalSystemExamination.setJoint_TypeOfJoint("Joint Type Of Joint");
        Timestamp lastModDate = mock(Timestamp.class);
        actualSysMusculoskeletalSystemExamination.setLastModDate(lastModDate);
        actualSysMusculoskeletalSystemExamination.setLowerLimb_Abnormality("Lower Limb Abnormality");
        actualSysMusculoskeletalSystemExamination.setLowerLimb_Laterality("Lower Limb Laterality");
        actualSysMusculoskeletalSystemExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualSysMusculoskeletalSystemExamination.setParkingPlaceID(1);
        actualSysMusculoskeletalSystemExamination.setProcessed("Processed");
        actualSysMusculoskeletalSystemExamination.setProviderServiceMapID(1);
        actualSysMusculoskeletalSystemExamination.setReservedForChange("Reserved For Change");
        actualSysMusculoskeletalSystemExamination.setSpine("Spine");
        actualSysMusculoskeletalSystemExamination.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualSysMusculoskeletalSystemExamination.setSyncedDate(syncedDate);
        actualSysMusculoskeletalSystemExamination.setUpperLimb_Abnormality("Upper Limb Abnormality");
        actualSysMusculoskeletalSystemExamination.setUpperLimb_Laterality("Upper Limb Laterality");
        actualSysMusculoskeletalSystemExamination.setVanSerialNo(1L);
        actualSysMusculoskeletalSystemExamination.setVehicalNo("Vehical No");
        actualSysMusculoskeletalSystemExamination.setVisitCode(1L);
        Long actualBenVisitID = actualSysMusculoskeletalSystemExamination.getBenVisitID();
        Long actualBeneficiaryRegID = actualSysMusculoskeletalSystemExamination.getBeneficiaryRegID();
        String actualChestWall = actualSysMusculoskeletalSystemExamination.getChestWall();
        String actualCreatedBy = actualSysMusculoskeletalSystemExamination.getCreatedBy();
        Timestamp actualCreatedDate = actualSysMusculoskeletalSystemExamination.getCreatedDate();
        Boolean actualDeleted = actualSysMusculoskeletalSystemExamination.getDeleted();
        Long actualID = actualSysMusculoskeletalSystemExamination.getID();
        String actualJoint_Abnormality = actualSysMusculoskeletalSystemExamination.getJoint_Abnormality();
        String actualJoint_Laterality = actualSysMusculoskeletalSystemExamination.getJoint_Laterality();
        String actualJoint_TypeOfJoint = actualSysMusculoskeletalSystemExamination.getJoint_TypeOfJoint();
        Timestamp actualLastModDate = actualSysMusculoskeletalSystemExamination.getLastModDate();
        String actualLowerLimb_Abnormality = actualSysMusculoskeletalSystemExamination.getLowerLimb_Abnormality();
        String actualLowerLimb_Laterality = actualSysMusculoskeletalSystemExamination.getLowerLimb_Laterality();
        String actualModifiedBy = actualSysMusculoskeletalSystemExamination.getModifiedBy();
        Integer actualParkingPlaceID = actualSysMusculoskeletalSystemExamination.getParkingPlaceID();
        String actualProcessed = actualSysMusculoskeletalSystemExamination.getProcessed();
        Integer actualProviderServiceMapID = actualSysMusculoskeletalSystemExamination.getProviderServiceMapID();
        String actualReservedForChange = actualSysMusculoskeletalSystemExamination.getReservedForChange();
        String actualSpine = actualSysMusculoskeletalSystemExamination.getSpine();
        String actualSyncedBy = actualSysMusculoskeletalSystemExamination.getSyncedBy();
        Timestamp actualSyncedDate = actualSysMusculoskeletalSystemExamination.getSyncedDate();
        String actualUpperLimb_Abnormality = actualSysMusculoskeletalSystemExamination.getUpperLimb_Abnormality();
        String actualUpperLimb_Laterality = actualSysMusculoskeletalSystemExamination.getUpperLimb_Laterality();
        Long actualVanSerialNo = actualSysMusculoskeletalSystemExamination.getVanSerialNo();
        String actualVehicalNo = actualSysMusculoskeletalSystemExamination.getVehicalNo();
        Long actualVisitCode = actualSysMusculoskeletalSystemExamination.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Chest Wall", actualChestWall);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Joint Abnormality", actualJoint_Abnormality);
        assertEquals("Joint Laterality", actualJoint_Laterality);
        assertEquals("Joint Type Of Joint", actualJoint_TypeOfJoint);
        assertEquals("Lower Limb Abnormality", actualLowerLimb_Abnormality);
        assertEquals("Lower Limb Laterality", actualLowerLimb_Laterality);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Spine", actualSpine);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Upper Limb Abnormality", actualUpperLimb_Abnormality);
        assertEquals("Upper Limb Laterality", actualUpperLimb_Laterality);
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
