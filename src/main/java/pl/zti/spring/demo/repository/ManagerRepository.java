package pl.zti.spring.demo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.zti.spring.demo.entity.Manager;

import javax.persistence.Cacheable;
import javax.transaction.Transactional;

@Transactional
@Cacheable
public interface ManagerRepository extends CrudRepository<Manager, Long> {

}
