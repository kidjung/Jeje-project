package Jeje_project.Jeje_project;

import Jeje_project.Jeje_project.Dog_repository.Dog_MemoryRepository;
import Jeje_project.Jeje_project.Dog_repository.Dog_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import Jeje_project.Jeje_project.service.Dog_Service;

@Configuration
public class SpringConfig {


    private final Dog_Repository dog_repository;

    @Autowired
    public SpringConfig(Dog_Repository dog_repository){
        this.dog_repository=dog_repository;
    }

    @Bean
    public Dog_Service dog_service(){
        return new Dog_Service(dog_repository);
    }

    //객체 저장하는 위치 바뀜에 따라 (db, memory) 변경 예정
    @Bean
    public Dog_Repository dog_repository(){
        return new Dog_MemoryRepository();
    }
}
