package com.example.batch2.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Customer {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String designation;
    private String phone;
    private String code;
    private Date nameUpdatedAt;
    private Date designationUpdatedAt;


    public Customer(Integer id, String firstName, String lastName, String email, String designation, String phone, String code){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.designation = designation;
        this.code = code;
    }


    public Customer(){
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public Date getNameUpdatedAt() {
        return nameUpdatedAt;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNameUpdatedAt(Date nameUpdatedAt) {
        this.nameUpdatedAt = nameUpdatedAt;
    }

    public Date getDesignationUpdatedAt() {
        return designationUpdatedAt;
    }

    public void setDesignationUpdatedAt(Date designationUpdatedAt) {
        this.designationUpdatedAt = designationUpdatedAt;
    }

    @Override
    public String toString() {
        return String.format("Customer{id=%d, name='%s', name='%s', designation='%s', nameUpdated='%s', designationUpdated='%s'}",
                id, firstName, lastName, designation, nameUpdatedAt, designationUpdatedAt);
    }



}
