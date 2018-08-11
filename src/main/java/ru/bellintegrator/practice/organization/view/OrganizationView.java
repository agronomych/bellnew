package ru.bellintegrator.practice.organization.view;

public class OrganizationView {

    public Integer id;

    public Integer version;

    public String name;

    public String fullName;

    public String address;

    public String inn;

    public String kpp;

    public String phone;

    public Boolean isActive;

    @Override
    public String toString(){
        return fullName+" "+address+" "+phone;
    }
}
