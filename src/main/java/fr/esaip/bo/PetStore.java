package fr.esaip.bo;

import jakarta.persistence.*;
import org.hibernate.sql.results.graph.instantiation.internal.ArgumentDomainResult;

import java.util.Set;

@Entity
@Table(name = "petstore")
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "manager_name")
    private String managerName;


    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "petStore")
    private Set<Product> products;

    @OneToMany(mappedBy = "petStore")
    private Set<Animal> animals;

    public PetStore() {
    }

    public PetStore(Long id, String name, String managerName, Address address, Set<Product> products, Set<Animal> animals) {
        this.id = id;
        this.name = name;
        this.managerName = managerName;
        this.address = address;
        this.products = products;
        this.animals = animals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", address=" + address +
                ", products=" + products +
                ", animals=" + animals +
                '}';
    }
}
