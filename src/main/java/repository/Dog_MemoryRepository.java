package repository;

import domain.Dog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Dog_MemoryRepository implements Dog_Repository{

    private static ArrayList<Dog> dogs= new ArrayList<>();

    //견종 일치하는 것 반환
    @Override
    public Optional<Dog> findbyName(String name) {
        return dogs.stream().filter(dog->dog.getName().equals(name)).findAny();
    }

    //견종 찾기
    @Override
    public List<Dog> searchbyName(String name) {
        return dogs.stream().filter(dog->dog.getName().contains(name)).collect(Collectors.toList());
    }

    @Override
    public List<Dog> findAll() {
        return dogs;
    }
}
