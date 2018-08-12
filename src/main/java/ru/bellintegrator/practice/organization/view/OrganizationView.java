package ru.bellintegrator.practice.organization.view;

public class OrganizationView {

    public Integer id;

    public Integer version;

    public String name;

    public String fullname;

    public String address;

    public String inn;

    public String kpp;

    public String phone;

    public Boolean isactive;

    @Override
    public String toString(){
        return fullname+" "+address+" "+phone;
    }
}
