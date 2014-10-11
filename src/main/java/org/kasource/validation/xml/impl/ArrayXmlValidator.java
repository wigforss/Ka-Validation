package org.kasource.validation.xml.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.xml.Xml;

public class ArrayXmlValidator extends AbstractXmlValidator implements ConstraintValidator<Xml, Object[]>{

    @Override
    public void initialize(Xml annotation) {
       super.initialize(annotation); 
    }
    
    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {       
        return isValidArray(value);
    }

}
