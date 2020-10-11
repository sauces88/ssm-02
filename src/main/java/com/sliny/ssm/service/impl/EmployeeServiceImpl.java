package com.sliny.ssm.service.impl;

import com.sliny.ssm.entity.Employee;
import com.sliny.ssm.mapper.EmployeeMapper;
import com.sliny.ssm.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @date 2020/10/10 21:35
 */

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeMapper empMapper) {
        this.employeeMapper = empMapper;
    }

    @Override
    public List<Employee> findAll() {
        return employeeMapper.findAll();
    }

    @Override
    public int insert(Employee employee) {
        employee.setId(null);

        int result = employeeMapper.insert(employee);
//        int x  = 1/0; //测试异常处理
        return result;
    }

    @Override
    public int update(Employee employee) {
        return employeeMapper.update(employee);
    }

    @Override
    public int delete(Long id) {
        return employeeMapper.delete(id);
    }
}
