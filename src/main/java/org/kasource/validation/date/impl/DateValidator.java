package org.kasource.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.date.DateFormat;

public class DateValidator extends AbstractDateTimeValidator implements ConstraintValidator<DateFormat, String> {

   
    
    @Override
    public void initialize(DateFormat annotation) {
        super.initialize(annotation.value());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      
        return isValid(value);
    }

}
