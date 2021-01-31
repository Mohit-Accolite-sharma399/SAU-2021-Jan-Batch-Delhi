package com.example.assignment.dao;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="currency")
public class Currency {
    @Id
    private int id;

    private String currency_id;
    private int amount;
    private String email;
    private String branchname;
    private String timestamp;
    private Boolean isfake=false;

    public Boolean getIsfake() {
        return isfake;
    }

    public void setIsfake(Boolean isfake) {
        this.isfake = isfake;
    }

    public Currency(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", currency_id=" + currency_id +
                ", amount=" + amount +
                ", email='" + email + '\'' +
                ", branchname='" + branchname + '\'' +
                ", timestamp=" + timestamp +
                ", isfake=" + isfake +
                '}';
    }
}
