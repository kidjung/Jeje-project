package Jeje_project.Jeje_project.service;

import Jeje_project.Jeje_project.Dog_domain.Breed;
import Jeje_project.Jeje_project.Dog_repository.Dog_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Dog_Service {

    private Dog_Repository dog_repository;

    @Autowired
    public Dog_Service(Dog_Repository dog_repository){
        this.dog_repository=dog_repository;
    }

    // 새로운 종 추가
    public Breed add_Dog_species(Breed breed){
        dog_repository.save(breed);
        return breed;
    }

    //종 검색
    public List<Breed> search_Dogs(String name){
        return dog_repository.searchbyName(name);
    }

    //전체 종 반환
    public List<Breed> all_Dogs(){
        return dog_repository.findAll();
    }

}
