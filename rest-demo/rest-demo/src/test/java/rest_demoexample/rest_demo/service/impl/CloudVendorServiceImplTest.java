package rest_demoexample.rest_demo.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rest_demoexample.rest_demo.model.CloudVendor;
import rest_demoexample.rest_demo.repository.CloudVendorRepository;
import rest_demoexample.rest_demo.service.CloudVendorService;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@Tag("unitTest")
class CloudVendorServiceImplTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;
    CloudVendor cloudVendor;
    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor = new CloudVendor("1","Alex","USA","One");
    }

    @AfterEach
    void tearDown() throws Exception {
      autoCloseable.close();
    }

    @Test
    void createCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
       String message = cloudVendorService.createCloudVendor(cloudVendor);
        Assertions.assertThat(message).isEqualTo("Success");
        verify(cloudVendorRepository, times(1)).save(cloudVendor);

    }

    @Test
    void updateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        String message = cloudVendorService.updateCloudVendor(cloudVendor);
        Assertions.assertThat(message).isEqualTo("Success");
        verify(cloudVendorRepository,times(1)).save(cloudVendor);
    }

    @Test
    void deleteCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        String message = cloudVendorService.deleteCloudVendor("1");
        Assertions.assertThat(message).isEqualTo("Success");
        verify(cloudVendorRepository,times(1)).deleteById("1");
    }

    @Test
    void getCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.findById("1")).thenReturn(Optional.of(cloudVendor));

        CloudVendor actualCloudVendor = cloudVendorService.getCloudVendor("1");

        Assertions.assertThat(actualCloudVendor).isEqualTo(cloudVendor);
        verify(cloudVendorRepository,times(2)).findById("1");

    }

    @Test
    void getAllCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.findAll()).thenReturn(List.of(cloudVendor));
        List<CloudVendor> cloudVendorList = cloudVendorService.getAllCloudVendor();
        Assertions.assertThat(cloudVendorList.get(0)).isEqualTo(cloudVendor);
        verify(cloudVendorRepository,times(1)).findAll();
    }

    @Test
    void testGetAllCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.findByVendorName("Alex")).thenReturn(List.of(cloudVendor));
        List<CloudVendor> cloudVendorsListByName = cloudVendorService.getAllCloudVendor("Alex");
        Assertions.assertThat(cloudVendorsListByName.get(0)).isEqualTo(cloudVendor);
        verify(cloudVendorRepository,times(1)).findByVendorName("Alex");
    }
}