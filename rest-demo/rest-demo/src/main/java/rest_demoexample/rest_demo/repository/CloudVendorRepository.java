package rest_demoexample.rest_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rest_demoexample.rest_demo.model.CloudVendor;

import java.util.List;

// Here CloudVendor is the model(Entity) we created and String is the data type of our primary Key. In this case we have
//give String ID as primary key in Entity therefore we passed String here
public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

    List<CloudVendor> findByVendorName(String vendorName);
}
