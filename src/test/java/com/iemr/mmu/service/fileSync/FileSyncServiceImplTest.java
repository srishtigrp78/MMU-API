//package com.iemr.mmu.service.fileSync;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//class FileSyncServiceImplTest {
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testGetServerCredential() {
//        // TODO: Diffblue Cover was only able to create a partial test for this method:
//        //   Reason: Sandboxing policy violation.
//        //   Diffblue Cover ran code in your project that tried
//        //     to access files (file './fileSynclogs', permission 'write').
//        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
//        //   your code from damaging your system environment.
//        //   See https://diff.blue/R011 to resolve this issue.
//
//        // Arrange
//        // TODO: Populate arranged inputs
//        FileSyncServiceImpl fileSyncServiceImpl = null;
//
//        // Act
//        String actualServerCredential = fileSyncServiceImpl.getServerCredential();
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//}
package com.iemr.mmu.service.fileSync;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.iemr.mmu.utils.exception.IEMRException;
@ExtendWith(MockitoExtension.class)
class FileSyncServiceImplTest {
	
	@InjectMocks
    private FileSyncServiceImpl fileSyncServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        fileSyncServiceImplUnderTest = new FileSyncServiceImpl();
        ReflectionTestUtils.setField(fileSyncServiceImplUnderTest, "serverIP", "serverIP");
        ReflectionTestUtils.setField(fileSyncServiceImplUnderTest, "serverDomain", "serverDomain");
        ReflectionTestUtils.setField(fileSyncServiceImplUnderTest, "serverUserName", "serverUserName");
        ReflectionTestUtils.setField(fileSyncServiceImplUnderTest, "serverPassword", "serverPassword");
        ReflectionTestUtils.setField(fileSyncServiceImplUnderTest, "getServerCredentialURL", "getServerCredentialURL");
        ReflectionTestUtils.setField(fileSyncServiceImplUnderTest, "localFolderToSync", "localFolderToSync");
        ReflectionTestUtils.setField(fileSyncServiceImplUnderTest, "serverFolder", "serverFolder");
    }

    @Test
    void testGetServerCredential() {
        assertThat(fileSyncServiceImplUnderTest.getServerCredential()).isEqualTo("result");
    }

    @Test
    void testSyncFiles() throws Exception {
        assertThat(fileSyncServiceImplUnderTest.syncFiles("ServerAuthorization"))
                .isEqualTo("File Sync activity Completed");
        assertThatThrownBy(() -> fileSyncServiceImplUnderTest.syncFiles("ServerAuthorization"))
                .isInstanceOf(IEMRException.class);
        assertThatThrownBy(() -> fileSyncServiceImplUnderTest.syncFiles("ServerAuthorization"))
                .isInstanceOf(IOException.class);
    }
}
