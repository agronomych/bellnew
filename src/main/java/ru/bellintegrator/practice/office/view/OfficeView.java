package ru.bellintegrator.practice.office.view;

public class OfficeView {

    public Integer id;

    public Integer version;

    public String name;

    public String phone;

    public String address;

    public Boolean isActive;

    public Integer orgId;

    @Override
    public String toString(){
        return name+" "+address+" "+phone;
    }
}
