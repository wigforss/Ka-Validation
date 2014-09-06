package org.kasource.validation.isbn.impl;

import org.apache.commons.validator.routines.ISBNValidator;
import org.kasource.validation.AbstractValidator;

public class AbstractIsbnValidator extends AbstractValidator {

    private ISBNValidator validator = new ISBNValidator(false);
    
    
    @Override
    public boolean isValid(Object value) {
        if (value == null) {
            return true;
        }
        return validator.isValid(value.toString());
        
    }

}
