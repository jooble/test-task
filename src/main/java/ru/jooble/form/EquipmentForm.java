package ru.jooble.form;

import ru.jooble.domain.Equipment;

public class EquipmentForm {
    private String id;
    private String cupboardId;
    private String type;
    private String model;
    private String inventoryNumber;

    public EquipmentForm() {

    }

    public EquipmentForm(Equipment equipment) {
        this.id = Integer.toString(equipment.getId());
        this.cupboardId = Integer.toString(equipment.getCupboard().getId());
        this.type = equipment.getType().getValue();
        this.model = equipment.getModel();
        this.inventoryNumber = Integer.toString(equipment.getInventoryNumber());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCupboardId() {
        return cupboardId;
    }

    public void setCupboardId(String cupboardId) {
        this.cupboardId = cupboardId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }
}
