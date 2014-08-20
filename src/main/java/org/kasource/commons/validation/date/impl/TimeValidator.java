package org.kasource.commons.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.date.Time;

public class TimeValidator extends AbstractDateTimeValidator implements ConstraintValidator<Time, String> {

   
    
    @Override
    public void initialize(Time annotation) {
        super.initialize(annotation.value());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      
        return isValid(value);
    }

}
