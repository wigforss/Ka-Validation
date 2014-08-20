package org.kasource.commons.validation.xml.impl;

import java.net.URL;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.DataLocationType;
import org.kasource.commons.validation.xml.Xml;

public class UrlXmlValidator extends AbstractXmlValidator implements ConstraintValidator<Xml, URL>{

    @Override
    public void initialize(Xml annotation) {
       super.initialize(annotation, DataLocationType.URL); 
    }
    
    @Override
    public boolean isValid(URL value, ConstraintValidatorContext context) {       
        return isValid(value);
    }

}
