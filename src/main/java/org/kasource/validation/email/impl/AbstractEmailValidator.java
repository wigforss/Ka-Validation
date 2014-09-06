package org.kasource.validation.email.impl;

import org.apache.commons.validator.routines.EmailValidator;
import org.kasource.validation.AbstractValidator;
import org.kasource.validation.email.Email;


public class AbstractEmailValidator extends AbstractValidator {
    private EmailValidator validator;
    
    
    protected void initialize(Email annotation) {
        validator = EmailValidator.getInstance(annotation.allowLocalAddresses());      
    }

    @Override
    protected boolean isValid(Object value) {
       if (value == null) {
           return true;
       }
       return validator.isValid(value.toString());
    }

}
