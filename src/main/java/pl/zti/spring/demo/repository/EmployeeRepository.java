package pl.zti.spring.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.zti.spring.demo.entity.Employee;

import javax.persistence.Cacheable;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Cacheable
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Query(value = "select * from zti.employee where id = ?1", nativeQuery = true)
    Employee findOneById(Long id);

    //List<Employee> findAll();
    List<Employee> findByRole(String role);

    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    List<Employee> findByManagerName(String name);

    List<Employee> findByFirstNameAndRole(String firstName, String role);
}
