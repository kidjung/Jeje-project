package Jeje_project.Jeje_project.Dog_repository;

import Jeje_project.Jeje_project.Dog_domain.Breed;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/* This repository operates for Breed of dog (save, find, search ,,)*/
@Repository
public class Breed_JPA_Repository implements Breed_Repository {

    private final EntityManager entityManager;

    //Constructor
    public Breed_JPA_Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    //Save breed
    //(This is for admin of pages)
    @Override
    public Breed save(Breed breed) {
        entityManager.persist(breed);
        return breed;
    }

    //find by Name breed of dog
    @Override
    public Optional<Breed> findbyName(String name) {
        Breed breed = entityManager.find(Breed.class, name);
        return Optional.ofNullable(breed);
    }

    //search by Name breed of dog (returns List)
    @Override
    public List<Breed> searchbyName(String name) {
        List<Breed> breeds =entityManager.createQuery("SELECT d FROM Breed d WHERE d.name LIKE '%:name%'", Breed.class)
                .setParameter("name",name)
                .getResultList();
        return breeds;
    }

    //find all of breed (returns List)
    @Override
    public List<Breed> findAll() {
        List<Breed> breeds;
        breeds = entityManager.createQuery("SELECT d FROM Breed d", Breed.class)
                .getResultList();

        return breeds;
    }
}
