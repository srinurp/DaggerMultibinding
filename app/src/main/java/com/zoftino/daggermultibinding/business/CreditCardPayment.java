package com.zoftino.daggermultibinding.business;

import javax.inject.Inject;

public class CreditCardPayment implements Payment{
    @Inject
    public CreditCardPayment(){}
    public String payOrder(String orderId){
        return "Your order payment by credit card is successful";
    }
}
