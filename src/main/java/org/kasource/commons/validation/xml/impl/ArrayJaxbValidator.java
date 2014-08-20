package org.kasource.commons.validation.xml.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.xml.Jaxb;

public class ArrayJaxbValidator extends AbstractJaxbValidator  implements ConstraintValidator<Jaxb, Object[]>  {
    @Override
    public void initialize(Jaxb annotation) {
       super.initialize(annotation.value(), annotation.location()); 
    }
    
    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {       
        return isValidArray(value);
    }
}
