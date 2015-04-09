/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.cps.training.controller;

import bv.cps.training.service.CalculatePrice;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sasilva
 */
@Named
public class ProductPrice {
    
    private double price;
    
    @Inject
    private CalculatePrice calculatePrice;

    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getPrice(){
        return calculatePrice.calculatePrice(12, 21.30);
    }
    
}
