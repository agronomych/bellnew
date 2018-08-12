package ru.bellintegrator.practice.docs.model;

import ru.bellintegrator.practice.user.model.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "docs")
public class Doc {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    @Column(name = "code", nullable = false)
    private Integer code;

    /**
     * Название страны
     */
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "doc")
    private Set<User> users;

    public Doc() {
    }

    public Doc(String name, Integer code) {
        this.code = code;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        if (users == null){
            users = new HashSet<User>();
        }
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
