package ru.bellintegrator.practice.office.model;

import io.swagger.models.auth.In;
import ru.bellintegrator.practice.user.model.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "offices")
public class Office {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Integer id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    private Integer orgid;

    private String name;

    private String phone;

    private Boolean isactive;

    private String address;

    /*@OneToMany(mappedBy = "office")
    public List<User> users;*/

    public Integer getOrgId() {
        return orgid;
    }

    public void setOrgId(Integer orgId) {
        this.orgid = orgId;
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
        this.isactive = active;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
