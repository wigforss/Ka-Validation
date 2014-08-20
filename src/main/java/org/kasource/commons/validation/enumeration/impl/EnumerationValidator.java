package org.kasource.commons.validation.enumeration.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.enumeration.Enumeration;


public class EnumerationValidator extends AbstractEnumerationValidator implements ConstraintValidator<Enumeration, String> {

    @Override
    public void initialize(final Enumeration enumeration) {
       super.initialize(enumeration);
     
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {      
        
        boolean isValid = super.isValid(value);
       
        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate( "must be any of " + message).addConstraintViolation();
        }
        return isValid;
       
    }

}
