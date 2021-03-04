package Jeje_project.Jeje_project.User_repository;

import Jeje_project.Jeje_project.Dog_domain.Breed;
import Jeje_project.Jeje_project.User_domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class User_JPA_Repository implements User_Repository{

    private final EntityManager entityManager;

    //Constructor
    public User_JPA_Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Save(Sign up) User info
    @Override
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }


    //Withdrawal User
    //** not implemented
    @Override
    public User delete(User user) {
        return null;
    }

    //Find user by id
    @Override
    public Optional<User> findbyId(Long u_id) {
        User user=entityManager.find(User.class,u_id);
        return Optional.ofNullable(user);
    }

    //Find user by nickname
    @Override
    public List<User> searchbyNickname(String nickname) {
        List<User> users=entityManager.createQuery("SELECT u FROM User u WHERE u.name LIKE '%"+nickname+"%'", User.class)
                .getResultList();
        return users;
    }
}
