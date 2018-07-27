package com.project.model.cinemaproject.equipment;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "equipment")
public class Equipment {

    @Id
    private String id;
    private String name;
    private String equipmentDesc;
    private int price;

    public String getName() {
        return name;
    }

    public String getEquipmentDesc() {
        return equipmentDesc;
    }

    public int getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEquipmentDesc(String equipmentDesc) {
        this.equipmentDesc = equipmentDesc;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
