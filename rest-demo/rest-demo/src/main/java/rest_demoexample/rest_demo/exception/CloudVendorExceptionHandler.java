package rest_demoexample.rest_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class CloudVendorExceptionHandler {
    @ExceptionHandler(value = {CloudVendorNotFoundException.class})
    public ResponseEntity<Object> handleCloudVendorNotFoundException(CloudVendorNotFoundException cloudVendorNotFoundException)
    {
        System.out.println(Arrays.toString(cloudVendorNotFoundException.getStackTrace()));

        CloudVendorException cloudVendorException = new CloudVendorException(cloudVendorNotFoundException.getMessage(),
                        cloudVendorNotFoundException.getCause(),
                        HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cloudVendorException,HttpStatus.NOT_FOUND);
    }
}
