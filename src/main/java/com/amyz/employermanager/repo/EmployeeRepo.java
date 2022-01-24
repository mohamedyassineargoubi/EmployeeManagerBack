package com.amyz.employermanager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amyz.employermanager.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	void deleteEmployeeById(Long id);
	Optional<Employee> findEmployeeById(Long id);

}
