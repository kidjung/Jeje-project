package Jeje_project.Jeje_project;

import Jeje_project.Jeje_project.Dog_repository.Breed_JPA_Repository;
//import Jeje_project.Jeje_project.Dog_repository.Dog_MemoryRepository;
import Jeje_project.Jeje_project.Dog_repository.Dog_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import Jeje_project.Jeje_project.service.Dog_Service;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {


    private final Dog_Repository dog_repository;
    private EntityManager entityManager;

    @Autowired
    public SpringConfig(Dog_Repository dog_repository){
        this.dog_repository=dog_repository;
    }

    @Bean
    public Dog_Service dog_service(){
        return new Dog_Service(dog_repository);
    }

    //Mysql 서버 db에 저장
    @Bean
    public Dog_Repository dog_repository(){
        return new Breed_JPA_Repository(entityManager);
    }
}
