package Jeje_project.Jeje_project.User_domain;

import javax.persistence.*;

/*This entity is for describe about User inforamation */

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="u_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long U_id;

    @Column(name="id", nullable = false)
    String Id;

    @Column(name="password", nullable = false)
    String Password;

    @Column(name="nickname", nullable = false)
    String Nickname;

    @OneToOne
    @JoinColumn(name="do_id")
    Dog_Owner dog_owner;

    @OneToOne
    @JoinColumn(name="w_id")
    Walker walker;

    public Long getU_id() {
        return U_id;
    }

    public void setU_id(Long u_id) {
        U_id = u_id;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public Dog_Owner getDog_owner() {
        return dog_owner;
    }

    public void setDog_owner(Dog_Owner dog_owner) {
        this.dog_owner = dog_owner;
    }

    public Walker getWalker() {
        return walker;
    }

    public void setWalker(Walker walker) {
        this.walker = walker;
    }
}
