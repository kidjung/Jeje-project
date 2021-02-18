package Jeje_project.Jeje_project.Dog_domain;

import javax.persistence.*;

/*This entity is for Dog that has a Owner */
@Entity
@Table(name="mydog")
public class MyDog {

    @Id @Column(name="dog_id")@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Dog_id;        //강아지 ID
    @Column(name="owner_id")
    private Long Owner_id;      //주인 ID
    @Column(name="age")
    private int age;            //나이
    @Column(name="name")
    private String name;        //이름
    @Column(name="sex")
    private String sex;         //성별
    @Column(name="breed_name")
    private String breed_name;  //견종
    @Column(name="describes")
    private String describe;    //추가 설명 및 소개

    public Long getDog_id() {
        return Dog_id;
    }

    public void setDog_id(Long dog_id) {
        Dog_id = dog_id;
    }

    public Long getOwner_id() {
        return Owner_id;
    }

    public void setOwner_id(Long owner_id) {
        Owner_id = owner_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBreed() {
        return breed_name;
    }

    public void setBreed(String breed_name) {
        this.breed_name = breed_name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
