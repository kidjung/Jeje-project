package Jeje_project.Jeje_project.Dog_repository;

import Jeje_project.Jeje_project.Dog_domain.Dog;

import java.util.List;
import java.util.Optional;

public interface Dog_Repository {

    Dog save(Dog dog);
    Optional<Dog> findbyName(String name);
    List<Dog> searchbyName(String name);
    List<Dog> findAll();
}
