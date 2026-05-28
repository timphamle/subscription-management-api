package com.timle.subscriptionapi.model;

public class Subscription{
    private int id;
    private String merchantName;
    private double amount;
    private String frequency;
    private User user;
    private PaymentMethod paymentMethod;

    public Subscription(int id, String merchantName, double amount, String frequency, User user, PaymentMethod paymentMethod){
        this.id = id;
        this.merchantName = merchantName;
        this.amount = amount;
        this.frequency = frequency;
        this.user = user;
        this.paymentMethod = paymentMethod;
    }

    public Subscription(){
        // default constructor
    }

    // getters
    public int getId(){
        return id;
    }

    public String getMerchantName(){
        return merchantName;
    }

    public double getAmount(){
        return amount;
    }

    public String getFrequency(){
        return frequency;
    }

    public User getUser(){
        return user;
    }

    public PaymentMethod getPaymentMethod(){
        return paymentMethod;
    }

    // setters
    public void setId(int id){
        this.id = id;
    }

    public void setMerchantName(String merchantName){
        this.merchantName = merchantName;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public void setFrequency(String frequency){
        this.frequency = frequency;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }

}