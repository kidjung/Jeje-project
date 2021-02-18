package Jeje_project.Jeje_project.Dog_repository;

import Jeje_project.Jeje_project.Dog_domain.Breed;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/* According to use JPA for Mysql, this class replaced to Breed_JPA_Repository */
/* If you want to know what function do, read this code*/

/*

@Repository
public class Breed_MemoryRepository implements Breed_Repository{

    private static ArrayList<Breed> breeds = new ArrayList<>();


    // 새로윤 견종 추가
    @Override
    public Breed save(Breed breed){
        breeds.add(breed);
        return breed;
    }

    //견종 일치하는 것 반환
    @Override
    public Optional<Breed> findbyName(String name) {
        return breeds.stream().filter(dog->dog.getName().equals(name)).findAny();
    }

    //견종 찾기
    @Override
    public List<Breed> searchbyName(String name) {
        return breeds.stream().filter(dog->dog.getName().contains(name)).collect(Collectors.toList());
    }

    @Override
    public List<Breed> findAll() {
        return breeds;
    }
}


*/
