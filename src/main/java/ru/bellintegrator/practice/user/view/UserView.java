package ru.bellintegrator.practice.user.view;

public class UserView {

    public Integer id;

    public Integer version;

    public Integer officeId;

    public String firstName;

    public String lastName;

    public String middleName;

    public String position;

    public Integer docId;

    public Integer citizenshipId;

    public String phone;

    public String docNumber;
    
    public java.util.Date docDate;

    public Boolean isIdentified;

    @Override
    public String toString(){
        return "name"+" lastName"+" middleName,"+" docName,"+" docNumber,"+" docDate";
    }
}
