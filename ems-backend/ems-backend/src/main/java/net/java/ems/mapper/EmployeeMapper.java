package net.java.ems.mapper;

import net.java.ems.dto.EmployeeDto;
import net.java.ems.entity.Employee;

public class EmployeeMapper {

    // DTO -> Entity
    public static Employee mapDtoEmployee(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmailId(dto.getEmail());
        return employee;
    }

    // Entity -> DTO
    public static EmployeeDto employeeToEmployeeDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmailId());
        return dto;
    }
}
