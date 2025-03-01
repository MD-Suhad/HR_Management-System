package com.alibou.security.mapper;

import com.alibou.security.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail()
                );
    };

    public static Employee mapToEmployee(EmployeeDto employeeDta){
        return new Employee(
                employeeDta.getId(),
                employeeDta.getFirstName(),
                employeeDta.getLastName(),
                employeeDta.getEmail()
        );
    }


}
