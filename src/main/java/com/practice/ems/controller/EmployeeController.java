package com.practice.ems.controller;

import com.practice.ems.dto.EmployeeDTO;
import com.practice.ems.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
        name = "Spring Boot Employee Rest API",
        description = "Employee CRUD REST APIs - Get Employee, Get All Employee, Add Employee, Update Employee, Delete Employee"
)
@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(
            summary = "Create Employee REST API",
            description = "Employee Created")
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 Created")
    @PostMapping("create")
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Employee REST API",
            description = "Get Employee by Id")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 Success")
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") Integer employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @Operation(
            summary = "Get All Employee REST API",
            description = "Get All Employees")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 Success")
    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @Operation(
            summary = "Update Employee REST API",
            description = "Update Employee by Id")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 Success")
    @PutMapping("{id}/update")
    public ResponseEntity<EmployeeDTO> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO,
                                                      @PathVariable("id") Integer employeeId) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDTO, employeeId));
    }

    @Operation(
            summary = "Delete Employee REST API",
            description = "Delete Employee by Id")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 Success")
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer employeeId){
        return new ResponseEntity<>(employeeService.deleteEmployee(employeeId), HttpStatus.OK);
    }
}
