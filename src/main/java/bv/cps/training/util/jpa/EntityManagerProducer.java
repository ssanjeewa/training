/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.cps.training.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sasilva
 */
@ApplicationScoped
public class EntityManagerProducer {
    
    private EntityManagerFactory factory;

    public EntityManagerProducer() {
        factory = Persistence.createEntityManagerFactory("ccmsystemPU");
    }
    
    @Produces @RequestScoped
    public EntityManager createEntityManager(){
        return factory.createEntityManager();
    }
    
    public void closeEntityManager(@Disposes EntityManager manager){
        manager.close();
    }
    
}
