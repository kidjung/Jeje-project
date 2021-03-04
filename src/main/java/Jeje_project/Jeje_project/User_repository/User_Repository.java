package Jeje_project.Jeje_project.User_repository;

import Jeje_project.Jeje_project.Dog_domain.MyDog;
import Jeje_project.Jeje_project.User_domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public interface User_Repository {

    User save(User user);
    User delete(User user);
    Optional<User> findbyId(Long u_id);
    List<User> searchbyNickname(String nickname);

}
