package com.sliny.ssm.service;

import com.sliny.ssm.entity.Employee;

import java.util.List;

/**
 * @date 2020/10/10 21:34
 */
public interface EmployeeService {
    List<Employee> findAll();

    int insert(Employee emp);

    int update(Employee emp);

    int delete(Long id);
}
