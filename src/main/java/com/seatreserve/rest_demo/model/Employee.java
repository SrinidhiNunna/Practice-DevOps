package com.seatreserve.rest_demo.model;


import jakarta.persistence.*;

@Entity
public class Employee  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeID;
    @Column
    private String employeeName;
    @Column
    private String employeePhoneNumber;

    public Employee() {
    }

//    public Employee(long employeeID, String employeeName, String employeePhoneNumber) {
//        this.employeeID = employeeID;
//        this.employeeName = employeeName;
//        this.employeePhoneNumber = employeePhoneNumber;
//    }

    public Employee( String employeeName, String employeePhoneNumber) {
        //this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeePhoneNumber = employeePhoneNumber;
    }


    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }
}
