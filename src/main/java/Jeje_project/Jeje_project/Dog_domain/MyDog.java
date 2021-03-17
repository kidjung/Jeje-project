package Jeje_project.Jeje_project.Dog_domain;

import javax.persistence.*;

/*This entity is for Dog that has a Owner */
@Entity
@Table(name="mydog")
public class MyDog {

    @Id @Column(name="dog_id")@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Dog_id;        //강아지 ID
    @Column(name="age")
    private int age;            //나이
    @Column(name="name")
    private String name;        //이름
    @Column(name="sex")
    private String sex;         //성별
    @ManyToOne
    @JoinColumn(name="breed_name")
    private Breed breed;  //견종
    @Column(name="describes")
    private String describe;    //추가 설명 및 소개

    public Long getDog_id() {
        return Dog_id;
    }
    public void setDog_id(Long dog_id) {
        Dog_id = dog_id;
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
    public Breed getBreed() {
        return breed;
    }
    public void setBreed(Breed breed) {
        this.breed = breed;
    }
    public String getDescribe() {
        return describe;
    }
    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
