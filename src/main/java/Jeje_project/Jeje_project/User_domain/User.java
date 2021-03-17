package Jeje_project.Jeje_project.User_domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/*This entity is for describe about User inforamation */


@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Entity
@Table(name="user")
public class User implements UserDetails {
    @Id
    @Column(name="uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long U_id;

    @Column(name="email", nullable = false)
    private String Email;

    @Column(name="password", nullable = false)
    private String Password;

    @Column(name="nickname", nullable = false)
    private String Nickname;

    @Column(name="auth")
    private String Auth;

    @OneToOne
    @JoinColumn(name="do_id")
    private Dog_Owner dog_owner;

    @OneToOne
    @JoinColumn(name="w_id")
    private Walker walker;


    @Builder
    public User(String email, String password, String nickname, String auth){
        this.Email=email;
        this.Password=password;
        this.Nickname=nickname;
        this.Auth=auth;
    }
    public Long getU_id() {
        return U_id;
    }

    public void setU_id(Long u_id) {
        U_id = u_id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (String role : Auth.split(",")) {
            roles.add(new SimpleGrantedAuthority(role));
        }
        return roles;
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

    @Override
    public String getUsername() {
        return Email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
