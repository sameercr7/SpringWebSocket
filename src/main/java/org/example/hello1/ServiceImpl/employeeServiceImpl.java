package org.example.hello1.ServiceImpl;

import jakarta.transaction.Transactional;
import org.example.hello1.Entity.Employee;
import org.example.hello1.Repository.employeeRepo;
import org.example.hello1.Service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class employeeServiceImpl implements employeeService {
    @Autowired
    private employeeRepo employeeRepoList;

    @Override
    public void saveFormDetail(Employee employee) {
        employeeRepoList.save(employee);

    }

    @Override
    public List<Employee> getEmployeeList() {
        return List.of();
    }




    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepoList.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee updateEmployee(Employee employeeDetails) {

        Employee employee = employeeRepoList.findById(employeeDetails.getId()).get();
        employee.setName(employeeDetails.getName());
        employee.setAge(employeeDetails.getAge());
        employee.setCompanyName(employeeDetails.getCompanyName());

        return employeeRepoList.save(employee);
    }

    @Override
    public String deleteEmployee(Long id) {

        employeeRepoList.deleteById(id);
        return "Employee deleted";
    }

    @Override
    public List<Employee> findAllData() {
        return employeeRepoList.findAll();
    }

    @Override
    public List<Employee> findAllDataOfEmployee(Long id ) {

        List<Employee> employeeList= employeeRepoList.findAllDataById(id);
        return employeeList;
    }

}
