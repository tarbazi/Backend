package com.Backend.CampusOrdering.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name = "`Order`")
public class Order {

    @Id
    @GeneratedValue
    private int id;
    private String studentnum;
    private String itemname;
    private int quantity;
    private int ordernum;

    public Order(){
        
    }

    public Order(String studentnum, String itemname, int quantity, int ordernum){
        this.studentnum = studentnum;
        this.itemname = itemname;
        this.quantity = quantity;
        this.ordernum = ordernum;
    }

    public void setStudentNum(String studentnum){
        this.studentnum = studentnum;    
    }

    public void setItemName(String itemname){
        this.itemname = itemname;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setOrderNum(int ordernum){
        this.ordernum = ordernum;
    }

    public String getStudentNum(){
        return studentnum;
    }

    public String getItemName(){
        return itemname;
    }

    public int getQuantity(){
        return quantity;
    }

    public int getOrderNum(){
        return ordernum;
    }

}
