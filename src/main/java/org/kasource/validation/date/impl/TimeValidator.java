package org.kasource.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.date.TimeFormat;

public class TimeValidator extends AbstractDateTimeValidator implements ConstraintValidator<TimeFormat, String> {

   
    
    @Override
    public void initialize(TimeFormat annotation) {
        super.initialize(annotation.value());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      
        return isValid(value);
    }

}
