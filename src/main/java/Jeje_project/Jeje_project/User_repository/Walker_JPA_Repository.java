package Jeje_project.Jeje_project.User_repository;

import Jeje_project.Jeje_project.User_domain.Walker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@Transactional
public class Walker_JPA_Repository implements Walker_Repository{

    private final EntityManager entityManager;

    //Constructor
    public Walker_JPA_Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Save walker
    @Override
    public Walker save(Walker walker) {
        entityManager.persist(walker);
        return walker;
    }

    //Find walker by id
    @Override
    public Optional<Walker> findbyid(Long w_id) {
        Walker walker=entityManager.find(Walker.class, w_id);
        return Optional.ofNullable(walker);
    }
}
