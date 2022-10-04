package com.javatodev.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled = true;

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @OneToMany(cascade = CascadeType.ALL)
    List<UserAuthority> authorities = new ArrayList<>();

    public void addAuthorities(String authority) {
        this.authorities.add(new UserAuthority(null, this, authority));
    }
}
