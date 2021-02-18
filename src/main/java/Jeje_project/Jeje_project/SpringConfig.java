package Jeje_project.Jeje_project;

//import Jeje_project.Jeje_project.Dog_repository.Dog_MemoryRepository;
import Jeje_project.Jeje_project.Dog_repository.Breed_JPA_Repository;
import Jeje_project.Jeje_project.Dog_repository.Breed_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import Jeje_project.Jeje_project.service.Dog_Service;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private EntityManager entityManager;


    public SpringConfig(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Bean
    public Dog_Service dog_service(){
        return new Dog_Service(breed_repository());
    }

    //Mysql 서버 db에 저장
    @Bean
    public Breed_Repository breed_repository(){
        return new Breed_JPA_Repository(entityManager);
    }
}
