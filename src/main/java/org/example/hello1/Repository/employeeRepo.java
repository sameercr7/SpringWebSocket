package org.example.hello1.Repository;

import org.example.hello1.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface employeeRepo extends JpaRepository<Employee, Long> {


    @Query(value = "SELECT * FROM about_company WHERE id=?1", nativeQuery = true)
    List<Employee> findAllDataById(Long id);

}
