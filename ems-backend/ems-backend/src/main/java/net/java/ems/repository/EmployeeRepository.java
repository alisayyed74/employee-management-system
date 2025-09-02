package net.java.ems.repository;

import jakarta.transaction.Transactional;
import net.java.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
