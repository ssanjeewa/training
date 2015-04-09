/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.cps.training.util.jsf;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

/**
 *
 * @author sasilva
 */
public class JsfExceptionHandler extends ExceptionHandlerWrapper{

    private ExceptionHandler wrapped;

    public JsfExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }
        
    @Override
    public ExceptionHandler getWrapped() {
        return this.wrapped;
    }

    @Override
    public void handle() throws FacesException {
        Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();
        
        while (events.hasNext()) {
            ExceptionQueuedEvent event = events.next();
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext)event.getSource();
            
            Throwable exception = context.getException();
            
            try {
                if (exception instanceof ViewExpiredException) {
                    redirect("/");
                }
            } finally {
                events.remove();
            }
        }
        
        getWrapped().handle();
    }

    private void redirect(String page) {
        try {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        String contextPath = externalContext.getRequestContextPath();
        
        
            externalContext.redirect(contextPath + page);
            facesContext.responseComplete();
        } catch (IOException ex) {
            throw new FacesException(ex);
        }
        
    }
    
    
}
