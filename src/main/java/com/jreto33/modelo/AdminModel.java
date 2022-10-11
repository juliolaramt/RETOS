package com.jreto33.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="admin")
public class AdminModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name",length=250)
    private String name;

    @Column(name="email",length=45)
    private String email;
    @Column(name="password",length=45)
    private String password;

    public AdminModel() {
    }

    public AdminModel(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public AdminModel(Integer id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
