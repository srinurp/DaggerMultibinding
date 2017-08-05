package com.zoftino.daggermultibinding.business;

import javax.inject.Inject;

public class PayPalPayment implements Payment{
    @Inject
    public PayPalPayment(){}
    public String payOrder(String orderId){
        return "Your order payment by pay bal is successful";
    }
}
