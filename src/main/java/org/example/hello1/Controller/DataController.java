package org.example.hello1.Controller;

import org.example.hello1.Entity.Employee;
import org.example.hello1.Service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/data")
public class DataController {

    @Autowired
    private employeeService empService;

    @GetMapping(path = "/getAllData/{id}")
    public List<Employee> getAlldetailById(@PathVariable(value = "id")Long id){
        List<Employee> allDataOfEmployee=empService.findAllDataOfEmployee(id);

        return allDataOfEmployee;
    }

    @GetMapping(path = "/welcome")
    public List<Employee> welcome(){


        return null;
    }

}
