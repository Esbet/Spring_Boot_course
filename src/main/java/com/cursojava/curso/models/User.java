package com.cursojava.curso.models;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "users")
@ToString @EqualsAndHashCode
public class User {

    @Getter
    @Setter
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    @Setter
    @Column(name = "name")
    private String name;
    @Getter
    @Setter
    @Column(name = "lastname")
    private String lastname;
    @Getter
    @Setter
    @Column(name = "email")
    private String email;
    @Getter
    @Setter
    @Column(name = "phone")
    private String phone;
    @Getter
    @Setter
    @Column(name = "password")
    private String password;

}
