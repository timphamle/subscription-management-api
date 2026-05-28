package com.timle.subscriptionapi.model;

public class PaymentMethod{
    private int id;
    private String cardHolder;
    private String lastFourDigits;
    private String cardType;

    public PaymentMethod(int id, String cardHolder, String lastFourDigits, String cardType){
        this.id = id;
        this.cardHolder = cardHolder;
        this.lastFourDigits = lastFourDigits;
        this.cardType = cardType;
    }

    public PaymentMethod(){
        // default constructor
    }

    // getters
    public int getId(){
        return id;
    }

    public String getCardHolder(){
        return cardHolder;
    }

    public String lastFourDigits(){
        return lastFourDigits;
    }

    public String cardType(){
        return cardType;
    }

    // setters
    public void setId(int id){
        this.id = id; 
    }

    public void setCardHolder(String cardHolder){
        this.cardHolder = cardHolder; 
    }

    public void setLastFourDigits(String lastFourDigits){
        this.lastFourDigits = lastFourDigits; 
    }

    public void setCardType(String cardType){
        this.cardType = cardType;
    }
}