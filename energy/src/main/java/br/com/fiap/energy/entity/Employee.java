package br.com.fiap.energy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_employee")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employee extends User {


    private String position;

    public Employee() {
    }

    public Employee(Long id, String name, String email, String password, String kind, String position) {
        super(id, name, email, password, kind);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public Employee setPosition(String position) {
        this.position = position;
        return this;
    }
}
