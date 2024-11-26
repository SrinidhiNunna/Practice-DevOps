package com.seatreserve.rest_demo.controller;

import com.seatreserve.rest_demo.model.Employee;
import com.seatreserve.rest_demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@RequestMapping("/EmployeeDetails")

public class EmployeeDetailsController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping(value="/")
    public  String getPage(){
        return "Welcome";
    }
   //Employee employee;
//    @GetMapping("{employeeID}")
//     public Employee getEmployeeDetails(String employeeID){
//    //return new Employee("S1","Srinidhi","7396681487");
//
//    return employee;
//
//     }
    @GetMapping(value = "/allEmployees")
    public List<Employee> getAllEmployeeDetails(){
        return employeeRepo.findAll();
    }


//    @GetMapping(value = "/get/{employeeID}")
//    public void getEmployeeDetails(@PathVariable long employeeID, @RequestBody Employee employee){
//        System.out.println(employeeRepo.findById(employeeID).get());
//    }

//     @PostMapping
//    public String createEmployeeDetails( @RequestBody Employee employee) {
//        this.employee = employee;
//        return "Employee created Successfully";
//     }
    @PostMapping(value = "/save")
    public String createEmployeeDetails(@RequestBody Employee employee){
        employeeRepo.save(employee);
        return "Employee created Successfully";
    }

//    @PutMapping
//    public String updateEmployeeDetails( @RequestBody Employee employee) {
//        this.employee = employee;
//        return "Employee updated Successfully";
//    }

    @PutMapping(value = "/update/{employeeID}")
    public String updateEmployeeDetails(@PathVariable long employeeID, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeRepo.findById(employeeID).get();
        updatedEmployee.setEmployeeName(employee.getEmployeeName());
        updatedEmployee.setEmployeePhoneNumber(employee.getEmployeePhoneNumber());
        employeeRepo.save(updatedEmployee);

        return "Employee updated Successfully";
    }

//    @DeleteMapping("{employeeID}")
//    public String deleteEmployeeDetails(String employeeID) {
//        this.employee = null;
//        return "Employee deleted Successfully";
//    }
    @DeleteMapping(value="delete/{employeeID}")
        public String deleteEmployeeDetails(@PathVariable long employeeID) {
        Employee deleteEmployee = employeeRepo.findById(employeeID).get();
        employeeRepo.delete(deleteEmployee);
        return "Employee deleted Successfully";
}

}
