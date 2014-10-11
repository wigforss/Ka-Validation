package org.kasource.validation.xml.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.xml.Jaxb;

public class IterableJaxbValidator extends AbstractJaxbValidator  implements ConstraintValidator<Jaxb, Iterable<? extends Object>>  {
    @Override
    public void initialize(Jaxb annotation) {
       super.initialize(annotation.value()); 
    }
    
    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {       
        return isValidItarable(value);
    }
}
