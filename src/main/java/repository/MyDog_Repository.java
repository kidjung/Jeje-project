package repository;

import domain.Dog;
import domain.MyDog;

import java.util.List;
import java.util.Optional;

public interface MyDog_Repository {
    MyDog save(MyDog myDog);
    List<MyDog> findbyOwner(String Owner_id);
}
