package com.iemr.mmu.data.benFlowStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class BenPhoneMapsTest {
    
    @Test
    void testGettersAndSetters() {
        // Arrange
        BenPhoneMaps benPhoneMaps = new BenPhoneMaps();

        // Act
        benPhoneMaps.setPhoneNo("6625550144");

        // Assert that nothing has changed
        assertEquals("6625550144", benPhoneMaps.getPhoneNo());
    }
}
