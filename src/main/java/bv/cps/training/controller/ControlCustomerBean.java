/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.cps.training.controller;

import bv.cps.training.models.Customer;
import bv.cps.training.repository.CustomerRepository;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 *
 * @author sasilva
 */
@Named
@ViewScoped
public class ControlCustomerBean implements Serializable{
    
   
    @Inject
    private EntityManager manager;
    @Inject
    CustomerRepository cr;
    
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public void saveCustomer(){
        System.out.println("### " +customerName);
        Customer cm = new Customer();
        cm.setCusName(customerName);
        cm.setDescription("Test Desc");
        List<Customer> c =(List<Customer>)  manager.createQuery("from Customer",Customer.class).getResultList();
        for (Customer c1 : c) {
            System.out.println("###### "+ c1.getCusName());
        }
        cr.save(cm);
        //test
    }
    
}
