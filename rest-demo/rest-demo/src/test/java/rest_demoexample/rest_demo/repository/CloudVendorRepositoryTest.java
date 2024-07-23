package rest_demoexample.rest_demo.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import rest_demoexample.rest_demo.model.CloudVendor;

import java.util.List;

@DataJpaTest
public class CloudVendorRepositoryTest {
    //given - when - then
    @Autowired
    CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;

    @BeforeEach
    public void setUp()
    {
        cloudVendor = new CloudVendor("1","Alex","USA","One");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    public void tearDown()
    {
        cloudVendor = null;
        cloudVendorRepository.deleteAll();
    }

    @Test
    void testCheckFindByNameSuccess()
    {
        List<CloudVendor> vendorList = cloudVendorRepository.findByVendorName("Alex");
        CloudVendor actualVendor = vendorList.get(0);
        Assertions.assertThat(actualVendor.getVendorId()).isEqualTo(cloudVendor.getVendorId());
        Assertions.assertThat(actualVendor.getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
        Assertions.assertThat(actualVendor.getVendorPhoneNumber()).isEqualTo(cloudVendor.getVendorPhoneNumber());
    }

    @Test
    void textCheckFindByNameFailure()
    {
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("James");
        Assertions.assertThat(cloudVendorList.size()).isEqualTo(0);
    }

}
