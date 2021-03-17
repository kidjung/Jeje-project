package Jeje_project.Jeje_project.service;

import Jeje_project.Jeje_project.Dog_domain.MyDog;
import Jeje_project.Jeje_project.Dog_repository.MyDog_Repository;
import Jeje_project.Jeje_project.User_domain.Dog_Owner;
import Jeje_project.Jeje_project.User_domain.User;
import Jeje_project.Jeje_project.User_domain.User_DTO;
import Jeje_project.Jeje_project.User_repository.Dog_Owner_Repository;
import Jeje_project.Jeje_project.User_repository.User_Repository;
import Jeje_project.Jeje_project.User_repository.Walker_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class User_Service implements UserDetailsService {

    private final User_Repository user_repository;
    private Walker_Repository walker_repository;
    private Dog_Owner_Repository dog_owner_repository;
    private MyDog_Repository myDog_repository;

    @Autowired
    public User_Service(User_Repository user_repository, Walker_Repository walker_repository
                        ,Dog_Owner_Repository dog_owner_repository, MyDog_Repository myDog_repository){
        this.user_repository=user_repository;
        this.walker_repository=walker_repository;
        this.dog_owner_repository=dog_owner_repository;
        this.myDog_repository=myDog_repository;
    }

    //회원가입
    public User Signup(User_DTO user){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        return user_repository.save(User.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .nickname(user.getNickname())
                .auth(user.getAuth()).build());
    }

    //본인 강아지 저장
    public MyDog add_dog(User user, MyDog dog){
        myDog_repository.save(dog);
        return dog;
    }

    //로그인
    public boolean login(User user){
        Optional<User> to_login=user_repository.findbyEmail(user.getEmail());
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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return user_repository.findbyEmail(email)
                .orElseThrow(()->new UsernameNotFoundException(email));
    }

    public Optional<User> findbyEmail(String email){
        return user_repository.findbyEmail(email);
    }

    public Optional<User> findbyNickname(String nickname){
        return user_repository.findbyNickname(nickname);
    }
}
