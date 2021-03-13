package Jeje_project.Jeje_project.controller;

import Jeje_project.Jeje_project.User_domain.User;
import Jeje_project.Jeje_project.service.User_Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

class Signup_form{
    private String Id;
    private String Password;
    private String Password_check;
    private String Nickname;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword_check() {
        return Password_check;
    }

    public void setPassword_check(String password_check) {
        Password_check = password_check;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }
}


@Controller
public class User_Controller {

    private final User_Service user_service;

    public User_Controller(User_Service user_service) {
        this.user_service = user_service;
    }

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/login")
    public String login_page(HttpSession httpSession){
        if(httpSession.getAttribute("loginCheck")==null){
            return "user_pages/login";
        }
        else{
            return "fail_page";
        }
    }

    @GetMapping("/signup")
    public String signup_page(HttpSession httpSession){
        if(httpSession.getAttribute("loginCheck")==null){
            return "user_pages/sign_up";
        }
        else{
            return "fail_page";
        }
    }

    @PostMapping("/login")
    public String login(HttpSession httpSession, User user){
        if(user_service.login(user)){
            httpSession.setAttribute("loginCheck",true);
            httpSession.setAttribute("id",user.getId());
            return "redirect:/";
        }
        else{
            return "fail_page";
        }
    }

    @PostMapping("/signup")
    public String signup(HttpSession httpSession, @RequestParam Signup_form signup_form){
        if(signup_form.getPassword()!=signup_form.getPassword_check()){
            return "fail_page";
        }
        User to_signup=new User();
        System.out.println(signup_form.getId());
        to_signup.setId(signup_form.getId());
        System.out.println(signup_form.getPassword());
        to_signup.setPassword(signup_form.getPassword());
        System.out.println(signup_form.getNickname());
        to_signup.setNickname(signup_form.getNickname());
        user_service.Signup(to_signup);
        return "redirect:/";
    }

}
