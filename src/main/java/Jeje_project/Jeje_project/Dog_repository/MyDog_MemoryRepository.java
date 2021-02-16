package Jeje_project.Jeje_project.Dog_repository;

import Jeje_project.Jeje_project.Dog_domain.MyDog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* According to use JPA for Mysql, this class replaced to MyDog_JPA_Repository */
/* If you want to know what function do, read this code*/


/*

public class MyDog_MemoryRepository implements MyDog_Repository{

    private static List<MyDog> store= new ArrayList<>();

    @Override
    public MyDog save(MyDog myDog) {
        store.add(myDog);
        return myDog;
    }

    @Override
    public List<MyDog> findbyOwner(String Owner_id) {
        return store.stream().filter(dog->dog.getOwner_id().equals(Owner_id)).collect(Collectors.toList());
    }
}

*/