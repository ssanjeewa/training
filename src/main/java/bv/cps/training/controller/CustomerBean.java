/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.cps.training.controller;

import bv.cps.training.models.Customer;
import bv.cps.training.repository.CustomerRepository;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author sasilva
 */
@ManagedBean
@ViewScoped
public class CustomerBean implements Serializable{

    /**
     * Creates a new instance of CustomerBean
     */
 
    @Inject
    private CustomerRepository cr;
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void printName(){
        System.out.println(name);
        Customer c = new Customer();
        c.setCusName(name);
        c.setDescription("Test");
        cr.save(c);
    }
    
}
