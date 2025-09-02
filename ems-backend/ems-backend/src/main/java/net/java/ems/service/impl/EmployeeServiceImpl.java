package net.java.ems.service.impl;

import lombok.AllArgsConstructor;
import net.java.ems.dto.EmployeeDto;
import net.java.ems.entity.Employee;
import net.java.ems.exception.ResourceNotFoundException;
import net.java.ems.mapper.EmployeeMapper;
import net.java.ems.repository.EmployeeRepository;
import net.java.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapDtoEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.employeeToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with given id: " + employeeId));
        return EmployeeMapper.employeeToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper::employeeToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with given id: " + employeeId)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmailId(updatedEmployee.getEmail());

        Employee updatedEmployeeEntity = employeeRepository.save(employee);
        return EmployeeMapper.employeeToEmployeeDto(updatedEmployeeEntity);
    }


    public void deleteEmployee(Long EmployeeId) {
       Employee employee = employeeRepository.findById(EmployeeId).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with given id: " + EmployeeId)
    );

       employeeRepository.deleteById(EmployeeId);
    }
}
