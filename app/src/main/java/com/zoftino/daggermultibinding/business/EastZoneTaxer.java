package com.zoftino.daggermultibinding.business;


import javax.inject.Inject;

public class EastZoneTaxer implements Taxer{
    @Inject
    public EastZoneTaxer(){

    }
    public double calculateTax(double price){
        return 0.4*price;
    }
}
