package com.practice.ems.service;

import com.practice.ems.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Integer employeeId);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Integer employeeId);

    String deleteEmployee(Integer employeeId);
}
