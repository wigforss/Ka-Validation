package org.kasource.commons.validation.email.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.email.Email;


public class EmailValidator extends AbstractEmailValidator implements ConstraintValidator<Email, String> {
  
    @Override
    public void initialize(Email annotation) {
        super.initialize(annotation);        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
       return isValid(value);
    }

}
