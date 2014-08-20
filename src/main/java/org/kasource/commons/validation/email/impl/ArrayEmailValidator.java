package org.kasource.commons.validation.email.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.email.Email;

public class ArrayEmailValidator extends AbstractEmailValidator implements ConstraintValidator<Email, Object[]> {
   
    @Override
    public void initialize(Email annotation) {
        super.initialize(annotation);        
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
       return isValidArray(value);
    }

}
