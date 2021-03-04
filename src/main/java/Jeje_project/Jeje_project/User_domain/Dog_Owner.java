package Jeje_project.Jeje_project.User_domain;

import Jeje_project.Jeje_project.Dog_domain.MyDog;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*This entity is for describe about User dog_owner */

@Entity
@Table(name="dog_owner")
public class Dog_Owner {

    @OneToOne(mappedBy = "dog_owner")
    User user;

    @Id
    @Column(name="do_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long DO_Id;

    @Column(name="address")
    String Address;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Long getDO_Id() {
        return DO_Id;
    }
    public void setDO_Id(Long DO_Id) {
        this.DO_Id = DO_Id;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public List<MyDog> getMyDog() {
        return myDog;
    }

    public void setMyDog(List<MyDog> myDog) {
        this.myDog = myDog;
    }

    @OneToMany
    @JoinColumn(name="dog_id")
    List<MyDog> myDog=new ArrayList<MyDog>();



}
