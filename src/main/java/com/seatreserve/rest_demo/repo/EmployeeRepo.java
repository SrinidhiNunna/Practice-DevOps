package com.seatreserve.rest_demo.repo;

import com.seatreserve.rest_demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
