package com.myApplication.client.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


public class ContractDao implements Serializable {
    private static int nextId = 0;
    private final int id = nextId++;
    private String contractId;
    private Date date;
    private String name;
    private Double premium;
    private Date dateValidUntil;

    public ContractDao(String contractId, Date date, String name, Double premium, Date dateValidUntil) {
        this.contractId = contractId;
        this.date = date;
        this.name = name;
        this.premium = premium;
        this.dateValidUntil = dateValidUntil;
    }

    public ContractDao() {
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public void setDateValidUntil(Date dateValidUntil) {
        this.dateValidUntil = dateValidUntil;
    }


    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public Double getPremium() {
        return premium;
    }

    public Date getDateValidUntil() {
        return dateValidUntil;
    }

    public String getContractId() {
        return contractId;
    }

    public static void setNextId(int nextId) {
        ContractDao.nextId = nextId;
    }

    public static int getNextId() {

        return nextId;
    }

    public int getId() {
        return id;
    }
}
