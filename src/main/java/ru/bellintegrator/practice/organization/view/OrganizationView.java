package ru.bellintegrator.practice.organization.view;

public class OrganizationView extends OrganizationViewList {

    public Integer version;

    public String fullname;

    public String address;

    public String inn;

    public String kpp;

    public String phone;

    @Override
    public String toString(){
        return fullname+" "+address+" "+phone;
    }
}
