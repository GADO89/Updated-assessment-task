package com.spring.swagger.repository;

import com.spring.swagger.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Transactional
	@Modifying
	@Query("delete from Employee e where e.id like ?1 and fileName like ?2")
	public void deleteEmployeeWithFile(Long id, String fileName);

	//void save(Employee employee);

	//List<Employee> findAll();
}
