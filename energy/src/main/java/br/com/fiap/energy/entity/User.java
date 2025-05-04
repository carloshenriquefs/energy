package br.com.fiap.energy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "tb_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER")
    @SequenceGenerator(
            name = "SEQ_USER",
            sequenceName = "SEQ_USER",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String email;
    private String password;
    private String kind;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "user")
    private List<Residence> residences;

    public User() {
    }

    public User(String name, String email, String password, String kind) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.kind = kind;
    }

    public User(Long id, String name, String email, String password, String kind) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.kind = kind;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getKind() {
        return kind;
    }

    public User setKind(String kind) {
        this.kind = kind;
        return this;
    }
}
