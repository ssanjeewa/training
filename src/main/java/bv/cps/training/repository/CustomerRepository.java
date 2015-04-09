/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.cps.training.repository;

import bv.cps.training.models.Customer;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author sasilva
 */
public class CustomerRepository implements Serializable{
    
    @Inject
    private EntityManager manager;
    
    public void save(Customer customer){
        EntityTransaction trx = manager.getTransaction();
        trx.begin();
        manager.persist(customer);
        trx.commit();
    }
    
    
}
