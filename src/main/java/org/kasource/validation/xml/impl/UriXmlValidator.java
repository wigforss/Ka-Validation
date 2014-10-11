package org.kasource.validation.xml.impl;

import java.net.URI;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.xml.Xml;

public class UriXmlValidator extends AbstractXmlValidator implements ConstraintValidator<Xml, URI>{

    @Override
    public void initialize(Xml annotation) {
       super.initialize(annotation); 
    }
    
    @Override
    public boolean isValid(URI value, ConstraintValidatorContext context) {       
        return isValid(value);
    }

}
