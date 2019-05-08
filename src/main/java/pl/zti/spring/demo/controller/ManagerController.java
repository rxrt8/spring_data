package pl.zti.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.zti.spring.demo.entity.Manager;
import pl.zti.spring.demo.repository.ManagerRepository;

@RestController
public class ManagerController {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/manager")
    public Iterable<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/manager", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addManager(@RequestBody Manager manager) {
        managerRepository.save(manager);
    }
}
