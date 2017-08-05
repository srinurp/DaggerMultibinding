package com.zoftino.daggermultibinding.business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DataProvider {
    @Inject
    public DataProvider(){}

    public List<String> getTaxZones(){
        List<String> taxZone = new ArrayList<String>();
        taxZone.add("east");
        taxZone.add("west");
        taxZone.add("central");
        return taxZone;
    }
    public List<String> getPaymentModes(){
        List<String> payment = new ArrayList<String>();
        payment.add("credit");
        payment.add("debit");
        payment.add("paypal");
        return payment;
    }

    public double getOrderPrice(){
        return 234.0;
    }

    public String getOrderId(){
        return "aksjfd767889";
    }
}
