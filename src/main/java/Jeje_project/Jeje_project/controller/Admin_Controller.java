package Jeje_project.Jeje_project.controller;

import Jeje_project.Jeje_project.Dog_domain.Breed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import Jeje_project.Jeje_project.service.Dog_Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class Admin_Controller {

    private final Dog_Service dog_service;

    @Autowired
    public Admin_Controller(Dog_Service dog_service){
        this.dog_service=dog_service;
    }


    //관리자 메인 페이지
    @GetMapping("/admin_page")
    public String admin_main(Model model){
        return "redirect:/main";
    }


    //견종 추가, 삭제, 수정 페이지
    @GetMapping("/admin_page/dog_list")
    public String dog_list( Model model) {
        List<Breed> breeds = dog_service.all_Dogs();
        model.addAttribute("breeds", breeds);
        return "admin_pages/dog_list";
    }


    //견종 추가 Post
    @PostMapping("/add_breed")
    public void add_Breed(Breed dog_form, HttpServletResponse response) throws Exception{
        Breed breed =new Breed();

        //빈칸이 있는지 확인
        if(dog_form.getName().strip().length()==0 || dog_form.getInfo().strip().length()==0){
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('빈칸을 채워주세요');</script>");
            out.flush();
        }

        breed.setName(dog_form.getName());
        breed.setSize(dog_form.getSize());
        breed.setInfo(dog_form.getInfo());

        try {
            dog_service.add_Breed(breed);

            //등록 알림창
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('등록 되었습니다'); </script>");
            out.flush();
        }
        catch (Exception exception){
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('등록 실패하였습니다');</script>");
            out.flush();
        }
        finally {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>location.href='/admin_page/dog_list';</script>");
            out.flush();
        }
    }

    //견종 삭제 Delete
    @DeleteMapping("/delete_breed/{breed_name}")
    public ResponseEntity<Breed> delete_breed(@PathVariable String breed_name, HttpServletResponse response) throws IOException {
        return ResponseEntity.ok().body(dog_service.delete_Breed(breed_name));
    }

    //견종 검색 Post
    @PostMapping(value="/search_breed")
    public String search_dog(Breed dog_form, Model model) throws Exception{
        List<Breed> breeds = dog_service.search_Breeds(dog_form.getName());
        model.addAttribute("breeds", breeds);
        return "admin_pages/dog_list";
    }
}
