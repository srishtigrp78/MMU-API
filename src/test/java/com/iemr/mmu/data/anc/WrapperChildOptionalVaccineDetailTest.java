package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class WrapperChildOptionalVaccineDetailTest {
    @Autowired
    private WrapperChildOptionalVaccineDetail wrapperChildOptionalVaccineDetail;

   
    @Test
    void testGetChildOptionalVaccineDetails() {
        // Arrange, Act and Assert
        assertTrue((new WrapperChildOptionalVaccineDetail()).getChildOptionalVaccineDetails().isEmpty());
        assertTrue(WrapperChildOptionalVaccineDetail.getChildOptionalVaccineDetail(new ArrayList<>())
                .getChildOptionalVaccineDetails()
                .isEmpty());
    }

    @Test
    void testGetChildOptionalVaccineDetails2() {
        // Arrange
        ChildOptionalVaccineDetail childOptionalVaccineDetail = new ChildOptionalVaccineDetail();
        childOptionalVaccineDetail.setActualReceivingAge("Actual Receiving Age");
        childOptionalVaccineDetail.setBenVisitID(1L);
        childOptionalVaccineDetail.setBeneficiaryRegID(1L);
        childOptionalVaccineDetail.setCaptureDate(mock(Date.class));
        childOptionalVaccineDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        childOptionalVaccineDetail.setCreatedDate(mock(Timestamp.class));
        childOptionalVaccineDetail.setDefaultReceivingAge("Default Receiving Age");
        childOptionalVaccineDetail.setDeleted(true);
        childOptionalVaccineDetail.setID(1L);
        childOptionalVaccineDetail.setLastModDate(mock(Timestamp.class));
        childOptionalVaccineDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        childOptionalVaccineDetail.setParkingPlaceID(1);
        childOptionalVaccineDetail.setProcessed("Processed");
        childOptionalVaccineDetail.setProviderServiceMapID(1);
        childOptionalVaccineDetail.setReceivedDate(mock(Timestamp.class));
        childOptionalVaccineDetail.setReceivedFacilityName("Received Facility Name");
        childOptionalVaccineDetail.setReservedForChange("Reserved For Change");
        childOptionalVaccineDetail.setSctCode("Sct Code");
        childOptionalVaccineDetail.setSctTerm("Sct Term");
        childOptionalVaccineDetail.setStatus("Status");
        childOptionalVaccineDetail.setSyncedBy("Synced By");
        childOptionalVaccineDetail.setSyncedDate(mock(Timestamp.class));
        childOptionalVaccineDetail.setVaccineName("Vaccine Name");
        childOptionalVaccineDetail.setVanID(1);
        childOptionalVaccineDetail.setVanSerialNo(1L);
        childOptionalVaccineDetail.setVehicalNo("Vehical No");
        childOptionalVaccineDetail.setVisitCode(1L);

        ArrayList<ChildOptionalVaccineDetail> childOptionalVaccineList = new ArrayList<>();
        childOptionalVaccineList.add(childOptionalVaccineDetail);

        WrapperChildOptionalVaccineDetail wrapperChildOptionalVaccineDetail2 = new WrapperChildOptionalVaccineDetail();
        wrapperChildOptionalVaccineDetail2.setChildOptionalVaccineList(childOptionalVaccineList);

        // Act and Assert
        assertEquals(1, wrapperChildOptionalVaccineDetail2.getChildOptionalVaccineDetails().size());
    }

    
    @Test
    void testGetChildOptionalVaccineDetails3() {
        // Arrange
        ChildOptionalVaccineDetail childOptionalVaccineDetail = new ChildOptionalVaccineDetail();
        childOptionalVaccineDetail.setActualReceivingAge("Actual Receiving Age");
        childOptionalVaccineDetail.setBenVisitID(1L);
        childOptionalVaccineDetail.setBeneficiaryRegID(1L);
        childOptionalVaccineDetail.setCaptureDate(mock(Date.class));
        childOptionalVaccineDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        childOptionalVaccineDetail.setCreatedDate(mock(Timestamp.class));
        childOptionalVaccineDetail.setDefaultReceivingAge("Default Receiving Age");
        childOptionalVaccineDetail.setDeleted(true);
        childOptionalVaccineDetail.setID(1L);
        childOptionalVaccineDetail.setLastModDate(mock(Timestamp.class));
        childOptionalVaccineDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        childOptionalVaccineDetail.setParkingPlaceID(1);
        childOptionalVaccineDetail.setProcessed("Processed");
        childOptionalVaccineDetail.setProviderServiceMapID(1);
        childOptionalVaccineDetail.setReceivedDate(mock(Timestamp.class));
        childOptionalVaccineDetail.setReceivedFacilityName("Received Facility Name");
        childOptionalVaccineDetail.setReservedForChange("Reserved For Change");
        childOptionalVaccineDetail.setSctCode("Sct Code");
        childOptionalVaccineDetail.setSctTerm("Sct Term");
        childOptionalVaccineDetail.setStatus("Status");
        childOptionalVaccineDetail.setSyncedBy("Synced By");
        childOptionalVaccineDetail.setSyncedDate(mock(Timestamp.class));
        childOptionalVaccineDetail.setVaccineName(null);
        childOptionalVaccineDetail.setVanID(1);
        childOptionalVaccineDetail.setVanSerialNo(1L);
        childOptionalVaccineDetail.setVehicalNo("Vehical No");
        childOptionalVaccineDetail.setVisitCode(1L);

        ArrayList<ChildOptionalVaccineDetail> childOptionalVaccineList = new ArrayList<>();
        childOptionalVaccineList.add(childOptionalVaccineDetail);

        WrapperChildOptionalVaccineDetail wrapperChildOptionalVaccineDetail2 = new WrapperChildOptionalVaccineDetail();
        wrapperChildOptionalVaccineDetail2.setChildOptionalVaccineList(childOptionalVaccineList);

        // Act and Assert
        assertTrue(wrapperChildOptionalVaccineDetail2.getChildOptionalVaccineDetails().isEmpty());
    }

    
    @Test
    void testGetChildOptionalVaccineDetail() {
        // Arrange
        ArrayList<Object[]> childOptionalVaccineDetail = new ArrayList<>();

        // Act and Assert
        assertEquals(childOptionalVaccineDetail,
                WrapperChildOptionalVaccineDetail.getChildOptionalVaccineDetail(childOptionalVaccineDetail)
                        .getChildOptionalVaccineList());
    }

    @Test
    void testGettersAndSetters() {
        // Arrange
        WrapperChildOptionalVaccineDetail wrapperChildOptionalVaccineDetail = new WrapperChildOptionalVaccineDetail();

        // Act
        wrapperChildOptionalVaccineDetail.setBenVisitID(1L);
        wrapperChildOptionalVaccineDetail.setBeneficiaryRegID(1L);
        ArrayList<ChildOptionalVaccineDetail> childOptionalVaccineList = new ArrayList<>();
        wrapperChildOptionalVaccineDetail.setChildOptionalVaccineList(childOptionalVaccineList);
        wrapperChildOptionalVaccineDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        wrapperChildOptionalVaccineDetail.setParkingPlaceID(1);
        wrapperChildOptionalVaccineDetail.setProviderServiceMapID(1);
        wrapperChildOptionalVaccineDetail.setVanID(1);
        wrapperChildOptionalVaccineDetail.setVisitCode(1L);
        Long actualBenVisitID = wrapperChildOptionalVaccineDetail.getBenVisitID();
        Long actualBeneficiaryRegID = wrapperChildOptionalVaccineDetail.getBeneficiaryRegID();
        ArrayList<ChildOptionalVaccineDetail> actualChildOptionalVaccineList = wrapperChildOptionalVaccineDetail
                .getChildOptionalVaccineList();
        String actualCreatedBy = wrapperChildOptionalVaccineDetail.getCreatedBy();
        Integer actualParkingPlaceID = wrapperChildOptionalVaccineDetail.getParkingPlaceID();
        Integer actualProviderServiceMapID = wrapperChildOptionalVaccineDetail.getProviderServiceMapID();
        Integer actualVanID = wrapperChildOptionalVaccineDetail.getVanID();
        Long actualVisitCode = wrapperChildOptionalVaccineDetail.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertSame(childOptionalVaccineList, actualChildOptionalVaccineList);
    }
}
