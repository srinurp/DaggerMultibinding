package com.zoftino.daggermultibinding.business;

import javax.inject.Inject;

public class WestZoneTaxer implements Taxer{
    @Inject
    public WestZoneTaxer(){}
    public double calculateTax(double price){
        return 0.6*price;
    }
}
