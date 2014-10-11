package org.kasource.validation.xml.impl;

import java.net.URL;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.xml.Xml;

public class UrlXmlValidator extends AbstractXmlValidator implements ConstraintValidator<Xml, URL>{

    @Override
    public void initialize(Xml annotation) {
       super.initialize(annotation); 
    }
    
    @Override
    public boolean isValid(URL value, ConstraintValidatorContext context) {       
        return isValid(value);
    }

}
