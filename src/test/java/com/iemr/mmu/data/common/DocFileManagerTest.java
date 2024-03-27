package com.iemr.mmu.data.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class DocFileManagerTest {
   
    @Test
    void testGettersAndSetters() {
        // Arrange
        DocFileManager docFileManager = new DocFileManager();

        // Act
        docFileManager.setFileContent("Not all who wander are lost");
        docFileManager.setFileExtension("File Extension");
        docFileManager.setFileName("foo.txt");
        docFileManager.setVanID(1);
        String actualFileContent = docFileManager.getFileContent();
        String actualFileExtension = docFileManager.getFileExtension();
        String actualFileName = docFileManager.getFileName();

        // Assert that nothing has changed
        assertEquals("File Extension", actualFileExtension);
        assertEquals("Not all who wander are lost", actualFileContent);
        assertEquals("foo.txt", actualFileName);
        assertEquals(1, docFileManager.getVanID().intValue());
    }
}
