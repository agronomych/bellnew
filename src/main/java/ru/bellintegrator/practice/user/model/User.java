package ru.bellintegrator.practice.user.model;

import ru.bellintegrator.practice.countries.model.Country;
import ru.bellintegrator.practice.docs.model.Doc;
import ru.bellintegrator.practice.office.model.Office;

import javax.persistence.*;

@Entity
@Table(name = "user")
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

    @Column(name = "office_id")
    private Integer officeid;

    /**
     * имя пользователя
     */
    @Column(name = "first_name")
    private String firstname;

    /**
     * Фамилия пользователя
     */
    @Column(name = "last_name")
    private String lastname;

    /**
     * Отчество либо среднее имя
     */
    @Column(name = "middle_name")
    private String middlename;

    /**
     * Должность
     */
    private String position;

    /**
     * Указатель на гражданство
     */
    @Column(name = "citizenship_id")
    private Integer citizenshipid;

    /**
     * Указатель на тип документа
     */
    @Column(name = "doc_id")
    private  Integer docid;

    /**
     * Телефон пользователя
     */
    private String phone;

    /**
     * Номер документа
     */
    @Column(name = "doc_number")
    private String docnumber;

    /**
     * Дата выдачи документа
     */
    @Column(name = "doc_date")
    private String docdate;

    @Column(name = "is_identified")
    private Boolean isidentified;

    @ManyToOne
    @JoinColumn(name = "office_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Office office;

    @ManyToOne
    @JoinColumn(name = "doc_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Doc doc;

    @ManyToOne
    @JoinColumn(name = "citizenship_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Country country;

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

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
