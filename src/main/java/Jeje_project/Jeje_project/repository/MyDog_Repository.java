package Jeje_project.Jeje_project.repository;

import Jeje_project.Jeje_project.domain.MyDog;

import java.util.List;

public interface MyDog_Repository {
    MyDog save(MyDog myDog);
    List<MyDog> findbyOwner(String Owner_id);
}
