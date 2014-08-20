package org.kasource.commons.validation.email.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.email.Email;

public class IterableEmailValidator extends AbstractEmailValidator implements ConstraintValidator<Email, Iterable<? extends Object>> {
   
    @Override
    public void initialize(Email annotation) {
        super.initialize(annotation);      
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
       return isValidItarable(value);
    }

}
