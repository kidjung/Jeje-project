package Jeje_project.Jeje_project.Dog_domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*This entity is for describe about certain Breed of dog */
@Entity
@Table(name="breed")
public class Breed {

    @Id @Column(name="name")
    private String name;    //견종 명
    @Column(name="size")
    private String size;    //견종 사이즈
    @Column(name="information")
    private String info;    //정보

    public String getName() {
        return name;
}
    public String getSize() {
        return size;
    }
    public String getInfo() { return  info; }

    public void setName(String name) {
        this.name = name;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public void setInfo(String info) { this.info = info; }

}
