package com.damian.tutorialsql.logic;

import java.util.Date;

public class Rent {

    private int id;
    private Date date;
    private int customer_id;
    private int movie_id;
    private int rentDays;
    private double price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getRentDays() {
        return rentDays;
    }

    public void setRentDays(int rentDays) {
        this.rentDays = rentDays;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + ". "
                + date
                + "    Customer: " + customer_id
                + "    Movie: " + movie_id
                + "    Rent days: " + rentDays
                + "    Total Price:  " + price + " €.";
    }
}
