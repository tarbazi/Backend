package com.Backend.CampusOrdering.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Credential {

    @Id
    @GeneratedValue
    private int id;
    private String studentnum;
    private String password;

    public Credential(){
        
    }

    public Credential(String studentnum, String password){
        this.studentnum = studentnum;
        this.password = password;
    }

    public void setStudentNum(String studentnum){
        this.studentnum = studentnum;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getStudentNum(){
        return studentnum;
    }

    public String getPassword(){
        return password;
    }

}
