package Jeje_project.Jeje_project.controller;

import Jeje_project.Jeje_project.User_domain.User;
import Jeje_project.Jeje_project.User_domain.User_DTO;
import Jeje_project.Jeje_project.service.User_Service;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


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
        return "user_pages/login";
    }

    @GetMapping("/signup")
    public String signup_page(HttpSession httpSession){
        return "user_pages/sign_up";
    }
/*
    @PostMapping("/login")
    public String login(HttpSession httpSession, User user){
        if(user_service.login(user)){
            httpSession.setAttribute("loginCheck",true);
            httpSession.setAttribute("email",user.getEmail());
            return "redirect:/";
        }
        else{
            return "fail_page";
        }
    }
*/
    @PostMapping("/signup")
    public String signup(User_DTO user, HttpServletResponse response) throws IOException {

        if(!user.getPassword().equals(user.getPassword_check())){
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('비밀번호가 다릅니다');</script>");
            out.flush();
            return "user_pages/sign_up";
        }else if(user_service.findbyEmail(user.getEmail()).isPresent()){
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('이미 존재하는 아이디 입니다.');</script>");
            out.flush();
            return "user_pages/sign_up";
        }else if(user_service.findbyNickname(user.getNickname()).isPresent()){
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('이미 존재하는 닉네임 입니다.');</script>");
            out.flush();
            return "user_pages/sign_up";
        }

        user_service.Signup(user);
        return "redirect:/";
    }

    //로그아웃
    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
}

