package Jeje_project.Jeje_project.Dog_repository;

import Jeje_project.Jeje_project.Dog_domain.MyDog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/* This repository operates for Breed of dog (save, find, search ,,)*/
@Repository
public class MyDog_JPA_Repository implements MyDog_Repository{

    private final EntityManager entityManager;

    //Constructor
    public MyDog_JPA_Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //save dogs
    @Override
    public MyDog save(MyDog myDog) {
        entityManager.persist(myDog);
        return myDog;
    }

    //find by Owner_id (returns list)
    @Override
    public List<MyDog> findbyOwner(Long Owner_id) {
        List<MyDog> mydogs= entityManager.createQuery("select mydog from Mydog mydog where mydog.owner_id==:Owner_id")
                .setParameter("Owner_id",Owner_id)
                .getResultList();
        return mydogs;
    }



}
