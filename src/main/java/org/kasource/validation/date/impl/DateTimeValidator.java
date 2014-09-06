package org.kasource.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.date.DateTimeFormat;

public class DateTimeValidator extends AbstractDateTimeValidator implements ConstraintValidator<DateTimeFormat, String> {

   
    
    @Override
    public void initialize(DateTimeFormat annotation) {
        super.initialize(annotation.value(), annotation.rangeCheck(), annotation.offset(), annotation.before(), annotation.after(), annotation.timeUnit(), annotation.ignoreTimePart());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      
        return super.isValid(value);
    }

}
