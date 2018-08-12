package ru.bellintegrator.practice.office.view;

public class OfficeView {

    public Integer id;

    public Integer version;

    public String name;

    public String phone;

    public String address;

    public Boolean isactive;

    public Integer orgid;

    @Override
    public String toString(){
        return "id: "+id+"\n"+"name: "+name+"\n"+"address: "+address+"\n"+"phone: "+phone+"\n"+"isactive: "+isactive+"\n"+"orgid: "+orgid;
    }
}
