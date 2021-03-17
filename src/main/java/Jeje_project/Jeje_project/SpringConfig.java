package Jeje_project.Jeje_project;

//import Jeje_project.Jeje_project.Dog_repository.Dog_MemoryRepository;
import Jeje_project.Jeje_project.Dog_repository.Breed_JPA_Repository;
import Jeje_project.Jeje_project.Dog_repository.Breed_Repository;
import Jeje_project.Jeje_project.Dog_repository.MyDog_JPA_Repository;
import Jeje_project.Jeje_project.Dog_repository.MyDog_Repository;
import Jeje_project.Jeje_project.User_domain.Dog_Owner;
import Jeje_project.Jeje_project.User_domain.Walker;
import Jeje_project.Jeje_project.User_repository.*;
import Jeje_project.Jeje_project.service.User_Service;
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

    @Bean
    public User_Service user_service(){
        return new User_Service(user_repository(),walker_repository(),dog_owner_repository(), myDog_repository());
    }

    //Mysql 서버 db에 저장
    @Bean
    public Breed_Repository breed_repository(){
        return new Breed_JPA_Repository(entityManager);
    }

    @Bean
    public MyDog_Repository myDog_repository() {return new MyDog_JPA_Repository(entityManager);}

    @Bean
    public User_Repository user_repository(){
        return new User_JPA_Repository(entityManager);
    }

    @Bean
    public Walker_Repository walker_repository(){
        return new Walker_JPA_Repository(entityManager);
    }

    @Bean
    public Dog_Owner_Repository dog_owner_repository(){
        return new Dog_Owner_JPA_Repository(entityManager);
    }

}
