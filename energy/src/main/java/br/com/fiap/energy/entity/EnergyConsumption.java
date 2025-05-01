package br.com.fiap.energy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.time.LocalDate;


@Entity
@Table(name = "tb_energy_consumption")
public class EnergyConsumption {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ENERGY_CONSUMPTION")
    @SequenceGenerator(
            name = "SEQ_ENERGY_CONSUMPTION",
            sequenceName = "SEQ_ENERGY_CONSUMPTION",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "residence_id", nullable = false)
    private Residence residence;

    @ManyToOne
    @JoinColumn(name = "type_energy_id", nullable = false)
    private TypeEnergy typeEnergy;

    private LocalDate consumptionDate;
    private Double KwhQuantity;
    private Double cost;

    public EnergyConsumption() {
    }

    public EnergyConsumption(Long id, Residence residence, TypeEnergy typeEnergy, LocalDate consumptionDate, Double KwhQuantity, Double cost) {
        this.id = id;
        this.residence = residence;
        this.typeEnergy = typeEnergy;
        this.consumptionDate = consumptionDate;
        this.KwhQuantity = KwhQuantity;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public EnergyConsumption setId(Long id) {
        this.id = id;
        return this;
    }

    public Residence getResidence() {
        return residence;
    }

    public EnergyConsumption setResidence(Residence residence) {
        this.residence = residence;
        return this;
    }

    public TypeEnergy getTypeEnergy() {
        return typeEnergy;
    }

    public EnergyConsumption setTypeEnergy(TypeEnergy typeEnergy) {
        this.typeEnergy = typeEnergy;
        return this;
    }

    public LocalDate getConsumptionDate() {
        return consumptionDate;
    }

    public EnergyConsumption setConsumptionDate(LocalDate consumptionDate) {
        this.consumptionDate = consumptionDate;
        return this;
    }

    public Double getKwhQuantity() {
        return KwhQuantity;
    }

    public EnergyConsumption setKWhQuantity(Double KWhQuantity) {
        this.KwhQuantity = KWhQuantity;
        return this;
    }

    public Double getCost() {
        return cost;
    }

    public EnergyConsumption setCost(Double cost) {
        this.cost = cost;
        return this;
    }
}
