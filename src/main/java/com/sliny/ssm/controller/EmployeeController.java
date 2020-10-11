package com.sliny.ssm.controller;

import com.sliny.ssm.entity.Employee;
import com.sliny.ssm.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @date 2020/10/10 21:38
 */

@Controller
//@RestController
public class EmployeeController {
    private static final String FAILED = "failed";
    private static final String SUCCESS = "success";
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public String index(){
        return "index.ftl";
    }

    @ResponseBody
    @GetMapping("/emp/get")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @ResponseBody
    @PostMapping("/emp/insert")
    public String insertEmployee(@RequestBody Employee employee){
        String checked = this.check(employee);
        if (!checked.equals(""))
            return checked;
        if (employeeService.insert(employee) < 0)
            return FAILED;
        return SUCCESS;
    }

    @ResponseBody
    @PostMapping("/emp/update")
    public String updateEmployee(@RequestBody Employee employee){
        Long id = employee.getId();
        if ( id == null || id < 1)
            return "id不能为空";
        String checked = this.check(employee);
        if (!checked.equals(""))
            return checked;
        if (employeeService.update(employee) < 0)
            return FAILED;
        return SUCCESS;
    }

    @ResponseBody
    @PostMapping("/emp/delete/{id}")
    public String deleteEmployee(Long id){
        if ( id == null || id < 1)
            return "id不能为空";
        if (employeeService.delete(id) < 0)
            return FAILED;
        return SUCCESS;
    }

    private String check(Employee employee){
        if (employee == null)
            return "员工信息不能为空";
        String name = employee.getName();
        if (name == null)
            return "姓名不能为空";
        Integer age = employee.getAge();
        if (age < 1)
            return "年龄不能小于1";
        String sex = employee.getSex();
        if (sex == null)
            return "性别不能为空";
        if (!sex.equals("男") && !sex.equals("女"))
            return "请填写正确的性别";
        String phone = employee.getPhone();
        if (phone == null || phone.length() != 11)
            return "请填写正确的电话";
        String password = employee.getPassword();
        if (password == null || password.length() < 3 || password.length() > 6)
            return "请填写正确的密码长度为3-6位";
        return "";
    }
}
