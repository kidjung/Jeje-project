package Jeje_project.Jeje_project.Dog_repository;

import Jeje_project.Jeje_project.Dog_domain.Breed;

import java.util.List;
import java.util.Optional;

public interface Breed_Repository {

    Breed save(Breed breed);
    Breed delete(String name);
    Optional<Breed> findbyName(String name);
    List<Breed> searchbyName(String name);
    List<Breed> findAll();
}
