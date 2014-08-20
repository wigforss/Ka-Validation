package org.kasource.commons.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.date.DateTime;

public class ArrayDateTimeValidator extends AbstractDateTimeValidator implements ConstraintValidator<DateTime, Object[]> {

   
    
    @Override
    public void initialize(DateTime annotation) {
        super.initialize(annotation.value());
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        
        return isValidArray(value);
       
    }

}
