package org.kasource.commons.validation.email.impl;

import org.apache.commons.validator.routines.EmailValidator;
import org.kasource.commons.validation.AbstractValidator;
import org.kasource.commons.validation.email.Email;


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
