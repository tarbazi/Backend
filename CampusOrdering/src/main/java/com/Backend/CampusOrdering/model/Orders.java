package com.Backend.CampusOrdering.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity
public class Orders {
    @Id
    @GeneratedValue
    private int Id;
    private String StudentNum;
    private String ItemName;
    private int Quantity;

    public Orders(String studentNum, String itemName, int quantity){
        StudentNum = studentNum;
        ItemName = itemName;
        Quantity = quantity;        
    }

    public void setStudentNum(String studentNum){
        StudentNum = studentNum;    
    }

    public void setItemName(String itemName){
        ItemName = itemName;
    }

    public void setQuantity(int quantity){
        Quantity = quantity;
    }

    public String getStudentNum(){
        return StudentNum;
    }

    public String getItemName(){
        return ItemName;
    }

    public int getQuantity(){
        return Quantity;
    }

}
