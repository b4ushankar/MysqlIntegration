package com.shankar.mysqlIntegration.MysqlIntegration.controller;

import com.shankar.mysqlIntegration.MysqlIntegration.ExceptionHandling.EmployeeIDNotAvailableException;
import com.shankar.mysqlIntegration.MysqlIntegration.entity.Employee;
import com.shankar.mysqlIntegration.MysqlIntegration.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mysqlIntegration")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id){

        if(id==null || id==0){
            throw new EmployeeIDNotAvailableException("Please fill id and request");
        }
        Employee employee = employeeRepository.findById(id).orElse(new Employee());
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);

    }

    @PostMapping("employee")
    public ResponseEntity<Employee> insertEmployee(@RequestBody  Employee employee){

        employeeRepository.save(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

    @GetMapping("/employesList")
        public List<Map<String,String>> getAllEmpoloyees(){
        return employeeRepository.getEmployeeValues();
        }

    }





