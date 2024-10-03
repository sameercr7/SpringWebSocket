package org.example.hello1.Service;

import org.example.hello1.Entity.Employee;

import java.util.List;

public interface employeeService {
    void saveFormDetail(Employee employee);
    List<Employee> getEmployeeList();
//    Employee getEmployeeById(int id);

    Employee getEmployeeById(Long id);

    Employee updateEmployee( Employee employeeDetails);
    String deleteEmployee(Long id);

    List<Employee> findAllData();

    List<Employee> findAllDataOfEmployee(Long id);
}
