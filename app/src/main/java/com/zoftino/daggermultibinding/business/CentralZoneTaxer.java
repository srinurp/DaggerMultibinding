package com.zoftino.daggermultibinding.business;


import javax.inject.Inject;

public class CentralZoneTaxer implements Taxer{
    @Inject
    public CentralZoneTaxer(){}
    public double calculateTax(double price){
        return 0.25*price;
    }
}
