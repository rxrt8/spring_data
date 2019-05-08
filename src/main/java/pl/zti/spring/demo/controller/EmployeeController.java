package pl.zti.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.zti.spring.demo.entity.Employee;
import pl.zti.spring.demo.entity.Manager;
import pl.zti.spring.demo.repository.EmployeeRepository;
import pl.zti.spring.demo.repository.ManagerRepository;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    private final ManagerRepository managerRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, ManagerRepository managerRepository) {
        this.employeeRepository = employeeRepository;
        this.managerRepository = managerRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/employee")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findOneById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/employee", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addEmployee(@RequestBody Employee employee) {
        String manName = employee.getManager().getName();
        employeeRepository.save(employee);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/employee/manager/{name}")
    public List<Employee> getEmployeeByManagerName(@PathVariable String name) {
        return employeeRepository.findByManagerName(name);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/employee/{id_emp}/manager/{id_man}")
    public void setManager(@PathVariable("id_emp") Long employeeId, @PathVariable("id_man") Long managerId) {
        Employee e = employeeRepository.findOneById(employeeId);
        Manager m = managerRepository.findById(managerId).orElse(null);
        e.setManager(m);
        employeeRepository.save(e);
    }
}
