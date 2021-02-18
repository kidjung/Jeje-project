package Jeje_project.Jeje_project.service;

import Jeje_project.Jeje_project.Dog_domain.Breed;
import Jeje_project.Jeje_project.Dog_repository.Breed_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Dog_Service {

    private Breed_Repository breed_repository;

    @Autowired
    public Dog_Service(Breed_Repository breed_repository){
        this.breed_repository = breed_repository;
    }

    // 새로운 종 추가
    public Breed add_Dog_species(Breed breed){
        breed_repository.save(breed);
        return breed;
    }

    //종 검색
    public List<Breed> search_Dogs(String name){
        return breed_repository.searchbyName(name);
    }

    //전체 종 반환
    public List<Breed> all_Dogs(){
        return breed_repository.findAll();
    }

}
