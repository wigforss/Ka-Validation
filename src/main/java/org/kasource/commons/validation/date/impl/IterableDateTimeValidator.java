package org.kasource.commons.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.date.DateTime;

public class IterableDateTimeValidator extends AbstractDateTimeValidator implements ConstraintValidator<DateTime, Iterable<? extends Object>> {

   
    
    @Override
    public void initialize(DateTime annotation) {
        super.initialize(annotation.value());
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        
        return isValidItarable(value);
       
    }

}
