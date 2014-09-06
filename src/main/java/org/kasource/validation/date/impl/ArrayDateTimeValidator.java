package org.kasource.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.date.DateTimeFormat;

public class ArrayDateTimeValidator extends AbstractDateTimeValidator implements ConstraintValidator<DateTimeFormat, Object[]> {

   
    
    @Override
    public void initialize(DateTimeFormat annotation) {
        super.initialize(annotation.value(), annotation.rangeCheck(), annotation.offset(), annotation.before(), annotation.after(), annotation.timeUnit(), annotation.ignoreTimePart());
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        
        return isValidArray(value);
       
    }

}
