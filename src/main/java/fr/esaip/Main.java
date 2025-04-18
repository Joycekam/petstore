package fr.esaip;

import fr.esaip.bo.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Adresse
        Address address = new Address();
        address.setNumber("10");
        address.setStreet("Rue Victor Hugo");
        address.setZipCode("69000");
        address.setCity("Lyon");
        em.persist(address);

        // PetStore
        PetStore store = new PetStore();
        store.setName("Zanimoo");
        store.setManagerName("Joyce Kamgang");
        store.setAddress(address);
        em.persist(store);

        // Produits
        Product p1 = new Product();
        p1.setCode("FOOD001");
        p1.setLabel("Pâtée chat");
        p1.setType(ProdType.FOOD);
        p1.setPrice(5.99);
        p1.setPetStore(store);
        Product p2 = new Product();
        p2.setCode("ACC002");
        p2.setLabel("Collier chien");
        p2.setType(ProdType.ACCESSORY);
        p2.setPrice(12.50);
        p2.setPetStore(store);
        em.persist(p1);
        em.persist(p2);

        // Cat
        Cat cat = new Cat();
        cat.setBirth(LocalDate.of(2020, 10, 10));
        cat.setCouleur("Roux");
        cat.setChipId("CHIP2023");
        cat.setPetStore(store);
        em.persist(cat);

        // Fish
        Fish fish = new Fish();
        fish.setBirth(LocalDate.of(2021, 3, 3));
        fish.setCouleur("Jaune");
        fish.setLivingEnv(FishLivEnv.SEA_WATER);
        fish.setPetStore(store);
        em.persist(fish);
        em.getTransaction().commit();

        // Requête 1 : produits de type FOOD
        System.out.println("\n--- Produits de type FOOD ---");
        Set<Product> foodProducts = new HashSet<>(em.createQuery("SELECT p FROM Product p WHERE p.type = :type", Product.class).setParameter("type", ProdType.FOOD).getResultList());
        foodProducts.forEach(p -> System.out.println(p.getLabel()));

        // Requête 2 :
        System.out.println("\n--- Animaux dans la boutique ---");
        Set<Animal> animals = new HashSet<>(em.createQuery("SELECT a FROM Animal a WHERE a.petStore.id = :id", Animal.class)
                .setParameter("id", store.getId())
                .getResultList());
        animals.forEach(a -> System.out.println(a.getClass().getSimpleName() + " - " + a.getCouleur()));

    }
}