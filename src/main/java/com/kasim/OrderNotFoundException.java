package com.kasim;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException (String message){
        super(message);
    }

}
