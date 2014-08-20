package org.kasource.commons.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.date.Date;

public class DateValidator extends AbstractDateTimeValidator implements ConstraintValidator<Date, String> {

   
    
    @Override
    public void initialize(Date annotation) {
        super.initialize(annotation.value());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      
        return isValid(value);
    }

}
