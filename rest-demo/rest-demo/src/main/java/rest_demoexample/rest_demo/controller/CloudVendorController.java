package rest_demoexample.rest_demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest_demoexample.rest_demo.model.CloudVendor;
import rest_demoexample.rest_demo.response.ResponseHandler;
import rest_demoexample.rest_demo.service.CloudVendorService;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;
    public CloudVendorController(CloudVendorService cloudVendorService2) {
        this.cloudVendorService = cloudVendorService2;
    }
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId)
    {
        return ResponseHandler.responseBuilder("Requested vendor details are given here",
            HttpStatus.OK,cloudVendorService.getCloudVendor(vendorId));
        //return cloudVendorService.getCloudVendor(vendorId);
        //return responseHandler("Received", HttpStatus.valueOf(),vendorId);
    }

    @GetMapping
    public List<CloudVendor> getAllCloudVendorDetails()
    {

        return cloudVendorService.getAllCloudVendor();
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor1)
    {
      return cloudVendorService.createCloudVendor(cloudVendor1);

    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor2)
    {
       return cloudVendorService.updateCloudVendor(cloudVendor2);
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId)
    {
       return cloudVendorService.deleteCloudVendor(vendorId);
    }
}
