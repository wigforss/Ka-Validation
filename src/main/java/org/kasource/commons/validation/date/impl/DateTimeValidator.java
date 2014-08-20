package org.kasource.commons.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.date.DateTime;

public class DateTimeValidator extends AbstractDateTimeValidator implements ConstraintValidator<DateTime, String> {

   
    
    @Override
    public void initialize(DateTime annotation) {
        super.initialize(annotation.value());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      
        return super.isValid(value);
    }

}
