package domain;

public class MyDog {
    private String Owner_id;
    private int age;        //나이
    private String name;    //이름
    private String sex;     //성별
    private Dog breed;      //견종
    private String describe;    //추가 설명


    public String getOwner_id() {
        return Owner_id;
    }

    public void setOwner_id(String owner_id) {
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

    public Dog getBreed() {
        return breed;
    }

    public void setBreed(Dog breed) {
        this.breed = breed;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
