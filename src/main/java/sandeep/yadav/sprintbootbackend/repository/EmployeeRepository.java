package sandeep.yadav.sprintbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sandeep.yadav.sprintbootbackend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
