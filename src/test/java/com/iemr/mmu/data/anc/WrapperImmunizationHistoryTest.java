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
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class WrapperImmunizationHistoryTest {
    @InjectMocks
    private WrapperImmunizationHistory wrapperImmunizationHistory;

    
    @Test
    void testGetBenChildVaccineDetails() {
        // Arrange, Act and Assert
        assertEquals(1, (new WrapperImmunizationHistory()).getBenChildVaccineDetails().size());
        assertEquals(1,
                WrapperImmunizationHistory.getChildVaccineDetail(new ArrayList<>()).getBenChildVaccineDetails().size());
    }

  
    @Test
    void testGetBenChildVaccineDetails2() {
        // Arrange
        ChildVaccineDetail1 childVaccineDetail1 = new ChildVaccineDetail1();
        childVaccineDetail1.setActualReceivingAge("Actual Receiving Age");
        childVaccineDetail1.setBenVisitID(1L);
        childVaccineDetail1.setBeneficiaryRegID(1L);
        childVaccineDetail1.setCaptureDate(mock(Date.class));
        childVaccineDetail1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        childVaccineDetail1.setCreatedDate(mock(Timestamp.class));
        childVaccineDetail1.setDefaultReceivingAge("Default Receiving Age");
        childVaccineDetail1.setDeleted(true);
        childVaccineDetail1.setID(1L);
        childVaccineDetail1.setLastModDate(mock(Timestamp.class));
        childVaccineDetail1.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        childVaccineDetail1.setParkingPlaceID(1);
        childVaccineDetail1.setProcessed("Processed");
        childVaccineDetail1.setProviderServiceMapID(1);
        childVaccineDetail1.setReceivedDate(mock(Timestamp.class));
        childVaccineDetail1.setReceivedFacilityName("Received Facility Name");
        childVaccineDetail1.setReservedForChange("Reserved For Change");
        childVaccineDetail1.setSctCode("Sct Code");
        childVaccineDetail1.setSctTerm("Sct Term");
        childVaccineDetail1.setStatus("Status");
        childVaccineDetail1.setSyncedBy("Synced By");
        childVaccineDetail1.setSyncedDate(mock(Timestamp.class));
        childVaccineDetail1.setVaccineName("Vaccine Name");
        childVaccineDetail1.setVaccineNameList(new ArrayList<>());
        childVaccineDetail1.setVaccines(new ArrayList<>());
        childVaccineDetail1.setVanID(1);
        childVaccineDetail1.setVanSerialNo(1L);
        childVaccineDetail1.setVehicalNo("Vehical No");
        childVaccineDetail1.setVisitCode(1L);

        ArrayList<ChildVaccineDetail1> immunizationList = new ArrayList<>();
        immunizationList.add(childVaccineDetail1);

        WrapperImmunizationHistory wrapperImmunizationHistory2 = new WrapperImmunizationHistory();
        wrapperImmunizationHistory2.setImmunizationList(immunizationList);

        // Act and Assert
        assertTrue(wrapperImmunizationHistory2.getBenChildVaccineDetails().isEmpty());
    }

  
    @Test
    void testGetChildVaccineDetail() {
        // Arrange
        ArrayList<Object[]> childVaccineDetail = new ArrayList<>();

        // Act and Assert
        assertEquals(childVaccineDetail,
                WrapperImmunizationHistory.getChildVaccineDetail(childVaccineDetail).getImmunizationList());
    }

    @Test
    void testGettersAndSetters() {
        // Arrange
        WrapperImmunizationHistory wrapperImmunizationHistory = new WrapperImmunizationHistory();

        // Act
        wrapperImmunizationHistory.setBenVisitID(1L);
        wrapperImmunizationHistory.setBeneficiaryRegID(1L);
        wrapperImmunizationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        ArrayList<ChildVaccineDetail1> immunizationList = new ArrayList<>();
        wrapperImmunizationHistory.setImmunizationList(immunizationList);
        wrapperImmunizationHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        wrapperImmunizationHistory.setParkingPlaceID(1);
        wrapperImmunizationHistory.setProviderServiceMapID(1);
        wrapperImmunizationHistory.setVanID(1);
        wrapperImmunizationHistory.setVisitCode(1L);
        Long actualBenVisitID = wrapperImmunizationHistory.getBenVisitID();
        Long actualBeneficiaryRegID = wrapperImmunizationHistory.getBeneficiaryRegID();
        String actualCreatedBy = wrapperImmunizationHistory.getCreatedBy();
        ArrayList<ChildVaccineDetail1> actualImmunizationList = wrapperImmunizationHistory.getImmunizationList();
        String actualModifiedBy = wrapperImmunizationHistory.getModifiedBy();
        Integer actualParkingPlaceID = wrapperImmunizationHistory.getParkingPlaceID();
        Integer actualProviderServiceMapID = wrapperImmunizationHistory.getProviderServiceMapID();
        Integer actualVanID = wrapperImmunizationHistory.getVanID();
        Long actualVisitCode = wrapperImmunizationHistory.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertSame(immunizationList, actualImmunizationList);
    }
}
