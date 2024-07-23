package rest_demoexample.rest_demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest_demoexample.rest_demo.exception.CloudVendorNotFoundException;
import rest_demoexample.rest_demo.model.CloudVendor;
import rest_demoexample.rest_demo.repository.CloudVendorRepository;
import rest_demoexample.rest_demo.service.CloudVendorService;

import java.util.List;
@Service
public class CloudVendorServiceImpl implements CloudVendorService {
    CloudVendorRepository cloudVendorRepository;
    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }
    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
          if(cloudVendorRepository.findById(cloudVendorId).isEmpty() )
          {
              throw new CloudVendorNotFoundException("Requested Cloud Vendor Does Not Exist");
          }
         return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {

        return cloudVendorRepository.findAll();
    }

    @Override
    public List<CloudVendor> getAllCloudVendor(String vendorName) {

        return cloudVendorRepository.findByVendorName(vendorName);
    }
}
