package ru.jooble.inventorysystem.domain;


import javax.persistence.*;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cupboard cupboard;

    @Enumerated(EnumType.STRING)
    private TypeEquipmentEnum type;
    private String model;
    private String inventoryNumber;

    public Equipment() {

    }

    public TypeEquipmentEnum getType() {
        return type;
    }

    public void setType(TypeEquipmentEnum type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public Cupboard getCupboard() {
        return cupboard;
    }

    public void setCupboard(Cupboard cupboard) {
        this.cupboard = cupboard;
    }
}
