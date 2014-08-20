package org.kasource.commons.validation.xml.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.xml.Xml;

public class XmlValidator extends AbstractXmlValidator implements ConstraintValidator<Xml, String> {

    @Override
    public void initialize(Xml annotation) {
       super.initialize(annotation, annotation.value()); 
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {       
        return isValid(value);
    }

}
