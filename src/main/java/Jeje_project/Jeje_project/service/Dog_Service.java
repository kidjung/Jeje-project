package Jeje_project.Jeje_project.service;

import Jeje_project.Jeje_project.domain.Dog;
import Jeje_project.Jeje_project.repository.Dog_Repository;
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
    public Dog add_Dog_species(Dog dog){
        dog_repository.save(dog);
        return dog;
    }

    //종 검색
    public List<Dog> search_Dogs(String name){
        return dog_repository.searchbyName(name);
    }

    //전체 종 반환
    public List<Dog> all_Dogs(){
        return dog_repository.findAll();
    }

}
