package ru.jooble.domain;


import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Cupboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cupboard")
    private List<Equipment> equipments;

    @Transient
    private Map<TypeEquipmentEnum, List<Equipment>> equipmentMap;

    public Cupboard() {

    }

    public Map<TypeEquipmentEnum, List<Equipment>> getEquipmentMap() {
        return equipmentMap;
    }

    public void setEquipmentMap(Map<TypeEquipmentEnum, List<Equipment>> equipmentMap) {
        this.equipmentMap = equipmentMap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}
