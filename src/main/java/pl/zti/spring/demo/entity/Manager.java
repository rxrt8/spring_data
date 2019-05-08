package pl.zti.spring.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "manager", schema = "zti")
public class Manager {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "manager")
    List<Employee> employees;

    private Manager() {
    };

    public Manager(String name) {
        this.name = name;
    }
}
