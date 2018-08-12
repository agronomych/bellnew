package ru.bellintegrator.practice.user.model;

import ru.bellintegrator.practice.countries.model.Country;
import ru.bellintegrator.practice.docs.model.Doc;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.organization.model.Organization;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    private String docdate;

    private Boolean isidentified;

    @ManyToOne
    @JoinColumn(name = "officeid", referencedColumnName = "id", insertable = false, updatable = false)
    private Office office;

    /*@ManyToOne
    @JoinColumn(name = "organizationid", referencedColumnName = "id", insertable = false, updatable = false)
    private Organization organization;*/

    @ManyToOne
    @JoinColumn(name = "docid", referencedColumnName = "id", insertable = false, updatable = false)
    private Doc doc;

    /*@ManyToOne
    @JoinColumn(name = "countries")
    private Country country;*/

    public User(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOfficeid() {
        return officeid;
    }

    public void setOfficeid(Integer officeid) {
        this.officeid = officeid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getCitizenshipid() {
        return citizenshipid;
    }

    public void setCitizenshipid(Integer citizenshipid) {
        this.citizenshipid = citizenshipid;
    }

    public Integer getDocid() {
        return docid;
    }

    public void setDocid(Integer docid) {
        this.docid = docid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocnumber() {
        return docnumber;
    }

    public void setDocnumber(String docnumber) {
        this.docnumber = docnumber;
    }

    public String getDocdate() {
        return docdate;
    }

    public void setDocdate(String docdate) {
        this.docdate = docdate;
    }

    public Boolean getIsidentified() {
        return isidentified;
    }

    public void setIsidentified(Boolean isidentified) {
        this.isidentified = isidentified;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    /*public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }*/

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    /*public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }*/
}
