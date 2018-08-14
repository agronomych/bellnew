package ru.bellintegrator.practice.user.view;

public class UserView extends UserViewList{

    public Integer version;

    public Integer officeid;

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
