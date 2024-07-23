package rest_demoexample.rest_demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest_demoexample.rest_demo.model.Employee;

@RestController
@RequestMapping("/employees")

public class EmployeeController {

    @GetMapping("{name}")
    public Employee getEmployeeDetails(@PathVariable("name") String name)
    {
        return new Employee(1,name,12345678,"Abc Street");
    }


}
