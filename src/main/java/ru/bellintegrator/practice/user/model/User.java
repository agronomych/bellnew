package ru.bellintegrator.practice.user.model;

import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.organization.model.Organization;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Integer id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    private Integer officeid;

    private String firstname;

    private String lastname;

    private String middlename;

    private String position;

    private Integer citizenshipid;

    private  Integer docid;

    private String phone;

    private String docnumber;

    @Temporal(TemporalType.DATE)
    private java.util.Date docdate;

    private Boolean isidentified;

    /*@ManyToOne
    @JoinColumn(name = "office")
    public Office office;*/

    /*@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Organization organization;*/

    public User(){

    }

    public Integer getOfficeId() {
        return officeid;
    }

    public void setOfficeId(Integer officeid) {
        this.officeid = officeid;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddleName() {
        return middlename;
    }

    public void setMiddleName(String middlename) {
        this.middlename = middlename;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getCitizenshipId() {
        return citizenshipid;
    }

    public void setCitizenshipId(Integer citizenshipid) {
        this.citizenshipid = citizenshipid;
    }

    public Integer getDocId() {
        return docid;
    }

    public void setDocId(Integer docid) {
        this.docid = docid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocNumber() {
        return docnumber;
    }

    public void setDocNumber(String docnumber) {
        this.docnumber = docnumber;
    }

    public Date getDocDate() {
        return docdate;
    }

    public void setDocDate(Date docdate) {
        this.docdate = docdate;
    }

    public Boolean getidentified() {
        return isidentified;
    }

    public void setidentified(Boolean identified) {
        isidentified = identified;
    }

    public Integer getId() {
        return id;
    }
}
