package com.iemr.mmu.service.fileSync;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.iemr.mmu.utils.exception.IEMRException;
import com.iemr.mmu.utils.http.HttpUtils;

//class FileSyncServiceImplTest2 {

//	@Test
//	void testGetServerCredential() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSyncFiles() {
//		fail("Not yet implemented");
//	}

@ExtendWith(MockitoExtension.class)
class FileSyncServiceImplTest2 {
    
    @InjectMocks
    private FileSyncServiceImpl fileSyncServiceImplUnderTest;

    @Mock
    private HttpUtils httpUtilsMock;

    // Assume ServerCredential and other classes are appropriately mocked or instantiated.

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(fileSyncServiceImplUnderTest, "serverIP", "testServerIP");
        ReflectionTestUtils.setField(fileSyncServiceImplUnderTest, "serverDomain", "testServerDomain");
        ReflectionTestUtils.setField(fileSyncServiceImplUnderTest, "serverUserName", "testServerUserName");
        ReflectionTestUtils.setField(fileSyncServiceImplUnderTest, "serverPassword", "testServerPassword");
        ReflectionTestUtils.setField(fileSyncServiceImplUnderTest, "getServerCredentialURL", "testGetServerCredentialURL");
        ReflectionTestUtils.setField(fileSyncServiceImplUnderTest, "localFolderToSync", "testLocalFolderToSync");
        ReflectionTestUtils.setField(fileSyncServiceImplUnderTest, "serverFolder", "testServerFolder");
    }

    @Test
    void testGetServerCredential() {
        String expectedJson = "{\"serverIP\":\"testServerIP\",\"serverDomain\":\"testServerDomain\",\"serverUserName\":\"testServerUserName\",\"serverPassword\":\"testServerPassword\"}";
        String actualJson = fileSyncServiceImplUnderTest.getServerCredential();
        assertThat(actualJson).isEqualTo(expectedJson);
    }

    @Test
    void testSyncFilesSuccess() throws Exception {
        when(httpUtilsMock.get(anyString())).thenReturn("{\"statusCode\":200,\"data\":\"{...}\"}"); // Mock successful response

        String result = fileSyncServiceImplUnderTest.syncFiles("ServerAuthorization");
        assertThat(result).isEqualTo("File Sync activity Completed");
    }

    @Test
    void testSyncFilesFailureIEMRException() throws Exception {
        when(httpUtilsMock.get(anyString())).thenReturn("{\"statusCode\":400,\"errorMessage\":\"User ID Failure\"}"); // Mock failure response

        assertThatThrownBy(() -> fileSyncServiceImplUnderTest.syncFiles("ServerAuthorization"))
                .isInstanceOf(IEMRException.class)
                .hasMessageContaining("User ID Failure");
    }

    @Test
    void testSyncFilesIOException() throws Exception {
        when(httpUtilsMock.get(anyString())).thenThrow(new IOException("Network Error")); // Simulate IOException

        assertThatThrownBy(() -> fileSyncServiceImplUnderTest.syncFiles("ServerAuthorization"))
                .isInstanceOf(IOException.class)
                .hasMessageContaining("Network Error");
    }
}
