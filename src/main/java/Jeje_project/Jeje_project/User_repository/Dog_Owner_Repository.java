package Jeje_project.Jeje_project.User_repository;

import Jeje_project.Jeje_project.Dog_domain.MyDog;
import Jeje_project.Jeje_project.User_domain.Dog_Owner;

import java.util.List;
import java.util.Optional;

public interface Dog_Owner_Repository {
    Dog_Owner save_dog_owner(Dog_Owner dog_owner);
    Dog_Owner save_dog(MyDog mydog);
    Optional<MyDog> mydog_all();
    List<MyDog> search_mydog(String name);
}
