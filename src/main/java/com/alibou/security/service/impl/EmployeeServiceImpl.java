package com.alibou.security.service.impl;

import com.alibou.security.dbo.EmployeeDto;
import com.alibou.security.entity.Employee;
import com.alibou.security.exception.ResourceNotFoundException;
import com.alibou.security.mapper.EmployeeMapper;
import com.alibou.security.repository.EmployeeRepository;
import com.alibou.security.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        return null;
    }

//    @Override
//    public EmployeeDto getEmployeeById(Long employeeId) {
//
//    Employee employee =   employeeRepository.findById(employeeId)
//                .orElseThrow(() ->
//                        new ResourceNotFoundException("employee is not exit id:" + employeeId));
//        return EmployeeMapper.mapToEmployeeDto(employee);
//    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<Employee> employees = employeeRepository.findAll();
       return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
               .collect(Collectors.toList());

    }
}
