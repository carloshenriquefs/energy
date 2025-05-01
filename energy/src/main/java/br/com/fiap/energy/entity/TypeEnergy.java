package br.com.fiap.energy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_type_energy")
public class TypeEnergy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TYPE_ENERGY")
    @SequenceGenerator(
            name = "SEQ_TYPE_ENERGY",
            sequenceName = "SEQ_TYPE_ENERGY",
            allocationSize = 1
    )
    private Long id;
    private String name;

    public TypeEnergy() {
    }

    public TypeEnergy(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public TypeEnergy setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TypeEnergy setName(String name) {
        this.name = name;
        return this;
    }
}
