package com.alibou.security.service;

import com.alibou.security.dbo.EmployeeDto;
import com.alibou.security.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();
}
