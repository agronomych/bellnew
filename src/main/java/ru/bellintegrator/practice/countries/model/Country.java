package ru.bellintegrator.practice.countries.model;

import javax.persistence.*;

@Entity
@Table (name = "countries")
public class Country {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Код страны
     */
    private Integer code;

    /**
     * Название страны
     */
    @Column(nullable = false)
    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return getCode()+" "+getName();
    }
}
