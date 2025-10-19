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
    private String student_num;
    private String item_name;
    private int quantity;

    public Order(String student_num, String item_name, int quantity){
        this.student_num = student_num;
        this.item_name = item_name;
        this.quantity = quantity;
    }

    public void setStudentNum(String student_num){
        this.student_num = student_num;    
    }

    public void setItemName(String item_name){
        this.item_name = item_name;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String getStudentNum(){
        return student_num;
    }

    public String getItemName(){
        return item_name;
    }

    public int getQuantity(){
        return quantity;
    }

}
