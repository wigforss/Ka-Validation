package org.kasource.validation.xml.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.xml.Xml;

public class IterableXmlValidator extends AbstractXmlValidator implements ConstraintValidator<Xml, Iterable<? extends Object>>{

    @Override
    public void initialize(Xml annotation) {
       super.initialize(annotation, annotation.value()); 
    }
    
    @Override
    public boolean isValid( Iterable<? extends Object> value, ConstraintValidatorContext context) {       
        return isValidItarable(value);
    }

}
