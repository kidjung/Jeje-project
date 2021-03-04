package Jeje_project.Jeje_project.User_repository;

import Jeje_project.Jeje_project.User_domain.Walker;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Walker_Repository {

    Walker save(Walker walker);
    Optional<Walker> findbyid(Long w_id);
}
