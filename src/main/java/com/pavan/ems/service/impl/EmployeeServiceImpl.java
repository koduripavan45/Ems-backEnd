package com.pavan.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pavan.ems.Repository.EmployeeRepository;
import com.pavan.ems.dto.EmployeeDto;
import com.pavan.ems.entity.Employee;
import com.pavan.ems.exception.ResourceNotFoundException;
import com.pavan.ems.mapper.EmployeeMapper;
import com.pavan.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		
		
		// TODO Auto-generated method stub
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("employee is not exist" + employeeId));
		return  EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		 List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee) )
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long EmployeeId, EmployeeDto updatedEmployee) {
		Employee employee = employeeRepository.findById(EmployeeId).orElseThrow(
				() -> new ResourceNotFoundException ("Employee not exist : " + EmployeeId));
		
		        employee.setFirstName(updatedEmployee.getFirstName());
		        employee.setLastName(updatedEmployee.getLastName());
		        employee.setEmail(updatedEmployee.getEmail());
		        
		      Employee updatedEmployeeObj = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException ("Employee not exist : " + employeeId));
		
		
		employeeRepository.deleteById(employeeId);
	}

}
