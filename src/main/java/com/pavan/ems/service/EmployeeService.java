package com.pavan.ems.service;

import java.util.List;

import com.pavan.ems.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long EmployeeId, EmployeeDto updateEmployee);
	
	void deleteEmployee(Long employeeId);
}
