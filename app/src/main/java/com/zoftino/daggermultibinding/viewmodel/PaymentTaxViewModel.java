package com.zoftino.daggermultibinding.viewmodel;

import com.zoftino.daggermultibinding.business.Payment;
import com.zoftino.daggermultibinding.business.Taxer;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

public class PaymentTaxViewModel {

    @Inject
    Set<Payment> paymentModes;
    @Inject
    Map<String, Taxer> taxers;

    @Inject
    public PaymentTaxViewModel(){}


    public double calculateTax(double price, String taxZone){
        return taxers.get(taxZone).calculateTax(price);
    }

    public String payOrderAmount(String orderId, int paymentType){
       return (new ArrayList<Payment>(paymentModes)).get(paymentType).payOrder(orderId);
    }
}

