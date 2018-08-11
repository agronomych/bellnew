package ru.bellintegrator.practice.organization.model;

import javax.persistence.*;

@Entity
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    private String name;

    private String inn;

    private String fullname;

    private String kpp;

    private String address;

    private String phone;

    private Boolean isactive;

    /**
     * Конструктор для Hibernate
     */
    public Organization(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getFullName() {
        return fullname;
    }

    public void setFullName(String fullName) {
        this.fullname = fullName;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isactive;
    }

    public void setActive(Boolean active) {
        isactive = active;
    }

    public Integer getId() {
        return id;
    }
}
