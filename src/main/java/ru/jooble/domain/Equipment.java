package ru.jooble.domain;


import javax.persistence.*;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cupboard cupboard;

    @Enumerated(EnumType.STRING)
    private TypeEquipmentEnum type;
    private String model;
    private int inventoryNumber;
    private String description;

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

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cupboard getCupboard() {
        return cupboard;
    }

    public void setCupboard(Cupboard cupboard) {
        this.cupboard = cupboard;
    }
}
