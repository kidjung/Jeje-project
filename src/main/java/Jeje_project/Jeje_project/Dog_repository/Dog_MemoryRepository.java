package Jeje_project.Jeje_project.Dog_repository;

import Jeje_project.Jeje_project.Dog_domain.Dog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class Dog_MemoryRepository implements Dog_Repository{

    private static ArrayList<Dog> dogs= new ArrayList<>();


    // 새로윤 견종 추가
    @Override
    public Dog save(Dog dog){
        dogs.add(dog);
        return dog;
    }

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
