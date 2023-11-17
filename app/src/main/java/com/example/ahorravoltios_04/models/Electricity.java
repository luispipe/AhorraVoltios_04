package com.example.ahorravoltios_04.models;

public class Electricity {
    private final String SERIAL,ID_USER;
    private int quantity,price;
    private String month;

    public Electricity(String SERIAL, int quantity, int price, String month, String idUser) {
        this.SERIAL = SERIAL;
        this.quantity = quantity;
        this.price = price;
        this.month = month;
        this.ID_USER = idUser;
    }

    public String getSERIAL() {
        return SERIAL;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getIdUser() {
        return ID_USER;
    }
    }
