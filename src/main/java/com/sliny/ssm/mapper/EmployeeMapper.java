package com.sliny.ssm.mapper;

import com.sliny.ssm.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @date 2020/10/10 21:33
 */

@Mapper
public interface EmployeeMapper {

    @Select("select id,name,age,sex,address,phone,password from employee")
    List<Employee> findAll();

    @Insert("insert into employee values(default,#{name}, #{age}, #{sex}, #{address}, #{phone}, #{password})")
    int insert(Employee emp);

    @Update("update employee set name=#{name},age=#{age},sex=#{sex},address=#{address},phone=#{phone},password=#{password} where id=#{id}")
    int update(Employee emp);

    @Delete("delete from employee where id=#{id}")
    int delete(Long id);
}
