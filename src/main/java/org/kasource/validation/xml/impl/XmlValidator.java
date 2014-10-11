package org.kasource.validation.xml.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.xml.Xml;

public class XmlValidator extends AbstractXmlValidator implements ConstraintValidator<Xml, String> {

    @Override
    public void initialize(Xml annotation) {
       super.initialize(annotation); 
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {       
        return isValid(value);
    }

}
