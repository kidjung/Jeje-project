package Jeje_project.Jeje_project.controller;

import Jeje_project.Jeje_project.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import Jeje_project.Jeje_project.service.Dog_Service;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class Admin_Controller {

    private final Dog_Service dog_service;

    @Autowired
    public Admin_Controller(Dog_Service dog_service){
        this.dog_service=dog_service;
    }

    @GetMapping("/")
    public String admin_main_temp(Model model){
        return "admin_pages/admin_main";
    }
    //관리자 메인 페이지
    @GetMapping("/admin_page")
    public String admin_main(Model model){
        return "admin_pages/admin_main";
    }


    //견종 추가, 삭제, 수정 페이지
    @GetMapping("/admin_page/dog_list")
    public String dog_list(Model model){
        List<Dog> dogs=dog_service.all_Dogs();
        model.addAttribute("dogs", dogs);
        return "admin_pages/dog_list";
    }


    //견종 추가 Post
    @PostMapping("/add_dog")
    public String add_dog(Dog_Form dog_form, HttpServletResponse response) throws Exception{
        Dog dog=new Dog();

        //빈칸이 있는지 확인
        if(dog_form.getName().strip().length()==0 || dog_form.getInfo().strip().length()==0){
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('빈칸을 채워주세요'); location.href='/admin_page/dog_list';</script>");
            out.flush();
            return "redirect:/admin_pages/";
        }

        dog.setName(dog_form.getName());
        dog.setInfo(dog_form.getInfo());

        try {
            dog_service.add_Dog_species(dog);

            //등록 알림창
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('등록 되었습니다'); location.href='/admin_page/dog_list';</script>");
            out.flush();
        }
        catch (Exception exception){
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('등록 실패하였습니다'); location.href='/admin_page/dog_list';</script>");
            out.flush();
        }
        finally {
            return "redirect:/admin_pages/";
        }

    }

}
