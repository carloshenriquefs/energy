package br.com.fiap.energy.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "tb_residence")
public class Residence {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RESIDENCE")
    @SequenceGenerator(
            name = "SEQ_RESIDENCE",
            sequenceName = "SEQ_RESIDENCE",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String address;
    private String kind;

    @OneToMany(mappedBy = "residence", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnergyConsumption> energyConsumptions;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Residence() {
    }

    public Residence(String name, String address, String kind, List<EnergyConsumption> energyConsumptions, User user) {
        this.name = name;
        this.address = address;
        this.kind = kind;
        this.energyConsumptions = energyConsumptions;
        this.user = user;
    }

    public Residence(Long id, String name, String address, String kind, List<EnergyConsumption> energyConsumptions, User user) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.kind = kind;
        this.energyConsumptions = energyConsumptions;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Residence setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Residence setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Residence setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getKind() {
        return kind;
    }

    public Residence setKind(String kind) {
        this.kind = kind;
        return this;
    }

    public List<EnergyConsumption> getEnergyConsumptions() {
        return energyConsumptions;
    }

    public Residence setEnergyConsumptions(List<EnergyConsumption> energyConsumptions) {
        this.energyConsumptions = energyConsumptions;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Residence setUser(User user) {
        this.user = user;
        return this;
    }
}
