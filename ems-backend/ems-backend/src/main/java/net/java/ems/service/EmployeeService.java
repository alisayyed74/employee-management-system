package net.java.ems.service;

import net.java.ems.dto.EmployeeDto;
import net.java.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee( Long EmployeeId, EmployeeDto updatedEmployee);

    void deleteEmployee( Long EmployeeId);

}
