package Jeje_project.Jeje_project.User_repository;

import Jeje_project.Jeje_project.Dog_domain.Breed;
import Jeje_project.Jeje_project.Dog_domain.MyDog;
import Jeje_project.Jeje_project.User_domain.Dog_Owner;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class Dog_Owner_JPA_Repository implements Dog_Owner_Repository{

    private final EntityManager entityManager;

    //Constructor
    public Dog_Owner_JPA_Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Save dog_owner
    @Override
    public Dog_Owner save_dog_owner(Dog_Owner dog_owner) {
        entityManager.persist(dog_owner);
        return dog_owner;
    }

    //Get all of my dogs
    @Override
    public List<MyDog> mydog_all(Long do_id) {
        Dog_Owner dog_owner=entityManager.find(Dog_Owner.class,do_id);
        List<MyDog> myDogs=dog_owner.getMyDog();

        return myDogs;
    }

    //Search my dogs by name
    @Override
    public List<MyDog> search_mydog(Long do_id,String dog_name) {
        Dog_Owner dog_owner=entityManager.find(Dog_Owner.class,do_id);
        List<MyDog> myDogs=dog_owner.getMyDog();

        List<MyDog> result=new ArrayList<MyDog>();

        for(MyDog d : myDogs){
            if(d.getName().contains(dog_name)){
                result.add(d);
            }
        }
        return result;
    }
}
