package org.kasource.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.date.DateTimeFormat;

public class IterableDateTimeValidator extends AbstractDateTimeValidator implements ConstraintValidator<DateTimeFormat, Iterable<? extends Object>> {

   
    
    @Override
    public void initialize(DateTimeFormat annotation) {
        super.initialize(annotation.value());
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        
        return isValidItarable(value);
       
    }

}
