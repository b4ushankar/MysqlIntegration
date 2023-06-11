package com.shankar.mysqlIntegration.MysqlIntegration.repo;

import com.shankar.mysqlIntegration.MysqlIntegration.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "select id,name,salary from emp",nativeQuery = true)
    public List<Map<String,String>> getEmployeeValues();


}
