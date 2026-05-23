package com.practice.ems.service.impl;

import com.practice.ems.dto.EmployeeDTO;
import com.practice.ems.entity.Employee;
import com.practice.ems.exception.EmailAlreadyExistsException;
import com.practice.ems.exception.EmployeeNotFoundException;
import com.practice.ems.repository.EmployeeRepository;
import com.practice.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.practice.ems.mapper.EmployeeMapper.MAPPER;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employeeDTO.getEmail());
        if(optionalEmployee.isPresent()){
            throw new EmailAlreadyExistsException("Email Already Exists");
        }
        Employee employee = employeeRepository.save(MAPPER.employeeDTOToEmployee(employeeDTO));
        return MAPPER.employeeToEmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found"));
        return MAPPER.employeeToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(MAPPER::employeeToEmployeeDTO).toList();
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Integer employeeId) {
        Employee updateEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found"));

        updateEmployee.setFirstName(employeeDTO.getFirstName());
        updateEmployee.setLastName(employeeDTO.getLastName());
        updateEmployee.setEmail(employeeDTO.getEmail());
        Employee savedEmployee = employeeRepository.save(updateEmployee);

        return MAPPER.employeeToEmployeeDTO(savedEmployee);
    }

    @Override
    public String deleteEmployee(Integer employeeId) {
        employeeRepository.findById(employeeId).
                orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found"));
        employeeRepository.deleteById(employeeId);
        return "Employee Deleted Successfully";
    }
}
