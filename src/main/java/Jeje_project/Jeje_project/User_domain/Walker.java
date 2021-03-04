package Jeje_project.Jeje_project.User_domain;

import javax.persistence.*;

/*This entity is for describe about walker */

@Entity
@Table(name="walker")
public class Walker {

    @OneToOne(mappedBy = "walker")
    User user;

    @Id
    @Column(name="w_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long W_Id;

    @Column(name="address")
    String Address;

    public Long getW_Id() {
        return W_Id;
    }

    public void setW_Id(Long w_Id) {
        W_Id = w_Id;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
