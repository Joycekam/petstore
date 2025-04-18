package fr.esaip.bo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "birth")
    private LocalDate birth;
    @Column(name = "couleur")
    private String couleur;

    @ManyToOne
    private PetStore petStore;

    public Animal() {
    }

    public Animal(Long id, LocalDate birth, PetStore petStore, String couleur) {
        this.id = id;
        this.birth = birth;
        this.petStore = petStore;
        this.couleur = couleur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", birth=" + birth +
                ", couleur='" + couleur + '\'' +
                ", petStore=" + petStore +
                '}';
    }
}
