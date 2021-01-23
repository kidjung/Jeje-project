package repository;

import domain.Dog;

import java.util.List;
import java.util.Optional;

public interface Dog_Repository {

    Optional<Dog> findbyName(String name);
    List<Dog> searchbyName(String name);
    List<Dog> findAll();
}
