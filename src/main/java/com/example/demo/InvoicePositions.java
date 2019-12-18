package com.example.demo;

public class InvoicePositions
{
    private String product;
    private double price;
    private int amount;

    public void setProduct(String product){
        this.product = product;
    }
    public String getProduct(){
        return this.product;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    public Double getPrice(){
        return this.price;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }
    public int getAmount(){
        return this.amount;
    }
    
    @Override
    public String toString() {
    	return product + " " + amount + " x " + price +" = "+ amount*price;
    }
    
    public double getNetto() {
    	return price * amount; 
    }
}