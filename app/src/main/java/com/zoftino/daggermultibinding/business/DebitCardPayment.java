package com.zoftino.daggermultibinding.business;


import javax.inject.Inject;

public class DebitCardPayment implements Payment{
    @Inject
    public DebitCardPayment(){}
    public String payOrder(String orderId){
        return "Your order payment by debit card is successful";
    }
}
