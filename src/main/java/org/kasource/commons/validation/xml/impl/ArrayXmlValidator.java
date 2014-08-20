package org.kasource.commons.validation.xml.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.xml.Xml;

public class ArrayXmlValidator extends AbstractXmlValidator implements ConstraintValidator<Xml, Object[]>{

    @Override
    public void initialize(Xml annotation) {
       super.initialize(annotation, annotation.value()); 
    }
    
    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {       
        return isValidArray(value);
    }

}
