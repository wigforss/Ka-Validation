package org.kasource.commons.validation.xml.impl;

import java.net.URI;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.DataLocationType;
import org.kasource.commons.validation.xml.Xml;

public class UriXmlValidator extends AbstractXmlValidator implements ConstraintValidator<Xml, URI>{

    @Override
    public void initialize(Xml annotation) {
       super.initialize(annotation, DataLocationType.URL); 
    }
    
    @Override
    public boolean isValid(URI value, ConstraintValidatorContext context) {       
        return isValid(value);
    }

}
