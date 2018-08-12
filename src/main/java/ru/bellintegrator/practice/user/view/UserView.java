package ru.bellintegrator.practice.user.view;

public class UserView {

    public Integer id;

    public Integer version;

    public Integer officeid;

    public String firstname;

    public String lastname;

    public String middlename;

    public String position;

    public Integer docid;

    public Integer citizenshipid;

    public String phone;

    public String docnumber;
    
    public String docdate;

    public Boolean isidentified;

    @Override
    public String toString(){
        return firstname+" "+lastname+" "+middlename+" "+docid+" "+docnumber+" "+docdate;
    }
}
