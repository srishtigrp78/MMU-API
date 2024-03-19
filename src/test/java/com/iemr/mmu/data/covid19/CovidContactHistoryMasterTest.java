package com.iemr.mmu.data.covid19;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class CovidContactHistoryMasterTest {
   
    @Test
    void testGettersAndSetters() {
        // Arrange
        CovidContactHistoryMaster covidContactHistoryMaster = new CovidContactHistoryMaster();

        // Act
        covidContactHistoryMaster.setContactHistory("Contact History");
        covidContactHistoryMaster.setCovidcontacthistoryID(1);
        covidContactHistoryMaster.setDeleted(true);
        String actualContactHistory = covidContactHistoryMaster.getContactHistory();
        Integer actualCovidcontacthistoryID = covidContactHistoryMaster.getCovidcontacthistoryID();
        Boolean actualDeleted = covidContactHistoryMaster.getDeleted();

        // Assert that nothing has changed
        assertEquals("Contact History", actualContactHistory);
        assertEquals(1, actualCovidcontacthistoryID.intValue());
        assertTrue(actualDeleted);
    }
}
