package org.kasource.commons.validation.checkdigit.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.checkdigit.Checkdigit;

public class ArrayCheckdigitValidator extends AbstractCheckdigitValidator implements ConstraintValidator<Checkdigit, Object[]> {
    @Override
    public void initialize(Checkdigit annotation) {
        super.initialize(annotation);
        
    }
    
    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
       return isValidArray(value);
    }

}
