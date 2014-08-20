package org.kasource.commons.validation.checkdigit.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.checkdigit.Checkdigit;

public class IterableCheckdigitValidator extends AbstractCheckdigitValidator implements ConstraintValidator<Checkdigit, Iterable<? extends Object>> {
    @Override
    public void initialize(Checkdigit annotation) {
        super.initialize(annotation);
        
    }
    
    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
       return isValidItarable(value);
    }

}
