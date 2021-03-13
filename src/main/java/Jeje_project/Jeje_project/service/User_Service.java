package Jeje_project.Jeje_project.service;

import Jeje_project.Jeje_project.Dog_domain.MyDog;
import Jeje_project.Jeje_project.User_domain.Dog_Owner;
import Jeje_project.Jeje_project.User_domain.User;
import Jeje_project.Jeje_project.User_repository.Dog_Owner_Repository;
import Jeje_project.Jeje_project.User_repository.User_Repository;
import Jeje_project.Jeje_project.User_repository.Walker_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class User_Service {

    private User_Repository user_repository;
    private Walker_Repository walker_repository;
    private Dog_Owner_Repository dog_owner_repository;

    @Autowired
    public User_Service(User_Repository user_repository, Walker_Repository walker_repository, Dog_Owner_Repository dog_owner_repository){
        this.user_repository=user_repository;
        this.walker_repository=walker_repository;
        this.dog_owner_repository=dog_owner_repository;
    }

    //회원가입
    public User Signup(User user){
        user_repository.save(user);
        return user;
    }

    //본인 강아지 저장
    //** not implemented
    public MyDog add_dog(User user, MyDog dog){
        return new MyDog();
    }

    //로그인
    public boolean login(User user){
        Optional<User> to_login=user_repository.findbyId(user.getId());
        if(!to_login.isEmpty()){
            if(to_login.get().getPassword()==user.getPassword()){
                return true;
            }
            else {
                return true;
            }
        }
        else{
            return false;
        }
    }
}
