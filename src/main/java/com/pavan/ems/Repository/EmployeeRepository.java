package com.pavan.ems.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pavan.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
}
