package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class WrapperBenInvestigationANCTest {
    
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        WrapperBenInvestigationANC actualWrapperBenInvestigationANC = new WrapperBenInvestigationANC();
        actualWrapperBenInvestigationANC.setBenVisitID(1L);
        actualWrapperBenInvestigationANC.setBeneficiaryRegID(1L);
        actualWrapperBenInvestigationANC.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        actualWrapperBenInvestigationANC.setExternalInvestigations("External Investigations");
        ArrayList<LabTestOrderDetail> laboratoryList = new ArrayList<>();
        actualWrapperBenInvestigationANC.setLaboratoryList(laboratoryList);
        actualWrapperBenInvestigationANC.setParkingPlaceID(1);
        actualWrapperBenInvestigationANC.setPrescriptionID(1L);
        actualWrapperBenInvestigationANC.setProviderServiceMapID(1);
        actualWrapperBenInvestigationANC.setVanID(1);
        actualWrapperBenInvestigationANC.setVisitCode(1L);
        Long actualBenVisitID = actualWrapperBenInvestigationANC.getBenVisitID();
        Long actualBeneficiaryRegID = actualWrapperBenInvestigationANC.getBeneficiaryRegID();
        String actualCreatedBy = actualWrapperBenInvestigationANC.getCreatedBy();
        String actualExternalInvestigations = actualWrapperBenInvestigationANC.getExternalInvestigations();
        ArrayList<LabTestOrderDetail> actualLaboratoryList = actualWrapperBenInvestigationANC.getLaboratoryList();
        Integer actualParkingPlaceID = actualWrapperBenInvestigationANC.getParkingPlaceID();
        Long actualPrescriptionID = actualWrapperBenInvestigationANC.getPrescriptionID();
        Integer actualProviderServiceMapID = actualWrapperBenInvestigationANC.getProviderServiceMapID();
        Integer actualVanID = actualWrapperBenInvestigationANC.getVanID();
        Long actualVisitCode = actualWrapperBenInvestigationANC.getVisitCode();

        // Assert that nothing has changed
        assertEquals("External Investigations", actualExternalInvestigations);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualPrescriptionID.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertSame(laboratoryList, actualLaboratoryList);
    }

  
    @Test
    void testGettersAndSetters2() {
        // Arrange
        ArrayList<LabTestOrderDetail> laboratoryList = new ArrayList<>();

        // Act
        WrapperBenInvestigationANC actualWrapperBenInvestigationANC = new WrapperBenInvestigationANC(1L, 1L, 1, 1L,
                "Jan 1, 2020 8:00am GMT+0100", laboratoryList);
        actualWrapperBenInvestigationANC.setBenVisitID(1L);
        actualWrapperBenInvestigationANC.setBeneficiaryRegID(1L);
        actualWrapperBenInvestigationANC.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        actualWrapperBenInvestigationANC.setExternalInvestigations("External Investigations");
        ArrayList<LabTestOrderDetail> laboratoryList2 = new ArrayList<>();
        actualWrapperBenInvestigationANC.setLaboratoryList(laboratoryList2);
        actualWrapperBenInvestigationANC.setParkingPlaceID(1);
        actualWrapperBenInvestigationANC.setPrescriptionID(1L);
        actualWrapperBenInvestigationANC.setProviderServiceMapID(1);
        actualWrapperBenInvestigationANC.setVanID(1);
        actualWrapperBenInvestigationANC.setVisitCode(1L);
        Long actualBenVisitID = actualWrapperBenInvestigationANC.getBenVisitID();
        Long actualBeneficiaryRegID = actualWrapperBenInvestigationANC.getBeneficiaryRegID();
        String actualCreatedBy = actualWrapperBenInvestigationANC.getCreatedBy();
        String actualExternalInvestigations = actualWrapperBenInvestigationANC.getExternalInvestigations();
        ArrayList<LabTestOrderDetail> actualLaboratoryList = actualWrapperBenInvestigationANC.getLaboratoryList();
        Integer actualParkingPlaceID = actualWrapperBenInvestigationANC.getParkingPlaceID();
        Long actualPrescriptionID = actualWrapperBenInvestigationANC.getPrescriptionID();
        Integer actualProviderServiceMapID = actualWrapperBenInvestigationANC.getProviderServiceMapID();
        Integer actualVanID = actualWrapperBenInvestigationANC.getVanID();
        Long actualVisitCode = actualWrapperBenInvestigationANC.getVisitCode();

        // Assert that nothing has changed
        assertEquals("External Investigations", actualExternalInvestigations);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualPrescriptionID.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals(laboratoryList, actualLaboratoryList);
        assertSame(laboratoryList2, actualLaboratoryList);
    }
}
