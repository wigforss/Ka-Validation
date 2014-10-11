package org.kasource.validation.xml.impl;

import java.io.ByteArrayInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.kasource.validation.AbstractValidator;

public abstract class AbstractJaxbValidator  extends AbstractValidator {

    
    private JAXBContext jaxbContext;
    
    
    protected void initialize(Class<?> targetClass) {
      
        try {
            jaxbContext = JAXBContext.newInstance(targetClass);
        } catch (JAXBException e) {
           throw new IllegalStateException("Could not create JAXBContext for " + targetClass, e);
        }
    }
    
    @Override
    protected boolean isValid(Object object) {
        if (object == null) {
            return true;
        }
       try {
              byte[] data = loadFromLocation(object.toString());
              Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
              unmarshaller.unmarshal(new ByteArrayInputStream(data));
              return true;
        } catch (Exception e) {
           return false;
        } 
        
    }
    
}
