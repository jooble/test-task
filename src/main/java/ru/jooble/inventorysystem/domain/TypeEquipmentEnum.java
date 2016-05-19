package ru.jooble.inventorysystem.domain;

public enum TypeEquipmentEnum {
    DiskArray("DiskArray"),
    Server("Server"),
    UninterruptiblePowerSupply("UninterruptiblePowerSupply");

    private final String value;

    TypeEquipmentEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
