package fr.esaip.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Cat extends Animal {
    private String chipId;

    public Cat() {
    }

    public Cat(String chipId) {
        this.chipId = chipId;
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "chipId='" + chipId + '\'' +
                '}';
    }
}
